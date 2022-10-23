<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
   <form action = "/products/form" method = "POST">
         <h3>${title}</h3>
         Category:
         <select>
            <option>Select one</option> 
            <option>Men</option>
            <option>Women</option> 
            <option>Boys</option> 
         </select>
         <br />
         <input type="text" 
	      	name="id"
	      	required
	      	class="form-control" 
	      	value="${product.getId()}" 
	      	id="ProductId">
	      	
		  <div class="mb-3">
		    <label for="productTitle" class="form-label">Category Title</label>
		    <input type="text" 
		    	name="title"
		    	required
		    	class="form-control" 
		    	id="productTitle"
		    	value="${product.getTitle()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="stockQuantity" class="form-label">Price (&euro;)</label>
		    <input type="number" min="0.00" max="100000.00" step="0.01"
		    	name="title"
		    	required
		    	class="form-control" 
		    	id="stockQuantity"
		    	value="${product.getPrice()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="stockQuantity" class="form-label">Stock quantity</label>
		    <input type="number" min="0"
		    	name="title"
		    	required
		    	class="form-control" 
		    	id="stockQuantity"
		    	value="${product.getStockQuantity()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="discountPercent" class="form-label">Discount %</label>
		    <input type="number" max="100" min="0"
		    	name="title"
		    	required
		    	class="form-control" 
		    	id="discountPercent"
		    	value="${product.getDiscountPercent()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="productDescription" class="form-label">Description</label>
		    <textarea 
		    	name="description"
		    	class="form-control" 
	    		id="productDescription">${product.getDescription()}</textarea>
		  </div>	  
		  <input type="submit" value="Save" class="btn btn-secondary"/>
		  <input type="submit" value="Save and add another" class="btn btn-secondary"/>
		  <a class="btn btn-warning" href="/product/list">Cancel</a>
    </form>
</div>