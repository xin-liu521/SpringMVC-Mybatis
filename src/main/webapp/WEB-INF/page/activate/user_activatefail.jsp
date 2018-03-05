<%--
  Created by IntelliJ IDEA.
  User: infoyb
  Date: 2017.11.06
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活邮箱页面</title>

    <style>
        .content{
            text-align: center;
            height: 200px;
            width: 200px;
            position: absolute;
            top: 20%;
            left: 50%;
            margin-top: -50px;
            margin-left: -50px;
        }
    </style>
</head>
<body>
    <div class="content">
        <h3>激活失败</h3>
        <span>失败原因:激活超时</span>
        <div>
            <a href="${pageContext.request.contextPath}/userLogin">
                <h2>请重新注册</h2>
            </a>
        </div>
    </div>

</body>
</html>
