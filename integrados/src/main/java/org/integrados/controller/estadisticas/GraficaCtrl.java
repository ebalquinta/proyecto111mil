/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import org.integrados.view.estadisticas.GraficaBrw;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;

/**
 *
 * @author Yani
 */
public class GraficaCtrl {

    private GraficaBrw graficaBrw;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private List<RegistroActividad> listaActividades;

    public GraficaCtrl(List<RegistroActividad> listaActividades) {
        this.listaActividades = listaActividades;
    }
    
    public void mostrarBrw() {
        graficaBrw = new GraficaBrw(this, listaActividades);
        this.graficaBrw.mostrar();
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.graficaBrw.ocultar();
            //this.app.cerrar();
        }
    }
    
    
public void ventanaAnterior(){
    Alumno alumno = listaActividades.get(0).getAlumno();
        VerActividadesRealizadasCtrl ventanaAnterior = new VerActividadesRealizadasCtrl(alumno);
        ventanaAnterior.mostrarBrw();
        
        graficaBrw.ocultar();
    }
}
