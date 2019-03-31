package org.integrados.data.bloques;

public class BloqueAnd extends Bloque {

    private String texto;
    private String imagen;
    private String sonido;
    
    //ver si es necesario inicializar en null
    public BloqueAnd() {
        super();
        super.tipoBloque = 4;
        this.texto= null;
        this.imagen= null;
        this.sonido=null;
    }

    public BloqueAnd(String texto, String imagen, String sonido) {
        this();
        this.texto = texto;
        this.imagen = imagen;
        this.sonido = sonido;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString()+" "+ "BloqueAnd{" + "texto=" + texto + ", imagen=" + imagen + ", sonido=" + sonido + "}";
    }

}
