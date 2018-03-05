<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/5
  Time: 10:05
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
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon72.png" sizes="72x72">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon76.png" sizes="76x76">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon114.png" sizes="114x114">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon120.png" sizes="120x120">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon144.png" sizes="144x144">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon152.png" sizes="152x152">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath }/img/icon180.png" sizes="180x180">
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
                            <a href="${pageContext.request.contextPath }/preworkerAction_pageRsQueryCount.action" class=" active"><i class="gi gi-compass sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">首页</span></a>
                        </li>
                        <!-- 入职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-rocket sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">入职管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/preworkerAction_moveRsPageQuery.action">预登记（人事）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/daibaodaoAction_moveBdRsPageQuery.action">待报到（人事）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/shiyongqiAction_moveRsSypageQuery.action">试用期（人事）</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 离职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="gi gi-airplane sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">离职管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/leavereqAction_moveRsplist.action">人事审批</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 考勤模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">考勤管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/kaoqinAction_moveRsPageQuerykq.action">今日考勤（人事）</a>
                                </li>
                            </ul>
                        </li>
                        <!-- 个人中心模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">个人中心</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/workerAction_selectRsWorker.action">个人中心（人事）</a>
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
                        <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');this.blur();">
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
                        <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar-alt');this.blur();">
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
                                <a href="${pageContext.request.contextPath}/userAction_updatePasswordPage.action">
                                    <i class="fa fa-pencil-square fa-fw pull-right"></i>
                                    修改密码
                                </a>
                            </li>
                            <%--<li class="dropdown-header">--%>
                            <%--<strong>个人中心</strong>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<a href="page_app_email.html">--%>
                            <%--<i class="fa fa-inbox fa-fw pull-right"></i>--%>
                            <%--修改图像--%>
                            <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<a href="page_app_social.html">--%>
                            <%--<i class="fa fa-pencil-square fa-fw pull-right"></i>--%>
                            <%--修改信息--%>
                            <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<a href="page_app_media.html">--%>
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
                            <%--<a href="page_ready_lock_screen.html">--%>
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
                    <h3 class="text-center" style="color: red;">个人中心</h3>
                    <div class="panel-group" style="margin: auto 5%;">
                        <div class="panel-group">
                            <!-- 折叠第一个-->
                            <div class="panel table-bordered" style="padding-left: 5%;">
                                <p data-toggle="collapse" data-parent="#accordion" href="#collapse0">
                                    <span><strong>姓名：${worker.name} </strong></span><br>
                                    <span><strong>站点：${worker.station.name}</strong></span><br>
                                    <span><strong>手机：${worker.telephone} </strong></span><br>
                                    <span><strong>入职日期：${worker.indate} </strong></span><br>
                                </p>
                            </div>
                            <div class="panel table-bordered" style="padding-left: 5%;">
                                <p data-toggle="collapse" data-parent="#accordion" href="#collapse0">
                                    <span><strong>身份证信息 </strong></span><br>
                                    <span><strong>${worker.cardid}</strong></span><br>
                                </p>
                            </div>
                            <div class="panel table-bordered" style="padding-left: 5%;">
                                <p data-toggle="collapse" data-parent="#accordion" href="#collapse0">
                                    <span><strong>银行卡信息： </strong></span><br>
                                    <span><strong>开户行：${worker.yhfrom}</strong></span><br>
                                    <span><strong>账号：${worker.yhcard} </strong></span><br>
                                    <span><strong>户主： ${worker.yhperson}</strong></span><br>
                                </p>
                            </div>
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
<script src="${pageContext.request.contextPath }/js/movejs/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/plugins.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/app.js"></script>

<!-- Load and execute javascript code used only in this page -->
<script src="${pageContext.request.contextPath }/js/movejs/pages/readyDashboard.js"></script>
</html>
