package org.integrados.data.bloques;

import java.util.Objects;

public class Bloque {

    /*
    bloque: 
    sonido = 1
    imagen = 2
    texto = 3
    and = 4
     */
    protected Integer id;
    protected Integer tipoBloque;

    protected Bloque() {
        this.id = null;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoBloque() {
        return tipoBloque;
    }

    public void setTipoBloque(Integer tipoBloque) {
        this.tipoBloque = tipoBloque;
    }

    /**
     * el metodo equals recibiria dos objetos. dentro del metodo solo se compara
     * si son dos bloques iguales, sin depender del tipo de bloque
     *
     * public boolean equals(Bloque solucion, Bloque respuestaAlumno){
     *
     * return (respuestaAlumno.equals(solucion);
     *
     * }
     */
//    @Override
//    public boolean equals(Object obj) {
//        final Bloque other = (Bloque) obj;
//        return Objects.equals(this.id, other.id);
//    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + ", tipoBloque=" + tipoBloque + '}';
    }

}
