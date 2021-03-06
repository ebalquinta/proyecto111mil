package org.integrados.data.actividad;

import org.integrados.data.enums.*;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.usuarios.*;

/**
 *
 * @author Jacco
 */
public class Actividad {

    private Integer id;
    private Plantilla plantilla;
    private Docente docenteCreador;
    private Materia materia;
    private String tema;
    private Integer grado;
    private Nivel nivel;
    private Dificultad dificultad;
    private Integer maxIntentos;
    
    public Actividad(){ 
        this.id = null;
    }

    public Actividad( Plantilla plantilla, Docente docenteCreador, Materia materia, String tema, Integer grado, Nivel nivel, Dificultad dificultad, Integer maxIntentos) {
        this();
        this.plantilla = plantilla;
        this.docenteCreador = docenteCreador;
        this.materia = materia;
        this.tema = tema;
        this.grado = grado;
        this.nivel = nivel;
        this.dificultad = dificultad;
        this.maxIntentos = maxIntentos;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }
    
    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    public Docente getDocenteCreador() {
        return docenteCreador;
    }

    public void setDocenteCreador(Docente docenteCreador) {
        this.docenteCreador = docenteCreador;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Integer getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(Integer maxIntentos) {
        this.maxIntentos = maxIntentos;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + id + ", plantilla=" + plantilla + ", docente=" + docenteCreador + ", materia=" + materia + ", tema=" + tema + ", grado=" + grado + ", nivel=" + nivel + ", dificultad=" + dificultad + ", maxIntentos=" + maxIntentos + '}';
    }

}
