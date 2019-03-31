package org.integrados.data.util;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.Normalizer;
import java.text.ParseException;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.integrados.controller.ABM.MateriaABM;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Grado;
import org.integrados.data.enums.Nivel;

/**
 * paqiuete util: con .java con metodos que sean utiles para implemetar en
 * distintas clases. los metodos estaticos. la clase NO (publica). constrructor
 * privado. clacularPorcentaje y estrellas podrian estar en util.
 */
public class Util {

    private static final String FORMATO_FECHA = "dd/MM/yyyy";

    private Util() {

    }

    /**
     * El método convierte un Date a String
     *
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

    //-----
    /**
     * El método convierte de String a Date
     *
     * @param fecha
     * @return String
     * @throws java.text.ParseException
     */
    public static Date stringToDate(String fecha) throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        return date1;
    }

    //---
    /**
     * Método para crear un botón estándar con los estilos básicos de color
     * verde y cambio de color de fondo al pasar el mouse.
     *
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

    /**
     * Método para crear un label estándar con los estilos básicos de tipografía
     *
     * @param texto - El texto a insertar en el label
     * @param negrita - Si es 0, grosor normal, si es 1 negrita
     * @param tamañoletra - El tamaño de la letra a aplicar (en pixeles)
     * @return
     */
    public static JLabel crearLabel(String texto, int negrita, int tamañoletra) {
        JLabel label = new JLabel();
        label.setFont(new Font("Comic Sans MS", negrita, tamañoletra));
        label.setText(texto);
        return label;
    }

    /**
     * Método para crear un label para título con los estilos básicos de
     * tipografía
     *
     * @param texto - El texto a insertar en el label
     * @param negrita - Si es 0, grosor normal, si es 1 negrita
     * @param tamañoletra - El tamaño de la letra a aplicar (en pixeles)
     * @return
     */
    public static JLabel crearTitulo(String texto, int negrita, int tamañoletra) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setFont(new Font("Bradley Hand ITC", negrita, tamañoletra));
//        label.setText(texto);
        return label;
    }
//    Bradley Hand ITC 
//    Footlight MT Light
//    Garamond
//    Goudy Old Style
//    Harrington
//    Lucida Calligraphy
//    Matura MT Script Capitals
//    Monotype Corsiva
//    Papyrus
//    Trebuchet MS

    /**
     * Método para crear un text field estándar con los estilos básicos de
     * tipografía
     *
     * @param tamañoletra - El tamaño de la letra a aplicar (en pixeles)
     * @return
     */
    public static JTextField crearTextField(int tamañoletra) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Comic Sans MS", 0, tamañoletra));
        return textField;
    }

    /**
     * Método para crear un combo box estándar con los estilos básicos
     *
     * @param texto - El arreglo de texto a insertar en las opciones del combo
     * @return
     */
    public static JComboBox crearCombo(String[] texto) {
        JComboBox combo = new JComboBox<>();
        combo.setEditable(false);
//        combo.setForeground(new Color(0, 102, 102));
//        combo.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                combo.setBackground(new java.awt.Color(0, 102, 102));                
//                combo.setForeground(Color.WHITE);
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                combo.setBackground(UIManager.getColor("control"));
//                combo.setForeground(new java.awt.Color(0, 102, 102));
//            }
//        });
        combo.setModel(new DefaultComboBoxModel<>(texto));
        return combo;
    }

    public static JComboBox crearComboNivel() {
        JComboBox combo = new JComboBox<>(Nivel.values());
        combo.setEditable(false);
        return combo;
    }

    public static JComboBox crearComboGrado() {
        JComboBox combo = new JComboBox<>(Grado.values());
        combo.setEditable(false);
        return combo;
    }

    public static JComboBox crearComboDificultad() {
        JComboBox combo = new JComboBox<>(Dificultad.values());
        combo.setEditable(false);
        return combo;
    }

    public static JComboBox crearComboMateria() {
        JComboBox combo = new JComboBox<>();
        combo.setEditable(false);
        String[] materias = MateriaABM.getMaterias();
        combo.setModel(new DefaultComboBoxModel<>(materias));
        return combo;
    }

    /**
     * Redimencionar una imagen
     *
     * @param image el ImageIcon a redimensionar
     * @param width el ancho a redimensionar
     * @param height el alto a redimensionar
     * @return
     */
    public static ImageIcon reziseImageIcon(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

    /**
     * Recibo una URL pasada a string y reescribo esa ruta en formato correcto
     * para que saque espacios y caracteres especiales
     *
     * @param path - URL pasada a string
     * @return - Esa misma ruta en formato correcto
     */
    public static String getDecodedUrl(String path) {
        String result = "";
        try {
            result = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result.substring(6);
    }
    
    public static String normalizer(String s)  {
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String replacer(String param) {
        String t1 = "àâäçéèëêùûüôöïî";
        String t2 = "aaaceeeeuuuooii";
        String s = param;
        for (int i = 0; i < t1.length(); i++) {
            s = "replace(" + s + ",'" + t1.charAt(i) + "','" + t2.charAt(i) + "')";
        }
        return s;
    }
}