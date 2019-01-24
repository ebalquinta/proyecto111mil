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
public class Ordenamiento extends Plantilla {

    private List<BloqueAnd> bloques= new ArrayList<>();;

    public Ordenamiento(List<Bloque> respuesta, BloqueTexto enunciado, List<BloqueAnd> bloques) {
        super(respuesta, enunciado);
        this.bloques = bloques;
    }

    public Ordenamiento(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, List<BloqueAnd> bloques) {
        super(respuesta, enunciado, imagen);
        this.bloques = bloques;
    }

    public Ordenamiento(List<Bloque> respuesta, BloqueTexto enunciado, BloqueSonido sonido, List<BloqueAnd> bloques) {
        super(respuesta, enunciado, sonido);
        this.bloques = bloques;
    }

    public Ordenamiento(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, BloqueSonido sonido, List<BloqueAnd> bloques) {
        super(respuesta, enunciado, imagen, sonido);
        this.bloques = bloques;
    }

    public List<BloqueAnd> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueAnd> bloques) {
        this.bloques = bloques;
    }

    @Override
    public String toString() {
        return "Ordenamiento{" + "bloques=" + bloques + '}';
    }

}
