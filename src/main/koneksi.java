/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author AHSAN
 */
public class koneksi {
    Connection conn = null;
    public static Connection koneksi(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String host  = "jdbc:mysql://localhost:3306/db_rental_mobil";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection(host,user,password);
            System.out.println("Koneksi Berhasil");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    } 
}
