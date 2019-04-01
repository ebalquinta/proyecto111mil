package org.integrados.controller.actividades;

import java.util.ArrayList;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import java.util.List;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.plantillas.Memorama;
import org.integrados.view.AlumnoBrowseActividadesDlg;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesDlg;
import org.integrados.view.actividades.memorama.JugarMemoramaDlg;
import org.integrados.view.actividades.memorama.Tablero;

/**
 * @author Jacco, Vivi y Mariela
 */
public class JugarMemoramaCtrl {

    private Memorama plantilla;
    private Actividad actividad;
    private RegistroActividad registro;
    private Tablero tablero;
    private JugarMemoramaDlg jugarMemoramaDlg;
    private int intentos;
    private AlumnoBrowseActividadesDlg alumnoBrowseActividadesDlg;
    private DocenteBrowseActividadesDlg docenteBrowseActividadesDlg;

    public JugarMemoramaCtrl(RegistroActividad registro) {
        this.registro = registro;
        this.actividad = this.registro.getActividad();
        this.plantilla = (Memorama) this.registro.getActividad().getPlantilla();
        this.intentos = this.registro.getActividad().getMaxIntentos();
    }

    public JugarMemoramaCtrl(Actividad actividad) {
        this.actividad = actividad;
        this.plantilla = (Memorama) this.actividad.getPlantilla();
        this.intentos = actividad.getMaxIntentos();
        this.registro = null;
        tablero = new Tablero(crearListaBloqueImagen(plantilla.desordenar()));
        jugarMemoramaDlg = new JugarMemoramaDlg(this.tablero, this);
        jugarMemoramaDlg.setVisible(true);
    }
    
    public JugarMemoramaCtrl(Actividad actividad, AlumnoBrowseActividadesDlg alumnoBrowseActividadesDlg) {
        this(actividad);
        this.alumnoBrowseActividadesDlg = alumnoBrowseActividadesDlg;
        this.docenteBrowseActividadesDlg = null;
    }
    
    public JugarMemoramaCtrl(Actividad actividad, DocenteBrowseActividadesDlg docenteBrowseActividadesDlg) {
        this(actividad);
        this.docenteBrowseActividadesDlg = docenteBrowseActividadesDlg;
        this.alumnoBrowseActividadesDlg = null;
    }

    public AlumnoBrowseActividadesDlg getAlumnoBrowseActividadesDlg() {
        return alumnoBrowseActividadesDlg;
    }

    public DocenteBrowseActividadesDlg getDocenteBrowseActividadesDlg() {
        return docenteBrowseActividadesDlg;
    }
    
    public void jugar() {
        tablero.setImagenes(crearListaBloqueImagen(plantilla.desordenar()));
        tablero.comenzarJuego();       
    }

//    public void verificar(List<Bloque> rtaAlumno) throws IntegradosException {
//        if (rtaAlumno.isEmpty()) {
//            throw new IntegradosException("Seleccione alguna opcion");
//        }
//        if (intentos > 0) {
//            ArrayList<Bloque> respuestas = new ArrayList();
//            if (plantilla.verificarResultado(rtaAlumno)) {
//                jugarMemoramaDlg.setHecho();
//                if (registro != null) {
//                    for (Bloque b : rtaAlumno) {
//                        respuestas.add(b);
//                    }
//                    registro.setIntentos(intentos);
//                    registro.setRespuestaAlumno(respuestas);
//                    registro.setFinalizoCorrectamente(true);
//                    registro.setEstrella(registro.calcularEstrellas());
//                }
//            } else {
//                intentos -= 1;
//                jugarMemoramaDlg.setIntentos(intentos);
//                //Agrega todos los bloques de la lista a la lista RespuesAlumno que se encuenta en registro
//                for (Bloque b : rtaAlumno) {
//                    respuestas.add(b);
//                }
//            }
//        } else {
//            if (registro != null) {
//                registro.setRespuestaAlumno(rtaAlumno);
//                registro.setFinalizoCorrectamente(false);
//                registro.setIntentos(intentos);
//
//                registro.setEstrella(registro.calcularEstrellas());
//            }
//            throw new IntegradosException("No te quedan mas intentos");
//
//        }
//
//    }
    
    private List<BloqueImagen> crearListaBloqueImagen(List<Bloque> lista){
        List<BloqueImagen> retorno = new ArrayList();
        for(Bloque b:lista){
            if (b.getTipoBloque() == 2) {
                retorno.add((BloqueImagen)b);
            }
        }
        return retorno;
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.jugarMemoramaDlg.ocultar();
            LoginCtrl.app.cerrar();
        }
    }
}
