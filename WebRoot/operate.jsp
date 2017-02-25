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
    <title>操作公告</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="css/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.ico">
	
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
            <table class="table table-striped">
              <caption>公告信息</caption>
              <thead>
                <tr>
                  <th>标题</th>
                  <th>发布者</th>
                  <th>时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${messages }" var="message">
              		<tr>
              			<td><a href="${pageContext.request.contextPath }/show.action?messageid=${message.messageId }">${message.messageTitle }</a></td>
              			<td>${message.user.userName }</td>
              			<td><fmt:formatDate value="${message.messageDate }" pattern="yyyy-MM-dd HH:mm" /></td>
              			<td><a href="${pageContext.request.contextPath }/showEdit.action?messageid=${message.messageId }">编辑</a>
              			&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/delete.action?messageid=${message.messageId }" onclick="javascript:return del();">删除</a></td>
              		</tr>
              	</c:forEach>
              </tbody>
            </table>
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
		function del() {
			var msg = "您确定要删除吗？\n\n请确认！";
			if(confirm(msg) == true){
				return true;
			}else{
				return false;
			}
		}
	</script>
  </body>
</html>
