<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>My JSP 'top.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style.css">
</head>

<body>
	<header>
	<h1>
		<img src="/bookstore/manager/images/admin_logo.png" />
	</h1>
	<ul class="rt_nav">
		<li><a href="right.jsp" target="mainframe"
			class="website_icon">站点首页</a></li>
		<li><a href="#" class="admin_icon"><s:property value="#session.manager.adminname"/></a></li>
		<li><a href="ManagerExitAction.action" target="_parent" class="quit_icon">安全退出</a></li>
	</ul>
	</header>
</body>
</html>
