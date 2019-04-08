package com.nyown.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

public class CommonUtils {
	public Object convertValue(Map<String, Object> context, Object value,
            Class<?> toType) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {

            if(value!=null){
                if(toType==Date.class){
                    String [] params=(String[])value;
                    String param=params[0];
                    if(!StringUtils.isNullOrEmpty(param)){
                        return df.parse(param);
                    }else
                        return null;
                }
                else if (toType==String.class) {
                    Date date=(Date)value;
                    return df.format(date);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return null;

    }
	
	public static Date convert(String source) {
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
