<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/admintop1.css"/>"/>

<div id="nav">
    <div id="topic"></div>
    <div>
        <ul>
            <li><a href = " <c:url value="/managePage/login"/> ">登陆</a> </li>
            <li><a href = " <c:url value="/managePage/showAllNews"/>" >新闻管理</a></li>
            <li><a href = "<c:url value="/managePage/logout"/>">注销</a></li>
        </ul>
    </div>
</div>
<div id="navbar"></div>