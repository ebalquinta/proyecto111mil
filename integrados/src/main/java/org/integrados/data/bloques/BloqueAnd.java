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
public class BloqueAnd {

    private Integer idBlqueAnd;
    private Bloque bloque1;
    private Bloque Bloque2;

    public BloqueAnd(Bloque bloque1, Bloque Bloque2) {
        this.bloque1 = bloque1;
        this.Bloque2 = Bloque2;
    }

    public Integer getIdBlqueAnd() {
        return idBlqueAnd;
    }

    public void setIdBlqueAnd(Integer idBlqueAnd) {
        this.idBlqueAnd = idBlqueAnd;
    }

    public Bloque getBloque1() {
        return bloque1;
    }

    public void setBloque1(Bloque bloque1) {
        this.bloque1 = bloque1;
    }

    public Bloque getBloque2() {
        return Bloque2;
    }

    public void setBloque2(Bloque Bloque2) {
        this.Bloque2 = Bloque2;
    }

    @Override
    public String toString() {
        return "BloqueAnd{" + "idBlqueAnd=" + idBlqueAnd + ", bloque1=" + bloque1 + ", Bloque2=" + Bloque2 + '}';
    }

}
