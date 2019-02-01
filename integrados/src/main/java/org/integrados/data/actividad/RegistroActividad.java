package org.integrados.data.actividad;

import java.util.List;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author Yani, Jacco
 */
public class RegistroActividad {

    private Integer id;
    private Actividad actividad;
    private Alumno alumno;
    private Docente docente;
    private List<Bloque> respuestaAlumno;
    private Integer tiempo;
    private Boolean finalizoCorrectamente;
    private Integer intentos;
    private Integer estrella;
    private String corazon;
    private String observaciones;

    public RegistroActividad() {
        this.id = null;
    }

    public RegistroActividad(Actividad actividad, Alumno alumno, Docente docente) {
        this();
        this.actividad = actividad;
        this.alumno = alumno;
        this.docente = docente;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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

    public Boolean getFinalizoCorrectamente() {
        return finalizoCorrectamente;
    }

    public void setFinalizoCorrectamente(Boolean finalizoCorrectamente) {
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
    
    /**
     * Este metodo calcula el porcentaje obtenido una ves realizada la actividad exitosamente.
     * Teniendo en cuenta la cantidad de intentos en que se realizó la actividad.
     * 
     * @return  double
     */
    public double calcularPuntaje() {
        double porcentaje;
        
        //compara la cantidad de intentos realizados con el maximo cargado por el docente.
        if (this.intentos == 1) {
            porcentaje = 100;

            return porcentaje;
        } else {
            this.intentos -= 1;
            double totalPorc = 100 / this.actividad.getMaxIntentos();
            porcentaje = 100 - (totalPorc * this.intentos);

            return porcentaje;
        }
    }
    /**
     * En base al porcentaje de aciertos calcula la cantidad de estrellas que se otorgaran por la actividad realizada.
     * @return int
     */
     public int calcularEstrellas() {
        double porcentaje = this.calcularPuntaje();

        if (porcentaje == 100) {
            return 3;
        } else if ((porcentaje <= 99) && (porcentaje >= 33)) {
            return 2;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "RegistroActividad{" + "id=" + id + ", actividad=" + actividad + ", alumno=" + alumno + ", docente=" + docente + ", respuestaAlumno=" + respuestaAlumno + ", tiempo=" + tiempo + ", finalizoCorrectamente" + finalizoCorrectamente + ", intentos=" + intentos + ", estrella=" + estrella + ", corazon=" + corazon + ", observaciones=" + observaciones + '}';
    }

}
