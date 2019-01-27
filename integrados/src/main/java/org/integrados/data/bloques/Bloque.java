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

    protected Integer id = null;

    public Bloque() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + '}';
    }

}
