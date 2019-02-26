/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.actividades;

import java.util.ArrayList;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.view.actividades.PregRespBrowse;
import java.util.List;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueTexto;

/**
 *
 * @author Jacco
 */
public class PregRespCtrl {

    private PregYResp plantilla;
    private Actividad actividad;
    private RegistroActividad registro;

    public PregRespCtrl(RegistroActividad registro, Actividad actividad, PregYResp plantilla) {
        this.plantilla = plantilla;
        this.actividad = actividad;
        this.registro = registro;
        jugar();
    }

    public void jugar() {
        plantilla.desordenar();
        PregRespBrowse frame = new PregRespBrowse(plantilla.getOpciones(), plantilla.getEnunciado(), this);
        frame.setVisible(true);
    }

    public boolean verificar(List<Bloque> rtaAlumno) {
        boolean b = plantilla.verificarResultado(rtaAlumno);
//        System.out.println(rtaAlumno.get(0).getTipoBloque());
        return false;
    }


}

