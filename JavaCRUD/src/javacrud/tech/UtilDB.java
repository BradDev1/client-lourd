/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.sql.Connection; // entre la déclaration du package et de la classe
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b.chesneau
 */
public class UtilDB {

    static Connection con;
    static String url = "jdbc:mysql://localhost:3306/gestion_utilisateur";
    static String user = "root";
    static String pass = "";
    public static Connection getConnect() throws Exception{
        if(con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url ,user, pass);
            System.out.println(con.getClientInfo());
            
        }
        return con;
    }
}
