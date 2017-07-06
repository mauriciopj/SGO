/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.apresentacao;

import br.edu.ifnmg.psc.sgo.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgo.persistencia.FornecedorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class Repositorios {
    
    static FornecedorRepositorio fornecedorDAO = null;
    
    public static FornecedorRepositorio getFornecedorRepositorio(){
        if(fornecedorDAO == null)
            try {
                fornecedorDAO = new FornecedorDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fornecedorDAO;
    }
}
