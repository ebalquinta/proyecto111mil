/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.bloques;

/**
 *
 * @author Jacco
 */
public class FiltroBloque {

    private Integer id;
    private Bloque bloque1;
    private Bloque bloque2;
    private BloqueAnd bloqueAnd1;
    private BloqueAnd bloqueAnd2;

    public FiltroBloque() {
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

    public BloqueAnd getBloqueAnd1() {
        return bloqueAnd1;
    }

    public void setBloqueAnd1(BloqueAnd bloqueAnd1) {
        this.bloqueAnd1 = bloqueAnd1;
    }

    public BloqueAnd getBloqueAnd2() {
        return bloqueAnd2;
    }

    public void setBloqueAnd2(BloqueAnd bloqueAnd2) {
        this.bloqueAnd2 = bloqueAnd2;
    }

    public BloqueAnd filtrar() {
        BloqueAnd a = new BloqueAnd();
        if (this.bloqueAnd1 == null & this.bloqueAnd2 == null) {
            a.setBloque1(this.bloque1);
            a.setBloque2(this.bloque2);
            return a;
        } else {
            if (this.bloque1 == null & this.bloque2 == null) {
                a.setBloque1(this.bloqueAnd1);
                a.setBloque2(this.bloqueAnd2);
                return a;
            } else {
                if (this.bloque2 == null & this.bloqueAnd1 == null) {
                    a.setBloque1(this.bloque1);
                    a.setBloque2(this.bloqueAnd2);
                    return a;
                }else{
                    if (this.bloque1 == null & this.bloqueAnd2 == null) {
                        a.setBloque1(this.bloqueAnd1);
                        a.setBloque2(this.bloque2);
                        return a;
                    }
                }
            }

        }
        return null;
    }
}    
