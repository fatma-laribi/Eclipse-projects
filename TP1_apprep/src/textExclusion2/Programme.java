package textExclusion2;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import java.awt.Color;
import javax.swing.event.CaretListener;

import org.w3c.dom.css.RGBColor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Programme extends javax.swing.JFrame{
    static int userNumber=0;
    public static int[] currentWriters = {-1,-1,-1};
    int me;
    static ArrayList<Programme> allFrames=new ArrayList<Programme>(); 
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
    public javax.swing.JTextArea jTextArea3;
	    
    public Programme() {
    		me=userNumber;
	         userNumber++;
	         allFrames.add(this);
	         initComponents();}
	           
	    @SuppressWarnings("unchecked")
                         
	    public void initComponents() {
	    	jScrollPane2 = new javax.swing.JScrollPane();
	        jTextArea2 = new javax.swing.JTextArea();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        jTextArea3 = new javax.swing.JTextArea();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTextArea2.setColumns(20);
	        jTextArea2.setRows(5);
	        jScrollPane2.setViewportView(jTextArea2);

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jTextArea3.setColumns(20);
	        jTextArea3.setRows(5);
	        jScrollPane3.setViewportView(jTextArea3);

	        jLabel1.setText("User"+me);

	        jLabel2.setText("Section 1");

	        jLabel3.setText("No one is writing");

	        jLabel4.setText("Section 2");

	        jLabel5.setText("No one is writing");

	        jLabel6.setText("Section 3");

	        jLabel7.setText("No one is writing");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(67, 67, 67)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
	                            .addComponent(jScrollPane1)
	                            .addComponent(jScrollPane3)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                .addContainerGap(92, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel2)
	                .addGap(3, 3, 3)
	                .addComponent(jLabel3)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(39, 39, 39)
	                .addComponent(jLabel4)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLabel5)
	                .addGap(3, 3, 3)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
	                .addComponent(jLabel6)
	                .addGap(4, 4, 4)
	                .addComponent(jLabel7)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(69, 69, 69))
	        );

	        pack();

	       jTextArea1.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					currentWriters[0]=me; 
					System.out.println(" entered focus gained for text area 1");
					for(int i=0; i<allFrames.size();i++) {
						if(i!= me) allFrames.get(i).jTextArea1.setEnabled(false);
						
					}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					currentWriters[0]=-1; 
					for(int i=0; i<allFrames.size();i++) {
						allFrames.get(i).jLabel3.setText("No one is writing");
						if(i!= me) allFrames.get(i).jTextArea1.setEnabled(true);
						
					}
					
				}
	        });
	       jTextArea1.addCaretListener(new CaretListener() {
	            public void caretUpdate(javax.swing.event.CaretEvent e) {
	            	System.out.println(" entered handler");
	            	String message=jTextArea1.getText();
	            	Sender sender1 = new Sender(message,me,"mq1");
				}} ); 
	        //////////////////////////////// text area 2 ///////////////////////////////////////
	        
	        jTextArea2.addCaretListener(new CaretListener() {
	            public void caretUpdate(javax.swing.event.CaretEvent e) {
	            	System.out.println(" entered handler");
	            	String message=jTextArea2.getText();
	            	Sender sender2 = new Sender(message,me,"mq2");
				}} ); 
	        
	        jTextArea2.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					currentWriters[1]=me; 
					System.out.println(" entered focus gained for text area 2");
					for(int i=0; i<allFrames.size();i++) {
						if(i!= me) { allFrames.get(i).jTextArea2.setEnabled(false);}
						
					}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					currentWriters[1]=-1; 
					for(int i=0; i<allFrames.size();i++) {
						allFrames.get(i).jLabel5.setText("No one is writing");
						if(i!= me) allFrames.get(i).jTextArea2.setEnabled(true);
						
					}
					
				}
	        });
	        
	        ////////////////////////////////text area 3 ///////////////////////////////////////
	       
	        jTextArea3.addCaretListener(new CaretListener() {
	            public void caretUpdate(javax.swing.event.CaretEvent e) {
	            	System.out.println(" entered handler");
	            	String message=jTextArea3.getText();
	            	Sender sender3 = new Sender(message,me,"mq3");
				}} ); 
	        
	        jTextArea3.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					currentWriters[2]=me; 
					System.out.println(" entered focus gained for text area 3");
					for(int i=0; i<allFrames.size();i++) {
						if(i!= me) allFrames.get(i).jTextArea3.setEnabled(false);
						
					}
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					currentWriters[2]=-1; 
					for(int i=0; i<allFrames.size();i++) {
						allFrames.get(i).jLabel7.setText("No one is writing");
						if(i!= me) allFrames.get(i).jTextArea3.setEnabled(true);
						
					}
					
				}
	        });
	        
	        
	     
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

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Programme().setVisible(true);
	            }
	        });
	}}




