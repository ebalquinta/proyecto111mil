
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
        super.tipoPlantilla = "Unir";
        this.bloquesDer = new ArrayList<>();
        this.bloquesIzq = new ArrayList<>();
    }

    public Unir(String enunciado, List<Bloque> soluciones, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(enunciado, soluciones);
        super.tipoPlantilla = "Unir";
        this.bloquesDer = bloquesDer;
        this.bloquesIzq = bloquesIzq;
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

    /**
     * Crea una lista desordenada de bloques and y la devuelve
     *
     * @return bloquesAnd
     */
    @Override
    public List<Bloque> desordenar() {

        // Clonacion y creacion de las listas a usar        
        List<Bloque> bloquesDerClonada = this.clonarLista(this.bloquesDer);
        List<Bloque> bloquesIzqClonada = this.clonarLista(this.bloquesIzq);
        List<Integer> indicesUtilizadosMayor = new ArrayList();
        List<Integer> indicesUtilizadosMenor = new ArrayList();
        List<Bloque> bloquesSolucionClonada = new ArrayList<>();

        // Creacion de las variables auxiliares
        int aux;
        int aux2;
        int finalSize;
        List<Bloque> listaMayor; 
        List<Bloque> listaMenor; 
        // Controla que las listas sean distintas para que haya pares
        if (bloquesDerClonada.size() != bloquesIzqClonada.size()) {
            // averigua cual lista es la mayor
            if (bloquesDerClonada.size() > bloquesIzqClonada.size()) {
                finalSize = bloquesDerClonada.size();
                listaMayor = bloquesDerClonada;
                listaMenor = bloquesIzqClonada;
            } else {
                finalSize = bloquesIzqClonada.size();
                listaMayor = bloquesIzqClonada;
                listaMenor = bloquesDerClonada;
            }
            
            for (int i = 0; finalSize > i; i++) {
                // Crea y asigna una lista solucion tomando de un bloque de la lista de mayor cantidad y asignandole null al otro
                
                if (listaMayor.size() > listaMenor.size()) {
                    do {
                        aux = (int) (Math.random() * listaMayor.size());
                    } while (sonUtilizados(aux,indicesUtilizadosMayor));
                    
                    bloquesSolucionClonada.add(listaMayor.get(aux));
                    bloquesSolucionClonada.add(null);         
                    indicesUtilizadosMayor.add(aux);      
                    // Elimina de la lista clonada el bloque para que las listas queden pares
                    listaMayor.remove(aux);
                } else {
                    do {
                        aux = (int) (Math.random() * listaMayor.size());
                    } while (sonUtilizados(aux,indicesUtilizadosMayor));
                    do {
                        aux2 = (int) (Math.random() * listaMenor.size());
                    } while (sonUtilizados(aux2,indicesUtilizadosMenor));
                    
                    bloquesSolucionClonada.add(listaMayor.get(aux));
                    bloquesSolucionClonada.add(listaMenor.get(aux2));                          
                    indicesUtilizadosMayor.add(aux);    
                    indicesUtilizadosMenor.add(aux2);                          
                }                                      
            }            
        } else {
            for (int i = 0; bloquesDerClonada.size() > i; i++) {
                do {
                    aux = (int) (Math.random() * bloquesDerClonada.size());
                } while (sonUtilizados(aux,indicesUtilizadosMayor));
                do {
                    aux2 = (int) (Math.random() * bloquesIzqClonada.size());
                } while (sonUtilizados(aux2,indicesUtilizadosMenor));
                
                bloquesSolucionClonada.add(bloquesDerClonada.get(aux));
                bloquesSolucionClonada.add(bloquesIzqClonada.get(aux2));                        
                indicesUtilizadosMayor.add(aux);    
                indicesUtilizadosMenor.add(aux2);                     
            }
        }    
        return bloquesSolucionClonada;
    }

    private boolean sonUtilizados(int indice, List<Integer> indicesUtilizados) {
        if ( !indicesUtilizados.contains(indice) ) {
            return false;
        }
        return true;
    }

    /**
     * Verifica el resultado teniendo en cuenta la cantidad de pares realizados
     * correctamente
     *
     * @param respuestaAlumno del tipo Bloque que luego es casteada para poder
     * trabajar con los metodos de la clase BloqueAnd
     * @return boolean si la cantidad de pares correctos enviados por el alumno
     * es igual a la cantidad de pares correctos en el sistema
     */
    @Override
    public Boolean verificarResultado(List<Bloque> respuestaAlumno) {
//
//        BloqueAnd rtaAlumno;
//        BloqueAnd solucion;
//        int par = 0;
//        for (Bloque s : this.soluciones) {
//            for (Bloque b : respuestaAlumno) {
//                // comparando dos objetos con == :  se compara a un mismo espacion en memoria(heap). con equals compara sus hashCode.
//                if ((solucion.getBloque1() == rtaAlumno.getBloque1()) && (solucion.getBloque2() == rtaAlumno.getBloque2())) //para comparar objetos usar equals
//                {
//                    par++;
//                }
//            }
//        }
//        return (par == this.soluciones.size());
        return false;
    }

    @Override
    public Boolean validarPlantilla() {
        return this.soluciones.size() > 1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Unir{" + "bloquesDer=" + bloquesDer + ", bloquesIzq=" + bloquesIzq + '}';
    }

}
