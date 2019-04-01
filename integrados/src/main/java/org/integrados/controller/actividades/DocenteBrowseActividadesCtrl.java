package org.integrados.controller.actividades;

import java.util.List;
import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.PlantillaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesDlg;
import org.integrados.view.DocenteInicioDlg;
import org.integrados.view.NuevaActividadInicioDlg;
 
/**
 *
 * @author Grupo Front
 */
public class DocenteBrowseActividadesCtrl {
    
    private DocenteBrowseActividadesDlg actividadBrw = null;    
    public DocenteInicioDlg docenteInicioDlg;
    private ActividadABM actividadABM =new ActividadABM();
    private PlantillaABM plantillaABM = new PlantillaABM();
    
    
    
    public DocenteBrowseActividadesCtrl(DocenteInicioDlg docenteInicioDlg) {        
        this.docenteInicioDlg = docenteInicioDlg;
    }
    
    public void mostrar() {
        
        Docente docente = (Docente) LoginCtrl.app.getPersonaLogueada();
        List<Actividad> listaActividades = actividadABM.listaActividades(docente.getId());
     
       //Levantar actividades de lista estática
//       List<Actividad> listaActividades = new ArrayList<Actividad>();
//       listaActividades.add(new Actividad(new PregYResp("¿Cuál es el símbolo del Magnesio?"), new Docente(28200916, "Marta", "Rodriguez"), new Materia("Química"), "Elementos", 7, Nivel.SECUNDARIO, Dificultad.ALTO, 3));
//       listaActividades.add(new Actividad(new PregYResp("¿Cuál es la raiz cuadrada de 25?"), new Docente(28200912, "Mariela", "Gonzalez"), new Materia("Matematica"), "Logaritmos", 2, Nivel.INICIAL, Dificultad.INTERMEDIO, 3));
//       listaActividades.add(new Actividad(new PregYResp("¿Cuál es el pasado de correr?"), new Docente(28200913, "Pablo", "Martinez"), new Materia("Lengua"), "Verbos", 4, Nivel.PRIMARIO, Dificultad.BAJO, 4));
//       listaActividades.add(new Actividad(new PregYResp("¿Quién ganó?"), new Docente(28200914, "Jose", "Gomez"), new Materia("Historia"), "1ra guerra mundial", 5, Nivel.SECUNDARIO, Dificultad.INTERMEDIO, 3));
//       listaActividades.add(new Actividad(new PregYResp("¿Cuántos genes tiene una molécula de ADN?"), new Docente(28200915, "Pedro", "Sanchez"), new Materia("Biología"), "Genes", 6, Nivel.PRIMARIO, Dificultad.ALTO, 3));
      
       actividadBrw = new DocenteBrowseActividadesDlg(this, listaActividades);
        this.actividadBrw.mostrar();
    }   

    public void agregar() {   
        NuevaActividadInicioDlg nuevaActividadInicioDlg = new NuevaActividadInicioDlg(actividadBrw);
        nuevaActividadInicioDlg.mostrar();        
    }
    
    public void editar(Actividad actividad) {      
        String tipoPlantilla = actividad.getPlantilla().getTipoPlantilla();
        if (tipoPlantilla.equals("Preguntas y Respuestas")) {            
            CrearPregYRespCtrl actividadDlg = new CrearPregYRespCtrl(this);
            actividadDlg.editar(actividad);
            this.actividadBrw.ocultar();
        } else if (tipoPlantilla.equals("Memorama")) {
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
            return;
        } else if (tipoPlantilla.equals("Unir")) {
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
            return;        
        } else if (tipoPlantilla.equals("Ordenamiento")) {
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
            return;
        }        
    }
                
    public void probar(Actividad actividad, DocenteBrowseActividadesDlg docenteBrowseActividadesDlg ) {      
        String tipoPlantilla = actividad.getPlantilla().getTipoPlantilla();
        if (tipoPlantilla.equals("Preguntas y Respuestas")) {       
            JugarPregYRespCtrl pregCtrl = new JugarPregYRespCtrl(actividad, docenteBrowseActividadesDlg);
            pregCtrl.jugar();
            this.actividadBrw.ocultar();
        } else if (tipoPlantilla.equals("Memorama")) {
//            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
               
            JugarMemoramaCtrl memoramaCtrl = new JugarMemoramaCtrl(actividad, docenteBrowseActividadesDlg);
            memoramaCtrl.jugar();
            return;
        } else if (tipoPlantilla.equals("Unir")) {
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
            return;        
        } else if (tipoPlantilla.equals("Ordenamiento")) {
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
            return;
        }        
    }
    
    public void asignarAlumnos(Actividad actividad) {
        new AsignarAlumnosCtrl((Docente)LoginCtrl.app.getPersonaLogueada(), actividad);
    }
    
    public void guardar(Actividad actividad, boolean alta) throws Exception {        
        try {
            this.actividadABM.guardar(actividad);
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
            this.actividadABM.borrar(actividad);
            this.plantillaABM.borrar(actividad.getPlantilla());
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
            LoginCtrl.app.cerrar();
        }
    }
    
}
