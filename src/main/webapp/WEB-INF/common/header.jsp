<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style>
    #infoForm .form-body .form-group .col-md-4 .file-input .file-preview .krajee-default,
    #infoForm .form-body .form-group .col-md-4 .file-input .file-preview .close{
        display: none;
    }
</style>
<div class="page-header-inner ">
    <!-- BEGIN LOGO -->
    <div class="page-logo">
        <a href="${pageContext.request.contextPath}/index">
            <img src="${pageContext.request.contextPath}/assets/layouts/layout/img/logo.png" alt="logo" class="logo-default"/> </a>
        <%--<div class="menu-toggler sidebar-toggler">--%>
            <%--<span></span>--%>
        <%--</div>--%>
    </div>
    <!-- END LOGO -->
    <!-- BEGIN RESPONSIVE MENU TOGGLER -->
    <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse"
       data-target=".navbar-collapse">
        <span></span>
    </a>
    <!-- END RESPONSIVE MENU TOGGLER -->
    <!-- BEGIN TOP NAVIGATION MENU -->
    <div class="top-menu">
        <ul class="nav navbar-nav pull-right">

            <li class="dropdown dropdown-user">
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                   data-close-others="true">
                    <img alt="" id="myHeartLogo" class="img-circle"  src=""/>
                    <span class="username username-hide-on-mobile"><shiro:principal property="userAccount"></shiro:principal></span>
                    <i class="fa fa-angle-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-default">
                    <li class="divider"></li>
                    <%--<li>
                        <a href="page_user_lock_1.html">
                            <i class="icon-lock"></i> Lock Screen </a>
                    </li>--%>
                    <li>
                        <a href="#infoModal" onclick="showCurrentInfo();" data-toggle="modal">
                            <i class="icon-user"></i> 个人信息 </a>
                    </li>
                    <li>
                        <a href="#pswModal" onclick="showPswModal();" data-toggle="modal">
                            <i class="icon-pencil"></i> 修改密码 </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">
                            <i class="icon-key"></i> 退出 </a>
                    </li>
                </ul>
            </li>
            <!-- END USER LOGIN DROPDOWN -->
            <!-- BEGIN QUICK SIDEBAR TOGGLER -->
            <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
            <%--<li class="dropdown dropdown-quick-sidebar-toggler">--%>
                <%--<a href="javascript:;" class="dropdown-toggle">--%>
                    <%--<i class="icon-logout"></i>--%>
                <%--</a>--%>
            <%--</li>--%>
            <!-- END QUICK SIDEBAR TOGGLER -->
        </ul>
    </div>
    <!-- END TOP NAVIGATION MENU -->

    <%--<!-- BEGIN QUICK SIDEBAR  顶部右侧抽屉-->--%>
    <%--<a href="javascript:;" class="page-quick-sidebar-toggler">--%>
        <%--<i class="icon-login"></i>--%>
    <%--</a>--%>
    <%--<div class="page-quick-sidebar-wrapper" data-close-on-body-click="false">--%>
        <%--<div class="page-quick-sidebar">--%>
            <%--<ul class="nav nav-tabs">--%>
                <%--<li class="active">--%>
                    <%--<a href="javascript:;" data-target="#quick_sidebar_tab_1" data-toggle="tab"> 用户--%>
                        <%--<span class="badge badge-danger">2</span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="javascript:;" data-target="#quick_sidebar_tab_2" data-toggle="tab"> 通知--%>
                        <%--<span class="badge badge-success">7</span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> 更多--%>
                        <%--<i class="fa fa-angle-down"></i>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu pull-right">--%>
                        <%--<li>--%>
                            <%--<a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">--%>
                                <%--<i class="icon-bell"></i> 警告 </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">--%>
                                <%--<i class="icon-info"></i> 消息 </a>--%>
                        <%--</li>--%>

                        <%--<li class="divider"></li>--%>
                        <%--<li>--%>
                            <%--<a href="javascript:;" data-target="#quick_sidebar_tab_3" data-toggle="tab">--%>
                                <%--<i class="icon-settings"></i> 设置 </a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<div class="tab-content">--%>
                <%--<div class="tab-pane active page-quick-sidebar-chat" id="quick_sidebar_tab_1">--%>
                    <%--<div class="page-quick-sidebar-chat-users" data-rail-color="#ddd"--%>
                         <%--data-wrapper-class="page-quick-sidebar-list">--%>
                        <%--<h3 class="list-heading">员工</h3>--%>
                        <%--<ul class="media-list list-items">--%>
                            <%--<li class="media">--%>
                                <%--<div class="media-status">--%>
                                    <%--<span class="badge badge-success">8</span>--%>
                                <%--</div>--%>
                                <%--<img class="media-object" src="/assets/layouts/layout/img/avatar3.jpg" alt="...">--%>
                                <%--<div class="media-body">--%>
                                    <%--<h4 class="media-heading">Bob Nilson</h4>--%>
                                    <%--<div class="media-heading-sub"> Project Manager</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>

                        <%--</ul>--%>
                        <%--<h3 class="list-heading">客户</h3>--%>
                        <%--<ul class="media-list list-items">--%>
                            <%--<li class="media">--%>
                                <%--<div class="media-status">--%>
                                    <%--<span class="label label-sm label-success">new</span>--%>
                                <%--</div>--%>
                                <%--<img class="media-object" src="/assets/layouts/layout/img/avatar7.jpg" alt="...">--%>
                                <%--<div class="media-body">--%>
                                    <%--<h4 class="media-heading">Ernie Kyllonen</h4>--%>
                                    <%--<div class="media-heading-sub"> Project Manager,--%>
                                        <%--<br> SmartBizz PTL--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="tab-pane page-quick-sidebar-alerts" id="quick_sidebar_tab_2">--%>
                    <%--<div class="page-quick-sidebar-alerts-list">--%>
                        <%--<h3 class="list-heading">General</h3>--%>
                        <%--<ul class="feeds list-items">--%>
                            <%--<li>--%>
                                <%--<div class="col1">--%>
                                    <%--<div class="cont">--%>
                                        <%--<div class="cont-col1">--%>
                                            <%--<div class="label label-sm label-info">--%>
                                                <%--<i class="fa fa-check"></i>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                        <%--<div class="cont-col2">--%>
                                            <%--<div class="desc"> You have 4 pending tasks.--%>
                                                <%--<span class="label label-sm label-warning "> Take action--%>
                                                                <%--<i class="fa fa-share"></i>--%>
                                                            <%--</span>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="col2">--%>
                                    <%--<div class="date"> Just now</div>--%>
                                <%--</div>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="javascript:;">--%>
                                    <%--<div class="col1">--%>
                                        <%--<div class="cont">--%>
                                            <%--<div class="cont-col1">--%>
                                                <%--<div class="label label-sm label-success">--%>
                                                    <%--<i class="fa fa-bar-chart-o"></i>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <%--<div class="cont-col2">--%>
                                                <%--<div class="desc"> Finance Report for year 2013 has been released.</div>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="col2">--%>
                                        <%--<div class="date"> 20 mins</div>--%>
                                    <%--</div>--%>
                                <%--</a>--%>
                            <%--</li>--%>


                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="tab-pane page-quick-sidebar-settings" id="quick_sidebar_tab_3">--%>
                    <%--<div class="page-quick-sidebar-settings-list">--%>
                        <%--<h3 class="list-heading">General Settings</h3>--%>
                        <%--<ul class="list-items borderless">--%>
                            <%--<li> Enable Notifications--%>
                                <%--<input type="checkbox" class="make-switch" checked data-size="small"--%>
                                       <%--data-on-color="success" data-on-text="ON" data-off-color="default"--%>
                                       <%--data-off-text="OFF"></li>--%>

                        <%--</ul>--%>
                        <%--<h3 class="list-heading">System Settings</h3>--%>
                        <%--<ul class="list-items borderless">--%>
                            <%--<li> Security Level--%>
                                <%--<select class="form-control input-inline input-sm input-small">--%>
                                    <%--<option value="1">Normal</option>--%>
                                    <%--<option value="2" selected>Medium</option>--%>
                                    <%--<option value="e">High</option>--%>
                                <%--</select>--%>
                            <%--</li>--%>
                            <%--<li> Failed Email Attempts--%>
                                <%--<input class="form-control input-inline input-sm input-small" value="5"/></li>--%>
                            <%--<li> Secondary SMTP Port--%>
                                <%--<input class="form-control input-inline input-sm input-small" value="3560"/></li>--%>

                        <%--</ul>--%>
                        <%--<div class="inner-content">--%>
                            <%--<button class="btn btn-success">--%>
                                <%--<i class="icon-settings"></i> 保存--%>
                            <%--</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!-- END QUICK SIDEBAR -->

    <!-- BEGIN UPDATE PASSWORD-->
    <div id="pswModal" class="modal fade" tabindex="-1" data-width="480">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">修改密码</h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" id="pswForm">
                <div class="form-body">
                    <div class="form-group">
                        <label class="control-label col-md-4" style="width: 120px;">旧密码
                            <span class="required"> * </span>
                        </label>
                        <div class="col-md-8">
                            <input type="password" id="oldPsw" name="oldPsw" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" style="width: 120px;">新密码
                            <span class="required"> * </span>
                        </label>
                        <div class="col-md-8">
                            <input type="password" id="newPsw" name="newPsw" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-4" style="width: 120px;">确认新密码
                            <span class="required"> * </span>
                        </label>
                        <div class="col-md-8">
                            <input type="password" id="newPswConfirm" name="newPswConfirm" class="form-control"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn btn-outline dark">关闭</button>
            <button type="button" class="btn green" onclick="javascript:$('#pswForm').submit();">保存</button>
        </div>
    </div>
    <!-- END UPDATE PASSWORD-->


    <!-- START PERSONAL INFO-->
    <div id="infoModal" class="modal fade" tabindex="-1" data-width="780" >
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title">个人信息</h4>
        </div>
        <div id="roleList" class="modal-body" >
            <form class="form-horizontal" id="infoForm">
                <div class="form-body">
                    <div class="form-group ">
                        <label class="control-label col-md-2">头像</label>
                        <div class="col-md-4" id="cinput">
                            <input id="file" name="file" type="file" data-show-caption="true"  title="请选择文件" accept="image/png,image/jpeg">
                        </div>

                        <label class="control-label col-md-2">预览</label>
                        <div class="col-md-4">
                            <img id="mypic" style="width: 200px;height: 150px;" alt="">
                            <input name="pictureUrl" id="pictureUrl" hidden>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2">姓名
                        </label>
                        <div class="col-md-4">
                            <input type="text" id="userAccount" name="userAccount" class="form-control" readonly/>
                        </div>
                        <label class="control-label col-md-2">手机
                        </label>
                        <div class="col-md-4">
                            <input name="phone" id="phone1" type="text" class="form-control"/>
                        </div>
                       <%-- <label class="control-label col-md-2">性别
                        </label>
                        <div class="col-md-4">
                            <select class="bs-select form-control" id="sex1" name="sex">
                                <option value="1">女</option>
                                <option value="0">男</option>
                                <option value="2">保密</option>
                            </select>
                        </div>--%>
                    </div>
                    <div class="form-group">

                        <%--<label class="control-label col-md-2">座机
                        </label>
                        <div class="col-md-4">
                            <input name="tel" id="tel1" type="text" class="form-control"/>
                        </div>--%>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2">邮箱
                        </label>
                        <div class="col-md-4">
                            <input name="email" id="email1" type="text" class="form-control"/>
                        </div>
                       <%-- <label class="control-label col-md-2">地址
                        </label>
                        <div class="col-md-4">
                            <input name="address" id="address1" type="text" class="form-control"/>
                        </div>--%>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn btn-outline dark">关闭</button>
            <button type="button" class="btn green" onclick="submitInfo();">保存</button>
        </div>
    </div>
    <!-- END PERSONAL INFO-->
    <script>
        var pswFormValidate = null;
        $(function () {
            $("#infoForm").validate({
                rules: {
                    email: { //邮箱
                        required: true,
                        email: true,
                        maxlength: 20,
                        remote: {
                            url: "${pageContext.request.contextPath}/users/queryEmail",//校验是否存在
                            type: "post",
                            async: false,
                            dataType: "json",
                            data: {
                                "email": function () {
                                    return $("#email").val();
                                },
                            },
                            dataFilter: function (data) {
                                var result = eval("(" + data + ")");
                                if (result.code == 0) {
                                    return false;
                                } else if (result.code == 500) {
                                    return true;
                                }
                            }
                        }
                    },

                    phone: {//联系电话
                        isMobile: true,
                        maxlength: 20,
                        remote: {
                            url: "${pageContext.request.contextPath}/users/queryPhone",//校验是否存在
                            type: "post",
                            async: false,
                            dataType: "json",
                            data: {
                                "phone": function () {
                                    return $("#phone").val();
                                },
                            },
                            dataFilter: function (data) {
                                var result = eval("(" + data + ")");
                                if (result.code == 0) {
                                    return false;
                                } else if (result.code == 500) {
                                    return true;
                                }
                            }
                        }
                    },
                },
            });

            pswFormValidate = $('#pswForm').validate({
                rules: {
                    oldPsw: {
                        required: true
                    },
                    newPsw: {
                        required: true
                    },
                    newPswConfirm: {
                        required: true,
                        equalTo: "#newPsw"
                    }
                },
                messages: {
                    oldPsw: {
                        required: "<span style='color: red'>请输入旧密码</span>"
                    },
                    newPsw: {
                        required: "<span style='color: red'>请输入新密码</span>"
                    },
                    newPswConfirm: {
                        required: "<span style='color: red'>请输入确认密码</span>",
                        equalTo: "<span style='color: red'>新密码和确认新密码不一致，请重新输入</span>"
                    }
                },
                submitHandler: function (form) {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/users/changePsw",
                        dataType: "json",
                        data: {psw: $('#oldPsw').val(), newPsw: $('#newPsw').val()},
                        type: "post",
                        success: function (data) {
                            $('#pswModal').modal('hide');
                            if (data.code == 0) {
                                Command:toastr["success"](data.msg);
                            } else {
                                Command:toastr["warning"](data.msg);
                            }
                        },
                        error: function (XMLResponse) {
                            Command:toastr["error"](XMLResponse.type);
                        }
                    });
                }
            });
            //初始化时间组件
            $('.datetimepicker').datetimepicker({
                language: 'zh-CN',         //语言选择中文
                format: "yyyy-mm-dd",      //格式化日期
                timepicker: false,    //关闭时间选项
                yearStart: 2016,

                autoclose: true,
                yearEnd: 2050,        //设置最大年份
                todayBtn: true,    //关闭选择今天按钮
                startView: 2,
                minView: 2,
                todayHighlight: true
            });


        });
        /**
         *重置信息
         **/
        function showPswModal() {
            pswFormValidate.resetForm();
            $('#pswForm input').val('');
        }
        ;
        /**
         *显示个人信息
         **/
        function showCurrentInfo() {
            $.ajax({
                url: "${pageContext.request.contextPath}/users/baseInfo",
                dataType: "json",
                data: null,
                type: "post",
                success: function (data) {
                    $('#infoForm input').val('');
                    $('#userAccount').val(data.info.userAccount);
                    $('#email1').val(data.info.email);
//                    $('#tel1').val(data.info.tel);
                    $('#phone1').val(data.info.phone);
//                    $('#birthday1').val(data.info.birthday);
                    $('#address1').val(data.info.address);
                    $('#pictureUrl').val(data.info.pictureUrl);
                    $('#mypic').attr("src",data.info.pictureUrl);
                    var sexSelect = document.getElementById('sex1');
                    for (var i = 0; i < sexSelect.options.length; i++) {
                        var option = sexSelect.options[i];
                        if (option.value == data.info.sex) {
                            option.selected = true;
                        } else {
                            option.selected = false;
                        }
                    }
                    ;
                },
                error: function (XMLResponse) {
                    Command:toastr["error"](XMLResponse.type);
                }
            });
        };

        /**
         * 保存用户基本信息
         */
        function submitInfo() {
            $.ajax({
                url: "${pageContext.request.contextPath}/users/updateInfo",
                dataType: "json",
                data: $('#infoForm').serialize(),
                type: "post",
                success: function (data) {
                    $('#infoModal').modal('hide');
                    if (data.code == 0) {
                        Command:toastr["success"](data.msg);
                    } else {
                        Command:toastr["warning"](data.msg);
                    }
                },
                error: function (XMLResponse) {
                    Command:toastr["error"](XMLResponse.type);
                }
            });
        };
        $(function () {
            var path = "${pageContext.request.contextPath}/upload/uploadImg";
            initFileInput("file", path);
            $("#file").on("click",function () {
                controlInput.fileinput("clear");
            })
        });
        //初始化inputfile控件
        var controlInput=null;
        function initFileInput(ctrlName, uploadUrl) {
            var control = $('#' + ctrlName);
            controlInput=control.fileinput({
                language: 'zh',
                uploadUrl: uploadUrl,  //上传地址
                showUpload: false, //是否显示上传按钮
                showCaption: false,
                showRemove: true,
                dropZoneEnabled: false,
                showCaption: false,//是否显示标题
                allowedPreviewTypes: ['image'],
                allowedFileTypes: ['image'],
                allowedFileExtensions: ['jpg', 'png'],
                resizeImage:false,
                maxImageWidth:500,
                maxImageHeight:800,
                maxFileSize: 200,
                maxFileCount: 1,
                autoReplace:true,
                enctype: 'multipart/form-data',
                msgSizeTooLarge:'文件超过了允许大小{maxSize}KB',
                msgImageWidthLarge:"图像文件的宽度不能超过{size}像素",
                msgImageHeightLarge:"图像文件的高度不能超过{size}像素",
                msgValidationError:$('#file').val(),
                validateInitialCount:true,
                fileActionSettings:{
                    showRemove:false,
                    showUpload:false,
                    showZoom:false,
                    showDrag:false
                }

            }).on("filebatchselected", function (event, files) {
                if(files.length>0){
                   /* var r = new FileReader();  //本地预览
                    r.readAsDataURL(files[0]);    //Base64
                    r.onload = function (e) {
                        document.getElementById('mypic').src = r.result;
                    };*/
                    $(this).fileinput("upload");
                }else{
                    var title=$('#file').val();
                    title=title.substring(title.lastIndexOf("\\")+1,title.length);
                    $('#cinput .file-caption').attr("title",title);
                    document.getElementById('mypic').src="";
                }
            }).on("fileuploaded", function (event, data) {
                if(data.response.code==0){
                    document.getElementById("pictureUrl").value=data.response.msg[0];
                    document.getElementById('mypic').src = data.response.msg[0];
                }else{
                    Command:toastr["error"](data.response.msg);
                }
                setTimeout(function (e) {
                    $('#file').fileinput("refresh").fileinput('enable');
                },300);
            }).on("fileerror",function(event, data, msg) {
               // console.log(msg)
            });
        };

        var heartLogo='<shiro:principal property="pictureUrl"></shiro:principal>';
        if(heartLogo!="" && heartLogo!='null'){
            document.getElementById("myHeartLogo").src=heartLogo;
        }



    </script>
</div>

