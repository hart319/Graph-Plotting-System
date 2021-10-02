package CatChart;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Doughnut extends javax.swing.JFrame {
	static	Desktop d=Desktop.getDesktop();
	private JFrame frame;
	
	private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private JButton btnEnter;
    List<String>  Xval = new ArrayList<> ();
	List<String>  Yval = new ArrayList<> ();
	String s;
    
    public Doughnut() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg) {
        		
        		String link= " https://quickchart.io/chart?c={type:'doughnut',data:{labels:" + Xval +",datasets:[{data:"+Yval+"}]},options:{plugins:{doughnutlabel:{labels:[{text:"+"'"+s+"'"+",font:{size:20}},{text:'Total'}]}}}}";

        		System.out.println(link);

        		      
        		      
        		       
        		      
        		       try {
        		      URL url = new URL(link);
        		      String nullFragment = null;
        		      URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
        		      System.out.println("URI " + uri.toString() + " is OK");
        		      d.browse(uri);
        		    } catch (MalformedURLException e) {
        		      System.out.println("URL " + link + " is a malformed URL");
        		    } catch (URISyntaxException e) {
        		      System.out.println("URI " + link + " is a malformed URL");
        		    } catch (IOException e) {
        				// TODO Auto-generated catch block
        		    	System.out.println("URI " + link + " is a malformed URL");
        				//e.printStackTrace();
        			}
        	}
        });

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graph Plotting System");

        jPanel1.setBackground(new java.awt.Color(47, 79, 79));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Insert Pie Chart Data(Doughnut Mode)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new java.awt.Color(0, 128, 128));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("X Variables/Data");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Y Variables/Data");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Plot Graph");
        
        btnEnter = new JButton();
        btnEnter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String label1,label2;
        		
		        label1=jTextField1.getText();
		        label2=jTextField2.getText();
		       
//		    
		        Xval.add("'"+label1+"'");
		        System.out.println(Xval);
		        
		        Yval.add(label2);
		        System.out.println(Yval);
		        
		        
		        int sum = 0;
		        for(int i = 0; i < Yval.size(); i ++){
		            sum  = sum + Integer.parseInt(Yval.get(i));
		        }
		        
		        s=String.valueOf(sum); 
		        System.out.println(sum);
		     
		        
		        jTextField1.requestFocus();
		        jTextField1.setText("");
		        jTextField2.requestFocus();
		        jTextField2.setText("");
        		
        		
        		
        		
        		
        	}
        	
        	
        	
        	
        });
        btnEnter.setText("Enter");
        btnEnter.setFont(new Font("Tahoma", Font.BOLD, 14));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jTextField1)
        					.addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
        			.addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addGap(30)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        			.addGap(18)
        			.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(35))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public static void main(String args[])  throws IOException  {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doughnut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doughnut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doughnut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doughnut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doughnut().setVisible(true);
            }
        });
    }
    
 
    	

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    // End of variables declaration//GEN-END:variables

