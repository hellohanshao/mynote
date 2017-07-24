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
<script src="${file}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var num=0;
var src= '${src}';
$(function(){
	$("body").click(function(){
		num=num+1;
		if(num==6){
			window.location=src+"/index/login2.do";
		}
	});
	
})
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
	        	<input type="text" name="username" placeholder=" 用户名"/>
	        	<input type="password" name="password" placeholder=" 密码" ><br>
	        	<input type="checkbox" checked>
	        	<input type="text" name="massage"  value="${message }" <c:if test="${empty message  }"> style="display:none" </c:if> />
	        	<span>七日内免登录</span>
	        	<a href="javascript:;">登录</a>
	        </div>
	    </div>
	  </div>
	  <%@include file="../common/bottom.jsp" %>
	</div>
	<script type="text/javascript">
	 $(function(){
		 $('.login-main .content a').on('click',function(){
			 var form = $('<form>');
			 form.attr('action','${src}/login.do');
			 form.attr('method','post');
			 $('body').append(form);
			 $('form').submit();
		 });
	 }); 
	</script>
</body>
</html>
