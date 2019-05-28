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
       <h2 class="fl">添加图书</h2>
      </div>
      <table class="table">
       <tr>
        <th>图书类别ID</th>
        <th>图书类别</th>
       </tr>
       <s:iterator value="booktypes" status="stat" var="booktype">
       <tr>
        <td class="center"><s:property value="#booktype.id" /></td>
        <td class="center"><s:property value="#booktype.type" /></td>
       </tr>
       </s:iterator>
      </table>
      <aside class="paging">
      <a href="queryBookTypeAction?pageNo=1">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
					<a href="queryBookTypeAction?pageNo=${currentPage-1}">上一页</a>
				</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
					<a href="queryBookTypeAction?pageNo=${currentPage+1}">下一页</a>
				</c:when>
		</c:choose>
		<a href="queryBookTypeAction?pageNo=${totalPage}">尾页</a>
		[${currentPage}/${totalPage}]
      </aside>
      
       <ul class="ulColumn2">
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
      </ul>
 </div>
</section>
  </body>
</html>
