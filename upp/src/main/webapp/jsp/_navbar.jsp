<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .navbar-default .navbar-nav>li>a:hover{

        color: red;

    }
    .navbar-default .navbar-nav>li>a{

        color: white;

    }
    .navbar-default{
        background-color: #0079bb;
    }
</style>

<nav style="background-color:#337ab7;color:white !important;" id="navigation" class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div id="navigation" class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>


        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul id="nav" class="nav navbar-nav">
                <li><a href="/task/tasks">Home</a></li>
                <li><a href="/magazines/all">Magazines</a></li>
      
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty loggedUser}">
                    <li><a href="/jsp/login.jsp" id="Login">Log in</a></li>
                    <li><a href="/jsp/registration.jsp" id="Login">Registration</a></li>
                </c:if>
                <c:if test="${not empty loggedUser}">
                    <li><a href="/registration/logout">Log out</a></li>
                </c:if>

            </ul>
        </div>
    </div>

</nav>
