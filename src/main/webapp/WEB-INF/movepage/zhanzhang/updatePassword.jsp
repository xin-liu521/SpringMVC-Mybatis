<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>店小二</title>
    <meta name="description" content="AppUI is a Web App Bootstrap Admin Template created by pixelcave and published on Themeforest">
    <meta name="author" content="pixelcave">
    <meta name="robots" content="noindex, nofollow">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.png">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon57.png" sizes="57x57">

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon114.png" sizes="114x114">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/plugins.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/themes.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/layui.css">


    <script src="${pageContext.request.contextPath }/js/movejs/vendor/modernizr-3.3.1.min.js"></script>
    <style>
        .changeColor{
            color:gray;
            opacity: 0.3;
        }
    </style>
</head>
<body>
<div id="page-wrapper" class="page-loading">
    <div class="preloader">
        <div class="inner">
            <!-- Animation spinner for all modern browsers -->
            <div class="preloader-spinner themed-background hidden-lt-ie10"></div>

            <!-- Text for IE9 -->
            <h3 class="text-primary visible-lt-ie10"><strong>Loading..</strong></h3>
        </div>
    </div>
    <div id="page-container" class="header-fixed-top sidebar-visible-lg-full">
        <!-- 导航开始 -->
        <div id="sidebar">
            <!-- Sidebar Brand -->
            <div id="sidebar-brand" class="themed-background">
                <a href="index.jsp" class="sidebar-title">
                    <i class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide"><strong>店小二</strong></span>
                </a>
            </div>
            <!-- END Sidebar Brand -->

            <!-- Wrapper for scrolling functionality -->
            <div id="sidebar-scroll">
                <!-- Sidebar Content -->
                <div class="sidebar-content">
                    <!-- 左侧导航开始 -->
                    <ul class="sidebar-nav">
                        <!-- 首页 -->
                        <li>
                            <a href="index.jsp" class=" active"><i class="gi gi-compass sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">首页</span></a>
                        </li>
                        <!-- 入职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-rocket sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">入职管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/preworkerAction_movePageQuery.action">预登记（站长）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/daibaodaoAction_moveBdPageQuery.action">待报到（站长）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/shiyongqiAction_moveSypageQuery.action">试用期（站长）</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 离职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="gi gi-airplane sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">离职管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/leavereqAction_moveZsplist.action">站长审批</a>
                                </li>
                                <%--<li>--%>
                                <%--<a href="2-lz-manage.html">站长审批列表</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                <%--<a href="${pageContext.request.contextPath}/leavereqAction_moveRsplist.action">人事审批</a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>
                        <!-- 考勤模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">考勤管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/kaoqinAction_movePageQuerykq.action">今日考勤（站长）</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 个人中心模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">个人中心</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/workerAction_selectWorker.action">个人中心（站长）</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <!-- 左侧导航结束 -->
                </div>
                <!-- END Sidebar Content -->
            </div>
            <!-- END Wrapper for scrolling functionality -->

        </div>
        <!-- 导航结束 -->

        <!-- 主界面内容开始 -->
        <div id="main-container">
            <!-- 开始Header -->
            <header class="navbar navbar-inverse navbar-fixed-top">
                <!-- 左侧顶部开始 -->
                <ul class="nav navbar-nav-custom">
                    <!-- Main Sidebar Toggle Button -->
                    <li>
                        <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');this.blur();"  style="margin-top: 30%;">
                            <i class="fa fa-ellipsis-v fa-fw animation-fadeInRight" id="sidebar-toggle-mini"></i>
                            <i class="fa fa-bars fa-fw animation-fadeInRight" id="sidebar-toggle-full"></i>
                        </a>
                    </li>
                    <!-- END Main Sidebar Toggle Button -->

                    <!-- Header Link -->
                    <li class="hidden-xs animation-fadeInQuick">
                        <a href=""><strong>欢迎进入店小二</strong></a>
                    </li>
                    <!-- END Header Link -->
                </ul>
                <!-- 左侧顶部结束 -->

                <!-- 右侧顶部开始 -->
                <ul class="nav navbar-nav-custom pull-right">
                    <!-- Search Form -->
                    <li>
                        <form action="page_ready_search_results.html" method="post" class="navbar-form-custom">
                            <input type="text" id="top-search" name="top-search" class="form-control" placeholder="搜索..">
                        </form>
                    </li>
                    <!-- END Search Form -->

                    <!-- Alternative Sidebar Toggle Button -->
                    <li>
                        <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar-alt');this.blur();" style="margin-top: 30%;">
                            <i class="gi gi-search"></i>
                        </a>
                    </li>
                    <!-- END Alternative Sidebar Toggle Button -->

                    <!-- 个人中心 -->
                    <li class="dropdown">
                        <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="img/placeholders/avatars/avatar9.jpg" alt="avatar">
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/userAction_updatePwdPage.action">
                                    <i class="fa fa-pencil-square fa-fw pull-right"></i>
                                    修改密码
                                </a>
                            </li>

                            <li>
                                <a href="${pageContext.request.contextPath}/userAction_logout.action">
                                    <i class="fa fa-power-off fa-fw pull-right"></i>
                                    退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- 个人中心 -->
                </ul>
                <!-- 右侧顶部结束 -->
            </header>
            <!--  结束Header -->

            <!--  内容区 -->
            <div id="page-content">
                <!-- First Row -->
                <div class="row panel panel-default">
                    <div class="wrapper wrapper-content animated fadeInRight">

                        <div class="col-sm-10">
                            <div class="ibox float-e-margins">

                                <div class="ibox-content">

                                    <div>
                                        <form class="layui-form changePwd" id="editPassword">
                                            <div style="margin:20 0 15px 110px;"></div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">旧密码</label>
                                                <div class="layui-input-block">
                                                    <input type="password" id="pwd" name="pwd" placeholder="请输入旧密码"  class="layui-input pwd">
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">新密码</label>
                                                <div class="layui-input-block">
                                                    <input type="password" id="newPwd" name="newPwd" placeholder="请输入新密码"   class="layui-input pwd">
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">确认密码</label>
                                                <div class="layui-input-block">
                                                    <input type="password" id="verifyPwd" name="verifyPwd" placeholder="请确认密码"  class="layui-input pwd">
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <div class="layui-input-block">
                                                    <button class="layui-btn" lay-submit="" lay-filter="changePwd">立即修改</button>
                                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 内容区 -->
                </div>
            </div>
            <!-- 内容区 -->
        </div>
        <!-- 主界面内容结束 -->
    </div>
    <!-- END Page Container -->
</div>
</body>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>

<script src="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.js"></script>

<script src="${pageContext.request.contextPath }/js/movejs/plugins.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/app.js"></script>

<!-- Load and execute javascript code used only in this page -->
<script src="${pageContext.request.contextPath }/js/movejs/pages/readyDashboard.js"></script>
</html>
<script>
    $(function(){
        $('#editPassword').validate({
            rules: {
                pwd: {
                    required: true
                },
                newPwd: {
                    required: true
                },
                verifyPwd: {
                    required: true,
                    equalTo: "#newPwd"
                }
            },
            messages: {
                pwd: {
                    required: "<span style='color: red'>请输入旧密码</span>"
                },
                newPwd: {
                    required: "<span style='color: red'>请输入新密码</span>"
                },
                verifyPwd: {
                    required: "<span style='color: red'>请输入确认密码</span>",
                    equalTo: "<span style='color: red'>新密码和确认新密码不一致，请重新输入</span>"
                }
            },
            submitHandler: function (form) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/userAction_updatePassword.action",
                    dataType: "json",
                    data: {
                        pwd: $('#pwd').val(),
                        password: $('#newPwd').val()
                    },
                    type: "post",
                    success: function (data) {
                        if (data.success) {
                            Command:toastr["success"](data.picpath);
                            window.location.href = 'index.jsp'
                        } else {
                            Command:toastr["warning"](data.picpath);
                        }
                    },
                    error: function (XMLResponse) {
                        Command:toastr["error"](XMLResponse.type);
                    }
                });
            }
        });
    });
</script>