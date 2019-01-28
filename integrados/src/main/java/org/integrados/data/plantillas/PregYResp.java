/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.plantillas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.bloques.*;

/**
 *
 * @author Yani
 */
public class PregYResp extends Plantilla {

    private List<Bloque> opciones;
    
    public PregYResp(){
        
    }

    public PregYResp(List<Bloque> opciones, String enunciado, List<Bloque> solucion) {
        super(enunciado, solucion);
        this.opciones = opciones;
    }
    
    @Override
    public List<Bloque> desordenar(){
        int cambios = 0;
        List<Bloque> listaDesordenada = this.clonarLista(this.opciones);
       
        while (cambios < listaDesordenada.size() ){
            for (int i = 0; i < listaDesordenada.size(); i++) {
                int index = (int) (Math.random() * listaDesordenada.size());
                
                Bloque bloqueActual = listaDesordenada.get(i);
                Bloque auxiliar = listaDesordenada.get(index);

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
     * Primero checkea si la lista de respuestaalumnos es mas grande o mas chica que la de solucion
     * Despues checkea si las respuestas del alumno son iguales a las de la solucion sin importar su orden
     * @param List<Bloque> respuestaAlumno contiene las respuestas del alumno
     * @return boolean 
     */
    @Override
    public boolean verificarResultado(List<Bloque> respuestaAlumno){
        int respuestas = 0;
        if(respuestaAlumno.size() == this.solucion.size()){
            for(Bloque solucion:this.solucion){
                for(Bloque rta:respuestaAlumno){
                    if(solucion.equals(rta)){
                       respuestas++;
                    }
                }
            }
            return (respuestas == this.solucion.size());
        }
        return false;
    }
    
    @Override
    public boolean validarPlantilla(){
        return (this.solucion.size() >= 1);
    }
    
    @Override
    public String toString(){
        return super.toString() + ", opciones = " + this.opciones;
    }

    
    
    
    
}

