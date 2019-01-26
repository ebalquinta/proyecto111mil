/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.plantillas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.bloques.*;

/**
 *
 * @author Yani
 */
public abstract class Plantilla {

    protected Integer id;
    protected String enunciado;
    protected List<Bloque> solucion;
    protected String imagen;
    protected String sonido;

    public Plantilla(String enunciado, List<Bloque> solucion) {
        this.enunciado = enunciado;
        this.solucion = solucion;
        this.imagen = null;
        this.sonido = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Bloque> getSolucion() {
        return solucion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public String toString() {
        return "Plantilla{" + "id=" + id + ", enunciado=" + enunciado + ", solucion=" + solucion + ", imagen=" + imagen + ", sonido=" + sonido + '}';
    }
    
    public abstract List<Bloque> clonarLista();
    public abstract List<Bloque> desordenar();
    public abstract boolean verificarResultado(List<Bloque> respuestaAlumno);
    public abstract boolean validarPlantilla();

}
