<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title">
                Book Details<br>
            </p>
        </div>
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
        <div class="container has-text-centered">
            <form method="get" action="/user/book/list">
                <button type="submit" class="button is-link">Show book list</button>
            </form>
        </div>

    </div>
</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>
