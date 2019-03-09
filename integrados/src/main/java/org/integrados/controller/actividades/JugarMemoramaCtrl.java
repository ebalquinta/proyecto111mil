/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.actividades;

import java.util.ArrayList;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import java.util.List;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.plantillas.Memorama;
import org.integrados.view.actividades.memorama.JuegoFrm;
import org.integrados.view.actividades.memorama.MemoramaDlg;
import org.integrados.view.actividades.memorama.Tablero;

/**
 *
 * @author Jacco
 */
public class JugarMemoramaCtrl {

    private Memorama plantilla;
    private Actividad actividad;
    private RegistroActividad registro;
    private Tablero tablero;
    private JuegoFrm frame;
    private int intentos;

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
        frame = new JuegoFrm(this.tablero);
        frame.setVisible(true);
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
//                frame.setHecho();
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
//                frame.setIntentos(intentos);
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
        BloqueAnd ba;
        for(Bloque b:lista){
            ba = (BloqueAnd) b;
            if(ba.getBloque1() != null){
                retorno.add((BloqueImagen)ba.getBloque1());
                if(ba.getBloque2() != null){
                    retorno.add((BloqueImagen)ba.getBloque2());
                }
            }
        }
        return retorno;
    }

}
