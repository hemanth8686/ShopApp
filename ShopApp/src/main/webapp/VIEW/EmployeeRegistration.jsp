<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EmployeeRegister " method="post">
<table>
<tr>
<td>
EMPLOYEE FIRSTNAME:<input type="text" name="employeeFirstName">

</td>
</tr>
<tr>
<td>
EMPLOYEE LASTNAME:<input type="text" name="employeeLastName">

</td>
</tr>
<tr>
<td>
EMPLOYEE MOBILE:<input type="text" name="employeeNumber">

</td>
</tr>
<tr>
<td>
EMPLOYEE PASSWORD:<input type="password" name="employeePassword">

</td>
</tr>
<tr>
<td>
GENDER:<select name="gender">
<option value="male">MALE</option>
<option value="female">FEMALE</option>
</select>
</td>
</tr>
<tr>
<td>
EMPLOYEE Email:<input type="text" name="employeeEmail">

</td>
</tr>
<tr>
<td>
EMPLOYEE AGE:<input type="text" name="employeeAge">

</td>
</tr>
<tr>
<td>
EMPLOYEE NAME:<input type="text" name="employeeName">

</td>
</tr>

<tr>
<td>
<input type="submit" value="submit">
</td>
</tr>
</table>

</form>

</body>
</html>