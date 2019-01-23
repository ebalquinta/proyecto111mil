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
public class Estrella extends Recompensa {

    private int cantidad;

    public Estrella(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int getRecompensa() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Estrella{" + "cantidad=" + cantidad + '}';
    }

}
