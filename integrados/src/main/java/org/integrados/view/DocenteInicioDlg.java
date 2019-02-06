/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.view.Dialogo;
import org.integrados.view.pruebaABM.*;
        
public class DocenteInicioDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnActividades;
    private JButton btnAlumnos;
    private JButton btnCerrarSesion;
    
    public DocenteInicioDlg() {
        initComponents();
    }

    void initComponents() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.mostrar();
               
        btnActividades = new JButton();
        btnAlumnos = new JButton();
        btnCerrarSesion = new JButton();
        lblFondo = new JLabel();
                       
        btnActividades.setText("Actividades");
        getContentPane().add(btnActividades);
        btnActividades.setBounds(50, 400, 200, 100);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                // Aquí debemos enlazar con el browser
                    ActividadCtrl ctrl = new ActividadCtrl();
                    ctrl.mostrarBrw(null);
            }
        });
        
        btnAlumnos.setText("Alumnos");
        getContentPane().add(btnAlumnos);
        btnAlumnos.setBounds(300, 400, 200, 100);
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dialogo.Mensaje(" En construcción ", "¡ Estamos trabajando para usted! ");
            }
        });

         btnCerrarSesion.setText("Cerrar Sesión");
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.setBounds(550, 400, 200, 100);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dialogo.Mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");        
            }
        });
    }

    public void mostrar() {
        this.setVisible(true);
    }
    
    public void ocultar() {
        this.setVisible(false);
    }   
    
}