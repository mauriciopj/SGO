/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasCidade;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasEServicos;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasEServicosRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dougla_Castro
 */
public class ObrasEServicosDAO extends DAOGenerico<ObrasEServicos> implements ObrasEServicosRepositorio{
    
    public ObrasEServicosDAO() throws ClassNotFoundException, SQLException {
        super();
        clientes = new ClienteDAO();
    }

    @Override
    protected String getConsultaInsert() {
        return "insert into obrasEServicos(descricao, bairro, numero, complemento, rua, cidade, cliente) "
                + "values(?,?,?,?,?,?,?)";
    }
    
    @Override
    protected String getConsultaUpdate() {
        return "update obrasEServicos set descricao = ?, bairro = ?, numero = ?, complemento = ?, rua = ?, cidade = ?, cliente = ? where idObra = ?";
    }
    
    @Override
    protected String getConsultaDelete() {
        return "delete from obrasEServicos where idObra = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idObra, descricao, bairro, numero, complemento, rua, cidade, cliente from obrasEServicos where idObra = ?";
    }
    
    @Override
    protected String getConsultaBuscar() {
        return "select idObra, descricao, bairro, numero, complemento, rua, cidade, cliente from obrasEServicos";
    }
    
    @Override
    protected void setBuscaFiltros(ObrasEServicos filtro) {
        if(filtro.getDescricao()!= null && !filtro.getDescricao().isEmpty())
            this.adicionarFiltro("descricao", filtro.getDescricao());
   }
    
    @Override
    protected void setParametros(PreparedStatement sql, ObrasEServicos obj) {
        try {
            sql.setString(1, obj.getDescricao());
            sql.setString(2, obj.getBairro());                         
            sql.setString(3, obj.getNumero());
            sql.setString(4, obj.getComplemento());  
            sql.setString(5, obj.getRua());
            sql.setInt(6, obj.getCidade().getId());
            sql.setInt(7, obj.getCliente().getId());
            
            if(obj.getId() > 0)
                sql.setInt(8, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ObrasEServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ClienteDAO clientes;
    
    @Override
    protected ObrasEServicos setDados(ResultSet resultado) {
        try {
            ObrasEServicos obj = new ObrasEServicos();
            obj.setId( resultado.getInt("idObra") );
            obj.setDescricao(resultado.getString("descricao") );
            obj.setBairro( resultado.getString("bairro") );
            obj.setNumero( resultado.getString("numero") );
            obj.setComplemento( resultado.getString("complemento") );
            obj.setRua( resultado.getString("rua") );
            obj.setCidade( ObrasCidade.Abrir( resultado.getInt("cidade") ) );
            obj.setCliente( clientes.Abrir( resultado.getInt("cliente") ) );

            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ObrasEServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}