<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   
    
    <title>My JSP 'showmanager.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
    <script type="text/javascript">
    function deletemanager(id){
    if(confirm("你确定删除该管理员吗?")){
		location.href="deleteManager?id="+id;
	}
    }
    
    function selectchange(){
    	var i=document.getElementById("select1").value;
    	if(i=="b"){
    		location.href="showdDegreeManager?id=1";
    	}
    	if(i=="c"){
    		location.href="showdDegreeManager?id=0";
    	}
    }
    
    function queryname(){
    	var c=document.getElementById("queryname").value;
    	if(c.length>0){
    	location.href="queryNameManager?mname="+c;
    	}
    }
    </script>
  </head>
  
  <body>
    <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">管理员列表</h2>
       <a href="addmanager.jsp" class="fr top_rt_btn add_icon" target="mainframe">添加管理员</a>
      </div>
      <section class="mtb">
       <select class="select" onchange="selectchange()" id="select1">
       	<option value="a">等级</option>
        <option value="b">高级</option>
        <option value="c">低级</option>
       </select>
       <input type="text" class="textbox textbox_225" placeholder="输入管理员名称..." id="queryname"/>
       <input type="button" value="查询" class="group_btn" onclick="queryname()"/>
      </section>
      <table class="table">
       <tr>
        <th>id</th>
        <th>账号</th>
        <th>姓名</th>
        <th>手机号</th>
        <th>等级</th>
        <th>操作</th>
       </tr>
       <s:set var="flag" name="mname"/>
       <s:iterator value="managers" status="stat" var="manager">
       <tr>
        <td class="center"><s:property value="#manager.id" /></td>
        <td class="center"><s:property value="#manager.adminaccount" /></td>
        <td class="center"><s:property value="#manager.adminname" /></td>
        <td class="center"><s:property value="#manager.phone" /></td>
        <td class="center">
        <s:if test="#manager.adminflag>0">高级</s:if>
		<s:if test="#manager.adminflag<1">低级</s:if>
		</td>
        <td class="center">
         <a href="javascript:location.href='queryManagerById?id=${manager.id}'" title="修改" class="link_icon">&#101;</a>
         <a href="javascript:deletemanager('<s:property value="id"/>')" title="删除" class="link_icon">&#100;</a>
        </td>
       </tr>
       </s:iterator>
      </table>
      <aside class="paging">
      <a href="queryNameManager?pageNo=1&mname=${flag}">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
					<a href="queryNameManager?pageNo=${currentPage-1}&mname=${flag}">上一页</a>
				</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
					<a href="queryNameManager?pageNo=${currentPage+1}&mname=${flag}">下一页</a>
				</c:when>
		</c:choose>
		<a href="queryNameManager?pageNo=${totalPage}&mname=${flag}">尾页</a>
		[${currentPage}/${totalPage}]
      </aside>
 </div>
</section>
  </body>
</html>
