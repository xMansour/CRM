<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Form</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h1>CRM - Customer Relationship Manager</h1>
    </div>
    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td><label>First Name: </label></td>
                    <td><form:input path="firstName"/></td>
                </tr>

                <tr>
                    <td><label>Last Name: </label></td>
                    <td><form:input path="lastName"/></td>
                </tr>


                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"/></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
                </tbody>
            </table>


        </form:form>

        <br>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>
</div>

</body>
</html>