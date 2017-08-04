/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.ListaMaterial;
import br.edu.ifnmg.psc.sgo.aplicacao.ListaMaterialRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public class ListaMaterialDAO extends DAOGenerico<ListaMaterial> implements ListaMaterialRepositorio {

    public ListaMaterialDAO() throws ClassNotFoundException, SQLException {
        super();
        materiais = new MaterialConstrucaoDAO();
    }
    
    @Override
    protected String getConsultaInsert() {
        return "insert into listamaterial(material, qtd) values(?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update listamaterial set material = ?, qtd = ? where idLM = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from listamaterial where idLM = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idLM, material, qtd from listamaterial where idLM = ?";
    }
    
    @Override
    protected String getConsultaBuscar() {
        return "select idLM, material, qtd from listamaterial ";
    }
    
    MaterialConstrucaoDAO materiais;
    
    @Override
    protected void setParametros(PreparedStatement sql, ListaMaterial obj) {
        try {
            sql.setInt(1, obj.getMaterial().getId());           
            sql.setInt(2, obj.getQtd());
             
            if(obj.getId() > 0)
                sql.setInt(3, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected ListaMaterial setDados(ResultSet resultado) {
        try {
            ListaMaterial obj = new ListaMaterial();
            obj.setId( resultado.getInt("idLM") );
            obj.setMaterial( materiais.Abrir( resultado.getInt("material") ) );
            obj.setQtd( resultado.getInt("qtd") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ListaMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    @Override
    protected void setBuscaFiltros(ListaMaterial filtro) {
        //if(filtro.getId() > 0)
            //this.adicionarFiltro("idForn", filtro.getId());
        
        //if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            //this.adicionarFiltro("nome", filtro.getNome());
    }

}
