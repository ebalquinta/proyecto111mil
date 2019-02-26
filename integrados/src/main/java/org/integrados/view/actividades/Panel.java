/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;

/**
 *
 * @author alumno
 */
public class Panel extends JPanel {

    private BloqueSonido bloqueSonido;
    private BloqueTexto bloqueTexto;
    private BloqueImagen bloqueImagen;
    private BloqueAnd bloqueAnd;
    private static int altura = 150;
    private static int x = 150;

    public Panel(Bloque bloque, int y) {
//        setSize(300,300 );
        setBounds(200, altura,150,150);
//        if(y >151){
//            setBackground(Color.blue);
//        }else {
//            setBackground(Color.yellow);
//        }
        initComponents(bloque, y);
        altura += 150;
        x += 50;
    }

    private void initComponents(Bloque bloque, int y) {
        switch (bloque.getTipoBloque()) {
            case 1:
                BloqueSonido bs = (BloqueSonido) bloque;
                //agregar al panel el sonido
                break;
            case 2:
                BloqueImagen bi = (BloqueImagen) bloque;
                //agregar al panel el sonido
                break;
            case 3:
                BloqueTexto bt = (BloqueTexto) bloque;
                JLabel opcion = new JLabel();
                opcion.setText(bt.getTexto());
                opcion.setBounds(500, y, 500, 20);
                add(opcion);
                break;
            case 4:
                BloqueAnd ba = (BloqueAnd) bloque;
                initComponents(ba.getBloque1(), y);
                initComponents(ba.getBloque2(), y + 10);
                break;
        }
    }
}
