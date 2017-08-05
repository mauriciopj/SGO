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
public class PedidoItem implements Entidade {
    private int id;
    private MaterialConstrucao material;
    private int quantidade;
    private Pedido pedido;

    public PedidoItem() {
    }

    public PedidoItem(int id, MaterialConstrucao material, int quantidade, Pedido pedido) {
        this.id = id;
        this.material = material;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public MaterialConstrucao getMaterial() {
        return material;
    }

    public void setMaterial(MaterialConstrucao material) throws ViolacaoRegraNegocioException {
        if(material == null)
            throw new ViolacaoRegraNegocioException("Você deve selecionar o material para o pedido!");
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ViolacaoRegraNegocioException {
        if(quantidade <= 0)
            throw new ViolacaoRegraNegocioException("Você deve informar a quantidade!");
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) throws ViolacaoRegraNegocioException {
        if(pedido == null)
            throw new ViolacaoRegraNegocioException("O pedido não foi selecionado!");
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.material);
        hash = 79 * hash + this.quantidade;
        hash = 79 * hash + Objects.hashCode(this.pedido);
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
        final PedidoItem other = (PedidoItem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }
    
    
}
