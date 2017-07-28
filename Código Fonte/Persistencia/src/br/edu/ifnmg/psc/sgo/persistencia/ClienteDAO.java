/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.Cliente;
import br.edu.ifnmg.psc.sgo.aplicacao.ClienteRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio {

    public ClienteDAO() throws ClassNotFoundException, SQLException {
        super();
    }   
    
    @Override
    protected String getConsultaInsert() {
        return "insert into clientes(nome, email, fone, rua, bairro, numero) values(?,?,?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update clientes set nome = ?, email =  ?, fone = ?, rua = ?, bairro = ?, numero = ? where idCli = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from clientes where idCli = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idCli, nome, email, fone, rua, bairro, numero from clientes where idCli = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select idCli, nome, email, fone, rua, bairro, numero from clientes ";
    }

    @Override
    protected void setBuscaFiltros(Cliente filtro) {
        //if(filtro.getId() > 0)
            //this.adicionarFiltro("idForn", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Cliente obj) {
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Cliente setDados(ResultSet resultado) {
        try {
            Cliente obj = new Cliente();
            obj.setId( resultado.getInt("idForn") );
            obj.setNome( resultado.getString("nome") );
            obj.setEmail( resultado.getString("email") );
            obj.setFone( resultado.getString("fone") );
            obj.setRua( resultado.getString("rua") );
            obj.setBairro( resultado.getString("bairro") );
            obj.setNumero( resultado.getString("numero") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
