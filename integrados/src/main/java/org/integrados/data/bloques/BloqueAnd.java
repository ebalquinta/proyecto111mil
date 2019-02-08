package org.integrados.data.bloques;

public class BloqueAnd extends Bloque {

    private Bloque bloque1;
    private Bloque bloque2;
    
    //ver si es necesario inicializar en null
    public BloqueAnd() {
        super();
        super.tipoBloque = 4;
        this.bloque1= null;
        this.bloque2= null;
    }

    public BloqueAnd(Bloque bloque1, Bloque bloque2) {
        this();
        this.bloque1=bloque1;
        this.bloque2=bloque2;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() +"\n"+ "BloqueAnd{" + "bloque1=" + bloque1 + ", Bloque2=" + bloque2 + '}';
    }

}
