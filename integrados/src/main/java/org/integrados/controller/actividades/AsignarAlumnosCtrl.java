package org.integrados.controller.actividades;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.actividades.AsignarAlumnosDlg;

public class AsignarAlumnosCtrl {
    
    private AsignarAlumnosDlg asignarDlg;
    private final Docente docente;
    private final Actividad actividad;

    
    public AsignarAlumnosCtrl(Docente docente, Actividad actividad) {
        this.docente = docente;
        this.actividad = actividad;
        mostrarBrw();
    }
    
    public void mostrarBrw() {
        asignarDlg = new AsignarAlumnosDlg(docente, actividad, this);
        asignarDlg.mostrar();
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.asignarDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
