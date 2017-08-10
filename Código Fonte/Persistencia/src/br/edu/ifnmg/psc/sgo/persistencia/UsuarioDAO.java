/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;



import br.edu.ifnmg.psc.sgo.aplicacao.Usuario;
import br.edu.ifnmg.psc.sgo.aplicacao.UsuarioRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 
 */
public class UsuarioDAO extends DAOGenerico<Usuario> implements UsuarioRepositorio {

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    
    
    @Override
    protected String getConsultaInsert() {
        return "insert into usuario(nome, login, senha) values(?,?,?)";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update usuario set nome = ?, login = ?, senha = ? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from usuario where id = ?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id, nome, login, senha from usuario where id = ?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select id, nome, login, senha from usuario ";
    }

    @Override
    protected void setBuscaFiltros(Usuario filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
        
        if(filtro.getLogin() != null && !filtro.getLogin().isEmpty())
            this.adicionarFiltro("login", filtro.getLogin());
        
        if(filtro.getSenha() != null && !filtro.getSenha().isEmpty())
            this.adicionarFiltro("senha", filtro.getSenha());
    }

    @Override
    protected void setParametros(PreparedStatement sql, Usuario obj) {
        try {
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getLogin());
            sql.setString(3, obj.getSenha());
            
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Usuario setDados(ResultSet resultado) {
        try {
            Usuario obj = new Usuario();
            obj.setId( resultado.getInt("id") );
            obj.setNome( resultado.getString("nome") );
            obj.setLogin( resultado.getString("login") );
            obj.setSenha( resultado.getString("senha") );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
