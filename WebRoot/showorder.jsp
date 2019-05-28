<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("num", "5"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	
    
    <title>查看订单</title>
     <script type="text/javascript" src="js/showorderjs.js" charset="UTF-8">
    </script>       

  </head>
  
  <body>
    <div align="center">
   
   	<table border="1" width="95%"  border="0" cellpadding="3" cellspacing="1"  style="margin-bottom:8px;margin-top:8px;">
			
   	<s:iterator value="orders" status="st"  var="order">
			<tr>
			<th>订单号：<s:property value="#order.orderaccount"/></th>
			<th>时间：<s:property value="#order.orderdate"/></th>
			</tr>
   			<tr align="center" >
				<td><input type="button" id="chakan" name="" onclick="chakanmount('<s:property value="id"/>')" value="查看"></td>
				<td><s:property value="#order.recevstatus"/></td>
				<td>
				<s:if test="#order.recevstatus=='未收货'">
				<input type="button" id="queren" name="" value="确认收货" onclick="quemount('<s:property value="id"/>')"/>
				</s:if>
				<s:else>
				<input type="button" disabled="true" id="queren" name="" value="已经收货" onclick="quemount('<s:property value="id"/>')"/>
				</s:else>
				<s:if test="#order.recevstatus=='已退货'">
					<input type="button" id="shenqing" disabled="true"  name="" value="退货成功" onclick="shenmount('<s:property value="id"/>')"/>
				</s:if>
				<s:else>
					<input type="button" id="shenqing" name="" value="申请退货" onclick="shenmount('<s:property value="id"/>')"/>
				</s:else>
					</td>
			</tr>
   	</s:iterator>
   	</table>
   	[<a href="ShowOrderAction?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="ShowOrderAction?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="ShowOrderAction?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
			[<a href="ShowOrderAction?pageNo=${totalPage}">尾页</a>]
			</div>
  </body>
</html>
