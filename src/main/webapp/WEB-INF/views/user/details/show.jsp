<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title">
                User Details<br>
            </p>
        </div>
        <table class="table is-fullwidth is-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>User name</th>
                <th>Email</th>
                <th>Active</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${currentUser.id}</td>
                <td>${currentUser.username}</td>
                <td>${currentUser.email}</td>
                <td>${currentUser.enabled}</td>
            </tr>
            </tbody>
        </table>
        <div class="container has-text-centered">
            <form method="get" action="/admin/user/list">
                <button type="submit" class="button is-link">Show user list</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>
