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
public class Empresa extends Endereco implements Entidade{ 
    private int idEmpr;
    private String cnpj, nome, fone, email;

    public Empresa() {
    }   
    
    public Empresa(int idEmpr, String cnpj, String nome, String fone, String email) {
        this.idEmpr = idEmpr;
        this.cnpj = cnpj;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }    
        
    @Override
    public void setId(int id) {
        this.idEmpr = idEmpr;        
    }

    @Override
    public int getId() {
        return idEmpr;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws ViolacaoRegraNegocioException {
        if (cnpj == null || cnpj.length() < 14 || cnpj.length() > 14)
            throw new ViolacaoRegraNegocioException("O CNPJ deve conter 14 digitos!"); 
        this.cnpj = cnpj;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ViolacaoRegraNegocioException {
        if (nome == null || nome.length() < 5 || nome.length() > 100)
            throw new ViolacaoRegraNegocioException("O nome deve conter no mínimo 5 e máximo de 100 caracteres!"); 
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) throws ViolacaoRegraNegocioException {
        if (fone == null || fone.length() < 11 || fone.length() > 11)
            throw new ViolacaoRegraNegocioException("O telefone deve conter entre 10 ou 11 caracteres!");
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ViolacaoRegraNegocioException {
        if (email == null || email.length() > 150)
            throw new ViolacaoRegraNegocioException("O email pode conter até no máximo 150 caracteres!");
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ViolacaoRegraNegocioException {
        if (bairro == null || bairro.length() > 50)
            throw new ViolacaoRegraNegocioException("O bairro pode conter até no máximo 50 caracteres!");
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws ViolacaoRegraNegocioException {
        if (numero == null || numero.length() > 8)
            throw new ViolacaoRegraNegocioException("O numero pode conter até no máximo 8 caracteres!");
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ViolacaoRegraNegocioException {
        if (rua == null || rua.length() > 150)
            throw new ViolacaoRegraNegocioException("A rua pode conter até no máximo 150 caracteres!");
        this.rua = rua;
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
