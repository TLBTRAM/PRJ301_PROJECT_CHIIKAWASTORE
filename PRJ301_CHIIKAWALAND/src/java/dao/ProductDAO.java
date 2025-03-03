/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProductDAO implements IDAO<ProductDTO, String> {

    @Override
    public boolean create(ProductDTO entity) {
        String sql = "INSERT INTO tblProducts"
                + "(ProductID, Title, Brand, Price, Quantity)"
                + "VALUES (?, ?, ?, ?, ?) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getProductID());
            ps.setString(2, entity.getTitle());
            ps.setString(3, entity.getBrand());
            ps.setDouble(4, entity.getPrice());
            ps.setInt(5, entity.getQuantity());
            int i = ps.executeUpdate();
            return i > 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    @Override
    public List<ProductDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductDTO readById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProductDTO entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ProductDTO> searchByTitle(String searchTerm) {
        String sql = "SELECT * FROM tblProducts WHERE title LIKE ?";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO(
                        rs.getString("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Brand"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
    
     public List<ProductDTO> searchByTitle2(String searchTerm) {
        String sql = "SELECT * FROM tblBooks WHERE title LIKE ? AND Quantity>0";
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+searchTerm+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProductDTO p = new ProductDTO(
                        rs.getString("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Brand"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
    
    public boolean updateQuantityToZero(String id) {
        String sql = "UPDATE tblBooks SET Quantity=0 WHERE BookID=?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int i = ps.executeUpdate();
            return i>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}
