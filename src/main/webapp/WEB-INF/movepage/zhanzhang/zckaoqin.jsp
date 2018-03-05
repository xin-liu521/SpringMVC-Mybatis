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
                <div class="row panel panel-default">
                    <h3 class="text-center" style="color: red;">今日考勤</h3>
                    <div style="margin: auto 8%;color: #c4c4c4">考勤日期：<span id="todayDate"></span></div>
                    <ul id="myTab" class="nav nav-tabs"  style="margin: auto 8%;">
                        <li >
                            <a  href="${pageContext.request.contextPath}/kaoqinAction_movePageQuerykq.action">早餐班</a>
                        </li>
                        <li class="active" >
                            <a href="#">正常班</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/kaoqinAction_movePageYxkq.action">夜宵班 </a>
                        </li>
                    </ul>
                    <div class="Jhds">
                        <input checked class="radio" type="radio" name="Jhds" id="Jhds1">
                        <input class="radio" type="radio" name="Jhds" id="Jhds2">
                        <div class="tab-title">
                            <label for="Jhds1">未考勤</label>
                            <label for="Jhds2">已考勤</label>
                        </div>
                        <div class="tab-outer">
                            <%--未考勤--%>
                            <ul class="tab-inner">
                                <div class="panel-group" style="margin: auto 8%;">
                                    <!-- 未考勤 -->
                                    <div class="panel-group" id="accordion0">
                                        <div class="panel">
                                            <h4 class="panel-title">
                                                <table class="table" style="margin: 0;padding: 0;">
                                                    <tr>
                                                        <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                        <c:if test="${worker.btstate == 0}">
                                                        <c:set var="index" value="${index+1}"/>
                                                        <td class="text-center" style="width: 25%;" value="${index}">
                                                            <input type="hidden" id="id" name="id" value="${worker.id}"/>
                                                            <input type="hidden" id="state" name="state" value="${worker.state}"/>
                                                            <strong class="btn1 btn-group-xs" style="width: 8.5rem;padding: 5px;" onclick="clickObj(this)" >${worker.name}</strong>
                                                        </td>
                                                        <c:if test="${index%4 == 0}">
                                                    </tr><tr>
                                                    </c:if>
                                                    </c:if>
                                                    </c:forEach>
                                                </tr>
                                                </table>
                                            </h4>
                                            <button type="button" class="btn btn-info btn-sm"  onclick="cqClick(1);">出勤</button>
                                            <button type="button" class="btn btn-sm"  onclick="cqClick(4);" style="background: #498fee; color: white;">调休</button>
                                            <button type="button" class="btn btn-info btn-sm"  onclick="cqClick(5);">迟到</button>
                                            <button type="button" class="btn btn-sm"  onclick="cqClick(6);" style="background: #498fee; color: white;">事假</button>
                                            <button type="button" class="btn btn-info btn-sm"  onclick="cqClick(7);">病假</button>
                                            <button type="button" class="btn btn-sm"  onclick="cqClick(8);" style="background: #498fee; color: white;">旷工</button>
                                            <button type="button" class="btn btn-info btn-sm"  onclick="cqClick(9);">其他</button>
                                        </div>
                                    </div>
                                </div>
                            </ul>
                            <%--已考勤--%>
                            <ul class="tab-inner">
                                <div class="panel-group" id="accordion" style="margin: auto 8%;">
                                    <!-- 已考勤 -->
                                    <div class="panel panel-default">
                                        <h4 class="panel-title">
                                            <div class="col-xs-10"><h5>出勤人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 1}">
                                                    <c:set var="index1" value="${index1+1}"/>
                                                    <td class="text-center" style="width: 25%;" value="${index1}">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index1%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>
                                            </table>
                                            <div class="col-xs-10"><h5>调休人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 4}">
                                                    <c:set var="index2" value="${index2+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index2%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>
                                            </table>
                                            <div class="col-xs-10"><h5>迟到人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 5}">
                                                    <c:set var="index3" value="${index3+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index3%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>

                                            </table>
                                            <div class="col-xs-10"><h5>事假人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 6}">
                                                    <c:set var="index4" value="${index4+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index4%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>

                                            </table>
                                            <div class="col-xs-10"><h5>病假人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 7}">
                                                    <c:set var="index5" value="${index5+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index5%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>
                                            </table>
                                            <div class="col-xs-10"><h5>旷工人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 8}">
                                                    <c:set var="index6" value="${index6+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index6%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>
                                            </table>
                                            <div class="col-xs-10"><h5>其他人员：</h5></div>
                                            <table class="table table-bordered" style="margin: 0;padding: 0;">
                                                <tr>
                                                    <c:forEach items="${workerList}" var="worker" varStatus="status">
                                                    <c:if test="${worker.btstate == 9}">
                                                    <c:set var="index7" value="${index7+1}"/>
                                                    <td class="text-center" style="width: 25%;">
                                                        <strong class="btn-group-xs" style="width: 8.5rem;padding: 5px;">${worker.name}</strong>
                                                    </td>
                                                    <c:if test="${index7%4 == 0}">
                                                </tr><tr>
                                                </c:if>
                                                </c:if>
                                                </c:forEach>
                                            </tr>
                                            </table>
                                        </h4>
                                    </div>
                                </div>
                            </ul>
                        </div>
                    </div>
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

<script src="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.js"></script>

<script src="${pageContext.request.contextPath }/js/movejs/plugins.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/app.js"></script>

<!-- Load and execute javascript code used only in this page -->
<script src="${pageContext.request.contextPath }/js/movejs/pages/readyDashboard.js"></script>
</html>
<script>
    $('.btn1').click(function(){
        $(this).toggleClass('changeColor');
    });

    /**
     * @desc 选中和取消事件
     * @type {Array}
     */
    var idList = new Array();
    function clickObj(elem) {
        var parentElem=elem.parentNode;//获取节点对象
        var flag = $(elem).hasClass("changeColor");//判断样式是否存在
        var id = $(parentElem).find("input")[0].value;//获取数据的id
        if (!flag) {
            if (id != null) {
                idList.push(id);
            }
        }else {
            $.each(idList, function(index, value){
                if (value == id) {
                    idList.splice(index, 1);
                }
            });
        }
    };

    //考勤
    function cqClick(flag) {
        if (idList.length == 0) {
            Command: toastr["error"]("请选择骑手");
            return;
        }
        $.ajax({
            url : "kaoqinAction_submits.action",
            data : {
                entities : JSON.stringify(idList),
                state : flag,
                flag : 2
            },
            type : "post",
            dataType : "json",
            success : function(result) {
                if (result.success) {
                    Command: toastr["success"]("操作成功");
                    setTimeout(function(){
                        window.location.reload();
                        //$("#tableDiv").load("zkaoqin_list.jsp");
                    }, 500);
                }
            },
            error : function() {
                Command: toastr["error"]("系统异常，请联系管理员");
            }
        });
    }


    function show1(){
        document.getElementById("accordion0").style.display="block";
        document.getElementById("accordion1").style.display="none";
        // window.location.reload();
    };
    function show2()
    {
        document.getElementById("accordion1").style.display="block";
        document.getElementById("accordion0").style.display="none";
        //window.location.reload();
    }

    /**
     * @desc 获取当前时间
     */
    function showTime(){
        var nowTime=new Date();
        var year=nowTime.getFullYear();
        var month=nowTime.getMonth()+1;
        var date=nowTime.getDate();
        $("#todayDate").html(year+"年"+month+"月"+date+"日 "+nowTime.toLocaleTimeString());
    }

    setInterval("showTime()",1000);
</script>