<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  	<sx:head/>
    <title>My JSP 'Customerregister_success.jsp' starting page</title>
    <link href="css/Customerchangepassword.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
  </head>
  <body>
    <div class="div">
    	<br><font size="+1"><b>&nbsp;&nbsp;&nbsp;&nbsp;找回密码</b></font>
    	<hr align="center" width="98%" color="#eceef2"><br>
	    <s:form method="post" action="CheckCustomercaccountByphone_numAction">
		    <table cellspacing="15" class="table">
		    	<tr id="nowtr"><td class="td">1.填写账号</td><td class="td" id="now">2.身份验证</td><td class="td">3.设置密码</td><td class="td">4.修改成功</td></tr>
		    </table>
		    <table cellspacing="15" class="table">
		    	<tr><td>&nbsp;</td></tr>
		    	<tr class="tr"><td id="texttd">手机号:</td><td colspan="3"><s:textfield id="phone" maxlength="13" onkeyup="this.value=this.value.replace(/\D/gi,'')" readonly="true" cssStyle="height:30px;background:rgb(235,235,228)" size="30" name="phone_num" theme="simple" placeholder="请输入你的手机号" /></td><td>&nbsp;</td></tr>
		    	<tr class="tr"><td>&nbsp;</td>
		    		<td><s:textfield maxlength="6" cssStyle="height:30px" size="10" name="securityCode" theme="simple" placeholder="验证码"/><input type="button" id="bt01" onclick="GetSecurityCode(id)" value="发送验证码" /> </td><td><s:fielderror><s:param>securityCode</s:param></s:fielderror></td>
		    	</tr>
		    	<tr class="tr" id="btntr"><td colspan="2"><s:submit theme="simple" value="下一步" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>