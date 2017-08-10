/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;




import br.edu.ifnmg.psc.sgo.aplicacao.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifnmg.psc.sgo.aplicacao.PedidoRepositorio;
/**
 *
 * @author Douglas_Castro
 */
public class PedidoDAO extends DAOGenerico<Pedido> implements PedidoRepositorio {
    
    public PedidoDAO() throws ClassNotFoundException, SQLException {
        super();  
        materiais = new MaterialConstrucaoDAO();
        fornecedores = new FornecedorDAO();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into pedidos(data, qtdItens, fornecedor) values(?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pedidos set data = ?, qtdItens = ?, fornecedor = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete(){
          return "delete from pedidos where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
         return "select id, data, qtdItens, fornecedor from pedidos where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
         return "select id, data, qtdItens, fornecedor from pedidos ";
    }

    @Override
    protected void setBuscaFiltros(Pedido filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        if(filtro.getFornecedor()!= null)
            this.adicionarFiltro("fornecedor", filtro.getFornecedor().getId());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Pedido obj) {
        try {
            sql.setString(1, obj.getData() );
            sql.setInt(2, obj.getQuantidade());
            sql.setInt(3, obj.getFornecedor().getId());
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     MaterialConstrucaoDAO materiais;
     FornecedorDAO fornecedores;

    @Override
    protected Pedido setDados(ResultSet resultado) {
        try {
            Pedido obj = new Pedido();
            obj.setId( resultado.getInt("id") );
            obj.setData( resultado.getString("data") );
            obj.setQuantidade( resultado.getInt("qtdItens") );
            obj.setFornecedor(fornecedores.Abrir( resultado.getInt("fornecedor") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
