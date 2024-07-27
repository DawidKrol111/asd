<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<section class="login-page">
    <div class="container">
        <h2>Zaloguj się</h2>
        <form method="post">
            <div class="form-group"><label> Login : <input type="text" name="username"/> </label></div>
            <div class="form-group"><label> Hasło: <input type="password" name="password"/> </label></div>
            <div class="form-group"> <button type="submit">Zaloguj</button></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div class="spacer"></div>
        <a href="/problem"> Nie pamiętam hasła</a>

    </div>
</section>

<%@ include file="footer.jsp" %>


