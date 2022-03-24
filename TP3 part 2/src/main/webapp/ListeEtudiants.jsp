<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="Etudiant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Etudiants</title>
</head>
<body>
<table border="1">
<% 	
ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>)request.getAttribute("etudiants");
for(Etudiant etudiant: etudiants){ %>
	<tr>
<td> ${etudiant.cin} </td>
<td> ${etudiant.nom}</td>
<td> ${etudiant.prenom}</td>
<td> ${etudiant.age}</td>
<td> ${etudiant.filiere}</td>
<td> ${etudiant.niveau}</td>
<td> <a href="SupprimerEtudiant?cin=${etudiant.cin}">supprimer</a> </td>
</tr>
	
<% } %>

</table>
</body>
</html>