<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Boot Application | Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/theme.css" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">Spring Boot Application</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="navbar-form navbar-right">
                <%--<button type="button" class="btn btn-success">Login</button>--%>
            </div>
        </div>
    </div>
</nav>
<div class = "container">
    <div class="wrapper">
        <form name="f" action="/login" method="POST" class="form-signin" id="loginForm">
            <h3 class="form-signin-heading">Please Sign In</h3>
            <hr class="colorgraph"><br>
            <div class="alert-danger text-center" style="margin-bottom: 10px;">${error}</div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" class="form-control" name="username" placeholder="Username" required />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
            <button style="margin-bottom: 10px;" class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
            <a onclick="forgotpass();" style="cursor:pointer; from ">Forgot Password</a>
        </form>
        <form name="f2" action="/forgotpassword" class="form-signin" id="fPassForm" style="display: none;">
            <h3 class="form-signin-heading">Forgot Password</h3>
            <hr class="colorgraph"><br>
            <input type="email" class="form-control" name="email" placeholder="Enter Email" required style="margin-bottom: 20px;" />
            <button style="margin-bottom: 10px;" class="btn btn-lg btn-primary btn-block" type="Submit">Send Link</button>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function forgotpass(){
$('#loginForm').hide();
$('#fPassForm').show();
    }
</script>
</body>
</html>
