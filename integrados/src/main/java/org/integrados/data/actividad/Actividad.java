/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

import org.integrados.data.enums.*;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.usuarios.*;

/**
 *
 * @author Yani
 */
public class Actividad {

    private Integer idPlantilla;
    private Plantilla plantilla;
    private Docente docente;
    private Materia materia;
    private String tema;
    private int grado;
    private Nivel nivel;
    private Dificultad dificultad;
    private int maxIntentos;
    private int estrellasMax;

    public Actividad(Plantilla plantilla, Docente docente, Materia materia, String tema, int grado, Nivel nivel, Dificultad dificultad, int maxIntentos) {
        this.plantilla = plantilla;
        this.docente = docente;
        this.materia = materia;
        this.tema = tema;
        this.grado = grado;
        this.nivel = nivel;
        this.dificultad = dificultad;
        this.maxIntentos = maxIntentos;
    }

    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;

    }

    public Plantilla getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Plantilla plantilla) {
        this.plantilla = plantilla;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
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

    public int getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(int maxIntentos) {
        this.maxIntentos = maxIntentos;
    }

    public int getEstrellasMax() {
        return estrellasMax;
    }

    public void setEstrellasMax(int estrellasMax) {
        this.estrellasMax = estrellasMax;
    }

    @Override
    public String toString() {
        return "Actividad{" + "idPlantilla=" + idPlantilla + ", plantilla=" + plantilla + ", docente=" + docente + ", materia=" + materia + ", tema=" + tema + ", grado=" + grado + ", nivel=" + nivel + ", dificultad=" + dificultad + ", maxIntentos=" + maxIntentos + ", estrellasMax=" + estrellasMax + '}';
    }

}
