<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>hyn</title>	
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/hynlogin.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body class="body-background">
	<div class="whole-bg">
		<!--导航栏-->
		<nav class="navbar navbar-default" role="navigation">
		   <div class="navbar-header">
		      <a class="navbar-brand" href="#">新月微光</a>
		   </div>
		   <div ">
		  	 	<!--向左对齐-->
		      <ul class="nav navbar-nav navbar-left">
		         <li class="active"><a href="#">博客</a></li>
		         <li><a href="index.html">首页</a></li>
		         <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		               更多
		               <b class="caret"></b>
		            </a>
		            <ul class="dropdown-menu">
		               <li><a href="#">科技资讯</a></li>
		               <li><a href="#">Java攻略</a></li>
		               <li class="divider"></li>
		               <li><a href="#">新月趣事</a></li>
		               <li><a href="#">特效剪辑</a></li>	       
		               <li><a href="#">娱乐爱好</a></li>
		            </ul>
		         </li>
		      </ul>
	
		       <!--向右对齐-->
    	      <ul class="nav navbar-nav navbar-right" style="margin-right: 0;">
    	      	<li>
					<div>
			        <form class="navbar-form navbar-right" role="search">
			           <div class="form-group">
			              <input type="text" class="form-control" placeholder="您感兴趣的内容">
			           </div>		           
			           	  <button class="btn btn-info btn-search">搜索</button>
			        </form>    
			     	</div>
    	      	</li>             
    	         
	
    	         <li class="dropdown">
    	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
    	               新月 <b class="caret"></b>
    	            </a>
    	            <ul class="dropdown-menu">
    	               <li><a href="#">主页</a></li>
    	               <li><a href="#">消息</a></li>
    	               <li><a href="#">设置</a></li>
    	               <li class="divider"></li>
    	               <li><a href="#">退出</a></li>
    	            </ul>
    	         </li>
    	      </ul>
    	   </div>
		</nav>
		<!--导航栏-->	
			<div>
				<div class="panel panel-default login-page">
					<h2 class="topic-xinyue">欢迎来到新月之家</h2>
					<h5 class="page-header"></h5>
				   <div class="panel-body ">
				      <form class="form-horizontal" role="form" action="doLogin">
						   <div class="form-group">						      
						      <div class="col-sm-12">
						         <input type="text" name="user_name" class="form-control" id="firstname" 
						            placeholder="用户名">
						      </div>
						   </div>
						   <div class="form-group">
						      <div class="col-sm-12">
						         <input type="text" name="password" class="form-control" id="lastname" 
						            placeholder="密码">
						      </div>
						   </div>
						   <div class="form-group">
						      <div class="col-sm-offset-3 col-sm-12">
									<div class="checkbox-inline">
						            	<label class="col-xs-6">
						               		<input type="checkbox"> 自动登陆
						            	</label> 
						            	<label class="col-xs-6">
						               		<input type="checkbox"> 记住密码
						            	</label> 
						        	</div>
						      </div>
						   </div>
						   <div class="form-group">
						      <div class=" col-sm-12">
						         <button type="submit" class="btn btn-primary btn-block ">登录</button>
						         <button type="submit" class="btn btn-primary btn-block">注册</button>
						      </div>
						   </div>
						</form>
				    </div>

				    <h5 class="page-header"></h5>
					<h2 class="topic-xinyue">
					<c:choose>
   						<c:when test="${errorMsg==null}">  
         					先放着吧<br />   
   						</c:when>
   							<c:otherwise> 
							${errorMsg}</br>
   							</c:otherwise>
						</c:choose>
					

					</h2>
				</div>
			</div>
		
		<div class="main">
				<div class="hyn_footerall navbar-fixed-bottom">
					<dl>
						<dt class="foot_sub_menu">
							<a href="#">个人简介</a>
							<span>|</span>
							<a href="#">招贤纳士</a>
							<span>|</span>
							<a href="#">广告服务</a>
							<span>|</span>
							<a href="#">联系方式</a>
							<span>|</span>
							<a href="#">问题报告</a>
						</dt>
						<dd class="foot_copyright">
							<span>京 ICP 证 09002463 号</span>
							<span>|</span>
							<span>Copyright © 1999-2016, CSDN.NET, All 		Rights Reserved </span>
						</dd>
					</dl>
				</div>
			</div>
		</div>
</body>
</html>