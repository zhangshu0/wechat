<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    //导出
    function download() {
        var key = prompt("请输入key")
        var url = "/doExcel/genExcel?key=" + key;
        window.location.href = url;
    };

</script>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>

<form action="/doExcel/excel2Html" method="post" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile"/>
    <br/><br/>
    <input type="submit" value="上传"/>
    <c:choose>
        <c:when test="${requestScope.errorNo== 0}">
            <td><b>"文件生成成功,提取key是"${requestScope.key}",请牢记"</b></td>
        </c:when>
        <c:when test="${requestScope.errorNo== 1}">
            <td><b>"文件生成失败,错误原因:"${requestScope.errorMsg},"请联系工作人员~ QQ:780031741"</b></td>
        </c:when>
        <c:otherwise>
            <td><b>"请先上传文件"</b></td>
        </c:otherwise>
    </c:choose>
    <input type="button" value="下载" onclick="download()"/>
</form>
</body>
</html>