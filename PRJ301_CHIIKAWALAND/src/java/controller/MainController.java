package controller;


import dao.ProductDAO;
import dto.ProductDTO;
import dto.UserDTO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.AuthUtils;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private ProductDAO pdao = new ProductDAO();

    private static final String WELCOME = "UIlogin.jsp";

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
            if(pEdit != null){
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
                
//(String productID, String title, String brand, String category, double price, int quantity, String image)
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
                if (action.equals("login")) {
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