<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	       
    <div class="row pb-4">
    	<div class="col-3"><span class="fw-bold">Please confirm delete</span></div>    	
    	<div class="col-9">The user "${user.getName()}" will be permanently deleted</div>
    </div>
  
    
    <div class="mb-4">			 
		<form action="/user/${user.getId()}/delete" method="POST">
			<input type="submit" value="Yes, Delete" class="btn btn-sm btn-danger" />
			<a class="btn btn-sm btn-primary" href="/user/${user.getId()}">Cancel</a>
		</form>               
	</div>  
</div>