/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

/**
 *
 * @author Yani
 */
public class Materia {
    private Integer id = null;
    private String materia;
    
    public Materia(String materia){
        this.materia = materia;
    }
    
    public String getMateria(){
        return this.materia;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    @Override
    public String toString(){
        return "ID = " + this.id + ", materia = " + this.materia;
    }
}
