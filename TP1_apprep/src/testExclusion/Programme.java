package testExclusion;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import javax.swing.event.CaretListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Programme extends javax.swing.JFrame{
    static int userNumber=0;
    static int currentWriter=-1;
    int me;
    static ArrayList<Programme> allFrames=new ArrayList<Programme>(); 
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
	    
    public Programme() {
    		me=userNumber;
	         userNumber++;
	         allFrames.add(this);
	         initComponents();}
	           
	    @SuppressWarnings("unchecked")
                         
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTextArea2 = new javax.swing.JTextArea();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setText("User"+me);

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5); 
	        jScrollPane1.setViewportView(jTextArea1);

	        jLabel3.setText("Section 1");

	        jLabel4.setText("Section 2");
	        jLabel5.setText("No one is writing");
	        jTextArea2.setEditable(false);
	        jTextArea2.setColumns(20);
	        jTextArea2.setRows(5);
	        jScrollPane2.setViewportView(jTextArea2);
	        
	        jTextArea1.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					currentWriter=me; 
					System.out.println(" entered focus gained");
					for(int i=0; i<allFrames.size();i++) {
						if(i!= me) allFrames.get(i).jTextArea1.setEditable(false);
						
					}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					currentWriter=-1;
					for(int i=0; i<allFrames.size();i++) {
						allFrames.get(i).jLabel5.setText("No one is writing");
						if(i!= me) allFrames.get(i).jTextArea1.setEditable(true);
						
					}
					
				}
	        });
	        
	        
	        jTextArea1.addCaretListener(new CaretListener() {
	            public void caretUpdate(javax.swing.event.CaretEvent e) {
	            	System.out.println(" entered handler");
	            	String message=jTextArea1.getText();
	            	Sender1 sender1 = new Sender1(message,me);
				}} ); 
	        
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGap(0, 69, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        	.addComponent(jLabel5,javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jScrollPane2))
	                        .addGap(71, 71, 71))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jLabel1)
	                .addGap(8, 8, 8)
	                .addComponent(jLabel5)
	                .addGap(18, 18, 18)
	                .addComponent(jLabel3)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(44, 44, 44)
	                .addComponent(jLabel4)
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(16, Short.MAX_VALUE))
	        );

	        pack();
	    }
	   // </editor-fold>                                                             
	    public static void main(String args[]) {

	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Programme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Programme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Programme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Programme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	       
	        
	    }
	}




