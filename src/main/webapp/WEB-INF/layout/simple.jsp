<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="/webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
	    <link href="<c:url value="/css/styles.css" />" rel="stylesheet"></link>	
	
	    <title>${title}</title>
	</head>
	<body>
		
		<div class="row">
		    <div class="column middle" style="background-color:#f2f2f2;"><tiles:insertAttribute name="body" /></div>
		</div>		
		
		<script src="/webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/3.6.1/jquery.min.js"></script>	
	</body>
</html>