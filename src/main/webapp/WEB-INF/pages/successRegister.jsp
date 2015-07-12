<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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

<h5><s:message code="auth.signUp.congratulation"/></h5>

<p>
    <label class="input-label"><s:message code="label.user.username"/></label>
    <span class="input-field">${user.username}</span>
</p>
<p>
    <label class="input-label"><s:message code="label.user.emailAddress"/></label>
    <span class="input-field">${user.emailAddress}</span>
</p>

<s:url value="/login" var="URL_LOGIN"/>
<s:url value="/" var="URL_ROOT"/>
<button onclick="location.href='${URL_LOGIN}'"><s:message code="auth.button.login"/></button>
<button onclick="location.href='${URL_ROOT}'"><s:message code="auth.button.top"/></button>
</body>
</html>
