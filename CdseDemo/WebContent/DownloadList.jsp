<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SharpE CDSE Demo</title>
</head>
<body>
	<center>
		<h1>SharpE CDSE Demo</h1>
		<form action="/CdseDemo/getListUsingId.html" method="post"
			enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>Person ID:</td>
					<td><input type="text" name="personId" size="5" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName" size="50" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" size="50" /></td>
				</tr>
				<tr>
					<td>Portrait Photo:</td>
					<td><input type="file" name="photoPart" size="50" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>