<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%session.setAttribute("num", "7"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Anonymous_message.jsp' starting page</title>
    <sx:head/>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
    <script type="text/javascript">
    	function Alert(){
    		if(confirm("你确定提交吗?"))
    			this.submit();
    		else
    			return false;
    	}
    </script>
  </head>
  <body>
    <b>留言建议</b>
    <s:form method="post" action="AddMessageActionByAnonymous" onsubmit="return Alert()">
    	<input type="hidden" name="who" value="Anonymous" />
    	<input type="hidden" name="url" id="url">
		<table>
			<tr class="tr">
			    <td>&nbsp;你的手机号:</td>
			    <td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\D/gi,'')" cssStyle="height:30px" size="35" name="message.phone" theme="simple" placeholder="请输入你的手机号"/></td>
			    <td class="sign">*</td>
			    <td><s:fielderror><s:param>message.phone</s:param></s:fielderror></td>
		    </tr>
			<tr class="tr">
			    <td>&nbsp;留言标题:</td>
			    <td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="message.title" theme="simple" placeholder="请输入标题"/></td>
			    <td class="sign">*</td>
			    <td><s:fielderror><s:param>message.title</s:param></s:fielderror></td>
		    </tr>
    		<tr class="tr">
			    <td>&nbsp;你的留言:</td>
			    <td><textarea rows="8" cols="34" onkeyup="this.value=this.value.replace(/\s+/g,'')" name="message.message" maxlength="500" placeholder="请写下你的留言"></textarea></td>
			    <td class="sign">*</td>
			    <td><s:fielderror><s:param>message.message</s:param></s:fielderror></td>
		    </tr>
		    <tr class="tr" id="btntr">
				<td colspan="3">
					<s:submit theme="simple" value="提交" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/>
				</td>
				<td></td>
			</tr>
		</table>
		<script type="text/javascript">
	  		var url=localStorage.getItem("0");
	  		document.getElementById("url").value=url;
  		</script>
	</s:form>
  </body>
</html>
