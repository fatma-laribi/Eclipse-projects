package model;

import java.util.ArrayList;
import java.util.List;

import Metier.Article;

public class ArticleModel {
private String motCle;
private int code;
public List<Article> articles = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Article> getProduits() {
return articles;
}
public void setCode(int code) {
this.code = code;
}
public int getCode() {
return code;
}
public void setArticles(List<Article> articles) {
this.articles = articles;
}
}


