/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

/**
 *
 * 
 */
public class Aplicacao {
    
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Aplicacao.usuario = usuario;
    }
    
    public static boolean isLogged() {
        //return true;
        return usuario != null;
    }   
}
