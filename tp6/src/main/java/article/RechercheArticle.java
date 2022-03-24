package article;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Metier.Article;
import Metier.Catalogue;
import model.ArticleModel;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RechercheArticle() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String code= request.getParameter("code");
		ArticleModel Amodel = new ArticleModel();
		Amodel.setMotCle(name);
		Catalogue metier= new Catalogue();
		try {
		List<Article> articles = metier.rechercheArticle(code,name);
		Amodel.setArticles(articles);
		request.setAttribute("modele", Amodel);
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		PrintWriter out = response.getWriter();
		out.println(articles);
		if(!articles.isEmpty()) {
			request.getRequestDispatcher("ListeArticleTrouver.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("ArticleInexistant.jsp").forward(request, response);}
		}
		catch (Exception e) {System.out.println(e);}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String code= request.getParameter("code");
		ArticleModel Amodel = new ArticleModel();
		Amodel.setMotCle(name);
		Catalogue metier= new Catalogue();
		try {
		List<Article> articles = metier.rechercheArticle(code,name);
		Amodel.setArticles(articles);
		request.setAttribute("modele", articles);
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		PrintWriter out = response.getWriter();
		out.println(articles);
		System.out.println(articles.get(0).getDescription());
	if(!articles.isEmpty()) {
		Cookie cookie=new Cookie("cookie","existe");
		response.addCookie(cookie);
			request.getRequestDispatcher("ListeArticleTrouver.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("ArticleInexistant.jsp").forward(request, response);}
		}
		catch (Exception e) {System.out.println(e);}
		
	}

}
