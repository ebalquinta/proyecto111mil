package org.integrados.controller.estadisticas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseAlumnoDlg;
import org.integrados.view.estadisticas.VerActividadesRealizadasDlg;

public class VerActividadesRealizadasCtrl {
    private VerActividadesRealizadasDlg estadisticaBrw;
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private Alumno alumno;
    private DocenteBrowseAlumnoDlg docenteBrowseAlumnoDlg;
    
    public VerActividadesRealizadasCtrl(Alumno alumno, DocenteBrowseAlumnoDlg docenteBrowseAlumnoDlg) {        
        this.alumno = alumno;
        this.docenteBrowseAlumnoDlg = docenteBrowseAlumnoDlg;
    }

    public DocenteBrowseAlumnoDlg getDocenteBrowseAlumnoDlg() {
        return docenteBrowseAlumnoDlg;
    }
    
    public void mostrarBrw() {
        
      //recupera la lista de registros actividades del alumno seleccionado
      List<RegistroActividad> listaActividades = registroABM.listaRegActividadesAlumno(alumno.getId());
      
      List<RegistroActividad> listaActividadesRealizadas = actividadesRealizadas(listaActividades);
      if (listaActividadesRealizadas.size() == 0) {
          Dialogo.mensaje("¡Atencion! ", "El alumno no posee actividades realizadas");
      } else {
          estadisticaBrw = new VerActividadesRealizadasDlg(this, listaActividadesRealizadas);
          this.estadisticaBrw.mostrar();
          this.docenteBrowseAlumnoDlg.ocultar();
      }
       
    }
    
    
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
            LoginCtrl.app.cerrar();
        }
    }
}
