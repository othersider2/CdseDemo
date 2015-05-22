<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>${headerMessage}</h1>
 
	<h3>Photo ${person.photoPart} has been uploaded for</h3>

	<table>
		<tr>
			<td>First Name :</td>
			<td>${person.firstName}</td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td>${person.lastName}</td>
		</tr>
		<tr>
			<td>Roles :</td>
			<td>${person.roles}</td>
		</tr>

	</table>

</body>
</html>
