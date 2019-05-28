<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
  <head>
    <title>My JSP 'Login.jsp' starting page</title>
    <sx:head/>
    <style type="text/css">
    	*{
    		font-family:华文细黑;
    		padding:0;
    		margin:0;
    	}
    	a{
    		text-decoration:none;
    		font-size:15px;
    	}
    	a:hover{
    		color:#ca0c16;
    	}
    	.table{
    		margin-left:9%;
    		margin-top:5%;
    	}
    	.errorMessage{
			list-style-type: none;
		}
    	.tr{
    		font-size:14px;
    		height:35px;
    		text-align:center;
    	}
    	.td{
    		text-align:right;
    		font-size:15px;
    		height:40px;
    	}
    	#btn{
			background:#ff2832;
			color:white;
			border:hidden;
			border-radius:10px;
			font-size:20px;
			width:100%;
			height:50px;
			cursor:pointer;
    	}
    </style>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
    <script type="text/javascript">
    	function Closethis(){
    		var Body=this.parent.window.document.body;
    		var temp=parent.window.document.getElementById("temp");
    		var Loginiframe=parent.window.document.getElementById("Loginiframe");
    		Body.removeChild(temp);
    		Body.removeChild(Loginiframe);
    		localStorage.setItem("0", null);
    	}
    </script>
  </head>
  
  <body>
  	<s:form method="post" action="LoginAction">
  		<input type="hidden" name="url" id="url">
	    <table class="table" cellspacing="0">
	    	<tr><td align="right" colspan="2"><a href="javascript:void(0);" onclick="Closethis()" >关闭</a></td></tr>
	    	<tr><th colspan="2"><h2>登录</h2></th></tr>
	    	<tr><td>&nbsp;</td></tr>
	    	<tr><td>用户账号:</td><td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="30" name="customer.caccount" theme="simple" placeholder="请填写你的账号"/></td></tr>
	    	<tr class="tr"><td colspan="2"><s:fielderror><s:param>customer.caccount</s:param></s:fielderror></td></tr>
	    	<tr><td>登录密码:</td><td><s:password maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="30" name="customer.password" theme="simple" placeholder="请填写你的密码"/></td></tr>
	    	<tr class="tr"><td colspan="2"><s:fielderror><s:param>customer.password</s:param></s:fielderror></td></tr>
	    	<tr><td>验证码:</td><td><s:textfield maxlength="4" cssStyle="height:30px" name="securityCode" size="12" theme="simple" placeholder="请填写验证码"/>
	    	<img src="SecurityCodeImageAction" width="95px" height="30px" onclick="javascript:this.src='SecurityCodeImageAction?timestamp='+new Date().getTime();"
				alt="换一张" style="vertical-align:top; padding:0 0 0 8px;cursor:hand;"/></td></tr>
	    	<tr class="tr"><td colspan="2"><s:fielderror><s:param>securityCode</s:param></s:fielderror></td></tr>
	    	<tr><td colspan="2" class="td" align="right"><a href="Customerchangepassword1.jsp" target="_all">忘记密码</a></td></tr>
	    	<tr><td colspan="2"><s:submit theme="simple" value="登录" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/></td></tr>
	    	<tr><td colspan="2" class="td" align="right"><a href="Customerregister.jsp" target="_all">前往注册</a></td></tr>
	    </table>
	    <script type="text/javascript">
	  		var url=localStorage.getItem("0");
	  		document.getElementById("url").value=url;
  		</script>
    </s:form>
  </body>
</html>
