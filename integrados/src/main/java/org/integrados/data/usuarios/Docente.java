package org.integrados.data.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.actividad.Actividad;

public class Docente extends Persona {

    private List<Alumno> alumnos;
    private List<Actividad> actividades;

    public Docente() {
        super();
        this.actividades = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Docente(Integer dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.actividades = new ArrayList<>();
        this.alumnos = new ArrayList<>();
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
        return super.toString() +"\n"+ "Docente{" + "alumnos=" + alumnos + ", actividades=" + actividades + '}';
    }
}
