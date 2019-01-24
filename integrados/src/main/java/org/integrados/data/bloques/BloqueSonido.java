/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.bloques;

/**
 *
 * @author Yani
 */
public class BloqueSonido extends Bloque {

    private String sonido;

    public BloqueSonido(boolean valido, String sonido) {
        super(valido);
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public String toString() {
        return "BloqueSonido{" + "sonido=" + sonido + '}';
    }

}
