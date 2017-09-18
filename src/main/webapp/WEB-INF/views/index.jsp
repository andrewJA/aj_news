<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: andreyja
  Date: 12.09.17
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>aj_news</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/footer.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" crossorigin="anonymous">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="<c:url value='/list' />">AJnews</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/list' />">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/new' />">Add post</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">

                    <label class="dropdown-header">Choose:</label>

                    <c:forEach items="${categories}" var="category" varStatus="loop">
                        <div class="dropdown-item">
                            <form class="form-inline my-2 my-lg-0">
                                <input type="hidden" name="searchName" value="${category.name}">
                                <button class="btn-link" type="submit" formaction="searchPostsByCategory">${category.name}</button>
                            </form>
                        </div>
                    </c:forEach>

                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" name="searchName" id="searchName">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" formaction="searchPosts">Search</button>
        </form>
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">Lent of news</h1>
        <p>You can add, read, edit and delete news here.</p>
        <p><a class="btn btn-primary btn-lg" href="<c:url value="/test"/> " role="button">Learn more &raquo;</a></p>
    </div>
</div>

<div class="container">

    <c:if test="${empty posts}">
        There are no posts
    </c:if>
    <c:if test="${not empty posts}">

        <c:forEach items="${posts}" var="posts" varStatus="loop">
            <c:if test="${(loop.count-1)%3==0}">
                <div class="row" >
                    <div class="col-md-4">
                        <h2>${posts.name}</h2>
                        <p class="text-muted">${cats[loop.count-1].name}</p>
                        <p>${posts.content}</p>
                        <p><small>${posts.date}</small></p>
                        <p>
                            <a class="btn btn-outline-secondary my-2 my-sm-0" href="<c:url value='/edit-${posts.idPost}-post' />" role="button">Edit post &raquo;</a>
                            <a class="btn btn-outline-secondary my-2 my-sm-0" href="<c:url value='/delete-${posts.idPost}-post' />" role="button">Delete post &raquo;</a>
                        </p>
                    </div>

            </c:if>
            <c:if test="${(loop.count-1)%3!=0}">
                <div class="col-md-4">
                    <h2>${posts.name}</h2>
                    <p class="text-muted">${cats[loop.count-1].name}</p>
                    <p>${posts.content}</p>
                    <p><small>${posts.date}</small></p>
                    <p>
                        <a class="btn btn-outline-secondary my-2 my-sm-0" href="<c:url value='/edit-${posts.idPost}-post' />" role="button">Edit post &raquo;</a>
                        <a class="btn btn-outline-secondary my-2 my-sm-0" href="<c:url value='/delete-${posts.idPost}-post' />" role="button">Delete post &raquo;</a>
                    </p>
                </div>
                <c:if test="${loop.count%3==0}">
                </div>
                </c:if>
                <c:if test="${loop.last}">
                </div>
                </c:if>
            </c:if>
        </c:forEach>
    </c:if>
    <hr>

</div> <!-- /container -->

<footer class="blog-footer">
    <p><small>By <a href="https://vk.com/whatisup">Andrey Jashnikov</a> 2017 </small></p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
