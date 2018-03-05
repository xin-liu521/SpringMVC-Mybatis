<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/29
  Time: 17:44
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
    <style>
        .syfont {
            font-size: 12px;
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
                        <!--<li class="sidebar-separator">
                            <i class="fa fa-ellipsis-h"></i>
                        </li>-->
                        <!-- 入职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-rocket sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">入职管理</span></a>
                            <ul>
                                <%--<li>--%>
                                    <%--<a href="${pageContext.request.contextPath}/movepage_zhanzhang_zzregister.action">预登记（人事）</a>--%>
                                <%--</li>--%>

                                <%--<li>--%>
                                    <%--<a href="1-rz-notice.html">待报到（人事）</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="1-rz-common.html">试用期（人事）</a>--%>
                                <%--</li>--%>
                                <li>
                                    <a href="${pageContext.request.contextPath}/preworkerAction_movePageQuery.action">预登记（站长）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/daibaodaoAction_moveBdPageQuery.action">待报到（站长）</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/shiyongqiAction_moveSypageQuery.action">试用期（站长）</a>
                                </li>
                                <!--<li>
                                    <a href="page_ui_tables.html">Tables</a>
                                </li>-->
                            </ul>
                        </li>
                        <!-- 离职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="gi gi-airplane sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">离职管理</span></a>
                            <ul>
                                <%--<li>--%>
                                    <%--<a href="3-lz-article.html">骑手发起</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="2-lz-faqi.html">站长代发起</a>--%>
                                <%--</li>--%>
                                <li>
                                    <a href="${pageContext.request.contextPath}/leavereqAction_moveZsplist.action">站长审批</a>
                                </li>
                                <%--<li>--%>
                                    <%--<a href="2-lz-manage.html">站长审批列表</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="${pageContext.request.contextPath}/leavereqAction_moveRsplist.action">人事审批</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="1-lz-dengdai.html">扣费处理</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="1-lz-finish.html">人事审批列表</a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>
                        <%--<!-- 在职模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="gi gi-more_items sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">在职管理</span></a>
                            <ul>
                                <li>
                                    <a href="1-zz-list.html">人员管理（人事）</a>
                                </li>
                                <li>
                                    <a href="2-zz-list.html">人员管理（站长）</a>
                                </li>
                            </ul>
                        </li>--%>
                        <!-- 考勤模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">考勤管理</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/kaoqinAction_movePageQuerykq.action">今日考勤（站长）</a>
                                </li>
                                <%--<li>
                                    <a href="1-kq-show.html">今日考勤（人事）</a>
                                </li>
                                <li>
                                    <a href="2-kq-list.html">考勤统计（站长）</a>
                                </li>
                                <li>
                                    <a href="1-kq-list.html">考勤统计（人事）</a>
                                </li>
                                <li>
                                    <a href="2-kq-informs.html">人员速查（站长）</a>
                                </li>
                                <li>
                                    <a href="1-kq-informs.html">人员速查（人事）</a>
                                </li>--%>
                            </ul>
                        </li>
                        <!-- 个人中心模块 -->
                        <li>
                            <a href="#" class="sidebar-nav-menu"><i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i><i class="fa fa-gift sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">个人中心</span></a>
                            <ul>
                                <li>
                                    <a href="${pageContext.request.contextPath}/workerAction_selectWorker.action">个人中心（站长）</a>
                                </li>
                                <%--<li>--%>
                                    <%--<a href="1-profile.html">个人中心（人事）</a>--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                    <%--<a href="3-profile.html">个人中心（骑手）</a>--%>
                                <%--</li>--%>
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
                            <%--<li class="dropdown-header">--%>
                                <%--<strong>个人中心</strong>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="page_app_email.html">--%>
                                    <%--<i class="fa fa-inbox fa-fw pull-right"></i>--%>
                                    <%--修改图像--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <li>
                                <a href="${pageContext.request.contextPath}/userAction_updatePwdPage.action">
                                    <i class="fa fa-pencil-square fa-fw pull-right"></i>
                                    修改密码
                                </a>
                            </li>
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
            <!-- END Header -->

            <!-- Page content -->
            <div id="page-content">
                <!-- First Row -->
                <div class="row">
                    <!-- Simple Stats Widgets -->
                    <div class="col-xs-6 col-lg-3">
                        <a href="${pageContext.request.contextPath}/preworkerAction_movePageQuery.action" class="widget">
                            <div class="widget-content widget-content-mini text-right clearfix">
                                <div class="widget-icon pull-left themed-background">
                                    <i class="gi gi-cardio text-light-op"  style="margin-top: 30%;"></i>
                                </div>
                                <h2 class="widget-heading h3">
                                    <strong><span data-toggle="counter" data-to="2835" id="djCount">0</span></strong>
                                </h2>
                                <span class="text-muted syfont">预登记人数</span>
                            </div>
                        </a>
                    </div>
                    <div class="col-xs-6 col-lg-3">
                        <a href="${pageContext.request.contextPath}/daibaodaoAction_moveBdPageQuery.action" class="widget">
                            <div class="widget-content widget-content-mini text-right clearfix">
                                <div class="widget-icon pull-left themed-background-success">
                                    <i class="gi gi-user text-light-op" style="margin-top: 30%;"></i>
                                </div>
                                <h2 class="widget-heading h3 text-success">
                                    <strong><span data-toggle="counter" data-to="2862" id="bdCount">0</span></strong>
                                </h2>
                                <span class="text-muted syfont">待报到人数</span>
                            </div>
                        </a>
                    </div>
                    <div class="col-xs-6 col-lg-3">
                        <a href="${pageContext.request.contextPath}/shiyongqiAction_moveSypageQuery.action" class="widget">
                            <div class="widget-content widget-content-mini text-right clearfix">
                                <div class="widget-icon pull-left themed-background-warning">
                                    <i class="gi gi-briefcase text-light-op" style="margin-top: 30%;"></i>
                                </div>
                                <h2 class="widget-heading h3 text-warning">
                                    <strong><span data-toggle="counter" data-to="75" id="syCount">0</span></strong>
                                </h2>
                                <span class="text-muted syfont">试用期人数</span>
                            </div>
                        </a>
                    </div>
                    <div class="col-xs-6 col-lg-3">
                        <a href="javascript:void(0)" class="widget">
                            <div class="widget-content widget-content-mini text-right clearfix">
                                <div class="widget-icon pull-left themed-background-danger">
                                    <i class="gi gi-wallet text-light-op" style="margin-top: 30%;"></i>
                                </div>
                                <h2 class="widget-heading h3 text-danger">
                                    <strong><span data-toggle="counter" data-to="5820">${zgCount}</span></strong>
                                </h2>
                                <span class="text-muted syfont">在职人数</span>
                            </div>
                        </a>
                    </div>
                    <!-- END Simple Stats Widgets -->
                </div>
                <!-- END First Row -->


                <!-- Third Row -->
                <div class="row">
                    <div class="col-sm-4">
                        <!-- Project Widget -->
                        <div class="widget" onclick="kaoqinClick();">
                            <div class="widget-content border-bottom ">
                                <span class="pull-right text-muted">站点总人数${cqListCount}人</span>
                                人员考勤信息
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading">
                                            <i class="gi gi-book_open text-dark push"></i>
                                            <small id="todayCount" class="syfont">出勤(0)人</small>
                                        </h3>
                                    </div>
                                    <div class="col-xs-6 ">
                                        <h3 class="widget-heading">
                                            <i class="gi gi-user_add text-dark push"></i>
                                            <small id="qeqCount" class="syfont">未出勤(0)人</small></h3>
                                    </div>
                                </div>
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading">
                                            <i class="gi gi-briefcase text-dark push"></i>
                                            <small id="cdCount" class="syfont">迟到(0)人</small></h3>
                                    </div>
                                    <div class="col-xs-6">
                                        <h3 class="widget-heading">
                                            <i class="gi gi-truck text-dark push"></i>
                                            <small id="qjCount" class="syfont">请假(0)人</small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END Project Widget -->
                    </div>
                    <div class="col-sm-4">
                        <!-- Project Widget -->
                        <div class="widget" onclick="leaverClick();">
                            <div class="widget-content border-bottom">
                                <span class="pull-right text-muted">站点离职总人数${leaverCount}人</span>
                                站点人员离职信息
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading"><i class="gi gi-book_open text-dark push"></i> <small class="syfont" id="fqCount">发起离职(0)人</small></h3>
                                    </div>
                                    <div class="col-xs-6 ">
                                        <h3 class="widget-heading"><i class="gi gi-user_add text-dark push"></i> <small class="syfont" id="zApproveCount">待站长审批(0)人</small></h3>
                                    </div>
                                </div>
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading"><i class="gi gi-briefcase text-dark push"></i><small class="syfont" id="rsApproveCount">待人事审批(0)人</small></h3>
                                    </div>
                                    <div class="col-xs-6 ">
                                        <h3 class="widget-heading"><i class="gi gi-truck text-dark push"></i> <small class="syfont" id="finishCount">审批完成(0)人</small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END Project Widget -->
                    </div>
                    <div class="col-sm-4">
                        <!-- Project Widget -->
                        <div class="widget">
                            <div class="widget-content border-bottom">
                                <span class="pull-right text-muted"></span>
                                站点当日送餐数据
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading"><i class="gi gi-book_open text-dark push"></i> <small class="syfont">站点总单量</small></h3>
                                    </div>
                                    <div class="col-xs-6 ">
                                        <h3 class="widget-heading"><i class="gi gi-user_add text-dark push"></i> <small class="syfont">最高单量</small></h3>
                                    </div>
                                </div>
                            </div>
                            <div class="widget-content widget-content-full-top-bottom border-bottom">
                                <div class="row">
                                    <div class="col-xs-6 border-right">
                                        <h3 class="widget-heading"><i class="gi gi-briefcase text-dark push"></i> <small class="syfont">最低单量</small></h3>
                                    </div>
                                    <div class="col-xs-6">
                                        <h3 class="widget-heading"><i class="gi gi-truck text-dark push"></i> <small class="syfont">平均数据</small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END Project Widget -->
                    </div>
                </div>
                <!-- END Third Row -->
            </div>
            <!-- END Page Content -->
        </div>
        <!-- 主界面内容结束 -->
    </div>
    <!-- END Page Container -->
</div>
<!-- END Page Wrapper -->

<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
<script src="${pageContext.request.contextPath }/js/movejs/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/plugins.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/app.js"></script>

<!-- Load and execute javascript code used only in this page -->
<script src="${pageContext.request.contextPath }/js/movejs/pages/readyDashboard.js"></script>

</body>
</html>
<script>
    var cqList = '${cqList}';
    if (cqList != '') {
        var cqNum = 0; //出勤数
        var qjNum = 0;//请假数
        var qeqNum = 0;//未出勤数
        var cdNum = 0;//迟到数
        $.each(JSON.parse(cqList), function(index, value){
            var state = value.state;
            if (state == 1 || state == 2 || state == 3) {
                cqNum++;
            }
            if (state == 4 || state == 6|| state == 7) {
                qjNum++;
            }
            if (state == 0) {
                qeqNum++;
            }
            if (state == 5) {
                cdNum++;
            }
        });

        $("#todayCount").text("出勤("+cqNum+")人");
        $("#qeqCount").html("未出勤("+qeqNum+")人");
        $("#cdCount").html("迟到("+cdNum+")人");
        $("#qjCount").html("请假("+qjNum+")人");
    }



    var leaverList = '${leaverList}';
    if (leaverList != '') {
        var fqCount = 0; //发起离职
        var zApproveCount = 0;//站长审批
        var rsApproveCount = 0;//人事审批
        var finishCount = 0;//审批完成
        $.each(JSON.parse(leaverList), function(index, value){
            var state = value.state;
            if (state == 0 ) {
                fqCount++;
            }
            if (state == 1 ) {
                zApproveCount++;
            }
            if (state == 2) {
                rsApproveCount++;
            }
            if (state == 3) {
                finishCount++;
            }
        });

        $("#fqCount").text("发起离职("+fqCount+")人");
        $("#zApproveCount").html("待站长审批("+zApproveCount+")人");
        $("#rsApproveCount").html("待人事审批("+rsApproveCount+")人");
        $("#finishCount").html("审批完成("+finishCount+")人");
    }

    var preworkerJson = '${preworkerJson}';
    if (preworkerJson != '') {
        var djCount = 0;
        var bdCount = 0;
        var syCount = 0;
        $.each(JSON.parse(preworkerJson), function(index, value){
            var state = value.state;
            if (state == 0 ) {
                djCount++;
            }
            if (state == 1 ) {
                bdCount++;
            }
            if (state == 2) {
                syCount++;
            }
        });

        $("#djCount").text(djCount);
        $("#bdCount").html(bdCount);
        $("#syCount").html(syCount);
    }

    //考勤跳转页面
    function kaoqinClick(){
        window.location.href = '${pageContext.request.contextPath}/kaoqinAction_movePageQuerykq.action';
    }

    //离职跳转页面
    function leaverClick() {
        window.location.href = '${pageContext.request.contextPath}/leavereqAction_moveZsplist.action';
    }
</script>