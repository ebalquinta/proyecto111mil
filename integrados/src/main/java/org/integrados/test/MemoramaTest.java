/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test; 

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import org.integrados.data.util.Util;

/**
 *
 * @author alumno
 */
public class MemoramaTest {
    List<Bloque> bloques;
    List<Bloque> bloques2;
    List<Bloque> solucion;
    public void principal() {
        
        // Obtengo la ruta relativa de donde estoy parado
        String path = this.getClass().getResource("../").toString();
        // Reescribo esa ruta en formato correcto para que saque espacios y caracteres especiales
        String result = Util.getDecodedUrl(path);
        System.out.println(result);
        
        bloques = new ArrayList();
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/uno.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/dos.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/tres.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/cinco.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/seis.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/siete.jpg"));
        bloques.add(new BloqueImagen(result + "view/imagesMemorama/ocho.jpg"));

        bloques2 = new ArrayList();
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/uno.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/dos.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/tres.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/cinco.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/seis.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/siete.jpg"));
        bloques2.add(new BloqueImagen(result + "view/imagesMemorama/ocho.jpg"));


        solucion = new ArrayList();
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/uno.jpg"), new BloqueImagen(result + "view/imagesMemorama/uno.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/dos.jpg"), new BloqueImagen(result + "view/imagesMemorama/dos.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/tres.jpg"), new BloqueImagen(result + "view/imagesMemorama/tres.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg"), new BloqueImagen(result + "view/imagesMemorama/cuatro.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/cinco.jpg"), new BloqueImagen(result + "view/imagesMemorama/cinco.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/seis.jpg"), new BloqueImagen(result + "view/imagesMemorama/seis.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/siete.jpg"), new BloqueImagen(result + "view/imagesMemorama/siete.jpg")));
        solucion.add(new BloqueAnd(new BloqueImagen(result + "view/imagesMemorama/ocho.jpg"), new BloqueImagen(result + "view/imagesMemorama/ocho.jpg")));
        

        Memorama m = new Memorama("xd",solucion,bloques, bloques2);
        Actividad actividad = new Actividad(m, new Docente(), new Materia("Matematica"), "kslkd", 3, Nivel.INICIAL, Dificultad.ALTO, 3);
        RegistroActividad registro = new RegistroActividad(actividad, new Alumno(), new Docente());
        JugarMemoramaCtrl ctrl = new JugarMemoramaCtrl(actividad);
        
    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemoramaTest test = new MemoramaTest();
        test.principal();
    }

}
