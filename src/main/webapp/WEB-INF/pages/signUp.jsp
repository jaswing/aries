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

<sf:form modelAttribute="user" method="post" action="signUp" acceptCharset="UTF-8">
    <fieldset>
        <legend><s:message code="auth.message.signupTitle"/></legend>
        <p>
            <label class="input-label" for="firstName"><s:message code="label.user.firstName"/></label>
            <span class="input-field">
                <sf:input path="firstName"/>
                <sf:errors path="firstName" element="span" cssClass="valid-error"/>
            </span>
        </p>

        <p>
            <label class="input-label" for="lastName"><s:message code="label.user.lastName"/></label>
            <span class="input-field">
                <sf:input path="lastName"/>
                <sf:errors path="lastName" element="span" cssClass="valid-error"/>
            </span>
        </p>

        <p>
            <label class="input-label" for="male"><s:message code="label.user.gender"/></label>
            <span class="input-field2"><sf:radiobuttons path="male" items="${genderMap}"/></span>
        </p>

        <p>
            <label class="input-label" for="emailAddress"><s:message code="label.user.emailAddress"/></label>
            <span class="input-field">
                <sf:input path="emailAddress"/>
                <sf:errors path="emailAddress" element="span" cssClass="valid-error"/>
            </span>
        </p>

        <p>
            <label class="input-label" for="username"><s:message code="label.user.username"/></label>
            <span class="input-field">
                <sf:input path="username"/>
                <sf:errors path="username" element="span" cssClass="valid-error"/>
            </span>
        </p>

        <p>
            <label class="input-label" for="password"><s:message code="label.user.password"/></label>
            <span class="input-field">
                <sf:password path="password"/>
                <sf:errors path="password" element="span" cssClass="valid-error"/>
            </span>
        </p>

        <p>
            <label class="input-label" for="matchingPassword"><s:message code="label.user.confirmPassword"/></label>
            <span class="input-field">
                <sf:password path="matchingPassword"/>
                <sf:errors element="span" cssClass="valid-error"/>
            </span>
        </p>

        <button type="submit"><s:message code="label.form.submit"/></button>
    </fieldset>
</sf:form>

<hr/>

<s:url value="/login" var="URL_LOGIN"/>
<s:url value="/" var="URL_ROOT"/>
<button onclick="location.href='${URL_LOGIN}'"><s:message code="auth.button.login"/></button>
<button onclick="location.href='${URL_ROOT}'"><s:message code="auth.button.top"/></button>
</body>
</html>