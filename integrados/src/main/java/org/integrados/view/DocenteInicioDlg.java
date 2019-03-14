/*
 * Frame/Ventana principal para Docentes.
 */
package org.integrados.view;

import org.integrados.controller.estadisticas.DocenteBrowseAlumnoCtrl;
import org.integrados.controller.estadisticas.VerActividadesRealizadasCtrl;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.data.util.Util;
import org.integrados.controller.actividades.DocenteBrowseActividadesCtrl;
import org.integrados.controller.usuarios.DocenteInicioCtrl;

public class DocenteInicioDlg extends JFrame {
    private JLabel lblTitulo;
    private JLabel lblFondo;
    private JToggleButton btnActividades;
    private JToggleButton btnAlumnos;
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
        this.setTitle("Inicio");
        String titulo =  "Bienvenid@ " + docenteInicioCtrl.getDocente().getNombre() + "!";
        lblTitulo = Util.crearTitulo(titulo, 1, 42);      

        btnActividades = new JToggleButton();
        btnAlumnos = new JToggleButton();
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
        
        // Propiedades de Título
        lblTitulo.setBounds(40, 40, 720, 60);
        getContentPane().add(lblTitulo);

        // Propiedades del botón Actividades
        btnActividades.setBackground(new java.awt.Color(255, 255, 204));
        btnActividades.setIcon(new ImageIcon(getClass().getResource("images/InicioActividadesBtn.png")));
        btnActividades.setBounds(230, 220, 140, 140);
        btnActividades.setToolTipText("Ver Lista de Actividades");
        getContentPane().add(btnActividades);
        DocenteInicioDlg aux = this;
        btnActividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                DocenteBrowseActividadesCtrl ctrl = new DocenteBrowseActividadesCtrl(aux);
                ctrl.mostrar();
            }
        });

        // Propiedades del botón Alumnos
        btnAlumnos.setBackground(new java.awt.Color(255, 255, 204));
        btnAlumnos.setIcon(new ImageIcon(getClass().getResource("images/InicioAlumnosBtn.png")));
        btnAlumnos.setBounds(440, 220, 140, 140);
        btnAlumnos.setToolTipText("Ver Lista de Alumnos");
        getContentPane().add(btnAlumnos);
        btnAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DocenteBrowseAlumnoCtrl ctrl = new DocenteBrowseAlumnoCtrl(aux);  // cambiar a ventana DocenteAlumnoBrowser
                ctrl.mostrarBrw();
                ocultar();
            }
        });

        // Propiedades de botón Volver
        btnCerrarSesion.setBounds(315, 510, 170, 30);
        getContentPane().add(btnCerrarSesion);
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                docenteInicioCtrl.cerrarSesion();
            }
        });

        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/FondoConTitulo.jpg", "descripción");
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
