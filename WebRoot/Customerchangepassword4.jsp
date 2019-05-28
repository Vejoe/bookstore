<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  	<sx:head/>
    <title>My JSP 'Customerregister_success.jsp' starting page</title>
    <style type="text/css">
    	#tr{
    		height:95px;
    		font-size:50px;
    		font-weight:bloder;
    		text-align:center;
    	}
    </style>
    <link href="css/Customerchangepassword.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
  </head>
  <body>
    <div class="div">
    	<br><font size="+1"><b>&nbsp;&nbsp;&nbsp;&nbsp;找回密码</b></font>
    	<hr align="center" width="98%" color="#eceef2"><br>
	    <s:form method="post" action="index.jsp">
		    <table cellspacing="15" class="table">
		    	<tr id="nowtr"><td class="td">1.填写账号</td><td class="td">2.身份验证</td><td class="td">3.设置密码</td><td class="td" id="now">4.修改成功</td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    	<tr id="tr"><td colspan="4">修改成功</td></tr>
		    	<tr class="tr" id="btntr"><td colspan="4"><s:submit theme="simple" value="前往首页" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>
