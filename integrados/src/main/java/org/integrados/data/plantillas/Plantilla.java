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

    protected Integer id = null;
    protected String enunciado;
    protected List<Bloque> solucion;
    protected String imagen = null;
    protected String sonido = null;

    public Plantilla() {
        this.solucion = new ArrayList<>();
    }

    public Plantilla(String enunciado, List<Bloque> solucion) {
        this.solucion = new ArrayList<>();
        this.enunciado = enunciado;
        this.solucion = solucion;
    }

    public Integer getId() {
        return id;
    }

    public List<Bloque> getSolucion() {
        return solucion;
    }

    public void setSolucion(List<Bloque> solucion) {
        this.solucion = solucion;
    }
 
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
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

    public List<Bloque> clonarLista(List<Bloque> listaClonar) {
        List<Bloque> listaClonada = new ArrayList<>();
        
        for(Bloque b : listaClonar){
            listaClonada.add(b);
        }
        return listaClonada;
    }
    
    public abstract List<Bloque> desordenar();

    public abstract Boolean verificarResultado(List<Bloque> respuestaAlumno);

    public abstract Boolean validarPlantilla();

    @Override
    public String toString() {
        return "Plantilla{" + "id=" + id + ", enunciado=" + enunciado + ", solucion=" + solucion + ", imagen=" + imagen + ", sonido=" + sonido + '}';
    }

}
