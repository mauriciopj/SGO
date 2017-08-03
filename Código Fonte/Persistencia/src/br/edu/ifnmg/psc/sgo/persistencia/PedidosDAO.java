/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;




import br.edu.ifnmg.psc.sgo.aplicacao.Pedidos;
import br.edu.ifnmg.psc.sgo.aplicacao.PedidosRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Douglas_Castro
 */
public class PedidosDAO extends DAOGenerico<Pedidos> implements PedidosRepositorio {
    
   public PedidosDAO() throws ClassNotFoundException, SQLException {
        super();  
         materiais = new MaterialConstrucaoDAO();
         fornecedores = new FornecedorDAO();
    
        
        
}

    @Override
    protected String getConsultaInsert() {
        return "insert into pedidos(data, qtd, material, fornecedor) values(?,?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pedidos set data = ?, qtd = ?, material = ?, fornecedor = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete(){
          return "delete from pedidos where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
         return "select id, data, qtd, material, fornecedor from pedidos where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
         return "select id, data, qtd, material, fornecedor from pedidos ";
    }

    @Override
    protected void setBuscaFiltros(Pedidos filtro) {
         
               
  
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getMaterial()!= null)
            this.adicionarFiltro("material", filtro.getMaterial().getId());
        
        if(filtro.getFornecedor()!= null)
            this.adicionarFiltro("fornecedor", filtro.getFornecedor().getId());
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Pedidos obj) {
        try {
            
            sql.setDate(1, new java.sql.Date( obj.getData().getTime() ));
            sql.setInt(2, obj.getQtd());
            sql.setInt(3, obj.getMaterial().getId());
            sql.setInt(4, obj.getFornecedor().getId());
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     MaterialConstrucaoDAO materiais;
     FornecedorDAO fornecedores;

    @Override
    protected Pedidos setDados(ResultSet resultado) {
        try {
            Pedidos obj = new Pedidos();
            obj.setId( resultado.getInt("id") );
            obj.setData( new Date( resultado.getDate("data").getTime() ) );
            obj.setQtd( resultado.getInt("qtd") );
            obj.setMaterial(materiais.Abrir( resultado.getInt("material") ) );
            obj.setFornecedor(fornecedores.Abrir( resultado.getInt("fornecedor") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
