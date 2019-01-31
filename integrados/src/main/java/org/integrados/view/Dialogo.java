package org.integrados.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

public class Dialogo extends JDialog {
    public static JDialog jDialog;
    private static  ListenerCerrarDialogo listener = null;
    public Dialogo() {}
    
    public static void crearVentana(String msg, ListenerCerrarDialogo listenerClosing) {
        jDialog = new JDialog();    
        
        JLabel label = new JLabel("<html> <div style=\"text-align: center;\">"+ msg +"</div></html>"); 
        jDialog.add(label); 
        label.setHorizontalAlignment(CENTER);  
        
        jDialog.setSize(200, 200); 
        jDialog.setLocationRelativeTo(null);   
        jDialog.setResizable(false);
        jDialog.setVisible(true); 
        
        listener = listenerClosing;
        
        jDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent we) {
                System.out.println("windowClosing");
                if (listener != null)
                    listener.ejecutar();
            }

            @Override
            public void windowClosed(WindowEvent we) {
                System.out.println("windowClosed");
                 
            }

            @Override
            public void windowIconified(WindowEvent we) {
                System.out.println("windowIconi");
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                System.out.println("windowDeicoified");                
            }

            @Override
            public void windowActivated(WindowEvent we) {                
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
    }
    
    public static void mostrarError(Exception e, ListenerCerrarDialogo listener) {
        String msg = e.getMessage();
        crearVentana(msg, listener);
    }
    
    public static void mostrarError(String msg, ListenerCerrarDialogo listener) {        
        crearVentana(msg, listener);
    }
    
    public interface ListenerCerrarDialogo {
        public void ejecutar();
    }
}
