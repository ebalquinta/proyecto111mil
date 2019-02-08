package org.integrados.view;

import javax.swing.JOptionPane;

/**
 * Se usa para mostrar diálogos para comunicar errores y mensajes o introducir
 * texto.
 *
 */
public class Dialogo {

    /**
     * Constructor invisible
     */
    private Dialogo() {
        //se prohíbe el uso del constructor para que no se puedan crear objetos
    }

    /**
     * Muestra un diálogo del tipo "Informativo". Se debe usar cuando se muestra
     * algún suceso en el sistema que no es un error.
     *
     * @param titulo del diálogo
     * @param mensaje información a mostrar.
     */
    public static void mensaje(String titulo, String mensaje) {
        JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un diálogo del tipo "Confirmación". Se debe usar cuando se
     * requiere la decisión del usuario, hay dos alternativas "Sí" o "No".
     *
     * @param titulo del diálogo
     * @param mensaje pregunta que se muestra
     * @return ResultadoDialogo.Yes o ResultadoDialogo.No
     */
    public static ResultadoDialogo confirmacion(String titulo, String mensaje) {
        if (JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return ResultadoDialogo.Yes;
        } else {
            return ResultadoDialogo.No;
        }
    }

    /**
     * Muestra un diálogo del tipo "Confirmación". Se debe usar cuando se
     * requiere la decisión del usuario, hay dos alternativas "Sí" o "No". Tiene
     * como título del diálogo "Confirmación"
     *
     * @param mensaje pregunta que se muestra
     * @return ResultadoDialogo.Yes o ResultadoDialogo.No
     */
    public static ResultadoDialogo confirmacion(String mensaje) {
        return confirmacion("Confirmación", mensaje);
    }

    /**
     * Muestra un diálogo del tipo "Error". Se usa cuando ocurre un error en el
     * sistema y se le notifica al usuario tal ocurrencia.
     *
     * @param titulo del diálogo
     * @param mensaje con la descripción del error
     */
    public static void error(String titulo, String mensaje) {
        JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);        
    }

    /**
     * Muestra un diálogo del tipo "Input". Se debe usar cuando se requiere una
     * entrada de texto por parte del usuario.
     *
     * @param titulo del diálogo
     * @param mensaje que indica que se espera como entrada
     * @return String con el texto ingresado por el usuario
     */
    public static String ingresoTexto(String titulo, String mensaje) {
        return JOptionPane.showInputDialog(null, titulo, "");
    }

    /**
     * Enumerador que identica todos los resultados posibles del diálogo
     * "Confirmation"
     */
    public enum ResultadoDialogo {
        Ok,
        Yes,
        No,
        Cancelar
    }
    
     public interface ListenerCerrarDialogo {
        public void ejecutar();
    }
}

// Esta es la primera versión de la clase Dialogo.
//
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
//import javax.swing.*;
//import static javax.swing.SwingConstants.CENTER;
//
//public class Dialogo extends JDialog {
//    public static JDialog jDialog;
//    private static  ListenerCerrarDialogo listener = null;
//    public Dialogo() {}
//    
//    public static void crearVentana(String msg, ListenerCerrarDialogo listenerClosing) {
//        jDialog = new JDialog();    
//        
//        JLabel label = new JLabel("<html> <div style=\"text-align: center;\">"+ msg +"</div></html>"); 
//        jDialog.add(label); 
//        label.setHorizontalAlignment(CENTER);  
//        
//        jDialog.setSize(200, 200); 
//        jDialog.setLocationRelativeTo(null);   
//        jDialog.setResizable(false);
//        jDialog.setVisible(true); 
//        
//        listener = listenerClosing;
//        
//        jDialog.addWindowListener(new WindowListener() {
//            @Override
//            public void windowOpened(WindowEvent we) {
//                System.out.println("windowOpened");
//            }
//
//            @Override
//            public void windowClosing(WindowEvent we) {
//                System.out.println("windowClosing");
//                if (listener != null)
//                    listener.ejecutar();
//            }
//
//            @Override
//            public void windowClosed(WindowEvent we) {
//                System.out.println("windowClosed");
//                 
//            }
//
//            @Override
//            public void windowIconified(WindowEvent we) {
//                System.out.println("windowIconi");
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent we) {
//                System.out.println("windowDeicoified");                
//            }
//
//            @Override
//            public void windowActivated(WindowEvent we) {                
//            }
//
//            @Override
//            public void windowDeactivated(WindowEvent we) {
//            }
//        });
//    }
//    
//    public static void mostrarError(Exception e, ListenerCerrarDialogo listener) {
//        String msg = e.getMessage();
//        crearVentana(msg, listener);
//    }
//    
//    public static void mostrarError(String msg, ListenerCerrarDialogo listener) {        
//        crearVentana(msg, listener);
//    }
//    
//}