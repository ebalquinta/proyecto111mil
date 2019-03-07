/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseAlumnoDlg;
import org.integrados.view.estadisticas.VerActividadesSinRealizarDlg;

/**
 *
 * @author Yani
 */
public class VerActividadesSinRealizarCtrl {

    private VerActividadesSinRealizarDlg actividadDlg;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private Alumno alumno;
    private DocenteBrowseAlumnoDlg docenteBrowseAlumnoDlg;

    public VerActividadesSinRealizarCtrl(Alumno alumno, DocenteBrowseAlumnoDlg docenteBrowseAlumnoDlg) {
        this.alumno = alumno;
        this.docenteBrowseAlumnoDlg = docenteBrowseAlumnoDlg;
    }

    public DocenteBrowseAlumnoDlg getDocenteBrowseAlumnoDlg() {
        return docenteBrowseAlumnoDlg;
    }

    public void mostrarBrw() {
        List<RegistroActividad> listaActividades = registroABM.listaRegActividadesAlumno(alumno.getId());
        List<RegistroActividad> listaActividadesNoRealizadas = actividadesRealizadas(listaActividades);

        actividadDlg = new VerActividadesSinRealizarDlg(this, listaActividadesNoRealizadas);
        this.actividadDlg.mostrar();
    }

    //Metodo que reune las actividades ya realizadas por el alumno
    public List<RegistroActividad> actividadesRealizadas(List<RegistroActividad> listaActividades) {
        List<RegistroActividad> listaNueva = new ArrayList<>();

        for (RegistroActividad registroActual : listaActividades) {
            if (!registroActual.getFinalizoCorrectamente()) {
                listaNueva.add(registroActual);
            }
        }
        return listaNueva;
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.actividadDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }
    
    public void borrar(RegistroActividad actividad)  throws Exception {
        try {
            this.registroABM.borrar(actividad);
            //Se debe borrar el registro actividad en la base de datos.
        } catch (Exception e) {
            throw new Exception("Error al borrar", e);
        }
    }

}
