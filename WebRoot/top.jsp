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
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<script type="text/javascript" src="js/LoginInterceptor.js"></script>
	<script type="text/javascript" src="js/ShowByJSP.js"></script>
	<script type="text/javascript" src="js/ShowByJSP2.js"></script>
		<script type="text/javascript">
		
		function exit(){
			location.href="ExtiAction?url="+this.parent.window.location.toString().substring(32);
		}
		function dosubmit(){
			var message=document.getElementById("form-text").value;
			location.href="showresultbookAction?status=0&bookmessage="+message;
		}
	</script>

  </head>
  
  <body>
  
  <s:action name="topAction" executeResult="false"></s:action>
   	<script type="text/javascript">
		function collection(){
			<%if(session.getAttribute("caccount")==null){ %>
				loginshow();
			<%}else{ %>
				location.href="collectionAction";
			<%} %>
		}
	</script>
	<div id="top">
    	<ul id="top-ul">
    		<%if(session.getAttribute("caccount")==null){ %>
			<li class="top-li"><div class="top-li-login"><a href="javascript:void(0);" onclick="loginshow()" >请登录</a></div><div class="top-li-login"><a href="Customerregister.jsp">免费注册</a></div></li>
    		<%}else{ %>
    		<li class="top-li" id="top-li-message">
    			<div class="top-content"><a target="_blank" href="Myself.jsp"><%=session.getAttribute("cname") %></a></div>
    		 	<div id="message-content">
    		 		<div><a href="javascript:void(0);" onclick="ShowByJSP('GetCustomerDetailBycaccountAction?num=2');" >修改基础资料</a></div>
    		 		<div><a href="javascript:void(0);" onclick="ShowByJSP('GetCustomerDetailBycaccountAction?num=3');" >修改密码</a></div>
    		 		<div><a href="javascript:void(0);" onclick="ShowByJSP('GetCustomerConsigneeDetailBycaccountAction');" >收货人信息</a></div>
    		 	</div>
    		</li>
    		<li class="top-li"><a href="javascript:void(0);" onclick='exit()'>[注销]</a></li>
    		<%} %>
    		<%if(session.getAttribute("caccount")==null){ %>
    		<li class="top-li"><a href="javascript:void(0);" onclick='loginshow()'>我的订单</a></li>
    		<li class="top-li"><a href="javascript:void(0);" onclick='loginshow()'>购物车</a></li>
    		<li class="top-li"><a href="javascript:void(0);" onclick="ShowByJSP('Anonymous_message.jsp')" >留言</a></li>
    		<%}else{ %>
    		<li class="top-li"><a href="javascript:void(0);" onclick="ShowByJSP2('ShowOrderAction')">我的订单</a></li>
    		<li class="top-li"><a href="javascript:void(0);" onclick="ShowByJSP2('ShowShoppingCartAction')">购物车</a></li>
    		<li class="top-li"><a href="javascript:void(0);" onclick="ShowByJSP('GetCustomerDetailBycaccountAction?num=7');">留言</a></li>
    		<%} %>
    	</ul>
    </div>
    <div id="content-top">
    	<div id="content">
    		<div id="content-logo"><img src="img/logo.png"/></div>
    		<div id="content-sousuo">
    			<form method="post" action="" onsubmit='return dosubmit()'>
    				<input type="text" id="form-text" name="bookmessage"/>
    			</form>
    				<div id="form-sub"  onclick="dosubmit();">搜索</div>
    			
    		</div>
    		<div id="collection">
    			<a href="javascript:void(0);" onclick='collection()'><div id="collection-title">我的收藏</div></a>
    			<div id="collectiondiv">
    			
   				<s:iterator value="#session.collection" status="st" var="cl">
    				<a href="showonebookAction?bookid=<s:property value="#cl.book.id"/>"><div class="collection-content">
    					<img src="BookImg/<s:property value="#cl.book.bookfilename"/>" height="50" width="40"/>
    					<div><s:property value="#cl.book.bookname"/></div>
    				</div></a>
    			</s:iterator>	
    				<a href="javascript:void(0);" onclick='collection()'><div id="collect-end">浏览更多收藏</div></a>
    			</div>
    		</div>
    	</div>
  	</div>
  	<div id="content-nav">
       	<ul id="content-nav-ul">
       		<li class="content-nav-li" id="nav-li1"><a>书籍分类&nbsp;&nbsp;&nbsp;></a>
       			<ul id="nav-li1-ul">
       				<s:iterator value="#session.booktype_list" status="st" var="btl">
       				<li class="nav-li1-li">	
       				<a href="showAction?Page_booktype_id=<s:property value="#btl.id"/>&Page_booktype_num=<s:property value="#st.index+1"/>&Page_bookstatus=0">
       				<s:property value="#btl.type"/>
       				</a>
       				</li>
       				</s:iterator>
       			</ul>
       		</li>
       		<li class="content-nav-li"><a href="mainpageAction">首页</a></li>
       		<li class="content-nav-li"><a href="showAction">书库</a></li>
       		<li class="content-nav-li"><a href="showAction?Page_booktype_id=0&Page_booktype_num=0&Page_bookstatus=1">销量榜</a></li>
       		<li class="content-nav-li"><a href="showAction?Page_booktype_id=0&Page_booktype_num=0&Page_bookstatus=2">浏览榜</a></li>       		
       		<li class="content-nav-li"><a href="showAction?Page_booktype_id=0&Page_booktype_num=0&Page_bookstatus=3">新书榜</a></li>

       	</ul>
    </div>
  </body>
</html>
