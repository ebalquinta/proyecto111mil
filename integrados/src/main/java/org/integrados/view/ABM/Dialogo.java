package org.integrados.view.ABM;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.integrados.view.pruebaABM;
//
//import javax.swing.JOptionPane;
//
///**
// * Se usa para mostrar diálogos para comunicar errores y mensajes o introducir
// * texto.
// *
// */
//public class Dialogo {
//
//    /**
//     * Constructor invisible
//     */
//    private Dialogo() {
//        //se prohíbe el uso del constructor para que no se puedan crear objetos
//    }
//
//    /**
//     * Muestra un diálogo del tipo "Informativo". Se debe usar cuando se muestra
//     * algún suceso en el sistema que no es un error.
//     *
//     * @param titulo del diálogo
//     * @param mensaje información a mostrar.
//     */
//    public static void Mensaje(String titulo, String mensaje) {
//        JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    /**
//     * Muestra un diálogo del tipo "Confirmación". Se debe usar cuando se
//     * requiere la decisión del usuario, hay dos alternativas "Sí" o "No".
//     *
//     * @param titulo del diálogo
//     * @param mensaje pregunta que se muestra
//     * @return ResultadoDialogo.Yes o ResultadoDialogo.No
//     */
//    public static ResultadoDialogo Confirmacion(String titulo, String mensaje) {
//        if (JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            return ResultadoDialogo.Yes;
//        } else {
//            return ResultadoDialogo.No;
//        }
//    }
//
//    /**
//     * Muestra un diálogo del tipo "Confirmación". Se debe usar cuando se
//     * requiere la decisión del usuario, hay dos alternativas "Sí" o "No". Tiene
//     * como título del diálogo "Confirmación"
//     *
//     * @param mensaje pregunta que se muestra
//     * @return ResultadoDialogo.Yes o ResultadoDialogo.No
//     */
//    public static ResultadoDialogo Confirmacion(String mensaje) {
//        return Confirmacion("Confirmacion", mensaje);
//    }
//
//    /**
//     * Muestra un diálogo del tipo "Error". Se usa cuando ocurre un error en el
//     * sistema y se le notifica al usuario tal ocurrencia.
//     *
//     * @param titulo del diálogo
//     * @param mensaje con la descripción del error
//     */
//    public static void Error(String titulo, String mensaje) {
//        JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
//    }
//
//    /**
//     * Muestra un diálogo del tipo "Input". Se debe usar cuando se requiere una
//     * entrada de texto por parte del usuario.
//     *
//     * @param titulo del diálogo
//     * @param mensaje que indica que se espera como entrada
//     * @return String con el texto ingresado por el usuario
//     */
//    public static String ingresoTexto(String titulo, String mensaje) {
//        return JOptionPane.showInputDialog(null, titulo, "");
//    }
//
//    /**
//     * Enumerador que identica todos los resultados posibles del diálogo
//     * "Confirmation"
//     */
//    public enum ResultadoDialogo {
//        Ok,
//        Yes,
//        No,
//        Cancelar
//    }
//}
