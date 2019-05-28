<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>My JSP 'showmessagedetail.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
  </head>
  
  <body>
    <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">留言详情</h2>
       <a href="showAllMessage.action" class="fr top_rt_btn">返回</a>
      </div>
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">标题：</span>
        <s:textfield name="m.title" class="textbox textbox_225"  />
       </li>
       <li>
        <span class="item_name" style="width:120px;">留言手机号：</span>
        <s:textfield name="m.phone" class="textbox textbox_225"  />
       </li>
       <li>
        <span class="item_name" style="width:120px;">内容：</span>
        <s:textarea name="m.message"  class="textbox textbox_295" />
       </li>
      </ul>
 </div>
</section>
  </body>
</html>
