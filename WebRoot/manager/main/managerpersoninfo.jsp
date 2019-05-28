<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>My JSP 'personinfo.jsp' starting page</title>
    <meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css" />
<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/verificationNumbers.js"></script>
<script src="/bookstore/manager/js/Particleground.js"></script>

  </head>
  
  <body>
  <section class="rt_wrap content mCustomScrollbar">
	
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">个人信息</h2>
			</div>
			<form action="updateManagerPersonal" method="post">
			<ul class="ulColumn2">
				<s:hidden name="manager.id"/>
				<s:hidden name="manager.adminaccount"/>
				<li><span class="item_name" style="width:120px;">姓名：</span> <s:textfield
					 class="textbox textbox_225" name="manager.adminname"
					placeholder="管理员姓名..." id="adminname"/> 
					<span class="errorTips" id="adminnameerror">姓名不能为空</span>
				</li>
				<s:hidden name="manager.adminpwd"/>
				<s:hidden name="manager.adminflag"/>
				<li><span class="item_name" style="width:120px;">手机号码：</span> <s:textfield
					 class="textbox textbox_225" name="manager.phone"
					placeholder="手机号码..." id="phone"/> 
					<span class="errorTips" id="phoneerror">手机不能为空</span></li>
				<li><span class="item_name" style="width:120px;"></span> <input
					type="submit" class="link_btn" value="修改" /></li>
			</ul>
			</form>
			<s:fielderror fieldName="createfailed" cssStyle="color:red;"/>
		</div>
	</form>
	
	</section>
  </body>
</html>
