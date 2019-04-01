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
public class BloqueTexto extends Bloque {

    private String texto;

    public BloqueTexto(){
        super();
        super.tipoBloque = 3;
    }
    
    public BloqueTexto(String texto) {
        this();
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object obj) {
        BloqueTexto bt = (BloqueTexto) obj;
        return bt.getTexto().equalsIgnoreCase(this.getTexto());
    }
    
    @Override
    public String toString() {
        return super.toString()+" " + "BloqueTexto{" + "texto=" + texto + "}";
    }

}
