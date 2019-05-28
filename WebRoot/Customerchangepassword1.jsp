<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
  	<sx:head/>
    <title>My JSP 'Customerchangepassword1.jsp' starting page</title>
    <link href="css/Customerchangepassword.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
  </head>
  <body>
    <div class="div">
    	<br><font size="+1"><b>&nbsp;&nbsp;&nbsp;&nbsp;找回密码</b></font>
    	<hr align="center" width="98%" color="#eceef2"><br>
	    <s:form method="post" action="QueryCustomerBycaccountAction">
		    <table cellspacing="15" class="table">
		    	<tr id="nowtr"><td class="td" id="now">1.填写账号</td><td class="td">2.身份验证</td><td class="td">3.设置密码</td><td class="td">4.修改成功</td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    	<tr class="tr"><td id="texttd">你的账号:</td><td colspan="3"><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="caccount" theme="simple" placeholder="请输入你的账号"/></td><td><s:fielderror><s:param>caccount</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>验证码:</td><td colspan="3"><s:textfield maxlength="4" cssStyle="height:30px" name="securityCode" size="15" theme="simple" placeholder="请填写验证码"/>
		    	<img src="SecurityCodeImageAction" width="105px" height="30px" onclick="javascript:this.src='SecurityCodeImageAction?timestamp='+new Date().getTime();"
				alt="换一张" style="vertical-align:top; padding:0 0 0 8px;cursor:hand;"/></td><td><s:fielderror><s:param>securityCode</s:param></s:fielderror></td></tr>
		    	<tr class="tr" id="btntr"><td colspan="3"><s:submit theme="simple" value="下一步" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    	<tr><td>&nbsp;</td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>
