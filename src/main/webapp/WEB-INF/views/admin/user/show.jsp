<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container">
        <div class="tile is-ancestor">
            <div class="tile is-4 is-vertical is-parent">
                <div class="tile is-child box">

                    <p class="title">
                        User Details<br>
                    </p>

                </div>
            </div>
            <div class="tile is-parent">
                <div class="tile is-child box">
                    <div class="field">
                        <label class="label">City:</label>
                        <div>
                            ${user.userDetails.city}
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Street:</label>
                        <div>
                            ${user.userDetails.street}
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">House Number:</label>
                        <div>
                            ${user.userDetails.houseNumber}
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Phone Number:</label>
                        <div>
                            ${user.userDetails.phoneNumber}
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Account creation date:</label>
                        <div>
                            ${user.userDetails.createdOn}
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">About Me:</label>
                        <div>
                            ${user.userDetails.aboutMe}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="tile is-ancestor">
            <div class="tile is-parent">
                <div class="tile is-child box is-vertical">
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
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.enabled}</td>
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
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/views/static/footer.jsp"/>
