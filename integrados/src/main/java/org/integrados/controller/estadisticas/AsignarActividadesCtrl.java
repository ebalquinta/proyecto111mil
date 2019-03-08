/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.AsignarActividadesDlg;

/**
 *
 * @author Yani
 */
public class AsignarActividadesCtrl {
    
    private AsignarActividadesDlg asignarDlg;
    private Docente docente;
    private Actividad actividad;

    
    public AsignarActividadesCtrl(Docente docente, Actividad actividad) {
        this.docente = docente;
        this.actividad = actividad;
        mostrarBrw();
    }
    
    public void mostrarBrw() {
        AsignarActividadesDlg asignar = new AsignarActividadesDlg(docente, actividad);
        asignar.mostrar();
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.asignarDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
