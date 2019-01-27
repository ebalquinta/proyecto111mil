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

    private Integer id = null;
    private String nombreInstitucion;
    private List<Docente> docentes = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private Persona administrador;

    public Institucion() {
    }

    public Institucion(String nombreInstitucion, Persona administrador) {
        this.nombreInstitucion = nombreInstitucion;
        this.administrador = administrador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Institucion{" + "id=" + id + ", nombreInstitucion=" + nombreInstitucion + ", docentes=" + docentes + ", alumnos=" + alumnos + ", administrador=" + administrador + '}';
    }

}
