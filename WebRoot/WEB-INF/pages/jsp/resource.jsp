<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	
 %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript">
var src= '${src}';
var isclick=0;
$(function(){ 
	$(".detailajax").click(function(){
		$(this).css("color","red");
		var detailid = $(this).attr("detailid");
		var subid = $(this).attr("subid");
		var titleid = $(this).attr("titleid");
		$.get(src+"/index/detail.do",
			{subid:subid,id:titleid,detailid:detailid},
			function(data){
				$("#detailname").empty();
				$("#detailname").append(data.detailname);
				$("#detail").empty();
				$("#detail").append(data.detail);
			},"json");
	});
	
	$(".navbar-brand").click(function(){
		
		$("#setting").show();
		$("#nosetting").hide();
		
		
	});
	
 	$(".btn-group").click(function(){
		if(isclick==0){
			$("[class='col-sm-3 col-md-2 d-none d-sm-block bg-faded sidebar']").css(
					{"width": "60px"}
			); 
			$("[class='col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3']").css(
					{"width": "100%","margin-left":"50px"}
			); 
			isclick=1;
		}else if(isclick==1){
			$("[class='col-sm-3 col-md-2 d-none d-sm-block bg-faded sidebar']").css(
					{"width": "15%"}
			);
			$("[class='col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3']").css(
					{"width": "85%","margin-left":"200px"}
			);
			isclick=0;
		}
		
	}); 
 	
}) 

</script>
<style type="text/css">
.detailajax a:focus{
	color:red;
}
/* .btn-group{
margin-left:150px;
width:15px;
} */

</style>
		<body>
	<%@ include file="../common/main.jsp"%>
		<div class="row">
	       		 <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-faded sidebar"  style="width:15%">
			       	<div class="btn-group" role="group" aria-label="..." >
										<button type="button" class="btn btn-default" ><></button>
					</div>
			          <ul class="nav nav-pills flex-column">
				          <c:forEach items="${subList}" var="f" >
				          		<li class="nav-item">
						              <a class="nav-link"  
						              	<c:if test="${f.id eq  subactive}">style="color:#fff" </c:if>
					              			href="${src}/setting/user.do?subid=${f.id}">${f.setname }</a>
					            </li>
			              </c:forEach>
			          </ul>
	        	</nav>
	        		<div id="aaa"  style="width:800px;height:600px;margin-left:400px;magin-top:150px" ></div>	   
		</div>   	
	<%@include file="../common/bottom.jsp" %>
	</body>
</html>