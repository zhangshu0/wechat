<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<!--主内容-->
<form class="form" action="/back/sql/executeSql.do" method="post">
    <input type="submit" value="导出excel">

</form>

<div>
    <table>
        <thead>
        <tr>
            <c:if test="${not empty columnList}">
                <c:forEach items="${columnList}" var="li">
                    <th>
                        <div style="background: #0a9de2;padding: 5px;margin: 1px;" size="100"> ${li}</div>
                    </th>
                </c:forEach>
            </c:if>
        </tr>
        </thead>
        <tbody>

        <c:if test="${not empty dataList}">

            <c:forEach items="${dataList}" var="midMap">
                <tr>
                    <c:forEach items="${midMap}" var="item">
                        <th><input style="width: 60px; color: #985f0d;" value="${item}" size="100"/></th>
                    </c:forEach>
                </tr>
            </c:forEach>

        </c:if>

        </tbody>
    </table>
</div>
</body>
</html>