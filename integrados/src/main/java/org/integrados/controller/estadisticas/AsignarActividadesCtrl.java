/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.estadisticas;

import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author Yani
 */
public class AsignarActividadesCtrl {
    private Alumno alumno;
    private Docente docente;
    private PersonaABM personaABM;

    public void mostrarBrw(){
        
        
    }
    
    
    
    
    private void comparar(Docente docente, Alumno alumno){
        List<Actividad> actividadesDocente = new ArrayList<>();
        List<Actividad> actividadesAlumno;
    
//        for(Actividad actAlumno : actividadesAlumno)
        
        return actividadesAlumno;
    }

    private void comparar(Docente docente, Alumno alumno) {
        List<Actividad> actividadesDocente = docente.getActividades();
        List<Actividad> actividadesAlumno = recuperarActividadesAlumno(alumno);

        for(Actividad actAlumno : actividadesAlumno){
            for (Actividad actDocente : actividadesDocente){
                if (actAlumno.getId().equals(actDocente.getId())){
                    
                }
            }
        }
    }
}
