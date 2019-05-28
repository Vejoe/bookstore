<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>My JSP 'showmanager.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="/bookstore/manager/css/style2.css">
	<script src="/bookstore/manager/js/jquery.js"></script>
<script src="/bookstore/manager/js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">顾客列表</h2>
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
               <th>操作</th>
			</tr>
			<s:iterator value="Customers" status="stat" var="customer">
				<tr>
				   <td class="center"><s:property value="#customer.id"/></td>
                   <td class="center"><s:property value="#customer.Caccount"/></td>
                   <td class="center"><s:property value="#customer.Cname"/></td>
                   <td class="center"><s:property value="#customer.password"/></td>
                   <td class="center"><s:property value="#customer.sex"/></td>
                   <td class="center"><s:property value="#customer.email"/></td>
                   <td class="center"><s:property value="#customer.phone_num"/></td>
                   <td class="center"><s:property value="#customer.birthday"/></td>
                   <td class="center"><s:property value="#customer.pay_sum"/></td>
                   <td class="center"><s:property value="#customer.rank"/></td>
					<td class="center">
					<a href="javascript:location.href='queryCustomerByIDAction?id=${customer.id}'"
						title="修改" class="link_icon">&#101;</a></td>
				</tr>
			</s:iterator>
		</table>
		<aside class="paging"> <a href="queryCustomerAction?pageNo=1">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
				<a href="queryCustomerAction?pageNo=${currentPage-1}">上一页</a>
			</c:when>
		</c:choose> <c:choose>
			<c:when test="${currentPage<totalPage}">
				<a href="queryCustomerAction?pageNo=${currentPage+1}">下一页</a>
			</c:when>
		</c:choose> <a href="queryCustomerAction?pageNo=${totalPage}">尾页</a>
		[${currentPage}/${totalPage}] </aside>
	</div>
	</section>
</body>
</html>
