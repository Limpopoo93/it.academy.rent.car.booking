<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 07.06.2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="authenticationRequestDto" type="rent.car.booking.tourist.bean.AuthenticationRequestDto"--%>
<form:form class="register-form"
           action="${pageContext.request.contextPath}userComeIn"
           modelAttribute="authenticationRequestDto" method="post">
    <div class="form">
        <form:errors path="username" cssStyle="color: red"/>
        <form:input path="username" type="text" placeholder="login"/>

        <form:errors path="password" cssStyle="color: red"/>
        <form:input path="password" type="text" placeholder="password"/>

        <div class="send-button">
            <input type="submit" value="Come In">
        </div>
    </div>
</form:form>
</body>
</html>
