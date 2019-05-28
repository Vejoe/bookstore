<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("num", "4"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
    <script type="text/javascript" src="js/shoppingcartjs.js" charset="UTF-8">
    </script>    
  </head>
  
  <body>
	<%-- <jsp:include page="top.jsp"></jsp:include> --%>
	
   	<table border="1"  border="0" cellpadding="3" cellspacing="1" style="margin-bottom:8px;margin-top:8px;">
   		<tr>
   		<th width="300px">书本名称</th>
   		<th>图片</th>
   		<th width="50px">单价</th>
   		<th width="80px">数量</th>
   		<th width="100px">总价</th>
   		<th width="200px">编辑</th>
   		</tr>
   	<s:iterator value="shoppingcartinfos" status="st"  var="shoppingcartinfo">
   			<tr align="center" >
			<td><s:property value="#shoppingcartinfo.bookname"/></td>
			<td><img src="BookImg/<s:property value="#shoppingcartinfo.book.bookfilename"/>"></td>
			<td><s:property value="#shoppingcartinfo.priceofonebook"/></td>
			<td><input type="button" id="min" name="" value="-" onclick="domnmount('<s:property value="id"/>')"/><s:property value="#shoppingcartinfo.ordermount"/><input type="button" id="add" name="" value="+" onclick="addmount('<s:property value="id"/>')"/></td>
			<td><s:property value="#shoppingcartinfo.price"/></td>
			<td>
				<a href="javascript:deleteshoppingcartinfo('<s:property value="id"/>')">删除</a>
			</td>
		</tr>
   	</s:iterator>
 	<tr>
 		<td>	总价格<s:property value="#shoppingcartinfo.shoppingcart.allprice"/></td>
 	</tr>
   	</table>
   	<input style="width:80px;" type="button" value="清空购物车" onclick="delall()"/>
   	<input type="button" style="width:70px;" id="jiesuan" value="结算"  onclick="jiesuan()" >
   	[<a href="ShowShoppingCartAction?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="ShowShoppingCartAction?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="ShowShoppingCartAction?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
			[<a href="ShowShoppingCartAction?pageNo=${totalPage}">尾页</a>]
  </body>
</html>
