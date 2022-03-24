public class FruitsRouges extends CoupeGlacee {
public static final FruitsRouges SINGLETON = new FruitsRouges();
private FruitsRouges() {
this.parfums.add(Parfum.fraise);
this.parfums.add(Parfum.framboise);
this.parfums.add(Parfum.cassis);
}
public float cout() {
return 6;
}
public static FruitsRouges getInstance() {
	return SINGLETON;
	
}
}
