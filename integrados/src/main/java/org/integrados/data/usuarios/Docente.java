package org.integrados.data.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;

public class Docente extends Persona {

    private List<Alumno> alumnos;
    private List<Actividad> actividades;
    private List<RegistroActividad> registroActividades;
    private Institucion institucion;

    public Docente() {
        super();
        this.actividades = new ArrayList<>();
        this.registroActividades = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public Docente(Integer dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.actividades = new ArrayList<>();
        this.registroActividades = new ArrayList<>();
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

    public List<RegistroActividad> getRegistroActividades() {
        return registroActividades;
    }

    public void setRegistroActividades(List<RegistroActividad> registroActividades) {
        this.registroActividades = registroActividades;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Override
    public String toString() {
        return "Docente{" + "alumnos=" + alumnos + ", actividades=" + actividades + ", registroActividades=" + registroActividades + ", institucion=" + institucion + '}';
    }

}
