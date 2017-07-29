<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<title>mynote</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link rel="stylesheet" type="text/css" href="${file}/css/index.css">
<link rel="stylesheet" type="text/css" href="${file}/css/common.css">
<script src="${file}/js/jquery1.10.2.js"></script>
<script type="text/javascript"  src="${file}/layui/layui.js"></script>

<script src="${file}/js/core.js"></script>
<script src="${file}/js/jsbn.js"></script>
<script src="${file}/js/jsbn2.js"></script>
<script src="${file}/js/sm3.js"></script>
<script type="text/javascript">

	
var num=0;
var src= '${src}';
	var layer=null;
	layui.use('layer', function(){
		  layer = layui.layer;
		});
	
</script>
</head>
<body>
	<div class="login-main">
	  <div class="header">
	    <div class="header_resize">
	      <div class="logo" >
			<p align="center">
				<h1>
					<a href="login.do">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mynote</a>
				</h1>
			</p>
	      </div>
	      <div class="clr"></div>
	    </div>
	  </div>
	  <div class="content">
	    <div class="content_in">
	        <div class="top">
	        	<p>登录</p>
	        </div>
	        <div class="con">
	        	<form action="${src}/login.do"  method="post">
		        	<input type="text" name="username" placeholder=" 用户名"/>
		        	<input type="password" name="password" placeholder=" 密码" ><br>
		        	<input type="checkbox" checked>
		        	<span>七日内免登录</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spn style="color:red;" >${message }</spn>
		        	<a href="javascript:;">登录</a>
	        	</form>
	        </div>
	    </div>
	  </div>
	  <%@include file="../common/bottom.jsp" %>
	</div>
	<script type="text/javascript">
	 $(function(){
		 $('.login-main .content a').on('click',function(){
			 var form = $('form');
			 var passwd = hex_sm3($("input[type='password']").val());
			 $("input[type='password']")[0].value=passwd;
			 if(validateInput()){
				 	$('form').submit();
				 }
		 });
		/*  $(window).keydown(function(event){
			 if(event.keyCode==13 && srcElement.type=='password'){
				 var form = $('form');
				 var passwd = hex_sm3($("input[type='password']").val());
				 $("input[type='password']")[0].value=passwd;
				 if(validateInput()){
					 alert(2);
				 	$('form').submit();
				 }
			 }
			}); */
	 }); 
	 
	 document.onkeydown = function(){
		 var event = window.event;
		 if(!event) event=arguments.callee.arguments[0];
		 var srcElement=event.srcElement;
		 if(!srcElement) srcElement=event.target;
		 if(event.keyCode==13 && srcElement.type=='password'){
			 var form = $('form');
			 var passwd = hex_sm3($("input[type='password']").val());
			 $("input[type='password']")[0].value=passwd;
			 if(validateInput()){
			 	$('form').submit();
			 }
		 }
	 } 
	 
	 function validateInput(){
		 if($("input[type='password']")[0].value.length==0){
			 layer.msg("密码不能为空");
			 return false;
		 }
		 if($("input[name='username']")[0].value.length==0){
			 layer.msg("用户名不能为空");
			 return false;
		 }
		 return true;
	 }
	</script>
</body>
</html>
