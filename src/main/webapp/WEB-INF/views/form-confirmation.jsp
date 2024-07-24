<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<div class="slogan container container--90">
    <h2>
        Dziękujemy za przesłanie formularza. Na maila prześlemy wszelkie
        informacje o odbiorze.
    </h2>

    <div class="summary">
        <div class="form-section">
            <h4>Oddajesz:</h4>
            <ul>
                <li>
                    <span class="icon icon-bag"></span>
                    <span class="summary--text">${donation.quantity} worki ${donation.categories}</span>
                </li>
                <li>
                    <span class="icon icon-hand"></span>
                    <span class="summary--text">Dla fundacji "${donation.institution.name}"</span>
                </li>
            </ul>
        </div>

        <div class="form-section form-section--columns">
            <div class="form-section--column">
                <h4>Adres odbioru:</h4>
                <ul>
                    <li>${donation.street}</li>
                    <li>${donation.city}</li>
                    <li>${donation.zipCode}</li>
                    <li>${donation.phone}</li>
                </ul>
            </div>

            <div class="form-section--column">
                <h4>Termin odbioru:</h4>
                <ul>
                    <li>${donation.pickUpDate}</li>
                    <li>${donation.pickUpTime}</li>
                    <li>${donation.pickUpComment}</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>


