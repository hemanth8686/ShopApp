<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="register" 
enctype="multipart/form-data">
<table  border="10"  >
<tr>
<td>
FIRSTNAME:<input type="text" name="firstName" >
</td>

</tr>
<tr>
<td>
LASTNAME:<input type="text" name="lastName" >
</td>

</tr>
<tr>
<td>
Gender:<select name="gender">
<option value="Male" >Male</option>
<option value="Female">Female</option>
</select>
</td>

</tr>
<tr>
<td>
MotherName:<input type="text" name="motherName" >
</td>

</tr>
<tr>
<td>
FatherName:<input type="text" name="fatherName" >
</td>

</tr>
<tr>
<td>
Student photo<input type="file" name="studentPhoto" >
</td>

</tr>


<tr>
<td>
MOBILE:<input type="text" name="mobile" >
</td>

</tr>
<tr>
<td>
AGE:<input type="text" name="age" >
</td>

</tr>
<tr>
<td>
EMAIL:<input type="text" name="email" >
</td>

</tr>
<tr>
<td>
PASSWORD:<input type="password" name="password" >
</td>

</tr>
<tr>
<td>
DATEOFBIRTH:<input type="date" name="dateOfBirth" value="DATEOFBIRTH">
</td>

</tr>
<tr>
<td >
Address:<textarea rows="3" cols="" name="address"></textarea>
</td>

</tr>


<tr>
<td>
BloodGroup:<input type="text" name="bloodGroup" >
</td>

</tr>

<tr>
<td>
<input type="submit" value="submit">
</td>


</table>

</form>

</body>
</html>