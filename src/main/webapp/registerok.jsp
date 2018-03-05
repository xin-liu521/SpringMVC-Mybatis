<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新骑手注册成功</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="icon" href="img/logo2.png">
</head>
<body>
<div>
    <section class="hero">
        <div class="hero-body">
            <div class="container">
                <div>
                    <div class="card-content">
                        <div class="content">
                            <h2 style="text-align: center;">
                                <strong style="color: red;">入职申请成功</strong>
                            </h2>
                        </div>
                    </div>

                    <div class="card-content">
                        <div class="content">
                            <%--<str→ong>重要提示：</strong>--%>
                            <%--<p>--%>
                                <%--入职申请成功，请携带3张一寸照片，--%>
                                <%--身份证原件到${reginname}市${tipinfo.addr}(美团${tipinfo.name})办理入职，--%>
                                <%--联系人:${tipinfo.linkman},联系电话:${tipinfo.linkmantel}'--%>
                            <%--</p>--%>
                            <strong class="message is-danger">重要提示：</strong>
                            <p>
                                请您于<strong>${spredate}</strong>到 <strong>${tipinfo.name}</strong> 报到 <br>
                                报到地址：${tipinfo.addr} <br>
                                联系人：${tipinfo.linkman} <br>
                                联系电话：${tipinfo.linkmantel} <br>
                                特别提醒：报到时请务必携带 <br>
                                &nbsp;&nbsp;&nbsp;1、3张一寸照片 <br>
                                &nbsp;&nbsp;&nbsp;2、身份证原件 <br>
                            </p>
                        </div>
                    </div>
                    <div class="card-content">
                        <div class="content">
                            <p>
                                <strong class="message is-danger">入职进展查询: <br></strong>
                                请在公众号内点击右下角<strong>&nbsp;员工通道→入职进展&nbsp;</strong>查询。
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<script language="javascript">
// 这个脚本是 ie6和ie7 通用的脚本
function CloseWebPage(){
 if (navigator.userAgent.indexOf("MSIE") > 0) {
  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
   window.opener = null;
   window.close();
  } else {
   window.open('', '_top');
   window.top.close();
  }
 }
 else if (navigator.userAgent.indexOf("Firefox") > 0) {
  window.location.href = 'about:blank ';
 } else {
  window.opener = null;
  window.open('', '_self', '');
  window.close();
 }
}
</script>

<%--<div align="center">--%>
<%--<input id="btnClose" type="button" value="关闭当前页面" onClick="CloseWebPage()" />--%>
<%--</div>--%>
<script src="${pageContext.request.contextPath }/js/jquery-1.12.3.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

<script type="text/javascript">
	
</script>
    </body>
</html>