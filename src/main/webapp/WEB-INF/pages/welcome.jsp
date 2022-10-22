<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="row">
    <div>
      notes
    <div>


    <form action = "main.jsp" method = "GET">
         <h3>Login as admin</h3>
         Email: <input type = "email" name = "email">
         <br />
         Password: <input type = "password" name = "password" />
         <input type = "submit" value = "Submit" />

         <div>Forgot password</div>
    </form>
</div>