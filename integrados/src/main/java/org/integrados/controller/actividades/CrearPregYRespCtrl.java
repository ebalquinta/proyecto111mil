package org.integrados.controller.actividades;

import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.CrearPregYRespDlg;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteInicioDlg;
import org.integrados.view.NuevaActividadInicioDlg;

/**
 *
 * @author Grupo Front
 */
public class CrearPregYRespCtrl {

    public NuevaActividadInicioDlg nuevaActividadInicioDlg;
    public DocenteBrowseActividadesCtrl docenteBrowseActividadesCtrl;
    public DocenteInicioDlg docenteInicioDlg;
    private CrearPregYRespDlg crearPregYRespDlg;
    private Actividad actividad = null;
    //Booleano que indica si se está dando de alta una actividad o es una edición.
    private boolean alta = false;
    private String titulo = null;
    

    public CrearPregYRespCtrl(DocenteBrowseActividadesCtrl docenteBrowseActividadesCtrl) {
        this.docenteBrowseActividadesCtrl = docenteBrowseActividadesCtrl;
        this.nuevaActividadInicioDlg = null;
        this.docenteInicioDlg = docenteBrowseActividadesCtrl.docenteInicioDlg;
    }

    public CrearPregYRespCtrl(NuevaActividadInicioDlg nuevaActividadInicioDlg, DocenteInicioDlg docenteInicioDlg) {
        this.nuevaActividadInicioDlg = nuevaActividadInicioDlg;
        this.docenteBrowseActividadesCtrl = null;
        this.docenteInicioDlg = docenteInicioDlg;
    }

    public CrearPregYRespDlg getCrearPregYRespDlg() {
        return crearPregYRespDlg;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public boolean isAlta() {
        return alta;
    }

   

    public void mostrar() {
        Docente docente = this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        this.alta = true;
        crearPregYRespDlg = new CrearPregYRespDlg(this, docente);
        this.crearPregYRespDlg.mostrar();
    }

    public void editar(Actividad actividad) {
        this.actividad = actividad;
        Docente docente = this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        this.alta = false;
        this.titulo = "Edición de Actividad nro. " + actividad.getId();

        crearPregYRespDlg = new CrearPregYRespDlg(this, docente, titulo);
        this.crearPregYRespDlg.mostrar();
    }

    /**
     * pasaje de string checkbox grado a int para ser guardado en BD
     * @param gradoS
     * @return 
     */
    public int verificarGrado(String gradoS){
        int grado;
        if(gradoS.equals("Primero")){
            grado = 1;
        }else if(gradoS.equals("Segundo")){
            grado = 2;
        } else if (gradoS.equals("Tercero")){
            grado=3;
        }else if (gradoS.equals("Cuarto")){
            grado = 4;
        }else if (gradoS.equals("Quinto")){
            grado =5;
        } else {
            grado = 6;
        }
        return grado;
    }
    
    /**
     * convierte dato string a int
     * @param numString
     * @return 
     */
    public int stringAInt(String numString) {
        return Integer.parseInt(numString);
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.crearPregYRespDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }
}
