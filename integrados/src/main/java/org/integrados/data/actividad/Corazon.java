/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

/**
 *
 * @author Yani
 */
public class Corazon extends Recompensa {

    private String comentarios;

    public Corazon(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int getRecompensa() {
        if (this.comentarios != null) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Corazon{" + "comentarios=" + comentarios + '}';
    }

}
