<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>My JSP 'showmessage.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="/bookstore/manager/css/style2.css">
     <script type="text/javascript">
     function deletemessage(id)
     {
     	if(confirm("你确定删除该留言吗?")){
		location.href="deleteMessage?id="+id;
	}
     }
    function queryname(){
    	var c=document.getElementById("queryname").value;
    	if(c.length>0){
    	location.href="queryMessageTitle?mname="+c;
    	}
    }
     </script>
  </head>
  
  <body>
     <section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">留言列表</h2>
      </div>
      <section class="mtb">
       <input type="text" class="textbox textbox_225" placeholder="输入标题名称..." id="queryname"/>
       <input type="button" value="查询" class="group_btn" onclick="queryname()"/>
      </section>
      <table class="table">
       <tr>
        <th>id</th>
        <th>标题</th>
        <th>手机号</th>
        <th>操作</th>
       </tr>
       <s:set var="flag" name="mname"/>
       <s:iterator value="messages" status="stat" var="m">
       <tr>
        <td class="center"><s:property value="#m.id" /></td>
        <td class="center"><s:property value="#m.title" /></td>
        <td class="center"><s:property value="#m.phone" /></td>
        <td class="center">
         <a href="javascript:location.href='showMessageDetail?id=${m.id}'" title="查看" class="link_icon">&#118;</a>
         <a href="javascript:deletemessage('<s:property value="id"/>')" title="删除" class="link_icon">&#100;</a>
        </td>
       </tr>
       </s:iterator>
      </table>
      <aside class="paging">
      <a href="queryMessageTitle?pageNo=1&mname=${flag}">首页</a>
		<c:choose>
			<c:when test="${currentPage>1}">
					<a href="queryMessageTitle?pageNo=${currentPage-1}&mname=${flag}">上一页</a>
				</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${currentPage<totalPage}">
					<a href="queryMessageTitle?pageNo=${currentPage+1}&mname=${flag}">下一页</a>
				</c:when>
		</c:choose>
		<a href="queryMessageTitle?pageNo=${totalPage}&mname=${flag}">尾页</a>
		[${currentPage}/${totalPage}]
      </aside>
 </div>
</section>
  </body>
</html>
