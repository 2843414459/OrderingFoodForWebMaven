<%--
  Created by IntelliJ IDEA.
  User: 71970
  Date: 2023/4/5
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="<%=request.getContextPath()%>" var="url" />
<%@page isELIgnored="false" %>
<html>
<head>
    <title>🐱吃了喵点餐平台-用户版</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import "${url}/css/index.css";
        @import "${url}/css/rider_login.css";
    </style>
    <script src="${url}/js/rider_login.js"></script>
</head>
<body>
<h1 class="title">吃了喵-骑手版</h1>
<img class="logo" src="${url}/images/rider.png"/>
</body>
</html>
