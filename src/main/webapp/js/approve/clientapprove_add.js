var uploader; // 文件上传组件对象
// 获取上传的文件信息
var uploadDocs = [];
$(function() {

    showChemical();
    $("input[name='isChemical']").click(function(){
        showChemical();
    });

    //所属地区模糊搜索
    $("#areaName").autocomplete({
        source:function( request, response ) {
            $.ajax({
                url : basePath +"/approveBase/selectByAreaName",
                type : "post",
                dataType : "json",
                data : {
                    areaName :request.term
                },
                success: function( data ) {
                    response( $.map( data.data, function( item ) {
                        return {
                            label: item.address,// 下拉项显示内容
                            value: item.areaId // 下拉项对应数值
                        }
                    }));
                }
            });
        },
        minLength: 1,  // 输入框字符个等于2时开始查询
        focus: function( event, ui ) {
            $("#areaName").val( ui.item.label );
            return false;
        },
        select: function( event, ui ) {// 选中某项时执行的操作
            $("#areaName").val( ui.item.label );
            $("#area").val( ui.item.value );
            return false;
        }
    });

    ////产品分类模糊搜索
    //$("#productTypeNames").autocomplete({
    //    source:function( request, response ) {
    //        $.ajax({
    //            url : basePath +"/approveBase/selectByProductTypeName",
    //            type : "post",
    //            dataType : "json",
    //            data : {
    //                productTypeName :request.term,
    //                flag : 0
    //            },
    //            success: function( data ) {
    //                response( $.map( data.data, function( item ) {
    //                    return {
    //                        label: item.lbmc,// 下拉项显示内容
    //                        value: item.lbbmId // 下拉项对应数值
    //                    }
    //                }));
    //            }
    //        });
    //    },
    //    minLength: 1,  // 输入框字符个等于2时开始查询
    //    focus: function( event, ui ) {
    //        //$("#productTypeNames_"+i).val( ui.item.label );
    //        $("#productTypeNames").val( ui.item.label );
    //        return false;
    //    },
    //    select: function( event, ui ) {// 选中某项时执行的操作
    //        //$("#productTypeNames_"+i).val( ui.item.label );
    //        //$("#productTypes_"+i).val( ui.item.value );
    //        $("#productTypeNames").val( ui.item.label );
    //        $("#productTypes").val( ui.item.value );
    //        return false;
    //    }
    //});

    //for(var i=1; i<=prIndex; i++) {
    //    //产品分类模糊搜索
    //    $("#productTypeNames_"+i).autocomplete({
    //        source:function( request, response ) {
    //            $.ajax({
    //                url :  basePath +"/approveBase/selectByProductTypeName",
    //                type : "post",
    //                dataType : "json",
    //                data : {
    //                    productTypeName :request.term,
    //                    flag : 0
    //                },
    //                success: function( data ) {
    //                    response( $.map( data.data, function( item ) {
    //                        return {
    //                            label: item.lbmc,// 下拉项显示内容
    //                            value: item.lbbmId // 下拉项对应数值
    //                        }
    //                    }));
    //                }
    //            });
    //        },
    //        minLength: 1,  // 输入框字符个等于2时开始查询
    //        focus: function( event, ui ) {
    //            //$("#productTypeNames_"+i).val( ui.item.label );
    //            $(this).val( ui.item.label );
    //            return false;
    //        },
    //        select: function( event, ui ) {// 选中某项时执行的操作
    //            //$("#productTypeNames_"+i).val( ui.item.label );
    //            //$("#productTypes_"+i).val( ui.item.value );
    //            $(this).val( ui.item.label );
    //            $(this).parent().find(".pType").val( ui.item.value );
    //            return false;
    //        }
    //    });
    //}

    //银行类别模糊搜索
    $("#bankTypeNameOne").autocomplete({
        source:function( request, response ) {
            $.ajax({
                url :  basePath +"/approveBase/selectByBankTypeName",
                type : "post",
                dataType : "json",
                data : {
                    bankTypeName : request.term
                },
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
            $("#bankTypeNameOne").val( ui.item.label );
            return false;
        },
        select: function( event, ui ) {// 选中某项时执行的操作
            //$('#bankTypeId').focus();
            $("#bankTypeNameOne").val(ui.item.label);
            $("#bankTypeOne").val(ui.item.value);
            $("#bankTypeTwo").val(ui.item.value);
            $("#depositBankNameOne").val("");
            $("#depositBankOne").val("");
            return false;
        },

    });

    //开户银行模糊搜索
    $("#depositBankNameOne").autocomplete({
        source:function( request, response ) {
            $.ajax({
                url :  basePath +"/approveBase/selectByDepositBankName",
                type : "post",
                dataType : "json",
                data : {
                    bankName : request.term,
                    bankType : $("#bankTypeTwo").val()
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
            $("#depositBankNameOne").val( ui.item.label );
            return false;
        },
        select: function( event, ui ) {// 选中某项时执行的操作
            //$('#bankTypeId').focus();
            $("#depositBankNameOne").val(ui.item.label);
            $("#depositBankOne").val(ui.item.value);
            $("#associatedNumber").val(ui.item.value);
            return false;
        },

    });

    if (bankJsonList != '') {
        $.each(JSON.parse(bankJsonList), function(index, val) {
            //开户银行模糊搜索
            $("#depositBankNameOne_"+(index+1)).autocomplete({

                source:function( request, response ) {
                    $.ajax({
                        url :  basePath +"/approveBase/selectByDepositBankName",
                        type : "post",
                        dataType : "json",
                        data : {
                            bankName : request.term,
                            bankType : $("#bankTypeTwo_"+(index+1)).val()
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
                    $(this).val( ui.item.label );
                    return false;
                },
                select: function( event, ui ) {// 选中某项时执行的操作
                    //$('#bankTypeId').focus();
                    $(this).val( ui.item.label );
                    $(this).parent().find(".depBank").val( ui.item.value );
                    $(this).parent().parent().parent().parent().find(".associated").val( ui.item.value );
                    return false;
                },

            });
        });
    }




    //是否三证合一
    showCont();
    $("input[name='isUnity']").click(function(){
        showCont();
    });

    for(var i = 1;i<(bakIndex+1); i++){
        //银行类别模糊搜索
        $("#bankTypeNameOne_"+i).autocomplete({
            source:function( request, response ) {
                $.ajax({
                    url :  basePath +"/approveBase/selectByBankTypeName",
                    type : "post",
                    dataType : "json",
                    data : {
                        bankTypeName : request.term
                    },
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
                $(this).parent().parent().parent().parent().find(".bankKhg").val( ui.item.value );
                $(this).parent().parent().parent().parent().find(".bankKhgName").val( ui.item.value );
                return false;
            },

        });
    }

    // 文件上传
    uploader = WebUploader.create({
        // swf文件路径
        swf:   basePath +'/assets/global/plugins/webuploader/Uploader.swf',
        // 文件接收服务端。
        server:  basePath +'/upload/uploadImg',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker',
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        // 自动上传
        auto: true,
        disableGlobalDnd: true,
        fileNumLimit: 5,
        //fileSizeLimit: 5 * 1024 * 1024,    // 200 M
        //fileSingleSizeLimit: 1 * 1024 * 1024    // 50 M
    });

    uploader.on('uploadSuccess', function(file, response) {
        console.info("已上传。。。");
        $("#thelist").append(
            "<p class=\"file-other-title\" id="+file.id+" style=\"text-align: left\">" +
            //"<img src='"+ response.msg[0].docUrl +"'/>"+
            "<span>"+file.name+"</span>" +
            "<button class=\"btn red\" onclick=\"deleteDoc('"+file.id+"','"+response.msg[0].docUrl+"')\">删除" +
            "</button>" +
            "</p>");
        uploadDocs.push(response.msg[0]);
    });

    uploader.on( 'uploadError', function( file, response) {
        $( '#'+file.id ).find('p.state').text('上传出错');
        console.info("上传出错。。。");
    });

    uploader.on( 'uploadComplete', function( file ) {
        // $( '#'+file.id ).find('.progress').fadeOut();
    });

    // 初始化附件列表
    var docLists = $('div[id="thelist"] > p > span[class="fileinfo"]');
    $.each(docLists, function (index, val) {
        //nameArray.push($(val).attr('filename'));
        //urlArray.push($(val).attr('fileurl'));
        var obj = {};
        obj.docUrl = $(val).attr('fileurl');
        obj.docName = $(val).attr('filename');
        uploadDocs.push(obj);
    });


    $("#baseForm").validate({
        onfocusout: true,//失去焦点时不验证
        rules: {
            companyFullName : {//单位全称
                required : true,
                remote: {
                    url: basePath+"/approveBase/queryCheckoutNameUnique",//校验唯一性
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "companyFullName": function () {return $("#companyFullName").val();},
                        "id" : function() {return $("#id").val();}
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
            areaName : {//所属地区
                required : true
            },
            legalPerson : {//法人
                required : true
            },
            socialCreditCode : {//社会信用代码
                required : true,
                isSocialCreditCode : true,
                remote: {
                    url: basePath+"/approveBase/queryCheckoutNameUnique",//校验唯一性
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "socialCreditCode": function () {return $("#socialCreditCode").val();},
                        "id" : function() {return $("#id").val();}
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
            licenseNumber : {//营业执照号
                required : true,
                isLicenseNumber : true,
                remote: {
                    url: basePath+"/approveBase/queryCheckoutNameUnique",//校验唯一性
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "licenseNumber": function () {return $("#licenseNumber").val();},
                        "id" : function() {return $("#id").val();}
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
            organizationCodeNumber : {//组织机构代码证号
                required : true,
                isOrganizationCodeNumber : true,
                remote: {
                    url: basePath+"/approveBase/queryCheckoutNameUnique",//校验唯一性
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "organizationCodeNumber": function () {return $("#organizationCodeNumber").val();},
                        "id" : function() {return $("#id").val();}
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
            taxNumber : {//税务登记证号
                required : true,
                isTaxNumber : true,
                remote: {
                    url: basePath+"/approveBase/queryCheckoutNameUnique",//校验唯一性
                    type: "post",
                    async: false,
                    dataType: "json",
                    data: {
                        "taxNumber": function () {return $("#taxNumber").val();},
                        "id" : function() {return $("#id").val();}
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
            economicsTypeName : {//经济类型
                selectNone : true
            },
            address : {//通讯地址
                required : true,
                maxlength : 100
            },
            phone : {//公司电话
                isTel : true
            },
            email : {
                required : true,
                email : true
            },
            contactPhone : {//手机号
                required : true,
                isMobile : true
            },
            postcode : {//邮编
                isNumber : true,
                isZipCode : true
            },
            fund : {//注册资金
                required : true,
                isNumber : true,
                maxlength : 9
            },
            contact : {
                required : true,
            }
        },
        messages: {
            companyFullName : {
                //required : "<span style='color: red'>属性不能为空</span>",
                remote: "<span style='color: red'>单位名称已存在</span>"
            },
            fund : {
                maxlength : "<span style='color: red'>注册资金不能超过9个字符</span>"
            },
            postcode :{
                isZipCode : "<span style='color: red'>请输入正确格式的邮编</span>"
            },
            socialCreditCode :{
                required : "<span style='color: red'>属性不能为空</span>",
                isSocialCreditCode : "<span style='color: red'>请输入正确的社会信用代码</span>",
                remote: "<span style='color: red'>社会信用代码已存在</span>"
            },
            licenseNumber : {
                required : "<span style='color: red'>属性不能为空</span>",
                isLicenseNumber :  "<span style='color: red'>请输入正确的营业执照号</span>",
                remote: "<span style='color: red'>营业执照已存在</span>"
            },
            organizationCodeNumber : {
                required : "<span style='color: red'>属性不能为空</span>",
                isOrganizationCodeNumber : "<span style='color: red'>请输入正确的组织机构代码证号</span>",
                remote: "<span style='color: red'>组织机构代码已存在</span>"
            },
            taxNumber : {
                required : "<span style='color: red'>属性不能为空</span>",
                isTaxNumber :  "<span style='color: red'>请输入正确的税务登记证号</span>",
                remote: "<span style='color: red'>税务登记号已存在</span>"
            }

        }

    });

    $("#productForm").validate({
        onfocusout: true,//失去焦点时不验证
        rules: {
            productTypes : {//产品分类
                required : true,
            }
        },
        messages: {
            productTypes : {

            },
        }
    });


    $("#bankForm").validate({
        onfocusout: true,//失去焦点时不验证
        rules: {
            bankAccount : {//银行账号
                required : true,
                bankCode : true
            },
            electronAccount : {
                required : true,
            },
            bankTypeName : {//银行类别
                required : true,
            },
            bankAccountName : {//账户名称
                required : true,
            },
            depositBankName : {//开户银行
                selectNone : true,
            },
            bankCountry : {//银行国家
                required : true,
            },
            associatedNumber : {//联行号
                required : true,
            }

        },
        messages: {
            bankAccount : {

            },
        }

    });

    //给初始化的产品加校验
    // electChange();
    $.each(JSON.parse(productJsonList), function(index, val) {
        $("#productTypes_" + (index+1)).rules("add", {required:true});
    });

    //给初始化的银行加校验
    // electChange();
    $.each(JSON.parse(bankJsonList), function(index, val) {
        $("#bankAccountOne_" + (index+1)).rules("add", {required:true});
        $("#electronAccountOne_" + (index+1)).rules("add", {required:true});
        $("#bankTypeNameOne_" + (index+1)).rules("add", {required:true});
        $("#bankAccountNameOne_" + (index+1)).rules("add", {required:true});
        $("#bankCountryOne_" + (index+1)).rules("add", {required:true});
        $("#associatedNumberOne_" + (index+1)).rules("add", {required:true});
        $("#depositBankNameOne_" + (index+1)).rules("add", {required:true});
    });

   // //是
   //// electChange();
   // $.each(JSON.parse(productJsonList), function(index, val) {
   //     $("#productTypeNames_" + (index+1)).rules("add", {required:true});
   // });

    //是否电子承兑账户
    // electChange();
    $.each(JSON.parse(bankJsonList), function(index, val) {
        if (val.isElectronAccount == 0) {
            $("#dzDiv_"+(index+1)).show();
            $("#yhDiv_"+(index+1)).hide();
        }else {
            $("#dzDiv_"+(index+1)).hide();
            $("#yhDiv_"+(index+1)).show();
        }
    });

});

/**
 * @desc 是否承兑银行
 * @param obj
 */
function electChange (obj) {
    //var isCheck = $("input[name=isElectronAccount]").is(":checked");
    var isCheck = $(obj).attr("value");
    if (isCheck == 0) {
        $(obj).parent().parent().parent().parent().parent().find(".electron").show();
        $(obj).parent().parent().parent().parent().parent().find(".account").hide();
        $(obj).parent().parent().parent().parent().parent().find(".inputaccoun").val('');
    }else {
        $(obj).parent().parent().parent().parent().parent().find(".account").show();
        $(obj).parent().parent().parent().parent().parent().find(".electron").hide();
        $(obj).parent().parent().parent().parent().parent().find(".elecinput").val('');
    }
}

function isElectronAccount () {

}

//是否危险化学品
function showChemical() {
    var isWh = $("input[name=isChemical]:checked").attr("value");
    if (isWh== 0){
        $("#chemical").show();
    } else {
        $("#chemical").hide();
    }
};

//银行类别change事件
function bankTypes(obj) {
    var codeNameId = $(obj).val();
    $(obj).parent().parent().parent().parent().find(".depBank").find("option").remove();
    $(obj).parent().parent().parent().parent().find(".depBank").append("<option value=''>请选择</option>");
    $.ajax({
        url :  basePath +"/approveBase/selectCodeName",
        type : "post",
        data : "bankCode=" + codeNameId,
        dataType : "json",
        async : false,
        success : function (result) {
            if (result.data) {

                for (var i= 0; i < result.data.length; i++){
                    var datas = result.data[i];
                    $(obj).parent().parent().parent().parent().find(".depBank").append("<option value='"+datas.bankCode+"'>"+datas.bankName+"</option>");
                }
            }
        }

    });
}

//开户银行切换事件
function depositBankCh(obj) {
    var bankCode = $(obj).val();
    $(obj).parent().parent().parent().parent().find(".associated").val(bankCode);
}


//是否三证合一
function showCont(){
    switch($("input[name='isUnity']:checked").attr("id")){
        case "isUnity1":
            //alert("one");
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
var treeObj;
function autoMatch(txtObj) {
    var zNodes = [];

        $.ajax({
            dataType:"json",
            type:"post",
            url: basePath +"/approveBase/queryEconomicsTypeTree",
            success:function(result){
                zNodes = result.data || zNodes ;
                treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            }
        });
        var setting = {
            check: {
                enable: false
            },
            view: {
             selectedMulti: false
             //dblClickExpand: true
             },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: false
            },
            async:{
                enable: true
            },
            callback: {
                //zTree节点的点击事件
                onClick: onClick
            }
        };
        //点击某个节点 然后将该节点的名称赋值值文本框
        function onClick(e, treeId, treeNode) {
            $("#economicsTypeName").val(treeNode.name);
            $("#economicsType").val(treeNode.id);
            //隐藏zTree
            hideMenu();
            return false;
        }
        showMenu();
    //} else {
    //    //隐藏树
    //    hideMenu();
    //}
}

//显示树
function showMenu() {

    $("#menuContent").show();
}
//隐藏树
function hideMenu() {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}


/**
 * @desc 提交
 * @param flag
 */
function referApproveBase (flag) {

    addClientApproveBase(flag);

}
/**
 * @desc 保存
 * @param flag
 */
function saveApproveBase(flag){
    //$("#searchModal").modal("show");//显示“正在进行”字样的模态框
    addClientApproveBase(flag);
};
/**
 * @desc 提交
 * @param flag
 */
function addClientApproveBase (flag) {
    var isValid = false;
    if (flag == 1) {

        if (!$("#baseForm").valid() || !$("#productForm").valid()||!$("#bankForm").valid()) {
            isValid = false;
            return;
        }else {
            if (uploadDocs.length == 0) {
                Command: toastr["warning"]("资质附件不能为空，请上传附件");
            }else {
                isValid = true;
                $("#searchModal").modal("show");//显示“正在进行”字样的模态框
            }

        }
    }else if (flag == 0){
        if (!$("#baseForm").valid()) {
            isValid = false;
            return;
        }else {
            isValid = true;
            //$("#searchModal").modal("show");
        }
    }


    if (isValid) {
        //if (flag == 0) {
        //    $("#searchModal").modal("show");//显示“正在进行”字样的模态框
        //}
        //获取行业信息
        var approveIndustry = [];
        var industry = $("input[name=industry]");
        var industryName = $("input[name=industryName]");
        var industryId = $("input[name=industryId]");
        $.each(industry, function(index, val) {
            var obj = {};
            obj.industry = val.value;
            obj.industryName = industryName[index].value;
            obj.id = industryId[index].value;
            approveIndustry.push(obj);
        });
        //获取产品信息
        var approveProduct =[];
        var productType = $("select[names=productType]");
        //var productTypeName = $("input[names=productTypeName]");
        var productId = $("input[name=productId]");
        $.each(productType, function(index, val) {
            var obj = {};
            obj.productType = val.value;
            obj.productTypeName = $(productType[index]).find("option:selected").text();
            obj.id = productId[index].value;
            approveProduct.push(obj);

            //console.log(obj.productType+"----"+obj.productTypeName);
        });
        //获取银行信息
        var approveBank=[];
        //var isElectronAccount =$("input[name='isElectronAccount']");
        var bankAccount = $("input[names=bankAccount]");
        var electronAccount = $("input[names=electronAccount]");
        var bankType = $("input[names=bankType]");
        var bankTypeName = $("input[names=bankTypeName]");
        var currencyType = $("select[names=currencyType]");
        var bankAccountName = $("input[names=bankAccountName]");
        var depositBank = $("input[names=depositBank]");
        var depositBankName = $("input[names=depositBankName]");
        var otherBank = $("input[names=otherBank]");
        var bankCountry = $("input[names=bankCountry]");
        var associatedNumber = $("input[names=associatedNumber]");
        var bankId = $("input[name=bankId]");
        var accountProperties =$("input:radio[names=accountProperties]:checked");
        var isElectronAccount =$("input:radio[names=isElectronAccounts]:checked");
        var isBaseAccount = $("input[name=isBaseAccount]");
        $.each(bankAccount, function(index, val) {
            var obj= {};

            obj.isElectronAccount = isElectronAccount[index].value;

            //console.log(obj.isElectronAccount);
            obj.bankAccount = val.value != "" ? val.value : electronAccount[index].value;
            obj.bankType = bankType[index].value;
            obj.bankTypeName = bankTypeName[index].value;
            obj.currencyType = $(currencyType[index]).val();
            obj.bankAccountName = bankAccountName[index].value;
            obj.depositBankName = depositBankName[index].value;
            obj.depositBank = depositBank[index].value;
            obj.otherBank = otherBank[index].value;
            obj.bankCountry = bankCountry[index].value;
            obj.associatedNumber = associatedNumber[index].value;
            obj.id = bankId[index].value;
            console.log(accountProperties[index].value);
            obj.accountProperties = accountProperties[index].value;
            obj.isBaseAccount = isBaseAccount[index].value;
            approveBank.push(obj);
        });

        $.ajax({
            url: basePath + "/approveBase/saveClintApproveBase",
            data : {
                "flag" : flag,
                "companyType" : 0,
                "id" : $("#id").val(),
                "uploadDocs" : JSON.stringify(uploadDocs),
                "productIdList" : JSON.stringify(productIdList),
                "bankIdList" : JSON.stringify(bankIdList),
                "approveIndustry" : JSON.stringify(approveIndustry),
                "approveProduct" : JSON.stringify(approveProduct),
                "approveBank" : JSON.stringify(approveBank),
                "companyFullName" : $("#companyFullName").val(),
                "companyFullEg" : $("#companyFullEg").val(),
                "companyShortName" : $("#companyShortName").val(),
                "companyShortEg" : $("#companyShortEg").val(),
                "areaName" : $("#areaName").val(),
                "area" : $("#area").val(),
                "legalPerson" : $("#legalPerson").val(),
                "fund" : $("#fund").val(),
                "socialCreditCode" : $("#socialCreditCode").val(),
                "licenseNumber" : $("#licenseNumber").val(),
                "organizationCodeNumber" : $("#organizationCodeNumber").val(),
                "taxNumber" : $("#taxNumber").val(),
                "economicsType" : $("#economicsType").val(),
                "economicsTypeName" : $("#economicsTypeName").val(),
                "createRegTime" : $("#createRegTime").val(),
                "address" : $("#address").val(),
                "postcode" : $("#postcode").val(),
                "phone" : $("#phone").val(),
                "fax" : $("#fax").val(),
                "email" : $("#email").val(),
                "webAddress" : $("#webAddress").val(),
                "isUnity" : $("input[name=isUnity]:checked").val(),
                "contact" : $("#contact").val(),
                "contactPhone" : $("#contactPhone").val(),
                "currency" : $("#currency").val(),
                "isChemical" : $("input:radio[name=isChemical]:checked").val(),
                "bankJsonList" : bankJsonList,
                "productJsonList" : productJsonList,
                "docJsonList" : docJsonList,
                "byApproveBase" : byApproveBase
            },
            type : "post",
            dataType : "json",
            success : function(data) {
                if(data != undefined && data.code == 500){
                    Command: toastr["error"](data.msg);
                }else{

                    if (flag == 0) {
                        Command: toastr["success"]("保存成功");
                        setTimeout(function() {
                            window.location.href =  basePath +"/index"
                        }, 500);

                    }else {
                        Command: toastr["success"]("提交成功");
                        setTimeout(function() {
                            window.location.href = basePath + "/approveBase/clientCheckPendingPage"
                        }, 500);
                    }
                }

            },
            error: function (XMLResponse) {
                $('#searchModal').modal('hide');
               Command: toastr["error"]("操作异常，请刷新页面后再次尝试");

            }
        });
    }

}

/**
 * @desc <p>删除附件</p>
 * @param id
 * @param notifiDocUrl
 */
function deleteDoc(id,docUrl) {
    for(var i=0;i<uploadDocs.length;i++) {
        if(uploadDocs[i].docUrl == docUrl) {
            uploadDocs.splice(i, 1);
            //nameArray.del(nameArray[i]);
        }
    }
    $("#"+id).remove();
   // uploader.removeFile(id, true);
}
////删除数组中制定元素
//Array.prototype.indexOf = function(val) {
//    for (var i = 0; i < this.length; i++) {
//        if (this[i] == val) return i;
//    }
//    return -1;
//};
//
//Array.prototype.del = function(val) {
//    var index = this.indexOf(val);
//    if (index > -1) {
//        this.splice(index, 1);
//    }
//};