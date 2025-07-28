package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // This is a simple check. A real application would use a UserDAO to check the database.
        if ("admin".equals(username) && "admin123".equals(password)) {
            // If login is successful, redirect to the dashboard servlet
            response.sendRedirect("adminDashboard");
        } else {
            // If login fails, redirect back to the login page
            response.sendRedirect("login.jsp");
        }
    }
}
