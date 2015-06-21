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
    <s:url value="/resources/css/style.css" var="URL_CSS_STYLE"/>
    <link rel="stylesheet" type="text/css" href="${URL_CSS_STYLE}">
</head>
<body>
<h1><s:message code="app.title"/></h1>

<h2><s:message code="label.user.userInfo"/></h2>

<p>
    <label class="input-label">ID</label>
    <span class="input-field">${user.id}</span>
</p>

<p>
    <label class="input-label"><s:message code="label.user.username"/></label>
    <span class="input-field">${user.username}</span>
</p>

<p>
    <label class="input-label"><s:message code="label.user.emailAddress"/></label>
    <span class="input-field">${user.emailAddress}</span>
</p>

<p>
    <label class="input-label">dateInfo</label>
    <span class="input-field">${user.dateInfo}</span>
</p>

<p>
    <label class="input-label">zonedDateTime1</label>
    <span class="input-field">${user.zonedDateTime1}</span>
</p>

<p>
    <label class="input-label">zonedDateTime2</label>
    <span class="input-field">${user.zonedDateTime2}</span>
</p>

<p>
    <label class="input-label">Role</label>
    <span class="input-field">${user.role}</span>
</p>
<hr/>

<s:url value="/" var="URL_ROOT"/>
<button onclick="location.href='${URL_ROOT}'"><s:message code="auth.button.top"/></button>
</body>
</html>