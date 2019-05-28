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
    <title>My JSP 'mainpage.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="css/mainpage.css">
	
	<script type="text/javascript" src="js/lunbo.js"></script>

  </head>
  
  <body>
  	<jsp:include page="top.jsp" flush="true"/>
  	<div id="lunbo">
  		<div id="lunbo-content">
  			<div class="biaoqian">&lt;</div>
  			<div class="book-message">
  			<s:iterator value="lunbo_book" status="st" var="lbb">
  				<div class="book-content">
					<div class="content-name"><s:property value="#lbb.bookname"/></div>
					<div class="content-author"><s:property value="#lbb.author"/></div>
  					<div class="content-jianjie"><s:property value="#lbb.profile"/></div>
  				</div>
  				</s:iterator>
  				<div id="content-img">
  				<s:iterator value="lunbo_book" status="st" var="lbb">
  					<div class="content-tupian"><a href="showonebookAction?bookid=<s:property value="#lbb.id"/>"><img class="photo" width="60" height="70" src="BookImg/<s:property value='#lbb.bookfilename'/>"/></a></div>
  				</s:iterator>
  				</div>
  			</div>
  			<div class="biaoqian">&gt;</div>
  		</div>	
  	</div>
  	
  	<div id="bottom">
	  	<div class="neirong">
	  		<div class="title"><div class="border-bottom"></div><span>热销排行榜</span></div>
	  		<s:iterator value="hot_book" status="st" var="hb">   
	  		<div class="content-div">
	  			<div class="content-img"><a href="showonebookAction?bookid=<s:property value="#hb.id"/>"><img width="160" height="170" src="BookImg/<s:property value='#hb.bookfilename'/>"/></a></div>
	  			<div class="book-name"><a href="showonebookAction?bookid=<s:property value="#hb.id"/>"><s:property value='#hb.bookname'/></a></div>
	  			<div class="book-author"><s:property value='#hb.author'/></div>
	  			<div class="book-price">原价：¥<s:property value='#hb.price'/><br>会员价：¥<s:property value='#hb.rank_price'/></div>
	  		</div>
	  		</s:iterator>
	  	</div>
	  	<div class="neirong">
	  		<div class="title"><div class="border-bottom"></div><span>新书榜</span></div>
	  		<s:iterator value="new_book" status="st" var="nb">      				
	  		<div class="content-div">
	  			<div class="content-img"><a href="showonebookAction?bookid=<s:property value="#nb.id"/>"><img width="150" height="160" src="BookImg/<s:property value='#nb.bookfilename'/>"/></a></div>
	  			<div class="book-name"><a href="showonebookAction?bookid=<s:property value="#nb.id"/>"><s:property value='#nb.bookname'/></a></div>
	  			<div class="book-author"><s:property value='#nb.author'/></div>
	  			<div class="book-price">原价：¥<s:property value='#nb.price'/><br>会员价：¥<s:property value='#nb.rank_price'/></div>
	  		</div>
	  		</s:iterator>
	  	</div>
	  	  	<jsp:include page="bottom.jsp" flush="true"/>
  	</div>
  	
  </body>
</html>
