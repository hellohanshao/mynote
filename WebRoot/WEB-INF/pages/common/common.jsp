<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<title>mynote</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%-- <script src="${file}/js/jquery-3.2.1.min.js"></script> --%>
<script src="${file}/js/jquery1.10.2.js"></script>
<script src="${file}/js/jquery.contextMenu.js"></script>
<script src="${file}/js/echarts.js"></script>
<%-- <script src="${file}/js/bootstrap.js"></script>
<script src="${file}/js/popper.js"></script> --%>
<script src="${file}/js/ie10-viewport-bug-workaround.js"></script>
<%-- <script type="text/javascript" charset="utf-8" src="${file}/UEditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${file}/UEditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${file}/UEditor/lang/zh-cn/zh-cn.js"></script> --%>
<script type="text/javascript"  src="${file}/layui/layui.js"></script>
<%-- <link rel="stylesheet" type="text/css" href="${file}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${file}/css/dashboard.css"> --%>
<link rel="stylesheet" type="text/css" href="${file}/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${file}/css/jquery.contextMenu.css">
<script type="text/javascript" charset="utf-8" src="${file}/js/custom.js"></script>
<script type="text/javascript">
var src= '${src}';
var layer=null;
layui.use('layer', function(){
	  layer = layui.layer;
	});
var element=null;
layui.use('element', function(){
	  element = layui.element();
	});
var form=null;
layui.use('form', function(){
	form = layui.form();
	});
var laypage=null;
layui.use(['laypage', 'layer'], function(){
	  laypage = layui.laypage;
});

var flow=null;
layui.use('flow', function(){
	  flow = layui.flow;
});
</script>
<style type="text/css">
.layui-main{
margin-left:20px

}
.layui-progress{
	margin-left:20px;
	width:1100px;
</style>