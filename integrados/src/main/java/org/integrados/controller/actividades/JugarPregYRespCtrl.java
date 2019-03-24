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
import org.integrados.view.actividades.pregyresp.JugarPregYRespDlg;
import java.util.List;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesDlg;

/**
 *
 * @author Jacco
 */
public class JugarPregYRespCtrl {

    private PregYResp plantilla;
    private Actividad actividad;
    private RegistroActividad registro;
    private JugarPregYRespDlg jugarPregYRespDlg;
    private int intentos;
    private DocenteBrowseActividadesDlg docenteBrowseActividadesBrw;

    public JugarPregYRespCtrl(RegistroActividad registro) {
        this.registro = registro;
        this.actividad = this.registro.getActividad();
        this.plantilla = (PregYResp) this.registro.getActividad().getPlantilla();
        this.intentos = this.registro.getActividad().getMaxIntentos();
        //jugar();
    }

    public JugarPregYRespCtrl(Actividad actividad) {
        this.actividad = actividad;
        this.plantilla = (PregYResp) this.actividad.getPlantilla();
        this.intentos = actividad.getMaxIntentos();
        this.docenteBrowseActividadesBrw = null;
        this.registro = null;
    }
    
    public JugarPregYRespCtrl(Actividad actividad, 
        DocenteBrowseActividadesDlg docenteBrowseActividadesBrw) {
        this.actividad = actividad;
        this.plantilla = (PregYResp) this.actividad.getPlantilla();
        this.intentos = actividad.getMaxIntentos();
        this.docenteBrowseActividadesBrw = docenteBrowseActividadesBrw;
        this.registro = null;
    }

    public DocenteBrowseActividadesDlg getDocenteBrowseActividadesBrw() {
        return docenteBrowseActividadesBrw;
    }

    public void jugar() {

        plantilla.setOpciones(plantilla.desordenar());
        jugarPregYRespDlg = new JugarPregYRespDlg(plantilla.getOpciones(), plantilla.getEnunciado(), this);
        jugarPregYRespDlg.setIntentos(intentos);

        jugarPregYRespDlg.setVisible(true);
    }

    public void verificar(List<Bloque> rtaAlumno) throws IntegradosException {
        if (rtaAlumno.isEmpty()) {
            throw new IntegradosException("Seleccione alguna opcion");
        }
        if (intentos > 0) {
            ArrayList<Bloque> respuestas = new ArrayList();
            if (plantilla.verificarResultado(rtaAlumno)) {
                jugarPregYRespDlg.setHecho();
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
                jugarPregYRespDlg.setIntentos(intentos);
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
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.jugarPregYRespDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
