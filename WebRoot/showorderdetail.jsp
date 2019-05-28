<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>订单详细</title>
 		<script type="text/javascript" src="js/showorderjs.js" charset="UTF-8">
   		 </script>  
  </head>
  
  <body>
      
   	<table border="1" width="99%"  border="0" cellpadding="3" cellspacing="1"  style="margin-bottom:8px;margin-top:8px;">
   		<tr>
   		<th>书本名称</th>
   		<th>图片</th>
   		<th>数量</th>
   		<th>总价</th>
   		</tr>
   	<s:iterator value="orderdetails" status="st"  var="orderdetail">
   			<tr align="center" >
			<td><s:property value="#orderdetail.book.bookname"/></td>
			<td><img src="BookImg/<s:property value="#orderdetail.book.bookfilename"/>"></td>
			<td><s:property value="#orderdetail.ordermount"/></td>
			<td><s:property value="#orderdetail.totalprice"/></td>
			</tr>
   	</s:iterator>

   			<input type="button"  id="fanhui" value="返回"  onclick="fanhui()" >
   		</div>
   </div>
  </body>
</html>
