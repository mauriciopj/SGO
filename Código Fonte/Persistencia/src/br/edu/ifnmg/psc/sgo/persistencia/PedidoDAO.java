/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;




import br.edu.ifnmg.psc.sgo.aplicacao.Pedido;
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
public class PedidoDAO extends DAOGenerico<Pedido> implements PedidosRepositorio {
    
    public PedidoDAO() throws ClassNotFoundException, SQLException {
        super();  
        materiais = new MaterialConstrucaoDAO();
        fornecedores = new FornecedorDAO();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into pedidos(data, qtd, fornecedor) values(?,?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update pedidos set data = ?, qtd = ?, fornecedor = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete(){
          return "delete from pedidos where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
         return "select id, data, qtd, fornecedor from pedidos where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
         return "select id, data, qtd,  fornecedor from pedidos ";
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
            sql.setDate(1, new java.sql.Date( obj.getData().getTime() ));
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
            obj.setData( new Date( resultado.getDate("data").getTime() ) );
            obj.setQuantidade( resultado.getInt("qtd") );
            obj.setFornecedor(fornecedores.Abrir( resultado.getInt("fornecedor") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
