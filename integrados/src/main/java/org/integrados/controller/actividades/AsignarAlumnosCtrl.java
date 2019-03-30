package org.integrados.controller.actividades;

import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.actividades.AsignarAlumnosDlg;

public class AsignarAlumnosCtrl {

    private RegistroActividadABM registroABM = new RegistroActividadABM();
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

    /**
     * comprueba si el alumno recibido por parametro ya posee la actividad que
     * desea asignar el docente
     *
     * @param alumno
     * @return boolean
     */
    public boolean comprobarExistentes(Alumno alumno) {
        List<RegistroActividad> reg = registroABM.listaRegActividadesAlumno(alumno.getId());
        boolean existe = true;

        for (RegistroActividad registro : reg) {
            if (registro != null) {
                if (this.actividad.getId().equals(registro.getActividad().getId())) {
                    return false;
                } else {
                    existe = true;
                }
            } else {
                existe = true;
            }
        }
        return existe;
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.asignarDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
