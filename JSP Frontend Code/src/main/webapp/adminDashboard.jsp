<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 2rem; background-color: #f9f9f9; }
        h2, h3 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 1rem; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color: #ddd; }
    </style>
</head>
<body>
    <h2>Admin Dashboard</h2>
    <h3>Product List</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Base Price</th>
                <th>Current Price</th>
                <th>Stock Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td><c:out value="${product.productId}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.basePrice}" /></td>
                    <td><b><c:out value="${product.currentPrice}" /></b></td>
                    <td><c:out value="${product.stockQuantity}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
