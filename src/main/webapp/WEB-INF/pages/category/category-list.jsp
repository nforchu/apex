<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div>
		<h3>
			<span>Available categories </span>  
			<a class="btn btn-sm btn-primary" href="/category/form">Add a Category</a> 
		</h3>                   
    </div>  
    <table class="table table-striped">
    <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
     	<c:forEach items="${categories}" var="category">
      	<tr>
          <td>${category.getTitle()}</td>
          <td>${category.getDescription()}</td>
          <td>active</td>
          <td>
          	<a class="btn btn-sm btn-warning" href="<c:out value="/category/form/${category.id}"/>">Edit</a>
          	<a class="btn btn-sm btn-warning" href="<c:out value="/category/${category.id}"/>">View</a>
          	<a class="btn btn-sm btn-dark" href="<c:out value="/category/${category.id}"/>">View products</a>
       	  </td>
     	</tr>
 		</c:forEach>                   
    </tbody>
  </table>          
</div>