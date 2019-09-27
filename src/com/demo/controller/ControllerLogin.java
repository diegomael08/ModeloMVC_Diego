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
    
    
    public long Registro(String id, String email, String clave, String apellidos, String nombres, String tipo){
        long status = 0;
        if (!( email.endsWith("@gmail.com"))) {
            JOptionPane.showMessageDialog(null, "Email incorrecto");
            return status;
        }else{
            Usuario user = new Usuario(Integer.parseInt(id), email, clave, apellidos, nombres, Integer.parseInt(tipo));
           status = ModeloUsuario.logUp(user); 
        }
        
        return status;
    }
    
    public long RecuperarClave(){
        long status = 0;
        
        return status;
    }
    
}
