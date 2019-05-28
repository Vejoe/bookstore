<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>My JSP 'addbook.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="/bookstore/manager/css/style2.css">
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">修改的用户ID：${session.Cid}</h2>
		</div>
		<table class="table">
			<tr>
				<th>用户ID</th>
				<th>用户账号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>性别</th>
				<th>邮箱</th>
				<th>手机号</th>
				<th>生日</th>
				<th>累计消费金额</th>
				<th>用户等级</th>
			</tr>
			<s:iterator value="Customers" status="stat" var="customer">
				<tr>
					<td class="center"><s:property value="#customer.id"/></td>
                   <td class="center"><s:property value="#customer.caccount"/></td>
                   <td class="center"><s:property value="#customer.cname"/></td>
                   <td class="center"><s:property value="#customer.password"/></td>
                   <td class="center"><s:property value="#customer.sex"/></td>
                   <td class="center"><s:property value="#customer.email"/></td>
                   <td class="center"><s:property value="#customer.phone_num"/></td>
                   <td class="center"><s:property value="#customer.birthday"/></td>
                   <td class="center"><s:property value="#customer.pay_sum"/></td>
                   <td class="center"><s:property value="#customer.rank"/></td>
				</tr>
			</s:iterator>
		</table>

		<ul class="ulColumn2">
			<s:form method="post" action="changeCINFAction">
       <s:textfield name="customer.cname" label="用户名"/>
       <s:textfield name="customer.password" label="密码"/>
       <s:textfield name="customer.sex" label="性别"/>
       <s:textfield name="customer.email" label="邮箱"/>
       <s:textfield name="customer.phone_num" label="手机号"/>
       <s:textfield name="customer.birthday" label="生日"/>
   <s:submit value="提交"/>
   </s:form>
		</ul>
	</div>
	</section>
</body>
</html>
