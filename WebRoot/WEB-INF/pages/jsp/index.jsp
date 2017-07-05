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
	
	
}) 

</script>
<style type="text/css">
.detailajax a:focus{
	color:red;
}

</style>
		<body>
	
					<%@ include file="../common/main.jsp"%>
			
				    <div class="container-fluid">
				      		<div class="row">
						       		 <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-faded sidebar"  style="display: none">
							          <ul class="nav nav-pills flex-column">
								          <c:forEach items="${subTitleList}" var="f" >
								          		<li class="nav-item">
										              <a class="nav-link"  
										              	<c:if test="${f.id eq  subactive}">style="color:#fff" </c:if>
									              			href="${src}/index/subtitle.do?subid=${f.id}&id=${active}">${f.subtitle }</a>
									            </li>
							              </c:forEach>
							          </ul>
						        	</nav>
					        		<main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3" role="main">
							       		<div class="row" id="nosetting">
										        <div class="col-sm-8 blog-main">
											          <div class="blog-post">
											            <h2 class="blog-post-title" id="detailname"></h2>
											            <p class="blog-post-meta">20170630 <a href="#">(By)lixiaobo</a></p>
											            <p id="detail">
																										
											            </p>
											          </div>
										
											          <nav class="blog-pagination">
											            <a class="btn btn-outline-primary" href="#">Older</a>
											            <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
											          </nav>
										        </div>
							
										        <div class="col-sm-3 offset-sm-1 blog-sidebar">
											          <div class="sidebar-module sidebar-module-inset">
											            <h4>关于</h4>
											            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
											          </div>
											          <div class="sidebar-module">
											            <h4>JAVA学习</h4>
											            <ol class="list-unstyled">
											            <c:forEach items="${detailList}" var="f" >
											              <li><a class="detailajax" detailid="${f.id }" href="#" subid="${subactive }" titleid="${active}" >${f.detailname }JAVA学习下的笔记列表</a></li>
											            </c:forEach>
											            </ol>
											          </div>
											          <div class="sidebar-module">
											            <h4>暂且没想到</h4>
											            <ol class="list-unstyled">
											              <li><a href="#">GitHub</a></li>
											              <li><a href="#">Twitter</a></li>
											              <li><a href="#">Facebook</a></li>
											            </ol>
											          </div>
											    </div>
							      		</div>
							      		
							      		
				<div id="setting" style="display: none">
				  <section class="row text-center placeholders">
					<div class="col-6 col-sm-3 placeholder">
					  <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail" width="200" height="200">
					  <h4>Label</h4>
					  <div class="text-muted">Something else</div>
					</div>
					<div class="col-6 col-sm-3 placeholder">
					  <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail" width="200" height="200">
					  <h4>Label</h4>
					  <span class="text-muted">Something else</span>
					</div>
					<div class="col-6 col-sm-3 placeholder">
					  <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail" width="200" height="200">
					  <h4>Label</h4>
					  <span class="text-muted">Something else</span>
					</div>
					<div class="col-6 col-sm-3 placeholder">
					  <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" class="img-fluid rounded-circle" alt="Generic placeholder thumbnail" width="200" height="200">
					  <h4>Label</h4>
					  <span class="text-muted">Something else</span>
					</div>
				  </section>

				  <h2>Section title</h2>
				  <div class="table-responsive">
					<table class="table table-striped">
					  <thead>
						<tr>
						  <th>#</th>
						  <th>Header</th>
						  <th>Header</th>
						  <th>Header</th>
						  <th>Header</th>
						</tr>
					  </thead>
					  <tbody>
						<tr>
						  <td>1,001</td>
						  <td>Lorem</td>
						  <td>ipsum</td>
						  <td>dolor</td>
						  <td>sit</td>
						</tr>
						<tr>
						  <td>1,003</td>
						  <td>libero</td>
						  <td>Sed</td>
						  <td>cursus</td>
						  <td>ante</td>
						</tr>
						<tr>
						  <td>1,007</td>
						  <td>sagittis</td>
						  <td>ipsum</td>
						  <td>Praesent</td>
						  <td>mauris</td>
						</tr>
						
					  </tbody>
					</table>
				  </div>
				</main>
			</div>
				
				
				 				 </main>
				      		</div>
				      
			        </div>
	      
					<%@include file="../common/bottom.jsp" %>
		</body>
</html>