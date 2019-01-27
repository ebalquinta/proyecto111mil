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
public class Memorama extends Plantilla {

    private List<Bloque> bloques1 = new ArrayList<>();
    private List<Bloque> bloques2 = new ArrayList<>();

    public Memorama(){
        super();
    }
    
    public Memorama (String enunciado, List<Bloque> solucion, List<Bloque> bloques1, List<Bloque> bloques2) {
        super(enunciado, solucion);
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


    @Override
    public List<Bloque> clonarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bloque> desordenar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarResultado(List<Bloque> respuestaAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarPlantilla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "Memorama{" + "bloques1=" + bloques1 + ", bloques2=" + bloques2 + '}';
    }
   

}
