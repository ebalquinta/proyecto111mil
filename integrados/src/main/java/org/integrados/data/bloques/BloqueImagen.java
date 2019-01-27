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
public class BloqueImagen extends Bloque {

    private String imagen;
    
    public BloqueImagen(){
        super();
    }

    public BloqueImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // hay que hacer el metodo
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + "BloqueImagen{" + "imagen=" + imagen + '}';
    }

}
