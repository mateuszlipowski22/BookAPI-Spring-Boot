<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title">
                My books list<br>
                <br>
            </p>
        </div>
        <table class="table is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Num</th>
                <th>Title</th>
                <th>Author</th>
                <th>Reading start date</th>
                <th>Reading finish date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="userBookListElemet" items="${userBookList}" varStatus="loop">
                <tr>
                    <td>${loop.count}</td>
                    <td>${userBookListElemet.book.title}</td>
                    <td>${userBookListElemet.book.author}</td>
                    <td>${userBookListElemet.plannedToReadDate}</td>
                    <td>${userBookListElemet.finishedReadDate}</td>
                    <td>
                        <nav class="navbar">
                            <div class="navbar-menu">
                                <a href="${userBookListElemet.id}/planReading">
                                    <button type="submit" class="button button is-primary">Plan reading</button>
                                </a>
                            </div>
                            <div class="navbar-menu">
                                <a href="${userBookListElemet.id}/setFinishReading">
                                    <button type="submit" class="button button is-primary">Finished reading</button>
                                </a>
                            </div>
                            <div class="navbar-menu">
                                <a href="${userBookListElemet.id}/delete">
                                    <button type="submit" class="button button is-primary">Delete from list</button>
                                </a>
                            </div>
                        </nav>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<jsp:include page="/WEB-INF/views/static/footer.jsp"/>
