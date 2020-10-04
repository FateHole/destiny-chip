<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("cts", request.getContextPath());
%>
<body>
<a href="${cts}/admins">select</a>
</body>
</html>
