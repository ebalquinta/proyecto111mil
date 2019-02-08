/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.ABM;

public class ActividadABM {
    
    private Integer id;
    private String plantilla;
    private String docente;
    private String materia;
    private String tema;
    
    public ActividadABM() {}
    
    public ActividadABM(Integer id, String plantilla, String docente, 
            String materia, String tema) {
        this.id = id;
        this.plantilla = plantilla;
        this.docente = docente;
        this.materia = materia;
        this.tema = tema;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(String plantilla) {
        this.plantilla = plantilla;
    }

    public String getDocente() {
        return this.docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public boolean equals(Object argObject) {
        ActividadABM argActividad = (ActividadABM)argObject;        
        return (this.id.equals(argActividad.getId()));
    } 
}