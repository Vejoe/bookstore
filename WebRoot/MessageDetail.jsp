<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'MessageDetail.jsp' starting page</title>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
    <script type="text/javascript">
    	function Closethis(){
    		var Body=this.parent.window.document.body;
    		var temp=parent.window.document.getElementById("Messagetemp");
    		var Messageiframe=parent.window.document.getElementById("Messageiframe");
    		Body.removeChild(temp);
    		Body.removeChild(Messageiframe);
    	}
    </script>
  </head>
  <body>
    <table>
    	<tr class="tr">
			<td>
				<s:property value="error"/>
			</td>
		</tr>
		<tr class="tr">
		    <td><s:textfield disabled="true" cssStyle="height:30px" size="36" name="message.title" theme="simple"/></td>
	    </tr>
   		<tr class="tr">
		    <td><s:textarea disabled="true" rows="17" cols="35" name="message.message" theme="simple"/></td>
	    </tr>
	    <tr class="tr" id="querytr">
			<td>
				<input value="关闭" id="Qbtn" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" onclick="Closethis()" />
			</td>
		</tr>
	</table>
  </body>
</html>
