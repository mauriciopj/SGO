/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.edu.ifnmg.psc.sgo.aplicacao.Empresa;
import br.edu.ifnmg.psc.sgo.aplicacao.EmpresaRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.ViolacaoRegraNegocioException;
import br.edu.ifnmg.psc.sgo.persistencia.EmpresaDAO;
import br.edu.ifnmg.psc.sgo.persistencia.FornecedorDAO;
import java.sql.SQLException;

/**
 *
 * @author mauricio
 */
public class Principal {
    public static void main (String[] args) throws ViolacaoRegraNegocioException, ClassNotFoundException, SQLException{
        Empresa e = new Empresa();
        
        e.setNome("jhghfdsf");
        e.setCnpj("4556");
        e.setRua("4");
        e.setBairro("4");
        e.setNumero("4");
        e.setFone("44444444444");
        e.setEmail("4");
        
        EmpresaRepositorio repositorio = new EmpresaDAO();
                    
        repositorio.Salvar(e);
    }
}
