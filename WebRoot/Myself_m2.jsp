<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%session.setAttribute("num", "2"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Myself_m2.jsp' starting page</title>
    <sx:head/>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>基础资料</b>
	<s:form method="post" action="ChangeCustomerDetailAction">
		<s:hidden name="customer.caccount"/>
		<table>
			<tr class="tr"><td>&nbsp;用户名:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.cname" theme="simple" placeholder="请填写你的用户名"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.cname</s:param></s:fielderror></td></tr>
			<tr class="tr"><td>&nbsp;性别:</td><td><s:radio name="customer.sex" list="%{#{'男':'男','女':'女'}}" theme="simple"/> </td><td class="sign"></td></tr>
			<tr class="tr"><td>&nbsp;邮箱:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.email" theme="simple" placeholder="请填写你的邮箱"/></td><td class="sign"></td><td><s:fielderror><s:param>customer.email</s:param></s:fielderror></td></tr>
			<tr class="tr"><td>&nbsp;手机号:</td><td><s:textfield maxlength="13" onkeyup="this.value=this.value.replace(/\D/gi,'')" cssStyle="height:30px" size="35" name="customer.phone_num" theme="simple" placeholder="请填写你的手机号"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.phone_num</s:param></s:fielderror></td></tr>
			<tr class="tr"><td>&nbsp;出生日期:</td><td><sx:datetimepicker name="customer.birthday" cssStyle="height:30px" displayFormat="yyyy-MM-dd"/></td><td class="sign"></td><td><s:fielderror><s:param>customer.birthday</s:param></s:fielderror></td></tr>
			<tr class="tr" id="btntr"><td colspan="3"><s:submit theme="simple" value="保存" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td><td></td></tr>
		</table>
	</s:form>
  </body>
</html>
