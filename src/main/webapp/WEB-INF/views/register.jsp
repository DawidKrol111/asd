<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" method="post" modelAttribute="user">

        <div class="form-group">
            <form:label path="username">Login:</form:label>
            <form:input path="username" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="password">Hasło:</form:label>
            <form:password path="password" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input path="email" required="required"/>
        </div>
        <button type="submit">Zarejestruj</button>
    </form:form>
</section>

<%@ include file="footer.jsp" %>


