<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="row">
    <div>
      notes
    <div>


    <form action = "/products/form" method = "POST">
         <h3>Add category</h3>
         Email: <input type = "email" name = "email" size="70">
         <br />
         Description: <textarea rows="5" cols="70" name = "description"> </textarea>
         <input type = "submit" value = "Submit" />

         <div>Forgot password</div>
    </form>
</div>