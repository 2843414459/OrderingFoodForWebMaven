
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("url","http://localhost:8080/OerDingFoodForWeb");
%>
<html>
<head>
    <title>Title</title>
    <title>🐱吃了喵点餐平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import "${url}/css/index.css";
        @import "${url}/css/user_login.css";
    </style>
    <script src="${url}/js/user_login.js"></script>
</head>
<body>
<h1 class="title">吃了喵-用户名</h1>
<img class="logo" src="${url}/images/user_login.png" alt="">
</body>
</html>