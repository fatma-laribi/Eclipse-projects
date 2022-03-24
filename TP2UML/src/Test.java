import java.io.PrintWriter;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CoupeGlacee c= new Chantilly(new SauceChocolat(TripleChocolat.getInstance()));
		CoupeGlacee c2=new Chantilly(new SauceChocolat(new Cafe("robusta")));
		PrintWriter writer=new PrintWriter(System.out);
		Commande commande= new Commande();
		commande.add(c);
		commande.add(c2);
		commande.publieFacture(writer);
		System.out.println(c.description());
		writer.flush();
		writer.close();

	}

}
