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
    
    private Integer id;
    private Actividad actividad;
    private Alumno alumno;
    private List<Bloque> respuestaAlumno;
    private int tiempo;
    private Date fechaInicio;
    private Date fechaFinal;
    private boolean finalizoCorrectamente;
    private int intentos;
    private int estrella;
    private String corazon;
    private String observaciones;
            
    public ActividadAlumno(){ }

    public ActividadAlumno(Actividad actividad, Alumno alumno, List<Bloque> respuestaAlumno, int tiempo, Date fechaInicio, Date fechaFinal, boolean finalizoCorrectamente, int intentos, int estrella) {
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
    
    @Override
    public String toString() {
        return "ActividadAlumno{" + "id=" + id + ", actividad=" + actividad + ", alumno=" + alumno + ", tiempo=" + tiempo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", finalizoCorrectamente=" + finalizoCorrectamente + ", intentos=" + intentos +", corazon = " + corazon + ", observaciones=" + observaciones + '}';
    }

}
