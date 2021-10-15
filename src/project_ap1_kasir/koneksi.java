/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ap1_kasir;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER
 */
public class koneksi {
    
        public static Connection con = null;
        public static Connection ambil_koneksi(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/kasir_db","root","");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
