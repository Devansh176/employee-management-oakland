<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h2>Employee Registration</h2>

<form:form method="post" modelAttribute="employee" action="register">
    Name: <form:input path="name"/><br/>
    DOB: <form:input path="dob" type="date"/><br/>
    Gender: <form:input path="gender"/><br/>
    Address: <form:input path="address"/><br/>
    City: <form:input path="city"/><br/>
    State: <form:input path="state"/><br/>
    Login ID: <form:input path="loginId"/><br/>
    Password: <form:input path="password"/><br/>
    <input type="submit" value="Register"/>
</form:form>