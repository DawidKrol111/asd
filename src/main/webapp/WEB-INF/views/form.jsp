<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form action="/submit" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach var="category" items="${categories}">
                    <div class="form-group form-group--checkbox">

                        <label>

                            <input type="checkbox" name="categories" value="${category.id}"/>
                            <span class="checkbox"></span>
                            <span class="description">${category.name}</span>

                        </label>
                    </div>
                </c:forEach>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">

                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>
                <div class="form-group form-group--inline">

                    <label for="quantity">Liczba 60l worków:</label>
                    <input type="number" id="quantity" name="quantity" value="${donation.quantity}"/>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <div data-step="3">

            <h3>Wybierz organizacje, której chcesz pomóc:</h3>
            <div class="form-group form-group--checkbox">

                <c:forEach var="institution" items="${institutions}">
                    <label>
                        <input type="radio" name="institution" value="${institution.id}"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                        <div class="title">${institution.name}</div>
                        <div class="subtitle">${institution.description}</div>
                    </span>
                    </label>
                </c:forEach>
            </div>
            <div class="form-group form-group--buttons">
                <button type="button" class="btn prev-step">Wstecz</button>
                <button type="button" class="btn next-step">Dalej</button>
            </div>


            </div>
            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <input type="text" id="street" name="street" value="${donation.street}" /></label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <input type="text" id="city" name="city" value="${donation.city}" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Kod pocztowy <input type="text" id="zipCode" name="zipCode" value="${donation.zipCode}" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Numer telefonu <input type="text" id="phone" name="phone" value="${donation.phone}" />
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <input type="date" id="pickUpDate" name="pickUpDate" value="${donation.pickUpDate}" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <input type="time" id="pickUpTime" name="pickUpTime" value="${donation.pickUpTime}" /></label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Uwagi dla kuriera
                                <textarea id="pickUpComment" rows="5" name="pickUpComment">${donation.pickUpComment}</textarea>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form>
    </div>
</section>

<%@ include file="footer.jsp" %>


