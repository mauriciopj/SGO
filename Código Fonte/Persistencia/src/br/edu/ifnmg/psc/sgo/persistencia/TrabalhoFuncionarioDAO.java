/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoFuncionario;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoFuncionarioRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class TrabalhoFuncionarioDAO extends DAOGenerico<TrabalhoFuncionario> implements TrabalhoFuncionarioRepositorio {

    FuncionarioDAO funcionarios;
    
    public TrabalhoFuncionarioDAO() throws ClassNotFoundException, SQLException {
        super();
        //funcionarios = new FuncionarioDAO();        
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into trabalhoFuncionario(funcionario, trabalho) values(?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update trabalhoFuncionario setfuncionario = ?, trabalho = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete(){
          return "delete from trabalhoFuncionario where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
         return "select id, funcionario, trabalho from trabalhoFuncionario where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
         return "select id, funcionario, trabalho from trabalhoFuncionario";
    }

    @Override
    protected void setBuscaFiltros(TrabalhoFuncionario filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        if(filtro.getFuncionario() != null)
            this.adicionarFiltro("funcionario", filtro.getId());
        if(filtro.getTrabalho()!= null)
            this.adicionarFiltro("trabalho", filtro.getId());
    }

    @Override
    protected void setParametros(PreparedStatement sql, TrabalhoFuncionario obj) {
        try {
            sql.setInt(1, obj.getFuncionario().getId());
            sql.setInt(2, obj.getTrabalho().getId());
            
            if(obj.getId() > 0)
                sql.setInt(3, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    TrabalhoDAO trabalho;
    
    @Override
    protected TrabalhoFuncionario setDados(ResultSet resultado) {
        try {
            TrabalhoFuncionario obj = new TrabalhoFuncionario();
            obj.setId( resultado.getInt("id") );
            obj.setTrabalho(trabalho.Abrir( resultado.getInt("trabalho") ) );
            obj.setFuncionario( funcionarios.Abrir( resultado.getInt("funcionario") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(TrabalhoFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
