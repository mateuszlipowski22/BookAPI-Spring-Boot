<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body container has-text-centered">
    <div>
        <table class="table is-fullwidth is-bordered">
            <tr>
                <td>
                    <div class="container has-text-centered">
                        <p class="title">
                            Register new user<br>
                            <br>
                        </p>
                    </div>

                    <form:form modelAttribute="registrationFormDTO" method="post" action="/register">
                        <div class="field">
                            <label class="label">User Name:</label>
                            <div>
                                <form:input path="username" cssClass="input"></form:input>
                            </div>
                            <div>
                                 <form:errors path="username"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Email address:</label>
                            <div>
                                <form:input path="email" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="email"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Password:</label>
                            <div>
                                <form:password path="password" cssClass="input"></form:password>
                            </div>
                            <div>
                                <form:errors path="password"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Repeat Password:</label>
                            <div>
                                <form:password path="password2" cssClass="input"></form:password>
                            </div>
                            <div>
                                <form:errors path="password2"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label"><form:checkbox path="confirmation" cssClass="checkbox"></form:checkbox>I agree to the terms and conditions </label>
                            <div>
                                <form:errors path="confirmation"></form:errors>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">City:</label>
                            <div>
                                <form:input path="city" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="city"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Street:</label>
                            <div>
                                <form:input path="street" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="street"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">House Number:</label>
                            <div>
                                <form:input path="houseNumber" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="houseNumber"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">Phone Number:</label>
                            <div>
                                <form:input path="phoneNumber" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="phoneNumber"></form:errors>
                            </div>
                        </div>
                        <div class="field">
                            <label class="label">About Me:</label>
                            <div>
                                <form:input path="aboutMe" cssClass="input"></form:input>
                            </div>
                            <div>
                                <form:errors path="aboutMe"></form:errors>
                            </div>
                        </div>

                        <br>
                        <div>
                            <input type="submit" class="button is-link" value="Register"/>
                        </div>
                    </form:form>
                </td>
            </tr>
        </table>
    </div>
</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>