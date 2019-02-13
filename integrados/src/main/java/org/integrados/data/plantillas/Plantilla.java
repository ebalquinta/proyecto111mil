package org.integrados.data.plantillas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.bloques.*;

/**
 *
 * @author BackEnd
 */
public abstract class Plantilla {

    /*
    tipo Plantilla:
    ordenamiento = 1
    unir = 2
    preg y resp = 3
    memorama = 4
     */
    protected Integer id;
    protected String enunciado;
    protected List<Bloque> soluciones;
    protected String imagenEnunciado;
    protected String sonidoEnunciado;
    protected Integer tipoPlantilla;

    public Plantilla() {
        this.sonidoEnunciado = null;
        this.imagenEnunciado = null;
        this.id = null;
        this.soluciones = new ArrayList<>();
    }

    public Plantilla(String enunciado, List<Bloque> soluciones) {
        this();
        this.enunciado = enunciado;
        this.soluciones = soluciones;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public List<Bloque> getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(List<Bloque> soluciones) {
        this.soluciones = soluciones;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getImagen() {
        return imagenEnunciado;
    }

    public void setImagen(String imagen) {
        this.imagenEnunciado = imagen;
    }

    public String getSonido() {
        return sonidoEnunciado;
    }

    public void setSonido(String sonido) {
        this.sonidoEnunciado = sonido;
    }

    public Integer getTipoPlantilla() {
        return tipoPlantilla;
    }

    public void setTipoPlantilla(Integer tipoPlantilla) {
        this.tipoPlantilla = tipoPlantilla;
    }

    /**
     * clona una lista
     */
    public List<Bloque> clonarLista(List<Bloque> listaClonar) {
        List<Bloque> listaClonada = new ArrayList<>();

        for (Bloque b : listaClonar) {
            listaClonada.add(b);
        }
        return listaClonada;
    }

    public abstract List<Bloque> desordenar();

    public abstract Boolean verificarResultado(List<Bloque> respuestaAlumno);

    public abstract Boolean validarPlantilla();

    @Override
    public String toString() {
        return "Plantilla{" + "id=" + id + ", enunciado=" + enunciado + ", solucion=" + soluciones + ", imagenEnunciado=" + imagenEnunciado + ", sonidoEnunciado=" + sonidoEnunciado + ", tipoPlantilla=" + tipoPlantilla + '}';
    }

}
