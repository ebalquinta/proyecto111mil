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
public class Plantilla {

    protected Integer idPlantilla;
    protected BloqueTexto enunciado;
    protected List<Bloque> respuesta = new ArrayList<>();
    protected BloqueImagen imagen;
    protected BloqueSonido sonido;

    public Plantilla(List<Bloque> respuesta, BloqueTexto enunciado) {
        this.respuesta = respuesta;
        this.enunciado = enunciado;
    }

    public Plantilla(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen) {
        this(respuesta, enunciado);
        this.imagen = imagen;
    }

    public Plantilla(List<Bloque> respuesta, BloqueTexto enunciado, BloqueSonido sonido) {
        this(respuesta, enunciado);
        this.sonido = sonido;
    }

    public Plantilla(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, BloqueSonido sonido) {
        this(respuesta, enunciado, imagen);
        this.sonido = sonido;
    }

    public Integer getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(Integer idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    public BloqueTexto getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(BloqueTexto enunciado) {
        this.enunciado = enunciado;
    }

    public List<Bloque> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<Bloque> respuesta) {
        this.respuesta = respuesta;
    }

    public BloqueImagen getImagen() {
        return imagen;
    }

    public void setImagen(BloqueImagen imagen) {
        this.imagen = imagen;
    }

    public BloqueSonido getSonido() {
        return sonido;
    }

    public void setSonido(BloqueSonido sonido) {
        this.sonido = sonido;
    }

    @Override
    public String toString() {
        return "Plantilla{" + "idPlantilla=" + idPlantilla + ", enunciado=" + enunciado + ", respuesta=" + respuesta + ", imagen=" + imagen + ", sonido=" + sonido + '}';
    }

}
