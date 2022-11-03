<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="m-4">
	<span class="fs-2 fw-bold text-secondary">${menu.getTitle()}</span>
	
	<ul class="list-group ">
	    <c:forEach var="entry" items="${menu.getMap()}">
	        <li class="list-group-item fs-6 fw-bold">
	            <a class="text-secondary" href="<c:out value="${entry.value}"/>"><c:out value="${entry.key}"/></a>
	        </li>
	    </c:forEach>
	</ul>
</div>
