<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>My JSP 'managerdetail.jsp' starting page</title>
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
				<h2 class="fl">修改信息</h2>
			</div>
			<form action="updateManager" method="post">
			<ul class="ulColumn2">
				<s:hidden name="manager.id"/>
				<li><span class="item_name" style="width:120px;">账号：</span> <s:textfield
					class="textbox textbox_225" name="manager.adminaccount"
					placeholder="管理员账号..." id="adminaccount"/>
					 <span class="errorTips" id="adminaccounterror">用户名不能为空</span>
				</li>
				<li><span class="item_name" style="width:120px;">姓名：</span> <s:textfield
					 class="textbox textbox_225" name="manager.adminname"
					placeholder="管理员姓名..." id="adminname"/> 
					<span class="errorTips" id="adminnameerror">姓名不能为空</span>
				</li>
				<s:hidden name="manager.adminpwd"/>
				<li><span class="item_name" style="width:120px;">会员等级：</span> <s:select
					class="select" name="degree" list="{'低级','高级'}"/>
				</li>
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
