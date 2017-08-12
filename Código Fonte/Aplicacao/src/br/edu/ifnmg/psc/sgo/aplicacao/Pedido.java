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
 * @author Douglas_Castro
 */
public class Pedido implements Entidade {
    private int id, quantidade = 0;
    private String data;
    private Fornecedor fornecedor;
    private List<ItemPedido> itens = null;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(int qtd, String data, Fornecedor fornecedor) {
        this.quantidade = qtd;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ViolacaoRegraNegocioException {
        if(quantidade <= 0)
            throw new ViolacaoRegraNegocioException("Você deve informar a quantidade!");
        this.quantidade = quantidade;
    }
   
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) throws ViolacaoRegraNegocioException {
        if(fornecedor == null)
            throw new ViolacaoRegraNegocioException("O fornecedor deve ser selecionado!");
        this.fornecedor = fornecedor;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) throws ViolacaoRegraNegocioException {
        if(itens == null)
            throw new ViolacaoRegraNegocioException("Você deve selecionar os itens para o pedido!");
        this.itens = itens;
    }
    
    public void addItem(ItemPedido item) throws ViolacaoRegraNegocioException {
        item.setPedido(this);
        if(item == null)
            throw new ViolacaoRegraNegocioException("Falha ao adicionar o item do pedido!");
        this.itens.add(item);
        this.quantidade += 1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + Objects.hashCode(this.quantidade);
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
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }

}
