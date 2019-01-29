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
public class BloqueAnd extends Bloque {

    private Bloque bloque1;
    private Bloque bloque2;
    
    public BloqueAnd() {
        super();
    }

    public BloqueAnd(Bloque bloque1, Bloque bloque2) {
        super();
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public Bloque getBloque1() {
        return bloque1;
    }

    public void setBloque1(Bloque bloque1) {
        this.bloque1 = bloque1;
    }

    public Bloque getBloque2() {
        return bloque2;
    }

    public void setBloque2(Bloque bloque2) {
        this.bloque2 = bloque2;
    }

    // hay que hacer el metodo
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "BloqueAnd{" + "bloque1=" + bloque1 + ", Bloque2=" + bloque2 + '}';
    }

}
