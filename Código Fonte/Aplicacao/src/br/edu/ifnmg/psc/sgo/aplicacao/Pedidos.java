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
 * @author Douglas_Castro
 */
public class Pedidos implements Entidade {
    private int id, qtd;
    private Date data;
    private Fornecedor fornecedor;
    private MaterialConstrucao material;

    public Pedidos() {
        
    }

    public Pedidos(int id, int qtd, Date data, Fornecedor fornecedor, MaterialConstrucao material) {
        this.id = id;
        this.qtd = qtd;
        this.data = data;
        this.fornecedor = fornecedor;
        this.material = material;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

     public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
   

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public MaterialConstrucao getMaterial() {
        return material;
    }

    public void setMaterial(MaterialConstrucao material) {
        this.material = material;
    }            
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.qtd);
        hash = 97 * hash + Objects.hashCode(this.fornecedor);
        hash = 97 * hash + Objects.hashCode(this.material);
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
        final Pedidos other = (Pedidos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.qtd, other.qtd)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.material)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return true;
    }

}
