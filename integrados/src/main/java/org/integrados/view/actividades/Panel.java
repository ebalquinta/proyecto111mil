/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades;

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

    public Panel(int tipoBloque, Bloque bloque) {
        initCoomponents(tipoBloque,bloque);
    }
    
    private void initCoomponents(int tipoBloque, Bloque bloque){
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
                break;
            case 4:
                BloqueAnd ba = (BloqueAnd) bloque;
                
                break;
        }
    }
}
