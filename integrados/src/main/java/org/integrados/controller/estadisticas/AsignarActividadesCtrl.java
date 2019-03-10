package org.integrados.controller.estadisticas;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.AsignarActividadesDlg;

public class AsignarActividadesCtrl {
    
    private AsignarActividadesDlg asignarDlg;
    private final Docente docente;
    private final Actividad actividad;

    
    public AsignarActividadesCtrl(Docente docente, Actividad actividad) {
        this.docente = docente;
        this.actividad = actividad;
        mostrarBrw();
    }
    
    public void mostrarBrw() {
        AsignarActividadesDlg asignar = new AsignarActividadesDlg(docente, actividad);
        asignar.mostrar();
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.asignarDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
