<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%session.setAttribute("num", "3"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Myself_m3.jsp' starting page</title>
    <sx:head/>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
    <script type="text/javascript">
    	function exit(){
    		window.location.href="ExtiAction.action";
    	}
    </script>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>修改密码</b>
	<s:form method="post" action="ChangepasswordByMtself_m3">
		<s:hidden name="customer.caccount"/>
		<s:hidden name="customer.phone_num"/>
		<table>
			<tr class="tr"><td>&nbsp;旧密码:</td><td><s:password maxlength="30" id="P1" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="customer.password" theme="simple" placeholder="请输入你的旧密码"/></td><td class="sign">*</td><td><s:fielderror><s:param>customer.password</s:param></s:fielderror></td></tr>
			<tr class="tr"><td>&nbsp;新密码:</td><td><s:password maxlength="30" id="P1" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="password1" theme="simple" placeholder="长度最少为6位"/></td><td class="sign">*</td><td><s:fielderror><s:param>password1</s:param></s:fielderror></td></tr>
		    <tr class="tr"><td>&nbsp;确认密码:</td><td><s:password maxlength="30" id="P2" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="password2" theme="simple" placeholder="请确认你的新密码"/></td><td class="sign">*</td><td><s:fielderror><s:param>password2</s:param></s:fielderror></td></tr>
			<tr class="tr" id="btntr"><td colspan="3"><s:submit theme="simple" value="修改" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td><td></td></tr>
		</table>
	</s:form>
	<script type="text/javascript">
		<%String errornum=null;
		if(session.getAttribute("errornum")!=null){
			errornum=session.getAttribute("errornum").toString();
			if(errornum.equals("2")){
			%>
				alert("旧密码错误");
				alert("你已经修改密码失败了2次了,现在将强行退出你的账号");
				exit();
			<%
			}else{ %>
				alert("旧密码错误");
				alert("你已经修改密码失败了"+<%=errornum %>+"次了,失败2次将强行退出你的账号");
			<%
			}
		} %>
	</script>
  </body>
</html>
