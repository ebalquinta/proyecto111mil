/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.actividad.Actividad;

/**
 *
 * @author Yani
 */
public class Docente extends Persona {

    private List<Alumno> alumnos;
    private List<Actividad> actividades;

    public Docente(int dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.alumnos = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public Docente(int dni, String nombre, String apellido, String usuario, String clave) {
        super(dni, nombre, apellido, usuario, clave);
        this.alumnos = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Docente{" + "alumnos=" + alumnos + ", actividades=" + actividades + '}';
    }

}
