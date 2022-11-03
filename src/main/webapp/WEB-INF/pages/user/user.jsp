<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="mb-4">	
		<a class="btn btn-sm btn-warning" href="<c:out value="/user/form/${user.id}"/>">Edit</a>	 
		<a class="btn btn-sm btn-danger" href="/user/${user.getId()}/delete">Delete</a>	
		<a class="btn btn-sm btn-primary" href="/user/form">Add a user</a>               
	</div> 
	
	<div class="row">
		<div class="col-12">
			<div class="row pb-4">
		    	<div class="col-3"><span class="fw-bold">Full name</span></div>    	
		    	<div class="col-9">${user.getName()}</div>
		    </div>
		    
		    <div class="row pb-4">
		    	<div class="col-sm-3"><span class="fw-bold">Email</span></div>    	
		    	<div class="col-sm-9">${user.getEmail()}</div>
		    </div>
		    
		    <div class="row pb-4">
		    	<div class="col-sm-3"><span class="fw-bold">Account status</span></div>    	
		    	<div class="col-sm-9">${user.getStatus()}</div>
		    </div>
		    
		    <div class="row pb-4">
		    	<div class="col-sm-3"><span class="fw-bold">Created</span></div>    	
		    	<div class="col-sm-9">${user.getCreated()}</div>
		    </div>
		    
		    <div class="row pb-4">
		    	<div class="col-sm-3"><span class="fw-bold">Last update</span></div>    	
		    	<div class="col-sm-9">${user.getUpdated()}</div>
		    </div>
		</div>
		
	</div> 
</div>