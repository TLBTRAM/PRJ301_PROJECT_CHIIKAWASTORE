package controller;

import dao.ProductDAO;
import dao.UserDAO;
import dto.CartItem;
import dto.ProductDTO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;
import utils.DBUtils;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private ProductDAO pdao = new ProductDAO();
    private UserDAO udao = new UserDAO();

    private static final String WELCOME = "UIlogin.jsp";
    private static final String REGISTER = "register.jsp";

    private String processRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;

        try {
            boolean checkError = false;

            String userID = request.getParameter("txtUserID");
            String fullName = request.getParameter("txtFullName");
            String password = request.getParameter("txtPassword");

            if (password.length() < 6) {
                checkError = true;
                request.setAttribute("error_Password", "Password must be at least 6 characters long !");
            }

            UserDTO udto = new UserDTO(userID, fullName, "US", password);

            UserDTO existingUser = udao.readById(userID);
            if (existingUser != null) {
                request.setAttribute("error_Register", "User ID already exists !");
                url = REGISTER;
            }
            if (!checkError) {
                udao.create(udto);
                url = WELCOME;
            } else {
                url = REGISTER;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    private String processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        //
        String strUserID = request.getParameter("txtUserID");
        String strPassword = request.getParameter("txtPassword");
        if (AuthUtils.isValidLogin(strUserID, strPassword)) {
            url = "dashBoard.jsp";
            UserDTO user = AuthUtils.getUser(strUserID);
            request.getSession().setAttribute("user", user);
            // search
            processSearch(request, response);
        } else {
            request.setAttribute("message", "Incorrect UserID or Password");
            url = "login.jsp";
        }
        //
        return url;
    }

    private String processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        //
        HttpSession session = request.getSession();
        if (AuthUtils.isLoggedIn(session)) {
            request.getSession().invalidate(); // Hủy bỏ session
            url = WELCOME;
        }
        //
        return url;
    }

    public String processSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "dashBoard.jsp";

        String searchTerm = request.getParameter("searchTerm");
        if (searchTerm == null) {
            searchTerm = "";
        }

        int pageT = 1;
        int pageSize = 8;

        try {
            if (request.getParameter("pageT") != null) {
                pageT = Integer.parseInt(request.getParameter("pageT"));
            }
        } catch (NumberFormatException e) {
            pageT = 1;
        }

        try {
            List<ProductDTO> products = pdao.searchByTitleWithPagination(searchTerm, pageT, pageSize);
            int totalProducts = pdao.getTotalSearchResults(searchTerm);
            int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

            request.setAttribute("products", products);
            request.setAttribute("searchTerm", searchTerm);
            request.setAttribute("currentPage", pageT);
            request.setAttribute("totalPages", totalPages);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return url;
    }

    public String processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        HttpSession session = request.getSession();
        if (AuthUtils.isAdmin(session)) {
            String id = request.getParameter("idDelete");
            pdao.updateQuantityToZero(id);
            // search
            processSearch(request, response);
            url = "dashBoard.jsp";
        }
        return url;
    }

    public String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        HttpSession session = request.getSession();
        if (AuthUtils.isAdmin(session)) {
            try {
                boolean checkError = false;

                String productID = request.getParameter("txtProductID");
                String title = request.getParameter("txtTitle");
                String brand = request.getParameter("txtBrand");
                String category = request.getParameter("txtCategory");
                double price = Double.parseDouble(request.getParameter("txtPrice"));
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                String image = request.getParameter("txtImage");

                if (productID == null || productID.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtProductID_error", "Product ID cannot be empty !");
                }
                if (title == null || title.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtTitle_error", "Title cannot be empty !");
                }
                if (brand == null || brand.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtBrand_error", "Brand cannot be empty !");
                }
                if (category == null || category.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtCategory_error", "Please select a category !");
                }
                if (price < 0) {
                    checkError = true;
                    request.setAttribute("txtPrice_error", "Price must be greater than or equal to 0 !");
                }
                if (quantity < 0) {
                    checkError = true;
                    request.setAttribute("txtQuantity_error", "Quantity must be greater than or equal to 0 !");
                }

                ProductDTO product = new ProductDTO(productID, title, brand, category, price, quantity, image);

                if (!checkError) {
                    pdao.create(product);
                    // search
                    url = processSearch(request, response);
                } else {
                    url = "productForm.jsp";
                    request.setAttribute("product", product);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    private String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        //
        // Cần quyền ADMIN để edit
        HttpSession session = request.getSession();
        if (AuthUtils.isAdmin(session)) {
            String id = request.getParameter("idEdit"); // Lấy ProductID (ở dB.jsp) để edit
            ProductDTO pEdit = pdao.readById(id); // Lấy product
            if (pEdit != null) {
                request.setAttribute("product", pEdit);
                request.setAttribute("action", "update");
                url = "productForm.jsp";
            }
            // search
            processSearch(request, response);
        }
        //
        return url;
    }

    private String processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        //
        HttpSession session = request.getSession();
        if (AuthUtils.isAdmin(session)) {
            try {
                boolean checkError = false;

                String productID = request.getParameter("txtProductID");
                String title = request.getParameter("txtTitle");
                String brand = request.getParameter("txtBrand");
                String category = request.getParameter("txtCategory");
                double price = Double.parseDouble(request.getParameter("txtPrice"));
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                String image = request.getParameter("txtImage");

                if (productID == null || productID.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtProductID_error", "Product ID cannot be empty !");
                }
                if (title == null || title.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtTitle_error", "Title cannot be empty !");
                }
                if (brand == null || brand.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtBrand_error", "Brand cannot be empty !");
                }
                if (category == null || category.trim().isEmpty()) {
                    checkError = true;
                    request.setAttribute("txtCategory_error", "Please select a category !");
                }
                if (price < 0) {
                    checkError = true;
                    request.setAttribute("txtPrice_error", "Price must be greater than or equal to 0 !");
                }
                if (quantity < 0) {
                    checkError = true;
                    request.setAttribute("txtQuantity_error", "Quantity must be greater than or equal to 0 !");
                }

                ProductDTO product = new ProductDTO(productID, title, brand, category, price, quantity, image);

                if (!checkError) {
                    pdao.update(product);    // giống processAdd chỉ khác dòng này
                    // search
                    url = processSearch(request, response);
                } else {
                    url = "productForm.jsp";
                    request.setAttribute("product", product);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //
        return url;
    }

    // Phương thức xử lý xem chi tiết sách
    private String processViewDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "detail.jsp";

        try {
            String productID = request.getParameter("id");
            if (productID != null && !productID.isEmpty()) {
                ProductDTO product = pdao.readById(productID);
                if (product != null) {
                    request.setAttribute("productDetail", product);
                } else {
                    request.setAttribute("message", "Product not found.");
                    request.setAttribute("messageType", "error");
                }
            } else {
                request.setAttribute("message", "Invalid product ID.");
                request.setAttribute("messageType", "error");
            }
        } catch (Exception e) {
            request.setAttribute("message", "Error loading product details: " + e.getMessage());
            request.setAttribute("messageType", "error");
            System.out.println("Error in processViewDetail: " + e.toString());
        }
        return url;
    }

    private String addToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "detail.jsp";

        HttpSession session = request.getSession();
        String productID = request.getParameter("productID");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Lấy giỏ hàng từ session (hoặc tạo mới nếu chưa có)
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        boolean found = false;
        for (CartItem item : cart) {
            if (item.getProductID().equals(productID)) {  // So sánh bằng equals
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        // Nếu chưa có trong giỏ hàng, thêm sản phẩm mới
        if (!found) {
            ProductDTO product = pdao.readById(productID);
            if (product != null) {
                cart.add(new CartItem(productID, product.getTitle(), product.getPrice(), quantity));
            }
        }

        session.setAttribute("cart", cart);
        url = "cart.jsp";
        return url;
    }

    private String buyNow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "detail.jsp";

        HttpSession session = request.getSession();
        String productID = request.getParameter("productID"); // Lấy productId kiểu String
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductDTO product = pdao.readById(productID);
        if (product != null) {
            List<CartItem> checkoutItems = new ArrayList<>();
            checkoutItems.add(new CartItem(productID, product.getTitle(), product.getPrice(), quantity));
            session.setAttribute("checkoutItems", checkoutItems);
            url = "checkout.jsp"; // Chuyển hướng đến trang thanh toán
        } else {
            response.sendRedirect("product.jsp?error=ProductNotFound");
        }
        return url;
    }

    private String checkOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String url = "checkout.jsp";
        HttpSession session = request.getSession();

        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        // Kiểm tra thông tin nhập vào
        if (name == null || name.trim().isEmpty()
                || address == null || address.trim().isEmpty()
                || phone == null || phone.trim().isEmpty()) {
            request.setAttribute("message", "⚠️ Vui lòng điền đầy đủ thông tin!");
            return url;
        }

        // Lấy giỏ hàng từ session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            request.setAttribute("message", "🚫 Giỏ hàng trống! Không thể đặt hàng.");
            return url;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement checkStmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);

            // Câu lệnh SQL trừ số lượng sản phẩm
            String updateStockQuery = "UPDATE tblProducts SET Quantity = Quantity - ? WHERE ProductID = ?";
            stmt = conn.prepareStatement(updateStockQuery);

            for (CartItem item : cart) {
                System.out.println("Updating ProductID: " + item.getProductID() + " - Quantity: " + item.getQuantity());

                // Kiểm tra số lượng trước khi trừ
                String checkStockQuery = "SELECT Quantity FROM tblProducts WHERE ProductID = ?";
                checkStmt = conn.prepareStatement(checkStockQuery);
                checkStmt.setString(1, item.getProductID());
                rs = checkStmt.executeQuery();

                if (rs.next()) {
                    int availableQuantity = rs.getInt("Quantity");
                    if (availableQuantity < item.getQuantity()) {
                        request.setAttribute("message", "⚠️ Sản phẩm " + item.getProductID() + " không đủ hàng!");
                        return url;
                    }
                } else {
                    request.setAttribute("message", "⚠️ Sản phẩm " + item.getProductID() + " không tồn tại!");
                    return url;
                }

                // Đóng ResultSet và Statement sau khi kiểm tra
                rs.close();
                checkStmt.close();

                // Tiếp tục cập nhật nếu hợp lệ
                stmt.setInt(1, item.getQuantity());
                stmt.setString(2, item.getProductID());
                int affectedRows = stmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("⚠️ Không thể cập nhật sản phẩm ID: " + item.getProductID());
                }
            }

            conn.commit(); // Lưu thay đổi vào DB
            session.removeAttribute("cart"); // Xóa giỏ hàng

            //Đặt hàng thành công → Chuyển hướng đến orderSuccess.jsp
            url = "orderSuccess.jsp";
            
        } catch (SQLException e) {
            System.out.println("Lỗi SQL: " + e.getMessage()); // In lỗi SQL
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback nếu có lỗi
                    System.out.println("Rollback thành công!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            request.setAttribute("message", "⚠️ Lỗi khi đặt hàng! " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (checkStmt != null) {
                    checkStmt.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return url;
    }

    // Main
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            System.out.println("action: " + action);
            if (action == null) {
                url = WELCOME;
            } else {
                if (action.equals("register")) {
                    url = processRegister(request, response);
                } else if (action.equals("login")) {
                    url = processLogin(request, response);
                } else if (action.equals("logout")) {
                    url = processLogout(request, response);
                } else if (action.equals("search")) {
                    url = processSearch(request, response);
                } else if (action.equals("delete")) {
                    url = processDelete(request, response);
                } else if (action.equals("add")) {
                    url = processAdd(request, response);
                } else if (action.equals("edit")) {
                    url = processEdit(request, response);
                    // Sau khi edit thêm thông tin thì update
                } else if (action.equals("update")) {
                    url = processUpdate(request, response);
                } else if (action.equals("viewDetail")) {
                    url = processViewDetail(request, response);
                } else if (action.equals("addToCart")) {
                    url = addToCart(request, response);
                } else if (action.equals("buyNow")) {
                    url = buyNow(request, response);
                } else if (action.equals("checkout")) {
                    url = checkOut(request, response);
                }

            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
