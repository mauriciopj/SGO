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
public class Fornecedor extends Pessoa implements Entidade {
    private int idForn;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String fone, String email, String rua, String bairro, String numero) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    @Override
    public int getId() {
        return idForn;
    }

    @Override
    public void setId(int id) {
        this.idForn = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.idForn;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.fone);
        hash = 71 * hash + Objects.hashCode(this.email);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.idForn != other.idForn) {
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
