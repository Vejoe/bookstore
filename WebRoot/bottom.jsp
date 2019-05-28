<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bottom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bottom.css">

  </head>
  
  <body>
        	<div id="end-bottom">
    		<hr size="2" width="100%"/>
    		<div id="bottom-content">
    		<h5>15软件工程三班-韦志浩-陈作鑫-卢粤涛-李育聪-陈彦钊</h5>
    			<h5>第二组实践作业：图书售卖系统设计与实现</h5>
    			<h5>时间：2018-6-25</h5>
    		</div>
	  	</div>
  </body>
</html>
