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
public class BloqueOrden extends Bloque {

    private int numeroOrden;

    public BloqueOrden(boolean valido, int numeroOrden) {
        super(valido);
        this.numeroOrden = numeroOrden;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    @Override
    public String toString() {
        return "BloqueOrden{" + "numeroOrden=" + numeroOrden + '}';
    }

}
