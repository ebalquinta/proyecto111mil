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
public class PregYResp extends Plantilla {

    private List<Plantilla> preguntas = new ArrayList<>();

    public PregYResp(List<Bloque> respuesta, BloqueTexto enunciado, List<Plantilla> preguntas) {
        super(respuesta, enunciado);
        this.preguntas = preguntas;
    }

    public PregYResp(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, List<Plantilla> preguntas) {
        super(respuesta, enunciado, imagen);
        this.preguntas = preguntas;
    }

    public PregYResp(List<Bloque> respuesta, BloqueTexto enunciado, BloqueSonido sonido, List<Plantilla> preguntas) {
        super(respuesta, enunciado, sonido);
        this.preguntas = preguntas;
    }

    public PregYResp(List<Bloque> respuesta, BloqueTexto enunciado, BloqueImagen imagen, BloqueSonido sonido, List<Plantilla> preguntas) {
        super(respuesta, enunciado, imagen, sonido);
        this.preguntas = preguntas;
    }

    public List<Plantilla> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Plantilla> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "PregYResp{" + "preguntas=" + preguntas + '}';
    }

}
