<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>无标题页</title>
    <link href="Menu/main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    	NPUT {
    BORDER-TOP-WIDTH: 1px; PADDING-RIGHT: 1px; PADDING-LEFT: 1px; BORDER-LEFT-WIDTH: 1px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 1px; BORDER-BOTTOM-COLOR: #cccccc; PADDING-BOTTOM: 1px; BORDER-TOP-COLOR: #cccccc; PADDING-TOP: 1px; FONT-FAMILY: 宋体, Arial, Helvetica; HEIGHT: 18px; BACKGROUND-COLOR: #b0b2a2; BORDER-RIGHT-WIDTH: 1px; BORDER-RIGHT-COLOR: #cccccc
}
BODY {
    SCROLLBAR-HIGHLIGHT-COLOR: buttonface; SCROLLBAR-SHADOW-COLOR: buttonface; SCROLLBAR-3DLIGHT-COLOR: buttonhighlight; SCROLLBAR-TRACK-COLOR: #eeeeee; SCROLLBAR-DARKSHADOW-COLOR: buttonshadow; font-color: #000066
}
.p10 {
    FONT-SIZE: 10.5pt
}
.p9 {
    FONT-SIZE: 9pt; PADDING-BOTTOM: 5px; LINE-HEIGHT: 150%; PADDING-TOP: 5px
}
.text {
    FONT-SIZE: 9pt; FILTER: DropShadow(Color=#f5f5f5, OffX=1, OffY=1, Positive=1)
}
A:link {
    COLOR: #333333; TEXT-DECORATION: none
}
A:visited {
    COLOR: #333333; TEXT-DECORATION: none
}
A:active {
    COLOR: #333333; TEXT-DECORATION: underline
}
A:hover {
    COLOR: #333333; TEXT-DECORATION: underline
}
TD.menu {
    BACKGROUND: #7d86aa
}
TD {
    FONT-SIZE: 9pt; LINE-HEIGHT: 150%
}
.clsMenu {
    BORDER-RIGHT: buttonhighlight 1px outset; BORDER-TOP: buttonhighlight 1px outset; VISIBILITY: hidden; BORDER-LEFT: buttonhighlight 1px outset; WIDTH: 100px; CURSOR: default; COLOR: #000000; BORDER-BOTTOM: buttonhighlight 1px outset; POSITION: absolute; BACKGROUND-COLOR: #f5f5f5
}
.menuitems {
    PADDING-RIGHT: 10px; PADDING-LEFT: 20px; FONT-SIZE: 12px; COLOR: #333333; LINE-HEIGHT: 18px
}
.form1 {
    FONT-SIZE: 9pt; BORDER-BOTTOM: #cccccc 1px solid
}
.form2 {
    FONT-SIZE: 9pt; BORDER-BOTTOM: #999999 1px solid
}
.form3 {
    BORDER-RIGHT: #999999 1px solid; FONT-SIZE: 9pt
}
.form4 {
    BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 9pt; BORDER-BOTTOM: #cccccc 1px solid
}
.form5 {
    BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 9pt
}
.form6 {
    FONT-SIZE: 10.5pt; BORDER-BOTTOM: #999999 1px solid
}
.IN {
    BORDER-TOP-WIDTH: 1px; PADDING-RIGHT: 1px; PADDING-LEFT: 1px; BORDER-LEFT-WIDTH: 1px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 1px; BORDER-BOTTOM-COLOR: #cccccc; PADDING-BOTTOM: 1px; BORDER-TOP-COLOR: #cccccc; PADDING-TOP: 1px; FONT-FAMILY: 宋体, Arial, Helvetica; HEIGHT: 18px; BACKGROUND-COLOR: #ffffff; BORDER-RIGHT-WIDTH: 1px; BORDER-RIGHT-COLOR: #cccccc
}
.form {
    BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; FONT-SIZE: 9pt; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid; BACKGROUND-COLOR: white
}
    	
    
    
    </style>
     <script type="text/javascript">
     var strMenu = "<div id="menu" class="clsMenu" onMouseover="highlight()" onMouseout="lowlight()">"
     strMenu += "<div class="menuitems" onClick="javascript:history.back()">返回</div>"
     strMenu += "<div class="menuitems" onClick="javascript:history.forward()">前进</div>"
     strMenu += "<div class="menuitems" onClick="javascript:location.reload()">刷新</div>"
     strMenu += "<div class="menuitems" onClick="javascript:print()">打印</div>"

     strMenu += "<hr color=#999999 size=1>"
     strMenu += "<div class="menuitems" onClick="javascript:location.href='index.html'">系统首页</div>"
     strMenu += "<div class="menuitems" onClick="javascript:location.href='map.html'">系统帮助</div>"
     //strMenu += "<div class="menuitems" onClick="javascript:location.href='feedback.html'">D??￠·′à?</div>"
     //strMenu += "<div class="menuitems" onClick="javascript:location.href='job.html'">3???ó￠2?</a></div>"

     strMenu += "<div class="menuitems" onClick="javascript:location.href='mailto:scutde@21cn.com'">联系我们</a></div>"
     strMenu += "<div class="menuitems" onClick="javascript:location.href='law.html'">退出系统</a></div>"
     strMenu += "</div>"

     // 
     function ie() {
         if (navigator.appName=="Microsoft Internet Explorer") {
             return true;
         } else {
             return false;
     }}

     // 
     function showmenu(){
         if (ie()){
         // 
         var rightedge=document.body.clientWidth-event.clientX
         var bottomedge=document.body.clientHeight-event.clientY

         // 
         if (rightedge<menu.offsetWidth)
             // 
             menu.style.left=document.body.scrollLeft+event.clientX-menu.offsetWidth
         else
             // 
             menu.style.left=document.body.scrollLeft+event.clientX

         // 
         if (bottomedge<menu.offsetHeight)
             menu.style.top=document.body.scrollTop+event.clientY-menu.offsetHeight
         else
             menu.style.top=document.body.scrollTop+event.clientY

             menu.style.visibility="visible"
         }
         return false
     }


     // 
     function hidemenu(){
         if (ie()) menu.style.visibility="hidden"
     }

     //
     function highlight(){
         if (event.srcElement.className=="menuitems"){
             event.srcElement.style.backgroundColor="#03618D"
             event.srcElement.style.color="#FFFFFF"
     }}

     //
     function lowlight(){
         if (event.srcElement.className=="menuitems"){
         event.srcElement.style.backgroundColor=""
         event.srcElement.style.color="menutext"
     }}

     if (ie()) document.write (strMenu);
     document.oncontextmenu= showmenu
     document.body.onclick= hidemenu
        
        </script> 
</head>
<body>
    <form id="form1" runat="server">
    <div>
        菜单测试
    
                  
</SCRIPT>
    </div>
    </form>
</body>
</html>