/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.sql.*;
public class MyConnection {
    
//    public static void main(String[] args) {
//    	 
//    	createAndShowGui();}
    
    public static Connection getConnection(){
       
     Connection con = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con =  DriverManager.getConnection("jdbc:mysql://localhost/ graphplotter ", "root" , "");
           } catch (Exception ex){
               System.out.println(ex.getMessage());
               
           }
        return con;
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
