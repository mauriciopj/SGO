/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasCidade;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasEServicos;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasEServicosRepositorio;
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
public class ObrasEServicosDAO extends DAOGenerico<ObrasEServicos> implements ObrasEServicosRepositorio{
public ObrasEServicosDAO() throws ClassNotFoundException, SQLException {
        super();    
}

@Override
    protected String getConsultaInsert() {
        return "insert into obraseservicos(descricao, bairro, numero, complemento, rua, cidade, idCliente) "
                + "values(?,?,?,?,?,?,?)";
    }
    
     @Override
    protected String getConsultaUpdate() {
        return "update obraseservicos set descricao = ?, bairro = ?, numero = ?, complemento = ?, rua = ?, cidade = ?, idCliente = ? where idObras = ?";
    }
 @Override
    protected String getConsultaDelete() {
        return "delete from obraseservicos where idObras = ?";
    }
    
    @Override
    protected String getConsultaAbrir() {
        return "select idObras, descricao, bairro, numero, complemento, rua, cidade, idCliente from obraseservicos where idObras = ?";
    }
    
    @Override
    protected String getConsultaBuscar() {
        return "select idObras,descricao, bairro, numero, complemento, rua, cidade, idCliente from obraseservicos";
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
            setInt(7, obj.getidCliente());
            sql.setString(8, obj.getNumero());
            
            if(obj.getId() > 0)
                sql.setInt(9, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ObrasEServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       @Override
    protected ObrasEServicos setDados(ResultSet resultado) {
        try {
            ObrasEServicos obj = new ObrasEServicos();
            obj.setId( resultado.getInt("idObras") );
            obj.setDescricao(resultado.getString("descricao") );
            obj.setBairro( resultado.getString("bairro") );

            obj.setNumero( resultado.getString("numero") );
            obj.setComplemento( resultado.getString("complemento") );
            
            obj.setRua( resultado.getString("rua") );
            obj.setCidade( ObrasCidade.Abrir( resultado.getInt("cidade") ) );
            obj.setidCliente( resultado.getInt("idCliente") );
      
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ObrasEServicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

    private void setInt(int i, Object idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void adicionarFiltro(String idCliente, Object idCliente0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    protected void setBuscaFiltros(ObrasEServicos filtro) {
        if(filtro.getDescricao()!= null && !filtro.getDescricao().isEmpty())
            this.adicionarFiltro("cpf", filtro.getDescricao());
   }
}