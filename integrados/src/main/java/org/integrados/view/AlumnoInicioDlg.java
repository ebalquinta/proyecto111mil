/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.controller.actividades.AlumnoBrowseActividadesCtrl;
import org.integrados.data.util.Util;
import org.integrados.controller.actividades.DocenteBrowseActividadesCtrl;
import org.integrados.controller.usuarios.AlumnoInicioCtrl;
import org.integrados.controller.usuarios.LoginCtrl;
        
public class AlumnoInicioDlg extends JFrame {
    private JLabel lblTitulo;
    private JLabel lblFondo;
    private JToggleButton btnActividades;
    private JToggleButton btnSalir;
    private AlumnoInicioCtrl alumnoInicioCtrl;
    
    public AlumnoInicioDlg(AlumnoInicioCtrl alumnoInicioCtrl) {
        this.alumnoInicioCtrl = alumnoInicioCtrl;
        initComponents();
    }

    void initComponents() {
        this.setTitle("Inicio");
        String titulo =  "Bienvenid@ " + alumnoInicioCtrl.getAlumno().getNombre() + "!";
        lblTitulo = Util.crearTitulo(titulo, 1, 42);        
        btnActividades = new JToggleButton();
        btnSalir = new JToggleButton();
        lblFondo = new JLabel();
        AlumnoInicioDlg aux = this;
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                alumnoInicioCtrl.cerrarAplicacion();
            }
        });
        
        getContentPane().setLayout(null);
        
        // Propiedades de Título
        lblTitulo.setBounds(40, 40, 720, 60);
        getContentPane().add(lblTitulo);

        // Propiedades del botón Actividades
        btnActividades.setBackground(new java.awt.Color(255, 255, 204));
        btnActividades.setIcon(new ImageIcon(getClass().getResource("images/InicioActividadesBtn.png")));
        btnActividades.setBounds(230, 220, 140, 140);
        btnActividades.setToolTipText("Ver tus Actividades Asignadas");
        getContentPane().add(btnActividades);
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {     
                ocultar();
                new AlumnoBrowseActividadesCtrl(aux).mostrar();
            }
        });
        
        // Propiedades del botón Alumnos
        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setIcon(new ImageIcon(getClass().getResource("images/InicioSalirBtn.png")));
        btnSalir.setBounds(440, 220, 140, 140);
        btnSalir.setToolTipText("Cerrar Sesión");
        getContentPane().add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                alumnoInicioCtrl.cerrarSesion();    
            }
        });       
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/FondoConTitulo.jpg","descripción");
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