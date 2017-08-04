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
public class ListaMaterial implements Entidade {
    private int idLM, qtd;
    private MaterialConstrucao material;

    public ListaMaterial() {
        
    }

    public ListaMaterial(int qtd, MaterialConstrucao material) {
        this.qtd = qtd;
        this.material = material;
    }   

    @Override
    public int getId() {
        return idLM;
    }

    @Override
    public void setId(int id) {
        this.idLM = id;
    }

    public MaterialConstrucao getMaterial() {
        return material;
    }

    public void setMaterial(MaterialConstrucao material) {
        this.material = material;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
