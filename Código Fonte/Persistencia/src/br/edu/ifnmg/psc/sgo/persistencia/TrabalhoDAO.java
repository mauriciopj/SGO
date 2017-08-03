/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.StatusAndamento;
import br.edu.ifnmg.psc.sgo.aplicacao.Trabalho;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class TrabalhoDAO extends DAOGenerico<Trabalho> implements TrabalhoRepositorio {

    public TrabalhoDAO() throws ClassNotFoundException, SQLException {
        super();
    }    

    @Override
    protected String getConsultaInsert() {
        return "insert into trabalhos(idTrab, dataInicio, dataTermino, andamento) values(?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update trabalhos set dataInicio = ?, dataTermino = ?, andamento = ? where idTrab = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from trabalhos where idTrab = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idTrab, dataInicio, dataTermino, andamento from trabalhos where idTrab = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select idTrab, dataInicio, dataTermino, andamento from trabalhos ";
    }

    @Override
    protected void setBuscaFiltros(Trabalho filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("idTrab", filtro.getId());
        if(filtro.getDataInicio() != null)
            this.adicionarFiltro("dataInicio", filtro.getDataInicio().toString() );
        if(filtro.getDataTermino() != null)
            this.adicionarFiltro("dataTermino", filtro.getDataTermino().toString() );
        if(filtro.getAndamento() != null)
            this.adicionarFiltro("andamento", filtro.getAndamento().toString() );
    }

    @Override
    protected void setParametros(PreparedStatement sql, Trabalho obj) {
        try {
            sql.setDate(1, (java.sql.Date) obj.getDataInicio());
            sql.setDate(2, (java.sql.Date) obj.getDataTermino());            
            sql.setInt(3, obj.getAndamento().getId());     
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Trabalho setDados(ResultSet resultado) {
        try {
            Trabalho obj = new Trabalho();
            obj.setId( resultado.getInt("idTrab") );
            obj.setDataInicio( resultado.getDate("dataInicio") );
            obj.setDataTermino( resultado.getDate("dataTermino") );
            obj.setAndamento( StatusAndamento.Abrir( resultado.getInt("andamento") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
