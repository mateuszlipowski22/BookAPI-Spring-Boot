<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.09.2022
  Time: 22:15
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
            Book Details
        </p>
    </div>
    <div class="table-container">
        <table class="table is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Type</th>
                <th>Publisher</th>
                <th>isbn</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.type}</td>
                <td>${book.publisher}</td>
                <td>${book.isbn}</td>
            <tr>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="container has-text-centered">
        <form method="get" action="/admin/book/list">
            <button type="submit" class="button is-link">Show book list</button>
        </form>
        <form method="get" action="/admin/book/${book.id}/edit">
            <button type="submit" class="button is-link">Edit</button>
        </form>
        <form method="get" action="/admin/book/${book.id}/delete">
            <button type="submit" class="button is-link">Delete</button>
        </form>
    </div>
</div>

</body>
</html>
