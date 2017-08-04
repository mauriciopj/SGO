/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Douglas_Castro
 */
public class Pedido implements Entidade {
    private int id, qtd;
    private Date data;
    private Fornecedor fornecedor;
    private List<PedidoItem> itens;

    public Pedido() {
        
    }

    public Pedido(int qtd, Date data, Fornecedor fornecedor) {
        this.qtd = qtd;
        this.data = data;
        this.fornecedor = fornecedor;
        this.itens = new ArrayList<>();
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

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }
    
    public void addItem(PedidoItem item){
        item.setPedido(this);
        this.itens.add(item);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.qtd);
        hash = 97 * hash + Objects.hashCode(this.fornecedor);
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.qtd, other.qtd)) {
            return false;
        }
        return true;
    }

}
