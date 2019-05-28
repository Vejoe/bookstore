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
<script type="text/javascript">
	function deletebook(id) {
		if (confirm("你确定删除该图书吗?")) {
			location.href = "deleteBookAction?id=" + id;
		}
	}

</script>
</head>

<body>
	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">图书列表</h2>
			<a href="queryBookTypeAction" class="fr top_rt_btn add_icon"
				target="mainframe">添加图书</a>
		</div>
		<table class="table">
			<tr>
				<th>书籍图片</th>
				<th>图书ID</th>
				<th>图书类别</th>
				<th>图书名</th>
				<th>出版社</th>
				<th>出版日期</th>
				<th>作者</th>
				<th>原价</th>
				<th>库存</th>
				<th>会员价</th>
				<th>成交量</th>
				<th>浏览次数</th>
			</tr>
			<s:iterator value="books" status="stat" var="book">
				<tr>
					<td class="center"><img
						src="../../BookImg/<s:property value="#book.bookfilename"/>" /></td>
					<td class="center"><s:property value="#book.id" /></td>
					<td class="center"><s:property value="#book.booktype.type" /></td>
					<td class="center"><s:property value="#book.bookname" /></td>
					<td class="center"><s:property value="#book.publisher" /></td>
					<td class="center"><s:property value="#book.publisher_year" /></td>
					<td class="center"><s:property value="#book.author" /></td>
					<td class="center"><s:property value="#book.price" /></td>
					<td class="center"><s:property value="#book.stocks" /></td>
					<td class="center"><s:property value="#book.rank_price" /></td>
					<td class="center"><s:property value="#book.bookDealmount" /></td>
					<td class="center"><s:property value="#book.bookLookmount" /></td>
					<td class="center"><a
						href="javascript:location.href='queryBookByIDAction?id=${book.id}'"
						title="修改" class="link_icon">&#101;</a> <a
						href="javascript:deletebook('<s:property value="id"/>')"
						title="删除" class="link_icon">&#100;</a></td>
				</tr>
			</s:iterator>
		</table>
		<aside class="paging"> <a href="queryBookAction?pageNo=1">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
				<a href="queryBookAction?pageNo=${currentPage-1}">上一页</a>
			</c:when>
		</c:choose> <c:choose>
			<c:when test="${currentPage<totalPage}">
				<a href="queryBookAction?pageNo=${currentPage+1}">下一页</a>
			</c:when>
		</c:choose> <a href="queryBookAction?pageNo=${totalPage}">尾页</a>
		[${currentPage}/${totalPage}] </aside>
	</div>
	</section>
</body>
</html>
