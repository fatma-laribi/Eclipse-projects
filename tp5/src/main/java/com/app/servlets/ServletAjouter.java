package com.app.servlets;

import com.app.metier.GestUsers;
import mod.app.metier.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAjouter", value = "/ServletAjouter")
public class ServletAjouter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession=request.getSession(false);
        if(maSession==null){
            response.sendRedirect("Login.jsp");
            return;
        }
        Utilisateur user=(Utilisateur) maSession.getAttribute("user");
        if(user==null){
            response.sendRedirect("Login.jsp");
            return;
        }
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email=request.getParameter("email");
        String ville=request.getParameter("ville");
        
        if(login=="" || password=="" || email=="" || ville==""){
            request.setAttribute("error","SOMETHING IS MISSING");
            getServletContext().getRequestDispatcher("/ajout.jsp").forward(request,response);
        }
        GestUsers gu=new GestUsers();
        Utilisateur newUser=new Utilisateur();
        newUser.setEmail(email);
        newUser.setVille(ville);
        newUser.setLogin(login);
        newUser.setPass(password);
        System.out.println(newUser);
        gu.ajouter(newUser);
        response.sendRedirect("ServletListe");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}