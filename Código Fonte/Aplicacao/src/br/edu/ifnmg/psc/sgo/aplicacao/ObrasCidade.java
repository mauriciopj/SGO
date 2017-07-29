/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgo.aplicacao;

/**
 *
 * @author Dougla_Castro
 */
public enum ObrasCidade {
    
    Bonito_de_Minas(1, "Bonito de Minas"),
    Januária(2, "Januária"),
    Itacarambi(3, "Itacarambi"),
    P_Maria_da_Cruz(4, "P.Maria da Cruz"),;
   
    
    private int id;
    private String cidade;
    
    private ObrasCidade(int id, String cidade) {
        this.id = id;
        this.cidade = cidade;
    }           

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }        

    @Override
    public String toString() {
        return cidade;
    }
    
    public static ObrasCidade Abrir(int id){
        for(ObrasCidade c : ObrasCidade.values())
            if(id == c.getId())
                return c;
        return null;
    }
    
}
