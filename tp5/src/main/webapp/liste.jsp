<%@ page import="mod.app.metier.Utilisateur" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 15/11/2021
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listes des utilisateurs</title>
</head>
<body>

<% Utilisateur user=(Utilisateur) session.getAttribute("user");
  Vector<Utilisateur> utilisateurs=(Vector<Utilisateur>) request.getAttribute("utilisateursVect");%>

<% if (user!=null) { %>
<% if (utilisateurs==null) { %>
    <p>Pas d'utilisateurs</p>
<% } else { %>
    <% for(int i=0;i<utilisateurs.size();i++) { %>
        <ul>
            <li>Id User :<%=utilisateurs.get(i).getIdUser() %></li>
            <li>Login :<%=utilisateurs.get(i).getLogin()%></li>
            <li>Pass :<%=utilisateurs.get(i).getPass()%></li>
            <li>Email :<%=utilisateurs.get(i).getEmail()%> </li>
            <li>Ville :<%=utilisateurs.get(i).getVille()%></li>
            <li><a href="ServletSuppression?id=<%= utilisateurs.get(i).getIdUser()%>">Supprimer</a></li>
        </ul>
    <% } %>
<% } %>
<% } else { %>
<p>vous n'êtes pas authentifier</p>
<a href="Login.jsp">Go to Login</a>
<% } %>
<a href="bienvenue.jsp">Go to Bienvenue</a>

</body>
</html>