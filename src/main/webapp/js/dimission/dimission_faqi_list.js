var $table=null;
$(function () {

    $table = $('#faqiTable').bootstrapTable({
        method: 'post',
        cache: false, // 不缓存
        toolbar: '#toolbar', //工具按钮用哪个容器
        height: $(window).height()-200,
        striped: true,  // 隔行加亮
        pagination: true, //是否显示分页（*）
        pageSize: 10, //每页的记录行数（*）
        pageNumber:1, //初始化加载第一页，默认第一页
        pageList: [10, 20, 50, 100, 200, 500],
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        paginationFirstText: "首页",
        paginationLastText: "末页",
        showColumns: true,
        showExport: true,
        clickToSelect: true, //是否启用点击选中行
        singleSelect:true,//单选
        minimumCountColumns: 2,  //最少允许的列数 clickToSelect: true,
        queryParamsType:'undefined',//设置为"undefined",可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为"limit",符合 RESTFul 格式的参数,可以获取limit, offset, search, sort, order
        sidePagination: "server",
        url:"/dimission/list",
        exportTypes: ['json', 'xml', 'csv', 'txt', 'sql', 'excel'],
        dataType:"json",
        sortOrder : "desc",
        sortName : "create_time",
        //queryParams : function(params){
        //    var q = queryParams(params);
        //    return q;
        //},
        contentType: "application/x-www-form-urlencoded",
        columns: [
            {
                checkbox:true,
            },
            {field:"id",title:"序号",align:"center",valign:"middle"},
            {field:"name",title:"姓名",align:"center",valign:"middle",sortable:"true"},
            {field:"meituanId",title:"美团ID",align:"center",valign:"middle",sortable:"true"},
            {field:"telephone",title:"手机号码",align:"center",valign:"middle"},
            {field:"operate",title:"操作",align:"center",valign:"middle", formatter :operateformatter}
        ],
        onLoadSuccess: function (data) { //加载成功时执行
        },
        onLoadError: function (res) { //加载失败时执行
        },
        onClickRow : function(row, tr,flied){

        }
    });

    $(window).resize(function () {
        $('#faqiTable').bootstrapTable('resetView');
    });

    //银行验证
    $("#leaveForm").validate({
        onfocusout: true,//失去焦点时不验证
        rules: {
            leavName : {
                required : true,
            },
            reqdate : {
                required : true,
            },
            reason : {
                required : true,
            }

        },
        messages: {

        }

    });

    //初始化时间组件
    $(".datetimepicker").datetimepicker({
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

//初始化操作栏
var operateformatter = function (value, row, index) {
    return '<a href="" class="pull-center btn btn-xs btn-info" data-toggle="modal" data-target="#leave" onclick="tijiao('+index+')">递交离职</a>';
};


//递交离职 modal赋值
function tijiao (index) {
    var datas = $table.bootstrapTable('getData');
    var data=datas[index];//获取这行数据
    $("#reason").val(data.reason);
    $("#leavName").val(data.name);
    $("#reqdate").val(data.reqdate);
    $("#leavId").val(data.id);
}

//发起离职确认
function saveLeave() {
    var isValid = false;
    if (!$("#leaveForm").valid()) {
        isValid = false;
        return;
    }else {
        isValid = true;
    }
    if(isValid) {
        $.ajax({
            url : "/sysUser/update",
            data : {
                reason : $("#reason").val(data.reason),
                name : $("#leavName").val(data.name),
                reqdate : $("#reqdate").val(data.reqdate),
                id : $("#leavId").val(data.id),
            },
            type : "post",
            dataType : "json",
            success : function(result) {
                if (result.code == 0) {
                    Command: toastr["success"]("保存成功");
                }
                $("#leave").modal("hide");
                $('#faqiTable').bootstrapTable('refresh');
            },
            error : function() {
                Command: toastr["error"]("系统异常，请联系管理员");
            }
        });
    }
}
