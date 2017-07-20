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
public enum CargoFuncionario {
    ARQUITETO(1, "Arquiteto"),
    ENGENHEIRO(2, "Engenheiro"),
    MESTRE_DE_OBRAS(3, "Mestre de obras"),
    PEDREIRO(4, "Pedreiro"),
    SERVENTE_OU_AUXILIAR(5, "Servente ou auxiliar"),
    ARMADOR(6, "Armador"),
    PINTOR(7, "Pintor"),
    ELETRICISTA(8, "Eletricista"),
    ENCANADOR(9, "Encanador"),
    SECRETARIA(10, "Secretária(o)"),
    COORDENADOR_DE_OBRAS(11, "Coordenador de obras"),;
    
    private int id;
    private String cargo;
    
    private CargoFuncionario(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }           

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }        

    @Override
    public String toString() {
        return cargo;
    }
    
    public static CargoFuncionario Abrir(int id){
        for(CargoFuncionario c : CargoFuncionario.values())
            if(id == c.getId())
                return c;
        return null;
    }
}
