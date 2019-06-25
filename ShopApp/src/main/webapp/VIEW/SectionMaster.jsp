<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addSection" method="post">
<table>


<tr>
				<td>STUDENTCLASS: <select name="studentClass" id="test"
					onchange="removeDet();">
						<option></option>
						<option value="0.1">play</option>
						<option value="0.2 ">L.K.G</option>
						<option value="0.3">U.K.G</option>
						<option value="1 ">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>

				</select>
				<td><input type="text" name="section" placeholder="section"></td>
				<td><input type="submit" value="submit">
			</tr>
			
			
			
			
</table>
</form>
</body>
</html>