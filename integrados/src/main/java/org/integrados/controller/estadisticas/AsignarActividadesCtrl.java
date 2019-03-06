/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.AsignarActividadesDlg;

/**
 *
 * @author Yani
 */
public class AsignarActividadesCtrl {
    private Alumno alumno;
    private Docente docente;
    private PersonaABM personaABM;
    private AsignarActividadesDlg asignarDlg;
    
    
    public void mostrarBrw(){
       
    }
         public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.asignarDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
//    private void comparar(Docente docente, Alumno alumno){
//        List<Actividad> actividadesDocente = new ArrayList<>();
//        List<Actividad> actividadesAlumno;
//    
////        for(Actividad actAlumno : actividadesAlumno)
//        
//       
//    }

//    private void comparar(Docente docente, Alumno alumno) {
//        List<Actividad> actividadesDocente = docente.getActividades();
//        List<Actividad> actividadesAlumno = recuperarActividadesAlumno(alumno);
//
//        for(Actividad actAlumno : actividadesAlumno){
//            for (Actividad actDocente : actividadesDocente){
//                if (actAlumno.getId().equals(actDocente.getId())){
//                    
//                }
//            }
//        }
//    }
}
