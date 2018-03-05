<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->

<link href="${pageContext.request.contextPath}/assets/global/css/google-fonts.css" rel="stylesheet" type="text/css" />

<!-- BEGIN THEME GLOBAL STYLES -->
<link href="${pageContext.request.contextPath}/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->

<!-- BEGIN THEME LAYOUT STYLES -->
<link href="${pageContext.request.contextPath}/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="${pageContext.request.contextPath}/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME LAYOUT STYLES -->

<!--BEGIN BOOTSTRAP INPUT FILE-->
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-fileinput/fileinput.min.css" rel="stylesheet" type="text/css" />
<!--END BOOTSTRAP INPUT FILE-->

<link rel="shortcut icon" href="favicon.ico" />

<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-table-1.11.1/bootstrap-table.css" rel="stylesheet" type="text/css" />

<!-- BEGIN DATE STYLES-->
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstraptime/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<!-- END DATE STYLES-->


<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/assets/global/plugins/zTree_v3/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-sweetalert/sweetalert.css" rel="stylesheet" type="text/css" >

<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/global/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/ie8.fix.min.js"></script>
<![endif]-->

<!-- BEGIN CORE PLUGINS -->
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!--BEGIN BOOTSTRAP INPUT FILE-->
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-fileinput/fileinput.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-fileinput/zh.js" type="text/javascript"></script>
<!--END BOOTSTRAP INPUT FILE-->
<script src="${pageContext.request.contextPath}/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/moment.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstraptime/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstraptime/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${pageContext.request.contextPath}/assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${pageContext.request.contextPath}/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-table-1.11.1/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-table-1.11.1/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-table-1.11.1/extensions/export/bootstrap-table-export.js"></script>

<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js"></script>

<script src="${pageContext.request.contextPath}/assets/global/plugins/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/zTree_v3/js/jquery.ztree.excheck.min.js"></script>

<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.custom.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-validation/jquery.validate.messages_cn.js"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-sweetalert/sweetalert.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-toastr/toastr.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-cookie/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/global/scripts/underscore.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/common/common.js" type="text/javascript"></script>


