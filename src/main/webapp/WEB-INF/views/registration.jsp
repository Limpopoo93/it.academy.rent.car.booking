<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 07.06.2020
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="user" type="rent.car.booking.tourist.bean.User"--%>
<form:form class="register-form"
           action="${pageContext.request.contextPath}userRegistration"
           modelAttribute="user" method="post">
    <div class="form">
        <form:errors path="username" cssStyle="color: red"/>
        <form:input path="username" type="text" placeholder="login"/>

        <form:errors path="password" cssStyle="color: red"/>
        <form:input path="password" type="text" placeholder="password"/>

        <form:errors path="email" cssStyle="color: red"/>
        <form:input path="email" type="text" placeholder="email"/>

        <form:errors path="firstName" cssStyle="color: red"/>
        <form:input path="firstName" type="text" placeholder="firstName"/>

        <form:errors path="lastName" cssStyle="color: red"/>
        <form:input path="lastName" type="text" placeholder="lastName"/>
        <div class="send-button">
            <input type="submit" value="Registration">
        </div>
    </div>
</form:form>
</body>
</html>
