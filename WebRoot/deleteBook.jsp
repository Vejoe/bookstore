<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <style type="text/css">
    	td{
    		text-align:center;
    	}
    </style>
  </head>
  
  <body>
   <div align="center">
   <table cellpadding="0" cellspacing="0" border="1" width="70%">
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
	<s:iterator value="books" var="book" status="b">
		<tr>
			<td><img src="BookImg/<s:property value="#book.bookfilename"/>"/></td>
			<td><s:property value="#book.id"/></td>
			<td><s:property value="#book.booktype.type"/></td>
			<td><s:property value="#book.bookname"/></td>
			<td><s:property value="#book.publisher"/></td>
			<td><s:property value="#book.publisher_year"/></td>
			<td><s:property value="#book.author"/></td>
			<td><s:property value="#book.price"/></td>
			<td><s:property value="#book.stocks"/></td>
			<td><s:property value="#book.rank_price"/></td>
			<td><s:property value="#book.bookDealmount"/></td>
			<td><s:property value="#book.bookLookmount"/></td>
		</tr>
	</s:iterator>
    </table>
	[<a href="queryBookAction?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="queryBookAction?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="queryBookAction?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
	<a href="queryBookAction?pageNo=${totalPage}">尾页</a>]
       <h3>请输入要<h3 style="color:red;">删除</h3>的图书ID</h3>
               <s:form method="post" action="deleteBookAction">
                   <s:textfield name="id" label="图书ID"/>
                   <s:submit value="删除"/>
               </s:form>
	   <h3>请输入要<h3 style="color:red;">修改</h3>的图书ID</h3>
	   <s:form method="post" action="queryBookByIDAction">
		   <s:textfield name="id" label="图书ID"/>
		   <s:submit value="修改"/>
	   </s:form>
   </div>
  </body>
</html>
