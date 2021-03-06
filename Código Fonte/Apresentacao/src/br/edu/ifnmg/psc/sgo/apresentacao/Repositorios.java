/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.apresentacao;

import br.edu.ifnmg.psc.sgo.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.EmpresaRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.FuncionarioRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.ObrasEServicosRepositorio;
import br.edu.ifnmg.psc.sgo.persistencia.ObrasEServicosDAO;
import br.edu.ifnmg.psc.sgo.aplicacao.MaterialConstrucaoRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.PedidoRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.psc.sgo.persistencia.ClienteDAO;
import br.edu.ifnmg.psc.sgo.persistencia.UsuarioDAO;
import br.edu.ifnmg.psc.sgo.persistencia.EmpresaDAO;
import br.edu.ifnmg.psc.sgo.persistencia.FornecedorDAO;
import br.edu.ifnmg.psc.sgo.persistencia.FuncionarioDAO;
import br.edu.ifnmg.psc.sgo.persistencia.ItemPedidoDAO;
import br.edu.ifnmg.psc.sgo.persistencia.MaterialConstrucaoDAO;
import br.edu.ifnmg.psc.sgo.persistencia.PedidoDAO;
import br.edu.ifnmg.psc.sgo.persistencia.TrabalhoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifnmg.psc.sgo.aplicacao.ItemPedidoRepositorio;
import br.edu.ifnmg.psc.sgo.aplicacao.TrabalhoFuncionarioRepositorio;
import br.edu.ifnmg.psc.sgo.persistencia.TrabalhoFuncionarioDAO;

/**
 *
 * @author mauricio
 */
public class Repositorios {
    
    static FornecedorRepositorio fornecedorDAO = null;
    static FuncionarioRepositorio funcionarioDAO = null;
    static EmpresaRepositorio empresaDAO = null;
    static MaterialConstrucaoRepositorio materialConstrucaoDAO = null;
    static ClienteRepositorio clienteDAO = null;
    static ObrasEServicosRepositorio obrasEServicosDAO = null;
    static PedidoRepositorio pedidosDAO = null;
    static TrabalhoRepositorio trabalhoDAO = null;
    static ItemPedidoRepositorio itemPedidoDAO = null;
    static UsuarioRepositorio usuarioDAO = null;
    static TrabalhoFuncionarioRepositorio trabalhoFuncionarioDAO = null;
    
    public static EmpresaRepositorio getEmpresaRepositorio(){
        if(empresaDAO == null)
            try {
                empresaDAO = new EmpresaDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return empresaDAO;
    }
    
    public static FornecedorRepositorio getFornecedorRepositorio(){
        if(fornecedorDAO == null)
            try {
                fornecedorDAO = new FornecedorDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fornecedorDAO;
    }
    
    public static FuncionarioRepositorio getFuncionarioRepositorio(){
        if(funcionarioDAO == null)
            try {
                funcionarioDAO = new FuncionarioDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return funcionarioDAO;
    }
    
    public static MaterialConstrucaoRepositorio getMaterialConstrucaoRepositorio() {
        if(materialConstrucaoDAO == null)
            try {
                materialConstrucaoDAO = new MaterialConstrucaoDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return materialConstrucaoDAO;
    }
    
       public static ObrasEServicosRepositorio getObrasEServicosRepositorio() {
        if(obrasEServicosDAO == null)
            try {
                obrasEServicosDAO = new ObrasEServicosDAO() ;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return obrasEServicosDAO;
    }
       
    public static ClienteRepositorio getClienteRepositorio(){
        if(clienteDAO == null)
            try {
                clienteDAO = new ClienteDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return clienteDAO;
    }
    
    
    public static PedidoRepositorio getPedidosRepositorio(){
        if(pedidosDAO == null)
            try {
                pedidosDAO = new PedidoDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return pedidosDAO;
        
    }
    
    public static TrabalhoRepositorio getTrabalhoRepositorio(){
        if(trabalhoDAO == null)
            try {
                trabalhoDAO = new TrabalhoDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return trabalhoDAO;
    }
    
    public static ItemPedidoRepositorio getPedidoItemRepositorio(){
        if(itemPedidoDAO == null)
            try {
                itemPedidoDAO = new ItemPedidoDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return itemPedidoDAO;
    }
    
    
    
    public static UsuarioRepositorio getUsuarioRepositorio(){
        if(usuarioDAO == null)
            try {
               usuarioDAO = new UsuarioDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return usuarioDAO;
    }
         
    public static TrabalhoFuncionarioRepositorio getTrabalhoFuncionarioRepositorio(){
        if(trabalhoFuncionarioDAO == null)
            try {
               trabalhoFuncionarioDAO = new TrabalhoFuncionarioDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return trabalhoFuncionarioDAO;
    }
            
}
