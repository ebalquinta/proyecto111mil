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
 * @author Yani, Jacco
 */
public class Unir extends Plantilla {

    private List<Bloque> bloquesDer;
    private List<Bloque> bloquesIzq;

    public Unir() {
        super();
    }

    public Unir(String enunciado, List<Bloque> solucion, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(enunciado, solucion);
        this.bloquesDer=bloquesDer;
        this.bloquesIzq=bloquesIzq;
    } 
    
    
      /**
     * Crea una lista desordenada de bloques and y la devuelve
     * @return bloquesAnd 
     */
    @Override
    public List<Bloque> desordenar(){
        
        // Clonacion y creacion de las listas a usar        
        List<Bloque> bloquesDerClonada = this.clonarLista();
        List<Bloque> bloquesIzqClonada = this.clonarLista();
        List<Bloque> bloquesAnd = new ArrayList<>();
        
        // Creacion de las variables auxiliares
        BloqueAnd b;
        int aux; 
        int aux2;
        // Controla que las listas sean iguales para que haya pares
        if(this.bloquesDer.size() != this.bloquesIzq.size()){
            
            // Si hay un par averigua cual lista es la impar
            if(this.bloquesDer.size() > this.bloquesIzq.size()){
                
                // Crea y asigna un bloqueAnd tomando de un bloque de la lista de mayor cantidad y asignandole null al otro
                aux = (int) (Math.random()*bloquesDerClonada.size());
                b = new BloqueAnd(bloquesDerClonada.get(aux), null);
                bloquesAnd.add(b);
                
                // Elimina de la lista clonada el bloque para que las listas queden pares
                bloquesDerClonada.remove(aux);
            }else{
                aux = (int) (Math.random()*bloquesIzqClonada.size()) ;
                b = new BloqueAnd(bloquesIzqClonada.get(aux), null);
                bloquesAnd.add(b);
                bloquesIzqClonada.remove(aux);
            }
            
        }
        
        
        for(int i = 0; bloquesDerClonada.size()>i;i++){
            
            // Asignacion de numeros aleatorios a los indices auxiliares teniendo en cuenta el tamao de la lista
            aux = (int) (Math.random() * bloquesDerClonada.size());
            aux2 = (int) (Math.random() * bloquesDerClonada.size());
            
            // Creacion y asignacion a lista de el bloqueAnd
            b = new BloqueAnd(bloquesDerClonada.get(aux), bloquesIzqClonada.get(aux2));
            bloquesAnd.add(b);
            
            // Eliminacion de los bloques ya asignados
            bloquesDerClonada.remove(aux);
            bloquesIzqClonada.remove(aux2);
        }
        
        return bloquesAnd;
    }
    
    /**
     * Verifica el resultado teniendo en cuenta la cantidad de pares realizados correctamente
     * @param respuestaAlumno del tipo Bloque que luego es casteada para poder trabajar con los metodos de la clase BloqueAnd
     * @return boolean si la cantidad de pares correctos enviados por el alumno es igual a la cantidad de pares correctos en el sistema
     */
    @Override
    public boolean verificarResultado(List<Bloque> respuestaAlumno){
        
        BloqueAnd rtaAlumno;
        BloqueAnd solucion;
        int par = 0;
        for(Bloque s:this.solucion){
            solucion = (BloqueAnd) s;
            for(Bloque b: respuestaAlumno){
                rtaAlumno = (BloqueAnd) b;
                if((solucion.getBloque1() == rtaAlumno.getBloque1()) && (solucion.getBloque2() == rtaAlumno.getBloque2()))
                    par++;
                }
            }
        }
        return (par==this.solucion.size());
    }
    
    
    @Override
    public boolean validarPlantilla(){
        return this.solucion.size() > 1;
    }
    

    public List<Bloque> getBloquesDer() {
        return bloquesDer;
    }

    public void setBloquesDer(List<Bloque> bloquesDer) {
        this.bloquesDer = bloquesDer;
    }

    public List<Bloque> getBloquesIzq() {
        return bloquesIzq;
    }

    public void setBloquesIzq(List<Bloque> bloquesIzq) {
        this.bloquesIzq = bloquesIzq;
    }
    
    @Override
    public String toString() {
        return "Unir{" + "bloquesDer=" + bloquesDer + ", bloquesIzq=" + bloquesIzq + '}';
    }

}
