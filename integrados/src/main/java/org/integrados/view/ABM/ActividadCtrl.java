package org.integrados.view.ABM;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.integrados.view.Dialogo;
import org.integrados.view.NuevaActividadInicioDlg;

/**
 *
 * @author Grupo Front
 */
public class ActividadCtrl {
    
    private ActividadBrw actividadBrw = null;
    
    private ActividadDlg actividadDlg = null;
    
    //private ActividadDlg actividadDlg;
    
    public ActividadCtrl() {        
    }
    
    public void mostrarBrw(JFrame framePadre) {
        
        //Levantar actividades desde la base de datos        
       List<ActividadABMs> listaActividades = new ArrayList<>();
       listaActividades.add(new ActividadABMs(1, "Preguntas", "Cynthia", "Historia", "1era Guerra Mundial"));
       listaActividades.add(new ActividadABMs(2, "Memorama", "Mauricio", "Física", "Caída libre"));
       listaActividades.add(new ActividadABMs(3, "Unir", "Pablo", "Matemática", "Cálculo de Area"));
       listaActividades.add(new ActividadABMs(4, "Unir", "Pablo", "Matemática", "Cálculo de Perímetro"));
       listaActividades.add(new ActividadABMs(5, "Ordenar", "Mauricio", "Física", "Movimiento Rectilineo"));
       listaActividades.add(new ActividadABMs(6, "Memorama", "Malena", "Historia", "2da Guerra Mundial"));
       listaActividades.add(new ActividadABMs(7, "Ordenar", "Cynthia", "Historia", "Independencia Argentina"));
              
        actividadBrw = new ActividadBrw(this, listaActividades);
        this.actividadBrw.mostrar(framePadre);
    }   

    public void agregar() {
        ActividadABMs actividad = new ActividadABMs();
        //acá podría poner valores por defecto.
        
        // actividadDlg = new ActividadDlg(this);
        // actividadDlg.nuevo(actividad);
        //actividadDlg.mostrar(actividadBrw.getFrame());
        
        NuevaActividadInicioDlg nuevaActividadInicioDlg = new NuevaActividadInicioDlg(null);
        nuevaActividadInicioDlg.mostrar();        
    }
    
    public void editar(ActividadABMs actividad) {        
        actividadDlg = new ActividadDlg(this);
        actividadDlg.editar(actividad);
        actividadDlg.mostrar(actividadBrw.getFrame());
    }
    
    
    public void guardar(ActividadABMs actividad, boolean alta) throws Exception {        
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
    
    public void borrar(ActividadABMs actividad)  throws Exception {
        try {
            //Se debe borrar la actividad en la base de datos.
        } catch (Exception e) {
            throw new Exception("Error al borrar", e);
        }
    }
    
    public void volver(){
        actividadBrw.getFrame().dispose();
    }    
}