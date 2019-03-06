package org.integrados.controller.usuarios;

import org.integrados.Aplicacion;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteInicioDlg;

/**
 *
 * @author Grupo Front
 */
public class DocenteInicioCtrl {
    
    private Aplicacion app;
    private Docente docente;
    private DocenteInicioDlg docenteInicioDlg;

    public DocenteInicioCtrl(Aplicacion app, Docente docente) {
        this.app = app;
        this.docente = docente;
    }    

    public Aplicacion getApp() {
        return app;
    }

    public Docente getDocente() {
        return docente;
    }
    
    public void iniciar() {
        this.docenteInicioDlg = new DocenteInicioDlg(this);
        this.docenteInicioDlg.mostrar();
    }

    public void cerrarSesion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea cerrar sesión?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.docenteInicioDlg.ocultar();
            this.app.setPersonaLogueada(null);
            this.app.ejecutar();
        }
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.docenteInicioDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

    
    
    
}
