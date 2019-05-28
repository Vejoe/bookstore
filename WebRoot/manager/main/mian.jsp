<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<title>后台中心</title>
    </head>
    <frameset rows="8%,*" frameborder="NO" border="0" framespacing="0">
    <frame src="/bookstore/manager/main/top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0"/>
    <frameset  cols="210,*" id="frame">
    <frame src="/bookstore/manager/main/left.jsp" scrolling="yes" noresize="noresize" frameborder="NO" marginwidth="0" marginheight="0"/>
    <frame src="/bookstore/manager/main/right.jsp" id="mainframe" name="mainframe"  scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" />
    </frameset>
        <noframes>
  <body></body>
    </noframes>
    </frameset>

</html>
