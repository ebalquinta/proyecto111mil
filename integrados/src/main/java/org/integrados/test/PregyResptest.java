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
        s.add("Aguante el paco");
        s.add("Aguante el paca");
        s.add("Aguante el caca");
        s.add("Aguante el paccaco");
        s.add("Aguante el paco");
        s.add("Aguante el paco");

        PregRespBrowse frame = new PregRespBrowse(s, "Cuantos pacos hay?");
        frame.setVisible(true);
    }
}
