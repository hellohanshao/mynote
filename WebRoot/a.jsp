<%@ page language="java" contentType="text/html; charset=UTF-8"
	  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jQuery右键菜单，上下文菜单-柯乐义</title>
<script type="text/javascript" src="http://keleyi.com/keleyi/pmedia/jquery-1.8.2.min.js"
charset="utf-8"></script>
<style type="text/css" media="screen">
html, body
{
height: 100%;
}

body
{
font-family: 'lucida grande' , tahoma, verdana;
font-size: 15px;
color: #555;
width: 700px;
margin: 0 auto;
padding: 30px 0;
}

h1, h2
{
color: #222;
}

ul
{
list-style-type: none;
list-style-position: inside;
margin: 0;
padding: 0;
}

/* all context menus have this class */
.context-menu
{
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;
background-color: #f2f2f2;
border: 1px solid #999;
list-style-type: none;
margin: 0;
padding: 0;
}
.context-menu a
{
display: block;
padding: 3px;
text-decoration: none;
color: #333;
}
.context-menu a:hover
{
background-color: #666;
color: white;
}

/* second context menu */
#context-menu-2
{
border: 1px solid #333;
background-color: orange;
margin: 0;
padding: 0;
}


.target1, .target2 li, .target3 li
{
background-color: #ddd;
color: #333;
border: 1px solid #c6c6c6;
padding: 5px;
}

.target1
{
width: 130px;
}

.target2 li, .target3 li
{
margin-top: 5px;
}

.target1 li.green, .target2 li.green, .target3 li.green
{
background-color: green;
color: #fff;
}

.big-font
{
font-size: 25px;
}
</style>
</head>
<body>
<h1>
jQuery右键菜单示例·柯乐义</h1>
<h2>
例 1</h2>
<p>
单个div的上下文菜单。 Note that the native context menu is disabled by passing {disable_native_context_menu:
true} as the options hash and last argument of the plugin. The native context menu
is enabled by default.
</p>
<div class="target1">
右击我</div>
<h2>
<div>
本插件的不足支出就是不支持jquery1.9以上版本。</div>
<script src="http://keleyi.com/keleyi/phtml/jqplug/8/jquery.contextMenu.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function () {
//例1
$('.target1').contextMenu('context-menu-1', {
'右键菜单项1': {
click: function (element) { // element is the jquery obj clicked on when context menu launched
alert('点击了右键菜单项');
},
klass: "menu-item-1" // a custom css class for this menu item (usable for styling)
},
'右键菜单项2': {
click: function (element) { alert('点击了第二项'); },
klass: "second-menu-item"
}, '返回首页': { click: function (element) { location.href = "http://keleyi.com"; } }
});
//例2
$('.target2 li').contextMenu('context-menu-2', {
'彩上绿色!': {
click: function (element) { // element is the jquery obj clicked on when context menu launched
element.addClass('green');
},
klass: "menu-item-1" // a custom css class for this menu item (usable for styling)
},
'变大!': {
click: function (element) { element.addClass('big-font') },
klass: "second-menu-item"
}, '打开原文': { click: function (element) { window.open("http://keleyi.com/a/bjac/qjaheda1.htm"); } }
}, { disable_native_context_menu: true, leftClick: true }
);
//例3
$('.target3 li').contextMenu('context-menu-2', {
'变大!': {
click: function (element) { element.addClass('big-font') },
klass: "menu-item-1" // a custom css class for this menu item (usable for styling)
}
}, {
disable_native_context_menu: true,
showMenu: function (element) { element.addClass('green'); },
hideMenu: function (element) { element.removeClass('green'); }
});
});
</script>



<div contextmenu="mymenu">qqqqqqqqqqqqqqqqqqqqqqqq
<menu type="context" id="mymenu">
  <menuitem label="Refresh"></menuitem>
  <menuitem label="Twitter"></menuitem>
</menu>
</div>
</body>
</html>