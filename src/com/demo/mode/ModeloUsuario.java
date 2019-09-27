/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.mode;

import com.demo.model.entity.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
    
    public static File ruta = new File("usuarios.txt");
    
    public static boolean logIn(Usuario user){
        /* 
        if(user.getEmail().compareTo("admin@gmail.com") == 0 &&
                user.getClave().compareTo("123456") == 0){
            band = true;
        }else{
            band = false;
        }
        return band;
        */
        boolean band = false;
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String[] datos;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                if (datos[1].compareTo(user.getEmail()) == 0 && datos[2].compareTo(user.getClave()) == 0) {
                    band = true;
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer: " + e);
        }
        return band;
    }
    
    public static long logUp(Usuario user){
        long band =0;
        String linea;
        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String[] datos;
            while((linea = br.readLine())!=null){
                datos =linea.split(";");  
            }
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            String filatxt = user.getEmail() + ","+ user.getNombres() + ","+ 
                    user.getApellidos() +","+ user.getClave() +","+ user.getTipo();
            pw.println(filatxt);
            
            pw.close();
            fw.close();
            br.close();
            fr.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        
        return band;
    }
}
