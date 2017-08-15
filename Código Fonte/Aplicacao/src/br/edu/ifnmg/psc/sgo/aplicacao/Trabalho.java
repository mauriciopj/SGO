/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mauricio
 */
public class Trabalho implements Entidade {
    private int id;
    private String dataInicio, dataTermino, ultimaModificacao;
    private StatusAndamento andamento;
    private ObrasEServicos obraEServico;
    private List<TrabalhoFuncionario> funcionarios = null;

    public Trabalho() {
        this.funcionarios = new ArrayList<>();      
    } 

    public Trabalho(int id, String dataInicio, String dataTermino, String ultimaModificacao, StatusAndamento andamento, ObrasEServicos obraEServico, List<TrabalhoFuncionario> funcionarios) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.ultimaModificacao = ultimaModificacao;
        this.andamento = andamento;
        this.obraEServico = obraEServico;
        this.funcionarios = new ArrayList<>(); 
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws ViolacaoRegraNegocioException {
        if(dataInicio == null)
            throw new ViolacaoRegraNegocioException("A data de início é obrigatória!");
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) throws ViolacaoRegraNegocioException {
        if(dataTermino == null)
            throw new ViolacaoRegraNegocioException("Informe a possível data de término!");
        this.dataTermino = dataTermino;
    }

    public String getUltimaModificacao() {
        return ultimaModificacao;
    }

    public void setUltimaModificacao(String ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public StatusAndamento getAndamento() {
        return andamento;
    }

    public void setAndamento(StatusAndamento andamento) throws ViolacaoRegraNegocioException {
        if(andamento == null)
            throw new ViolacaoRegraNegocioException("Selecione o andamento da obra ou serviço!");
        this.andamento = andamento;
    }

    public ObrasEServicos getObraEServico() {
        return obraEServico;
    }

    public void setObraEServico(ObrasEServicos obraEServico) throws ViolacaoRegraNegocioException {
        if(obraEServico == null)
            throw new ViolacaoRegraNegocioException("A obra ou serviço não foi selecionado!");
        this.obraEServico = obraEServico;
    }

    public List<TrabalhoFuncionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<TrabalhoFuncionario> funcionarios) throws ViolacaoRegraNegocioException {
        if(funcionarios == null)
            throw new ViolacaoRegraNegocioException("Você deve selecionar os funcionários!");
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(TrabalhoFuncionario funcionario) throws ViolacaoRegraNegocioException{
        funcionario.setTrabalho(this);
        if (funcionario == null)
            throw new ViolacaoRegraNegocioException("Falha ao incluir o funcionário!");         
        this.funcionarios.add(funcionario);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.dataInicio);
        hash = 53 * hash + Objects.hashCode(this.dataTermino);
        hash = 53 * hash + Objects.hashCode(this.ultimaModificacao);
        hash = 53 * hash + Objects.hashCode(this.andamento);
        hash = 53 * hash + Objects.hashCode(this.obraEServico);
        hash = 53 * hash + Objects.hashCode(this.funcionarios);
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
        final Trabalho other = (Trabalho) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (!Objects.equals(this.ultimaModificacao, other.ultimaModificacao)) {
            return false;
        }
        if (this.andamento != other.andamento) {
            return false;
        }
        if (!Objects.equals(this.obraEServico, other.obraEServico)) {
            return false;
        }
        if (!Objects.equals(this.funcionarios, other.funcionarios)) {
            return false;
        }
        return true;
    }

    
}
