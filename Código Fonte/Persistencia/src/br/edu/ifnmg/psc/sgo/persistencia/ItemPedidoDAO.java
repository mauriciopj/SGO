/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.PedidoItem;
import br.edu.ifnmg.psc.sgo.aplicacao.PedidoItemRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ItemPedidoDAO extends DAOGenerico<PedidoItem> implements PedidoItemRepositorio{

    public ItemPedidoDAO() throws ClassNotFoundException, SQLException {
        super();
        pedido = new PedidoDAO();
        materiais = new MaterialConstrucaoDAO();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into itemPedido(material, quantidade, pedido) values(?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update itemPedido set material = ?, quantidade = ?, pedido = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete(){
          return "delete from itemPedido where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
         return "select id, material, quantidade, pedido from itemPedido where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
         return "select id, material, quantidade, pedido from itemPedido ";
    }

    @Override
    protected void setBuscaFiltros(PedidoItem filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());        
    }

    @Override
    protected void setParametros(PreparedStatement sql, PedidoItem obj) {
        try {
            sql.setInt(1, obj.getMaterial().getId());
            sql.setInt(2, obj.getQuantidade());
            sql.setInt(3, obj.getPedido().getId());
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    PedidoDAO pedido;
    MaterialConstrucaoDAO materiais;
    
    @Override
    protected PedidoItem setDados(ResultSet resultado) {
        try {
            PedidoItem obj = new PedidoItem();
            obj.setId( resultado.getInt("id") );
            obj.setMaterial( materiais.Abrir( resultado.getInt("material") ) );
            obj.setQuantidade( resultado.getInt("quantidade") );
            obj.setPedido( pedido.Abrir( resultado.getInt("pedido") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
