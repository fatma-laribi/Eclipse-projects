<%@page import="mod.app.metier.Utilisateur"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue</title>
</head>
<% Utilisateur user=(Utilisateur) session.getAttribute("user");%>
<body>
<% if (user!=null) { %>
    <ul>
        <li>Id User :<%=user.getIdUser()%></li>
        <li>Login :<%=user.getLogin()%></li>
        <li>Pass :<%=user.getPass()%></li>
        <li>Email :<%=user.getEmail()%> </li>
        <li>Ville :<%=user.getVille()%></li>
        
    </ul>
<a href="ajout.jsp">Ajouter des utilisateurs</a>
<a href="ServletListe">Lister les utilisateurs</a>
<% } else { %>
    <p>vous n'êtes pas authentifier</p>
    <a href="login.jsp">Go to Login</a>
<% } %>
</body>
</html>