<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("num", "6"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Myself_m6.jsp' starting page</title>
    <sx:head/>
    <link href="css/GetconsigneesOrGetmessages.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/Myself_m6.js">
  	</script>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>收货人管理</b>
	<table cellspacing="10" id="table">
    	<tr align="center">
    		<th>收货人姓名</th>
    		<th>收货人手机号</th>
    		<th>收货人地址</th>
    		<th>操作</th>
    	</tr>
    	<s:iterator value="consignees" status="stat" var="consignee">
   		<tr align="center">
    		<td><s:property value="#consignee.getName()" /></td>
    		<td><s:property value="#consignee.getPhone_num()" /></td>
    		<td><s:property value="#consignee.getProvince()" />省<s:property value="#consignee.getCity()" /><s:property value="#consignee.getArea()" /></td>
    		<td>
				<input id="<s:property value="id"/>1" class="btn" type="button" onmouseover = "mouseover(id)" onmouseout = "mouseout(id)" value="修改" onclick="ConsigneeDetail('<s:property value="id"/>')"/>
				<input id="<s:property value="id"/>2" class="btn" type="button" onmouseover = "mouseover(id)" onmouseout = "mouseout(id)" value="删除" onclick="ConsigneeDelete('<s:property value="id"/>')"/>
			</td><td><s:fielderror><s:param>error</s:param></s:fielderror></td>
   		</tr>
    	</s:iterator>
    	<tr align="center">
    		<td colspan="5">
    			<input id="btn3" type="button" onmouseover = "mouseover('btn3')" onmouseout = "mouseout('btn3')" value="添加收货人" onclick="ConsigneeAdd()"/>
    		</td>
    	</tr>
   	</table>
   	<s:if test="num=='还没有收货人记录，赶紧新建一个吧！'">
   		&nbsp;<span><s:property value="num"/></span>
   	</s:if>
   	<s:else>
	   	<div id="div">
	   		[<a href="GetCustomerConsigneeDetailBycaccountAction?pageNo=1">首页</a>]
				<c:choose>
					<c:when test="${currentPage>1}">
						[<a href="GetCustomerConsigneeDetailBycaccountAction?pageNo=${currentPage-1}">上一页</a>]
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${currentPage<totalPage}">
						[<a href="GetCustomerConsigneeDetailBycaccountAction?pageNo=${currentPage+1}">下一页</a>]
					</c:when>
				</c:choose>
			[<a href="GetCustomerConsigneeDetailBycaccountAction?pageNo=${totalPage}">尾页</a>]
			
			<s:form method="post" theme="simple" action="GetCustomerConsigneeDetailBycaccountAction">
				跳转至第
				<s:textfield name="pageNo" size="1" theme="simple" onkeyup="value=value.replace(/[^\d]/g,'')"/>
				/<s:property value="totalPage"/>页
				<s:submit id="btn4" theme="simple" onmouseover = "mouseover('btn4')" onmouseout = "mouseout('btn4')" value="GO"/><span><s:property value="num"/></span>
			</s:form>
		</div>
	</s:else>
  </body>
</html>
