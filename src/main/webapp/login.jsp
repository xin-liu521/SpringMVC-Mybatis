<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>店小二 - 登录</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    <link href="css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="gray-bg" style="background: url('./img/login-background.jpg') 0 0 no-repeat;background-size:100% 100%;">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <h2>员工登录</h2>

        <form  method="post" action="${pageContext.request.contextPath }/userAction_login.action">
            <div class="form-group">
                <input id="username" name="username" type="text" class="form-control uname" placeholder="用户名" />
            </div>
            <div class="form-group">
                <input id="pwd" name="password" type="password" class="form-control pword m-b" placeholder="密码" />
            </div>
            <button type="submit" id="signinSubmit" class="btn btn-success btn-block">登录</button>
            <p class="text-muted text-center">
                <a href="#">忘记密码</a>
            </p>

            <div align="center">
                <br/>
                <font  color="red">
                    <s:actionerror/>
                </font>
            </div>
        </form>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
           <span>
                &copy; 西安威沃网络科技有限公司 <br>
                <%--<a href="#">备案号:陕ICP备15000560号-1</a>--%>
            </span>
        </div>
    </div>
</div>
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.5"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

<script>

$('#signinSubmit').click(function(){
	if($('#username').val() === ''){
		$(this).text('用户名不能为空');
	}else if($('#pwd').val() === ''){
		$(this).text('密码不能为空');
	}else{
		$(this).text('请稍后...');
	}
});
</script>
</html>