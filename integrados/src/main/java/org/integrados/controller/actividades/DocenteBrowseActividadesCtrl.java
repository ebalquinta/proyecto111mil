package org.integrados.controller.actividades;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.integrados.Aplicacion;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesBrw;
import org.integrados.view.DocenteBrowseActividadesDlg;
import org.integrados.view.DocenteInicioDlg;
import org.integrados.view.NuevaActividadInicioDlg;

/**
 *
 * @author Grupo Front
 */
public class DocenteBrowseActividadesCtrl {
    
    private Aplicacion app;    
    private DocenteBrowseActividadesBrw actividadBrw = null;    
    private DocenteBrowseActividadesDlg actividadDlg = null;
    public DocenteInicioDlg docenteInicioDlg;
    
    public DocenteBrowseActividadesCtrl(DocenteInicioDlg docenteInicioDlg) {        
        this.docenteInicioDlg = docenteInicioDlg;
    }
    
    public void mostrarBrw() {
        
        //Levantar actividades desde la base de datos        
       List<Actividad> listaActividades = new ArrayList<>();
       listaActividades.add(new Actividad(new PregYResp("¿Cuál es la raiz cuadrada de 25?"), new Docente(28200912, "Mariela", "Gonzalez"), new Materia("Matematica"), "Logaritmos", 2, Nivel.INICIAL, Dificultad.INTERMEDIO, 3));
       listaActividades.add(new Actividad(new PregYResp("¿Cuál es el pasado de correr?"), new Docente(28200913, "Pablo", "Martinez"), new Materia("Lengua"), "Verbos", 4, Nivel.PRIMARIO, Dificultad.BAJO, 4));
       listaActividades.add(new Actividad(new PregYResp("¿Quién ganó?"), new Docente(28200914, "Jose", "Gomez"), new Materia("Historia"), "1ra guerra mundial", 5, Nivel.SECUNDARIO, Dificultad.INTERMEDIO, 3));
       listaActividades.add(new Actividad(new PregYResp("¿Cuántos genes tiene una molécula de ADN?"), new Docente(28200915, "Pedro", "Sanchez"), new Materia("Biología"), "Genes", 6, Nivel.PRIMARIO, Dificultad.ALTO, 3));
       listaActividades.add(new Actividad(new PregYResp("¿Cuál es el símbolo del Magnesio?"), new Docente(28200916, "Marta", "Rodriguez"), new Materia("Química"), "Elementos", 7, Nivel.SECUNDARIO, Dificultad.ALTO, 3));
              
        actividadBrw = new DocenteBrowseActividadesBrw(this, listaActividades);
        this.actividadBrw.mostrar();
    }   

    public void agregar() {
        Actividad actividad = new Actividad();
        //acá podría poner valores por defecto.
        
        // actividadDlg = new ActividadDlg(this);
        // actividadDlg.nuevo(actividad);
        //actividadDlg.mostrar(actividadBrw.getFrame());
        
        NuevaActividadInicioDlg nuevaActividadInicioDlg = new NuevaActividadInicioDlg(actividadBrw);
        nuevaActividadInicioDlg.mostrar();        
    }
    
    public void editar(Actividad actividad) {        
        actividadDlg = new DocenteBrowseActividadesDlg(this);
        actividadDlg.editar(actividad);
        actividadDlg.mostrar();
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
    
    public void ocultar(){
        actividadBrw.setVisible(false);
    }    
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.actividadBrw.ocultar();
//            this.app.cerrar();
        }
    }
    
}
