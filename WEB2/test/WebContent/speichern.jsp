
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ich kann speichern!</title>
</head>
<body>

	<form action="speichern" method="post">
		<select name="typ" size="1">
			<option selected value="csv">CSV</option>
			<option value="ser">SER</option>
			<option value="xml">XML</option>
			<option value="pdf">PDF</option>
		</select>
		Dateipfad: <input type="text" name="pfad" size="20">
		 <input type="submit" name="typ" id="speichern" value="Speichern">
	</form>
	
		<form action="Client.jsp" method="post">
		<input type="submit" name="ok" value="Zurück">
	</form>

</body>
</html>