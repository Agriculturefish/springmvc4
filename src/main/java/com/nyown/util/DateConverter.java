
	package com.nyown.util;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	 
	import org.springframework.core.convert.converter.Converter;
	 
	//需要实现Converter接口，这里是将String类型转换成Date类型
	public class DateConverter implements Converter<String, Date> {
		@Override
		public Date convert(String source) {
			 //实现将字符串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            return dateFormat.parse(source);
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        //如果参数绑定失败返回null
	        return null;
		}
	 
	}

      
