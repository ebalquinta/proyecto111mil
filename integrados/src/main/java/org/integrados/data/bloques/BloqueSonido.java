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
    
    public BloqueSonido(){
        super();
    }

    public BloqueSonido(String sonido) {
        this();
        this.sonido = sonido;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    // hay que hacer el metodo
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\n" + "BloqueSonido{" + "sonido=" + sonido + '}';
    }

}
