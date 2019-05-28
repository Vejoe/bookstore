<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Addconsignee.jsp' starting page</title>
    <sx:head/>
    <link href="css/Myself_m.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/mouseoverAndmouseout.js"></script>
  	<script type="text/javascript" src="js/Select.js"></script>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td><s:property value="customer.getCaccount()"/></td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td><s:property value="customer.getPhone_num()"/></td></tr>
    </table>
    <hr color="red">
    <b>添加收货人</b>
	<s:form method="post" action="UpdateConsigneeAction">
		<s:hidden name="consignee.id"/>
		<table>
			<tr class="tr">
				<td>&nbsp;收货人姓名:</td>
				<td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\s+/g,'')" cssStyle="height:30px" size="35" name="consignee.name" theme="simple" placeholder="请输入收货人姓名"/></td>
				<td class="sign">*</td>
				<td><s:fielderror><s:param>consignee.name</s:param></s:fielderror></td>
			</tr>
			<tr class="tr">
				<td>&nbsp;收货人手机号:</td>
				<td><s:textfield maxlength="30" onkeyup="this.value=this.value.replace(/\D/gi,'')" cssStyle="height:30px" size="35" name="consignee.phone_num" theme="simple" placeholder="请输入收货人手机号"/></td>
				<td class="sign">*</td>
				<td><s:fielderror><s:param>consignee.phone_num</s:param></s:fielderror></td>
			</tr>
		    <tr class="tr">
			    <td>&nbsp;收货人地址:</td>
			    <td id="doubleselect">
				    <s:select id="sheng" name="consignee.province" list="#{consignee.province:consignee.province}" theme="simple"></s:select>
			    	<s:select id="shi" name="consignee.city" list="#{consignee.city:consignee.city}" theme="simple"></s:select>
			    	<s:select id="qu" name="consignee.area" list="#{consignee.area:consignee.area}" theme="simple"></s:select>
		   		</td>
		   		<td class="sign">*</td>
		   		<td><s:fielderror><s:param>consignee.area</s:param></s:fielderror></td>
	   		</tr>
		    <tr class="tr">
			    <td>&nbsp;具体地址:</td>
			    <td><s:textarea rows="3" cols="33" onkeyup="this.value=this.value.replace(/\s+/g,'')" theme="simple" name="consignee.detailed_address" maxlength="30" placeholder="具体地址"/></td>
			    <td class="sign">*</td>
			    <td><s:fielderror><s:param>consignee.detailed_address</s:param></s:fielderror></td>
		    </tr>
			<tr class="tr" id="btntr">
				<td colspan="3">
					<s:submit theme="simple" value="确定" id="btn" onmouseover = "mouseover()" onmouseout = "mouseout()"/>
					<input type="button" value="返回" id="Rbtn" onmouseover = "mouseoverbyid(id)" onmouseout = "mouseoutbyid(id)" onclick="returnMyself()"/>
				</td>
				<td></td>
			</tr>
		</table>
	</s:form>
  </body>
</html>
