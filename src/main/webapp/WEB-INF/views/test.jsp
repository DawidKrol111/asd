<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Donation Form</title>
</head>
<body>
<h2>Donation Form</h2>
<form action="submit" method="post">
    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" value="${donation.quantity}" />

    <label for="categories">Categories:</label>
    <c:forEach var="category" items="${categories}">
        <input type="checkbox" name="categories" value="${category.id}" />
        <label>${category.name}</label>
    </c:forEach>

    <label for="institution">Institution:</label>
    <select id="institution" name="institution.id">
        <c:forEach var="institution" items="${institutions}">
            <option value="${institution.id}">${institution.name}</option>
        </c:forEach>
    </select>

    <label for="street">Street:</label>
    <input type="text" id="street" name="street" value="${donation.street}" />

    <label for="city">City:</label>
    <input type="text" id="city" name="city" value="${donation.city}" />

    <label for="zipCode">Zip Code:</label>
    <input type="text" id="zipCode" name="zipCode" value="${donation.zipCode}" />

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" value="${donation.phone}" />

    <label for="pickUpDate">Pick Up Date:</label>
    <input type="date" id="pickUpDate" name="pickUpDate" value="${donation.pickUpDate}" />

    <label for="pickUpTime">Pick Up Time:</label>
    <input type="time" id="pickUpTime" name="pickUpTime" value="${donation.pickUpTime}" />

    <label for="pickUpComment">Pick Up Comment:</label>
    <textarea id="pickUpComment" name="pickUpComment">${donation.pickUpComment}</textarea>

    <button type="submit">Submit</button>
</form>
</body>
</html>
