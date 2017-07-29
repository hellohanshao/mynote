<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    		<ul class="layui-nav" >
    					<c:forEach var="f" items="${titleList}">
		        		<c:if test="${!empty f.title}">
		        			<c:if test="${f.id eq  active}">
				          		<li class="layui-nav-item layui-this"><a class="nav-link" href="${src}/${f.controller }.do?id=${f.id}">${f.title}</a></li>
				         	 </c:if>
				          	<c:if test="${f.id ne  active}">
				          		<li class="layui-nav-item "><a class="nav-link" href="${src}/${f.controller }.do?id=${f.id}">${f.title}</a></li>
				          	</c:if>
			         	</c:if>
			        </c:forEach>
					 <li class="layui-nav-item " style="margin-left: 300px;">
					 	<select name="city" lay-verify="" style="padding-left: 10px;height: 53px;width:80px; line-height: 38px;font-size: 14px;border-right-width: 0px;">
						  <option value="">全部</option>
						  <c:forEach var="f" items="${titleList}">
						  		<option value="${f.id }">${f.title }</option>
						   </c:forEach>
						</select>   
					 </li>
					 <li class="layui-nav-item ">
					 	<form id="frmSearch" action="http://so.csdn.net/search" class="form_search csdn-tracking-statistics" target="_blank" data-mod="popu_306">
						        <span><input id="inputSearch" type="text" class="blogsearch" title="请输入关键字" placeholder="请输入搜索内容"></span>
						        <input id="btnSubmit" type="button" value="搜索" title="search in blog" />
						        <input type="hidden" name="q" id="inputQ">
						        <input type="hidden" name="t" value="blog">
						        <a id="btnSearchBlog" target="_blank"></a>
        				</form>
					 </li>
					 <li class="layui-nav-item " style="right:2px;float:right;"><a href="javascript:;" id="loginOut">注销</a></li>
		</ul>
