<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Customerregister.jsp' starting page</title>
    <sx:head/>
    <link href="css/Customerregister.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
  </head>
  <body>
  	<div class="div">
	    <s:form method="post" action="RegisterAction">
		    <table cellspacing="15" class="table">
		    	<tr class="tr"><th colspan="3"><h2>新用户注册</h2></th></tr>
		    	<tr class="tr"><td>用户账号:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.caccount" theme="simple" placeholder="长度最少为6位"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.caccount</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>用户名:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.cname" theme="simple" placeholder="请填写你的用户名"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.cname</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>登录密码:</td><td><s:password maxlength="30" id="P1" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.password" theme="simple" placeholder="长度最少为6位"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.password</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>确认密码:</td><td><s:password maxlength="30" id="P2" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="password" theme="simple" placeholder="请确认你的密码"/></td><td class="sign">*</td><td><s:fielderror><s:param>password</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>性别:</td><td><s:radio name="customer.sex" list="%{#{'男':'男','女':'女'}}" theme="simple"/> </td><td class="sign"></td></tr>
		    	<tr class="tr"><td>邮箱:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.email" theme="simple" placeholder="请填写你的邮箱"/></td><td class="sign"></td><td><s:fielderror><s:param>customer.email</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>手机号:</td><td><s:textfield maxlength="13" onkeyup="this.value=this.value.replace(/\D/gi,'')" cssStyle="height:30px" size="35" name="customer.phone_num" theme="simple" placeholder="请填写你的手机号"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.phone_num</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>出生日期:</td><td><sx:datetimepicker name="customer.birthday" cssStyle="height:30px" displayFormat="yyyy-MM-dd"/></td><td class="sign"></td><td><s:fielderror><s:param>customer.birthday</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td>验证码:</td><td><s:textfield maxlength="4" cssStyle="height:30px" name="securityCode" size="15" theme="simple" placeholder="请填写验证码"/>
		    	<img src="SecurityCodeImageAction" width="105px" height="30px" onclick="javascript:this.src='SecurityCodeImageAction?timestamp='+new Date().getTime();"
				alt="换一张" style="vertical-align:top; padding:0 0 0 8px;cursor:hand;"/></td><td class="sign"></td><td><s:fielderror><s:param>securityCode</s:param></s:fielderror></td></tr>
		    	<tr class="tr"><td colspan="3"><s:submit theme="simple" value="立即注册" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
		    </table>
	    </s:form>
    </div>
  </body>
</html>
