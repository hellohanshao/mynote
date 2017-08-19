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
<form class="layui-form " id="form" method="post" action="taskgroup.do">
<div class="layui-form" align="center" >
	<div class="layui-inline">
			<div class="layui-input-inline">
				<input type="text" name="groupname"  placeholder="任务组" autocomplete="off" class="layui-input">
			</div>
	</div>
	<div class="layui-input-block" align="center" style="margin-left: 0px;margin-top: 5px;">
      <button class="layui-btn search">查询</button>
      <button type="reset" class="layui-btn layui-btn-primary">新增</button>
    </div>
</div>
</form>
<form class="layui-form " id="form1" >
	<table class="layui-table" lay-skin="line">
	  <colgroup>
	    <col width="150">
	  </colgroup>
	  <thead>
	    <tr>
	      <th>任务编号</th>
	      <th>任务名称</th>
	      <th>所属任务组</th>
	      <th>详情</th>
	      <th>是否开启</th>
	    </tr> 
	  </thead>
	  <tbody>
	  	  		<c:forEach items="${taskgroup}" var="f" >	
					    <tr>
					      <td>${f.id}</td>
					      <td>${f.groupname}</td>
					      <td>${f.tasknumber}</td>
					      <td>${f.describe}</td>
					      <c:if test="${f.isstart eq 1}">
					      	<td><input type="checkbox" checked="checked" lay-skin="switch" lay-filter="cc"></td>
					      </c:if>
					      <c:if test="${f.isstart ne 1}">
					      	<td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
					      </c:if>
					    </tr>
				</c:forEach>
	  </tbody>
	</table>
</form>
<script type="text/javascript">
layui.use('form', function(){
	var form = layui.form();
	 //全选
	  form.on('checkbox(allChoose)', function(data){
	    var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
	    child.each(function(index, item){
	      item.checked = data.elem.checked;
	    });
	    form.render('checkbox');
	  });
	
	 form.on('switch(cc)', function(data){
			if(data.elem.checked){
				$("#exit-task").show();
			}else{
				$("#exit-task").hide();
			}
		});
	
	});

	
	
	$(".layui-btn[type='reset']").click(function(){
		var index = layer.open({title:"<p align='center'>添加任务组<p>",
			  type: 2,
			  content: src+'/set/showTaskGroup.do',
			  area: ['200px', '195px'],
			  maxmin: true
			});
			layer.full(index);
	})
</script>
</body>
</html>
