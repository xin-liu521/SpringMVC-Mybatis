<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/3
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>入职进展查询</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>

    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body  class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <h2>入职进展查询</h2>

            <form class="m-t" role="form">
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" id="name" name="name" placeholder="骑手姓名">--%>
                <%--</div>--%>
                <div class="form-group">
                    <input type="tel" class="form-control" id="telephone" name="telephone" placeholder="请输入手机号码">
                </div>
                <button type="button" class="btn btn-primary m-b" style="width: 45%;" onclick="searchCourse();">查 询</button>

            </form>
        </div>
        <div  id="table">
            <table class="table table-bordered panel panel-primary">
                <tbody>
                <tr>
                    <td class="col-xs-6"><strong>姓名</strong></td>
                    <td class="col-xs-6" id="pname"></td>
                </tr>
                <tr>
                    <td class="col-xs-6"><strong>电话号码</strong></td>
                    <td class="col-xs-6" id="ptelephone"></td>
                </tr>
                <tr>
                    <td class="col-xs-6"><strong>分配站点</strong></td>
                    <td class="col-xs-6" id="stationName"></td>
                </tr>
                <tr>
                    <td class="col-xs-6"><strong>登记日期</strong></td>
                    <td class="col-xs-6" id="dateTime"></td>
                </tr>
                <tr>
                    <td class="col-xs-6"><strong>入职进展</strong></td>
                    <td class="col-xs-6" style="color: red;" id="status"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/jquery-validation/jquery.validate.custom.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/jquery-validation/jquery.validate.messages_cn.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.js"></script>

</html>
<script>
//    document.getElementById("search").onclick=function(){
//        document.getElementById("table").style.display="block";
//    };
//    document.getElementById("clear").onclick=function (ev) {
//        document.getElementById("table").style.display="none";
//    };

    function searchCourse() {
        var telephone = $("#telephone").val();
        if (telephone == ''|| telephone == null) {
            Command: toastr["warning"]("手机号不能为空!");
            return;
        }
        $.ajax({
            url : "${pageContext.request.contextPath}/preworkerAction_findByTelephone.action",
            type : "post",
            data : {
                telephone : telephone
            },
            success : function(result) {
                if (result) {
                    $("#pname").html(result.name);
                    $("#ptelephone").html(result.telephone);
                    $("#stationName").html(result.station.name);
                    $("#dateTime").html(result.spredate);
                    if (result.state == 0) {
                        $("#status").html("待报到");
                    }else if(result.state == 1){
                        $("#status").html("审核中");
                    }else if(result.state == 2){
                        $("#status").html("试用期中");
                    }else if(result.state == 3){
                        $("#status").html("入职完成");
                    }else {
                        $("#status").html("");
                    }

                }else {
                    Command: toastr["warning"]("手机号未注册!");
                }
            }
        });
    }

</script>