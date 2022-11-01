<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="mb-4">	
	<a class="btn btn-sm btn-warning" href="<c:out value="/product/form/${product.id}"/>">Edit</a>	 
		<a class="btn btn-sm btn-secondary" href="/product/form">Deactivate</a>  
		<a class="btn btn-sm btn-secondary disabled" href="/product/form">Activate</a> 
		<a class="btn btn-sm btn-secondary" href="/product/form">Delete</a>
		<a class="btn btn-sm btn-primary" href="/product/form">Add a Product</a>               
	</div>  
       
    <div class="row pb-4">
    	<div class="col-3"><span class="fw-bold">Product title</span></div>    	
    	<div class="col-9">${product.getTitle()}</div>
    </div>
    <div class="row pb-4">
    	<div class="col-sm-3"><span class="fw-bold">Price</span></div>    	
    	<div class="col-sm-9">&euro;${product.getPrice()}</div>
    </div>
    
    <div class="row pb-4">
    	<div class="col-sm-3"><span class="fw-bold">Discount %</span></div>    	
    	<div class="col-sm-9">${product.getDiscountPercent()} %</div>
    </div>
    
    <div class="row pb-4">
    	<div class="col-sm-3"><span class="fw-bold">Stock quantity %</span></div>    	
    	<div class="col-sm-9">${product.getStockQuantity()}</div>
    </div>
    
     <div class="row pb-4">
    	<div class="col-sm-3"><span class="fw-bold">Categories</span></div>    	
    	<div class="col-sm-9">    		
    		<c:forEach items="${product.getCategories()}" var="category">
            	<span class="badge text-bg-info">${category.getTitle()}</span>
        	</c:forEach>
    	</div>
    </div>

    
    <div class="row pb-4">
    	<div class="col-sm-3"><span class="fw-bold">Description</span></div>    	
    	<div class="col-sm-9">${product.getDescription()}</div>
    </div>
</div>