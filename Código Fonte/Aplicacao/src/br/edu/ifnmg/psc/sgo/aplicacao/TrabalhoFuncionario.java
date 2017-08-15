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
public class TrabalhoFuncionario implements Entidade {
    private int id;
    private Funcionario funcionario;
    private Trabalho trabalho;   

    public TrabalhoFuncionario() {
    }

    public TrabalhoFuncionario(int id, Funcionario funcionario, Trabalho trabalho) {
        this.id = id;
        this.funcionario = funcionario;
        this.trabalho = trabalho;
    }   

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }   

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) throws ViolacaoRegraNegocioException {
        if(funcionario == null)
            throw new ViolacaoRegraNegocioException("O funcionário não foi selecionado!");
        this.funcionario = funcionario;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.funcionario);
        hash = 17 * hash + Objects.hashCode(this.trabalho);
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
        final TrabalhoFuncionario other = (TrabalhoFuncionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.trabalho, other.trabalho)) {
            return false;
        }
        return true;
    }
        
}
