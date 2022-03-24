public class TripleChocolat extends CoupeGlacee {
public static final TripleChocolat SINGLETON = new TripleChocolat();
private TripleChocolat() {
this.parfums.add(Parfum.chocoblanc);
this.parfums.add(Parfum.chocolait);
this.parfums.add(Parfum.choconoir);
}
public float cout() {
return (float)6;
}
public static TripleChocolat getInstance() {
	return SINGLETON;
	
}
}
