/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.List;

/**
 *
 * @author mauricio
 */
public class Principal {
    public static void main (String[] args) throws ViolacaoRegraNegocioException{
        Empresa e = new Empresa();
        
        e.setNome("fdsfsdf");
        e.setCnpj("76845146000108");
        e.setRua("4");
        e.setBairro("4");
        e.setNumero("4");
        e.setFone("44444444444");
        e.setEmail("4");
        
        Repositorio<Empresa> repositorio = null;
                    
        repositorio.Salvar(e);
    }
}
