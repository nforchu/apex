<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
   <form action = "/product" method = "POST">
         <h3>${title}</h3>
         
         <br />
         <input type="hidden" 
	      	name="id"
	      	required
	      	class="form-control" 
	      	value="${product.getId()}" 
	      	id="ProductId">
	      	
      	<div class="mb-3">
      		<label  class="form-label">Categories</label>
      		<div class="row">
      			<c:forEach items="${categories}" var="category">
      				<div class="col-2"> 
      					<input type="checkbox" 
	      					name="categories" 
	      					value="${category.id}" 
	      					id="categories${category.getId() }">
	      				<label for="categories${category.id }">${category.getTitle() }</label>
      				</div>
      			</c:forEach>
      		</div>
      	</div>
	      	
		  <div class="mb-3">
		    <label for="productTitle" class="form-label">Product Title</label>
		    <input type="text" 
		    	name="title"
		    	required
		    	class="form-control" 
		    	id="productTitle"
		    	value="${product.getTitle()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="price" class="form-label">Price (&euro;)</label>
		    <input type="number" min="0.00" max="100000.00" step="0.01"
		    	name="price"
		    	required
		    	class="form-control" 
		    	id="price"
		    	value="${product.getPrice()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="stockQuantity" class="form-label">Stock quantity</label>
		    <input type="number" min="0"
		    	name="stockQuantity"
		    	required
		    	class="form-control" 
		    	id="stockQuantity"
		    	value="${product.getStockQuantity()}">	   
		  </div>
		  
		  <div class="mb-3">
		    <label for="discountPercent" class="form-label">Discount %</label>
		    <input type="number" max="100" min="0"
		    	name="discountPercent"
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
		  <input name="save" type="submit" value="Save" class="btn btn-secondary"/>
		  <input type="submit" value="Save and add another" class="btn btn-secondary"/>
		  <a class="btn btn-warning" href="/product/list">Cancel</a>
    </form>
</div>