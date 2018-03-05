<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/global/plugins/webuploader/webuploader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/jquery-ui-1.12.1/jquery-ui.css">
    <style>
        .check{
            color: #fff;
            background-color: #337ab7 !important;
            padding: 10px 15px;
        }
        p{text-align:center;}
        .process {
            background: #7f7f7f;
        }

        .page-content-wrapper .page-content{
            margin-left: 0;
        }
        body{
            background-color: #ffffff;
        }

        li {
            list-style-type:none;
        }
        .fontcolor {
           color: #ffffff;
        }
        .jz{
            font-size: 20px;
            height: 50px;
            text-align: center;
        }
        .aLike {
            display:block;width:200px;height:30px;
        }
        .step{
            color: #fff;
            background-color:#c0c0c0;
            padding: 10px 15px;
        }
        .ui-autocomplete {
            max-height: 100px;
            overflow-y: auto;
            /* 防止水平滚动条 */
            overflow-x: hidden;
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
                            <p class="step check">
                                <span class="number"> 1 </span>
                                <span class="desc"><i class="fa fa-check"></i>提交审核</span>
                            </p>
                        </li>
                        <li>
                            <p  class="step" >
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
                    <div class="col-xs-2">
                        <div  style="height: 300px; width: 200px;">
                            <div class="jz">
                                <a href="#tab_1" class="btn blue mt-clipboard aLike">基本信息</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_2" class="btn blue mt-clipboard aLike" >联系方式</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_4" class="btn blue mt-clipboard aLike" >产品说明</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_3" class="btn blue mt-clipboard aLike" >银行信息</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_5" class="btn blue mt-clipboard aLike" >客户资质</a>
                            </div>
                        </div>
                        <button type="button" class="btn blue" onclick="saveApproveBase(0);">保存</button>
                        <button type="button" class="btn blue" onclick="referApproveBase(1);">提交</button>
                        <button type="button" class="btn red" onclick="cancelApproveBase();">关闭</button>
                    </div>
                    <div class="col-xs-10 "  style="position:absolute; left:17%;height:100%; overflow:auto">
                        <form  class="horizontal-form" id="baseForm">
                            <input hidden="hidden" id="id" name="id" value="${byApproveBase.id}"/>
                        <div class="tab-pane" id="tab_1">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">基本信息 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <%--<form  class="horizontal-form" id="baseForm">--%>
                                        <div class="form-body">
                                            <%--<h3 class="form-section">Person Info</h3>--%>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">单位全称<span style="color:red">*</span></label>
                                                        <input type="text" name="companyFullName" id="companyFullName" class="form-control" value="${byApproveBase.companyFullName}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0}">readonly</c:if>   placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">英文全称</label>
                                                        <input type="text" name="companyFullEg" id="companyFullEg" class="form-control" value="${byApproveBase.companyFullEg}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if>  placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">单位简称</label>
                                                        <input type="text" name="companyShortName" id="companyShortName" class="form-control" value="${byApproveBase.companyShortName}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/row-->
                                            <div class="row">

                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">英文简称</label>
                                                        <input type="text" name="companyShortEg" id="companyShortEg" class="form-control" value="${byApproveBase.companyShortEg}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">所属地区<span style="color:red">*</span></label>
                                                        <input type="hidden" name="area" id="area" class="form-control" value="${byApproveBase.area}" placeholder="">
                                                        <input type="text" name="areaName" id="areaName" class="form-control" value="${byApproveBase.areaName}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="请输入关键字，例如：西安">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">法人<span style="color:red">*</span></label>
                                                        <input type="text" name="legalPerson" id="legalPerson" class="form-control" value="${byApproveBase.legalPerson}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="row">
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label" style="font-weight: bold">是否三证合一</label>
                                                            <label class="radio-inline">
                                                                <input type="radio" name="isUnity" id="isUnity1" value="0" <c:if test="${byApproveBase.isUnity == null || byApproveBase.isUnity == 0}">checked</c:if>
                                                                       <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus != 0 }">disabled</c:if> />是
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input type="radio" name="isUnity" id="isUnity2" value="1" <c:if test="${byApproveBase.isUnity == 1}">checked</c:if>
                                                                       <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0 }">disabled</c:if> />否
                                                            </label>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <div class="row" id="div1">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">社会信用代码<span style="color:red">*</span></label>
                                                        <input type="text" name="socialCreditCode" id="socialCreditCode" class="form-control" value="${byApproveBase.socialCreditCode}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="row" style="display:none;" id="div2">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">营业执照号<span style="color:red">*</span></label>
                                                        <input type="text" name="licenseNumber" id="licenseNumber" class="form-control" value="${byApproveBase.licenseNumber}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">组织机构代码证号<span style="color:red">*</span></label>
                                                        <input type="text" name="organizationCodeNumber" id="organizationCodeNumber" class="form-control" value="${byApproveBase.organizationCodeNumber}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">税务登记证号<span style="color:red">*</span></label>
                                                        <input type="text" name="taxNumber" id="taxNumber" class="form-control" value="${byApproveBase.taxNumber}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/row-->
                                            <div class="row">

                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">注册资金（万元）<span style="color:red">*</span></label>
                                                        <input type="text" name="fund" id="fund" class="form-control" value="${byApproveBase.fund}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0}">readonly</c:if>  placeholder="单位：万元">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">经济类型<span style="color:red">*</span></label>
                                                        <input id="economicsType" name="economicsType" value="${byApproveBase.economicsType}" type="hidden" value="" />
                                                        <input id="economicsTypeName" name="economicsTypeName" type="text" readonly class="form-control"
                                                               onclick="autoMatch();" value="${byApproveBase.economicsTypeName}" placeholder="请选择" style="width: 325px;"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">disabled</c:if>/>
                                                    </div>
                                                    <div id="menuContent" class="menuContent" style="display: none;overflow:auto; position: absolute;background: #fff;border:1px solid #ccc;">
                                                        <ul id="treeDemo" class="ztree" style="margin-top: 0; width: 320px;height:100px;">
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">成立日期</label>
                                                        <input name="createRegTime" id="createRegTime" type="text" readonly
                                                               value="<fmt:formatDate value='${byApproveBase.createRegTime}' pattern="yyyy-MM-dd"/>"
                                                               class="form-control datetimepicker" <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus !=0}">disabled</c:if> placeholder="请选择日期">
                                                        <%--<input type="text" name="createRegTime" id="createRegTime" class="form-control" placeholder="Chee Kin">--%>
                                                    </div>

                                                </div>
                                                <!--/span-->
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">资金币种</label>
                                                        <%--<input type="text" name="currencyType" names="currencyType" value="${bank.currencyType}" class="form-control" placeholder="">--%>
                                                        <select class="form-control" id="currency" names="currency" name="currency" value="${byApproveBase.currency}">
                                                            <option value="" style="display: none">请选择</option>
                                                            <option value="0" <c:if test="${byApproveBase.currency == 0}">selected</c:if>>人民币</option>
                                                            <option value="1" <c:if test="${byApproveBase.currency == 1}">selected</c:if>>美元</option>
                                                            <option value="2" <c:if test="${byApproveBase.currency == 2}">selected</c:if>>欧元</option>
                                                            <option value="3" <c:if test="${byApproveBase.currency == 3}">selected</c:if>>港币</option>
                                                            <option value="4" <c:if test="${byApproveBase.currency == 4}">selected</c:if>>英镑</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    <%--</form>--%>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>
                        <!--基本信息div  end-->
                        <!--联系方式div  start-->
                        <div class="tab-pane" id="tab_2">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">联系方式 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <%--<form  class="horizontal-form" id="">--%>
                                        <div class="form-body">
                                            <%--<h3 class="form-section">Person Info</h3>--%>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">通讯地址<span style="color:red">*</span></label>
                                                        <input type="text" id="address" name="address" class="form-control" value="${byApproveBase.address}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">联系人<span style="color:red">*</span></label>
                                                        <input type="text" id="contact" name="contact" class="form-control" required="required" value="${byApproveBase.contact}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus!= 0 }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">联系人手机号<span style="color:red">*</span></label>
                                                        <input type="text" id="contactPhone" name="contactPhone" class="form-control" required="required" value="${byApproveBase.contactPhone}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus!= 0 }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <!--/span-->
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Email地址<span style="color:red">*</span></label>
                                                        <input type="text" id="email" name="email" class="form-control" value="${byApproveBase.email}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder=""> </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">邮编</label>
                                                        <input type="text" id="postcode" name="postcode" class="form-control" value="${byApproveBase.postcode}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">公司电话</label>
                                                        <input type="text" id="phone" name="phone" class="form-control" value="${byApproveBase.phone}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                                }">readonly</c:if> placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">公司传真</label>
                                                        <input type="text" id="fax" name="fax" class="form-control" value="${byApproveBase.fax}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1  && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder=""> </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Web地址</label>
                                                        <input type="text" id="webAddress" name="webAddress" class="form-control" value="${byApproveBase.webAddress}"
                                                               <c:if test="${byApproveBase.companySupplierType == 1 && byApproveBase.supplierStatus != 0
                                                               }">readonly</c:if> placeholder=""> </div>
                                                </div>
                                            </div>

                                        </div>
                                    <%--</form>--%>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>
                        </form>
                        <!--联系方式div  end-->

                        <div class="tab-pane" id="tab_4">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">产品说明 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <form  class="horizontal-form" id="productForm">
                                        <div class="form-body">
                                            <c:set var="prIndex" value="0"/>
                                            <c:choose>
                                                <c:when test="${byProducts != null && byProducts.size() > 0}">
                                                    <c:forEach items="${byProducts}" var="product" varStatus="i" begin="0" end="${byProducts.size()}" step="1">
                                                        <c:set var="prIndex" value="${prIndex+1}"/>
                                                        <div class="row" >
                                                            <input type="hidden" name="productId" value="${product.id}"/>
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label class="control-label">客户产品分类<span style="color:red">*</span></label>
                                                                    <%--<input type="hidden" name="productTypes_${prIndex}" id="productTypes_${prIndex}"  names="productType"  value="${product.productType}" class="form-control pType" placeholder="">--%>
                                                                    <%--<input type="text" name="productTypeNames_${prIndex}" id="productTypeNames_${prIndex}"  names="productTypeName"  value="${product.productTypeName}"  class="form-control" placeholder="请输入关键字，例如：XX产品">--%>
                                                                    <select class="form-control" id="productTypes_${prIndex}" name="productTypes_${prIndex}" names="productType" style="overflow:auto;">
                                                                        <option value="">请选择</option>
                                                                        <c:forEach items="${wullbList}" var="wllb" varStatus="status" >
                                                                            <option value="${wllb.lbbmId}" <c:if test="${wllb.lbbmId == product.productType}">selected</c:if> >${wllb.lbmc}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <c:if test="${i.count != 1}">
                                                                <div  style="padding-top: 25px;">
                                                                    <button type="button" class="btn red" onclick="deleteProductDiv(this);">删除</button>
                                                                </div>
                                                            </c:if>

                                                        </div>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="row" >
                                                        <input hidden="hidden" name="productId"/>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label class="control-label">客户产品分类<span style="color:red">*</span></label>
                                                                <%--<input type="hidden" id="productTypes" name="productTypes" names="productType" class="form-control pType" placeholder="">--%>
                                                                <%--<input type="text" id="productTypeNames" name="productTypeName" names="productTypeName" class="form-control" placeholder="请输入关键字，例如：XX产品">--%>
                                                                <select class="form-control" id="productTypes" name="productTypes" names="productType">
                                                                    <option value="">请选择</option>
                                                                    <c:forEach items="${wullbList}" var="wllb" varStatus="status" >
                                                                        <option value="${wllb.lbbmId}">${wllb.lbmc}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                            <!--/row-->
                                        </div>
                                        <div class="form-actions left">
                                            <button type="button" class="btn blue" onclick="productDiv();">添加产品</button>
                                        </div>
                                    </form>
                                    <script>
                                        var prIndex = ${prIndex};
                                    </script>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane" id="tab_3">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">银行信息 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <form  class="horizontal-form" id="bankForm">
                                        <div class="form-body">
                                            <c:set var="bakIndex" value="0"/>
                                            <c:choose>
                                                <c:when test="${byBanks != null && byBanks.size() > 0}">
                                                    <c:forEach items="${byBanks}" var="bank" varStatus="i" begin="0" end="${byBanks.size()}" step="1">
                                                        <c:set var="bakIndex" value="${bakIndex+1}"/>
                                                        <div>
                                                            <input type="hidden" name="bankId" value="${bank.id}"/>
                                                            <hr style="stroke-width: 100%;background-color: blue;height: 1px;">
                                                            <div class="row">
                                                                <c:if test="${bank.isBaseAccount == 1}">
                                                                    <input name="isBaseAccount" names="isBaseAccount" type="hidden" value="1" />
                                                                </c:if>
                                                                <c:if test="${bank.isBaseAccount == 0}">
                                                                    <div class="col-md-4">
                                                                        <div class="form-group">
                                                                            <label class="control-label" style="font-weight:bold;color: red;">银行基本账户</label>
                                                                            <input name="isBaseAccount" names="isBaseAccount" type="hidden" value="0" />
                                                                        </div>
                                                                    </div>
                                                                </c:if>

                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label" style="font-weight:bold">是否电子承兑账号</label>
                                                                        <label><input name="isElectronAccountOne_${bakIndex}" names="isElectronAccounts" type="radio" value="0"
                                                                                      <c:if test="${bank.isElectronAccount == 0}">checked</c:if> onclick="electChange(this);" />是</label>
                                                                        <label><input name="isElectronAccountOne_${bakIndex}" names="isElectronAccounts"  type="radio" value="1"
                                                                                      <c:if test="${bank.isElectronAccount == 1}">checked</c:if> onclick="electChange(this);" />否</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label" style="font-weight:bold">账号性质</label>
                                                                        <label><input name="accountPropertiesOne_${bakIndex}" names="accountProperties" type="radio" value="0"
                                                                                      <c:if test="${bank.accountProperties == 0}">checked</c:if>
                                                                                      <c:if test="${bank.isBaseAccount == 0}">disabled</c:if> />个人账号</label>
                                                                        <label><input name="accountPropertiesOne_${bakIndex}" names="accountProperties"  type="radio" value="1"
                                                                                      <c:if test="${bank.accountProperties == 1}">checked</c:if>
                                                                                      <c:if test="${bank.isBaseAccount == 0}">disabled</c:if> />单位账号</label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">账户名称<span style="color:red">*</span></label>
                                                                        <input type="text" id="bankAccountNameOne_${bakIndex}" name="bankAccountNameOne_${bakIndex}" names="bankAccountName" value="${bank.bankAccountName}" class="form-control" placeholder="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4 account" id="yhDiv_${bakIndex}">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行账号<span style="color:red">*</span></label>
                                                                        <input type="text" id="bankAccountOne_${bakIndex}" name="bankAccountOne_${bakIndex}" names="bankAccount" class="form-control inputaccoun"
                                                                               <c:if test="${bank.isElectronAccount == 1}">value="${bank.bankAccount}"</c:if> placeholder=""/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4 electron" style="display: none" id="dzDiv_${bakIndex}">
                                                                    <div class="form-group">
                                                                        <label class="control-label">电子银行承兑账号<span style="color:red">*</span></label>
                                                                        <input type="text" id="electronAccountOne_${bakIndex}" name="electronAccountOne_${bakIndex}" names="electronAccount" class="form-control elecinput"
                                                                               <c:if test="${bank.isElectronAccount == 0}">value="${bank.bankAccount}"</c:if> placeholder=""/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行类别<span style="color:red">*</span></label>
                                                                        <input type="hidden" id="bankTypeOne_${bakIndex}" name="bankTypeOne_${bakIndex}" names="bankType"
                                                                               class="form-control bankType" placeholder=""
                                                                               value="${bank.bankType}"  onchange="bankTypes(this);">
                                                                        <input type="text" id="bankTypeNameOne_${bakIndex}" name="bankTypeNameOne_${bakIndex}" names="bankTypeName" class="form-control "
                                                                               value="${bank.bankTypeName}"  placeholder="请输入关键字，例如：工商">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">

                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">开户银行<span style="color:red">*</span></label>
                                                                        <%--<select class="form-control depBank" id="depositBankOne_${bakIndex}"--%>
                                                                                <%--onchange="depositBankCh(this);" name="depositBankOne_${bakIndex}" names="depositBank">--%>
                                                                            <%--<option value="">请选择</option>--%>
                                                                            <%--<c:forEach items="${bank.sysCodeList}" var="sysCode">--%>
                                                                                <%--<option value="${sysCode.banCode}" <c:if test="${sysCode.bankCode == bank.depositBank}">selected</c:if>>${sysCode.bankName}</option>--%>
                                                                            <%--</c:forEach>--%>

                                                                        <%--</select>--%>
                                                                        <input type="hidden" id="bankTypeTwo_${bakIndex}" name="bankTypeTwo_${bakIndex}" value="${bank.bankType}" class="form-control bankTY"/>

                                                                        <input type="hidden" id="depositBankOne_${bakIndex}" name="depositBankOne_${bakIndex}" names="depositBank"
                                                                               class="form-control bankKhg" placeholder="" value="${bank.depositBank}" >
                                                                        <input type="text" id="depositBankNameOne_${bakIndex}" name="depositBankNameOne_${bakIndex}" names="depositBankName" class="form-control bankKhgName"
                                                                               value="${bank.depositBankName}" placeholder="请输入关键字，例如：西安支行">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">联行号<span style="color:red">*</span></label>
                                                                        <input type="text" id="associatedNumberOne_${bakIndex}" name="associatedNumberOne_${bakIndex}"
                                                                               readonly names="associatedNumber" value="${bank.associatedNumber}" class="form-control associated" placeholder="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行国家<span style="color:red">*</span></label>
                                                                        <input type="text" id="bankCountryOne_${bakIndex}" name="bankCountryOne_${bakIndex}" names="bankCountry" value="${bank.bankCountry}" class="form-control" placeholder="">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">其他开户行</label>
                                                                        <input type="text" name="otherBank" names="otherBank" value="${bank.otherBank}" class="form-control" placeholder="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">币种</label>
                                                                            <%--<input type="text" name="currencyType" names="currencyType" value="${bank.currencyType}" class="form-control" placeholder="">--%>
                                                                        <select class="form-control" id="currencyType" names="currencyType" name="currencyType" value="${bank.currencyType}">
                                                                            <option value="" style="display: none">请选择</option>
                                                                            <option value="0" <c:if test="${bank.currencyType == 0}">selected</c:if>>人民币</option>
                                                                            <option value="1" <c:if test="${bank.currencyType == 1}">selected</c:if>>美元</option>
                                                                            <option value="2" <c:if test="${bank.currencyType == 2}">selected</c:if>>欧元</option>
                                                                            <option value="3" <c:if test="${bank.currencyType == 3}">selected</c:if>>港币</option>
                                                                            <option value="4" <c:if test="${bank.currencyType == 4}">selected</c:if>>英镑</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <c:if test="${i.count != 1}">
                                                                <div>
                                                                    <button type="button" class="btn red"  onclick="deleteBankDiv(this);">删除</button>
                                                                </div>
                                                            </c:if>

                                                        </div>

                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="row">
                                                        <input hidden="hidden" name="bankId"/>
                                                        <div class="col-md-4">
                                                            <div class="form-group">

                                                                <label class="control-label" style="font-weight:bold;color: red;">银行基本账户</label>
                                                                <input name="isBaseAccount" names="isBaseAccount" type="hidden" value="0" />
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label" style="font-weight:bold">是否电子承兑账号</label>
                                                                <label><input name="isElectronAccount" names="isElectronAccounts" type="radio" value="0"
                                                                               onclick="electChange(this);" />是</label>
                                                                <label><input name="isElectronAccount" names="isElectronAccounts"  type="radio" value="1"
                                                                              onclick="electChange(this);" checked />否</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label" style="font-weight:bold">账号性质</label>
                                                                <label><input names="accountProperties" name="accountProperties" type="radio" value="0" disabled>个人账号</label>
                                                                <label><input names="accountProperties" name="accountProperties" disabled type="radio" value="1" checked>单位账号</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">账户名称<span style="color:red">*</span></label>
                                                                <input type="text" name="bankAccountName" names="bankAccountName" class="form-control" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4 account" name="yhDiv">
                                                            <div class="form-group">
                                                                <label class="control-label">银行账号<span style="color:red">*</span></label>
                                                                <input type="text" name="bankAccount" names="bankAccount" class="form-control inputaccoun"
                                                                       placeholder=""/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4 electron" style="display: none" name="dzDiv">
                                                            <div class="form-group">
                                                                <label class="control-label">电子银行承兑账号<span style="color:red">*</span></label>
                                                                <input type="text" name="electronAccount" names="electronAccount" class="form-control elecinput"
                                                                       placeholder=""/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">银行类别<span style="color:red">*</span></label>
                                                                <input type="hidden" id="bankTypeOne" name="bankTypeOne" names="bankType"
                                                                       class="form-control bankType" placeholder=""
                                                                       onchange="bankTypes(this);">
                                                                <input type="text" id="bankTypeNameOne" name="bankTypeName" names="bankTypeName" class="form-control" placeholder="请输入关键字，例如：工商银行">
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row">

                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">开户银行<span style="color:red">*</span></label>
                                                                <%--<select class="form-control depBank"  name="depositBank" names="depositBank" onchange="depositBankCh(this);">--%>
                                                                    <%--<option value="">请选择</option>--%>
                                                                <%--</select>--%>
                                                                <input type="hidden" id="bankTypeTwo" name="bankTypeTwo"/>
                                                                <input type="hidden" id="depositBankOne" name="depositBankOne" names="depositBank"
                                                                       class="form-control" placeholder="" >
                                                                <input type="text" id="depositBankNameOne" name="depositBankName" names="depositBankName" class="form-control "
                                                                        placeholder="请输入关键字，例如：西安支行">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">联行号<span style="color:red">*</span></label>
                                                                <input type="text" id="associatedNumber" name="associatedNumber" names="associatedNumber"
                                                                       readonly class="form-control associated" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">银行国家<span style="color:red">*</span></label>
                                                                <input type="text" name="bankCountry" names="bankCountry" class="form-control" value="中国">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">其他开户行</label>
                                                                <input type="text" name="otherBank" names="otherBank" class="form-control" placeholder="">
                                                            </div>
                                                        </div>

                                                        <div class="col-md-4">
                                                            <div class="form-group">
                                                                <label class="control-label">币种</label>
                                                                    <%--<input type="text" name="currencyType" names="currencyType"   class="form-control" placeholder="">--%>
                                                                <select class="form-control" id="currencyType" name="currencyType" names="currencyType">
                                                                    <option value="" style="display: none">请选择</option>
                                                                    <option value="0" <c:if test="${bank.currencyType == 0}">selected</c:if>>人民币</option>
                                                                    <option value="1" <c:if test="${bank.currencyType == 1}">selected</c:if>>美元</option>
                                                                    <option value="2" <c:if test="${bank.currencyType == 2}">selected</c:if>>欧元</option>
                                                                    <option value="3" <c:if test="${bank.currencyType == 3}">selected</c:if>>港币</option>
                                                                    <option value="4" <c:if test="${bank.currencyType == 4}">selected</c:if>>英镑</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <!--/row-->
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <script>
                                            var bakIndex = ${bakIndex};
                                        </script>
                                        <div class="form-actions left">
                                            <button type="button" class="btn blue" onclick="bankDiv();">添加银行账号</button>
                                        </div>
                                    </form>
                                </div>
                                    <!-- END FORM-->
                                </div>
                        </div>


                        <div class="tab-pane" id="tab_5">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">客户资质 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <form  class="horizontal-form" id="aptitudeForm">
                                        <div class="form-body">

                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group" style="font-weight:bold">
                                                        <%--<input type="checkbox" name="isChemical" id="isChemical"--%>
                                                               <%--<c:if test="${byApproveBase.isChemical == 0}">checked</c:if> onchange="showChemical(this)" value="0">是否危险化学品--%>

                                                        <label class="control-label" style="font-weight:bold">是否危险化学品</label>
                                                        <label><input names="isChemical" name="isChemical" type="radio" value="0"
                                                                      <c:if test="${byApproveBase.isChemical == 0}">checked</c:if> />是</label>
                                                        <label><input names="isChemical" name="isChemical" type="radio" value="1"
                                                                      <c:if test="${byApproveBase.isChemical == 1 || byApproveBase.isChemical == null}">checked</c:if> />否</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div id="uploader" class="wu-example">
                                                    <!--用来存放文件信息-->
                                                    <div id="thelist" class="uploader-list" >
                                                        <c:forEach items="${byDocList}" var="doc" varStatus="status">
                                                           <p id="${doc.id}" style="text-align: left">
                                                               <%--<img src='${doc.docUrl}'/>--%>
                                                               <span class="fileinfo" filename="${doc.docName}" fileurl="${doc.docUrl}">${doc.docName}</span>
                                                               <button type="button" class="btn red" onclick="deleteDoc(${doc.id},'${doc.docUrl}')">删除</button>
                                                           </p>
                                                        </c:forEach>
                                                    </div>
                                                    <div class="btns">
                                                        <div id="picker" class="col-xs-2">添加附件</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div>
                                                    <h8>
                                                        提示：请上传企业营业执照、开户许可证及法人身份证等有效证件的扫描件。<br/>（上传文件大小不能超过10M。
                                                        文件格式为图片或文档，其中图片格式包括：*.jpg，*.png，*.jpeg，*.gif.)
                                                    </h8>
                                                    <div id="chemical" style="color: red">
                                                        <h8>*必须上传危化品相关资质资质。</h8>
                                                    </div>

                                                </div>
                                            </div>
                                            <!--/row-->
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
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
    <%--<%@include file="/WEB-INF/common/fotter.jsp"%>--%>
    <!-- END FOOTER -->
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="true" data-width="600px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div style="text-align: center"><h4>操作正在进行中.......</h4></div>
                <div class="progress progress-striped active">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60"
                         aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/webuploader/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/approve/clientapprove_add.js"></script>
<script>

    var basePath = '${pageContext.request.contextPath}';
    var bankJsonList = '${byBanksJson}';
    var productJsonList = '${byProductsJson}';
    var docJsonList = '${byDocListJson}';
    var byApproveBase = '${byApproveBaseJson}';

    function cancelApproveBase () {
        window.location.href = "${pageContext.request.contextPath}/index"
    }

    //删除产品div
    var productIdList = new Array();
    function deleteProductDiv(elem) {
        var parentElem=elem.parentNode.parentNode;
        var productIds = $(parentElem).find("input")[0].value;//获取删除数据的id
        if (productIds != null && productIds != 0) {
            productIdList.push(productIds);
        }
        $(parentElem).remove();
    };

    //删除银行div
    var bankIdList = new Array();
    function deleteBankDiv(elem) {
        var parentElem=elem.parentNode.parentNode;
        var bankIds = $(parentElem).find("input")[0].value;//获取删除数据的id
        if (bankIds != null && bankIds != 0) {
            bankIdList.push(bankIds);
        }
        $(parentElem).remove();
    };

    //产品添加div
    var idx = 0;
    function productDiv () {
        idx++;
        console.log(idx);
        $("#productForm").find(".form-body").append(
                '<div class="row" dom="div_' + idx + '">' +
                '<input hidden="hidden" name="productId"/>'+
                '<div class="col-md-6">' +
                '<div class="form-group">' +
                '<label class="control-label">客户产品分类<span style="color:red">*</span></label>' +
//                '<input type="hidden" id="productType_' + idx + '" name="productType_' + idx + '"  names="productType" class="form-control pType" placeholder=""/>' +
//                '<input type="text" id="productTypeName_' + idx + '"  name="productTypeName_' + idx + '" names="productTypeName" class="form-control" placeholder="请输入关键字，例如：工字钢"/>' +
                '<select class="form-control" id="productType_' + idx + '" name="productType_' + idx + '" names="productType">' +
                '<option value="">请选择</option>'+
                <c:forEach items="${wullbList}" var="wllb" varStatus="status" >
                '<option value="${wllb.lbbmId}">${wllb.lbmc}</option>'+
                </c:forEach>
                '</select>'+
                '</div>' +
                '</div>' +
                '<div  style="padding-top: 25px;">' +
                '<button type="button" class="btn red" onclick="deleteProductDiv(this);">删除</button>'+
                '</div>'+
                '</div>'
        );
            $("#productType_" + idx).rules("add", {required:true});

        <%--//产品分类模糊搜索--%>
        <%--$("#productTypeName_" + idx).autocomplete({--%>
            <%--source:function( request, response ) {--%>
                <%--$.ajax({--%>
                    <%--url : "${pageContext.request.contextPath}/approveBase/selectByProductTypeName",--%>
                    <%--type : "post",--%>
                    <%--dataType : "json",--%>
                    <%--data : {--%>
                        <%--productTypeName: request.term,--%>
                        <%--flag : 0--%>
                    <%--},--%>

                    <%--success: function( data ) {--%>
                        <%--response( $.map( data.data, function( item ) {--%>
                            <%--return {--%>
                                <%--label: item.lbmc,// 下拉项显示内容--%>
                                <%--value: item.lbbmId // 下拉项对应数值--%>
                            <%--}--%>
                        <%--}));--%>
                    <%--}--%>
                <%--});--%>
            <%--},--%>
            <%--minLength: 1,  // 输入框字符个等于2时开始查询--%>
            <%--focus: function( event, ui ) {--%>
                <%--$(this).val( ui.item.label );--%>
                <%--return false;--%>
            <%--},--%>
            <%--select: function( event, ui ) {// 选中某项时执行的操作--%>
                <%--$(this).val( ui.item.label );--%>
                <%--$(this).parent().find(".pType").val( ui.item.value );--%>
                <%--return false;--%>
            <%--}--%>
        <%--});--%>

    }

    var bankIndex = 0;
    //银行添加div
    function bankDiv () {
        bankIndex++;
        $("#bankForm").find(".form-body").append(
                '<div >'+
                '<input hidden="hidden" name="bankId"/>'+
                '<input name="isBaseAccount" names="isBaseAccount" type="hidden" value="1" />'+
                '<hr style="stroke-width: 100%;background-color: blue;height: 1px;">'+
                '<div class="row">' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label" style="font-weight:bold">是否电子承兑账号</label>' +
                '<label><input name="isElectronAccount_'+bankIndex+'" names="isElectronAccounts" type="radio" value="0" onclick="electChange(this);" />是</label>' +
                '<label><input name="isElectronAccount_'+bankIndex+'" names="isElectronAccounts"  type="radio" value="1" checked onclick="electChange(this);" />否</label>'+
//                '<label class="control-label" style="font-weight:bold">' +
//                '<input type="checkbox" value="0" name="isElectronAccount" onchange="electChange(this);"/>是否电子承兑账号</label>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label" style="font-weight:bold">账号性质</label>' +
                '<label><input name="accountProperties_'+bankIndex+'" names="accountProperties" type="radio" value="0" checked>个人账号</label>' +
                '<label><input name="accountProperties_'+bankIndex+'" names="accountProperties" type="radio" value="1">单位账号</label></div></div>'+
               '</div>' +
               '<div class="row">' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label">账户名称<span style="color:red">*</span></label>' +
                '<input type="text" id="bankAccountName_'+bankIndex+'" name="bankAccountName_'+bankIndex+'" names="bankAccountName" class="form-control" placeholder="">' +
                '</div>' +
                '</div>' +
                '<div class="col-md-4 account" name="yhDiv">' +
                '<div class="form-group">' +
                '<label class="control-label">银行账号<span style="color:red">*</span></label>' +
                '<input type="text" id="bankAccount_'+bankIndex+'" name="bankAccount_'+bankIndex+'" names="bankAccount" class="form-control inputaccoun" placeholder=""> </div>' +
                '</div>' +
                '<div class="col-md-4 electron" style="display: none" name="dzDiv">' +
                '<div class="form-group">' +
                '<label class="control-label">电子银行承兑账号<span style="color:red">*</span></label>' +
                '<input type="text" name="electronAccount_'+bankIndex+'" id="electronAccount_'+bankIndex+'" names="electronAccount" class="form-control elecinput" placeholder=""/>' +
                '</div>' +
                '</div>' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label">银行类别<span style="color:red">*</span></label>' +
                '<input type="hidden" name="bankType_'+bankIndex+'" id="bankType_'+bankIndex+'" names="bankType" class="form-control bankType" placeholder="" onchange="bankTypeChange(this.value);">' +
                '<input type="text" name="bankTypeName_'+bankIndex+'" id="bankTypeName_'+bankIndex+'" names="bankTypeName" class="form-control" placeholder="请输入关键字，例如：工商银行">' +
                '</div>' +
                '</div>' +
                '</div>'+
               '<div class="row">' +
               '<div class="col-md-4">' +
               '<div class="form-group">' +
               '<label class="control-label">开户银行<span style="color:red">*</span></label>' +
//               '<select type="text" id="depositBank_'+bankIndex+'" name="depositBank_'+bankIndex+'" names="depositBank" class="form-control" onchange="depositCh(this.value);">' +
//                        '<option value="-1">请选择</option>'+
//                '</select>'+
                ' <input type="hidden" id="bankType_'+bankIndex+'" name="bankType_'+bankIndex+'" class="bankTY"/>' +
                '<input type="hidden" id="depositBank_'+bankIndex+'" name="depositBank_'+bankIndex+'" names="depositBank"' +
                'class="form-control bankKhg">' +
                '<input type="text" id="depositBankName_'+bankIndex+'" name="depositBankName_'+bankIndex+'" names="depositBankName" class="form-control bankKhgName"'+
                'placeholder="请输入关键字，例如：西安支行">'+
               '</div>' +
               '</div>' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label">联行号<span style="color:red">*</span></label>' +
                '<input type="text" name="associatedNumber_'+bankIndex+'" id="associatedNumber_'+bankIndex+'" names="associatedNumber" readonly class="form-control associated" placeholder="">' +
                '</div>' +
                '</div>' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label">银行国家<span style="color:red">*</span></label>' +
                '<input type="text"  name="bankCountry_'+bankIndex+'" id="bankCountry_'+bankIndex+'" names="bankCountry"  class="form-control" value="中国">' +
                '</div>' +
                '</div>' +
               '</div>' +
               '<div class="row">' +
                '<div class="col-md-4">' +
                '<div class="form-group">' +
                '<label class="control-label">其他开户行</label>' +
                '<input type="text" id="otherBank_'+bankIndex+'" name="otherBank_'+bankIndex+'" names="otherBank" class="form-control" placeholder="">' +
                '</div>' +
                ' </div>' +
               '<div class="col-md-4">' +
               '<div class="form-group">' +
               '<label class="control-label">币种</label>' +
//               '<input type="text" name="currencyType_'+bankIndex+'" id="currencyType_'+bankIndex+'" names="currencyType" class="form-control" placeholder="">' +
                '<select class="form-control" id="currencyType" name="currencyType" names="currencyType">'+
                '<option value="" style="display: none">请选择</option>'+
                '<option value="0" <c:if test="${bank.currencyType == 0}">selected</c:if>>人民币</option>'+
                '<option value="1" <c:if test="${bank.currencyType == 1}">selected</c:if>>美元</option>'+
                '<option value="2" <c:if test="${bank.currencyType == 2}">selected</c:if>>欧元</option>'+
                '<option value="3" <c:if test="${bank.currencyType == 3}">selected</c:if>>港币</option>'+
                '<option value="4" <c:if test="${bank.currencyType == 4}">selected</c:if>>英镑</option>'+
                '</select>'+
               '</div>' +
               '</div>' +
               '</div>' +
                '<div>' +
                '<button type="button" class="btn red" onclick="deleteBankDiv(this);">删除</button>'+
                '</div>'+
                '</div>'
        );
        $("#bankAccount_" + bankIndex).rules("add", {required:true});
        $("#electronAccount_" + bankIndex).rules("add", {required:true});
        $("#bankTypeName_" + bankIndex).rules("add", {required:true});
        $("#bankAccountName_" + bankIndex).rules("add", {required:true});
        $("#bankCountry_" + bankIndex).rules("add", {required:true});
        $("#associatedNumber_" + bankIndex).rules("add", {required:true});
        $("#depositBankName_" + bankIndex).rules("add", {required:true});

        //银行类别模糊搜索
        $("#bankTypeName_"+bankIndex).autocomplete({
            source:function( request, response ) {
                $.ajax({
                    url : "${pageContext.request.contextPath}/approveBase/selectByBankTypeName",
                    type : "post",
                    dataType : "json",
                    data : {"bankTypeName": request.term},

                    success: function( data ) {
                        response( $.map( data.data, function( item ) {
                            return {
                                label: item.codeName,// 下拉项显示内容
                                value: item.code // 下拉项对应数值
                            }
                        }));
                    }
                });
            },
            minLength: 1,  // 输入框字符个等于2时开始查询
            focus: function( event, ui ) {
                $(this).val( ui.item.label );
                return false;
            },
            select: function( event, ui ) {// 选中某项时执行的操作
                //$('#bankTypeId').focus();
                $(this).val( ui.item.label );
                $(this).parent().find(".bankType").val( ui.item.value );
                //$(this).parent().find(".bankType").change();
                $(this).parent().parent().parent().parent().find(".bankTY").val( ui.item.value );
                $(this).parent().parent().parent().parent().find(".bankKhg").val("");
                $(this).parent().parent().parent().parent().find(".bankKhgName").val("");
                return false;
            },

        });


        //开户银行模糊搜索
        $("#depositBankName_"+bankIndex).autocomplete({
            source:function( request, response ) {
                $.ajax({
                    url : "${pageContext.request.contextPath}/approveBase/selectByDepositBankName",
                    type : "post",
                    dataType : "json",
                    data : {
                        bankName : request.term,
                        bankType : $("#bankType_"+bankIndex).val()
                    },
                    success: function( data ) {
                        response( $.map( data.data, function( item ) {
                            return {
                                label: item.bankName,// 下拉项显示内容
                                value: item.bankCode // 下拉项对应数值
                            }
                        }));
                    }
                });
            },
            minLength: 2,  // 输入框字符个等于2时开始查询
            focus: function( event, ui ) {
                $("#depositBankName_"+bankIndex).val( ui.item.label );
                return false;
            },
            select: function( event, ui ) {// 选中某项时执行的操作
                //$('#bankTypeId').focus();
                $("#depositBankName_"+bankIndex).val( ui.item.label );
                $("#depositBank_"+bankIndex).val( ui.item.value );
                $("#associatedNumber_"+bankIndex).val( ui.item.value );
                return false;
            },

        });

    }

//    //银行类别change事件
//    function bankTypeChange(codeNameId) {
//        $("#depositBank_"+bankIndex).find("option").remove();
//        $("#depositBank_"+bankIndex).append("<option value=''>请选择</option>");
//        $.ajax({
//            url : "/approveBase/selectCodeName",
//            type : "post",
//            data : "bankCode=" + codeNameId,
//            dataType : "json",
//            async : false,
//            success : function (result) {
//                if (result.data) {
//                    for (var i= 0; i < result.data.length; i++){
//                        var datas = result.data[i];
//                        $("#depositBank_"+bankIndex).append("<option value='"+datas.bankCode+"'>"+datas.bankName+"</option>");
//                    }
//                }
//            }
//
//        });
//    }

    //开户银行切换事件
    function depositCh(bankCode) {
        //var bankCode = $(obj).val();
        $("#associatedNumber_"+bankIndex).val(bankCode);
    }


</script>


