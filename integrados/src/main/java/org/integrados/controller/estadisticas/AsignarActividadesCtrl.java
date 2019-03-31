package org.integrados.controller.estadisticas;

import java.util.List;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.usuarios.DocenteInicioCtrl;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.estadisticas.AsignarActividadesDlg;

public class AsignarActividadesCtrl {
    
    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private AsignarActividadesDlg asignarDlg;
    private DocenteInicioCtrl docenteInicioCtrl;
    private Docente docenteInicio;
    private final Alumno alumno;

    public AsignarActividadesCtrl(Alumno alumno) {
        this.alumno = alumno;
        docenteInicio = docenteInicioCtrl.getDocente();
        mostrarBrw();
    }

    public void mostrarBrw() {
        asignarDlg = new AsignarActividadesDlg(docenteInicio, alumno, this);
        asignarDlg.mostrar();
    }

    /**
     * comprueba si el alumno recibido por parametro ya posee la actividad que
     * desea asignar el docente
     *
     * @param alumno
     * @return boolean
     */
    public boolean comprobarExistentes(Actividad actividad) {
        List<RegistroActividad> reg = registroABM.listaRegActividadesAlumno(this.alumno.getId());
        boolean existe = true;

        for (RegistroActividad registro : reg) {
            if (registro != null) {
                if (actividad.getId().equals(registro.getActividad().getId())) {
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
