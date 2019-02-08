package org.integrados.data.util;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 *paqiuete util: con .java con metodos que sean utiles para implemetar en distintas clases. 
los metodos estaticos. la clase NO (publica).
constrructor privado.
clacularPorcentaje y estrellas podrian estar en util.
 */

 public class Util {
    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    
    private Util(){
        
    }
    
    /**
     * El método convierte un Date a String
     * @param fechaNacimiento
     * @return String
     */
    public static String dateToString(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return "";
        }

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat(FORMATO_FECHA);
        return formatoDeFecha.format(fechaNacimiento);
    }
    
    /**
     * Método para crear un botón estándar con los estilos básicos de color verde 
     * y cambio de color de fondo al pasar el mouse.
     * @param texto - El texto a insertar en el botón
     * @param tamañoletra - El tamaño de la letra a aplicar (en pixeles)
     * @return 
     */
    public static JButton crearBoton(String texto, int tamañoletra) {
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setFocusPainted(false);
        boton.setFont(new java.awt.Font("Comic Sans MS", 1, tamañoletra));
        boton.setBorderPainted(true);
        boton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        boton.setForeground(new java.awt.Color(0, 102, 102));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(new java.awt.Color(0, 102, 102));                
                boton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(UIManager.getColor("control"));
                boton.setForeground(new java.awt.Color(0, 102, 102));
            }
        });
        
        return boton;
    }

}
