<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'test.jsp' starting page</title>
  	<script type="text/javascript">
  		function check(){
  			if(<%=session.getAttribute("caccount")%>==null){
  				parent.loginshow();
  				return false;
  			}
  		}
  	</script>
  </head>
  
  <body>
    <s:form method="post" action="Customerregister_success.jsp" onsubmit="return check()">
    	<s:submit id="submit" value="购买"></s:submit>
    </s:form>
  </body>
</html>
