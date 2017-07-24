<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <base href="<%=basePath%>">  
          
        <title>WebSocket</title>  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">         
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
        <meta http-equiv="description" content="This is my page">  
        <!-- 
        <link rel="stylesheet" type="text/css" href="styles.css"> 
        -->  
        <script src="${file}/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript">  
  
            var ws;  
            var url = "ws://" + window.location.host + "/mynote/websocket";  
            var result;  
  
            function initWebSocket() {  
                result = document.getElementById("result");  
                if("WebSocket" in window) {  
                    ws = new WebSocket(url);  
                }else if("MozWebSocket" in window) {  
                    ws = new MozWebSocket(url);  
                }else {  
                    result.innerHTML = "No support WebSocket !<br>";  
                }  
  
                ws.onopen = function() {  
                    result.innerHTML = "..# onopen" + "<br>";
                    ws.send("Hello WebSocket !");  
                };  
                ws.onmessage = function(event) {  
                	
                	 $("#log-container div").append(event.data);
                     // 滚动条滚动到最低部
                     $("#log-container").scrollTop($("#log-container div").height() - $("#log-container").height());
                     
                   /*  result.innerHTML += "..# onmessage : " + event.data + "<br>";  */ 
                };  
                ws.onclose = function(event) {  
                    result.innerHTML += "..# onclose" + "<br>";  
                }; 
                console.dir(ws);
            }  
  
            function send() {  
                ws.send(document.getElementById("msg").value);  
                console.dir(ws);
            }  
        </script>  
    </head>  
      
    <body onload="initWebSocket();">  
        <h1>WEBSOCKET</h1>  
        <hr>  
        <div id="log-container" style="height: 450px; overflow-y: scroll; background: #333; color: #aaa; padding: 10px;">
        <div>
        </div>
    </div>
        <div id="result" style="bottom: 20px;position: fixed;overflow-x: auto; "></div>  
        <textarea rows="5" cols="20" id="msg"></textarea>  
        <br>  
        <button onclick="send()">send</button>  
    </body>  
</html>  