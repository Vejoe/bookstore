<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>

    
    <title>生成订单</title>
    <script type="text/javascript" src="js/orderjs.js" charset="UTF-8">
    </script>  
  </head>
  
  <body>
  <div  id="bigbox" >
  <form method="post" action="AddOrderAction" >
  		
  		<div id="consignee">
  		<h5>确认收货地址</h5>
  		<p><a href="GetCustomerConsigneeDetailBycaccountAction.action">添加收货地址</a></p>
  		<hr>
  		<p>收货人信息</p>
  		<s:iterator value="consignees"  status="st" var="consignee">
  		<p>
  		<input type="radio" name="consigneeradid" value="<s:property value="#consignee.id"/>" id="text" >
  		 <s:hidden name="#consignee.id"/>
  		<s:property value="#consignee.name"/>
  		<s:property value="#consignee.phone_num"/>
  		<s:property value="#consignee.province"/>
  		<s:property value="#consignee.city"/>
  		<s:property value="#consignee.area"/> 
  		<s:property value="#consignee.detailed_address"/>	
  		</p>
  		</s:iterator>
  		</div>
		<hr>
  	  	
  	
  	<div id="paymethod">
  	<s:radio name="paymethod" 
  	list="%{#{'支付宝':'支付宝','微信':'微信'}}" value="" label="支付方式">
  	</s:radio>
  	</div>
  	<hr>
  	<div id="postmethod">
  	<s:radio name="postmethod" list="%{#{'顺丰快递':'顺丰快递','韵达快递':'韵达快递'}}" label="快递方式">
  	</s:radio>
  	</div>
	
  	<hr>
  	<div id="message">
  		<p>留言：</p><s:textfield name="message"></s:textfield>
  		
  	</div>
  	<input type="submit" value="生成订单"/>
  </form>	
  	<input type="button" value="取消订单"  onclick="A()">
  	    	<table border="1" width="60%"  border="0" cellpadding="3" cellspacing="1" style="margin-bottom:8px;margin-top:8px;">
   		<tr>
   		<th>书本名称</th>
   		<th>图片</th>
   		<th>单价</th>
   		<th>数量</th>
   		<th>总价</th>
   		
   		</tr>
   	<s:iterator value="shoppingcartinfos" status="st"  var="shoppingcartinfo">
   			<tr align="center" >
			<td><s:property value="#shoppingcartinfo.bookname"/></td>
			<td><img src="BookImg/<s:property value="#shoppingcartinfo.book.bookfilename"/>"></td>
			<td><s:property value="#shoppingcartinfo.priceofonebook"/></td>
			<td><s:property value="#shoppingcartinfo.ordermount"/></td>
			<td><s:property value="#shoppingcartinfo.price"/></td>

		</tr>
   	</s:iterator>
 	<tr>
 		<td>	总价格<s:property value="#shoppingcartinfo.shoppingcart.allprice"/></td>
 	</tr>
   	</table> 
  	</div>
</body>
</html>
