package com.nyown.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
public class SpringMvcConfigure  extends WebMvcConfigurerAdapter {
 
  /**
   * 非必须
   */
  @Override
  public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
 
  /**
   * 如果项目的一些资源文件放在/WEB-INF/resources/下面
   * 在浏览器访问的地址就是类似：https://host:port/projectName/WEB-INF/resources/xxx.css
   * 但是加了如下定义之后就可以这样访问：
   * https://host:port/projectName/resources/xxx.css
   * 非必须对外暴露访问的路径
   */
  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**/*").addResourceLocations("/WEB-INF/resources/");
  }
  
  /**
   * 拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      super.addInterceptors(registry);
//      registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/").excludePathPatterns("/admin");    
  }
  
  
}
