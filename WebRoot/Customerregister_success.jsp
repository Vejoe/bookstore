<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'Customerregister_success.jsp' starting page</title>
    <link href="css/Customerregister_success.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
  		#top{
  		width:100%;
  		height:40px;
  		background-color:#f5f5f5;
  		box-shadow:0px 3px 10px #3f3f3f;
  		}
  	</style>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
    <script type="text/javascript" src="js/ShowGo.js"></script>
  </head>
  <body>
  	<div id="top">
    	<marquee onmouseover="stop()"onmouseout="start()">
    		<span style="font-weight: bolder;font-size: 30px;color: red;"><%=session.getAttribute("cname") %></span>
    		<span style="font-weight: bolder;font-size: 30px;color: blue">同学,恭喜你成为本店的会员,赶紧前往书店购书吧！
    	</marquee>
    </div>
    <div class="div">
	    <s:form method="post" action="mainpageAction">
		    <table cellspacing="15" class="table">
		    	<tr class="texttr"><td>恭喜你注册成功!</td></tr>
		    	<tr class="texttr"><td id="texttd">你的账号为：<font color="red"><s:property value="customer.getCaccount()"/></font></td></tr>
		    	<tr class="texttr"><td>赶紧前往书店吧!</td></tr>
		    	<tr class="tr"><td><s:submit theme="simple" value="前往首页" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>
