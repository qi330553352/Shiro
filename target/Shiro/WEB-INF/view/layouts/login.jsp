<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shiro 权限管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/plugins/h-ui/css/H-ui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/plugins/Hui-iconfont/1.0.8/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css">
</head>

<body class="sign-in">
<div class="login_wrapper">
    <h1 class="title">Shiro 权限管理系统</h1>
    <form action="" method="POST">
        <div class="input-wrapper cl">
            <i class="icon-username"></i>
            <input type="text" class="plc_input" placeholder="用户名" name="username" value="${username}" >
        </div>
        <div class="input-wrapper cl">
            <i class="icon-password"></i>
            <input type="password" class="plc_input" placeholder="密码" name="password" value="${password}" autocomplete="off">
        </div>
        <div class="input-wrapper cl">
            <i class="icon-validate"></i>
            <input type="text" placeholder="验证码" name="vcode" class="plc_input" maxlength="4" style="vertical-align: middle;width: 165px;"/>
            <%--<img src="/captcha/getGifCode" onclick="this.src='/captcha/getGifCode?'+Math.random()">--%>
        </div>
        <div class="error-msg"><label><input type="checkbox" name="rememberMe" <c:if test="${rememberMe}">checked</c:if>/>记住我</label></div>
        <div class="c-red error-msg">${msg}</div>
        <input type="submit" name="Login" class="btn btn-block" value="登录" >
    </form>
</div>

</body>
</html>