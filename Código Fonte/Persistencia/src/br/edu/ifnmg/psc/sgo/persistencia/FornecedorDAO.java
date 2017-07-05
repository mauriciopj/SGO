/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.Fornecedor;
import br.edu.ifnmg.psc.sgo.aplicacao.FornecedorRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class FornecedorDAO extends DAOGenerico<Fornecedor> implements FornecedorRepositorio {

    public FornecedorDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into fornecedores(nome, email, fone, rua, bairro, numero) values(?,?,?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update fornecedores set nome = ?, email =  ?, fone = ?, rua = ?, bairro = ?, numero = ? where idForn = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from fornecedores where idForn = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idForn, nome, email, fone, rua, bairro, numero from fornecedores where idForn = ?";
    }
    

    @Override
    protected void setParametros(PreparedStatement sql, Fornecedor obj) {
        try {
            sql.setString(1, obj.getNome());            
            sql.setString(2, obj.getEmail());
            sql.setString(3, obj.getFone());
            sql.setString(4, obj.getRua());
            sql.setString(5, obj.getBairro());
            sql.setString(6, obj.getNumero());
            
            if(obj.getId() > 0)
                sql.setInt(7, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Fornecedor setDados(ResultSet resultado) {
        try {
            Fornecedor obj = new Fornecedor();
            obj.setId( resultado.getInt("idForn") );
            obj.setNome( resultado.getString("nome") );
            obj.setEmail( resultado.getString("email") );
            obj.setFone( resultado.getString("fone") );
            obj.setRua( resultado.getString("rua") );
            obj.setBairro( resultado.getString("bairro") );
            obj.setNumero( resultado.getString("numero") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    protected String getConsultaBuscar() {
        return "select idForn, nome, email, fone, rua, bairro, numero from fornecedores ";
    }

    @Override
    protected void setBuscaFiltros(Fornecedor filtro) {
        //if(filtro.getId() > 0)
            //this.adicionarFiltro("idForn", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
    }

    
}
