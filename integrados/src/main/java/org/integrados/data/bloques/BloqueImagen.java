package org.integrados.data.bloques;

public class BloqueImagen extends Bloque {

    private String imagen;
    
    public BloqueImagen(){
        super();
        super.tipoBloque = 2;
    }

    public BloqueImagen(String imagen) {
        this();
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // hay que hacer el metodo
    //yani: dado que hay que comparar bloques, usaria este metodo en el padre. en el caso de and que lo sobreEscriba. anotacion en bloque
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public String toString() {
        return super.toString()+" "+ "BloqueImagen{" + "imagen=" + imagen + "}";
    }

}
