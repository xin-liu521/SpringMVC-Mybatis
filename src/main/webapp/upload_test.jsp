<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/11
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/plugins.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/themes.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
</head>
<body>
<div style="width: 300px; height: 200px;align-content: center">
    <span style="font-size:14px;"><div id="uploader-demo">
        <!--用来存放item-->
        <div id="thelist" class="uploader-list"></div>
        <div>
            <div id="filePicker">选择图片</div>
            <button id="ctlBtn" class="btn btn-default">开始上传</button>
        </div>
        <a href="http://localhost:8080/uploadFloder/2018-02-12/2018-02-12ff71a892-187e-4950-ba72-b7591cb1894f.jpg">下载</a>
    </div>
    </span>
</div>

</body>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/movejs/vendor/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/webuploader/webuploader.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/plugins/bootstrap-toastr/toastr.min.js"></script>

</html>
<script>
    $(function(){
        /*init webuploader*/
        var $list=$("#thelist");   //这几个初始化全局的百度文档上没说明，好蛋疼。
        var $btn =$("#ctlBtn");   //开始上传
        var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档
        var thumbnailHeight = 100;

        var uploader = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: false,

            // swf文件路径
            swf: '/webuploader/Uploader.swf',

            // 文件接收服务端。
            server: '/uploadAction_insertFile.action',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#filePicker',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            //method:'POST',
        });
        // 当有文件添加进来的时候
        uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
            var $li = $(
                            '<div id="' + file.id + '" class="file-item thumbnail">' +
                            '<img>' +
                            '<div class="info">' + file.name + '</div>' +
                            '</div>'
                    ),
                    $img = $li.find('img');


            // $list为容器jQuery实例
            $list.append( $li );

            // 创建缩略图
            // 如果为非图片文件，可以不用调用此方法。
            // thumbnailWidth x thumbnailHeight 为 100 x 100
            uploader.makeThumb( file, function( error, src ) {   //webuploader方法
                if ( error ) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }

                $img.attr( 'src', src );
            }, thumbnailWidth, thumbnailHeight );
        });
        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress span');

            // 避免重复创建
            if ( !$percent.length ) {
                $percent = $('<p class="progress"><span></span></p>')
                        .appendTo( $li )
                        .find('span');
            }

            $percent.css( 'width', percentage * 100 + '%' );
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on( 'uploadSuccess', function( file, response ) {
            console.log(response);
            $( '#'+file.id ).addClass('upload-state-done');
        });

        // 文件上传失败，显示上传出错。
        uploader.on( 'uploadError', function( file, response) {
            var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');

            // 避免重复创建
            if ( !$error.length ) {
                $error = $('<div class="error"></div>').appendTo( $li );
            }

            $error.text('上传失败');
        });

        // 完成上传完了，成功或者失败，先删除进度条。
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').remove();
        });
        $btn.on( 'click', function() {
            console.log("上传...");
            uploader.upload();
            console.log("上传成功");
        });
    });
</script>