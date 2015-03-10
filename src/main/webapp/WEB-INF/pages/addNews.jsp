<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加新闻</title>
    <script language="JavaScript">
        function check(){
            if(document.addnews.title.value==null){
                alert("请填写新闻标题！");
                addnews.title.focus();
                return false;
            }
            if(document.addnews.content.value==null){
                alert("请填写新闻内容！");
                addnews.content.focus();
                return false;
            }
            document.addnews.submit();
        }
    </script>
</head>
<body>
<center>
    <%@include file="admintop.jsp"%>
    <br>
    <form name="addnews" action="<c:url value="/managePage/addNews"/>" method="post" enctype="multipart/form-data">
        <div style="text-align:center;">
            <table style="margin:auto; width:40%;" >
                <tr >
                    <td align="left">新闻标题</td>
                </tr>
                <tr>
                    <td align="left">
                        <input type="text" name="title" >
                    </td>
                </tr>
                <tr >
                    <td align="left">新闻内容</td>
                </tr>
                <tr>
                    <td align="left">
                        <textarea rows="20" cols="80" name="content"></textarea>
                    </td>
                </tr>

                <tr align="center" >
                    <td align="left"><input type="button" value="提交" onclick="check()"></td>
                    <td align="left"><input type="reset" value="重置"></td>
                </tr>
            </table>
        </div>
    </form>
</center>

</body>
</html>
