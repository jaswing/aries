<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<sf:form modelAttribute="user" method="post" enctype="utf8">
    <div>
        <label><s:message code="label.user.firstName"/></label>
        <sf:input path="firstName"/>
        <sf:errors path="firstName" element="div" cssClass="validate_err"/>
    </div>
    <div>
        <label><s:message code="label.user.lastName"/></label>
        <sf:input path="lastName"/>
        <sf:errors path="lastName" element="div" cssClass="validate_err"/>
    </div>
    <div>
        <label><s:message code="label.user.gender"/></label>
        <c:if test="${genderArr ne null and genderArr.size() > 0}">
            <sf:radiobuttons path="male" items="${genderArr}"/>
        </c:if>
    </div>
    <div>
        <label><s:message code="label.user.emailAddress"/></label>
        <sf:input path="emailAddress"/>
        <sf:errors path="emailAddress" element="div" cssClass="validate_err"/>
    </div>
    <div>
        <label><s:message code="label.user.username"/></label>
        <sf:input path="username"/>
        <sf:errors path="username" element="div" cssClass="validate_err"/>
    </div>
    <div>
        <label><s:message code="label.user.password"/></label>
        <sf:password path="password"/>
        <sf:errors path="password" element="div" cssClass="validate_err"/>
    </div>
    <div>
        <label><s:message code="label.user.confirmPassword"/></label>
        <sf:password path="matchingPassword"/>
        <sf:errors element="div" cssClass="validate_err"/>
    </div>

    <button type="submit"><s:message code="label.form.submit"/></button>
</sf:form>

<hr/>

<s:url value="/login" var="URL_LOGIN"/>
<input type="button" value="<s:message code='auth.button.login'/>" onclick="location.href='${URL_LOGIN}'"/>
</body>
</html>