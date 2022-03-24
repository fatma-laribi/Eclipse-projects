

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupprimerEtudiant
 */
@WebServlet("/SupprimerEtudiant")
public class SupprimerEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cin;
		cin=Integer.parseInt(request.getParameter("cin"));
		GestionEtudiants.supprimerEtudiant(cin);
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
