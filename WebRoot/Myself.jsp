<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%if(session.getAttribute("caccount")==null) response.sendRedirect("mainpage.jsp"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息操作</title>
  	<style type="text/css">
  		#top{
  		width:100%;
  		height:40px;
  		background-color:#f5f5f5;
  		box-shadow:0px 3px 10px #3f3f3f;
  		}
  	</style>
	<link href="css/Myself.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/Myself.js"></script>
  </head>
  
  <body>
  	<div id="top">
    	<marquee onmouseover="stop()"onmouseout="start()">
    		<span style="font-weight: bolder;font-size: 30px;color: red;"><%=session.getAttribute("cname") %></span>
    		<span style="font-weight: bolder;font-size: 30px;color: blue">同学你好，本店最新推出XXX活动，哦几把啦啪啪啪
    	</marquee>
    </div>
    <div class="div">
	    <table class="table"  border="0" cellspacing="0" cellpadding="0">
	    	<tr><td id="m1" class="menu" onmouseover = "mouseover('1')" onmouseout = "mouseout('1')" onclick="select('1')">我的信息</td><td id="iframetd" rowspan="18"><iframe id="iframe" scrolling="no" frameborder="0" src="GetCustomerDetailBycaccountAction.action?num=1"></iframe></td></tr>
	    	<tr><td id="m2" class="menu" onmouseover = "mouseover('2')" onmouseout = "mouseout('2')" onclick="select('2')">基础资料</td></tr>
	    	<tr><td id="m3" class="menu" onmouseover = "mouseover('3')" onmouseout = "mouseout('3')" onclick="select('3')">修改密码</td></tr>
	    	<tr><td id="m4" class="menu" onmouseover = "mouseover('4')" onmouseout = "mouseout('4')" onclick="select('4')">我的购物车</td></tr>
	    	<tr><td id="m5" class="menu" onmouseover = "mouseover('5')" onmouseout = "mouseout('5')" onclick="select('5')">我的订单</td></tr>
	    	<tr><td id="m6" class="menu" onmouseover = "mouseover('6')" onmouseout = "mouseout('6')" onclick="select('6')">收货人管理</td></tr>
	    	<tr><td id="m7" class="menu" onmouseover = "mouseover('7')" onmouseout = "mouseout('7')" onclick="select('7')">留言建议</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    	<tr><td class="menu">&nbsp;</td></tr>
	    </table>
    </div>
    <script type="text/javascript">
	    <%if(session.getAttribute("num")!=null){
				String num=session.getAttribute("num").toString(); %>
				var num=<%=num %>;
				now=num;
	    		document.getElementById("m"+num).style.background="white";
	    		document.getElementById("m"+num).style.color="blue"
	    		if(num==6)
	    			document.getElementById("iframe").src="GetCustomerConsigneeDetailBycaccountAction.action";
	    		else
	    			document.getElementById("iframe").src="GetCustomerDetailBycaccountAction.action?num="+num;
		<%}else{ %>
				var num=1;
				now=num;
	    		document.getElementById("m"+num).style.background="white";
	    		document.getElementById("m"+num).style.color="blue"
	    		document.getElementById("iframe").src="GetCustomerDetailBycaccountAction.action?num="+now;
		<%} %>
	</script>
  </body>
</html>
