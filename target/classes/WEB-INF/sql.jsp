<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<!--主内容-->
<form class="form" action="/back/sql/executeSql.do" method="post">
    <input type="submit" value="导出excel">

</form>

<div>
    <table border="1">
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
                        <td align="center"><input style="color:#985f0d;border:none;width:97%;padding:0px;overflow: auto;" type="text" class="input_auto"  value="${item}"/></td>
                        <span class="spanw"></span>
                        <%--<td>${item}</td>--%>
                    </c:forEach>
                </tr>
            </c:forEach>

        </c:if>

        </tbody>
    </table>
</div>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

    jQuery(document).ready(function($){
        // 第一次加载设置input宽度
        $('.input_auto').each(function(index, el) {
            textWidth($(this))
        });
        function textWidth($this){
            // 获取当前input的value值和字体大小
            var inputVal=$this.val();
            var font=$this.css('font-size');
            //获取容器的宽度
            $(".spanw").text(inputVal).css('font-size',font);;
            var width = $(".spanw").width();
            // 清空容器
            $(".spanw").text('');
            // 设置input宽度
            $this.css('width', width);
        };

    });

</script>
</html>