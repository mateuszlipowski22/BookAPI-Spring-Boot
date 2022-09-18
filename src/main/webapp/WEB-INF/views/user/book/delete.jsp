<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body ">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title" style="marker-offset: 30px">
                Do you want to delete below book from your list?
            </p>
        </div>
        <table class="table is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${userBookListElement.book.title}</td>
                <td>${userBookListElement.book.author}</td>
            </tr>
            </tbody>
        </table>
        <div class="level-item has-text-centered" style="">
                <form method="post" action="/user/book/delete">
                    <input type="hidden" name="id" value="${userBookListElement.id}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="control">
                        <button type="submit" class="button is-link">Yes</button>
                    </div>
                </form>
                <form method="get" action="/user/book/userBookList">
                    <div class="control">
                        <button type="submit" class="button is-link">No</button>
                    </div>
                </form>
        </div>
    </div>

</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>