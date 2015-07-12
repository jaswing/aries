<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title><s:message code="app.title"/></title>
    <s:url value="/resources/css/style.css" var="URL_CSS_STYLE" />
    <link rel="stylesheet" type="text/css" href="${URL_CSS_STYLE}">
</head>
<body>
<h1><s:message code="app.title"/></h1>

<p><s:message code="auth.error.404"/></p>

<s:url value="/" var="URL_ROOT"/>
<button onclick="location.href='${URL_ROOT}'"><s:message code="auth.button.top"/></button>

</body>
</html>