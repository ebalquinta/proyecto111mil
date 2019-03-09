/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test; 


import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.actividades.JugarMemoramaCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Memorama;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author alumno
 */
public class MemoramaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Bloque> bloques = new ArrayList();
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/uno.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/dos.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/tres.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cuatro.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cinco.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/seis.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/siete.jpg"));
        bloques.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/ocho.jpg"));

        List<Bloque> bloques2 = new ArrayList();
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/uno.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/dos.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/tres.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cuatro.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cinco.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/seis.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/siete.jpg"));
        bloques2.add(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/ocho.jpg"));


        List<Bloque> solucion = new ArrayList();
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/uno.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/uno.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/dos.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/dos.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/tres.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/tres.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cuatro.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cuatro.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cinco.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/cinco.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/seis.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/seis.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/siete.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/siete.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/ocho.jpg"), new BloqueImagen("F:/usuarios/alumno/Escritorio/xd/proyecto-111mil/integrados/src/main/resources/org/integrados/view/imagesMemorama/imagenes/ocho.jpg")));

        Memorama m = new Memorama("xd",solucion,bloques, bloques2);
        Actividad actividad = new Actividad(m, new Docente(), new Materia("Matematica"), "kslkd", 3, Nivel.INICIAL, Dificultad.ALTO, 3);
        RegistroActividad registro = new RegistroActividad(actividad, new Alumno(), new Docente());
        JugarMemoramaCtrl ctrl = new JugarMemoramaCtrl(actividad);

    }

}
