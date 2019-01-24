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
public abstract class Bloque {
    
    protected Integer id;
    protected boolean valido;

    public Bloque(boolean valido) {
        this.valido = valido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + ", valido=" + valido + '}';
    }
    
    
    
}
