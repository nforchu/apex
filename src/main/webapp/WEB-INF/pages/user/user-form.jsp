<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="container">
    <h3>${title}</h3>    
    <form action = "/user" method = "POST">
      <input type="hidden" 
      	name="id"
      	required
      	class="form-control" 
      	value="${user.getId()}" 
      	id="userId">
      	
	  <div class="mb-3">
	    <label for="userName" class="form-label">Full name</label>
	    <input type="text" 
	    	name="name"
	    	required
	    	class="form-control" 
	    	id="userName"
	    	value="${user.getName()}">	   
	  </div>
	  
	  <div class="mb-3">
	    <label for="userEmail" class="form-label">Email</label>
	    <input type="text" 
	    	name="email"
	    	class="form-control" 
    		id="userEmail" 
    		value="${user.getEmail()}"/>
	  </div>
	  
	  <div class="mb-3">
	    <label for="userPassword" class="form-label">Password</label>
	    <input type="password" 
	    	name="password"
	    	class="form-control" 
    		id="userPassword" 
    		value="${user.getPassword()}"/>
	  </div>	 
	   
	  <input type="submit" value="Save" class="btn btn-secondary"/>
	  <a class="btn btn-warning" href="/category/list">Cancel</a>
	</form>
</div>