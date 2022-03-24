package Metier;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 


import dao.Utilitaire;
public class Catalogue {
	public ArrayList<Article> rechercheArticle(String code,String mc) throws ClassNotFoundException, SQLException { 
	ArrayList<Article> prods= new ArrayList<Article>(); 
	Connection conn=Utilitaire.getConnection();
	mc=mc.toLowerCase();

	try {
	PreparedStatement ps=null;
	if(!mc.equals(null) && !(code==null)) {
		ps=conn.prepareStatement("select * from article where (nom LIKE ? or code LIKE ?) ");
		ps.setString(1, "%"+mc+"%");
		ps.setString(2, "%"+code+"%");}
	else if(mc.equals(null)) {
		ps=conn.prepareStatement("select * from article where (code LIKE ?) ");
		ps.setString(1, "%"+code+"%");
	}
	else if(code==null) {
		ps=conn.prepareStatement("select * from article where (nom LIKE ?) ");
		ps.setString(1, "%"+mc+"%");
	}
	ResultSet rs = ps.executeQuery(); 
	while (rs.next()) {
	Article p = new Article(); 
	p.setId(rs.getInt("code")); 
	p.setNom(rs.getString("nom")); 
	p.setPrix(rs.getFloat("prix")); 
	p.setDescription(rs.getString("description"));
	p.setQuantite(rs.getInt("quantite"));
	prods.add(p);
	}
	} catch (SQLException e) { 
	e.printStackTrace();
	}
	return prods;
	}
	public void addArticle(Article p) {
	// TODO Auto-generated method stub
	}
	}

