<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <style type="text/css">
    	td{
    		text-align:center;
    	}
    </style>
  </head>
  
  <body>
   <div align="center">
       <table cellpadding="0" cellspacing="0" border="1" width="70%">
           <tr>
               <th>用户ID</th>
               <th>用户账号</th>
               <th>用户名</th>
               <th>密码</th>
               <th>性别</th>
               <th>邮箱</th>
               <th>手机号</th>
               <th>生日</th>
               <th>累计消费金额</th>
               <th>用户等级</th>
           </tr>
           <s:iterator value="Customers" status="st" var="customer">
               <tr>
                   <td><s:property value="#customer.id"/></td>
                   <td><s:property value="#customer.Caccount"/></td>
                   <td><s:property value="#customer.Cname"/></td>
                   <td><s:property value="#customer.password"/></td>
                   <td><s:property value="#customer.sex"/></td>
                   <td><s:property value="#customer.email"/></td>
                   <td><s:property value="#customer.phone_num"/></td>
                   <td><s:property value="#customer.birthday"/></td>
                   <td><s:property value="#customer.pay_sum"/></td>
                   <td><s:property value="#customer.rank"/></td>
               </tr>
           </s:iterator>
       </table>
       [<a href="queryCustomerAction?pageNo=1">首页</a>]
       <c:choose>
           <c:when test="${currentPage>1}">
               [<a href="queryCustomerAction?pageNo=${currentPage-1}">上一页</a>]
           </c:when>
       </c:choose>
       <c:choose>
           <c:when test="${currentPage<totalPage}">
               [<a href="queryCustomerAction?pageNo=${currentPage+1}">下一页</a>]
           </c:when>
       </c:choose>
       <a href="queryCustomerAction?pageNo=${totalPage}">尾页</a>]
   <s:form method="post" action="queryCustomerByIDAction">
   <s:textfield name="id" label="修改顾客ID"/>
   <s:submit value="确定"/>
   </s:form>
   </div>
  </body>
</html>
