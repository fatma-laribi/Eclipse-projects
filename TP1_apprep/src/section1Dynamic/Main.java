package section1Dynamic;


public class Main {

	public static void main(String[] args) {
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	int n=3;
	            			//Integer.parseInt(args[0]);
	            /*	for(int i=0;i<n;i++) {
	            		User.allSections.add(new Group());
	            		
	            	}*/
	            	User.nbSections=n;
	            	for(int i=0;i<n;i++) {
	            		new User().setVisible(true);
	            	}
	            	
	            	Receiver receiver= new Receiver(n);
	            	receiver.setVisible(true);
	            	
	            }

		 });
    }
}
