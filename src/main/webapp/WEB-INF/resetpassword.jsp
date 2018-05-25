<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Boot Application | Reset Password</title>
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
            <a class="navbar-brand" href="/">Spring Boot Application</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="navbar-form navbar-right">
                <a href="/index" class="btn btn-success">Home</a>
            </div>
        </div>
    </div>
</nav>
<div class = "container">
    <div class="wrapper">
        <form name="f" action="/passwordreset" method="POST" class="form-signin">
            <h3 class="form-signin-heading">Reset Password</h3>
            <hr class="colorgraph"><br>
            <input type="hidden" id="key" name="key" value="${key}" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required=""/>
            <input type="password" class="form-control" id="confirmpassword" name="confirmpassword" placeholder="Re-Enter Password" required=""/>
            <button style="margin-bottom: 10px;" class="btn btn-lg btn-primary btn-block" onclick="return validatepassword();" name="Submit" value="Reset Password" type="Submit">Reset</button>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function validatepassword(){
        var pw = document.getElementById("password").value;
        var repw = document.getElementById("confirmpassword").value;
        if(pw=="") {
            alert("Please Enter Password");
            return false;
        }
        if(repw==""){
            alert("Please Enter Confirm Password");
            return false;
        }
        if(pw!=repw){
            alert("Passwords DO NOT MATCH!!");
            return false;
        }
    }
</script>
</body>
</html>
