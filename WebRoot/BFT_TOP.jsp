<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'BFT_TOP.jsp' starting page</title>
    <style type="text/css">
    	body{
    		background:url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526199504582&di=6a71edd6625e429a7f13808589eeb2a8&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd009b3de9c82d1589b3a2a8a8b0a19d8bc3e4254.jpg)
    	}
    	ul{
		    list-style-type: none;
		    margin: 0;
		    padding: 0;
		    overflow: hidden;
		    background-color: #333;
		}
		li{
		    float: left;
		}
		li a{
		    display: block;
		    color: white;
		    text-align: center;
		    padding: 14px 16px;
		    text-decoration: none;
		}
		/*鼠标移动到选项上修改背景颜色 */
		li a:hover{
		    background-color: #111;
		}
		.active{
		    background-color: #4CAF50;
		}
    </style>
  </head>
  <body>
    <div align="center">
    	<ul>
    	<li><a href="addBookType.jsp" target="bottom">增加图书类别</a></li>
    	<li><a href="<s:url action="queryBookTypeAction"/>" target="bottom">增加图书</a></li>
    	<li><a href="<s:url action="queryBookAction"/>" target="bottom">查询、修改图书信息</a></li>
    	<li><a href="<s:url action="queryCustomerAction"/>" target="bottom">查询、修改顾客信息</a></li>
    	</ul>
    </div>
  </body>
</html>
