<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%if(session.getAttribute("CHECK")==null){response.sendRedirect("mainpage.jsp");} %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  	<sx:head/>
    <title>My JSP 'Customerregister_success.jsp' starting page</title>
    <link href="css/Customerchangepassword.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
  </head>
  <body>
    <div class="div">
    	<br><font size="+1"><b>&nbsp;&nbsp;&nbsp;&nbsp;找回密码</b></font>
    	<hr align="center" width="98%" color="#eceef2"><br>
	    <s:form method="post" action="ChangepassowrdAction">
		    <table cellspacing="15" class="table">
		    	<tr id="nowtr"><td class="td">1.填写账号</td><td class="td">2.身份验证</td><td class="td" id="now">3.设置密码</td><td class="td">4.修改成功</td><td>&nbsp;</td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    	<tr class="tr"><td id="texttd">新密码:</td><td colspan="3"><s:password maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="newpassword" theme="simple" placeholder="请输入你的新密码"/></td><td><s:fielderror><s:param>newpassword</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td id="texttd">确认密码:</td><td colspan="3"><s:password maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="newpassword2" theme="simple" placeholder="请确认你的新密码"/></td><td><s:fielderror><s:param>newpassword2</s:param></s:fielderror></td></tr>
		    	<tr class="tr" id="btntr"><td colspan="3"><s:submit theme="simple" value="下一步" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>
