/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.view.Dialogo;
        
public class DocenteInicioDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnActividades;
    private JButton btnAlumnos;
    private JButton btnCerrarSesion;
    
    public DocenteInicioDlg() {
        initComponents();
    }

    void initComponents() {
        btnActividades = new JButton();
        btnAlumnos = new JButton();
        btnCerrarSesion = new JButton();
        lblFondo = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        btnActividades.setText("Actividades");
        getContentPane().add(btnActividades);
        btnActividades.setBounds(170, 260, 360, 135);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                // Aquí debemos enlazar con el browser
                
            }
        });
        
        btnAlumnos.setText("Alumnos");
        getContentPane().add(btnAlumnos);
        btnAlumnos.setBounds(620, 260, 360, 135);
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dialogo.mostrarError("¡En construcción!", null);
            }
        });

        
        btnCerrarSesion.setText("Cerrar Sesión");
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(170, 260, 360, 135);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
//        ImageIcon icon = createImageIcon("assets/img/LogIn1.1.jpg","a pretty but meaningless splat");
//
//        System.out.println("org.integrados.view.LoginDlg.initComponents()");
//        lblFondo.setIcon(icon);

        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 1200, 600);
        
        this.setBounds(new Rectangle(1200, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mostrar();
    }
    
//    protected ImageIcon createImageIcon(String path,
//                                           String description) {
//    java.net.URL imgURL = getClass().getResource(path);
//    if (imgURL != null) {
//        return new ImageIcon(imgURL, description);
//    } else {
//        System.err.println("Couldn't find file: " + path);
//        return null;
//    }
//}
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    public void ocultar() {
        this.setVisible(false);
    }   
    
}