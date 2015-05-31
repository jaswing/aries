<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<s:url value="/login" var="URL_LOGIN"/>
<form name="f" action="${URL_LOGIN}" method="post">
    <fieldset>
        <legend><s:message code="auth.message.loginTitle"/></legend>

        <!-- use param.error assuming FormLoginConfigurer#failureUrl contains the query parameter error -->
        <c:if test="${param.error != null}">
            <h5><s:message code="auth.message.loginFail"/></h5>
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                <p class="validate_err">
                    <s:message code="auth.message.cause"/>:
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </p>
            </c:if>
        </c:if>
        <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
        <c:if test="${param.logout != null}">
            <p><s:message code="auth.message.logoutStatus"/></p>
        </c:if>

        <div>
            <label for="username">Username</label>
            <input placeholder="User ID" type="text" id="username" name="username"/>
        </div>
        <div>
            <label for="password">Password</label>
            <input placeholder="Password" type="password" id="password" name="password"/>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </fieldset>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
