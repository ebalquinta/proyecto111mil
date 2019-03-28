package org.integrados.controller.actividades;

import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.view.AgregarBloqueDlg; 
import org.integrados.view.Dialogo;

/**
 *
 * @author Mariela
 */
public class AgregarBloqueCtrl {    
    private CrearPregYRespCtrl crearPregYRespCtrl;
    public AgregarBloqueDlg agregarBloqueDlg;
    private Bloque bloque = null;
    //Booleano que indica si se está dando de alta una actividad o es una edición.
    private boolean alta = false;
    private String titulo = null;

    public AgregarBloqueCtrl() {
    }
    
    public AgregarBloqueCtrl(CrearPregYRespCtrl crearPregYRespCtrl) {
        this.crearPregYRespCtrl = crearPregYRespCtrl;
    }    

    public CrearPregYRespCtrl getCrearPregYRespCtrl() {
        return crearPregYRespCtrl;
    }
    
    public boolean isAlta() {
        return alta;
    }
    public void mostrar() {
        this.alta = true;    
        agregarBloqueDlg = new AgregarBloqueDlg(this, crearPregYRespCtrl);
        this.agregarBloqueDlg.mostrar();
    }
    
    public void editar(Bloque bloque) {
        this.bloque = bloque;
        this.alta = false;        
        this.titulo = "Edición de Bloque nro. " + bloque.getId();
        
        agregarBloqueDlg = new AgregarBloqueDlg(this, crearPregYRespCtrl, titulo);
        this.agregarBloqueDlg.mostrar();
    }
    
    
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.agregarBloqueDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }
    
}
