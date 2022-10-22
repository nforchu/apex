<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/css/styles.css" />" rel="stylesheet"></link>

    <title>${title}</title>
</head>
<body>

<div class="header">
    <tiles:insertAttribute name="header" />
</div>

<div class="row">
    <div class="column middle" style="background-color:#bbb;"><tiles:insertAttribute name="body" /></div>
</div>

<div class="footer">
    <tiles:insertAttribute name="footer" />
</div>

</body>
</html>