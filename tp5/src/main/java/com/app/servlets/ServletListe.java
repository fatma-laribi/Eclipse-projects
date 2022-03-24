package com.app.servlets;

import com.app.metier.GestUsers;
import mod.app.metier.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletListe", value = "/ServletListe")
public class ServletListe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession=request.getSession(false);
        Utilisateur user=null;
        if(maSession!=null){
            user=(Utilisateur) maSession.getAttribute("user");
        }else {
            response.sendRedirect("login.jsp");
            return;
        }

        if(user==null){
            response.sendRedirect("login.jsp");
            return;
        }
        GestUsers gu=new GestUsers();
        Vector utilisateursList=gu.lister();
        request.setAttribute("utilisateursVect",utilisateursList);
        getServletContext().getRequestDispatcher("/liste.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}