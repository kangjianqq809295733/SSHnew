<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>编辑公告</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- 样式文件 -->
    <link rel="stylesheet" href="./umeditor/themes/default/css/umeditor.css">
    <!-- 引用jquery -->
    <script src="./umeditor/third-party/jquery.min.js"></script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="./umeditor/umeditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="./umeditor/umeditor.js"></script>
    <!-- 语言包文件 -->
    <script type="text/javascript" src="./umeditor/lang/zh-cn/zh-cn.js"></script>
    <!-- 实例化编辑器代码 -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/vendor/html5shiv.js"></script>
      <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <div class="container">
  	<!--导航栏-->
    <div class="row">
    	<div class="col-md-12">
        	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            	<div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#example-navbar-collapse">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">信息公告发布系统</a>
                    </div>
                    <div class="collapse navbar-collapse" id="example-navbar-collapse">
                        <ul class="nav navbar-nav navbar-right"> 
							<li><a href="${pageContext.request.contextPath }/index.action"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;返回首页</a></li>
                		</ul> 
                    </div>      
            	</div>
			</nav>
        </div>
    </div>
    <div class="row" style="margin-top:100px;">
    	<div class="col-md-12">
            <form class="form-horizontal" role="form" action="edit.action" method="post">
              <input type="hidden" name="messageid" value="${message.messageId }" />
              <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">公告标题</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" name="title" value="${message.messageTitle }">
                </div>
              </div>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">公告内容</label>
                <div class="col-sm-10">
                 	<!-- 加载编辑器的容器 -->
					<script id="container" type="text/plain" style="width:100%;height:200px;">${message.messageContent }</script>
                </div>
              </div>
              <div class="form-group" align="center">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default" onClick="">提交修改</button>
                </div>
              </div>
            </form>
		</div>
	</div>
	

    
    <!--版权信息-->
    <div class="row">
    	<div class="col-md-12">
        <hr/>
        <p align="center">
        	&reg;版权所有
        </p>
        </div>
    </div>
    
    
  </div>
    <!-- /.container -->
    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="js/vendor/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/vendor/video.js"></script>
    <script src="js/flat-ui.min.js"></script>
	<script>
		$(document).ready(function() {//导航栏定位
            $(".dropdown-menu a").click(function(){
				var href = $(this).attr("href");
				$("a[href='"+href+"'][data-toggle='tab']").tab('show');
			});
        });
	</script>
    <script type="text/javascript">
	    $(function(){
	        window.um = UM.getEditor('container', {
	            /* 传入配置参数,可配参数列表看umeditor.config.js */
	            toolbar: ['source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
	        'insertorderedlist insertunorderedlist | selectall cleardoc ' ,
	        '| justifyleft justifycenter justifyright justifyjustify |',
	        '| horizontal preview ']
	        });
	        
	    });
		function fun(){
			/* 获取编辑器内容 */
			var html = window.um.getContent();
		}
			
    </script>
  </body>
</html>
