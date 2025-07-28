package com.project.dao;

import com.project.model.Product;
import com.project.util.DbUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products ORDER BY product_id";
        try (Connection conn = DbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setBasePrice(rs.getDouble("base_price"));
                product.setCurrentPrice(rs.getDouble("current_price"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                products.add(product);
            }
        }
        return products;
    }
}
