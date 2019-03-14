package org.integrados.controller.usuarios;

import org.integrados.Aplicacion;
import org.integrados.data.usuarios.Alumno;
import org.integrados.view.AlumnoInicioDlg;
import org.integrados.view.Dialogo;

/**
 *
 * @author Grupo Front
 */
public class AlumnoInicioCtrl {
    
    private Aplicacion app;
    private Alumno alumno;
    private AlumnoInicioDlg alumnoInicioDlg;

    public AlumnoInicioCtrl(Aplicacion app, Alumno alumno) {
        this.app = app;
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    
    
    public void iniciar() {
        this.alumnoInicioDlg = new AlumnoInicioDlg(this);
        this.alumnoInicioDlg.mostrar();
    }

    public void cerrarSesion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea cerrar sesión?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.alumnoInicioDlg.ocultar();
            this.app.setPersonaLogueada(null);
            this.app.ejecutar();
        }
    }
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.alumnoInicioDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

    
    
    
}
