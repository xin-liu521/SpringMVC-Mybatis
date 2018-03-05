<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>新骑手注册</title>
	<meta charset="utf-8">
	<meta name="format-detection" content="telephone=no">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-touch-fullscreen" content="yes">
	<link href="http://www.jq22.com/jquery/bootstrap-3.3.4.css" rel="stylesheet">
	<!--[if IE]>
	<![endif]-->

	<link href="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet">
	<link href="layui/css/layui.css" rel="stylesheet">
	<link rel="stylesheet" href="css/register-wap.css">

	<link href="css/1.css" type="text/css" rel="stylesheet">
	<link href="css/2.css" type="text/css" rel="stylesheet">
<style>
	input[type="date"]:before{
		content: attr(placeholder);
	}
</style>

</head>
<body>
<div id="layout">
	<span style="color: red;padding: 20px 0;"><strong>店小二骑手注册</strong></span>
	<form id="registerForm"  class="form-inline" action="${pageContext.request.contextPath }/preworkerAction_scanAdd.action" method="post">
		<input type="hidden" id="openid" name="openid" value="${openid}"/>
		<input type="hidden" id="access_token" name="access_token" value="${access_token}"/>
		<ul data-toggle="distpicker">
			<li><i class="un">
				<img src="images/6.png"></i>
				<input class="username" id="name" name="name" type="text" value="${preworker.name}" placeholder=" 请输入姓名" />
			</li>
			<li><i class="pw"><img src="images/1.png"></i>
				<select class="dz" id="regionid" name="regionid" style="color: black;" onchange="regionChange(this.value);" >

				</select>
			</li>
			<li><i class="pw"><img src="images/5.png"></i>
				<select   class="dz"  id="stationid" name="stationid" style="color: black;">

				</select>
			</li>
			<li><i class="pw"><img src="images/3.png"></i>
				<input value="${preworker.spredate}" class="pwd" id="spredate" name="spredate" type="date" placeholder="请输入报到时间" required/>
			</li>
			<li><i class="pw"><img src="images/5.png"></i>
				<select   class="dz"  id="infofrom" name="infofrom" style="color: black;" onchange="infoClick(this.value);">
					<option value="">请选择信息来源</option>
					<option value="人才市场">人才市场</option>
					<option value="58同城">58同城</option>
					<option value="餐箱贴">餐箱贴</option>
					<option value="熟人介绍">熟人介绍</option>
					<option value="宣传彩页">宣传彩页</option>
					<option value="其他">其他</option>
				</select>
			</li>
			<li id="referId" style="display: none">
				<i class="un">
				<img src="images/6.png"></i>
				<input class="username" id="referee" name="referee" type="text" value="${preworker.referee}" placeholder=" 请输入推荐人" />
			</li>
			<li><i class="un">
				<img src="images/2.png"></i>
				<input class="phones" type="text" id="telephone" name="telephone" value="${preworker.telephone}" placeholder=" 请输入手机号" />
			</li>
			<li><i class="yz"><img src="images/8.png"></i>
				<input class="checkcode" id="checkcode" name="checkcode" type="text" placeholder="请输入短信动态码" />
				<input  id="btn" type="button" onclick="butClick();" value="获取动态码" />
				<img id="loginform:vCode" class="layui-hide" src="${pageContext.request.contextPath }/validatecode.jsp"
					 onclick="javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath }/validatecode.jsp?'+Math.random();" />
			</li>
		</ul>
		<div class="reg_btn">
			<button class="submit" type="submit">申请</button>
			<br><br><br><br>
		</div>
	</form>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/jquery-validation/jquery.validate.custom.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/jquery-validation/jquery.validate.messages_cn.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.js"></script>

<!-- 提交弹出信息 -->
<script>
	var openid = '${openid}';
	var access_token = '${access_token}';

	function infoClick(val) {
		var referId = document.getElementById("referId");
		if (val == '熟人介绍') {
			referId.style.display = ""
		}else {
			referId.style.display = "none"
		}
	}



	//倒计时60秒
	var wait=60;
	function time(o) {
		if (wait == 0) {
			o.removeAttribute("disabled");
			o.value="获取动态码";
			wait = 60;
		} else {
			o.setAttribute("disabled", true);
			o.value="重新发送(" + wait + ")";
			wait--;
			setTimeout(function() {
				time(o);
			}, 1000)
		}
	}
	//获取验证码
	function butClick() {
		var telephone = $("#telephone").val();
		if(telephone == "" ){
			Command: toastr["warning"]("请填写手机号!");
			return false;
		}
		if (!$("#telephone").valid()) {
			return false;
		}else {
			$.ajax({
				url : "${pageContext.request.contextPath }/preworkerAction_valideCode.action?telephone="+telephone,
				success : function(result) {
					if (result.success) {
						time(btn);
					}

				}
			});
		}

	}

$(function () {
	//注册验证
	$("#registerForm").validate({
		//onfocusout: true,//失去焦点时不验证
		rules: {
			name : {
				required : true,
			},
			sex : {
				required : true,
			},
			telephone : {
				required : true,
				isMobile : true,
				remote : {
					url: "${pageContext.request.contextPath }/preworkerAction_isHasPhone.action",//校验是否存在
					type: "post",
					async: false,
					dataType: "json",
					data: {
						"telephone": function () {
							return $("#telephone").val();
						},
					},
					dataFilter: function (data) {
						var result = eval("(" + data + ")");
						if (result.success) {
							return false;
						} else{
							return true;
						}
					}
				}

			},
			regionid : {
				required : true,
			},
			stationid : {
				required : true,
			},
			spredate : {
				required : true,
			},
			checkcode : {
				required : true,
				remote : {
					url: "${pageContext.request.contextPath }/preworkerAction_isHasCode.action",//校验是否存在
					type: "post",
					async: false,
					dataType: "json",
					data: {
						"checkcode": function () {
							return $("#checkcode").val();
						},
					},
					dataFilter: function (data) {
						var result = eval("(" + data + ")");
						if (result.success) {
							return true;
						} else{
							return false;
						}
					}
				}
			},
			infofrom : {
				required : true,
			}

		},
		messages: {

			telephone : {
				remote : "<span style='color: red;font-size: 13px;'>手机号已注册</span>"
			},
			checkcode : {
				remote : "<span style='color: red;font-size: 13px;'>验证码错误</span>"
			},
		}

	});

	
	//发送ajax请求,获取区域列表
	$("#regionid").empty();
	var url_1 = "preworkerAction_findRegionList.action";
	$.post(url_1,function(data)
	{
		$("#regionid").append("<option value=''>请选择所在地区</option>");
		//遍历json数组
		for(var i=0;i<data.length;i++)
		{
			var id = data[i].id;
			var name = data[i].name;
			
			//直接通过jstl库获取区域ID
			var oldregionid = "${regionid}";
			
			if(oldregionid==id) 
			   $("#regionid").append("<option selected='selected' value='"+id+"'>"+name+"</option>");
			else 
			  $("#regionid").append("<option value='"+id+"'>"+name+"</option>");
		}
	});


});

function regionChange(val) {
	//查询站点信息
	$("#stationid").empty();
	var url_2 = "preworkerAction_moveFindStations.action?regionid="+ val;
	$.post(url_2,function(data)
	{
		$("#stationid").append("<option value='-1'>请为我推荐站点</option>");
		//遍历json数组
		for(var i=0;i<data.length;i++)
		{
			var id = data[i].id;
			var name = data[i].name;

			//直接通过jstl库获取区域ID
			var oldstationid = "${stationid}";

			if(oldstationid == id)
				$("#stationid").append("<option selected='selected' value='"+id+"'>"+name+"</option>");
			else
				$("#stationid").append("<option value='"+id+"'>"+name+"</option>");
		}
	});
}


	var o = document.getElementById('spredate');
	o.onfocus = function(){
		this.removeAttribute('placeholder');
	};
	o.onblur = function(){
		if(this.value == '') this.setAttribute('placeholder','请输入报到时间');
	};
</script>
</body>
</html>