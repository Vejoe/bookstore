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
    		
    <title>My JSP 'showonebook.jsp' starting page</title>
  
	
	<link rel="stylesheet" type="text/css" href="css/showresultbook.css">
	<script type="text/javascript">
    		  window.onload=function(){
			if (self != top) {
				document.body.style.display="none";
				top.location.href="/bookstore"+localStorage.getItem("0");
			}
			
		};
    		</script>

  </head>
  
  <body> 
     <jsp:include page="top.jsp" flush="true"/>
     <div id="sousuo">
     	<div id="sousuo-div">
     		<div id="sousuo-title">${title }<div id="divbottom"></div></div>
     			<div id="showdiv">
     			<div id="error">${ErrorMessage}</div>
     			<s:iterator value="book_list" status="st" var="bl">
     				<div class="show-content">
     					<div class="show-img"><a href="showonebookAction?bookid=<s:property value="#bl.id"/>"><img src="BookImg/<s:property value="#bl.bookfilename"/>" height="240px" width="180px"/></a></div>
     					<div class="book-content">
     					<div class="bookname"><a href="showonebookAction?bookid=<s:property value="#bl.id"/>"><s:property value="#bl.bookname"/></a></div>
     					<div class="bookauthor">
     						<div class="bookleft">作者：<s:property value="#bl.author"/><br>分类：<s:property value="#bl.booktype.type"/></div>
     						<div class="bookright">出版社：<s:property value="#bl.publisher"/><br>出版时间：<s:property value="#bl.publisher_year"/></div>
     					</div>
     					<div class="bookjianjie"><s:property value="#bl.profile"/></div>
    					<div class="bookprice">普通价：<s:property value="#bl.price"/>&nbsp;&nbsp;&nbsp;&nbsp;会员价：<s:property value="#bl.rank_price"/></div>
						<div class="bookmessage">阅读量：<s:property value="#bl.booklookmount"/>&nbsp;&nbsp;&nbsp;&nbsp;销售量：<s:property value="#bl.bookdealmount"/></div>
     					</div>
     				</div>
     			</s:iterator>
     			
     			<%if(request.getSession().getAttribute("cid")!=null&&Integer.parseInt(request.getAttribute("status").toString())!=0){%>
     			<div id="tiaozhuan">
     				<div class="tiao-div"><a href="collectionAction?now_page=1">&lt;&lt;</a></div>
     				<div class="tiao-div"><a href="collectionAction?now_page=${session.now_page-1}">&lt;</a></div>
     				<%
					  	int totalnum=Integer.parseInt(request.getSession().getAttribute("totalnum").toString());
					  	
					  	for(int i=0;i<totalnum;i++){%>
					  	<div class="tiao-div"><a href="collectionAction?now_page=<%=i+1%>"><%=i+1%></a></div>
					<%}%>
     				<div class="tiao-div"><a href="collectionAction?now_page=${session.now_page+1}">&gt;</a></div>
				  	<div class="tiao-div"><a href="collectionAction?now_page=${totalnum}">&gt;&gt;</a></div>
     			</div>
   	 			<%}%>
	  						
     		</div>
     		
     	</div>
     	
     </div>
  </body>
</html>
