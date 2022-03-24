

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertionEtudiant
 */
@WebServlet("/InsertionEtudiant")
public class InsertionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom,prenom,filiere;
		int cin,age,niveau;
		cin=Integer.parseInt(request.getParameter("cin"));
		nom=request.getParameter("nom");
		prenom=request.getParameter("prenom");
		age=Integer.parseInt(request.getParameter("age"));
		filiere=request.getParameter("filiere");
		niveau=Integer.parseInt(request.getParameter("niveau"));
		Etudiant et=new Etudiant(nom,prenom,filiere,cin,age,niveau);
		GestionEtudiants.ajouterEtudiant(et);
		ArrayList<Etudiant> etudiants=GestionEtudiants.e; 
		PrintWriter out=response.getWriter();
		out.println("<html><body><table border=\"1px\"");
		for(Etudiant etudiant: etudiants){ 
			out.println("<tr>");
			out.println("<td>"+ etudiant.cin+ "</td>");
			out.println("<td>"+ etudiant.nom+ "</td>");
			out.println("<td>"+ etudiant.prenom+ "</td>");
			out.println("<td>"+ etudiant.age+ "</td>");
			out.println("<td>"+ etudiant.filiere+ "</td>");
			out.println("<td>"+ etudiant.niveau+ "</td>");
			out.println("<td> <a href=\"SupprimerEtudiant?cin="+etudiant.cin+"\">supprimer</a> </td>");
			out.println("</tr>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
