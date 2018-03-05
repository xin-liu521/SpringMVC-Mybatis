<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style>
    .second-arrow
    {
        display:block !important;
    }
</style>
<div class="page-sidebar navbar-collapse collapse">
    <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true"
        data-slide-speed="200" style="padding-top: 20px">
        <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
        <li class="sidebar-toggler-wrapper hide">
            <div class="sidebar-toggler">
                <span></span>
            </div>
        </li>
        <!-- END SIDEBAR TOGGLER BUTTON -->

    </ul>
    <!-- END SIDEBAR MENU -->
    <script>

        var redirTarget = function (cp) {
                rFunc = _.where(authArray,{"id": parseInt(cp)});
                $.cookie('cp', rFunc[0].id,{path: '/' });
                window.location.href = rFunc[0].url;
        };

        //获取cookie
        //var cp = ($.cookie('cp') == null ? '':$.cookie('cp'));//current_page_id
        //var cp = (cookie.get('cp') == null ? '':cookie.get('cp'));//current_page_id
        //alert('跳转后--' + cp);
//        if(cp != ''){
//            cFunc = _.where(authArray,{"id": parseInt(cp)});
//            pFunc = _.where(authArray,{"id": cFunc[0].pid});
//            if(pFunc != undefined){
//                //判断是否为三级权限树
//                var ppFuncId = pFunc[0].pid;
//                if(ppFuncId != 0){
//                    //存在三级权限树
//                    ppFunc = _.where(authArray,{"id": pFunc[0].pid});
//                }
//
//            }
//
//        }
//        <ul class="page-breadcrumb">
//            <li>
//            <a href="index.html">Home</a>
//            <i class="fa fa-circle"></i>
//            </li>
//            <li>
//            <span>UI Features</span>
//        </li>
//        </ul>
        $(function () {
            //初始化菜单树
            if(menuList != ''){
                var htmls = '';
                if(authArray != undefined && authArray.length > 0){
                    for(var i = 0; i < authArray.length; i ++){
                        var firstLevel = authArray[i];
                        if(firstLevel.pid == 0){
                            //第一级


                            if((ppFunc != undefined && ppFunc[0].id == firstLevel.id)  || (pFunc != undefined && pFunc[0].id == firstLevel.id)){
                                //如为三级权限树，当前ppFunc递归选中一级权限
                                //如为二级权限树，当前pFunc递归选中一级权限
                                htmls += '<li class="nav-item active open" data-level="first"> ';
                            }else{
                                if(firstLevel.id == 169){
                                    htmls += '<li class="nav-item start" data-level="first"> ';
                                }else{
                                    htmls += '<li class="nav-item" data-level="first"> ';
                                }

                            }
                            if(firstLevel.id == 169){
                                htmls += '  <a href="javascript:javascript:redirTarget('+ firstLevel.id +');" ata-id="' + firstLevel.id + '" class="nav-link nav-toggle start">';
                            }else{
                                htmls += '  <a href="javascript:void(0);" ata-id="' + firstLevel.id + '" class="nav-link nav-toggle">';
                            }


                            //判断是否输出图片
                            if(firstLevel.icon != undefined && firstLevel.icon != ''){
                                if(firstLevel.id == 169){
                                    htmls += '      <i class="' + firstLevel.icon + '"></i><span class="title">' + firstLevel.name + '</span>';
                                }else{
                                    htmls += '      <i class="' + firstLevel.icon + '"></i><span class="title">' + firstLevel.name + '</span> <span class="arrow"></span>';
                                }

                            }else{
                                if(firstLevel.id == 169){
                                    htmls += '      <i class="icon-layers"></i><span class="title">' + firstLevel.name + '</span>';
                                }else{
                                    htmls += '      <i class="icon-layers"></i><span class="title">' + firstLevel.name + '</span> <span class="arrow"></span>';
                                }
                            }

                            htmls += '  </a>';
                            var secondLevelArray = _.where(authArray,{"pid": firstLevel.id});
                            if(secondLevelArray != undefined && secondLevelArray.length > 0){
                                htmls += '<ul class="sub-menu" data-level="second" style="display: block;">';
                                for(var j = 0; j <secondLevelArray.length; j ++){
                                    var secondLevel = secondLevelArray[j];
                                    var threeLevelArray = _.where(authArray,{"pid": secondLevel.id});

                                    if((cFunc != undefined && cFunc[0].id == secondLevel.id) || (pFunc != undefined && pFunc[0].id == secondLevel.id)){
                                        //如为三级权限树，当前pFunc递归选中二级权限
                                        //如为二级权限树，当前cFunc递归选中二级权限
                                        htmls += '<li class="nav-item active open"> ';
                                    }else{
                                        htmls += '<li class="nav-item"> ';
                                    }

                                    //如存在第三级则当前二级节点不能跳转，否则可以直接跳转
                                    if(threeLevelArray != undefined && threeLevelArray.length > 0){
                                        htmls += '      <a href="javascript: void(0);" data-id="' + secondLevel.id + '" class="nav-link">';
                                    }else{
                                        htmls += '      <a href="javascript: redirTarget('+ secondLevel.id + ');" data-id="' + secondLevel.id + '" class="nav-link ">';
                                    }

                                    htmls += '          <span class="title">' + secondLevel.name + '</span>';

                                    //如存在第三级，则增加下拉html
                                    if(threeLevelArray != undefined && threeLevelArray.length > 0){
                                        htmls += '<span class="arrow second-arrow"></span>';
                                    }

                                    htmls += '      </a>';
                                    htmls += '  </li>';

                                    //第三级
                                    if(threeLevelArray != undefined && threeLevelArray.length > 0){
                                        for(var k = 0; k < threeLevelArray.length; k++){
                                            var threeLevel = threeLevelArray[k];
                                            htmls += '<ul class="sub-menu" data-level="three">';

                                            if(cFunc != undefined && cFunc[0].id == secondLevel.id){
                                                //当前cFunc递归选中二级权限
                                                htmls += '<li class="nav-item active open"> ';
                                            }else{
                                                htmls += '<li class="nav-item"> ';
                                            }

                                            htmls += '      <a href="javascript: redirTarget(' + firstLevel.id + ');" class="nav-link "> ' + threeLevel.name + ' </a>';
                                            htmls += '  </li>';
                                            htmls += '</ul>';

                                        }
                                    }


                                }
                                htmls += '</ul>';
                            }

                            htmls += '</li>';
                        }
                    }

                    $('ul.page-sidebar-menu').append(htmls);
                }
            }
            $('.second-arrow').parent().on('click',function(){
                //$(this).toggleClass("open");
                if($('ul[data-level="three"]').is(":hidden")){
                    $(this).addClass("open");
                    $('ul[data-level="three"]').show();    //如果元素为隐藏,则将它显现
                }else{
                    $(this).removeClass("open");
                    $('ul[data-level="three"]').hide();     //如果元素为显现,则将其隐藏
                }
            });

            //首页
            if(cp != '' && cp == '169'){
                $('li.start').addClass("active");
            }

        });


    </script>
</div>


