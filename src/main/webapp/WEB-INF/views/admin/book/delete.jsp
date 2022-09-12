<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 13.09.2022
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<div class="hero-body">
    <div class="container has-text-centered">
        <p class="title">
            Do you want to delete below book?
        </p>
    </div>
    <div class="table-container">
        <table class="table is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${book.title}<td>
                    <td>${book.author}</td>
                <tr>
                </tr>
            </tbody>
        </table>
    </div>
    <form method="post" action="/admin/book/delete">
        <input type="hidden" name="id" value="${book.id}"/>
        <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}"/>
        <div class="control">
            <button type="submit" class="button is-link">Yes</button>
        </div>
    </form>

    <form method="get" action="/admin/book/list">
        <div class="control">
            <button type="submit" class="button is-link">No</button>
        </div>
    </form>
</div>


</body>
</html>
