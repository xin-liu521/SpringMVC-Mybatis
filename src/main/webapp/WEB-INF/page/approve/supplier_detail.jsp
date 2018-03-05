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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/jquery-ui-1.12.1/jquery-ui.css">
    <style>
        .check{
            color: #fff;
            background-color: #337ab7;
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
        .jz{
            font-size: 20px;
            height: 50px;
            text-align: center;
        }
        .aLike {
            display:block;width:200px;height:30px;
        }
    </style>

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
                    <div id="bar" class="progress progress-striped" role="progressbar">
                        <div class="progress-bar progress-bar-success"> </div>
                    </div>
                    <div class="col-xs-2">
                        <div style="height: 300px; width: 200px;">
                            <div class="jz">
                                <a href="#tab_1" class="btn blue mt-clipboard aLike">基本信息</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_2" class="btn blue mt-clipboard aLike">联系方式</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_3" class="btn blue mt-clipboard aLike">产品说明</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_4" class="btn blue mt-clipboard aLike">银行信息</a>
                            </div>
                            <div class="jz">
                                <a href="#tab_5" class="btn blue mt-clipboard aLike">资质说明</a>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/index"><button type="button" class="btn green">返回</button></a>
                    </div>
                    <div class="col-xs-10"  style="position:absolute; left:17%;height:100%; overflow:auto">
                        <form id="addSupplierApprove" class="horizontal-form">
                            <input hidden="hidden" id="id" name="id" value="${byApproveBase.id}"/>
                            <div class="tab-pane" id="tab_1">
                                <div class="portlet box blue">
                                    <div class="portlet-title">
                                        <div class="caption">基本信息 </div>
                                    </div>
                                    <div class="portlet-body form">
                                        <!-- BEGIN FORM-->
                                        <%--<form  class="horizontal-form">--%>
                                        <div class="form-body">
                                            <%--<h3 class="form-section">Person Info</h3>--%>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">单位全称</label>
                                                        <input type="text" name="companyFullName" id="companyFullName" class="form-control" required="required" value="${byApproveBase.companyFullName}"
                                                                readonly placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">英文全称</label>
                                                        <input type="text" name="companyFullEg" id="companyFullEg" class="form-control" value="${byApproveBase.companyFullEg}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">单位简称</label>
                                                        <input type="text" name="companyShortName" id="companyShortName" class="form-control" value="${byApproveBase.companyShortName}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">英文简称</label>
                                                        <input type="text" name="companyShortEg" id="companyShortEg" class="form-control" value="${byApproveBase.companyShortEg}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">所属地区</label>
                                                        <input type="hidden" name="area" id="area" class="form-control" required="required" value="${byApproveBase.area}" placeholder="">
                                                        <input type="text" name="areaName" id="areaName" class="form-control" value="${byApproveBase.areaName}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">法人</label>
                                                        <input type="text" name="legalPerson" id="legalPerson" class="form-control" required="required" value="${byApproveBase.legalPerson}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <div class="row">
                                                <!--/span-->
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">是否三证合一</label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="isUnity" readonly id="isUnity1" value="0" <c:if test="${byApproveBase.isUnity == null || byApproveBase.isUnity == 0}">checked</c:if>
                                                                   <c:if test="${byApproveBase.companyType == 0 && byApproveBase.supplierStatus!=3 && byApproveBase.status!= 0 }">readonly</c:if> disabled />是
                                                        </label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="isUnity" readonly id="isUnity2" value="1" <c:if test="${byApproveBase.isUnity == 1}">checked</c:if>
                                                                   <c:if test="${byApproveBase.companyType == 0 && byApproveBase.supplierStatus!=3 && byApproveBase.status!= 0 }">readonly</c:if> disabled/>否
                                                        </label>
                                                    </div>
                                                </div>
                                                <!--/span-->
                                            </div>
                                            <div class="row" id="div1">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">社会信用代码</label>
                                                        <input type="text" name="socialCreditCode" id="socialCreditCode" class="form-control" required="required" value="${byApproveBase.socialCreditCode}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="row" style="display:none;" id="div2">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">营业执照号</label>
                                                        <input type="text" name="licenseNumber" id="licenseNumber" class="form-control" required="required" value="${byApproveBase.licenseNumber}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">组织机构代码证号</label>
                                                        <input type="text" name="organizationCodeNumber" id="organizationCodeNumber" class="form-control" required="required" value="${byApproveBase.organizationCodeNumber}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">税务登记证号</label>
                                                        <input type="text" name="taxNumber" id="taxNumber" class="form-control" required="required" value="${byApproveBase.taxNumber}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">经济类型</label>
                                                        <select class="form-control" id="economicsType" name="economicsType" disabled>
                                                            <option value="0" <c:if test="${byApproveBase.economicsType == 0}">selected</c:if>>国有经济</option>
                                                            <option value="1"<c:if test="${byApproveBase.economicsType == 1}">selected</c:if>>集体经济</option>
                                                            <option value="2"<c:if test="${byApproveBase.economicsType == 2}">selected</c:if>>私营经济</option>
                                                            <option value="3"<c:if test="${byApproveBase.economicsType == 3}">selected</c:if>>个体经济</option>
                                                            <option value="4"<c:if test="${byApproveBase.economicsType == 4}">selected</c:if>>股份制</option>
                                                            <option value="5"<c:if test="${byApproveBase.economicsType == 5}">selected</c:if>>外商投资</option>
                                                            <option value="6"<c:if test="${byApproveBase.economicsType == 6}">selected</c:if>>港澳台投资</option>
                                                            <option value="7"<c:if test="${byApproveBase.economicsType == 7}">selected</c:if>>其它经济</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">注册资金</label>
                                                        <input type="text" name="fund" id="fund" class="form-control" value="${byApproveBase.fund}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">成立日期</label>
                                                        <input name="createRegTime" id="createRegTime" type="text" disabled
                                                               value="<fmt:formatDate value='${byApproveBase.createRegTime}' pattern="yyyy-MM-dd"/>"
                                                               class="form-control datetimepicker" placeholder="请选择日期">
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
                                                        <select class="form-control" id="currency" names="currency" disabled name="currency" value="${bank.currency}">
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
                                        <%-- <form  class="horizontal-form">--%>
                                        <div class="form-body">
                                            <%--<h3 class="form-section">Person Info</h3>--%>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">通讯地址</label>
                                                        <input type="text" id="address" name="address" class="form-control" required="required" value="${byApproveBase.address}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">联系人</label>
                                                        <input type="text" id="contact" name="contact" class="form-control" value="${byApproveBase.contact}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">联系人手机号</label>
                                                        <input type="text" id="contactPhone" name="contactPhone" class="form-control" value="${byApproveBase.contactPhone}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!--/row-->
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Email地址</label>
                                                        <input type="text" id="email" name="email" class="form-control" required="required" value="${byApproveBase.email}"
                                                               readonly placeholder="该邮箱用于密码找回">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">邮编</label>
                                                        <input type="text" id="postcode" name="postcode" class="form-control" value="${byApproveBase.postcode}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">公司电话</label>
                                                        <input type="text" id="phone" name="phone" class="form-control" value="${byApproveBase.phone}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">公司传真</label>
                                                        <input type="text" id="fax" name="fax" class="form-control" value="${byApproveBase.fax}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label class="control-label">Web地址</label>
                                                        <input type="text" id="webAddress" name="webAddress" class="form-control" value="${byApproveBase.webAddress}"
                                                               readonly placeholder="">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- </form>--%>
                                        <!-- END FORM-->
                                    </div>
                                </div>
                            </div>
                        </form>
                        <!--联系方式div  end-->
                        <%--产品说明--%>
                        <div class="tab-pane" id="tab_3">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">产品说明 </div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <form  class="horizontal-form" id="addProductForm">
                                        <div class="form-body">
                                            <c:choose>
                                                <c:when test="${byProducts != null && byProducts.size() > 0}">
                                                    <c:forEach items="${byProducts}" var="product" varStatus="status">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group">
                                                                    <label class="control-label">产品分类</label>
                                                                    <input type="hidden" name="productType" value="${product.productType}" class="form-control" readonly placeholder="">
                                                                    <input type="text" name="productTypeName" value="${product.productTypeName}"  class="form-control" readonly placeholder="请输入关键字，例如：工字钢">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="row">
                                                        <input hidden="hidden" name="productId"/>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label class="control-label">产品分类</label>
                                                                <input type="hidden" name="productType" class="form-control" placeholder="">
                                                                <input type="text" name="productTypeName"  class="form-control" placeholder="请输入关键字，例如：工字钢">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                            <!--/row-->
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>
                        <%--银行信息--%>
                        <div class="tab-pane" id="tab_4">
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
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label" style="font-weight:bold">
                                                                            <input type="checkbox" value="0" name="isElectronAccount" disabled
                                                                                   <c:if test="${bank.isElectronAccount == 0}">checked</c:if> onchange="electChange(this);"/>是否电子承兑账号</label>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">账号性质</label>
                                                                        <label><input name="accountPropertiesOne_${bakIndex}" names="accountProperties" type="radio" value="0"
                                                                                      <c:if test="${bank.accountProperties == 0}">checked</c:if> disabled />个人账号</label>
                                                                        <label><input name="accountPropertiesOne_${bakIndex}" names="accountProperties"  type="radio" value="1"
                                                                                      <c:if test="${bank.accountProperties == 1}">checked</c:if> disabled />单位账号</label>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-4 account" id="yhDiv_${bakIndex}">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行账号</label>
                                                                        <input type="text" name="bankAccount" names="bankAccount" class="form-control inputaccoun" readonly
                                                                               <c:if test="${bank.isElectronAccount == 1}">value="${bank.bankAccount}"</c:if> placeholder=""/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4 electron" style="display: none" id="dzDiv_${bakIndex}">
                                                                    <div class="form-group">
                                                                        <label class="control-label">电子银行承兑账号</label>
                                                                        <input type="text" name="electronAccount" names="electronAccount" class="form-control elecinput" readonly
                                                                               <c:if test="${bank.isElectronAccount == 0}">value="${bank.bankAccount}"</c:if> placeholder=""/>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行类别</label>
                                                                        <input type="hidden" id="bankTypeOne_${bakIndex}" name="bankTypeOne_${bakIndex}" names="bankType"
                                                                               class="form-control bankType" placeholder=""
                                                                               value="${bank.bankType}"  onchange="bankTypes(this);">
                                                                        <input type="text" id="bankTypeNameOne_${bakIndex}" name="bankTypeName" names="bankTypeName" class="form-control "
                                                                               value="${bank.bankTypeName}" readonly placeholder="请输入关键字，例如：工商">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">账户名称</label>
                                                                        <input type="text" name="bankAccountName" names="bankAccountName" value="${bank.bankAccountName}" readonly class="form-control" placeholder="">
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">开户银行</label>
                                                                        <%--<select class="form-control depBank"  name="depositBank" names="depositBank" disabled >--%>
                                                                            <%--<option value="${bank.depositBank}" selected>${bank.depositBankName}</option>--%>
                                                                        <%--</select>--%>
                                                                        <input type="hidden" id="bankType_${bakIndex}" name="bankType_${bakIndex}" value="${bank.bankType}" class="form-control bankTY"/>

                                                                        <input type="hidden" id="depositBankOne_${bakIndex}" name="depositBankOne_${bakIndex}" names="depositBank"
                                                                               class="form-control depBank" placeholder="" value="${bank.depositBank}" >
                                                                        <input type="text" id="depositBankNameOne_${bakIndex}" name="depositBankNameOne_${bakIndex}" names="depositBankName" class="form-control "
                                                                               value="${bank.depositBankName}" readonly placeholder="请输入关键字，例如：西安支行">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">其他开户行</label>
                                                                        <input type="text" name="otherBank" names="otherBank" value="${bank.otherBank}" class="form-control" readonly placeholder="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">银行国家</label>
                                                                        <input type="text" name="bankCountry" names="bankCountry" value="${bank.bankCountry}" class="form-control" readonly placeholder="">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">联行号</label>
                                                                        <input type="text" name="associatedNumber" names="associatedNumber" value="${bank.associatedNumber}" class="form-control" readonly placeholder="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <div class="form-group">
                                                                        <label class="control-label">币种</label>
                                                                        <%--<input type="text" name="currencyType" names="currencyType" value="${bank.currencyType}" class="form-control" readonly placeholder="">--%>
                                                                        <select class="form-control" id="currencyType" names="currencyType" value="${bank.currencyType}" name="currencyType" disabled>
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
                                                        </div>

                                                    </c:forEach>
                                                </c:when>

                                            </c:choose>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <%--资质说明--%>
                        <div class="tab-pane" id="tab_5">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">资质说明</div>
                                </div>
                                <div class="portlet-body form">
                                    <!-- BEGIN FORM-->
                                    <form  class="horizontal-form" id="aptitudeForm">
                                        <div class="form-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                      <div class="form-group" style="font-weight: bold">
                                                        <input type="checkbox" name="isChemical" id="isChemical" disabled
                                                               <c:if test="${byApproveBase.isChemical == 0}">checked</c:if> value="0"/>是否危险化学品
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div id="uploader" class="wu-example">
                                                    <!--用来存放文件信息-->
                                                    <div id="thelist" class="uploader-list">
                                                        <c:if test="${byDocList!=null && byDocList.size() != 0}">
                                                            <c:choose>
                                                                <c:when test="${byDocList!=null && byDocList.size() != 0}">
                                                                    <%--<c:if test="${byDocList.size() > 1}">--%>
                                                                        <%--<td colspan="5"> ${byDocList.size()}个 <button type="button" class="btn blue" onclick="batchDownloadFiles()">全部下载</button></td>--%>
                                                                    <%--</c:if>--%>
                                                                    <c:forEach items="${byDocList}" var="doc" varStatus="status">
                                                                        <p class="file-other-title" id="${doc.id}" style="text-align: left"><span>${doc.docName}</span>
                                                                                <%--<button type="button" class="user_up_button search-min-button">预览</button>--%>
                                                                            <a href="http://10.20.2.45:8080${doc.docUrl}">下载</a></p>
                                                                        </p>
                                                                    </c:forEach>
                                                                </c:when>
                                                            </c:choose>
                                                            </td>
                                                        </c:if>
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
                </div>
                <!--中间内容页-->
            </div>
            <!-- END CONTENT BODY -->
        </div>
        <!-- END CONTENT -->

    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
   <%-- <%@include file="/WEB-INF/common/fotter.jsp"%>--%>
    <!-- END FOOTER -->
</div>
</body>
</html>
<script>
    //是否电子承兑账户
    // electChange();
    var bankAccounts = '${byBanksJson}';

    $(function () {
        $.each(JSON.parse(bankAccounts), function(index, val) {
            if (val.isElectronAccount == 0) {
                $("#dzDiv_"+(index +1)).show();
                $("#yhDiv_"+(index +1)).hide();
            }else {
                $("#dzDiv_"+(index +1)).hide();
                $("#yhDiv_"+(index +1)).show();
            }
        });

        showChemical();
        showCont();
    });
    //是否危险化学品
    function showChemical() {
        if ($('#isChemical').prop("checked")){
            $("#chemical").show();
        } else {
            $("#chemical").hide();
        }
    };
    //是否三证合一
    function showCont(){
        switch($("input[name='isUnity']:checked").attr("id")){
            case "isUnity1":
                $("#div2").hide();
                $("#div1").show();
                break;
            case "isUnity2":
                $("#div1").hide();
                $("#div2").show();
                break;
            default:
                break;
        }
    }
</script>





