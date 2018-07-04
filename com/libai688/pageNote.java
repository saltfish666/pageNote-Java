package com.libai688;

import java.io.IOException;    
import java.io.OutputStream;   
import java.net.InetSocketAddress;   
import java.util.Queue;  
import java.util.concurrent.*;  
  
import com.sun.net.httpserver.HttpExchange;   
import com.sun.net.httpserver.HttpHandler;   
import com.sun.net.httpserver.HttpServer; 

public class pageNote {
	public static void main(String[] args) throws IOException {
		 try {  
         
            int backLog = 10;  
            InetSocketAddress inetSock = new InetSocketAddress(8086);  
            HttpServer httpServer = HttpServer.create(inetSock, backLog);  
         
            httpServer.createContext("/", new HandlerTestA());  
            httpServer.createContext("/test",new HandlerTestB());  
            httpServer.setExecutor(null);  
            httpServer.start();  
            System.out.println("HttpServer Test Start!");  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
}

class HandlerTestA implements HttpHandler{  
    public void handle(HttpExchange httpExchange) throws IOException {  
        String responseString = "<font color='#ff0000'>Hello! This a HttpServer!</font>";  
        httpExchange.sendResponseHeaders(200, responseString.length());     
        OutputStream os = httpExchange.getResponseBody();     
        os.write(responseString.getBytes());     
        os.close();   
    }    
} 

class HandlerTestB implements HttpHandler{  
    public void handle(HttpExchange httpExchange) throws IOException {  
        String responseString = "Hello Java";  
        httpExchange.sendResponseHeaders(200, responseString.length());     
        OutputStream os = httpExchange.getResponseBody();     
        os.write(responseString.getBytes());     
        os.close();   
    }
} 



