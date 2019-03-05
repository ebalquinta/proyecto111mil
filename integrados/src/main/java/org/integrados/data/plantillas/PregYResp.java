package org.integrados.data.plantillas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.bloques.*;

public class PregYResp extends Plantilla {

    // opciones es una lista: opcion correcta mas las incorrectas
    private List<Bloque> opciones;

    public PregYResp() {
        super();
        super.tipoPlantilla = "Preguntas y Respuestas";
        this.opciones = new ArrayList<>();
    }

    public PregYResp(String enunciado) {
        super(enunciado);
        super.tipoPlantilla = "Preguntas y Respuestas";
        this.opciones = new ArrayList();
    }
    
    public PregYResp(List<Bloque> opciones, String enunciado, List<Bloque> soluciones) {
        super(enunciado, soluciones);
        super.tipoPlantilla = "Preguntas y Respuestas";
        this.opciones = opciones;
    }

    public List<Bloque> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Bloque> opciones) {
        this.opciones = opciones;
    }

    /**
     * Clona la lista opciones, para luego desordenar los objetos contenidos.
     * Mediante un indice aleatorio.
     *
     * @return List<Bloque>
     */
    @Override
    public List<Bloque> desordenar() {
        int cambios = 0;
        List<Bloque> listaDesordenada = this.clonarLista(this.opciones);

        //Cambia los objetos de lugar hasta que cambios se iguale al tamaño de la lista.
        while (cambios < listaDesordenada.size()) {
            for (int i = 0; i < listaDesordenada.size(); i++) {

                //devuelve un valor aleatorio entre 0 y el tamaño de la lista -1.
                int index = (int) (Math.random() * listaDesordenada.size());

                //toma el valor donde se situa el indice en el for(bloqueActual) y el valor en que se encuentra index (auxiliar)
                Bloque bloqueActual = listaDesordenada.get(i);
                Bloque auxiliar = listaDesordenada.get(index);

                //remueve y agrega los bloques en la posicion contraria. 
                listaDesordenada.remove(i);
                listaDesordenada.add(i, auxiliar);

                listaDesordenada.remove(index);
                listaDesordenada.add(index, bloqueActual);

                cambios++;
            }
        }
        return listaDesordenada;
    }

    /**
     * Primero checkea si la lista de respuestaalumnos es mas grande o mas chica
     * que la de solucion Despues checkea si las respuestas del alumno son
     * iguales a las de la solucion sin importar su orden
     *
     * @param List<Bloque> respuestaAlumno contiene las respuestas del alumno
     * @return boolean
     */
    @Override
    public Boolean verificarResultado(List<Bloque> respuestaAlumno) {
        int respuestas = 0;
        if (respuestaAlumno.size() == this.soluciones.size()) {   //para comparar objetos usar equals
            for (Bloque solucion : this.soluciones) {
                for (Bloque rta : respuestaAlumno) {
                    if (rta.equals(solucion)) {     //esta parte se modulariza al metodo equals en Bloque. if(equals){respuesta++}
                        respuestas++;
                    }
                }
            }
            return (respuestas == this.soluciones.size());
        }
        return false;
    }

    @Override
    public Boolean validarPlantilla() {
        return (this.soluciones.size() >= 1);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + ",opciones = " + this.opciones;
    }

}