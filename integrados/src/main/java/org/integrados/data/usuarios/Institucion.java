/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.usuarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yani
 */
public class Institucion {

    private Integer idInstitucion;
    private String nombreInstitucion;
    private List<Docente> docentes;
    private List<Alumno> alumnos;
    private Persona administrador;

    public Institucion(Persona administrador) {
        this.administrador = administrador;
        this.docentes = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public Institucion(Persona administrador, String nombreInstitucion) {
        this(administrador);
        this.nombreInstitucion = nombreInstitucion;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Persona getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Persona administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Institucion{" + "idInstitucion=" + idInstitucion + ", nombreInstitucion=" + nombreInstitucion + ", docentes=" + docentes + ", alumnos=" + alumnos + ", administrador=" + administrador + '}';
    }

}
