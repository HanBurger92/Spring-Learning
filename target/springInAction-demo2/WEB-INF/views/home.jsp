<%--
  Created by IntelliJ IDEA.
  User: BaoHan
  Date: 2019-06-24
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome to Repository Manager</h1>

<a href="<c:url value="/login" /> ">Login</a>
<a href="<c:url value="/register"/> ">Register</a>
</body>
</html>