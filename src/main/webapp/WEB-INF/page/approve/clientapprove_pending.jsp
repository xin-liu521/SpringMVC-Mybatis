<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title>优百信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="reportdfdfds" name="description" />
    <meta content="" name="author" />
    <%@include file="/WEB-INF/common/css_js_link.jsp"%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/jquery-ui-1.12.1/jquery-ui.css">
    <style>
        .check{
            color: #fff;
            background-color: #337ab7 !important;
            padding: 10px 15px;
        }
        p {
            text-align:center;
        }

        .second {
            text-align:center;
        }
        .page-content-wrapper .page-content{
            margin-left: 0;
        }
        .step{
            color: #fff;
            background-color:#c0c0c0;
            padding: 10px 15px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/assets/jquery-ui-1.12.1/jquery-ui.js"></script>

</head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
<div class="page-wrapper">
    <!-- BEGIN HEADER -->
    <div class="page-header navbar navbar-fixed-top">
        <!-- BEGIN HEADER INNER -->
        <%@include file="/WEB-INF/common/header.jsp"%>
        <!-- END HEADER INNER -->
    </div>
    <!-- END HEADER -->
    <!-- BEGIN HEADER & CONTENT DIVIDER -->
    <div class="clearfix"> </div>
    <!-- END HEADER & CONTENT DIVIDER -->

    <!-- BEGIN CONTAINER -->
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar-wrapper">
            <%--<%@include file="/WEB-INF/common/left_menu.jsp"%>--%>
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <!-- BEGIN CONTENT BODY -->
            <div class="page-content">
                <!-- BEGIN PAGE HEADER-->

                <!-- BEGIN PAGE BAR  面包屑导航-->
                <div class="page-bar">
                    <ul class="page-breadcrumb">

                    </ul>

                </div>
                <!-- END PAGE BAR -->


                <!--中间内容页-->
                <div class="row">
                    <ul class="nav nav-pills nav-justified steps">
                        <li>
                            <p class="step">
                                <span class="number"> 1 </span>
                                <span class="desc"><i class="fa fa-check"></i>提交审核</span>
                            </p>
                        </li>
                        <li>
                            <p  class="step check" >
                                <span class="number"> 2 </span>
                                <span class="desc"><i class="fa fa-check"></i>等待审核</span>
                            </p>
                        </li>
                        <li>
                            <p  class="step">
                                <span class="number"> 3 </span>
                                <span class="desc"><i class="fa fa-check"></i>审核结果</span>
                            </p>
                        </li>

                    </ul>
                    <div id="bar" class="progress progress-striped" role="progressbar">
                        <div class="progress-bar progress-bar-success"> </div>
                    </div>

                    <div class="second">
                        <h4 ></h4>
                        <h5 ></h5>
                        <div>
                            <img src="${pageContext.request.contextPath}/assets/global/img/shalouicon.png" />
                            <h1>正在审核中。。。</h1>
                            <a href="${pageContext.request.contextPath}/index">
                                <h3>我知道了</h3>
                            </a>
                        </div>
                    </div>
                </div>
                <!--中间内容页-->
            </div>
            <!-- END CONTENT BODY -->
        </div>
        <!-- END CONTENT -->

    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
    <%@include file="/WEB-INF/common/fotter.jsp"%>
    <!-- END FOOTER -->
</div>
</body>
</html>



