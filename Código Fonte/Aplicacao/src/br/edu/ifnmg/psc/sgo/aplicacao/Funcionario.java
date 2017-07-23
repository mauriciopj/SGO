/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Funcionario extends PessoaFisica implements Entidade {
    private int idFunc;
    private CargoFuncionario cargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String cpf, String nome, CargoFuncionario cargo, String fone, double salario, String email, String rua, String bairro, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
        this.fone = fone;
        this.salario = salario;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }  
    
    @Override
    public void setId(int id) {
        this.idFunc = id;
    }

    @Override
    public int getId() {
        return idFunc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws ViolacaoRegraNegocioException {
        if(salario <= 0)
            throw new ViolacaoRegraNegocioException("O campo salario é obrigatório");
        this.salario = salario;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) throws ViolacaoRegraNegocioException {
        if(cargo == null)
            throw new ViolacaoRegraNegocioException("Você deve selecionar o cargo!");
        this.cargo = cargo;
    }        

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idFunc;
        hash = 17 * hash + Objects.hashCode(this.cargo);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
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
        final Funcionario other = (Funcionario) obj;
        if (this.idFunc != other.idFunc) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (this.cargo != other.cargo) {
            return false;
        }
        return true;
    }   
           
}
