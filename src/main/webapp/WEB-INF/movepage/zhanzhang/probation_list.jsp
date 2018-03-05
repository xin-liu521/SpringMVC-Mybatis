<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 14:42
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

    <!-- Icons -->
    <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/img/favicon.png">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon57.png" sizes="57x57">

    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon114.png" sizes="114x114">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/plugins.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/themes.css">
    <script src="${pageContext.request.contextPath }/js/movejs/vendor/modernizr-3.3.1.min.js"></script>
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
                            <%--<li class="dropdown-header">--%>
                                <%--<strong>个人中心</strong>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">--%>
                                    <%--<i class="fa fa-inbox fa-fw pull-right"></i>--%>
                                    <%--修改图像--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">--%>
                                    <%--<i class="fa fa-pencil-square fa-fw pull-right"></i>--%>
                                    <%--修改信息--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">--%>
                                    <%--<i class="fa fa-picture-o fa-fw pull-right"></i>--%>
                                    <%--个人资料--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li class="divider"><li>--%>
                            <%--<li>--%>
                                <%--<a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar-alt');">--%>
                                    <%--<i class="gi gi-settings fa-fw pull-right"></i>--%>
                                    <%--设置--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">--%>
                                    <%--<i class="gi gi-lock fa-fw pull-right"></i>--%>
                                    <%--锁定账户--%>
                                <%--</a>--%>
                            <%--</li>--%>
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
                <div class="row panel">
                    <h3 class="text-center" style="color: red;">试用期骑手信息</h3>
                    <div class="panel-group" id="accordion" style="margin: auto 5%;">
                        <p style="padding-left: 3%;"> 试用期人数 ：<span style="color: red;">${count}</span>人</p>
                        <div class="panel-group" id="accordion">
                            <!-- 折叠第一个-->
                            <c:forEach items="${preworkerList}" var="preworker" varStatus="status">
                                <c:set var="index" value="${index+1}"/>
                                <div class="panel table-bordered" style="padding-left: 5%;">
                                    <!-- 展开部分 -->
                                    <p data-toggle="collapse" data-parent="#accordion" href="#collapse_${index}" style="padding: 10px;">
                                        <span class="col-xs-5"><strong>${preworker.name}</strong></span>
                                        <span class="col-xs-6"><strong>${preworker.telephone}</strong></span>
                                        <span style="margin-top:1%;"><strong class="caret"></strong></span>
                                    </p>
                                    <!-- 折叠部分 -->
                                    <div id="collapse_${index}" class="panel-collapse collapse">
                                        <p data-toggle="collapse" data-parent="#accordion" href="#"  style="color: #2f96b4">
                                            <span class="col-xs-11"><strong>试用期开始时间：<fmt:formatDate value="${preworker.baodaodate}" pattern="yyyy-MM-dd"/></strong></span><br>
                                            <span class="col-xs-11"><strong>试用期结束时间：<fmt:formatDate value="${preworker.indate}" pattern="yyyy-MM-dd"/></strong></span><br>
                                            <span class="col-xs-11"><strong>地区：${preworker.region.name}</strong></span></br>
                                            <span class="col-xs-11"><strong>站点：${preworker.station.name}</strong></span>
                                        </p>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="text-center">- 已经到底了，别再划了 -</div>
                    <!-- 主内容折叠区结束 -->
                </div>
                <!-- END First Row -->

            </div>
            <!-- 内容区 -->
        </div>
        <!-- 主界面内容结束 -->
    </div>
    <!-- END Page Container -->
</div>
</body>
<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
<script src="${pageContext.request.contextPath }/js/movejs/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/plugins.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/app.js"></script>

<!-- Load and execute javascript code used only in this page -->
<script src="${pageContext.request.contextPath }/js/movejs/pages/readyDashboard.js"></script>
</html>
