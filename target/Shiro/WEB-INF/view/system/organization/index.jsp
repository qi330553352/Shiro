<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/css.css">
</head>
<body>

<iframe name="content" class="ui-layout-center" src="" frameborder="0" scrolling="auto"></iframe>

<iframe name="tree" class="ui-layout-west" src="${pageContext.request.contextPath}/organization/tree" frameborder="0" scrolling="auto"></iframe>

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