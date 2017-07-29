/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;
import br.edu.ifnmg.psc.sgo.aplicacao.Entidade;
import br.edu.ifnmg.psc.sgo.aplicacao.ViolacaoRegraNegocioException;
import java.util.Objects;
/**
 *
 * @author Dougla_Castro
 */
public class ObrasEServicos implements Entidade {
     private int idObras;
     private ObrasCidade cidade;
    private String descricao;
    private String bairro;
    private String numero;
    private String complemento;
    private String rua;
    private int idCliente;
     
     
     public ObrasEServicos() {
    }
     
       public ObrasEServicos(String descricao, String bairro, ObrasCidade cidade, String numero, String complemento, String rua,  int idCliente) {
        this.descricao = descricao;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.complemento = complemento;
       
        this.rua = rua;
        
        this.idCliente = idCliente;
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
    
     @Override
    public int hashCode() {
        int hash = 4;
        hash = 61 * hash + this.idObras;
        hash = 61 * hash + Objects.hashCode(this.cidade);
       
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
        if (this.cidade != other.cidade) {
            return false;
        }
        
        return true;
    }     

    public Object getidCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setidCliente(int IdCliente) {
          this.idCliente = IdCliente;
    }

    public void setRua(String rua) {
        this. rua= rua;
    }

   
           
}
