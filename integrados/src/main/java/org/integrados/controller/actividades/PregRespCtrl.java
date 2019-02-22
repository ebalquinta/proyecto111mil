/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.actividades;

import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.plantillas.PregYResp;

/**
 *
 * @author Jacco
 */
public class PregRespCtrl {
    private PregYResp plantilla;
    private Actividad actividad;
    private RegistroActividad registro;
    
    public PregRespCtrl(RegistroActividad registro, Actividad actividad, PregYResp plantilla){
        this.plantilla = plantilla;
        this.actividad = actividad;
        this.registro = registro;
        
    }
    
}
