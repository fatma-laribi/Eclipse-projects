	import java.util.*;
	public abstract class CoupeGlacee extends Produit{
	protected List<Parfum> parfums;
	protected CoupeGlacee() {
		parfums=new ArrayList<Parfum>();
	}
	
	public String description() {
	StringBuffer sb = new StringBuffer("");
	for(Iterator it = parfums.iterator();it.hasNext();) {
	sb.append(it.next().toString());
	sb.append(" ");
	}
	return "Une coupe "+sb.toString();
	}
	
	public abstract float cout();
	}

