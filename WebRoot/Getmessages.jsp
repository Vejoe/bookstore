<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'GetMessages.jsp' starting page</title>
    <link href="css/GetconsigneesOrGetmessages.css" rel="stylesheet" type="text/css"/>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"> </script>
    <script type="text/javascript" src="js/MessageDetail.js"> </script>
    <script type="text/javascript">
    	function returntoMyself_m7(num){
			location.href="GetCustomerDetailBycaccountAction.action?num="+num;
		}
    </script>
  </head>
  <body>
	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>我的留言</b>
	<table cellspacing="10" id="table" width="600">
    	<s:iterator value="messages" status="stat" var="message">
    	<tr align="left">
    		<th>&nbsp;留言标题:<span class="span"><s:property value="#message.getTitle()" /></span></th>
   		</tr>
   		<tr align="left">
    		<th>&nbsp;你的留言:<span class="span"><s:property value="#message.getMessage()" /></span></th><th></th>
   		</tr>
   		<tr align="left"><td>&nbsp;<input id="<s:property value="id"/>1" class="btn" type="button" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" value="查看" onclick="MessageDetail('<s:property value="id"/>')" style="width:10%" /></td></tr>
    	</s:iterator>
   	</table>
   	 
   	<s:if test="num=='您没有留言记录！'">
   		&nbsp;<span><s:property value="num"/></span>
   		<input type="button" value="返回" id="Rbtn" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" onclick="returntoMyself_m7(7)" />
   	</s:if>
   	<s:else>
	   	<div id="div">
	   		[<a href="GetMessageAction?pageNo=1">首页</a>]
				<c:choose>
					<c:when test="${currentPage>1}">
						[<a href="GetMessageAction?pageNo=${currentPage-1}">上一页</a>]
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${currentPage<totalPage}">
						[<a href="GetMessageAction?pageNo=${currentPage+1}">下一页</a>]
					</c:when>
				</c:choose>
			[<a href="GetMessageAction?pageNo=${totalPage}">尾页</a>]
			<s:form method="post" theme="simple" action="GetMessageAction">
				跳转至第
				<s:textfield name="pageNo" size="1" theme="simple" onkeyup="value=value.replace(/[^\d]/g,'')"/>
				/<s:property value="totalPage"/>页
				<s:submit id="btn4" theme="simple" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" value="GO"/><span>
				<s:property value="num"/></span>
				<input type="button" value="返回" id="Rbtn" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" onclick="returntoMyself_m7(7)" />
			</s:form>
		</div>
	</s:else>
  </body>
</html>
