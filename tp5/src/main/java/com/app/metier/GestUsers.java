package com.app.metier;
import com.app.GestUsersDAO;
import mod.app.metier.Utilisateur;
import java.util.Vector;
/**
*
* @author USER
*/
public class GestUsers { 
GestUsersDAO dao; 
public GestUsers()
{
dao=new GestUsersDAO();
}
public Utilisateur Chercher(String login, String pass){
return dao.loadUser(login, pass);
}
public void ajouter(Utilisateur u){
dao.addUser(u.getLogin(), u.getPass(),u.getEmail(),u.getVille());
}
public Vector lister(){
return dao.selectAll();
}
}
