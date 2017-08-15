/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.StatusAndamento;
import br.edu.ifnmg.psc.sgo.aplicacao.Trabalho;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoFuncionario;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class TrabalhoDAO extends DAOGenerico<Trabalho> implements TrabalhoRepositorio {
    
    private TrabalhoFuncionarioDAO funcionarios = new TrabalhoFuncionarioDAO();
    private Trabalho trabalho;
    private ObrasEServicosDAO obrasEServicos = new ObrasEServicosDAO();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    public TrabalhoDAO() throws ClassNotFoundException, SQLException {
        super();
        //obrasEServicos = new ObrasEServicosDAO();
    }    

    @Override
    protected String getConsultaInsert() {
        return "insert into trabalhos(dataInicio, dataTermino, andamento, ultimaModificacao, obraEServico) values(?,?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update trabalhos set dataInicio = ?, dataTermino = ?, andamento = ?, ultimaModificacao = ?, obraEServico = ? where id = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from trabalhos where id = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select id, dataInicio, dataTermino, andamento, ultimaModificacao, obraEServico from trabalhos where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select id, dataInicio, dataTermino, andamento, ultimaModificacao, obraEServico from trabalhos ";
    }        
    
    @Override
    protected void setBuscaFiltros(Trabalho filtro) {        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        if(filtro.getDataInicio() != null)
            this.adicionarFiltro("dataInicio", df.format(filtro.getDataInicio()) );
        if(filtro.getDataTermino() != null)
            this.adicionarFiltro("dataTermino", df.format(filtro.getDataTermino()) );
        if(filtro.getAndamento() != null)
            this.adicionarFiltro("andamento", filtro.getAndamento().getId() );
        if(filtro.getObraEServico() != null)
            this.adicionarFiltro("obraEServico", filtro.getObraEServico().getDescricao());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Trabalho obj) {
        try {
            sql.setString(1, obj.getDataInicio() );
            sql.setString(2, obj.getDataTermino() );                        
            sql.setInt(3, obj.getAndamento().getId());
            sql.setString(4, obj.getUltimaModificacao() );
            sql.setInt(5, obj.getObraEServico().getId()); 
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected Trabalho setDados(ResultSet resultado) {
        try {
            Trabalho obj = new Trabalho();
            obj.setId( resultado.getInt("id") );
            obj.setDataInicio( resultado.getString("dataInicio") );
            obj.setDataTermino( resultado.getString("dataTermino") );            
            obj.setAndamento( StatusAndamento.Abrir( resultado.getInt("andamento") ) );
            obj.setUltimaModificacao(resultado.getString("ultimaModificacao") );
            obj.setObraEServico( obrasEServicos.Abrir(resultado.getInt("obraEServico") ) );
            
            TrabalhoFuncionario filtro = new TrabalhoFuncionario();
            filtro.setTrabalho(obj);
            
            obj.setFuncionarios(funcionarios.Buscar(filtro) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(TrabalhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public boolean Salvar(Trabalho obj) {
        if(super.Salvar(obj)){
            obj.setId(UltimoDaLista(null).getId());
            trabalho = obj;
            for(TrabalhoFuncionario t : obj.getFuncionarios()){
                t.setTrabalho(trabalho);
                funcionarios.Salvar(t);
            }
            return true;
        }
        return false;
    }

}
