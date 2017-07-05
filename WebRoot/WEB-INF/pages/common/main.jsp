<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
					<nav class="navbar navbar-expand-md navbar-inverse fixed-top bg-inverse">
				      	<a class="navbar-brand" href="${src}/setting.do?id="  
				      		<c:if test="${active eq 0 }"> style="color:#fff" </c:if> 
				      		 >设置</a>
						      <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
						        <span class="navbar-toggler-icon"></span>
						      </button>
				
						      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
						      
							        <ul class="navbar-nav mr-auto">
							        	<c:forEach var="f" items="${titleList}">
							        		<c:if test="${!empty f.title}">
							        			<c:if test="${f.id eq  active}">
									          		<li class="nav-item active">
									          </c:if>
									          <c:if test="${f.id ne  active}">
									          		<li class="nav-item">
									          </c:if>
									            <a class="nav-link" href="${src}/index.do?id=${f.id}">${f.title}</a>
									          </li>
								         	</c:if>
								        </c:forEach>
							        </ul>
							        <form class="form-inline mt-2 mt-md-0">
							          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
							          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
							        </form>
						      </div>
				     </nav>
