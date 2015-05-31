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

<c:if test="${messages == null or messages.size() == 0}">
    <s:message code="app.noData"/>
</c:if>
<c:if test="${messages != null and messages.size() > 0}">
    <ul>
        <c:forEach items="${messages}" var="item">
            <li>${item.id} / ${item.title} / ${item.message}</li>
        </c:forEach>
    </ul>
</c:if>

<hr/>

<sec:authentication var="user" property="principal" />

<sec:authorize access="isAuthenticated()">
    <s:url value="/logout" var="URL_LOGOUT"/>
    <form action="${URL_LOGOUT}" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="<s:message code='auth.button.logout'/>"/>
    </form>
    <div>${user}</div>
    <div>${user.username}</div>
    <div>${user.role}</div>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <s:url value="/login" var="URL_LOGIN"/>
    <s:url value="/signUp"  var="URL_SIGNUP"/>
    <input type="button" value="<s:message code='auth.button.login'/>" onclick="location.href='${URL_LOGIN}'"/>
    <input type="button" value="<s:message code='auth.button.signUp'/>" onclick="location.href='${URL_SIGNUP}'"/>
</sec:authorize>
</body>
</html>