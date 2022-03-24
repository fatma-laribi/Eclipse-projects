<%@page import="mod.app.metier.Utilisateur"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout</title>
</head>
<% Utilisateur user=(Utilisateur) session.getAttribute("user"); %>
<body>
${requestScope.error}
<% if (user!=null) { %>
<FORM METHOD="POST" action="ServletAjouter">
  <P> Please enter the infos
  <P> email: <INPUT NAME="email" type="text" SIZE=" 12" MAXLENGTH=" 20">
  <P> ville: <INPUT NAME="ville" type="text" SIZE=" 12" MAXLENGTH=" 20">
  <P> login: <INPUT NAME="login" type="text" SIZE=" 12" MAXLENGTH=" 20">
  <P> password: <INPUT NAME="password" type="password" SIZE=" 12" MAXLENGTH=" 20">
  <P> Thank you! <INPUT TYPE="SUBMIT"></P>
</FORM>
<% } else { %>
<p>vous n'êtes pas authentifié</p>
<a href="Login.jsp">Go to Login</a>
<% } %>
</body>
</html>