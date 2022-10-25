<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="mb-4">	
		<a class="btn btn-sm btn-warning" href="<c:out value="/category/form/${category.id}"/>">Edit</a>
       	<a class="btn btn-sm btn-dark" href="<c:out value="/category/${category.id}/products"/>">View products</a>	 
		<a class="btn btn-sm btn-secondary" href="/category/form">Deactivate</a>  
		<a class="btn btn-sm btn-secondary disabled" href="/category/form">Activate</a> 
		<a class="btn btn-sm btn-secondary" href="/category/form">Delete</a>
		<a class="btn btn-sm btn-primary" href="/category/form">Add a Category</a>               
	</div>  
       
    <div class="row pb-4">
    	<div class="col-3"><span class="fw-bold">Category title</span></div>    	
    	<div class="col-9">${category.getTitle()}</div>
    </div>
    
    <div class="row">
    	<div class="col-sm-3"><span class="fw-bold">Description</span></div>    	
    	<div class="col-sm-9">${category.getDescription()}</div>
    </div>
</div>