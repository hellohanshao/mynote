<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/common.jsp"%>
  
    <script type="text/javascript">
    /* 
    $(function(){
		$("#savedetail").click(function(){
		 		
		 		var detailid=0;
		 		var d = $("#detailname").attr("detailid");
		 		var url="";
		 			if($("#detailname").val()==""){
		 				alert("请输入标题内容后，再保存");
		 				return;
		 			}
		 		if(d=="undefined" || d==0 || d=="" || !d){
		 			url=	"${src}/insert.do";
		 		}else{
		 			detailid = $("#detailname").attr("detailid")
		 			
		 			url=	"${src}/updatedetail.do";
		 		}
		 		
		 		var index = layer.load(0, {
					  shade: [0.1,'#fff'] //0.1透明度的白色背景
					 	
					});
				$.post(url,{detail:layedit.getContent(layindex),detailname:$.trim($("#detailname").val()),relation:$("#detailname").attr("relation"),id:detailid},function(data){
					if(data.status==1){
						alert("保存成功");
						$("#detailname").attr("detailid",data.id);
					 	$("#detailname").attr("readonly","readonly");
					 	$("#modifydetail").hide();
					 	$("#detailarea").empty();
					 	$("#detailarea").append(layedit.getContent(layindex));
					 	$("#detailarea").show();
					 	layer.close(index);
					 	window.location.href=window.location.href;
					}else if(data.status==0){
						alert("保存失败，请重试");
						layer.close(index);
					}
				})
			}); 
			
			 $("#editor").on("click",function(){
				 $("#detailname").removeAttr("readonly");
				 $("#modifydetail").show();
				 $("#detailarea").hide();
				 
			}) ;
			
    }) */
    
</script>
<input type="text" name="title" required lay-verify="required" placeholder="请输入标题" id="detailname"  detailid="${detail.id }" relation="${relation }" value="${detail.detailname }" autocomplete="off" class="layui-input" readonly="readonly">  
<div id="modifydetail" style="display: none">
	<textarea id="demo" style="display: none;" >
	${detail.detail}
</textarea>
</div>
<div id="detailarea" >
	${detail.detail}
</div>

<div>
	<p align="center">
 		<a href="javascript:;"  id="editor" class="layui-btn layui-btn-normal">编辑</a>
 		<a href="javascript:;"  id="savedetail" class="layui-btn layui-btn-normal">保存</a>
       </p>
</div>

<script type="text/javascript">
		
		var layindex="";
		var layedit=null;
		layui.use('layedit', function(){
			  layedit = layui.layedit;
			  layindex =  layedit.build('demo');
			});
		</script>
</html>