<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring Boot Application | All Student Details</title>
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
                <a href="/admin/addnewstudent" class="btn btn-danger">Add Student</a>
                <a href="/admin/logout" class="btn btn-success">Logout</a>
            </div>
        </div>
    </div>
</nav>
<div class="container" style="margin-top: 7%;">
<c:if test="${!empty listOfStudents}">
    <h3 class="text-center">List of All Students</h3>
    <div class="method">
        <div class="row margin-0 list-header hidden-sm hidden-xs">
            <div class="col-md-1"><div class="header">Id</div></div>
            <div class="col-md-3"><div class="header">Student Name</div></div>
            <div class="col-md-3"><div class="header">Mobile</div></div>
            <div class="col-md-3"><div class="header">Email</div></div>
            <div class="col-md-1"><div class="header">Edit</div></div>
            <div class="col-md-1"><div class="header">Delete</div></div>
        </div>
        <c:forEach items="${listOfStudents}" var="listOfStudents">
        <div class="row margin-0">
            <div class="col-md-1">
                <div class="cell">
                    <div class="propertyname">
                        ${listOfStudents.sid}
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="cell">
                    <div class="propertyname">
                        ${listOfStudents.sname}
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="cell">
                    <div class="propertyname">
                            ${listOfStudents.smobile}
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="cell">
                    <div class="propertyname">
                        ${listOfStudents.semail}
                    </div>
                </div>
            </div>
            <div class="col-md-1">
                <div class="cell">
                    <div class="propertyname">
                        <a href="<c:url value='/admin/updateStudent/${listOfStudents.sid}' />" >Edit</a>
                    </div>
                </div>
            </div>
            <div class="col-md-1">
                <div class="cell">
                    <div class="propertyname">
                        <a href="javascript:void(0);" onclick="deleteUser('${listOfStudents.sid}');">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    </div>
</c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function deleteUser(userid){
            if(confirm("Are you sure you want to Delete this User?")){
                location.href="/admin/deleteStudent/"+userid;
            }
        }
    </script>
</body>
</html>
