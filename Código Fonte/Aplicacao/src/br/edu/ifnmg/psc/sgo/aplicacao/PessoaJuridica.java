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
public class PessoaJuridica extends Pessoa {
    
    int id;
    
    protected String cnpj;

    public PessoaJuridica() {
        
    }

    PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }        
    
    public void setCnpj(String cnpj) throws ViolacaoRegraNegocioException{
        if (!validaCNPJ(cnpj))
            throw new ViolacaoRegraNegocioException("CNPJ inválido!"); 
        this.cnpj = cnpj;
    }
        
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean validaCNPJ(String cnpj) throws ViolacaoRegraNegocioException {
        if (cnpj==null || cnpj.length()!=14)
            throw new ViolacaoRegraNegocioException("O CNPJ deve conter 14 digitos!");
        
        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }        
    
}
