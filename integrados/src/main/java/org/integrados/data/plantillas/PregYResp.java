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

    private List<Bloque> opciones = new ArrayList<>();
    
    public PregYResp(){
        super();
    }

    public PregYResp(String enunciado, List<Bloque> solucion, List<Bloque> opciones) {
        super(enunciado, solucion);
        this.opciones = opciones;
    }

    public List<Bloque> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Bloque> opciones) {
        this.opciones = opciones;
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
        return super.toString() + "PregYResp{" + "opciones=" + opciones + '}';
    }
    
}

