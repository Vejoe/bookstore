<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showbook.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="css/showbook.css">
	<script type="text/javascript" src="js/showbook.js">
	</script>
  </head>
  
  <body>
  	<input id="booktype_id" type="hidden" value="<s:property value="Page_booktype_id"/>"/>  
	<input id="booktype_num" type="hidden" value="<s:property value="Page_booktype_num"/>"/>  
	<input id="bookstatus" type="hidden" value="<s:property value="Page_bookstatus"/>"/>  
	<jsp:include page="top.jsp" flush="true"/>
	<div id="showbook-select">
		<div id="showbook-nav">
			<div class="book-type">
				<div class="book-type-name">书籍类型</div>
				<div class="type-content">
					<ul>
						<li class="type-name" value="quanbu">全部</li>
						<s:iterator value="#session.booktype_list" status="st" var="btl">
						<li class="type-name" value="<s:property value="#btl.id"/>"><s:property value="#btl.type"/></li>
       					</s:iterator>
					</ul>
				</div>
			</div>
			<div class="book-type">
				<div class="book-type-name">书籍状态</div>
				<div class="type-content">
					<ul>
						<li class="book-status">全部</li>
						<li class="book-status">销售量</li>
						<li class="book-status">浏览量</li>
						<li class="book-status">新书</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="showbook">
	<s:iterator value="book_list" status="st" var="bl">	
		<div class="content-div">
	  			<div class="content-img"><a href="showonebookAction?bookid=<s:property value="#bl.id"/>"><img width="150" height="160" src="BookImg/<s:property value="#bl.bookfilename"/>"/></a></div>
	  			<div class="book-name"><a href="showonebookAction?bookid=<s:property value="#bl.id"/>"><s:property value="#bl.bookname"/></a></div>
	  			<div class="book-author"><s:property value="#bl.author"/></div>
	  			<div class="book-price">原价：¥<s:property value="#bl.price"/><br>会员价：¥<s:property value="#bl.rank_price"/></div>
	  	</div>
	  </s:iterator>
	  	<div id="tiaozhuan">
		  	<div class="tiao-div"><a href="showAction?now_page=1&Page_booktype_id=${Page_booktype_id}&Page_booktype_num=${Page_booktype_num}&Page_bookstatus=${Page_bookstatus}">&lt;&lt;</a></div>
		  	<div class="tiao-div"><a href="showAction?now_page=${session.now_page-1}&Page_booktype_id=${Page_booktype_id}&Page_booktype_num=${Page_booktype_num}&Page_bookstatus=${Page_bookstatus}">&lt;</a></div>
		  	
		  	<%
		  		int totalnum=Integer.parseInt(request.getSession().getAttribute("totalnum").toString());
		  		for(int i=0;i<totalnum;i++){%>
		  		<div class="tiao-div"><a href="showAction?now_page=<%=i+1%>&Page_booktype_id=${Page_booktype_id}&Page_booktype_num=${Page_booktype_num}&Page_bookstatus=${Page_bookstatus}"><%=i+1%></a></div>
		  	<%}%>
		  	<div class="tiao-div"><a href="showAction?now_page=${session.now_page+1}&Page_booktype_id=${Page_booktype_id}&Page_booktype_num=${Page_booktype_num}&Page_bookstatus=${Page_bookstatus}">&gt;</a></div>
		  	<div class="tiao-div"><a href="showAction?now_page=${totalnum}&Page_booktype_id=${Page_booktype_id}&Page_booktype_num=${Page_booktype_num}&Page_bookstatus=${Page_bookstatus}">&gt;&gt;</a></div>
	  	</div>
	  		<jsp:include page="bottom.jsp" flush="true"/>
	</div>

  </body>
</html>
