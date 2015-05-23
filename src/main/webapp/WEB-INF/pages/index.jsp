<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><s:message code="app.title"/></title>
    <meta charset="utf-8" />
</head>
<body>
<h1><s:message code="app.title"/></h1>

<c:if test="${messages != null}">
<ul>
    <c:forEach items="${messages}" var="item">
        <li>${item.id} / ${item.title} / ${item.message}</li>
    </c:forEach>
</ul>
</c:if>
</body>
</html>