/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test;

import java.util.ArrayList;
import org.integrados.view.actividades.PregRespBrowse;

/**
 *
 * @author alumno
 */
public class PregyResptest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> s = new ArrayList();
        s.add("3");
        s.add("5");
        s.add("2");
        s.add("4");
       

        PregRespBrowse frame = new PregRespBrowse(s, "¿Cuantos reinos existen?");
        
        frame.setVisible(true);
    }
}
