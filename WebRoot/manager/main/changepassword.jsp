<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My JSP 'changepassword.jsp' starting page</title>

<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
<script type="text/javascript">
function check(){
	document.getElementById("pwderror").style.display="none";
	var a=document.getElementById("newpwd").value;
	var b=document.getElementById("repwd").value;
	if(a==b){
		return true;
	}
	else{
		document.getElementById("pwderror").style.display="inline-block";
		return false;
	}
}
</script>
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">

	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">修改密码</h2>
		</div>
		<form action="ChangePassWord" method="post" onsubmit="return check()">
			<ul class="ulColumn2">
				<li><span class="item_name" style="width:120px;">请输入原密码：</span>
					<input type="password" class="textbox textbox_225" name="oldpwd"
					required/> 
				</li>
				<li><span class="item_name" style="width:120px;">新密码：</span> <input
					type="password" class="textbox textbox_225" name="newpwd" required
					 id="newpwd" />
				<li><span class="item_name" style="width:120px;">再次输入新密码：</span> <input
					type="password" class="textbox textbox_225" required
					 id="repwd" /> <span class="errorTips"
					id="pwderror">两次输入密码不一致</span></li>

				<li><span class="item_name" style="width:120px;"></span> <input
					type="submit" class="link_btn" value="修改" /></li>
			</ul>
		</form>
		<s:fielderror fieldName="updatepasswordfailed" cssStyle="color:red;" />
	</div>
	</form>

	</section>
</body>
</html>
