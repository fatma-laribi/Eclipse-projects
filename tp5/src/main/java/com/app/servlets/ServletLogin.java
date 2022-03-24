package com.app.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.app.metier.*;

import mod.app.metier.Utilisateur;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login==""  || password=="" ){
            request.setAttribute("error","SOMETHING IS MISSING");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
      
        
        }
        GestUsers gu=new GestUsers();
        Utilisateur user=gu.Chercher(login,password);
        if(user!=null){
            HttpSession maSession = request.getSession(true);
            maSession.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request,response);
        }else {
            request.setAttribute("error","Il n'y a pas de user avec cette combinaison!");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
        }


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);

    }

}
