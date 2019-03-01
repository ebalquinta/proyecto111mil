/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.data.util.Util;
import org.integrados.controller.actividades.DocenteBrowseActividadesCtrl;
import org.integrados.controller.usuarios.AlumnoInicioCtrl;
        
public class AlumnoInicioDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnActividades;
    private JButton btnSalir;
    private AlumnoInicioCtrl alumnoInicioCtrl;
    
    public AlumnoInicioDlg(AlumnoInicioCtrl alumnoInicioCtrl) {
        this.alumnoInicioCtrl = alumnoInicioCtrl;
        initComponents();
    }

    void initComponents() {
        
        btnActividades = Util.crearBoton("Jugar", 18);
        btnSalir = Util.crearBoton("Salir", 18);
        lblFondo = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                alumnoInicioCtrl.cerrarAplicacion();
            }
        });
        
        getContentPane().setLayout(null);

        // Propiedades del botón Actividades
        btnActividades.setBounds(400, 120, 170, 60);    
        getContentPane().add(btnActividades);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                // Aquí debemos enlazar con la lista de actividades del alumno                    
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del botón Alumnos
        btnSalir.setBounds(230, 320, 170, 60);
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alumnoInicioCtrl.cerrarSesion();    
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