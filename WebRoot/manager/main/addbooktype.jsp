<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css" />
<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/verificationNumbers.js"></script>
<script src="/bookstore/manager/js/Particleground.js"></script>
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">
	<form action="addBookTypeAction" method="post">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">增加图书类别</h2>
			</div>
			<ul class="ulColumn2">
				<li><span class="item_name" style="width:120px;">图书类别：</span> <input
					type="text" class="textbox textbox_225" name="booktype.type"
					placeholder="输入图书类别..."/>
				</li>
				<li><span class="item_name" style="width:120px;"></span> <input
					type="submit" class="link_btn" value="添加" /></li>
			</ul>
			<s:fielderror fieldName="booktype.type" cssStyle="color:red;"/>
		</div>
	</form>
	</section>
</body>
</html>
