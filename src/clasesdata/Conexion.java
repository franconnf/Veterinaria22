/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Conexion {

    private String url;
    private String user;
    private String pass;
    private static Connection conexion;

    private Conexion() {
        url = "jdbc:mysql://localhost:3306/veterinaria22?useTimezone=false&serverTimezone=UTC";
        user = "root";
        pass = "";

        //url = "jdbc:mysql://db4free.net/veterinaria22";
        //user = "grupo22";
        //pass = "123456789";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("CANT CONNECT");
            System.out.println(ex);
        }
    }

    public static Connection getConexion() {
        try {
            if (conexion == null || !conexion.isValid(10)) {
                Conexion dataBaseConnection = new Conexion();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public static void close() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {

            }
        }
    }
}
