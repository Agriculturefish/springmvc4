package com.topway.springmvc4_01;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import com.nyown.pojo.Items;

public class Client {
	    public static void main(String[] args) {  
	        AsyncRestTemplate template = new AsyncRestTemplate();  
	        //调用完后立即返回（没有阻塞）  
	        ListenableFuture<ResponseEntity<Items>> future = template.getForEntity("http://127.0.0.1:38080/springmvc/api", Items.class);  
	        //设置异步回调  
	        future.addCallback(new ListenableFutureCallback<ResponseEntity<Items>>() {  
	            @Override  
	            public void onSuccess(ResponseEntity<Items> result) {  
	                System.out.println("======client get result : " + result.getBody());  
	            }  
	      
	            @Override  
	            public void onFailure(Throwable t) {  
	                System.out.println("======client failure : " + t);  
	            }  
	        });  
	        System.out.println("==no wait");  
	    }  
    }

      
