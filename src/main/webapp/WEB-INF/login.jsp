<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/13
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" >
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="${pageContext.request.contextPath}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />


    <link href="${pageContext.request.contextPath}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" type="text/css" />
    <!-- END THEME GLOBAL STYLES -->
    <style>
        .login {
            background-color: #364150 !important;
        }

        .login .logo {
            margin: 0 auto;
            margin-top: 60px;
            padding: 15px;
            text-align: center;
        }

        .login .content {
            background-color: white;
            -webkit-border-radius: 7px;
            -moz-border-radius: 7px;
            -ms-border-radius: 7px;
            -o-border-radius: 7px;
            border-radius: 7px;
            width: 400px;
            margin: 40px auto 10px auto;
            padding: 30px;
            padding-top: 10px;
            overflow: hidden;
            position: relative;
        }

        .login .content h3 {
            color: #4db3a5;
            text-align: center;
            font-size: 28px;
            font-weight: 400 !important;
        }

        .login .content h4 {
            color: #555;
        }

        .login .content .hint {
            color: #999;
            padding: 0;
            margin: 15px 0 7px 0;
        }

        .login .content .login-form,
        .login .content .forget-form {
            padding: 0px;
            margin: 0px;
        }

        .login .content .form-control {
            border: none;
            background-color: #dde3ec;
            height: 43px;
            color: #8290a3;
            border: 1px solid #dde3ec;
        }

        .login .content .form-control:focus, .login .content .form-control:active {
            border: 1px solid #c3ccda;
        }

        .login .content .form-control::-moz-placeholder {
            color: #8290a3;
            opacity: 1;
        }

        .login .content .form-control:-ms-input-placeholder {
            color: #8290a3;
        }

        .login .content .form-control::-webkit-input-placeholder {
            color: #8290a3;
        }

        .login .content select.form-control {
            padding-left: 9px;
            padding-right: 9px;
        }

        .login .content .forget-form {
            display: none;
        }

        .login .content .register-form {
            display: none;
        }

        .login .content .form-title {
            font-weight: 300;
            margin-bottom: 25px;
        }

        .login .content .form-actions {
            clear: both;
            border: 0px;
            border-bottom: 1px solid #eee;
            padding: 25px 30px 25px 30px;
            margin-left: -30px;
            margin-right: -30px;
        }

        .login .content .form-actions > .btn {
            margin-top: -2px;
        }

        .login-options {
            margin-top: 30px;
            margin-bottom: 30px;
            overflow: hidden;
        }

        .login-options h4 {
            float: left;
            font-weight: 600;
            font-size: 15px;
            color: #7d91aa !important;
        }

        .login-options .social-icons {
            float: right;
            padding-top: 3px;
        }

        .login-options .social-icons li a {
            border-radius: 15px 15px 15px 15px !important;
            -moz-border-radius: 15px 15px 15px 15px !important;
            -webkit-border-radius: 15px 15px 15px 15px !important;
        }

        .login .content .form-actions .checkbox {
            margin-left: 0;
            padding-left: 0;
        }

        .login .content .forget-form .form-actions {
            border: 0;
            margin-bottom: 0;
            padding-bottom: 20px;
        }

        .login .content .register-form .form-actions {
            border: 0;
            margin-bottom: 0;
            padding-bottom: 0px;
        }

        .login .content .form-actions .btn {
            margin-top: 1px;
        }

        .login .content .form-actions .btn {
            font-weight: 600;
            padding: 10px 20px !important;
        }

        .login .content .form-actions .btn-default {
            font-weight: 600;
            padding: 10px 25px !important;
            color: #6c7a8d;
            background-color: #ffffff;
            border: none;
        }

        .login .content .form-actions .btn-default:hover {
            background-color: #fafaff;
            color: #45b6af;
        }

        .login .content .forget-password {
            font-size: 14px;
            float: right;
            display: inline-block;
            margin-top: 10px;
        }

        .login .content .check {
            color: #8290a3;
        }

        .login .content .rememberme {
            margin-left: 8px;
        }

        .login .content .create-account {
            margin: 0 -40px -30px -40px;
            padding: 15px 0 17px 0;
            text-align: center;
            background-color: #6c7a8d;
            -webkit-border-radius: 0 0 7px 7px;
            -moz-border-radius: 0 0 7px 7px;
            -ms-border-radius: 0 0 7px 7px;
            -o-border-radius: 0 0 7px 7px;
            border-radius: 0 0 7px 7px;
        }

        .login .content .create-account > p {
            margin: 0;
        }

        .login .content .create-account p a {
            font-weight: 600;
            font-size: 14px;
            color: #c3cedd;
        }

        .login .content .create-account a {
            display: inline-block;
            margin-top: 5px;
        }

        /* footer copyright */
        .login .copyright {
            text-align: center;
            margin: 0 auto 30px 0;
            padding: 10px;
            color: #7a8ca5;
            font-size: 13px;
        }

        @media (max-width: 440px) {
            /***
            Login page
            ***/
            .login .logo {
                margin-top: 10px;
            }

            .login .content {
                width: 280px;
                margin-top: 10px;
            }

            .login .content h3 {
                font-size: 22px;
            }

            .forget-password {
                display: inline-block;
                margin-top: 20px;
            }

            .login-options .social-icons {
                float: left;
                padding-top: 3px;
            }

            .login .checkbox {
                font-size: 13px;
            }
        }

        .sweet-alert{
            height: 200px;
        }
    </style>

</head>
<body class=" login">
<div class="logo">

</div>
<div class="content">
    <!-- BEGIN LOGIN FORM -->
    <form class="login-form" id="loginForm" method="post" action="">
        <h3 class="form-title font-green">登录</h3>

        <div class="form-group">
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off"
                   placeholder="用户名" id="account" name="account"/>
        </div>
        <div class="form-group">
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off"
                   placeholder="密码" id="password" name="password"/>
        </div>

    <%--<div class="form-group">--%>
            <%--<input class="form-control form-control-solid " type="text" autocomplete="off"--%>
                   <%--placeholder="验证码" id="captcha" name="captcha" style="width: 35%;display: inline-block"/>--%>
            <%--<img src="captcha.jpg" id="createCheckCode" style="width: 150px;height: 43px;margin-top: -3px;">--%>
            <%--<a style="position: relative;top: 5px;left: 5px;" href="#" onclick="codeReload()">换一个</a>--%>
        <%--</div>--%>
        <div class="form-actions"  style="text-align: center">
            <button type="button" class="btn green uppercase" id="subBtn" onclick="userLogin();" >登录</button>
            <button type="button" class="btn green uppercase" data-toggle="modal" data-target="#responsive">注册</button>
        </div>

    </form>
</div>

<!-- 注册页面 -->
<div id="responsive" class="modal fade "  tabindex="-1" data-width="500px" >
    <form id="addUserForm" class="form-horizontal" style="height: 600px">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3 class="modal-title font-green" align="center">注册</h3>
        </div>
        <div class="modal-body" >
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN FORM-->
                    <div class="form-body" >
                       <%-- <div class="form-group">
                            <label class="control-label col-md-3">名称
                                <span class="required"> * </span>
                            </label>
                            <div class="col-md-6">
                                <input type="text" data-required="1" class="form-control" id="userName" name="userName"/>
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <label class="control-label col-md-3">账户名
                                <span class="required"> * </span>
                            </label>
                            <div class="col-md-6">
                                <input type="text" data-required="1" class="form-control" id="userAccount" name="userAccount" placeholder="最少由6位数字或英文组成"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">密码
                                <span class="required"> * </span>
                            </label>
                            <div class="col-md-6">
                                <input type="password" data-required="1" class="form-control" placeholder="请输入英文或数字" id="userPassword" name="userPassword" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">确认密码
                                <span class="required"> * </span>
                            </label>
                            <div class="col-md-6">
                                <input type="password" data-required="1" class="form-control" placeholder="请输入英文或数字" id="userPsws" name="userPsws"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3">手机号
                            </label>
                            <div class="col-md-6">
                                <input type="text" data-required="1" class="form-control" placeholder="请输入11位的手机号" id="phone" name="phone" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3">电子邮箱
                                <span class="required"> * </span>
                            </label>
                            <div class="col-md-6">
                                <input type="text" data-required="1" class="form-control" id="email" name="email"/>
                            </div>
                        </div>
                       <div class="form-group">
                           <label class="control-label col-md-3">验证码
                               <span class="required"> * </span>
                           </label>
                           <input class="form-control" type="text" autocomplete="off"
                                  placeholder="请输入验证码" id="captcha" name="captcha" style="width: 25%;display: inline-block"/>
                           <img src="captcha.jpg" id="createCheckCode" style="width: 100px;height: 43px;margin-top: -3px;">
                           <a style="position: relative;top: 5px;left: 5px;" href="#" onclick="codeReload()">换一个</a>
                       </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-8">
                            <label class="control-label col-md-4">
                            </label>
                            <input type="checkbox" id="agreement" name="agreement">阅读并同意</input><a data-toggle="modal"  data-target="#registrationAgreement">《注册协议》</a>
                        </div>
                    </div>
                </div>
                <!-- END FORM-->
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn btn-outline dark">关闭</button>
            <button type="button" class="btn green" onclick="saveUser()">保存</button>
        </div>
    </form>
</div>

<div id="registrationAgreement" class="modal fade "  tabindex="-1" data-width="1100px" >
    <form id="adddForm" class="form-horizontal" style="height: 700px">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h3 class="modal-title font-green" align="center">注册须知</h3>
        </div>
        <div class="modal-body" >
            <p>&nbsp&nbsp&nbsp&nbsp欢迎您来到陕西北元化工集团有限公司（以下简称北元集团）电子采购系统，在申请注册成为北元集团电子采购系统用户前，请您仔细阅读下列内容，以便维护您的合法权益：</p>
            <p>一、北元集团采购基本原则<br>
                1、践行“诚信为本”的经营理念，愿与您建立起“平等互利、长期合作”的良好关系。<br>
                2、北元集团的物资采购项目均预先在电子采购系统进行公告。<br>
                3、北元集团将选择具有以下优势的供应商作为长期合作伙伴：信誉优良、技术先进、质量可靠、服务完善、价格优惠。<br>
                4、供应商具有下列行为的，一经查实，将被列入北元集团采购黑名单，受到业务限制、短期或长期禁入等处罚：<br>
                （1）提供虚假资质文件、业绩证明等材料。<br>
                （2）虚假报价、串标和围标。<br>
                （3）中标后拒不签署或履行合同。<br>
                （4）供应掺假、掺杂原材料。<br>
                （5）提供的产品质量和服务未达到合同约定引发重大质量、安全事故。<br>
                （6）向公司人员行贿或给予好处的。<br></p>
            <p>二、北元集团电子采购业务的操作流程<br>
                1、通过互联网进入陕西北元化工集团有限公司门户网站，点击电子采购平台，按照“使用帮助”中的相关提示完成注册，并提交营业执照、税务登记证、组织机构代码等资质文件（原件的扫描件）。<br>
                2、北元集团对您提交的资料进行评审，评审通过后，您成为正式用户。如您所提交的有误或不齐全，会提醒您及时完善。<br>
                3、成为正式用户后，您可以查看北元集团的采购信息及联系信息。<br>
                4、您可以通过北元集团电子采购系统进行报价和投标。<br>
                5、北元集团在网上开标,评标、发布中标公告。<br>
                6、双方签定书面合同，履行合同。<br></p>
            <p>三、注册用户的权利与义务<br>
                1、权利<br>
                （1）可以在北元集团电子采购系统上查询相关采购信息。<br>
                （2）享有提交相关竞价信息等服务的权利。<br>
                （3）在使用电子采购系统时出现登录、发布、搜索等问题时，有获得相关帮助的权利。<br>
                （4）有权对电子采购系统提出改进建议和服务需求。<br>
                （5）有权对相关业务以及内部人员进行投诉。<br>
                2、义务<br>
                （1）应保证其所提供资料的真实性和准确性。<br>
                （2）中标后应在规定期限内签订合同。<br>
                （3）妥善保管账号和密码，不得借给其它个人或单位使用。如发生遗失或泄露，应自行承担相关法律后果。<br>
                （4）不得利用帐号对电子采购系统非法登录，禁止破坏电子采购系统数据或从事其他违法活动。<br>
                （5）遵守本注册须知、采购政策及电子采购系统的相关管理规定。如与北元集团开展业务时，应遵守双方之间的相关合同及约定。<br></p>
            <p>四、北元集团的权利与义务<br>
                1、权利<br>
                （1）当用户违反本须知内容、采购政策或北元集团电子采购系统的相关管理规定时，有权利取消其信息的发布。<br>
                （2）当用户违反协议规定时，有权利取消其信息的发布。<br>
                （3）当网站出现安全方面的紧急状况时或应政府的要求，有权暂停服务。<br>
                （4）有权对网站功能、服务进行相应的变更。<br>
                （5）在提请通知用户的情况下，可以暂停网站以进行相关维护和完善。<br>
                2、义务<br>
                （1）及时将用户在合同中要求的信息发布到北元集团电子采购系统中。<br>
                （2）向用户提供合同中要求的竞价服务。<br>
                （3）保证电子采购系统信息的准确性和安全性。<br>
                （4）对于用户的相关信息予以保密。<br></p>
            <p>五、免责条款<br>
                1、北元集团对任何因用户不正当或非法使用服务，或因用户发布言论、信息而产生的直接、间接、偶然、特殊及后续的损害不承担任何责任。<br>
                2、北元集团对因第六条规定的不可抗力原因造成的服务中断或不能满足用户的要求及其他后果不承担任何责任。<br>
                3、由于通信线路、网络、用户所在位置以及其他任何技术原因而导致用户不能接受本系统服务时，北元集团不承担任何责任。<br>
                4、对于因注册用户提交资料不准确或不及时更新其资料而给他人或自身原因造成的任何损失、影响及风险，北元集团不承担任何责任。<br>
                5、北元集团对在网上的任何交易、交易进程不提供任何类型的担保，不论是明示的或默示的。<br>
                6、供应商用户理解、判断或决定是否接受任何通过北元集团电子采购系统所取得信息资料的可靠性，完全取决于供应商用户自己并承担相关的风险。<br></p>
            <p>六、不可抗力 以下情况应视为不可抗力：<br>
                1、本系统已经采取合理的电脑病毒防护措施，但仍遭受电脑病毒破坏而致使用户资料受损或无法正常使用网站的。<br>
                2、本系统已经采取合理的防电脑黑客入侵手段，但仍遭受电脑黑客入侵致使用户资料受损或被窃取。<br>
                3、因计算机设施或操作系统软件本身固有的技术缺陷而引起的用户资料数据受损或被窃取的。<br>
                4、其他无法预见、无法避免且无法克服的情况。<br></p>
            <p>七、适用法律 本电子采购系统管理及服务适用《中华人民共和国合同法》、《中华人民共和国公安部计算机安全法》等法律法规。用户可以下载本网站上显示的资料，但不得用于任何商业用途。</p>
            <p> 八、争议解决 如因本电子采购系统而发生任何争议，双方友好协商解决,协商不成应向北元集团所在地人民法院提起诉讼。</p>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn btn-outline dark">关闭</button>
        </div>
    </form>
</div>




</body>
</html>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-sweetalert/sweetalert.min.js" type="text/javascript"></script>

<!--框架js-->
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-toastr/toastr.min.js" type="text/javascript"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.custom.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.messages_cn.js"></script>





<script>
    $(function () {
        $("#addUserForm").validate({
            rules: {
                userAccount: { //用户名
                    required: true,
                    maxlength: 50,
                    isFullAccount: true,
                    remote: {
                        url: "${pageContext.request.contextPath}/users/queryUser",//校验是否存在
                        type: "post",
                        async: false,
                        dataType: "json",
                        data: {
                            "userAccount": function () {
                                return $("#userAccount").val();
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
                email: { //邮箱
                    required: true,
                    email: true,
                    maxlength: 100,
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
                userPassword: {//密码
                    required: true
                },
                userPsws: {//确认密码
                    required: true,
                    equalTo: "#userPassword"
                },
            },
            messages: {
                userAccount: {
                    isFullAccount: "<span style='color: red'>输入至少6个数字或英文</span>",
                    remote: "<span style='color: red'>账号已存在</span>"
                },

                email: {
                    remote: "<span style='color: red'>邮箱已存在</span>"
                },
                phone: {
                    remote: "<span style='color: red'>联系电话已存在</span>"
                },
                userPsw: {
                    required: "<span style='color: red'>请输入密码</span>"
                },
                userPsws: {
                    required: "<span style='color: red'>请输入确认密码</span>",
                    equalTo: "<span style='color: red'>密码和确认密码不一致，请重新输入</span>"
                }
            },


            submitHandler: function (form) {
                var method_url = "${pageContext.request.contextPath}/users/sendEmail";
                $.ajax({
                    url: method_url,
                    dataType: "json",
                    data: {
                        userPassword: $("#userPassword").val(),
                        userAccount: $("#userAccount").val(),
                        phone: $("#phone").val(),
                        email: $("#email").val(),
                        captcha: $("#captcha").val(),

                    },
                    type: "post",
                    success: function (data) {
                        //console.log(data.code);
                        if (data.success) {
                            Command: toastr["success"](data.msg);
                            $("#userAccount").val("");
                            $("#userPassword").val("");
                            $("#userPsws").val("");
                            $("#phone").val("");
                            $("#email").val("");
                            $("#captcha").val("");
                            $("#agreement").prop("checked",false);
                            $('#responsive').modal('hide');
                        } else {
                            //alertTittlewin("ERROR", "邮件发送失败", 200);
                            Command: toastr["error"](data.msg);
                            codeReload();
                        }
                    },
                    error: function (XMLResponse) {
                    }
                });
            }
        });

        var errorMsg='${message_login}';
        if(errorMsg!=undefined && errorMsg!=''){
            swal({
                title: "提示",
                text: errorMsg,
                confirmButtonClass:"btn-warning",
                confirmButtonText: "确定"
            });
        }

    });

    function saveUser() {
        if ($('#agreement').prop("checked")){
            $("#addUserForm").submit();
        }else{
            Command: toastr["error"]("请阅读并同意注册协议");
        }
    }

    $('#loginForm input').keyup(function (event) {
        if(event.keyCode ==13){
            userLogin();
        }
    });

    /**
     *登录
     **/
    function userLogin(){
        var username=$('#username').val();
        var psw=$('#password').val();
//        var code=$('#captcha').val();
        if(username!="" && psw!=""){
            $("#loginForm").submit();
        }else{
            swal({
                title: "提示",
                text: "用户名、密码不能为空！",
                confirmButtonClass:"btn-warning",
                confirmButtonText: "确定"
            });
        }
    };

    //切换验证码
    function codeReload() {
        var url = '${pageContext.request.contextPath}/captcha.jpg?t=' + new Date().getTime();
        $('#createCheckCode').attr('src', url);
    }

    function close() {
        window.history.go(-1);
    }

</script>
