<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<c:forEach var="f" items="${detailList}">
		 <div>
		 	<a class="openDetail"  href="javascript:;" detailid="${f.id }" subid="${subactive}" id="${active}" ><b><li>${f.detailname }</li></b></a>
		 	<p style="font-size: 13px">
		 		${f.detail }
		 	</p>
		 </div>
		 <hr style="background-color: gray;">
		 </c:forEach>
			 <div id="demo7" align="center"></div>
