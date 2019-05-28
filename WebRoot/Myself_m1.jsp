<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%session.setAttribute("num", "1"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Myself_m1.jsp' starting page</title>
    <style type="text/css">
    	*{
    		font-size:15px;
    	}
    </style>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>我的信息</b>
    <table>
    	<tr><td>&nbsp;总消费金额:</td><td><s:property value="customer.getPay_sum()"/></td></tr>
    	<tr><td>&nbsp;用户等级:</td><td><s:property value="customer.getRank()"/></td></tr>
    </table>
  </body>
</html>
