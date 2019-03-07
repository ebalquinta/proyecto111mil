/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import java.util.List;
import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.AsignarActividadesDlg;

/**
 *
 * @author Yani
 */
public class AsignarActividadesCtrl {
    
    private PersonaABM pers = new PersonaABM();
    private ActividadABM act = new ActividadABM();
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

//    public void guardarAsignaciones(boolean[] asignacion) {
//        System.out.println("entra en controller");
//        Docente docen = docente;
//        Actividad act = actividad;
//        List<Alumno> listaAlumnos = pers.listaAlumnos(docente.getId());
//        
//        for (int i = 0; i < asignacion.length; i++) {
//            
//            if (asignacion[i]) {
//                RegistroActividad nuevoRegistro = new RegistroActividad();
//                nuevoRegistro.setActividad(actividad);
//                nuevoRegistro.setAlumno(listaAlumnos.get(i));
//                nuevoRegistro.setDocente(docente);
//                
//                registroABM.guardar(nuevoRegistro);
//            }
//        }
//    }

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
