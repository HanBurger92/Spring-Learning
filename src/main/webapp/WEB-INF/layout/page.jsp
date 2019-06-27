<%--
  Created by IntelliJ IDEA.
  User: BaoHan
  Date: 2019-06-25
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<html>
<head>
    <title>repository Manager</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/css/style.css" />">
</head>
<body>
<div id="header">
    <t:insertAttribute name="header" />
</div>

<div id="content">
    <t:insertAttribute name="body" />
</div>
<div id="footer">
    <t:insertAttribute name="footer" />
</div>
</body>
</html>
