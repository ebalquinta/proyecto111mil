package org.integrados.controller.estadisticas;

import java.util.List;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseAlumnoDlg;
import org.integrados.view.DocenteInicioDlg;

public class DocenteBrowseAlumnoCtrl {

    private DocenteBrowseAlumnoDlg alumnoBrw;
    public DocenteInicioDlg docenteInicioDlg;
    private PersonaABM alumnoABM = new PersonaABM(); // se debe usar, ya que al mapear como list el id se guarda con indices 0 y al recuperar busca por id incremental
    private List<Alumno> listaAlumnos;

    public DocenteBrowseAlumnoCtrl() {
    }

    public DocenteBrowseAlumnoCtrl(DocenteInicioDlg docenteInicioDlg) {
        this.docenteInicioDlg = docenteInicioDlg;
    }

    public void mostrarBrw() {
        Docente docente = this.docenteInicioDlg.getDocenteInicioCtrl().getDocente();
        listaAlumnos = alumnoABM.listaAlumnos(docente.getId());

        alumnoBrw = new DocenteBrowseAlumnoDlg(this, listaAlumnos);
        this.alumnoBrw.mostrar();
    }

    /**
     * el metodo cuenta la cantidad de actividades realizadas que posee el alumno
     * segun el atributo finalizoCorrectamente como true. 
     * !!!! Dado que la lista registros de la base de datos trae objetos en null, se debe limpiar hasta
     * solucionar este problema
     *
     * @param alumno
     * @return int cantidad de actividades realizadas por el alumno
     */
    public int cantRealizadas(Alumno alumno) {
        int contadorRealizadas = 0;

        for (RegistroActividad reg : alumno.getRegistroActividades()) {
            try {
                if (reg != null) {
                    if (reg.getFinalizoCorrectamente()) {
                        contadorRealizadas++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error en metodo cantRealizadas");
            }
        }

        return contadorRealizadas;
    }

    /**
     * el metodo cuenta la cantidad de actividades NO realizadas que posee el alumno
     * segun el atributo finalizoCorrectamente como false. 
     * !!!! Dado que la lista registros de la base de datos trae objetos en null, se debe limpiar hasta
     * solucionar este problema
     *
     * @param alumno
     * @return int cantidad de actividades realizadas por el alumno
     */
    public int cantNoRealizadas(Alumno alumno) {
        int contadorNoRealizadas = 0;

        for (RegistroActividad reg : alumno.getRegistroActividades()) {
            try {
                if (reg != null) {
                    if (!reg.getFinalizoCorrectamente()) {
                        contadorNoRealizadas++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error en metodo cantRealizadas");
            }
        }

        return contadorNoRealizadas;
    }

    public void ocultar() {
        alumnoBrw.setVisible(false);
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.alumnoBrw.ocultar();
            LoginCtrl.app.cerrar();
        }
    }

}
