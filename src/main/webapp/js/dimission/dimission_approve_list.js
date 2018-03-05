var $table=null;
$(function () {

    $table = $('#approveTable').bootstrapTable({
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
            {field:"reason",title:"离职原因",align:"center",valign:"middle"},
            {field:"reqdate",title:"发起时间",align:"center",valign:"middle"},
            //{field:"leavedate",title:"审批时间",align:"center",valign:"middle", formatter : leaveFor},
            {field:"reqtype",title:"离职类型",align:"center",valign:"middle", formatter : typeFor},
            {field:"state",title:"所处状态",align:"center",valign:"middle", formatter : statusFor},
            {field:"operate",title:"物料归还",align:"center",valign:"middle", formatter : wlFormatter},
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
        $('#reportTable').bootstrapTable('resetView');
    });
});

//离职类型
var typeFor = function(value, row, index) {
    if (value == 0) {
        return '试岗不合格';
    }
    if (value == 1) {
        return '骑手申请';
    }
    if (value == 2) {
        return '缺勤申请';
    }
    if (value == 3) {
        return '站长代申请';
    }
};

//状态
var statusFor = function(value, row, index) {
    if (value == 0) {
        return '申请离职';
    }
    if (value == 2) {
        return '站长审批通过';
    }
    if (value == -1) {
        return '站长驳回';
    }
    if (value == 3) {
        return '人事审批通过';
    }
    if (value == 4) {
        return '已离职';
    }
};

//初始化操作栏
var operateformatter = function (value, row, index) {
    return '<a href="" class="pull-center btn btn-xs btn-info" onclick="dijiao('+index+')">递交人事</a>' +
        '<a href="" class="pull-center btn btn-xs btn-info" onclick="bohui('+index+')">站长驳回</a>';
};
  //初始化物料归还
var wlFormatter = function (value, row, index) {
    return '<a href="/material/update_article3_page" class="pull-center btn btn-xs btn-info">物料归还</a>';
};

//var leaveFor = function (value, row, index) {
//    return '<input id="CreationTime" class="easyui-datebox" type="datetime">';
//};

//递交人事 修改状态
function dijiao (index) {
    var datas = $table.bootstrapTable('getData');
    var data=datas[index];//获取这行数据
    $.ajax({
        url : "/sysUser/update",
        data : {
            id : data.id
        },
        type : "post",
        dataType : "json",
        success : function(result) {
            $('#reportTable').bootstrapTable('refresh');
            if (result.code == 0) {
                Command: toastr["success"]("递交成功");
            }else {
                Command: toastr["error"]("递交失败");
            }
        },
        error : function() {
            Command: toastr["error"]("系统异常，请联系管理员");
        }
    });

}
//站长驳回 修改状态
function bohui(index) {
    var datas = $table.bootstrapTable('getData');
    var data=datas[index];//获取这行数据
    $.ajax({
        url : "/sysUser/update",
        data : {
            id : data.id
        },
        type : "post",
        dataType : "json",
        success : function(result) {
            $('#reportTable').bootstrapTable('refresh');
            if (result.code == 0) {
                Command: toastr["success"]("驳回成功");
            }else {
                Command: toastr["error"]("驳回失败");
            }
        },
        error : function() {
            Command: toastr["error"]("系统异常，请联系管理员");
        }
    });
}