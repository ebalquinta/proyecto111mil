/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import org.integrados.view.estadisticas.GraficoDlg;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.VerActividadesRealizadasDlg;

/**
 *
 * @author Yani
 */
public class GraficoCtrl {

    private GraficoDlg graficaBrw;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private List<RegistroActividad> listaActividades;
    private VerActividadesRealizadasDlg verActividadesRealizadasDlg;

    public GraficoCtrl(List<RegistroActividad> listaActividades, VerActividadesRealizadasDlg verActividadesRealizadasDlg) {
        this.listaActividades = listaActividades;
        this.verActividadesRealizadasDlg = verActividadesRealizadasDlg;
    }

    public VerActividadesRealizadasDlg getVerActividadesRealizadasDlg() {
        return verActividadesRealizadasDlg;
    }
    
    public void mostrarBrw() {
        graficaBrw = new GraficoDlg(this, listaActividades);
        this.graficaBrw.mostrar();
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.graficaBrw.ocultar();
            LoginCtrl.app.cerrar();
        }
    }    
}
