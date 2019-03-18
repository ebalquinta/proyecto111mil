/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaabm;

public class Actividad {
    
    private Integer id;
    private String nombre;
    private String dificultad;
    
    public Actividad() {}
    
    public Actividad(Integer id, String nombre, String dificultad) {
        this.id = id;
        this.nombre = nombre;
        this.dificultad = dificultad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    public boolean equals(Object argObject) {
        Actividad argActividad = (Actividad)argObject;        
        return (this.id.equals(argActividad.getId()));
    } 
}