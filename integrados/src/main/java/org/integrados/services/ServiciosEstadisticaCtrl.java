package org.integrados.services;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteInicioDlg;

public class ServiciosEstadisticaCtrl {
    private ServiciosEstadisticaBrw estadisticaBrw;
    private RegistroActividadABM registroABM;
    public DocenteInicioDlg docenteInicioDlg;
    private ServiciosEstadisticaDlg estadisticaDlg;
    
    public ServiciosEstadisticaCtrl(DocenteInicioDlg docenteInicioDlg) {        
        this.docenteInicioDlg = docenteInicioDlg;
    }
    
    public void mostrarBrw() {
        
       Docente docente =  this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        
     List<RegistroActividad> listaActividades = registroABM.listaActividades(docente.getId());
        System.out.println("docente**** " + docente.getId());
       //Levantar actividades de lista estática
//       List<RegistroActividad> listaActividades = new ArrayList<Actividad>();
//       listaActividades.add(new Actividad(), new Alumno(), new Docente());
      
       estadisticaBrw = new ServiciosEstadisticaBrw(listaActividades, this);
        this.estadisticaBrw.mostrar();
    }
    
    public void graficar(RegistroActividad actividad) {        
        estadisticaDlg = new ServiciosEstadisticaDlg(this);
       // estadisticaDlg.editar(actividad);
        estadisticaDlg.mostrar();
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.estadisticaBrw.ocultar();
//            this.app.cerrar();
        }
    }

    public void ocultar(){
        estadisticaBrw.setVisible(false);
    }
    
    
}
