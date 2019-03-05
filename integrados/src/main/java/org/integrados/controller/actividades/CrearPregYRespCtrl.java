package org.integrados.controller.actividades;

import org.integrados.data.usuarios.Docente;
import org.integrados.view.CrearPregYRespDlg;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteInicioDlg;
import org.integrados.view.NuevaActividadInicioDlg;
 
/**
 *
 * @author Grupo Front
 */
public class CrearPregYRespCtrl {
    
    public NuevaActividadInicioDlg nuevaActividadInicioDlg;
    public DocenteInicioDlg docenteInicioDlg;
    private CrearPregYRespDlg crearPregYRespDlg;
    
    public CrearPregYRespCtrl(NuevaActividadInicioDlg nuevaActividadInicioDlg, DocenteInicioDlg docenteInicioDlg) {
        this.nuevaActividadInicioDlg = nuevaActividadInicioDlg;
        this.docenteInicioDlg = docenteInicioDlg;
    }
    
    public void mostrarDlg() {
        Docente docente =  this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        crearPregYRespDlg = new CrearPregYRespDlg(this, docente);
        this.crearPregYRespDlg.mostrar();
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.crearPregYRespDlg.ocultar();
            this.docenteInicioDlg.getDocenteInicioCtrl().getApp().cerrar();
        }
    }
}
