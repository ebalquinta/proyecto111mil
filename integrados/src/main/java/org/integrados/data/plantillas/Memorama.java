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
public class Memorama extends Plantilla {

    private List<Bloque> bloque1 = new ArrayList<>();
    private List<Bloque> bloque2 = new ArrayList<>();

    public Memorama(List<Bloque> respuesta, BloqueTexto enunciado, List<Bloque> bloque1, List<Bloque> bloque2) {
        super(respuesta, enunciado);
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public Memorama(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, List<Bloque> bloque1, List<Bloque> bloque2) {
        super(respuesta, enunciado, imagen);
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public Memorama(List<Bloque> respuesta, BloqueTexto enunciado, BloqueSonido sonido, List<Bloque> bloque1, List<Bloque> bloque2) {
        super(respuesta, enunciado, sonido);
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public Memorama(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, BloqueSonido sonido, List<Bloque> bloque1, List<Bloque> bloque2) {
        super(respuesta, enunciado, imagen, sonido);
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public List<Bloque> getBloque1() {
        return bloque1;
    }

    public void setBloque1(List<Bloque> bloque1) {
        this.bloque1 = bloque1;
    }

    public List<Bloque> getBloque2() {
        return bloque2;
    }

    public void setBloque2(List<Bloque> bloque2) {
        this.bloque2 = bloque2;
    }

    @Override
    public String toString() {
        return "Memorama{" + "bloque1=" + bloque1 + ", bloque2=" + bloque2 + '}';
    }

}
