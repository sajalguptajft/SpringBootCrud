<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring Boot Application | Edit Student Details</title>
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
            <a class="navbar-brand" href="/admin/getAllStudents">Spring Boot Application</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="navbar-form navbar-right">
                <a href="/admin/getAllStudents" class="btn btn-danger">All Students</a>
                <a href="/admin/logout" class="btn btn-success">Logout</a>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <div class="col-md-offset-4 col-md-4" style="margin-top: 5%;">
        <div class="form-area">
            <form:form method="post" modelAttribute="studentform" action="${pageContext.request.contextPath}/admin/addStudent" role="form">
                <form:hidden path="sid" value="${student.sid}" />
                <br style="clear:both">
                <h3 style="margin-bottom: 25px; text-align: center;">Edit Student</h3>
                <div class="form-group">
                    <form:input type="text" path="sname" value="${student.sname}" size="30" class="form-control" maxlength="30" placeholder="Enter Name" />
                </div>
                <div class="form-group">
                    <form:input type="password" path="spassword" value="${student.spassword}" size="30" maxlength="30" class="form-control" placeholder="Enter Password" />
                </div>
                <div class="form-group">
                    <form:input type="password" path="sconfpassword" value="${student.spassword}" size="30" maxlength="30" class="form-control" placeholder="Re Enter Password" />
                </div>
                <div class="form-group">
                    <form:input type="text" path="smobile" value="${student.smobile}" size="10" maxlength="10" class="form-control" placeholder="Enter Mobile No" />
                </div>
                <div class="form-group">
                    <form:input type="email" path="semail" class="form-control" value="${student.semail}" placeholder="Enter Email Id" />
                </div>
                <div class="form-group">
                    <form:input path="senabled" type="hidden" value="TRUE" />
                    <input type="submit" class="btn btn-primary pull-right" onclick="return validateStudent();" />
                </div>
            </form:form>
        </div>
    </div>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function validateStudent(){
            var username = document.getElementById("sname").value;
            if(username=="") {
                alert("Enter Username");
                document.getElementById("sname").focus();
                return false;
            }
            var password = document.getElementById("spassword").value;
            if(password=="") {
                alert("Enter Password");
                document.getElementById("spassword").focus();
                return false;
            }
            var confpassword = document.getElementById("sconfpassword").value;
            if(confpassword=="") {
                alert("Re Enter Password");
                document.getElementById("sconfpassword").focus();
                return false;
            }
            if(password!=confpassword){
                alert("Passwords DO NOT MATCH!");
                document.getElementById("spassword").focus();
                return false;
            }
            var mobile = document.getElementById("smobile").value;
            if(mobile=="") {
                alert("Enter Mobile");
                document.getElementById("smobile").focus();
                return false;
            }
            var email = document.getElementById("semail").value;
            if(email=="") {
                alert("Enter Email Id");
                document.getElementById("semail").focus();
                return false;
            }
        }
    </script>
</body>
</html>
