<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.09.2022
  Time: 23:41
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
            Add New Book
        </p>
    </div>
    <div class="table-container">
        <form:form modelAttribute="book" method="post" action="/admin/book/add">
            <div class="field">
                <label class="label">Title</label>
                <div class="input">
                    <form:input path="title"></form:input>
                </div>
                <div>
                    <form:errors path="title"></form:errors>
                </div>
            </div>
            <div class="field">
                <label class="label">Author</label>
                <div class="input">
                    <form:input path="author"></form:input>
                </div>
                <div>
                    <form:errors path="author"></form:errors>
                </div>
            </div>
            <div class="field">
                <label class="label">Publisher</label>
                <div class="input">
                    <form:input path="publisher"></form:input>
                </div>
                <div >
                    <form:errors path="publisher"></form:errors>
                </div>
            </div>
            <div class="field">
                <label class="label">ISBN</label>
                <div class="input">
                    <form:input path="isbn"></form:input>
                </div>
                <div >
                    <form:errors path="isbn"></form:errors>
                </div>
            </div>
            <div class="field">
                <label class="label">type</label>
                <div class="input">
                    <form:input path="type"></form:input>
                </div>
                <div >
                    <form:errors path="type"></form:errors>
                    <form:hidden path="id"></form:hidden>
                </div>
            </div>
            <div class="control">
                <button type="submit" class="button is-link">Add Book</button>
            </div>
        </form:form>
    </div>
</div>


</body>
</html>
