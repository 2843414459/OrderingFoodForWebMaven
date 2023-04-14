<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("url", "http://localhost:8080/OrderingFoodForWebMaven");
%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <title>🐱吃了喵点餐平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        @import "${url}/css/index.css";
        @import "${url}/css/bus_login.css";
    </style>
    <script src="${url}/js/bus_login.js"></script>
</head>
<body>
<h1 class="title">吃了喵-商家版</h1>
<img class="logo" src="${url}/images/bus_login.png" alt="">


<div class="login_box">
    <form action="${url}/busLogin.do" method="post">
        <table>
            <tr>
                <td class="l_td">用户名</td>
                <td class="r_td"><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td class="l_td">密码：</td>
                <td class="r_td"><input type="password" name="password"></td>
            </tr>
        </table>
        <p>还没有账号？<a onclick="register()" href="javascript:void(0)">去注册</a></p>
        <button class="sub_btn" type="submit">登&nbsp;&nbsp;&nbsp;录</button>
    </form>
</div>

<div class="register">
    <form action="${url}/busRegister.do">
        <table>
            <tr>
                <td class="l_td">昵称：</td>
                <td class="r_td"><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td class="l_td">用户名：</td>
                <td class="r_td">
                    <input type="text" id="userName" name="userName" onblur="checkUserName()" required>
                    <span id="userNameMsg" style="color: tomato"></span>
                </td>
            </tr>
            <tr>
                <td class="l_td">密码：</td>
                <td class="r_td"><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td class="l_td">地址：</td>
                <td class="r_td"><input type="text" name="address" required></td>
            </tr>
            <tr>
                <td class="l_td">手机号：</td>
                <td class="r_td"><input type="text" name="tel" required></td>
            </tr>
        </table>
        <p>已有账号？ <a onclick="login()" href="javascript:void(0)">去登陆</a></p>
        <button class="sub_btn" href="javascript:void(0)" type="submit">提交</button>
    </form>
</div>
</body>
</html>
