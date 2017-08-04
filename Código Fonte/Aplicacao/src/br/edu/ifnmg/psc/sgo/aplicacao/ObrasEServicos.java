/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;
import java.util.Objects;
/**
 *
 * @author Dougla_Castro
 */
public class ObrasEServicos implements Entidade {
    private int idObras;
    private ObrasCidade cidade;
    private String descricao, bairro, numero, complemento, rua;
    private Cliente cliente;
     
     
    public ObrasEServicos() {
    }
     
    public ObrasEServicos(String descricao, String bairro, ObrasCidade cidade, String numero, String complemento, String rua, Cliente cliente) {
        this.descricao = descricao;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
        this.rua = rua;
        this.cliente = cliente;
    }  
       
    @Override
    public void setId(int id) {
        this.idObras = id;
    }
    
    @Override
    public int getId() {
        return idObras;
    }
    
    public ObrasCidade getCidade() {
        return cidade;
    }
    
    public void setCidade(ObrasCidade cidade) throws ViolacaoRegraNegocioException {
        if(cidade == null)
            throw new ViolacaoRegraNegocioException("Você deve selecionar a cidade!");
        this.cidade = cidade;
    } 

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
       return descricao;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getRua() {
            return rua;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setBairro(String bairro) {
         this.bairro = bairro;
    }

    public void setComplemento(String complemnento) {
         this.complemento = complemnento;
    }

    public void setNumero(String numero) {
         this.numero = numero;
    }

    public void setRua(String rua) {
        this. rua= rua;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idObras;
        hash = 79 * hash + Objects.hashCode(this.cidade);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.bairro);
        hash = 79 * hash + Objects.hashCode(this.numero);
        hash = 79 * hash + Objects.hashCode(this.complemento);
        hash = 79 * hash + Objects.hashCode(this.rua);
        hash = 79 * hash + Objects.hashCode(this.cliente);
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
        final ObrasEServicos other = (ObrasEServicos) obj;
        if (this.idObras != other.idObras) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.cidade != other.cidade) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

   
           
}
