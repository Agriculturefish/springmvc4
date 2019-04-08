<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item</title>
</head>
<body>
   <table>
		 <tr>
		    <td class="midTable1td2" width="20px">
			   <%--  <INPUT type="checkbox" name="del" value="${request.item.id}"> </td>     --%>
			    <td width="100px">${name}</td>
			    <%-- <td align="center">${request.item.price}</td>
			    <td align="center" width="30px">
			        <input type="button"  name="update" value="变更" onclick="update1(${request.item.id})">
			    </td> --%>
		   </tr>          
		   <h1>item</h1>  
   </table>
</body>
</html>