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
    	<th>图书类别ID</th>
		<th>图书类别</th>
	</tr>
	<s:iterator value="booktypes" status="st" var="booktype">
		<tr>
			<td><s:property value="#booktype.id"/></td>
			<td><s:property value="#booktype.type"/></td>
		</tr>
	</s:iterator>
    </table>
	[<a href="queryBookTypeAction?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="queryBookTypeAction?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="queryBookTypeAction?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
	<a href="queryBookTypeAction?pageNo=${totalPage}">尾页</a>]
       <s:form method="post" action="addBookAction" enctype="multipart/form-data">
       <s:textfield name="book.booktype.id" label="图书类别"/>
       <s:textfield name="book.bookname" label="图书名称"/>
       <s:textfield name="book.profile" label="图书简介"/>
       <s:textfield name="book.publisher" label="出版社"/>
       <s:textfield name="book.publisher_year" label="出版年份"/>
       <s:textfield name="book.author" label="作者"/>
       <s:textfield name="book.price" label="原价"/>
       <s:textfield name="book.stocks" label="库存"/>
       <s:textfield name="book.rank_price" label="会员价"/>
       <s:file name="upload" label="书籍图片"/>
       <s:submit value="添加"/>
       </s:form>
   </div>
  </body>
</html>
