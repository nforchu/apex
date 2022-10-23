<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    
    <link href="/webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/css/styles.css" />" rel="stylesheet"></link>	
    
    <title>${title}</title>
  </head>
  
  <body>
	<div class="header">
	  <tiles:insertAttribute name="header" />
	</div>
	<div class="container-fluid">	
		<div class="navigation text-end">
		    <a href="/welcome">Home</a>		    
		    <a href="/category/list">Categories</a>
		    <a href="/product/list">Products</a>
		</div>
		
		<div class="row pt-2">
		    <div class="column side"><tiles:insertAttribute name="menu" /></div>
		 	<div class="column middle"><tiles:insertAttribute name="body" /></div>
		</div>		
			
	</div>
	
	<script src="/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.1/jquery.min.js"></script>	
  </body>
</html>