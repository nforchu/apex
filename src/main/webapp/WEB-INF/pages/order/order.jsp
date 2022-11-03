<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row mb-4">
	<div class="col-12">
		<c:if test = "${order.getStatus().name() == 'CONFIRMED'}">
			<a class="btn btn-sm btn-dark" href="<c:out value="/order/${order.id}/process?status=PROCESSING"/>">Process order</a>
		</c:if>
		
		<c:if test = "${order.getStatus().name() == 'PROCESSING'}">
			<a class="btn btn-sm btn-dark" href="<c:out value="/order/${order.id}/process?status=DELIVERED"/>">Close</a>
		</c:if>
	</div>

</div>

<div class="row pb-4">
   	<div class="col-3"><span class="fw-bold">Product title</span></div>    	
   	<div class="col-9">${order.getOrderNumber()}</div>
   </div>
   <div class="row pb-4">
   	<div class="col-sm-3"><span class="fw-bold">Customer</span></div>    	
   	<div class="col-sm-9">${order.getCustomer().getName()}</div>
   </div>
   
   <div class="row pb-4">
   	<div class="col-sm-3"><span class="fw-bold">Status</span></div>    	
   	<div class="col-sm-9">${order.getStatus()}</div>
   </div>
   
   <div class="row pb-4">
   	<div class="col-sm-3"><span class="fw-bold">Created</span></div>    	
   	<div class="col-sm-9">${order.getCreated()}</div>
   </div>
   
   <div class="row pb-4">
   	<div class="col-sm-3"><span class="fw-bold">Last update</span></div>    	
   	<div class="col-sm-9">${order.getUpdated()}</div>
   </div>
   

<table class="table table-striped">
    <thead>
        <tr>  
        	<th>#</th>
        	<th>Product</th>        
            <th>Quantity</th>            
            <th>Unit price</th>
            <th>Discount %</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
    	<%! int total = 0; %>  
        <c:forEach items="${order.getItems()}" var="item" varStatus="loop">
        	<c:set var = "total" scope = "request" value = "${total + ((item.getPrice() * item.getQuantity())-((item.getDiscount()/100)*(item.getPrice() * item.getQuantity())))}"/>
            <tr>
                <td>${ loop.index + 1 }</td>
                <td>${item.getProduct().getTitle()}</td>
                <td>${item.getQuantity()}</td>
                <td>&euro;${item.getPrice()}</td>
                <td>${item.getDiscount()}</td>
                <td class="fw-bold">&euro;${(item.getPrice() * item.getQuantity())-((item.getDiscount()/100)*(item.getPrice() * item.getQuantity()))}</td>
               
            </tr>
        </c:forEach>
        <tr class="fs-2 fw-bold text-success">
            <td colspan="4" class="fs-2 fw-bold">Total</td>
            <td>&euro;${total}</td>
         </tr>
    </tbody>
</table>