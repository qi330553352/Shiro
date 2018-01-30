<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Shiro综合案例</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/plugins/layout-default-latest.css">
</head>
<body>
    <iframe name="content" class="ui-layout-center" src="${pageContext.request.contextPath}/Layouts/welcome" frameborder="0" scrolling="auto"></iframe>
    <div class="ui-layout-north">欢迎[<shiro:principal/>]学习Shiro综合案例，<a href="${pageContext.request.contextPath}/logout">退出</a></div>
    <div class="ui-layout-south">
        获取源码：<a href="https://github.com/zhangkaitao/shiro-example" target="_blank">https://github.com/zhangkaitao/shiro-example</a>
    </div>
    <div class="ui-layout-west">
        功能菜单<br/>
        <c:forEach items="${menus}" var="m">
            <a href="${pageContext.request.contextPath}${m.url}" target="content">${m.name}</a><br/>
        </c:forEach>
    </div>


    <script src="${pageContext.request.contextPath}/script/plugins/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/plugins/jquery.layout-latest.min.js"></script>
    <script>
        $(function () {
            $(document).ready(function () {
                $('body').layout({ applyDemoStyles: true });
            });
        });
    </script>
</body>
</html>
