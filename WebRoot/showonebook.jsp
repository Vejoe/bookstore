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
    
	
	<link rel="stylesheet" type="text/css" href="css/showonebook.css">
	<script type="text/javascript" src="js/showonebook.js">
	</script>
	<script type="text/javascript">
		function commentsubmit(){
			var bookid=document.getElementById("book-id").value;
			var message=document.getElementById("input-textarea").value;
			var Loginstatus=document.getElementById("Login-status").value;
			if(Loginstatus==0){
				
				loginshow();
			}else{
				location.href="addCommentAction?bookid="+bookid+"&commentcontent="+message;
			}
		}
	</script>
  </head>
  
  <body>
  	<input id="book-id" type="hidden" value="<s:property value="bookid"/>"/>  
  	<input id="collect-status" type="hidden" value="${collectstatus}"/>
  	<input id="Login-status" type="hidden" value="${Loginstatus}"/>
     <jsp:include page="top.jsp" flush="true"/>
     <div id="showbookdiv">
     	<div id="showdiv">
     		<div id="show-top"><a href="">首页</a>>><a href="showAction?Page_booktype_id=${book.booktype.id}&Page_booktype_num=${book.booktype.id}&Page_bookstatus=0">${book.booktype.type}</a>>>${book.bookname}</div>
     		<div id="show-content">
     			<div id="show-img"><img src="BookImg/${book.bookfilename}" height="320px" width="250px"/></div>
     			<div id="book-content">
     				<div id="bookname">${book.bookname}</div>
     				<div id="bookauthor">
     					<div id="bookleft">作者：${book.author}<br>分类：${book.booktype.type}</div>
     					<div id="bookright">出版社：${book.publisher}<br>出版时间：${time}</div>
     				</div>
     				<div id="bookjianjie">${bookjianjie}</div>
     				<div id="bookprice">普通价：${book.price}&nbsp;&nbsp;&nbsp;&nbsp;会员价：${book.rank_price}</div>
     				<div id="bookanniu"><div class="anniu">加入购物车</div>
     				
     				<div class='anniu' id='shoucang'>收藏</div>
     				<div class='anniu' id='deletecollection'>取消收藏</div>
     				
     				</div>
					<div id="bookmessage">阅读量：${book.booklookmount}&nbsp;&nbsp;&nbsp;&nbsp;销售量：${book.bookdealmount}</div>
     			</div>
     		</div>
     	</div>
     </div>
     <div id="comment">
    
     	<div id="comment-div">
     		<div class="comment-title">用户评论<div class="divbottom"></div></div>
     		
     		<s:iterator value="list_comment" status="st" var="lc">	
     			<div class="comment-message">
     				<div class="comment-username"><div class="commentnicheng">用户昵称：<span><s:property value="#lc.cname"/></span></div><div class="commentdate">评论时间：<span><s:property value="#lc.commentdate"/></span></div></div>
     				<div class="comment-content"><div class="comment-pinglun">用户评论：<span><s:property value="#lc.commentcontent"/></span></div></div>
     			</div>
     		</s:iterator>
     	
     		<div id="tiaozhuan">
		  		<div class="tiao-div"><a href="showonebookAction?bookid=${bookid}&now_page=1">&lt;&lt;</a></div>
		  		<div class="tiao-div"><a href="showonebookAction?bookid=${bookid}&now_page=${session.now_page-1}">&lt;</a></div>
		  		<%int totalnum=Integer.parseInt(request.getSession().getAttribute("totalnum").toString());
					for(int i=0;i<totalnum;i++){%>
		  		<div class="tiao-div"><a href="showonebookAction?bookid=${bookid}&now_page=<%=i+1%>"><%=i+1%></a></div>
		  		<%}%>
		  		<div class="tiao-div"><a href="showonebookAction?bookid=${bookid}&now_page=${session.now_page+1}">&gt;</a></div>
		  		<div class="tiao-div"><a href="showonebookAction?bookid=${bookid}&now_page=${totalnum}">&gt;&gt;</a></div>
	  		</div>
	  		
	  		<div class="comment-title">发表评论<div class="divbottom"></div></div>
	  		<form id="comment-form">
	  		<textarea id="input-textarea"></textarea>
	  			<div id="form-buttom"><div id="form-submit" onclick="commentsubmit()">提交</div><input value="清空" type="reset" id="form-reset"></div>
	  		</form>
    	</div>
    	
	  	  	<jsp:include page="bottom.jsp" flush="true"/>
     </div>
  </body>
</html>

