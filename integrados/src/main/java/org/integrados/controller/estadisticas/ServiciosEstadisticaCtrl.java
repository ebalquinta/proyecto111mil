package org.integrados.controller.estadisticas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseAlumnoCtrl;
import org.integrados.view.estadisticas.ServiciosEstadisticaBrw;

public class ServiciosEstadisticaCtrl {
    private ServiciosEstadisticaBrw estadisticaBrw;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private Alumno alumno;
    
    
    public ServiciosEstadisticaCtrl(Alumno alumno) {        
        this.alumno = alumno;
    }
    
    public void mostrarBrw() {
        
      //recupera la lista de registros actividades del alumno seleccionado
      List<RegistroActividad> listaActividades = registroABM.listaActividades(alumno.getId());
      
      List<RegistroActividad> listaActividadesRealizadas = actividadesRealizadas(listaActividades);
      
       estadisticaBrw = new ServiciosEstadisticaBrw(this, listaActividadesRealizadas);
        this.estadisticaBrw.mostrar();
    }
    
//    public void graficar(RegistroActividad actividad) {        
//        estadisticaDlg = new ServiciosEstadisticaBrw(this);
//       // estadisticaDlg.editar(actividad);
//        estadisticaDlg.mostrar();
//    }
    
    
    //Metodo que reune las actividades ya realizadas por el alumno
    public List<RegistroActividad> actividadesRealizadas(List<RegistroActividad> listaActividades){
        List<RegistroActividad> listaNueva = new ArrayList<>();
        
        for( RegistroActividad registroActual: listaActividades){
            if (registroActual.getFinalizoCorrectamente()){
                listaNueva.add(registroActual);
            }
        }
        return listaNueva;
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.estadisticaBrw.ocultar();
            //this.app.cerrar();
        }
    }
    
    
    public void ventanaAnterior(){
        DocenteBrowseAlumnoCtrl ventanaAnterior = new DocenteBrowseAlumnoCtrl();
        ventanaAnterior.mostrarBrw();
    }
}
