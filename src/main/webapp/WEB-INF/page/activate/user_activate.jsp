<%--
  Created by IntelliJ IDEA.
  User: infoyb
  Date: 2017.11.03
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活邮箱页面</title>
    <style>
        .content{
            text-align: center;
            height: 100px;
            width: 100px;
            position: absolute;
            top: 20%;
            left:50%;
            margin-top: -50px;
            margin-left: -50px;
        }
    </style>
</head>
<body>
    <div class="content">
        <h3>激活成功</h3>
        <div>
            <a href="${pageContext.request.contextPath}/userLogin">
                <h2>登录</h2>
            </a>
        </div>
    </div>
</body>
</html>
