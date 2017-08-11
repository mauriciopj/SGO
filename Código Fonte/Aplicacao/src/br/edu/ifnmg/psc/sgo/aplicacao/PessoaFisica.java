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
public class PessoaFisica extends Pessoa {
    protected String cpf;

    public PessoaFisica() {
        
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }        

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ViolacaoRegraNegocioException {
        if (!validaCPF(cpf))
            throw new ViolacaoRegraNegocioException("CPF inválido!");
        this.cpf = cpf;
    }  
    
    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
       
    public static boolean validaCPF(String cpf) throws ViolacaoRegraNegocioException {
        if (cpf==null || cpf.length()!=11)
            throw new ViolacaoRegraNegocioException("O CPF deve conter 11 digitos!");

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
   }

    @Override
    public void setId(int id) {
        
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
