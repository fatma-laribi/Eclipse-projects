

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(name="cs",urlPatterns= {"/FirstServlet"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.getRequestDispatcher("vue.jsp").forward(request, response);
		int nbLig=Integer.parseInt(request.getParameter("lig"));
		int nbCol=Integer.parseInt(request.getParameter("col"));
		PrintWriter out= response.getWriter();
		out.println("<html><body><table border=\"1px\">");
		for(int i=0; i< nbLig; i++) {
			out.println("<tr>");
			for(int j=0; j<nbCol;j++) {
				out.println("<td>*</td>");
			}
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
