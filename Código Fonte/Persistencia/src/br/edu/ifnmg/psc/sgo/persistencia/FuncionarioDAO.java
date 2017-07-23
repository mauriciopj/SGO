/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.CargoFuncionario;
import br.edu.ifnmg.psc.sgo.aplicacao.Funcionario;
import br.edu.ifnmg.psc.sgo.aplicacao.FuncionarioRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements FuncionarioRepositorio{

    public FuncionarioDAO() throws ClassNotFoundException, SQLException {
        super();
    }    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into funcionarios(nome, cpf, cargo, email, fone, salario, rua, bairro, numero) "
                + "values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update funcionarios set nome = ?, cpf = ?, cargo = ?, email = ?, fone = ?, salario = ?, rua = ?, bairro = ?, numero = ? where idFunc = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from funcionarios where idFunc = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select idFunc, nome, cpf, cargo, email, fone, salario, rua, bairro, numero from funcionarios where idFunc = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select idFunc, nome, cpf, cargo, email, fone, salario, rua, bairro, numero from funcionarios";
    }

    @Override
    protected void setBuscaFiltros(Funcionario filtro) {
        if(filtro.getCpf() != null && !filtro.getCpf().isEmpty())
            this.adicionarFiltro("cpf", filtro.getCpf());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Funcionario obj) {
        try {
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCpf());            
            sql.setInt(3, obj.getCargo().getId());     
            sql.setString(4, obj.getEmail());
            sql.setString(5, obj.getFone());
            sql.setDouble(6, obj.getSalario());
            sql.setString(7, obj.getRua());
            sql.setString(8, obj.getBairro());
            sql.setString(9, obj.getNumero());
            
            if(obj.getId() > 0)
                sql.setInt(10, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Funcionario setDados(ResultSet resultado) {
        try {
            Funcionario obj = new Funcionario();
            obj.setId( resultado.getInt("idFunc") );
            obj.setNome( resultado.getString("nome") );
            obj.setCpf( resultado.getString("cpf") );
            obj.setCargo( CargoFuncionario.Abrir( resultado.getInt("cargo") ) );
            obj.setEmail( resultado.getString("email") );
            obj.setFone( resultado.getString("fone") );
            obj.setSalario( resultado.getDouble("salario") );
            obj.setRua( resultado.getString("rua") );
            obj.setBairro( resultado.getString("bairro") );
            obj.setNumero( resultado.getString("numero") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}