<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>
     <form action="itemList" method="post">
	   <center>
	        <h2>Welcome to dennis shop</h2>
	        <h2> ${map.name}</h2>
	    </center>
	   <label>时间:</label>
	      <input type="text" name="starttime">  
	      <!-- <input type="text" name="createtime">   -->
	      <input type="submit" name="find" value="查找"/>
   </form>
</body>
</html>