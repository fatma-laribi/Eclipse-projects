
public class Context {
	private Strategy s;

	public Context() {
		// TODO Auto-generated constructor stub
	}
	
	public void setVue(Strategy vue) {
		this.s=vue;
	}
	public void executeStrategy() {
		s.afficher();
	}
}
