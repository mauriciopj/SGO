/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

/**
 *
 * @author aluno
 */
public class Cliente extends Pessoa implements Entidade {
    private int idCli;
    private int opcao;
    
    public Cliente() {
        
    }  

    public Cliente(int opcao, String nome,  String cpf, String cnpj, String fone, String email, String rua, String bairro, String numero) {
        this.opcao = opcao;
        if (opcao == 1){
            Pessoa p = new PessoaFisica(cpf);            
        } else if (opcao == 2){
            Pessoa p = new PessoaJuridica(cnpj);            
        }
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }        
    
    @Override
    public int getId() {
        return idCli;
    }

    @Override
    public void setId(int id) {
        this.idCli = id;
    }
    
    public Object getCpf() {
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idCli;
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
        final Cliente other = (Cliente) obj;
        if (this.idCli != other.idCli) {
            return false;
        }
        return true;
    }       

    public void setCpf(String cpf) {
        this.cpf= cpf;
    }
        
}
