package org.integrados.data.bloques;

import java.util.Objects;

public class Bloque {

    protected Integer id;

    protected Bloque() {
        this.id= null;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bloque{" + "id=" + id + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bloque other = (Bloque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    /**
     * el metodo equals recibiria dos objetos. dentro del metodo solo se compara si son dos bloques iguales, sin depender del tipo de bloque
     
     public boolean equals(Bloque solucion, Bloque respuestaAlumno){
     *  
     * return (respuestaAlumno.equals(solucion);
     *      
     }
     */
    
}
