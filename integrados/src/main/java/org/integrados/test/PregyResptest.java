/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.actividades.PregRespCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author alumno
 */
public class PregyResptest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Bloque> opciones = new ArrayList();
        opciones.add(new BloqueTexto("Va a explotar"));
        opciones.add(new BloqueTexto("Va a prenderse"));
        opciones.add(new BloqueTexto("No va a pasar nada"));
        String enunciado = "¿Que pasa si metemos una lampara en un microondas?"; 
        List<Bloque> soluciones = new ArrayList();
        soluciones.add(opciones.get(1));
        PregYResp plantilla = new PregYResp(opciones,enunciado,soluciones);
        Actividad actividad = new Actividad(plantilla, new Docente(), new Materia("Matematica"), enunciado,3, Nivel.INICIAL, Dificultad.ALTO, 3);
        RegistroActividad registro = new RegistroActividad(actividad,new Alumno(),new Docente());
        try{
            PregRespCtrl p = new PregRespCtrl(registro);
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}
