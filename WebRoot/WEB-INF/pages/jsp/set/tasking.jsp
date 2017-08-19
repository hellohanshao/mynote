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
<form class="layui-form " id="form1" >
	<table class="layui-table" lay-skin="line">
	  <colgroup>
	    <col width="150">
	    <col width="150">
	    <col width="200">
	    <col>
	  </colgroup>
	  <thead>
	    <tr>
	      <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
	      <th>任务编号</th>
	      <th>任务名称</th>
	      <th>所属任务组</th>
	      <th>进度</th>
	      <th>是否开启</th>
	    </tr> 
	  </thead>
	  <tbody>
	    <tr>
	      <td><input type="checkbox" name="" lay-skin="primary"></td>
	      <td>贤心</td>
	      <td>汉族</td>
	      <td>1989-10-14</td>
	      <td>人生似修行</td>
	      <td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
	    </tr>
	    <tr>
	      <td><input type="checkbox" name="" lay-skin="primary"></td>
	      <td>张爱玲</td>
	      <td>汉族</td>
	      <td>1920-09-30</td>
	      <td>于千万人之中遇见你所遇</td>
	      <td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
	    </tr>
	    <tr>
	      <td><input type="checkbox" name="" lay-skin="primary"></td>
	      <td>Helen Keller</td>
	      <td>拉丁美裔</td>
	      <td>1880-06-27</td>
	      <td> Life is either a daring adventure or nothing.</td>
	      <td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
	    </tr>
	    <tr>
	      <td><input type="checkbox" name="" lay-skin="primary"></td>
	      <td>岳飞</td>
	      <td>汉族</td>
	      <td>1103-北宋崇宁二年</td>
	      <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
	      <td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
	    </tr>
	    <tr>
	      <td><input type="checkbox" name="" lay-skin="primary"></td>
	      <td>孟子</td>
	      <td>华夏族（汉族）</td>
	      <td>公元前-372年</td>
	      <td>猿强，则国强。国强，则猿更强！ </td>
	      <td><input type="checkbox"  lay-skin="switch" lay-filter="cc"></td>
	    </tr>
	  </tbody>
	</table>
</form>
  <div>
	  <button style="float:left;" class="layui-btn layui-btn-primary layui-btn-small">小型按钮</button>
	 <div id="demo6" ></div>
  </div>
<script type="text/javascript">
laypage({
    cont: 'demo6'
    ,pages: 5
    ,groups: 0
    ,first: false
    ,last: false
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第 '+ obj.curr +' 页');
      }
    }
  });
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
	    min: laydate.now()
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
			  content: src+'/set/tasking.do?subid=3',
			  area: ['320px', '195px'],
			  maxmin: true
			});
			layer.full(index);
	})
	//任务组明细 open bind-form-id="form2"
	$(".task-form[bind-form-id='form2']").click(function(){
		var index = layer.open({title:"<p align='center'>任务组明细<p>",
			  type: 2,
			  content: src+'/set/taskgroup.do?subid=3',
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
