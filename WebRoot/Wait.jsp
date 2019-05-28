<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta http-equiv="refresh" content="2;url='GetCustomerDetailBycaccountAction.action?num=2"/>
    <style type="text/css">
    	*{
    		font-size:15px;
    	}
    </style>
    <script type="text/javascript">
    var i=2;
    function showTime(){
    i--;
    document.getElementById("mytime").innerText=i;
    }
    setInterval("showTime()",1000);
    </script>
  </head>
  
  <body>
  	<b>基础信息</b>
    <table>
    	<tr><td>&nbsp;用户账号:</td><td>正在修改中</td></tr>
    	<tr><td>&nbsp;绑定手机:</td><td>正在修改中</td></tr>
    </table>
    <hr color="red">
    <b style="color:blue">正在修改中，请稍后...<span style="color:red" id="mytime">2</span></b> <br>
    	如果没有自动跳转请点击这里. <br>
    <a href="GetCustomerDetailBycaccountAction.action?num=2"> 点这里 </a> 
  </body>
</html>
