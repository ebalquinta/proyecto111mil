/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

import java.util.Date;
import org.integrados.data.usuarios.Alumno;

/**
 *
 * @author Yani
 */
public class ActividadAlumno {

    private Integer id;
    private Actividad actividad;
    private Alumno alumno;
    private int tiempo;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean finalizoCorrectamente;
    private int intentos;
    private Recompensa recompensas;
    private String observaciones;

    public ActividadAlumno(Actividad actividad, Alumno alumno, int tiempo, Date fechaInicio, Date fechaFinal, boolean finalizoCorrectamente, int intentos) {
        this.actividad = actividad;
        this.alumno = alumno;
        this.tiempo = tiempo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.finalizoCorrectamente = finalizoCorrectamente;
        this.intentos = intentos;
    }

    public ActividadAlumno(Actividad actividad, Alumno alumno, int tiempo, Date fechaInicio, Date fechaFinal, boolean finalizoCorrectamente, int intentos, Recompensa recompensas) {
        this(actividad, alumno, tiempo, fechaInicio, fechaFinal, finalizoCorrectamente, intentos);
        this.recompensas = recompensas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isFinalizoCorrectamente() {
        return finalizoCorrectamente;
    }

    public void setFinalizoCorrectamente(boolean finalizoCorrectamente) {
        this.finalizoCorrectamente = finalizoCorrectamente;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public Recompensa getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(Recompensa recompensas) {
        this.recompensas = recompensas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "ActividadAlumno{" + "id=" + id + ", actividad=" + actividad + ", alumno=" + alumno + ", tiempo=" + tiempo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", finalizoCorrectamente=" + finalizoCorrectamente + ", intentos=" + intentos + ", recompensas=" + recompensas + ", observaciones=" + observaciones + '}';
    }

}
