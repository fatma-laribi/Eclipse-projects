<%@page import="Metier.Article"%>
<%@page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256" import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste articles</title>
</head>
<body>

<table border="1" width="80%">
<tr>
<th>code</th> <th>Nom</th> <th>description</th> <th>quantité</th> <th>Prix</th> <th>Ajouter au panier</th>
<% ArrayList<Article> modele=(ArrayList<Article>)request.getAttribute("modele"); 
for(int i=0;i< modele.size();i++){%> 
	<tr>
<td>${modele.get(i).getId()}</td>
<td>${modele.get(i).getNom()}</td>
<td>${modele.get(i).getDescription()}</td>
<td>${modele.get(i).getQuantite()}</td>
<td>${modele.get(i).getPrix()}</td>
<td>Ajouter au panier</td>

</tr>
	
<%} %> 
</table>
</body>
</html>