

public class CoulisFraise extends Toppings{

	public CoulisFraise(CoupeGlacee c) {
		super(c);
	}
	public float cout() {
		return coupe.cout()+(float)1;
	}
	public String description() {
		return (super.description()+" au coulis de fraises fraiches ");
	}


}