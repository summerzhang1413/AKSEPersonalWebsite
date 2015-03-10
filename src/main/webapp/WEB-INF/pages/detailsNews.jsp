<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消息公告</title>
<link href="/resources/css/news.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.STYLE2 {}
 
a:visited {
	color:#660099;
}
 
#com #content a:hover{
color: #FF0000;
text-decoration: none;
}
 
-->
</style>
</head>

<body>
<div id="com">
  <div id="head"><img src="/resources/images/header.png" width="955" height="150" /></div>
  
  <div id="content"> 
  <br />
    <p>&#12288;&#12288;<c:out value="${detailsNews.title}"/></p>
    <p><c:out value="${detailsNews.time}"/></p>
    <p><c:out value="${detailsNews.content}"/></p>
 <br />
 <br />  
 
  <table width="150" border="0" align="right">
  <tr>
    <td><a href="../home"><span class="STYLE2">返回首页&gt;&gt;</span></a></td>
  </tr>
</table>
<br />
<br />
</div>

  <div id="fonter">
    <table width="954" height="121" border="0">
    <tr><td height="8" bgcolor="#6633FF"></td>
    </tr>
      <tr>
        <td height="49"><div align="center">云南省昆明市西山区碧鸡镇黑荞母村&#12288;电话:18208770050</div></td>
      </tr>
      <tr>
        <td height="56"><div align="center">四川师范大学IFOX工作室版权所有</div></td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
