<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="color: red">product list</div>
<table style="color: blue">
    <thead>
        <tr>
            <th>ISBN</th>
            <th>Name</th>
            <th>Author</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.title}</td>
                <td>${product.id}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>