<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/verificationNumbers.js"></script>
<script src="/bookstore/manager/js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
});
function check(){
	if(document.getElementById("adminaccount").value==""){
		document.getElementById("adminaccount").setAttribute("placeholder","用户名不能为空");
		return false;
	}else if(document.getElementById("adminpwd").value==""){
		document.getElementById("adminpwd").setAttribute("placeholder","密码不能为空");
		return false;
	}else if(validate()==false){
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<form action="managerloginAction" method="post" onsubmit="return check()">
<dl class="admin_login">
 <dt>
  <strong>站点后台管理系统</strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" id="adminaccount" name="manager.adminaccount"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" id="adminpwd" name="manager.adminpwd"/>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd>
 <dd>
  <input type="submit" value="立即登录" class="submit_btn"/>
 </dd>
 <dd>
<s:fielderror fieldName="loginfailed" cssStyle="color:red;"/>
 </dd>
</dl>
</form>
</body>
</html>
