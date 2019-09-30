/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.mode.ModeloUsuario;
import com.demo.model.entity.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author whiston
 */
public class ControllerLogin extends Controller {
    
    public ControllerLogin(){
    
    }
    
    public boolean logIn(String usuario, String clave){
        boolean band = false;
        Usuario user = new Usuario(usuario, clave);
        band = ModeloUsuario.logIn(user); 
        return band;
    }
    
    
    public long Registro(String id, String nombres, String apellidos, String email, String clave, String tipo){
        long status = -1;
        if (!(email.endsWith("@gmail.com"))) {
            JOptionPane.showMessageDialog(null, "Email incorrecto");
            return status;
        }
        try{
           Usuario user = new Usuario(Integer.parseInt(id), nombres, apellidos, email, clave, tipo);
           status = ModeloUsuario.logUp(user); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
        return status;   
    }
    
    public long RecuperarClave(String email, String clave){
        long status = 0;
        try{
            Usuario user = new Usuario(email, clave);
            status = ModeloUsuario.recuperarClave(user);
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error en los datos");
        }
        
        return status;
    }
    
}
