package com.nyown.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

@Controller
public class HelloController {
	 //日志类
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
   @RequestMapping("/hello")
   public String showMessage(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name,HttpServletRequest request) {
	   logger.debug("进入showMessage方法,传入参数：{}"+JSON.toJSONString(name));
       Map<String,String> map=new HashMap<String, String>();
       map.put("name", name);
       request.setAttribute("map", map);
       logger.info("退出showMessage方法,返回信息：{}"+JSON.toJSONString(map));
       return "hello";
   }
}
