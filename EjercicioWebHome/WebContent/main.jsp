<%@page import="com.home.htmlform.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession httpSession = request.getSession();
Usuario usuario = (Usuario)httpSession.getAttribute("USUARIO");
%>
<%if (usuario==null){%>

<form action="LoginHome" method="post">
First name:<br>
<input type="text" name="firstname">
<br>
Last name:<br>
<input type="text" name="lastname">
<br>
<input type="submit" value="Enter">

</form>
<%}else{

if (usuario.getWeight()==null && usuario.getHeight()==null && usuario.getPhoneNum()==null){%>

<form action="LoginHome" method="post">
Weight:<br>
<input type="text" name="weight">
<br>
Height:<br>
<input type="text" name="height">
<br>
Phone Number:<br>
<input type="text" name="phone">
<br>
<input type="submit" value="Submit">
</form>
<%}else{ %>

<h2> Tu nombre completo es <%= usuario.getName() %> <%= usuario.getSurname() %>.</h2>
<br>
<h2> Pesas <%= usuario.getWeight() %> kilogramos y mides <%= usuario.getHeight() %> centímetros.</h2>
<br>
<h2> Tu número de teléfono es <%= usuario.getPhoneNum()%> </h2>


<%}%>
<%}%>

</body>
</html>