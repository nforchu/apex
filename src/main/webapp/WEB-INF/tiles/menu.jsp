<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
    <c:forEach var="entry" items="${menu}">
        <li>
            <a href="<c:out value="${entry.value}"/>"><c:out value="${entry.key}"/></a>
        </li>
    </c:forEach>
</ul>