
public class Cafe extends Produit {
	
public String nom;
	public Cafe(String nom) {
		super();
		this.nom=nom;
	}

	@Override
	public String description() {
		return ("cafe "+nom+" ");
	}

	@Override
	public float cout() {
		return (float)1.50;
	}

}
