/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

/**
 *
 * @author mauricio
 */
public abstract class Pessoa implements Entidade {
    protected String nome, fone, email, bairro, numero, rua;      

    public Pessoa() {
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

    public void setFone(String fone) throws ViolacaoRegraNegocioException{
        if (fone == null || fone.length() < 10 || fone.length() > 11)
            throw new ViolacaoRegraNegocioException("O telefone deve conter entre 10 ou 11 caracteres!");
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ViolacaoRegraNegocioException{
        if (email == null || email.length() > 150)
            throw new ViolacaoRegraNegocioException("O email pode conter até no máximo 150 caracteres!");
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ViolacaoRegraNegocioException{
        if (rua == null || rua.length() > 150)
            throw new ViolacaoRegraNegocioException("A rua pode conter até no máximo 150 caracteres!");
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ViolacaoRegraNegocioException{
        if (bairro == null || bairro.length() > 50)
            throw new ViolacaoRegraNegocioException("O bairro pode conter até no máximo 50 caracteres!");
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws ViolacaoRegraNegocioException{
        if (numero == null || numero.length() > 8)
            throw new ViolacaoRegraNegocioException("O numero pode conter até no máximo 8 caracteres!");
        this.numero = numero;
    }  
    
    protected static int calcularDigito(String str, int[] peso) {
       int soma = 0;
       for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
          digito = Integer.parseInt(str.substring(indice,indice+1));
          soma += digito*peso[peso.length-str.length()+indice];
       }
       soma = 11 - soma % 11;
       return soma > 9 ? 0 : soma;
    }        
    
}
