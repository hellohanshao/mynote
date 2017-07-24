<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
//var detail='';
var id="${active}";
var src= '${src}';
//window.onbeforeunload = function() {return ("确认关闭吗？");}
layui.use(['laypage', 'layer'], function(){
  var laypage = layui.laypage
  ,layer = layui.layer;
  laypage({
	    cont: 'demo7',
	    pages: '${sumPage}',
	    skip: true,
	    curr:'${currPage}',
	    jump: function(obj, first){
	        //得到了当前页，用于向服务端请求对应数据
	        var curr = obj.curr;
	        if(first!=true){
	        	
	        window.location.href=src+"/index/page.do?page="+curr+"&subid=${subactive}&id=${active}";
	        }
	      }
	  });
 })
 
</script>
<style type="text/css">
.detailajax a:focus{
	color:red;
}
.body{
	padding: 0px;
	margin:0px;
	height: 1000px;
	width: auto;
}
.root{
	height: 100%;
	width: 100%;
	margin:0 auto;
	overflow: hidden;
	background-color: #CCE8CF;
}
.top{
	height:60px;;
	width:100%;
}
.center{
	height:900px;
	width:100%;
}
.bottom{
	height:40px;
	width:100%;
	background-color: #CCE8CF;
	clear: both;
}
.left{
	width:15%;
	height:1386px;
	float:left;
    overflow-x: hidden;
    overflow-y: auto;
    background-color: #2B2E37!important;
    padding-bottom: 100%;
}

.middle{
	height:auto;
	width:70%;
	float:left;
	padding-left: 5px;
}

.right{
	height:1386px;
	width:15%;
	float:right;
	background-color: #393D49;
	padding-bottom: 1356px;
	padding-left: 3px;
	
}
.layui-nav-item{
	z-index: 1000;
}
.blogsearch {
    width: 192px;
    border: 1px solid #ccc;
    height: 38px;
    padding: 7px 30px 7px 7px;
}
#btnSubmit {
    border: 0;
    background: url("${file}/img/skin-search.png") no-repeat center;
    position: absolute;
    width: 20px;
    height: 20px;
    top: 20px;
    right: 10px;
    text-indent: -100px;
    cursor: pointer;
}
</style>
		<body >
				<div class="root">
					<div class="top">
					<%@ include file="../common/main.jsp"%>
					</div>
				    <div class="center">
				    		<div class="left">
				    			<%@ include file="../common/left.jsp"%>
				    		</div>
				    		<div class="middle">
								 <%@ include file="../common/contentlist.jsp"%>
				    		</div>
				    		<div class="right">
				    		</div>
			        </div>
			        <hr style="background-color: gray;">
			        <div class="bottom">
			        </div>
					<%@include file="../common/bottom.jsp" %>
				</div>
				<input type="hidden" value="${active }" id="active" >
		</body>
</html>
