/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mauricio
 */
public class Trabalho implements Entidade {
    private int idTrab;
    private Date dataInicio;
    private Date dataTermino;
    private StatusAndamento andamento;
    //private ObrasEServico ob;

    public Trabalho() {
        
    }        
    
    @Override
    public void setId(int id) {
        this.idTrab = id;
    }

    @Override
    public int getId() {
        return idTrab;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) throws ViolacaoRegraNegocioException {
        if(dataInicio == null)
            throw new ViolacaoRegraNegocioException("A data de início é obrigatória!");
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) throws ViolacaoRegraNegocioException {
        if(dataTermino == null)
            throw new ViolacaoRegraNegocioException("A data de término é obrigatória!");
        this.dataTermino = dataTermino;
    }

    public StatusAndamento getAndamento() {
        return andamento;
    }

    public void setAndamento(StatusAndamento andamento) throws ViolacaoRegraNegocioException {
        if(andamento == null)
            throw new ViolacaoRegraNegocioException("É obrigatório selecionar o andamento!");
        this.andamento = andamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.idTrab;
        hash = 41 * hash + Objects.hashCode(this.dataInicio);
        hash = 41 * hash + Objects.hashCode(this.dataTermino);
        hash = 41 * hash + Objects.hashCode(this.andamento);
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
        if (this.idTrab != other.idTrab) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (this.andamento != other.andamento) {
            return false;
        }
        return true;
    }           
    
}
