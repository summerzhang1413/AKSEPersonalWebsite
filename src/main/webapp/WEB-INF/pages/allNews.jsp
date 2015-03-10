<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>新闻管理</title>
</head>
<body>
<center>
    <%@include file="admintop.jsp"%>
    <br>
    <c:choose>
        <c:when test="${sessionManager==null}">
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        <strong>操作错误:</strong>请先登录！
                    </td>
                </tr>
            </table>
        </c:when>
        <c:when test="${sessionManager!=null}">
            <table align="center" width="80%" cellspacing="1" border="2">
                <tr bgcolor="white" align="center">
                    <td>新闻编号</td>
                    <td>新闻标题</td>
                    <td>操作</td>
                    <td>发布时间</td>
                </tr>
                <c:forEach items="${allnews}" var="allnews" varStatus="status">
                    <tr align="center">
                        <td>
                            <c:out value="${allnews.id}"></c:out>
                        </td>
                        <td>
                            <a href="<c:url value="/newsmanage/update?newsId=${allnews.id}"/>"><c:out value="${allnews.title}"></c:out></a>
                        </td>
                        <td>
                            <a href="<c:url value="/managePage/deleteNews?id=${allnews.id}"/> ">删除</a>
                        </td>
                        <td>
                            <c:out value="${allnews.time}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <table align="center" border="0" width="80%">
                <tr align="center">
                    <td align="center">
                        <a href="<c:url value="/managePage/toAddNews"/> ">添加新闻</a>
                    </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        操作错误，请重试！
                    </td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</center>
</body>
</html>
