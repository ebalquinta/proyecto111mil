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
import org.integrados.controller.usuarios.DocenteInicioCtrl;
import org.integrados.services.ServiciosEstadisticaCtrl;
        
public class DocenteInicioDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnActividades;
    private JButton btnAlumnos;
    private JButton btnCerrarSesion;
    private DocenteInicioCtrl docenteInicioCtrl;
    
    public DocenteInicioDlg(DocenteInicioCtrl docenteInicioCtrl) {
        this.docenteInicioCtrl = docenteInicioCtrl;
        initComponents();
    }

    public DocenteInicioCtrl getDocenteInicioCtrl() {
        return docenteInicioCtrl;
    }

    void initComponents() {
        
        btnActividades = Util.crearBoton("Actividades", 18);
        btnAlumnos = Util.crearBoton("Alumnos", 18);
        btnCerrarSesion = Util.crearBoton("Cerrar Sesión", 14);
        lblFondo = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                docenteInicioCtrl.cerrarAplicacion();
            }
        });
        getContentPane().setLayout(null);

        // Propiedades del botón Actividades
        btnActividades.setBounds(230, 320, 170, 60);       
        getContentPane().add(btnActividades);
        DocenteInicioDlg aux = this;
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                // Aquí debemos enlazar con el browser
                DocenteBrowseActividadesCtrl ctrl = new DocenteBrowseActividadesCtrl(aux);
                ctrl.mostrarBrw();
                ocultar();
            }
        });
        
        // Propiedades del botón Alumnos
        btnAlumnos.setBounds(400, 120, 170, 60);
        getContentPane().add(btnAlumnos);
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               ServiciosEstadisticaCtrl ctrl = new ServiciosEstadisticaCtrl(aux);
                ctrl.mostrarBrw();
                ocultar();
            }
        });
        
        // Propiedades de botón Volver
        btnCerrarSesion.setBounds(295, 510, 170, 30);
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                docenteInicioCtrl.cerrarSesion();    
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