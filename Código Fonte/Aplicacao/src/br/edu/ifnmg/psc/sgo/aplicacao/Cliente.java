/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

/**
 *
 * @author aluno
 */
public class Cliente extends PessoaFisica {
    private int idCli;

    public Cliente() {
        
    }   
    
    public int getId() {
        return idCli;
    }

    public void setId(int id) {
        this.idCli = id;
    }   
    
}
