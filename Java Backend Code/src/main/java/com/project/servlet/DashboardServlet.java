package com.project.servlet;

import com.project.dao.ProductDAO;
import com.project.model.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminDashboard")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Product> productList = productDAO.getAllProducts();
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error while fetching products.", e);
        }
    }
}
