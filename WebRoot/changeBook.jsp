<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
    	td{
    		text-align:center;
    	}
    </style>
</head>
<body>
	<div align="center">
    <h3>修改的图书 ID:${session.Bid}</h3>
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
    
    <s:form method="post" action="changeBookAction" enctype="multipart/form-data">
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
        <s:submit value="修改"/>
    </s:form>
</div>
</body>
</html>
