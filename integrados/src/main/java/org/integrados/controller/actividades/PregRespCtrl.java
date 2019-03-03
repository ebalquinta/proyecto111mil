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
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Jacco
 */
public class PregRespCtrl {

    private PregYResp plantilla;
    private Actividad actividad;
    private RegistroActividad registro;
    private PregRespBrowse frame;
    private int intentos;

    public PregRespCtrl(RegistroActividad registro) {
        this.registro = registro;
        this.actividad = this.registro.getActividad();
        this.plantilla = (PregYResp) this.registro.getActividad().getPlantilla();
        this.intentos = this.registro.getActividad().getMaxIntentos();
        //jugar();
    }

    public PregRespCtrl(Actividad actividad) {
        this.actividad = actividad;
        this.plantilla = (PregYResp) this.actividad.getPlantilla();
        this.intentos = actividad.getMaxIntentos();
        this.registro = null;
    }

    public void jugar() {

        plantilla.setOpciones(plantilla.desordenar());
        frame = new PregRespBrowse(plantilla.getOpciones(), plantilla.getEnunciado(), this);
        frame.setIntentos(intentos);

        frame.setVisible(true);
    }

    public void verificar(List<Bloque> rtaAlumno) throws IntegradosException {
        if (rtaAlumno.isEmpty()) {
            throw new IntegradosException("Seleccione alguna opcion");
        }
        if (intentos > 0) {
            ArrayList<Bloque> respuestas = new ArrayList();
            if (plantilla.verificarResultado(rtaAlumno)) {
                frame.setHecho();
                if (registro != null) {
                    for (Bloque b : rtaAlumno) {
                        respuestas.add(b);
                    }
                    registro.setIntentos(intentos);
                    registro.setRespuestaAlumno(respuestas);
                    registro.setFinalizoCorrectamente(true);
                    registro.setEstrella(registro.calcularEstrellas());
                }
            } else {
                intentos -= 1;
                frame.setIntentos(intentos);
                //Agrega todos los bloques de la lista a la lista RespuesAlumno que se encuenta en registro
                for (Bloque b : rtaAlumno) {
                    respuestas.add(b);
                }
            }
        } else {
            if (registro != null) {
                registro.setRespuestaAlumno(rtaAlumno);
                registro.setFinalizoCorrectamente(false);
                registro.setIntentos(intentos);

                registro.setEstrella(registro.calcularEstrellas());
            }
            throw new IntegradosException("No te quedan mas intentos");

        }

    }

}
