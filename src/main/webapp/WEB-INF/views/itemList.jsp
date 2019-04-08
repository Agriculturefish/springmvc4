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
       <c:forEach items="${itemList}" var="l">
		  <tr>
		    <td class="midTable1td2" width="20px">
		   <c:if test="${not empty l}"> 
			    <INPUT type="checkbox" name="del" value="${l.id}"> </td>    
			    <td width="100px">${l.name}</td>
			    <td align="center">${l.price}</td>
			    <td align="center" width="30px">
			        <input type="button"  name="update" value="变更" onclick="update1(${l.id})">
			    </td>
		    </c:if>
		   </tr>           
		</c:forEach> 
   </table>
</body>
</html>