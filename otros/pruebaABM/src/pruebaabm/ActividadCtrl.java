/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaabm;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Escaliner SD
 */
public class ActividadCtrl {
    
    private ActividadBrw actividadBrw = null;
    
    private ActividadDlg actividadDlg = null;
    
    //private ActividadDlg actividadDlg;
    
    public ActividadCtrl() {        
    }
    
    public void mostrarBrw(JFrame framePadre) {
        
        //Levantar actividades desde la base de datos        
       List<Actividad> listaActividades = new ArrayList<>();
       listaActividades.add(new Actividad(1, "Algo", "3"));
       listaActividades.add(new Actividad(2, "Otro", "1"));
       listaActividades.add(new Actividad(3, "Gato", "3"));
       listaActividades.add(new Actividad(4, "Macri", "2"));
       listaActividades.add(new Actividad(5, "Arturo", "2"));
       listaActividades.add(new Actividad(6, "Gonzalo", "4"));
       listaActividades.add(new Actividad(7, "Felipe", "5"));
       listaActividades.add(new Actividad(8, "Ernesto", "9"));
       
        actividadBrw = new ActividadBrw(this, listaActividades);
        this.actividadBrw.mostrar(framePadre);
    }   

    public void agregar() {
        Actividad actividad = new Actividad();
        //acá podría poner valores por defecto.
        
        actividadDlg = new ActividadDlg(this);
        actividadDlg.nuevo(actividad);
        actividadDlg.mostrar(actividadBrw.getFrame());
        
    }
    
    public void editar(Actividad actividad) {        
        actividadDlg = new ActividadDlg(this);
        actividadDlg.editar(actividad);
        actividadDlg.mostrar(actividadBrw.getFrame());
    }
    
    
    public void guardar(Actividad actividad, boolean alta) throws Exception {        
        try {
            //Se debe registrar la actividad en la base de datos.
        } catch (Exception e) {
            throw new Exception("Error al guardar", e);
        }        
        if (alta)
            this.actividadBrw.agregarATabla(actividad);
        else
            this.actividadBrw.actualizarATabla(actividad);
    }
    
    public void borrar(Actividad actividad)  throws Exception {
        try {
            //Se debe borrar la actividad en la base de datos.
        } catch (Exception e) {
            throw new Exception("Error al borrar", e);
        }
    }    
}