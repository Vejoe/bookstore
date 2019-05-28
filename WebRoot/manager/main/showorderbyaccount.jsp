<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>My JSP 'showorder.jsp' starting page</title>

	 <link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
	<script type="text/javascript">
	function deleteorder(id){
	if(confirm("你确定删除该订单吗?")){
		location.href="deleteOrder?id="+id;
	}
	}
	
	  function queryname(){
    	var c=document.getElementById("queryname").value;
    	if(c.length>0){
    	location.href="queryAccountOrder?mname="+c;
    	}
    }
	</script>

  </head>
  
  <body>
    <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">订单列表</h2>
       <a href="addmanager.jsp" class="fr top_rt_btn add_icon" target="mainframe">添加商品</a>
      </div>
      <section class="mtb">
       <input type="text" class="textbox textbox_225" placeholder="输入订单标号..." id="queryname"/>
       <input type="button" value="查询" class="group_btn" onclick="queryname()"/>
      </section>
      <table class="table">
       <tr>
        <th>id</th>
        <th>订单号</th>
        <th>订单时间</th>
        <th>收货人</th>
        <th>收货地址</th>
        <th>发货状态</th>
        <th>收货状态</th>
        <th>价格</th>
        <th colspan=3>操作</th>
       </tr>
        <s:set var="flag" name="mname"/>
       <s:iterator value="orders" status="stat" var="order">
       <tr>
        <td class="center"><s:property value="#order.id" /></td>
        <td class="center"><s:property value="#order.orderaccount" /></td>
        <td class="center"><s:property value="#order.orderdate" /></td>
        <td class="center"><s:property value="#order.consignee.name" /></td>
        <td class="center"><s:property value="#order.consignee.province"/><s:property value="#order.consignee.city" /><s:property value="#order.consignee.area" /><s:property value="#order.consignee.detailedAddress" /></td>
        <td class="center"><s:property value="#order.poststatus" /></td>
        <td class="center"><s:property value="#order.recevstatus" /></td>
        <td class="center"><s:property value="#order.orderprice" /></td>
       <td class="center">
		<s:if test="#order.recevstatus=='未收货'">
		<s:if test="#order.poststatus=='未发货'">
		<input type="button" value="发货" onclick="javascript:location.href='todealOrder?id=${order.id}'">
		</s:if>
		</s:if>
		</td>
		<td class="center">
		<s:if test="#order.recevstatus=='请求退货'">
		<input type="button" value="退货" onclick="javascript:location.href='todealOrder2?id=${order.id}'">
		</s:if>
		</td>
        <td class="center">
         <a href="javascript:location.href='toOrderdetail?id=${order.id}'" title="查看" class="link_icon">&#118;</a>
         <a href="javascript:deleteorder('<s:property value="id"/>')" title="删除" class="link_icon">&#100;</a>
        </td>
       </tr>
       </s:iterator>
      </table>
      <aside class="paging">
      <a href="queryAccountOrder?pageNo=1&mname=${flag}">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
					<a href="queryAccountOrder?pageNo=${currentPage-1}&mname=${flag}">上一页</a>
				</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
					<a href="queryAccountOrder?pageNo=${currentPage+1}&mname=${flag}">下一页</a>
				</c:when>
		</c:choose>
		<a href="queryAccountOrder?pageNo=${totalPage}&mname=${flag}">尾页</a>
		[${currentPage}/${totalPage}]
      </aside>
 </div>
</section>
  </body>
</html>
