<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="mb-4">
	<span class="fs-2 fw-bold text-secondary">${title}</span>                    
</div>  
<table class="table table-striped">
    <thead>
        <tr>  
        	<th>#</th>
        	<th>Order Number</th>        
            <th>Status</th>            
            <th>Customer name</th>
            <th>Created</th>
            <th>Last update</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${orders}" var="order" varStatus="loop">
            <tr>
            	<td>${ loop.index + 1 }</td>
                <td>
                	<a href="<c:out value="/order/${order.id}"/>">${order.getOrderNumber()}</a>
               	</td>
                <td>${order.getStatus()}</td>
                <td>${order.getCustomer().getName()}</td>
                <td>${order.getCreated()}</td>
                <td>${order.getUpdated()}</td>
               
            </tr>
        </c:forEach>
    </tbody>
</table>