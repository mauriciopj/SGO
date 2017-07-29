/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;
import br.edu.ifnmg.psc.sgo.aplicacao.Entidade;
import br.edu.ifnmg.psc.sgo.aplicacao.Entidade;
import java.util.Objects;
/**
 *
 * @author Douglas_Castro
 */
public class MaterialConstrucao implements Entidade {
    
    private int idMate;
    private String nome;
    private String descricao;
    private String valor; 
    private int qtd;

    public MaterialConstrucao() {
    } 
    
    
      public MaterialConstrucao( String nome, String descricao, String valor,int qtd) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtd=qtd;
        this.valor=valor;
    }  

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
           
    @Override
    public void setId(int id) {
        this.idMate = id;        
    }

    @Override
    public int getId() {
        return idMate;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
      @Override
    public int hashCode() {
        int hash = 2;
        hash = 43 * hash + this.idMate;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.descricao);
         hash = 43 * hash + Objects.hashCode(this.qtd);
        hash = 43 * hash + Objects.hashCode(this.valor);
        return hash;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MaterialConstrucao other = (MaterialConstrucao) obj;
        if (this.idMate != other.idMate) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        
         if (!Objects.equals(this.qtd, other.qtd)) {
            return false;
        }
         if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }       
    
}



