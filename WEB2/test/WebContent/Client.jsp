<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
</head>
<body>
<h1>Enter Game Lobby</h1>
<form action="Lobby" method="post">
Client
<br>
<input name="param1" type="text" size="20"></input>
<select name="color">
<option>Rot</option>
<option>Blau</option>
<option>Gruen</option>
<option>Gelb</option>
</select>
<select name="ki">
<option>Mensch</option>
<option>Defensive KI</option>
<option>Offenssive KI</option>
</select>
<input type="hidden" name="type" value="client"></input>

<input id="senden" type="submit" value="join Lobby"></input>

</form>

		<form action="Speichern.jsp" method="post">
		<input type="submit" name="ok" value="Speichern">
	</form>
</body>
</html>