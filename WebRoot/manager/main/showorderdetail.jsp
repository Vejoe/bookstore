<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>My JSP 'showorderdetail.jsp' starting page</title>
   <link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
	<script type="text/javascript">
	function do1(st){
		var c=st
		
		if(c=="未发货"){
		location.href="todealOrder?id=${order.id}";
		}
	}
	function do2(st){
		var c=st;
		
		if(c=="请求退货"){
		location.href="todealOrder3?id=${order.id}";
		}
	}
	function do3(st){
		var c=st;
		
		if(c!="已收货"){
		location.href="todealOrder2?id=${order.id}";
		}
	}
	</script>
  </head>
  
  <body>
    <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">订单详情</h2>
      </div>
      <table class="table">
       <tr>
        <td>收件人：<s:property value="order.consignee.name" /></td>
        <td>联系电话：<s:property value="order.consignee.phone_num" /></td>
        <td>收件地址：<s:property value="order.consignee.province"/><s:property value="order.consignee.city" /><s:property value="order.consignee.area" /><s:property value="order.consignee.detailedAddress" /></td>
        <td>下单时间：<s:property value="order.orderdate" /></td>
       </tr>
       <tr>
        <td>订单金额：<s:property value="order.orderprice" /></td>
        <td>购买顾客：<s:property value="order.customer.cname" /></td>
        <td>配送方式：<s:property value="order.postmethod" /></td>
        <td>支付方式：<s:property value="order.paymethod" /></td>
       </tr>
       <tr>
        <td>订单状态：<s:property value="order.poststatus" />,<s:property value="order.recevstatus" /></td>
        <td colspan="3">订单备注：<mark><s:property value="order.message" /></mark></td>
        </tr>
      </table>
      <table class="table">
      <s:iterator value="orderdetails" status="stat" var="orderdetail">
       <tr>
        <td class="center"><img src="../../BookImg/<s:property value="#orderdetail.book.bookfilename" />" width="50" height="50"/></td>
        <td class="center"><s:property value="#orderdetail.book.bookname" /></td>
        <td class="center"><s:property value="#orderdetail.totalprice/#orderdetail.ordermount" /></td>
        <td class="center"><s:property value="#orderdetail.ordermount" /></td>
        <td class="center">
         <p>类型：<s:property value="#orderdetail.book.booktype.type" /></p>
         <p>作者：<s:property value="#orderdetail.book.author" /></p>
        </td>
        <td class="center"><s:property value="#orderdetail.totalprice" /></td>
       </tr>
       </s:iterator>
      </table>
      <aside class="mtb" style="text-align:right;">
       <label>管理员操作：</label>
       <input type="text" class="textbox textbox_295" placeholder="管理员操作备注"/>
       <input type="button" value="打印订单" class="group_btn"/>
       <input type="button" value="确认订单" class="group_btn"/>
       <input type="button" value="发货" class="group_btn" onclick="do1('<s:property value="order.poststatus"/>')"/>
       <input type="button" value="退货" class="group_btn" onclick="do3('<s:property value="order.recevstatus"/>')")/>
       <input type="button" value="确认收货" class="group_btn" onclick="do2('<s:property value="order.recevstatus"/>')"/>
      </aside>
 </div>
</section>
  </body>
</html>
