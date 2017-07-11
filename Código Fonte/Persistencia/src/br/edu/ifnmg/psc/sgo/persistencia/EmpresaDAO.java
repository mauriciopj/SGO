/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.Empresa;
import br.edu.ifnmg.psc.sgo.aplicacao.EmpresaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class EmpresaDAO extends DAOGenerico<Empresa> implements EmpresaRepositorio {
    
    public EmpresaDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into empresa(idEmpr, cnpj, nome, email, fone, rua, bairro, numero) values(?,?,?,?,?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update empresa set idEmpr = ?, cnpj = ?, nome = ?, email =  ?, fone = ?, rua = ?, bairro = ?, numero = ? where idForn = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from empresa where idEmpr = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idEmpr, cnpj, nome, email, fone, rua, bairro, numero from empresa where idEmpr = ?";
    }

    @Override
    protected void setBuscaFiltros(Empresa filtro) {
        //if(filtro.getId() > 0)
            //this.adicionarFiltro("idForn", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Empresa obj) {
        try {
            sql.setString(1, obj.getCnpj());
            sql.setString(2, obj.getNome());            
            sql.setString(3, obj.getEmail());
            sql.setString(4, obj.getFone());
            sql.setString(5, obj.getRua());
            sql.setString(6, obj.getBairro());
            sql.setString(7, obj.getNumero());
            
            if(obj.getId() > 0)
                sql.setInt(8, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Empresa setDados(ResultSet resultado) {
        try {
            Empresa obj = new Empresa();
            obj.setId( resultado.getInt("idEmpr") );
            obj.setCnpj( resultado.getString("cnpj") );
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
        return "select idEmpr, cnpj, nome, email, fone, rua, bairro, numero from empresa ";
    }
    
}
