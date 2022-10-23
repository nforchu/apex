<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="container">
    <h3>${title}</h3>    
    <form action = "/category" method = "POST">
      <input type="hidden" 
      	name="id"
      	required
      	class="form-control" 
      	value="${category.getId()}" 
      	id="categoryId">
      	
	  <div class="mb-3">
	    <label for="categoryTitle" class="form-label">Category Title</label>
	    <input type="text" 
	    	name="title"
	    	required
	    	class="form-control" 
	    	id="categoryTitle"
	    	value="${category.getTitle()}">	   
	  </div>
	  
	  <div class="mb-3">
	    <label for="categoryDescription" class="form-label">Description</label>
	    <textarea 
	    	name="description"
	    	class="form-control" 
    		id="categoryDescription">${category.getDescription()}</textarea>
	  </div>	  
	  <input type="submit" value="Save" class="btn btn-secondary"/>
	  <input type="submit" value="Save and add another" class="btn btn-secondary"/>
	  <a class="btn btn-warning" href="/category/list">Cancel</a>
	</form>
</div>