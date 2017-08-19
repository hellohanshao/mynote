<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
//var detail='';
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
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>图片懒加载</legend>
</fieldset>
<div class="site-demo-flow" id="LAY_demo3">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/701696736/TB2PNl5ahQa61Bjy0FhXXaalFXa_!!701696736.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/162734861/TB2V5rsX_gc61BjSZFkXXcTkFXa_!!162734861.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i4/69476562/TB2htq4XTka61BjSszfXXXN8pXa_!!69476562.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i1/180558071/TB2sy6jXMQc61BjSZFGXXa1DFXa_!!180558071.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/701696736/TB2PNl5ahQa61Bjy0FhXXaalFXa_!!701696736.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i3/285892163/TB2qu2HX9Zb61BjSZPfXXaU.pXa_!!285892163.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/704998060/TB2S.gAXTgc61BjSZFkXXcTkFXa_!!704998060.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i3/117202952/TB25lckX_AX61Bjy0FcXXaSlFXa_!!117202952.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/162734861/TB2qijoX9Zb61BjSZPfXXaU.pXa_!!162734861.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i3/96216586/TB2S7EfXHMc61BjSZFFXXaDLFXa_!!96216586.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i8/TB1jSSFNFXXXXcoXFXXYXGcGpXX_M2.SS2_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/162734861/TB2ylbsX37c61BjSZFKXXb6hFXa_!!162734861.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i2/117202952/TB2FdyZajUd61BjSZPcXXc6hXXa_!!117202952.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i4/777105914/TB2t.qbXZwb61Bjy0FfXXXvlpXa_!!777105914.jpg_400x400q90.jpg?t=1501427012960">
  <img lay-src="https://gw.alicdn.com/bao/uploaded/i4/TB1XzupNFXXXXcpXXXXXXXXXXXX_!!0-item_pic.jpg_400x400q90.jpg?t=1501427012960">
</div>
<script>
layui.use('flow', function(){
  var flow = layui.flow;
 
  
  //按屏加载图片
  flow.lazyimg({
    elem: '#LAY_demo3 img'
    ,scrollElem: '#LAY_demo3' //一般不用设置，此处只是演示需要。
  });
  
});
</script>
			        </div>
			        <hr style="background-color: gray;">
			        <div class="bottom">
			        </div>
					<%@include file="../common/bottom.jsp" %>
				</div>
				<input type="hidden" value="${active }" id="active" >
		</body>
</html>
