<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title">
                Set date when you plan to start reading the book
                <br>
                <br>
            </p>
        </div>
        <form:form modelAttribute="userBookList" method="post" action="/user/book/${userBookList.id}/planReading">
            <div class="field">
                <label class="label">Start reading book date</label>
                <div>
                    <form:input path="plannedToReadDate" cssClass="input" type="date"></form:input>
                </div>
                <div>
                    <form:errors path="plannedToReadDate" ></form:errors>
                    <form:hidden path="id"></form:hidden>
                </div>
            </div>
            <div class="control">
                <button type="submit" class="button is-link">Set Date</button>
            </div>
        </form:form>
    </div>
</div>


<jsp:include page="/WEB-INF/views/static/footer.jsp"/>
