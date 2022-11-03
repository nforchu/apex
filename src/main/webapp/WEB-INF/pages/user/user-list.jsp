<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div>
		<h3>
			<span>All Users </span>  
			<a class="btn btn-sm btn-primary" href="/user/form">Add a User</a> 
		</h3>                   
    </div>  
    <table class="table table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
     	<c:forEach items="${users}" var="user">
      	<tr>
          <td>${user.getName()}</td>
          <td>${user.getEmail()}</td>
          <td>${user.getStatus()}</td>
          <td>
          	<a class="btn btn-sm btn-warning" href="<c:out value="/user/form/${user.id}"/>">Edit</a>
          	<a class="btn btn-sm btn-warning" href="<c:out value="/user/${user.id}"/>">View</a>
          	<a class="btn btn-sm btn-danger" href="/user/${user.getId()}/delete">Delete</a>	
       	  </td>
     	</tr>
 		</c:forEach>                   
    </tbody>
  </table>          
</div>