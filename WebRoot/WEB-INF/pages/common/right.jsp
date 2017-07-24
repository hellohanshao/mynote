<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="sidebar-module">
          <h4>${Rtitle}</h4>
          <ol class="list-unstyled">
	          <c:forEach items="${detailList}" var="f" >
	           	 <li><a detailid="${f.id }" href="${src}/index/detail2.do?subid=${subactive}&id=${active}&detailid=${f.id }" subid="${subactive }" titleid="${active}" >${f.detailname }</a></li>
	          </c:forEach>
          </ol>
        </div>
        <div class="layui-btn-group1" >
			<button class="layui-btn layui-btn-small" id="insertdetail" relation="${subactive}"><i class="layui-icon"></i></button>
		</div>