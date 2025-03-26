package dao;

import dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class ProductDAO implements IDAO<ProductDTO, String> {

    @Override
    public boolean create(ProductDTO entity) {
        String sql = "INSERT INTO tblProducts"
                + "(ProductID, Title, Brand, Category, Price, Quantity, Image)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getProductID());
            ps.setString(2, entity.getTitle());
            ps.setString(3, entity.getBrand());
            ps.setString(4, entity.getCategory());
            ps.setDouble(5, entity.getPrice());
            ps.setInt(6, entity.getQuantity());
            ps.setString(7, entity.getImage());
            
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ProductDTO> readAll() {
        return null;
    }

    @Override
    public ProductDTO readById(String id) {
        String sql = "SELECT * FROM tblProducts WHERE ProductID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProductDTO p = new ProductDTO(
                        rs.getString("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Brand"),
                        rs.getString("Category"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity"),
                        rs.getString("Image"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(ProductDTO entity) {
        String sql = "UPDATE tblProducts SET "
                + " Title = ?, Brand = ?, Category = ?, Price =? , Quantity = ?, Image = ? "
                + " WHERE ProductID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, entity.getTitle());
                ps.setString(2, entity.getBrand());
                ps.setString(3, entity.getCategory());
                ps.setDouble(4, entity.getPrice());
                ps.setInt(5, entity.getQuantity());
                ps.setString(6, entity.getImage());
                ps.setString(7, entity.getProductID());
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<ProductDTO> search(String searchTerm) {
        return null;
    }


     public List<ProductDTO> searchByTitle(String searchTerm) {
        String sql = "SELECT * FROM tblProducts WHERE Title LIKE ? AND Quantity > 0 ";
        List<ProductDTO> list = new ArrayList<>();
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO p = new ProductDTO(
                        rs.getString("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Brand"),
                        rs.getString("Category"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity"),
                        rs.getString("Image"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateQuantityToZero(String id) {
        String sql = "UPDATE tblProducts SET Quantity = 0 WHERE ProductID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);
            int i = ps.executeUpdate();
            return i>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public List<ProductDTO> searchByTitleWithPagination(String searchTerm, int pageT, int pageSize) throws Exception {
        if (pageT < 1) pageT = 1;
        if (pageSize <= 0) pageSize = 8; // Giá trị mặc định

        String sql = "SELECT * FROM tblProducts WHERE Quantity > 0 AND Title LIKE ? ORDER BY ProductID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;";

        List<ProductDTO> list = new ArrayList<>();
        int startIndex = (pageT - 1) * pageSize;

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchTerm + "%");
            ps.setInt(2, startIndex);
            ps.setInt(3, pageSize);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductDTO(
                    rs.getString("ProductID"),
                    rs.getString("Title"),
                    rs.getString("Brand"),
                    rs.getString("Category"),
                    rs.getDouble("Price"),
                    rs.getInt("Quantity"),
                    rs.getString("Image")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalSearchResults(String searchTerm) throws Exception {
        String sql = "SELECT COUNT(*) FROM tblProducts WHERE Title LIKE ?";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchTerm + "%");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    
}
