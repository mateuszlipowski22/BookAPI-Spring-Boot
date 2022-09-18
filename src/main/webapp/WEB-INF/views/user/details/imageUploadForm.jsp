<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/static/header.jsp"/>


<div class="hero-body">
    <div class="container has-text-centered">
        <div>
            <div class="tile">
                <h1>Upload user picture image</h1>
            </div>
            <div class="container">
                <div>
                    <div>
                        <form method="post" action="/user/details/image" enctype="multipart/form-data">
                            <label class="control-label">Select File</label>
                            <input id="imageFile" name="imageFile" type="file" class="file">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" class="button is-link">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/static/footer.jsp"/>