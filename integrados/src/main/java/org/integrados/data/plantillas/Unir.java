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
public class Unir extends Plantilla {

    private List<Bloque> bloquesDer = new ArrayList<>();
    private List<Bloque> bloquesIzq = new ArrayList<>();

    public Unir(List<Bloque> respuesta, BloqueTexto enunciado, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(respuesta, enunciado);
        this.bloquesDer = bloquesDer;
        this.bloquesIzq = bloquesIzq;
    }

    public Unir(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(respuesta, enunciado, imagen);
        this.bloquesDer = bloquesDer;
        this.bloquesIzq = bloquesIzq;
    }

    public Unir(List<Bloque> respuesta, BloqueTexto enunciado, BloqueSonido sonido, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(respuesta, enunciado, sonido);
        this.bloquesDer = bloquesDer;
        this.bloquesIzq = bloquesIzq;
    }

    public Unir(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, BloqueSonido sonido, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(respuesta, enunciado, imagen, sonido);
        this.bloquesDer = bloquesDer;
        this.bloquesIzq = bloquesIzq;
    }

    public List<Bloque> getBloquesDer() {
        return bloquesDer;
    }

    public void setBloquesDer(List<Bloque> bloquesDer) {
        this.bloquesDer = bloquesDer;
    }

    public List<Bloque> getBloquesIzq() {
        return bloquesIzq;
    }

    public void setBloquesIzq(List<Bloque> bloquesIzq) {
        this.bloquesIzq = bloquesIzq;
    }

    @Override
    public String toString() {
        return "Unir{" + "bloquesDer=" + bloquesDer + ", bloquesIzq=" + bloquesIzq + '}';
    }

}
