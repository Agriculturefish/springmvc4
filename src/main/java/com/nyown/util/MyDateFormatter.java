
	package com.nyown.util;

	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Locale;

	import org.springframework.format.Formatter;
	
	public class MyDateFormatter implements Formatter<Date> {

	    public String print(Date object, Locale locale) {
	        // TODO Auto-generated method stub
	        return null;
	    }

	    public Date parse(String text, Locale locale) throws ParseException {
	        // TODO Auto-generated method stub
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = null;
	        try {
	            date = format.parse(text);
	        } catch (Exception e) {
	            format = new SimpleDateFormat("yyyy-MM-dd");
	            date = format.parse(text);
	        }
	        return date;
	    }

	}

      
