<%@page import="sun.util.logging.resources.logging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTML Table</title>
<style>
a {text-decoration:none}
a {color:#000000}
/*td#SR1, td#SR2, td#SR3, td#SR4 {  
    background-color: red;
}
td#SB1, td#SB2, td#SB3, td#SB4 {  
    background-color: blue;
}
td#SGr1, td#SGr2, td#SGr3, td#SGr4 {  
    background-color: green;
}
td#SG1, td#SG2, td#SG3, td#SG4 {  
    background-color: yellow;
}*/
</style>
</head>
<body>

<table id="spielbrett" border="8">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="SR1"><a href="htmlServlet">SR1</a></td>
		<td id="SR2"><a href="htmlServlet">SR2</a></td>
		<td></td>
		<td></td>
		<td id="9"><a href="htmlServlet">9</a></td>
		<td id="10"><a href="htmlServlet">10</a></td>
		<td id="11"><a href="htmlServlet">11</a></td>
		<td></td>
		<td></td>
		<td id="SB1"><a href="htmlServlet">SB1</a></td>
		<td id="SB2"><a href="htmlServlet">SB2</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="SR3"><a href="htmlServlet">SR3</a></td>
		<td id="SR4"><a href="htmlServlet">SR4</a></td>
		<td></td>
		<td></td>
		<td id="8"><a href="htmlServlet">8</a></td>
		<td id="EB1"><a href="htmlServlet">EB1</a></td>
		<td id="12"><a href="htmlServlet">12</a></td>
		<td></td>
		<td></td>
		<td id="SB3"><a href="htmlServlet">SB3</a></td>
		<td id="SB4"><a href="htmlServlet">SB4</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td id="7"><a href="htmlServlet">7</a></td>
		<td id="EB2"><a href="htmlServlet">EB2</a></td>
		<td id="13"><a href="htmlServlet">13</a></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td id="6"><a href="htmlServlet">6</a></td>
		<td id="EB3"><a href="htmlServlet">EB3</a></td>
		<td id="14"><a href="htmlServlet">14</a></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="1"><a href="htmlServlet">1</a></td>
		<td id="2"><a href="htmlServlet">2</a></td>
		<td id="3"><a href="htmlServlet">3</a></td>
		<td id="4"><a href="htmlServlet">4</a></td>
		<td id="5"><a href="htmlServlet">5</a></td>
		<td id="EB4"><a href="htmlServlet">EB4</a></td>
		<td id="15"><a href="htmlServlet">15</a></td>
		<td id="16"><a href="htmlServlet">16</a></td>
		<td id="17"><a href="htmlServlet">17</a></td>
		<td id="18"><a href="htmlServlet">18</a></td>
		<td id="19"><a href="htmlServlet">19</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="40"><a href="htmlServlet">40</a></td>
		<td id="ER1"><a href="htmlServlet">ER1</a></td>
		<td id="ER2"><a href="htmlServlet">ER2</a></td>
		<td id="ER3"><a href="htmlServlet">ER3</a></td>
		<td id="ER4"><a href="htmlServlet">ER4</a></td>
		<td></td>
		<td id="EGr4"><a href="htmlServlet">EGr4</a></td>
		<td id="EGr3"><a href="htmlServlet">EGr3</a></td>
		<td id="EGr2"><a href="htmlServlet">EGr2</a></td>
		<td id="EGr1"><a href="htmlServlet">EGr1</a></td>
		<td id="20"><a href="htmlServlet">20</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="39"><a href="htmlServlet">39</a></td>
		<td id="38"><a href="htmlServlet">38</a></td>
		<td id="37"><a href="htmlServlet">37</a></td>
		<td id="36"><a href="htmlServlet">36</a></td>
		<td id="35"><a href="htmlServlet">35</a></td>
		<td id="EG4"><a href="htmlServlet">EG4</a></td>
		<td id="25"><a href="htmlServlet">25</a></td>
		<td id="24"><a href="htmlServlet">24</a></td>
		<td id="23"><a href="htmlServlet">23</a></td>
		<td id="22"><a href="htmlServlet">22</a></td>
		<td id="21"><a href="htmlServlet">21</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td id="34"><a href="htmlServlet">34</a></td>
		<td id="EG3"><a href="htmlServlet">EG3</a></td>
		<td id="26"><a href="htmlServlet">26</a></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td id="33"><a href="htmlServlet">33</a></td>
		<td id="EG2"><a href="htmlServlet">EG2</a></td>
		<td id="27"><a href="htmlServlet">27</a></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="SG1"><a href="htmlServlet">SG1</a></td>
		<td id="SG2"><a href="htmlServlet">SG2</a></td>
		<td></td>
		<td></td>
		<td id="32"><a href="htmlServlet">32</a></td>
		<td id="EG1"><a href="htmlServlet">EG1</a></td>
		<td id="28"><a href="htmlServlet">28</a></td>
		<td></td>
		<td></td>
		<td id="SGr1"><a href="htmlServlet">SGr1</a></td>
		<td id="SGr2"><a href="htmlServlet">SGr2</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td id="SG3"><a href="htmlServlet">SG3</a></td>
		<td id="SG4"><a href="htmlServlet">SG4</a></td>
		<td></td>
		<td></td>
		<td id="31"><a href="htmlServlet">31</a></td>
		<td id="30"><a href="htmlServlet">30</a></td>
		<td id="29"><a href="htmlServlet">29</a></td>
		<td></td>
		<td></td>
		<td id="SGr3"><a href="htmlServlet">SGr3</a></td>
		<td id="SGr4"><a href="htmlServlet">SGr4</a></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>

<form action="htmlServlet" method="post"><input type="submit" id="wurfeln" name="type" value="wurfeln"></form>
<form action="htmlServlet" method="post"><input type="submit" id="bewegen" name="type" value="bewegen"></form>

<textarea id="logg" name="logg" cols="80" rows="10" readonly></textarea>
</form>

</body>
</html>