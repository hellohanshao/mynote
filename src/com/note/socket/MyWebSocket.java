package com.note.socket.web;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.note.listener.NoteServletListener;

/**
 * 
 * 日期：2017年7月13日
 * 作者：李小波
 * javax包自带的websocket包
 */
@ServerEndpoint(value = "/websocket")  
public class MyWebSocket {
	 // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private  static final AtomicInteger onlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    //定义一个记录客户端的聊天昵称
    private final String nickname="";
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    
    private static int count=0;
    
   
    @OnOpen  
    public void open(Session session) {  
    	 this.session = session;
         webSocketSet.add(this);
         String message = String.format("[%s,%s]","","加入聊天室");
         broadcast(message);
         System.out.println("onOpen");
        System.out.println("MyWebSocket与客户端建立连接。。");
        count++;
        System.out.println(count+"open");
    }  
      
    @OnMessage  
    public void inMessage(String message) throws IOException, InterruptedException {  
        System.out.println("MyWebSocket处理用户信息" + this.session.getId()); 
        broadcast(String.format("%s:%s",nickname,filter(message)));
        count++;
        NoteServletListener.constant = NoteServletListener.constant+1;
       System.out.println(NoteServletListener.constant);
        System.out.println(count+"inMessage");
    }  
      
    @OnClose  
    public void end(Session session,CloseReason closeReason) {  
        try {
        	webSocketSet.remove(this);
            String message = String.format("[%s,%s]",nickname,"离开了聊天室链接");
            broadcast(message);
            
        	System.out.println("MyWebSocket关闭socket " + session.getId());  
		} catch (Exception e) {
			// TODO: handle exception
		}
    }  
    
    //完成群发
    private void broadcast(String info){
        for(MyWebSocket w:webSocketSet){
            try {
                synchronized (MyWebSocket.class) {
                    w.session.getBasicRemote().sendText("alert("+"'aa'"+")"+info+"<br>");
                }
            } catch (IOException e) {
                System.out.println("向客户端"+w.nickname+"发送消息失败");
                webSocketSet.remove(w);
                try {
                    w.session.close();
                } catch (IOException e1) {}
                String message = String.format("[%s,%s]",w.nickname,"已经断开链接");
                broadcast(message);
            }

        }
    }
    
  //对用户的消息可以做一些过滤请求，如屏蔽关键字等等。。。
    public static String filter(String message){
        if(message==null){
            return null;
        }
        return message;
    }
}
