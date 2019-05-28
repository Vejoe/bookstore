<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
       <h3>修改的用户ID：${session.Cid}</h3>
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
   <s:form method="post" action="changeCINFAction">
       <s:textfield name="customer.cname" label="用户名"/>
       <s:textfield name="customer.password" label="密码"/>
       <s:textfield name="customer.sex" label="性别"/>
       <s:textfield name="customer.email" label="邮箱"/>
       <s:textfield name="customer.phone_num" label="手机号"/>
       <s:textfield name="customer.birthday" label="生日"/>
   <s:submit value="提交"/>
   </s:form>
   </div>
  </body>
</html>
