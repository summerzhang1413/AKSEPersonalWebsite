<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>高空飞人</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
    <script language="JavaScript">
        function Check(){
            if(document.managerlogin.name.value==""){
                alert("请填写管理员名！！！");
                managerlogin.name.focus();
                return false;
            }
            if(document.managerlogin.pwd.value==""){
                alert("请填写密码！！！");
                managerlogin.pwd.focus();
                return false;
            }
            document.managerlogin.submit();
        }
    </script>
</head>
<body >
<%@ include file="admintop.jsp" %>
<br><br>

<c:choose>
    <c:when test="${sessionManager==null||sessionManager.id==null}">
        <table id="back">
            <form  name="managerlogin" action="<c:url value="/managePage/login"/>" method="post">
                <tr height=80><td height="53"></td></tr>
                <tr>
                    <td width="30%" height="55" align="right">用户名:</td>
                    <td colspan="2" width="70%">
                        <input type="text" name="name" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td width="30%" height="57" align="right">密码:</td>
                    <td colspan="2" width="70%">
                        <input type="password" name="pwd" size="20"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <input type="button" size="20" value="   登录   " onClick="Check()">
                    </td>
                    <td align="left">
                        &nbsp;&nbsp;
                        <input type="reset" size="20" value="   重置   ">
                    </td>
                </tr>
            </form>
        </table>
    </c:when>
    <c:otherwise>
        <table align="center" width="100%" height="100%">
            <tr align="center">
                <td>
                        ${sessionManager.name} 您好，您已登录……<a href="<c:url value="/managePage/logout"/>">注销</a>
                </td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>
<br><br>
<c:if test="${not empty login_error}">
    <table align="center" width="100%" height="100%">
        <tr align="center">
            <td>
                <strong>登录出错:</strong>${login_error}
            </td>
        </tr>
        <c:remove var="login_error" />
    </table>
</c:if>

</body>
</html>