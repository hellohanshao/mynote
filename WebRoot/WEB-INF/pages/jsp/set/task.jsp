<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="../../common/common.jsp"%>
<title>task</title>
</head>
<body>
<blockquote align="center" class="layui-elem-quote tasking">正在执行任务进度</blockquote>
<hr>
<div class="layui-progress layui-progress-big" lay-showPercent="true">
  <div class="layui-progress-bar layui-bg-blue" lay-percent="100%"></div>
</div>
<hr>
<blockquote align="center" bind-form-id="form2" class="layui-elem-quote task-form">任务组明细</blockquote>
<blockquote align="center" bind-form-id="form1" class="layui-elem-quote task-form" >新建任务计划</blockquote>
<form class="layui-form " id="form1" style="display:none;" action="taskAdd.do" method="post"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
  
  <div class="layui-form-item">
    <label class="layui-form-label">搜索网站</label>
    <div class="layui-input-block">
      <input type="text" name="domain" placeholder="请输入网站域名" autocomplete="off" class="layui-input">
    </div>
     <label class="layui-form-label">匹配格式</label>
    <div class="layui-input-block">
      <input type="text" name="pattern" placeholder="请输入搜索格式" autocomplete="off" class="layui-input">
    </div>
     <label class="layui-form-label">关键字搜索</label>
    <div class="layui-input-block">
      <input type="text" name="keyword" placeholder="请输入键字，多个关键字以;分割" autocomplete="off" class="layui-input">
    </div>
     <label class="layui-form-label">请输入任务名称</label>
    <div class="layui-input-block">
      <input type="text" name="taskname" placeholder="请输入任务名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">是否加入现有任务中</label>
    <div class="layui-input-block" >
      <input type="checkbox"  name="isadd" lay-skin="switch" lay-filter="cc">
    </div>
  </div>
  <div class="layui-form-item" id="exit-task" style="width:300px;display:none">
    <label class="layui-form-label">现有任务</label>
    <div class="layui-input-block">
     <select name="fid" lay-verify="" lay-search>
     	<c:forEach items="${groupname }" var="f" >
		  <option value="${f.groupname}">${f.groupname}</option>
     	</c:forEach>
	</select>   
    </div>
  </div>
  
  <div class="layui-form-item" >
    <label class="layui-form-label" >是否立即执行</label>
    <div class="layui-input-block">
      <input type="radio" name="immediately" value="0" title="是" checked lay-filter="radio1">
      <input type="radio" name="immediately" value="1" title="否"  lay-filter="radio2">
    </div>
  </div>
  
  <div class="layui-form-item" id="date" style="display:none;">
	  	<label class="layui-form-label" >执行时间</label>
	  <div class="layui-input-inline">
	  	<input class="layui-input" name="starttime" placeholder="开始时间" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	  </div>
	 <!--  <div class="layui-input-
	 inline">
	  	<input class="layui-input" placeholder="结束时间" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	  </div> -->
   </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">添加本次任务描述</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script type="text/javascript">
layui.use('form', function(){
	var form = layui.form();
	
	 form.on('switch(cc)', function(data){
			if(data.elem.checked){
				$("#exit-task").show();
			}else{
				$("#exit-task").hide();
			}
		});
		 
	form.on('radio(radio1)', function(data){
			if($(data.elem).attr("checked")==true){
				$("#date").show();
			}else{
				$("#date").hide();
			}
		});
		
	form.on('radio(radio2)', function(data){
		
			if($(data.elem).attr("checked")==true){
				$("#date").hide();
			}else{
				$("#date").show();
			}
		});
	
	});
		 


 layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  var start = {
	    format: 'YYYY-MM-DD'
	    ,min: laydate.now()
	    ,max: '2099-06-16 23:59:59'
	    ,istoday: false
	    ,choose: function(datas){
	      end.min = datas; //开始日选好后，重置结束日的最小日期
	      end.start = datas //将结束日的初始值设定为开始日
	    }
	  };
	  
	  var end = {
	    min: laydate.now()
	    ,max: '2099-06-16 23:59:59'
	    ,istoday: false
	    ,choose: function(datas){
	      start.max = datas; //结束日选好后，重置开始日的最大日期
	    }
	  };
	  
	  
	}); 

	$(".task-form").click(function(){
		var id = $(this).attr("bind-form-id");
		
		if($("#"+id).css('display')=='none'){
			$("#"+id).show();
		}else{
			$("#"+id).hide();
		}
		
	})
	//正在执行的任务
	$(".tasking").click(function(){
		var index = layer.open({title:"<p align='center'>正在执行的任务<p>",
			  type: 2,
			  content: src+'/set/tasking.do',
			  area: ['320px', '195px'],
			  maxmin: true
			});
			layer.full(index);
	})
	//任务组明细 open bind-form-id="form2"
	$(".task-form[bind-form-id='form2']").click(function(){
		var index = layer.open({title:"<p align='center'>任务组明细<p>",
			  type: 2,
			  content: src+"/set/taskgroup.do",
			  area: ['320px', '195px'],
			  maxmin: true
			});
			layer.full(index);
	})
	
	$(".layui-btn.layui-btn-primary[type='reset']").click(function(){
		$("#date").hide();
		$("#exit-task").hide();
	})
	
	
</script>
</body>
</html>
