package com.app.servlets;

import com.app.metier.GestUsers;
import mod.app.metier.Utilisateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSuppression", value = "/ServletSuppression")
public class ServletSuppression extends HttpServlet {
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
        String id=request.getParameter("id");
        if (id == "" || id.trim() == "") {
            request.setAttribute("error","Pas d'id insérer");
            getServletContext().getRequestDispatcher("/ServletListe").forward(request,response);
        }
        GestUsers gu=new GestUsers();
        boolean done=gu.supprimer(id);
        getServletContext().getRequestDispatcher("/ServletListe").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}