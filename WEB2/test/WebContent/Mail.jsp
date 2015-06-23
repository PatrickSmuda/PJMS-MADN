<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>E-mail versenden</h2>
<form action="MailServlet" method="post">
<table>
<tr>
<td>
E-mail
</td>
<td>
Betreff
</td>
<td>
Text
</td>
<td>
Anhang
</td>
</tr>
<tr>
<td>
<input type="text" name="address">
</td>
<td>
<input type="text" name="betreff">
</td>
<td>
<input type="text" name="text" height="50">
</td>
<td>
<input type="text" name="anhang">
</td>
<td>
<input type="submit" value="senden">
</td>
</tr>
</table>


</form>
</body>
</html>