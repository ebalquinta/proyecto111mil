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
public class Bloque {

    protected Integer id;

    protected Bloque() {
        this.id= null;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + '}';
    }

}
