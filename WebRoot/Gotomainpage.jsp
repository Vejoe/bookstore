<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Gotomainpage.jsp' starting page</title>
	<style type="text/css">
		a{
    		text-decoration:none;
    		font-size:15px;
    	}
    	a:hover{
    		color:#ca0c16;
    	}
		.table{
    		width:100%;
    	}
    	.texttr{
    		height:40px;
    		font-size:30px;
    		font-family:华文彩云;
    		text-align:center;
    	}
    	.tr{
    		height:40px;
    		text-align:center;
    	}
    	#btn{
    		 background:#ff2832;
    		 color:white;
    		 border:hidden;
    		 border-radius:10px;
    		 font-size:40px;
    		 width:100%;
    		 height:60px;
    		 cursor:pointer;
    		 font-family:华文细黑;
    	}
	</style><script type="text/javascript" src="js/mouseoverAndmouseout.js">
  	</script>
	<script type="text/javascript">
    	function goiframeclose(){
    		var Body=this.parent.window.document.body;
    		var temp=parent.window.document.getElementById("temp");
    		var goiframe=parent.window.document.getElementById("goiframe");
    		Body.removeChild(temp);
    		Body.removeChild(goiframe);
		}
    </script>
  </head>
  
  <body>
    <s:form method="post" action="mainpageAction">
	    <table cellspacing="15" class="table">
	    	<tr align="right"><td><a href="javascript:void(0);" onclick="goiframeclose()" >关闭</a></td></tr>
	    	<tr class="texttr"><td>恭喜你注册成功!</td></tr>
	    	<tr class="tr"><td><s:submit theme="simple" value="前往首页" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
	    </table>
    </s:form>
  </body>
</html>
