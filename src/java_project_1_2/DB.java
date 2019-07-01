/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project_1_2;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/products_db2","root","root");

                          //JOptionPane.showMessageDialog(null,"connected");
		}catch(Exception e)
                {
                    System.out.println(e);
                      //JOptionPane.showMessageDialog(null," not connected");
                }
		return con;
	}

}

