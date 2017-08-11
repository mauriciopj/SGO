/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.persistencia;

import br.edu.ifnmg.psc.sgo.aplicacao.Entidade;
import br.edu.ifnmg.psc.sgo.aplicacao.Repositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level; 
import java.util.logging.Logger;

/**
 *
 * @author mauricio
 */
public abstract class DAOGenerico<T extends Entidade> implements Repositorio<T> {   
    private Connection conexao;   
    private String where = "";

    public DAOGenerico() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  
<<<<<<< HEAD
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgo","mauriciopj","123");
=======
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgo","root","");
>>>>>>> 0237a51305c0293bd44c2711a478a6e3bbbdda64
    }

    protected abstract String getConsultaInsert();
    protected abstract String getConsultaUpdate();
    protected abstract String getConsultaDelete();
    protected abstract String getConsultaAbrir();
    protected abstract String getConsultaBuscar();
    protected abstract void setBuscaFiltros(T filtro);
    
    protected abstract void setParametros(PreparedStatement sql, T obj);
    protected abstract T setDados(ResultSet resultado);
    
    
    @Override
    public boolean Salvar(T obj) {
        try {
            PreparedStatement sql = null;
            
            // Objeto não está salvo no BD ---> INSERT
            if(obj.getId() == 0){
                // Criar a consulta SQL de inserção
                sql = conexao.prepareStatement(getConsultaInsert());
            
            // Objeto já está salvo no BD ---> UPDATE
            } else {
                // Criar a consulta SQL de inserção
                sql = conexao.prepareStatement(getConsultaUpdate());
            }    
            
            setParametros(sql, obj);

            if (sql.executeUpdate() <= 0)
                return false;
            
            List<T> busca = Buscar(obj);
            
            T maiorid = busca.get(0);
            
            obj.setId(maiorid.getId());
            
            return true;
            
        } catch(Exception ex) {
             return false;
        }
    }

    @Override
    public boolean Apagar(T obj) {
        try {
            PreparedStatement sql = conexao.prepareStatement(getConsultaDelete());
            
            sql.setInt(1, obj.getId());
            
            if (sql.executeUpdate() > 0) {
                obj = null;
                return true;
            } else 
                return false;
            
        } catch(Exception ex) {
             return false;
        }
    }

    @Override
    public T Abrir(int id) {
        try {
            PreparedStatement sql = conexao.prepareStatement(this.getConsultaAbrir());
            
            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();
            
            if(resultado.next())
                return this.setDados(resultado);
            else 
                return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    protected DAOGenerico<T> adicionarFiltro(String campo, String valor){   // Contribui com a consulta formando a condição where
        if(where.length() > 0)                                              
            where += " and ";
        
        where += campo + " = '"+ valor + "'";
        
        return this;
    }
    
    protected DAOGenerico<T> adicionarFiltro(String campo, int valor){
        if(where.length() > 0)
            where += " and ";
        
        where += campo + " = "+ Integer.toString(valor);
        
        return this;
    }

    @Override
    public List<T> Buscar(T filtro) {
        
        // Cria uma lista vazia com o tipo T
        List<T> lista = new ArrayList<>();
        
        try {
            
            if(filtro != null)
                this.setBuscaFiltros(filtro);
            
            String sqlfinal = this.getConsultaBuscar();
            
            if(! where.isEmpty())
                sqlfinal += " where " + where;
            
            PreparedStatement sql = conexao.prepareStatement(sqlfinal );
                       
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next())
                lista.add( this.setDados(resultado) );
            
            this.where = "";
            
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
