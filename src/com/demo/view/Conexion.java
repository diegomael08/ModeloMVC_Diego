/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Conexion {
    private static Connection conectarse_mysql;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String password="";
    private static final String url="jdbc:mysql://localhost:3306/Usuarios";
    
    public Conexion(){
        conectarse_mysql=null;
        try {
            Class.forName(driver);
            conectarse_mysql = DriverManager.getConnection(url, user, password);
            if (conectarse_mysql!=null) {
                JOptionPane.showMessageDialog(null, "Conexion a MySQL correcta...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar "+e);
        }
        
    }
}
