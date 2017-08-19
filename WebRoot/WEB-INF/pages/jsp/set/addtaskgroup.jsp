<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="../../common/common.jsp"%>
<title>TaskGroup</title>
</head>
<body>
<form class="layui-form " id="form1"  action="addTaskGroup.do" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">任务组名称</label>
    <div class="layui-input-block">
      <input type="text" name="groupname" placeholder="请输入任务组名称" value="${groupname}" autocomplete="off" readonly="readonly" class="layui-input">
    </div>
   <!--   <label class="layui-form-label">任务组</label>
    <div class="layui-input-block">
      <input type="text" name="pattern" placeholder="请输入任务组" autocomplete="off" class="layui-input">
    </div>
     <label class="layui-form-label">请输入任务名称</label>
    <div class="layui-input-block">
      <input type="text" name="taskname" placeholder="请输入任务名称" autocomplete="off" class="layui-input">
    </div> -->
  </div>
  <div class="layui-form-item" >
    <label class="layui-form-label">是否开启</label>
    <div class="layui-input-block" >
      <input type="checkbox"  name="isstart" lay-skin="switch" value="1" lay-filter="cc">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">添加本次任务组描述</label>
    <div class="layui-input-block">
      <textarea name="describe" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
  <div>${msg }</div>
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
	
	});
	
</script>
</body>
</html>
