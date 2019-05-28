<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>My JSP 'left.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>

<body>
	<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="right.jsp" target="mainframe">起始页</a></h2>
 <ul>
 <%if(session.getAttribute("adimflag").toString().equals("1")){ %>
  <li>
   <dl>
    <dt>图书管理</dt>
    <dd><a href="queryBookAction"  target="mainframe">图书列表</a></dd>
    <dd><a href="queryBookTypeAction" target="mainframe">增加图书</a></dd>
    <dd><a href="addbooktype.jsp" target="mainframe">增加图书类别</a></dd>
   </dl>
  </li>
  <%} %>
  <li>
   <dl>
    <dt>订单管理</dt>
    <dd><a href="showAllOrder.action" target="mainframe">订单列表</a></dd>
   </dl>
  </li>
  <%if(session.getAttribute("adimflag").toString().equals("1")){ %>
  <li>
   <dl>
    <dt>管理员管理</dt>
    <dd><a href="showAllManager.action" target="mainframe">管理员列表</a></dd>
    <dd><a href="addmanager.jsp" target="mainframe">添加管理员</a></dd>
   </dl>
  </li>
    <li>
   <dl>
    <dt>顾客管理</dt>
    <dd><a href="queryCustomerAction" target="mainframe">顾客列表示例</a></dd>
   </dl>
  </li>
  <li>
  <%} %>
   <dl>
    <dt>留言管理</dt>
    <dd><a href="showAllMessage.action" target="mainframe">留言列表</a></dd>
   </dl>
   <dl>
    <dt>个人信息</dt>
    <dd><a href="changepassword.jsp" target="mainframe">修改密码</a></dd>
    <dd><a href="ManagerPersonInform" target="mainframe">个人信息修改</a></dd>
   </dl>
  </li>
 </ul>
</aside>
</body>
</html>