/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades.pregyresp;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.util.Util;

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
        setBounds(200, altura,150,150);
        initComponents(bloque, y);
        altura += 150;
    }
    /**
     * Este metodo se encarga de castear el bloque que recibe por parametro
     * @param bloque Bloque
     * @param y int
     */
    private void initComponents(Bloque bloque, int y) {
        switch (bloque.getTipoBloque()) {
            case 1:
                this.bloqueSonido = (BloqueSonido) bloque;
                //agregar al panel el sonido
                break;
            case 2:
                this.bloqueImagen = (BloqueImagen) bloque;
                //agregar al panel la imagen
                JLabel imagen = new JLabel();
                ImageIcon icon = createImageIcon(this.bloqueImagen.getImagen(),"Fondo");
                if (icon != null) {
                    imagen.setIcon(Util.reziseImageIcon(icon, 60, 40));
                }
                imagen.setBounds(50, y, 60, 40);
                add(imagen);
                break;
            case 3:
                this.bloqueTexto = (BloqueTexto) bloque;
                JLabel texto = new JLabel();
                texto.setText(bloqueTexto.getTexto());
                texto.setBounds(50, y, 60, 40);
                add(texto);
                break;
            case 4:
                this.bloqueAnd= (BloqueAnd) bloque;
//                initComponents(bloqueAnd.getBloque1(), y);
//                initComponents(bloqueAnd.getBloque2(), y + 10);
                break;
        }
    }  
    
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.out.println("Couldn't find file: " + path);
            return null;
        }
    }
    
}
