<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
	
var src= '${src}';
 
</script>
<style type="text/css">
.detailajax a:focus{
	color:red;
}
.body{
	padding: 0px;
	margin:0px;
	height: 900px;
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
	height:900px;
	float:left;
    overflow-x: hidden;
    overflow-y: auto;
    background-color: #2B2E37!important;
}

.middle{
	height:900px;
	width:85%;
	float:right;
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
.layui-tab-content{
	padding:0px;
	border:2px;
	
}
.layui-this{
	background-color:#009688;
}
.ifra{
	width:100%;
	height:860px;
}
.layui-tab{
	
    margin-top: 0px;
}
hr{
	margin:0px;
}
.layui-main{
	
    margin-left: 5px;
    width:100%;
	
}
</style>
		<body >
				<div class="root">
					<div class="top">
						<%@ include file="../common/main.jsp"%>
					</div>
					
				    <div class="center">
				    
				    		<div class="left">
				    			<ul class="layui-nav layui-nav-tree" id="sideNav" lay-filter="sideNav">${subactive }
									<c:forEach items="${setList}" var="f" >	
									  <li subid="${f.id}" titleid="${active}"  class="layui-nav-item<c:if test='${f.id eq  subactive}' >layui-this</c:if>  ">
									    <a  href="javascript:;" subid="${f.id}" controller="${f.controller}" id="${f.id}" class="create_tab" >${f.setname }</a>
									  </li>
									</c:forEach>
								</ul>
				    		</div>
				    		
				    		<div class="middle">
					    			<div class="layui-tab" lay-allowClose="true" lay-filter="note_tab" >
											  <ul class="layui-tab-title" >
											  </ul>
											  <div class="layui-tab-content">
											  </div>
									</div>
							</div>
							
			        </div>
			        <hr style="background-color: gray;">
			        <div class="bottom">
			        </div>
					<%@include file="../common/bottom.jsp" %>
				</div>
				<input type="hidden" value="${active }" id="active" >
				<script type="text/javascript">
				 var element;
					layui.use('element', function(){
				   		element = layui.element();
					  	//一些事件监听
				  		element.on('tab(note_tab)', function(data){
							     $(".create_tab.layui-this").removeClass("layui-this"); 
							     $(".layui-nav-item.layui-this").removeClass("layui-this"); 
							     $(".layui-nav-item[subid='"+$(this).attr("lay-id")+"']").addClass("layui-this");
				  		});
					});
				
					
					 $(".create_tab").click(function(){
							 
								   var fid = $(this).attr("id");
								   var isAddTab=false;
								   
								  $(".layui-tab-title >li ").each(function(i){
									  if($(this).attr("lay-id")==fid){
										  isAddTab=false;
										  return false;
									  } else{
										  isAddTab=true;
									  } 
								  })
								  
								  if($(".layui-tab-title >li ").length==0){
									  isAddTab=true;
								   }
								  
								  if(isAddTab==true){
											  var index = layer.load(2, {
												  shade: [0.1,'#fff'] 
												});
											   var ifra = $("<iframe class='ifra' id=ifr"+fid+"  ></iframe>")
											   var laycontent = $(".layui-tab-content")
											  
											   var url=src+"/set/"+$(this).attr("controller")+".do?subid="+$(this).attr("subid");
											   ifra.attr("src",url);
											   laycontent.append(ifra);
											   element.tabAdd('note_tab', {
												   title: $(this).text()
												  ,content: ifra.html()
												  ,id: $(this).attr("id")
												}); 
											   
											   $(".layui-tab-item").each(function(i){
												   if($(".layui-tab-item").length==(i+1)){
												  		$(this).append(document.getElementById("ifr"+fid)); 
												   }
													   
												  
											   })
											layer.close(index);
									  
								  }
								  
								  element.tabChange('note_tab', fid);
							      if($(this).is("layui-this")){
							    	 $(this).removeClass("layui-this");
							      }else{
							    	  $(this).addClass("layui-this"); 
							      }
						})
						
				</script>
		</body>
</html>
