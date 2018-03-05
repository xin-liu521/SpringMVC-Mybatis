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
</head>
<!-- END HEAD -->
<style>
    .page-content-wrapper .page-content{
        margin-left: 0;
    }

    .second {
        text-align:center;
    }
    .row{
        display: flex;
        align-content: center;
        align-items: center;
        justify-content: space-between;
    }
</style>
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
                        <div class="col-lg-3" >
                            <c:choose>
                                <c:when test="${byApproveBase != null && !''.equals(byApproveBase)}">
                                    <c:if test="${byApproveBase.companyType == 0 && byApproveBase.status == 1}">
                                        <a class="dashboard-stat dashboard-stat-v2 blue" href="${pageContext.request.contextPath}/approveBase/clientCheckPendingPage">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(认证中)</div>
                                                <div class="desc"> 客户认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                    <c:if test="${byApproveBase.companyType == 0 && byApproveBase.status == 2}">
                                        <a class="dashboard-stat dashboard-stat-v2 blue" href="${pageContext.request.contextPath}/approveBase/clientApproveResultPage?id=${byApproveBase.id}">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(已认证)</div>
                                                <div class="desc"> 客户认证 </div>
                                            </div>
                                        </a>
                                        <button type="button" class="btn blue" onclick="clientDetails(${byApproveBase.id});">查看信息</button>
                                        <button type="button" class="btn blue" onclick="clientUpdateDetails(${byApproveBase.id})">更新信息</button>
                                    </c:if>
                                    <c:if test="${byApproveBase.companyType == 0 && byApproveBase.status == 3}">
                                        <a class="dashboard-stat dashboard-stat-v2 blue" href="${pageContext.request.contextPath}/approveBase/clientApproveResultPage?id=${byApproveBase.id}">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(认证失败)</div>
                                                <div class="desc"> 客户认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                    <c:if test="${byApproveBase.status == null || byApproveBase.status == 0}">
                                        <a class="dashboard-stat dashboard-stat-v2 blue" href="${pageContext.request.contextPath}/approveBase/clientApproveBasePage">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">（未认证）</div>
                                                <div class="desc"> 客户认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <a class="dashboard-stat dashboard-stat-v2 blue" href="${pageContext.request.contextPath}/approveBase/clientApproveBasePage">
                                        <div class="visual">
                                            <i class="fa fa-comments"></i>
                                        </div>
                                        <div class="details">
                                            <div class="number">（未认证）</div>
                                            <div class="desc"> 客户认证 </div>
                                        </div>
                                    </a>
                                </c:otherwise>
                            </c:choose>


                        </div>


                        <div class="col-lg-3 col-xs-12 col-sm-12">
                            <c:choose>
                                <c:when test="${byApproveBase != null && !''.equals(byApproveBase)}">
                                    <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus == 1}">
                                        <a class="dashboard-stat dashboard-stat-v2 red" href="${pageContext.request.contextPath}/approveBase/clientCheckPendingPage">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(认证中)</div>
                                                <div class="desc"> 供应商认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                    <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus == 2}">
                                        <a class="dashboard-stat dashboard-stat-v2 red" href="${pageContext.request.contextPath}/approveBase/supplierApproveResultPage?id=${byApproveBase.id}">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(已认证)</div>
                                                <div class="desc"> 供应商认证 </div>
                                            </div>
                                        </a>
                                        <button type="button" class="btn blue" onclick="supplierDetails(${byApproveBase.id});">查看信息</button>
                                        <button type="button" class="btn blue" onclick="supplierUpdateDetails(${byApproveBase.id})">更新信息</button>
                                    </c:if>
                                    <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus == 3}">
                                        <a class="dashboard-stat dashboard-stat-v2 red" href="${pageContext.request.contextPath}/approveBase/supplierApproveResultPage?id=${byApproveBase.id}">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">(认证失败)</div>
                                                <div class="desc"> 供应商认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                    <c:if test="${byApproveBase.supplierStatus == 0 || byApproveBase.supplierStatus == null}">
                                        <a class="dashboard-stat dashboard-stat-v2 red" href="${pageContext.request.contextPath}/approveBase/supplierApproveBasePage">
                                            <div class="visual">
                                                <i class="fa fa-comments"></i>
                                            </div>
                                            <div class="details">
                                                <div class="number">（未认证）</div>
                                                <div class="desc"> 供应商认证 </div>
                                            </div>
                                        </a>
                                    </c:if>
                                </c:when>
                                <c:otherwise>
                                    <a class="dashboard-stat dashboard-stat-v2 red" href="${pageContext.request.contextPath}/approveBase/supplierApproveBasePage">
                                        <div class="visual">
                                            <i class="fa fa-comments"></i>
                                        </div>
                                        <div class="details">
                                            <div class="number">（未认证）</div>
                                            <div class="desc"> 供应商认证 </div>
                                        </div>
                                    </a>
                                </c:otherwise>
                            </c:choose>


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

<script>
    //供应商查看信息
    function supplierDetails(id) {
        window.location.href= "${pageContext.request.contextPath}/approveBase/supplierDetail?id="+id;
    }
    //供应商更新信息
    function supplierUpdateDetails(id) {
        window.location.href= "${pageContext.request.contextPath}/approveBase/supplierApproveBasePage?id="+id;
    }
    //客户查看信息
    function clientDetails(id) {
        window.location.href= "${pageContext.request.contextPath}/approveBase/clientDetail?id="+id;
    }
    //客户更新信息
    function clientUpdateDetails(id) {
        window.location.href= "${pageContext.request.contextPath}/approveBase/clientApproveBasePage?id="+id;
    }

</script>

