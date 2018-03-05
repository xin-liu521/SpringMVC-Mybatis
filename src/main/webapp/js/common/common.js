//获取cookie
var cp = ($.cookie('cp') == null ? '':$.cookie('cp'));//current_page_id
var authArray;
var cFunc,pFunc,ppFunc,rFunc;
var navBar = '';
$(function () {
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "positionClass": "toast-top-right",
        "onclick": null,
        "showDuration": "1000",
        "hideDuration": "1000",
        "timeOut": "3000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    if(cp != '' && cp != '169'){
           cFunc = _.where(authArray,{"id": parseInt(cp)});
           if(cFunc == undefined || cFunc.length == 0){
               cFunc = undefined;
               pFunc = undefined;
               ppFunc = undefined;
           }else{
               pFunc = _.where(authArray,{"id": cFunc[0].pid});
               if(pFunc != undefined){
                   //判断是否为三级权限树
                   var ppFuncId = pFunc[0].pid;
                   if(ppFuncId != 0){
                       //存在三级权限树
                       ppFunc = _.where(authArray,{"id": pFunc[0].pid});
                   }

               }
           }


    }

    if(ppFunc != undefined){
        navBar += '<li>';
        if(ppFunc[0].pid == 0){
            navBar += '<a href="javascript:void(0);">' + ppFunc[0].name+ '</a>';
        }else{
            navBar += '<a href="' + ppFunc[0].url+ '">' + ppFunc[0].name+ '</a>';
        }

        if(pFunc != undefined){
            navBar += '     <i class="fa fa-circle"></i>';
        }

        navBar += '</li>';

    }

    if(pFunc != undefined){
        navBar += '<li>';
        if(pFunc[0].pid == 0){
            navBar += '<a href="javascript:void(0);">' + pFunc[0].name+ '</a>';
        }else{
            navBar += '<a href="' + pFunc[0].url+ '">' + pFunc[0].name+ '</a>';
        }

        if(cFunc != undefined){
            navBar += '     <i class="fa fa-circle"></i>';
        }

        navBar += '</li>';
    }

    if(cFunc != undefined){
        navBar += '<li>';
        navBar += '<span>' + cFunc[0].name + '</span>';
        navBar += '<li>';
    }

    //$('ul.page-breadcrumb').html(navBar);
});