
public class Parfum {
public static Parfum cassis = new Parfum("cassis");
public static Parfum chocoblanc= new Parfum("chocolat blanc");
public static Parfum chocolait= new Parfum("chocolat au lait");
public static Parfum choconoir= new Parfum("chocolat noir");
public static Parfum fraise= new Parfum("fraise");
public static Parfum framboise= new Parfum("framboise");
private String name;
	public Parfum(String s) {
		name=s;
	}
	public String toString() {
	//ToDo: implement toString
		return(name);
	}

}
