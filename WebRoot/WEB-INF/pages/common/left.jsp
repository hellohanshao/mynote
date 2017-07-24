<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="layui-nav layui-nav-tree" id="sideNav" lay-filter="sideNav">
<c:forEach items="${subTitleList}" var="f" >	
  <li subid="${f.id}" id="${active}"  class="layui-nav-item 
  	<c:if test="${f.id eq  subactive}" >layui-nav-itemed 
  	</c:if> > ">
    <a href="${src}/index/subtitle.do?subid=${f.id}&id=${active}">${f.subtitle }</a>
  </li>
</c:forEach>
</ul>
