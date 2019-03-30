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
public class Memorama extends Plantilla {

    private List<Bloque> bloques1;
    private List<Bloque> bloques2;

    public Memorama() {
        super();
        super.tipoPlantilla = "Memorama";
        this.bloques1 = new ArrayList<>();
        this.bloques1 = new ArrayList<>();
    }

    public Memorama(String enunciado, List<Bloque> soluciones, List<Bloque> bloques1, List<Bloque> bloques2) {
        super(enunciado, soluciones);
        super.tipoPlantilla = "Memorama";
        this.bloques1 = bloques1;
        this.bloques2 = bloques2;
    }

    public List<Bloque> getBloques1() {
        return bloques1;
    }

    public void setBloques1(List<Bloque> bloques1) {
        this.bloques1 = bloques1;
    }

    public List<Bloque> getBloques2() {
        return bloques2;
    }

    public void setBloques2(List<Bloque> bloques2) {
        this.bloques2 = bloques2;
    }

    /**
     * Crea una lista desordenada de bloques del doble de tamaño de cada una de las listas de bloque1 y bloque2 y la devuelve
     *
     * @return bloquesAnd
     */
    @Override
    public List<Bloque> desordenar() {

        // Clonacion y creacion de las listas a usar        
        List<Bloque> bloques1Clonada = this.clonarLista(this.bloques1);
        List<Bloque> bloques2Clonada = this.clonarLista(this.bloques2);
        List<Integer> indicesUtilizados1 = new ArrayList();
        List<Integer> indicesUtilizados2 = new ArrayList();
        List<Bloque> bloquesSolucionClonada = new ArrayList<>();

        // Creacion de las variables auxiliares
        int aux;
        int aux2;
        int finalSize = bloques1Clonada.size();
        for (int i = 0; i < finalSize; i++) {

            // Asignacion de numeros aleatorios a los indices auxiliares teniendo en cuenta el tamaño de la lista y checkeando que no se repitan los indices
            do {
                aux = (int) (Math.random() * bloques1Clonada.size());
            } while (sonUtilizados(aux,indicesUtilizados1));
            do {
                aux2 = (int) (Math.random() * bloques2Clonada.size());
            } while (sonUtilizados(aux2,indicesUtilizados2));

            indicesUtilizados1.add(aux);
            indicesUtilizados2.add(aux2);
            // Creacion y asignacion a lista del bloqueAnd
            bloquesSolucionClonada.add(this.bloques1.get(aux));
            bloquesSolucionClonada.add(this.bloques2.get(aux2));
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
     * Verifica el resultado teniendo en cuenta la cantidad de pares
     * realizados correctamente
     *
     * @param respuestaAlumno del tipo Bloque que luego es casteada para
     * poder trabajar con los metodos de la clase BloqueAnd
     * @return boolean si la cantidad de pares correctos enviados por el
     * alumno es igual a la cantidad de pares correctos en el sistema
     */
    @Override
    public Boolean verificarResultado(List<Bloque> respuestaAlumno) {
//        
//        
//        BloqueAnd rtaAlumno;
//        BloqueAnd solucion;
//        int par = 0;
//        for (Bloque s : this.soluciones) {
//            solucion = (BloqueAnd) s;
//            for (Bloque b : respuestaAlumno) {
//                rtaAlumno = (BloqueAnd) b;
//                // tendriamos que usar un equals para esos objetos??
//                if (rtaAlumno.getBloque1().equals(solucion.getBloque1())) {
//                    if (rtaAlumno.getBloque2().equals(solucion.getBloque2())) {
//                        par++;
//                    }
//                }
//            }
//        }
//        return (par == this.soluciones.size());
        return false;
    }

    @Override
    public Boolean validarPlantilla() {
        return (this.soluciones.size() > 1);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Bloques1 = " + this.bloques1 + ", Bloques2 = " + this.bloques2 + super.toString();
    }

}
