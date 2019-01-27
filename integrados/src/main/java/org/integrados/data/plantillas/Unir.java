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
public class Unir extends Plantilla {

    private List<Bloque> bloquesDer = new ArrayList<>();
    private List<Bloque> bloquesIzq = new ArrayList<>();
    
    public Unir(){
        super();
    }

    public Unir(String enunciado, List<Bloque> solucion, List<Bloque> bloquesDer, List<Bloque> bloquesIzq) {
        super(enunciado, solucion);
        this.bloquesDer=bloquesDer;
        this.bloquesIzq=bloquesIzq;
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
        return super.toString() + "Unir{" + "bloquesDer=" + bloquesDer + ", bloquesIzq=" + bloquesIzq + '}';
    }
}
