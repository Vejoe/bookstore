<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   
    
    <title>My JSP 'addbook.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
  </head>
  
  <body>
    <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">修改的图书 ID:${session.Bid}</h2>
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
        <td class="center"><img src="../../BookImg/<s:property value="#book.bookfilename"/>"/></td>
			<td class="center"><s:property value="#book.id"/></td>
			<td class="center"><s:property value="#book.booktype.type"/></td>
			<td class="center"><s:property value="#book.bookname"/></td>
			<td class="center"><s:property value="#book.publisher"/></td>
			<td class="center"><s:property value="#book.publisher_year"/></td>
			<td class="center"><s:property value="#book.author"/></td>
			<td class="center"><s:property value="#book.price"/></td>
			<td class="center"><s:property value="#book.stocks"/></td>
			<td class="center"><s:property value="#book.rank_price"/></td>
			<td class="center"><s:property value="#book.bookDealmount"/></td>
			<td class="center"><s:property value="#book.bookLookmount"/></td>
		</tr>
       </tr>
       </s:iterator>
      </table>
      
       <ul class="ulColumn2">
       <form action="changeBookAction" method="post" enctype="multipart/form-data">
       <li>
        <s:file name="upload" label="书籍图片"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">图书类别：</span>
        <s:textfield class="textbox textbox_225"  name="book.booktype.id"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">图书名称：</span>
        <s:textfield class="textbox textbox_225"  name="book.bookname"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">图书简介：</span>
        <s:textfield class="textbox textbox_225"  name="book.profile"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">出版社：</span>
        <s:textfield class="textbox textbox_225"  name="book.publisher"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">出版年份：</span>
        <s:textfield class="textbox textbox_225"  name="book.publisher_year"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">作者：</span>
        <s:textfield class="textbox textbox_225"  name="book.author"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">原价：</span>
        <s:textfield class="textbox textbox_225"  name="book.price"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">库存：</span>
        <s:textfield class="textbox textbox_225"  name="book.stocks"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">会员价：</span>
        <s:textfield class="textbox textbox_225"  name="book.rank_price"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;"></span>
        <input type="submit" class="link_btn" value="更新/保存"/>
       </li>
       </form>
      </ul>
 </div>
</section>
  </body>
</html>
