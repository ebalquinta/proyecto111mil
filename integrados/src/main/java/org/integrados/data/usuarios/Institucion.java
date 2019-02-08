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

    private Integer id;
    private String nombreInstitucion;
    private List<Docente> docentes;
    private Docente administrador;

    public Institucion() {
        this.docentes = new ArrayList<>();
        this.id = null;
    }

    public Institucion(String nombreInstitucion, Docente administrador) {
        this();
        this.nombreInstitucion = nombreInstitucion;
        this.administrador = administrador;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
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

    public Docente getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Docente administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Institucion{" + "id=" + id + ", nombreInstitucion=" + nombreInstitucion + ", docentes=" + docentes + ", administrador=" + administrador + '}';
    }

}
