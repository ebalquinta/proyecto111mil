
package org.integrados.data.plantillas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.data.bloques.*;

public class Ordenamiento extends Plantilla {
    
    
    public Ordenamiento(){
        super();
    }

    public Ordenamiento(String enunciado, List<Bloque> solucion) {
        super(enunciado, solucion);
    }
    
    @Override
    public List<Bloque> desordenar() {
       int cambios = 0;
        List<Bloque> listaDesordenada = this.clonarLista(super.solucion);
       
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

    @Override
    public Boolean verificarResultado(List<Bloque> respuestaAlumno) {
       
        for (int i = 0; i < respuestaAlumno.size(); i++){
            //desarrollar metodo equals dentro de cada tipo de bloque para que compare por id
            if(!respuestaAlumno.get(i).equals(super.solucion.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean validarPlantilla() {
       if (super.solucion.size() < 1){
           return false;
       }
        return true;
    }
    
   
    @Override
    public String toString() {
        return super.toString();
    }

    

}
