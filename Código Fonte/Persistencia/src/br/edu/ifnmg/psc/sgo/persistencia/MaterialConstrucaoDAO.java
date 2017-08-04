/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;


import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucao;
import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucaoRepositorio;
import br.edu.ifnmg.psc.sgo.persistencia.DAOGenerico;
import br.edu.ifnmg.psc.sgo.persistencia.DAOGenerico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dougla_Castro
 */
public class MaterialConstrucaoDAO extends DAOGenerico<MaterialConstrucao> implements MaterialConstrucaoRepositorio{
     
    public MaterialConstrucaoDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into materiais(nome,descricao,qtd,valor) values(?,?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
      return "update materiais set  nome = ?, descricao = ?, qtd = ? ,valor = ? where idMate = ?";
    }
    @Override
    protected String getConsultaDelete() {
         return "delete from materiais where idMate = ?";
    }
    @Override
    protected String getConsultaAbrir() {
       return "select idMate, nome, descricao ,qtd ,valor from materiais where idMate = ?";
    }

    
    @Override
    protected void setBuscaFiltros(MaterialConstrucao filtro) {
      if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
    }

    @Override
    protected void setParametros(PreparedStatement sql, MaterialConstrucao obj) {
         try {
           
            sql.setString(1, obj.getNome());            
            sql.setString(2, obj.getDescricao());
            sql.setString(3, obj.getValor());            
            sql.setInt(4, obj.getQtd());
  
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(MaterialConstrucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    protected MaterialConstrucao setDados(ResultSet resultado) {
       try {
            MaterialConstrucao obj = new MaterialConstrucao();
         
            obj.setId( resultado.getInt("idMate") );
            obj.setNome( resultado.getString("nome") );
            obj.setDescricao( resultado.getString("descricao") );
             obj.setQtd(resultado.getInt("qtd") );
            obj.setValor(resultado.getString("valor") );
           
           
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(MaterialConstrucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    @Override
    protected String getConsultaBuscar() {
        return "select idMate, nome, descricao , qtd ,valor from materiais ";
    }
    
}

