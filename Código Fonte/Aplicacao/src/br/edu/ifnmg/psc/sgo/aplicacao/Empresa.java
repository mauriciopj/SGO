/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.Objects;

/**
 *
 * @author mauricio
 */
public class Empresa extends PessoaJuridica implements Entidade{ 
    private int idEmpr;

    public Empresa() {

    }   
    
    public Empresa(String cnpj, String nome, String email, String fone, String rua, String bairro, String numero) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }    
        
    @Override
    public void setId(int id) {
        this.idEmpr = id;        
    }

    @Override
    public int getId() {
        return idEmpr;
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idEmpr;
        hash = 43 * hash + Objects.hashCode(this.cnpj);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.fone);
        hash = 43 * hash + Objects.hashCode(this.email);
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
        final Empresa other = (Empresa) obj;
        if (this.idEmpr != other.idEmpr) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.fone, other.fone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }       
    
}
