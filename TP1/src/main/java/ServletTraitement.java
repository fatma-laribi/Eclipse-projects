

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTraitement
 */
@WebServlet("/ServletTraitement")
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletTraitement() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String prefixe;
		String fonction=request.getParameter("fonction");
		String[] loisirs=request.getParameterValues("loisirs");
		if(request.getParameter("sexe") != null) {
			if (request.getParameter("sexe").equals("F")) {
				prefixe="Madame";
				}
			else prefixe="Monsieur";
			out.println( "<h2> Bonjour "+ prefixe+ " "+ nom +" "+ prenom
					+" votre fonction est : "+ fonction+" et vos loisirs sont: "+"</h2>" );}
		else {out.println( "<h2> Bonjour "+ nom +" "+ prenom
				+" votre fonction est : "+ fonction+" et vos loisirs sont: "+"</h2>" );}
		

		
				for(String loisir : loisirs ) {
					out.println("<div>"+ loisir+"</div>");
					}}
				
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
