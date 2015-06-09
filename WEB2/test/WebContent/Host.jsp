<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Game</title>
</head>
<body>
<h1>Creating Game as Host</h1>
<form action="Lobby" method="post">
Host
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
<br>
<br>
Anzahl Spieler
<br>
<input name="param2" type="number" size="20" min="2" max="4" value="2"></input>
<input type="hidden" name="type" value="host"></input>

<input id="senden" type="submit" value="create Lobby"></input>
</form>

</body>
</html>