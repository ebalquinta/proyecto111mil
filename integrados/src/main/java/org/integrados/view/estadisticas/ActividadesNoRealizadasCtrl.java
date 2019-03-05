/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;

/**
 *
 * @author Yani
 */
public class ActividadesNoRealizadasCtrl {

    private ActividadesNoRealizadasDlg actividadDlg;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private Alumno alumno;

    public ActividadesNoRealizadasCtrl(Alumno alumno) {
        this.alumno = alumno;
    }

    public void mostrarBrw() {
        List<RegistroActividad> listaActividades = registroABM.listaActividades(alumno.getId());
        List<RegistroActividad> listaActividadesNoRealizadas = actividadesRealizadas(listaActividades);

        actividadDlg = new ActividadesNoRealizadasDlg(this, listaActividadesNoRealizadas);
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
            //this.app.cerrar();
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
