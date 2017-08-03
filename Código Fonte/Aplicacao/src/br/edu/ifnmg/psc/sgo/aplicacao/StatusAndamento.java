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
public enum StatusAndamento {
    EM_EXECUCAO(1, "Em execução"),
    PARADO(2, "Parado"),
    FINALIZADO(3, "Finalizado");                    
    
    private int id;
    private String descricao;

    private StatusAndamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
    public static StatusAndamento Abrir(int id){
        for(StatusAndamento s : StatusAndamento.values())
            if(id == s.getId())
                return s;
        return null;
    }
}
