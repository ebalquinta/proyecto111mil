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

    /*
    tipo Plantilla:
    ordenamiento = 1
    unir = 2
    preg y resp = 3
    memorama = 4
    
     */
    protected Integer id;
    protected String enunciado;
    protected List<Bloque> solucion;
    protected String imagenEnunciado;
    protected String sonidoEnunciado;
    protected Integer tipoPlantilla;

    public Plantilla() {
        this.sonidoEnunciado = null;
        this.imagenEnunciado = null;
        this.id = null;
        this.solucion = new ArrayList<>();
    }

    public Plantilla(String enunciado, List<Bloque> solucion) {
        this();
        this.enunciado = enunciado;
        this.solucion = solucion;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
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
        return imagenEnunciado;
    }

    public void setImagen(String imagen) {
        this.imagenEnunciado = imagen;
    }

    public String getSonido() {
        return sonidoEnunciado;
    }

    public void setSonido(String sonido) {
        this.sonidoEnunciado = sonido;
    }

    public Integer getTipoPlantilla() {
        return tipoPlantilla;
    }

    public void setTipoPlantilla(Integer tipoPlantilla) {
        this.tipoPlantilla = tipoPlantilla;
    }

    /**
     * clona una lista
     */
    public List<Bloque> clonarLista(List<Bloque> listaClonar) {
        List<Bloque> listaClonada = new ArrayList<>();

        for (Bloque b : listaClonar) {
            listaClonada.add(b);
        }
        return listaClonada;
    }

    public abstract List<Bloque> desordenar();

    public abstract Boolean verificarResultado(List<Bloque> respuestaAlumno);

    public abstract Boolean validarPlantilla();

    @Override
    public String toString() {
        return "Plantilla{" + "id=" + id + ", enunciado=" + enunciado + ", solucion=" + solucion + ", imagenEnunciado=" + imagenEnunciado + ", sonidoEnunciado=" + sonidoEnunciado + ", tipoPlantilla=" + tipoPlantilla + '}';
    }

}
