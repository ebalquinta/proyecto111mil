/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Yani
 */
public class Alumno extends Persona {

    private List<RegistroActividad> actividades;
    private Date fechaNacimiento;
    private Integer edadMadurativa;
    private Integer grado;
    private String division;
    private Nivel nivel;
    private String observaciones;

    public Alumno() {
        super();
        this.actividades = new ArrayList<>();
    }

    public Alumno(Integer dni, String nombre, String apellido, Integer grado, String division, Nivel nivel) {
        super(dni, nombre, apellido);
        this.actividades = new ArrayList<>();
        this.grado = grado;
        this.division = division;
        this.nivel = nivel;
    }

    public List<RegistroActividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<RegistroActividad> actividades) {
        this.actividades = actividades;
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

    public int calcularEdad() {

        String fechaString = dateToString(this.fechaNacimiento);

        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatoEdad = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatoEdad);
        Period diff = Period.between(fecha, hoy);
        
        return diff.getYears();
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" + "actividades=" + actividades + ", fechaNacimiento=" + fechaNacimiento + ", edadMadurativa=" + edadMadurativa + ", grado=" + grado + ", division=" + division + ", nivel=" + nivel + ", observaciones=" + observaciones + '}';
    }

}
