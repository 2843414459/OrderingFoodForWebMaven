
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "url" value="<%=request.getContextPath()%>"></c:set>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <title>🐱吃了喵点餐平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${url}/css/index.css">
    <link rel="stylesheet" href="${url}/css/rider_login.css">
    <script src="${url}/js/riderJs/rider_login.js"></script>
</head>
<body>

<h1 class="title">吃了喵-骑手版</h1>
<img class="logo" src="${url}/images/rider_login.png" alt="">


<div class="login_box">
    <form action="${url}/busLogin.do" method="post">
        <table>
            <tr>
                <td class="l_td">用户名</td>
                <td class="r_td"><input value="xyzhlt" type="text" name="userName"></td>
            </tr>
            <tr>
                <td class="l_td">密码：</td>
                <td class="r_td"><input value="123456" type="password" name="password"></td>
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