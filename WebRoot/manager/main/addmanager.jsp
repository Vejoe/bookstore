<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css" />
<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/verificationNumbers.js"></script>
<script src="/bookstore/manager/js/Particleground.js"></script>
<script>
function check(){
	document.getElementById("adminaccounterror").style.display="none";
	document.getElementById("adminnameerror").style.display="none";
	document.getElementById("adminpwderror").style.display="none";
	document.getElementById("phoneerror").style.display="none";
	var c=true;
	if(document.getElementById("adminaccount").value==""){
		document.getElementById("adminaccounterror").style.display="inline-block";
		c=false;
	}
	if(document.getElementById("adminname").value==""){
		document.getElementById("adminnameerror").style.display="inline-block";
		c=false;
	}
	if(document.getElementById("adminpwd").value==""){
		document.getElementById("adminpwderror").style.display="inline-block";
		c=false;
	}
	if(document.getElementById("phone").value==""){
		document.getElementById("phoneerror").style.display="inline-block";
		c=false;
	}
	return c;
}
</script>
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">
	<form action="addManager" method="post" onsubmit="return check()">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">管理员信息</h2>
			</div>
			<ul class="ulColumn2">
				<li><span class="item_name" style="width:120px;">账号：</span> <input
					type="text" class="textbox textbox_225" name="manager.adminaccount"
					placeholder="管理员账号..." id="adminaccount"/>
					 <span class="errorTips" id="adminaccounterror">用户名不能为空</span>
				</li>
				<li><span class="item_name" style="width:120px;">姓名：</span> <input
					type="text" class="textbox textbox_225" name="manager.adminname"
					placeholder="管理员姓名..." id="adminname"/> 
					<span class="errorTips" id="adminnameerror">姓名不能为空</span>
				</li>
				<li><span class="item_name" style="width:120px;">登陆密码：</span> <input
					type="password" class="textbox textbox_225" name="manager.adminpwd"
					placeholder="管理员密码..." id="adminpwd"/> 
					<span class="errorTips" id="adminpwderror">密码不能为空</span>
				</li>
				<li><span class="item_name" style="width:120px;">会员等级：</span> <select
					class="select" name="degree">
						<option>低级</option>
						<option>高级</option>
				</select></li>
				<li><span class="item_name" style="width:120px;">手机号码：</span> <input
					type="tel" class="textbox textbox_225" name="manager.phone"
					placeholder="手机号码..." id="phone"/> 
					<span class="errorTips" id="phoneerror">手机不能为空</span></li>
				<li><span class="item_name" style="width:120px;"></span> <input
					type="submit" class="link_btn" value="添加" /></li>
			</ul>
			<s:fielderror fieldName="createfailed" cssStyle="color:red;"/>
		</div>
	</form>
	</section>
</body>
</html>
