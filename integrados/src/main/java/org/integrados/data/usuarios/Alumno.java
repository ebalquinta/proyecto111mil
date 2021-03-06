package org.integrados.data.usuarios;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.enums.Nivel;
import static org.integrados.data.util.Util.dateToString;

public class Alumno extends Persona {

    private List<Docente> docentes;
    private List<RegistroActividad> registroActividades;
    private Date fechaNacimiento;
    private Integer edadMadurativa;
    private Integer grado;
    private String division;
    private Nivel nivel;
    private String observaciones;

    public Alumno() {
        super();
        this.docentes = new ArrayList<>();
        this.registroActividades = new ArrayList<>();
    }

    public Alumno(Integer dni, String nombre, String apellido, Integer grado, String division, Nivel nivel) {
        super(dni, nombre, apellido);
        this.docentes = new ArrayList<>();
        this.registroActividades = new ArrayList<>();
        this.grado = grado;
        this.division = division;
        this.nivel = nivel;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<RegistroActividad> getRegistroActividades() {
        return registroActividades;
    }

    public void setRegistroActividades(List<RegistroActividad> registroActividades) {
        this.registroActividades = registroActividades;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdadMadurativa() {
        return edadMadurativa;
    }

    public void setEdadMadurativa(Integer edadMadurativa) {
        this.edadMadurativa = edadMadurativa;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer calcularEdad() {

        String fechaString = dateToString(this.fechaNacimiento);

        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatoEdad = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatoEdad);
        Period diff = Period.between(fecha, hoy);

        return diff.getYears();
    }

    @Override
    public String toString() {
        return "Alumno{" + "docentes=" + docentes + ", registroActividades=" + registroActividades + ", fechaNacimiento=" + fechaNacimiento + ", edadMadurativa=" + edadMadurativa + ", grado=" + grado + ", division=" + division + ", nivel=" + nivel + ", observaciones=" + observaciones + '}';
    }

}
