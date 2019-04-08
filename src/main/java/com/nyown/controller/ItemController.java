package com.nyown.controller;

import java.util.List;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyown.pojo.Items;
import com.nyown.pojo.ItemsVO;
import com.nyown.service.ItemService;

/**
 * @RestController指定在控制器上，这样就不需要在每个@RequestMapping方法上加 @ResponseBody
 * 而且添加了一个AsyncRestTemplate ，支持REST客户端的异步无阻塞支持
 * */
@RestController  
public class ItemController {
 
	/*  @Autowired//默认按type注入;@Qualifier("itemService")//一般作为@Autowired()的修饰用
		@Resource(name="itemService")//默认按name注入，可以通过name和type属性进行选择性注入
		@Component  定义Bean, 不好归类时使用
		@Repository("Bean的名称")定义DAO层Bean
		@Service("Bean的名称")定义业务层Bean
		@Controller("Bean的名称")定义控制层Bean,如Action
	*/
    @Autowired
    @Qualifier("itemService")
    private ItemService itemService;
    
    //日志类
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
    /**
     * 使用jstl标签输出结果集
     * */
    @RequestMapping(value="/itemList")
    public String  getItemsList(HttpServletRequest request,@ModelAttribute ItemsVO itemvo) {
    	
    	logger.debug("进入getItemsList方法,传入参数："+JSON.toJSONString(itemvo));
        // 查询商品列表
        List<Items> itemList = itemService.getItemList(itemvo);
        // 把查询结果传递给页面
        // 返回结果
        request.setAttribute("itemList", itemList);
    	itemvo.setId(1);
        Items item = itemService.getItem(itemvo);
        request.setAttribute("item", item);
        logger.info("退出getItemsList方法,返回信息："+JSON.toJSONString(itemList));
        return "itemList";
    }
    
    
    
    @RequestMapping(value="/item1")
    public String  getItems(HttpServletRequest request,@ModelAttribute ItemsVO itemvo) {
    	logger.debug("进入getItems方法,传入参数："+JSON.toJSONString(itemvo));
    	itemvo.setId(1);
        Items item = itemService.getItem(itemvo);
        request.setAttribute("item", item);
        logger.info("退出getItemsList方法,返回信息："+JSON.toJSONString(item));
        return "itemList";
    }
    
    /**
     * 提供AsyncRestTemplate用于客户端非阻塞异步支持
     * 服务器端暂停10秒再返回结果（但是服务器也是非阻塞的）
     * */
    @RequestMapping("/item")  
    public Callable<Items> api(HttpServletRequest request,@ModelAttribute ItemsVO itemvo,final Model model) {  
      logger.debug("进入api方法,传入参数："+JSON.toJSONString(itemvo)+"1、开启异步");
      return new Callable<Items>() {  
          @Override  
          public Items call() throws Exception {  
        	//2、设置超时时间
              Thread.sleep(2000L); //暂停两秒
              //3、告诉容器分派一个新的线程执行异步任务
              itemvo.setId(1);
              Items item = itemService.getItem(itemvo);
              model.addAttribute("name",item.getName());
              logger.info("退出api方法,返回信息："+JSON.toJSONString(item));
              return item;  
          }  
      };  
      //4、当前线程可立即返回
    }
    
    @RequestMapping("/api")  
    public Callable<Items> api() {  
      System.out.println("=====hello");  
      return new Callable<Items>() {  
          @Override  
          public Items call() throws Exception {  
              Thread.sleep(2000L); //暂停两秒  
              Items user = new Items();  
              user.setId(1);  
              user.setName("haha");  
              return user;  
          }  
      };  
  }  
    
}
