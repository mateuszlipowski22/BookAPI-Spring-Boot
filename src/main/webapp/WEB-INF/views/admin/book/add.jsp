<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div class="container has-text-centered">
            <p class="title">
                Add New Book<br>
            </p>
        </div>
        <table class="table is-fullwidth is-bordered">
            <form:form modelAttribute="bookDto" method="post" action="/admin/book/add">
                <div class="field">
                    <label class="label">Title</label>
                    <div>
                        <form:input path="title" cssClass="input"></form:input>
                    </div>
                    <div>
                        <form:errors path="title"></form:errors>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Author</label>
                    <div>
                        <form:input path="author" cssClass="input"></form:input>
                    </div>
                    <div>
                        <form:errors path="author"></form:errors>
                    </div>
                </div>
                <div class="field">
                    <label class="label">Publisher</label>
                    <div>
                        <form:input path="publisher" cssClass="input"></form:input>
                    </div>
                    <div>
                        <form:errors path="publisher"></form:errors>
                    </div>
                </div>
                <div class="field">
                    <label class="label">ISBN</label>
                    <div>
                        <form:input path="isbn" cssClass="input"></form:input>
                    </div>
                    <div>
                        <form:errors path="isbn"></form:errors>
                    </div>
                </div>
                <div class="field">
                    <label class="label">type</label>
                    <div>
                        <form:input path="type" cssClass="input"></form:input>
                    </div>
                    <div>
                        <form:errors path="type"></form:errors>
                    </div>
                </div>
                <div class="control">
                    <button type="submit" class="button is-link">Add Book</button>
                </div>
            </form:form>
        </table>
    </div>
</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>

