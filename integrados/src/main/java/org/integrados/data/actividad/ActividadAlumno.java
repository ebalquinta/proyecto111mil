/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

import java.util.List;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.usuarios.Alumno;
import java.util.Date;
/**
 *
 * @author Yani, Jacco
 */
public class ActividadAlumno {
    
    private Integer id = null;
    private Actividad actividad;
    private Alumno alumno;
    private List<Bloque> respuestaAlumno;
    private Integer tiempo;
    private Date fechaInicio;
    private Date fechaFinal;
    private Boolean finalizoCorrectamente;
    private Integer intentos;
    private Integer estrella;
    private String corazon;
    private String observaciones;
            
    public ActividadAlumno(){ }

    public ActividadAlumno(Actividad actividad, Alumno alumno, List<Bloque> respuestaAlumno, Integer tiempo, Date fechaInicio, Date fechaFinal, Boolean finalizoCorrectamente, Integer intentos, Integer estrella) {
        this.actividad = actividad;
        this.alumno = alumno;
        this.respuestaAlumno = respuestaAlumno;
        this.tiempo = tiempo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.finalizoCorrectamente = finalizoCorrectamente;
        this.intentos = intentos;
        this.estrella = estrella;
    }
    
    /**
     * devuelve los minutos jugados en una hora
     */
    public double calcularMinutosJugados(){
        if(this.fechaInicio.getMinutes()<this.fechaFinal.getMinutes()){
            return  (this.fechaFinal.getMinutes() - this.fechaInicio.getMinutes());
        }else{
            return (60 - this.fechaInicio.getMinutes()) + this.fechaFinal.getMinutes();
        }
    }

    public Integer getId() {
        return id;
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

    public List<Bloque> getRespuestaAlumno() {
        return respuestaAlumno;
    }

    public void setRespuestaAlumno(List<Bloque> respuestaAlumno) {
        this.respuestaAlumno = respuestaAlumno;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
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

    public Boolean isFinalizoCorrectamente() {
        return finalizoCorrectamente;
    }

    public void setFinalizoCorrectamente(boolean finalizoCorrectamente) {
        this.finalizoCorrectamente = finalizoCorrectamente;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Integer getEstrella() {
        return estrella;
    }

    public void setEstrella(Integer estrella) {
        this.estrella = estrella;
    }

    public String getCorazon() {
        return corazon;
    }

    public void setCorazon(String corazon) {
        this.corazon = corazon;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    @Override
    public String toString() {
        return "ActividadAlumno{" + "id=" + id + ", actividad=" + actividad + ", alumno=" + alumno + ", tiempo=" + tiempo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", finalizoCorrectamente=" + finalizoCorrectamente + ", intentos=" + intentos +", corazon = " + corazon + ", observaciones=" + observaciones + '}';
    }

}
