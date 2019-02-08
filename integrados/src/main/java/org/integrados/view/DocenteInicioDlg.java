/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.view.ABM.*;
import org.integrados.data.util.Util;
        
public class DocenteInicioDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnActividades;
    private JButton btnAlumnos;
    private JButton btnVolver;
    
    public DocenteInicioDlg() {
        initComponents();
    }

    void initComponents() {
        
        btnActividades = Util.crearBoton("Actividades", 18);
        btnAlumnos = Util.crearBoton("Alumnos", 18);
        btnVolver = Util.crearBoton("Volver", 14);
        lblFondo = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Propiedades del botón Actividades
        btnActividades.setBounds(295, 320, 170, 60);       
        getContentPane().add(btnActividades);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                // Aquí debemos enlazar con el browser
                    ActividadCtrl ctrl = new ActividadCtrl();
                    ctrl.mostrarBrw(null);
            }
        });
        
        // Propiedades del botón Alumnos
        btnAlumnos.setBounds(400, 120, 170, 60);
        getContentPane().add(btnAlumnos);
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades de botón Volver
        btnVolver.setBounds(295, 510, 170, 30);
        JFrame aux = this;
        getContentPane().add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aux.dispose();        
            }
        });
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/DocenteInicioDlgBkg.jpg","descripción");
        lblFondo.setIcon(icon);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 800, 600);

        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mostrar();
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
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    public void ocultar() {
        this.setVisible(false);
    }   
    
}