/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;

/**
 *
 * @author Yani
 */
public class ObservarAlumnoDlg extends JFrame {

    private JTextArea areaTexto;
    private JLabel nombreAlumno;
    private JButton btnVolver;
    private JPanel pnlBotonesEdicion = null;
    private Alumno alumno;
    private String observacion;
    private DatosAlumnoDlg ventanaAnterior;

    public ObservarAlumnoDlg(Alumno alumno, DatosAlumnoDlg ventanaAnterior) {
        this.alumno = alumno;
        this.ventanaAnterior = ventanaAnterior;
        initComponent();
    }

    private void initComponent() {
        this.setTitle("Observaciones");
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                //controlador.cerrarAplicacion();
            }
        });
        // titulo observaciones
        this.nombreAlumno = new JLabel();
        this.nombreAlumno.setText("Observaciones");
        this.nombreAlumno.setFont(new Font("Comic Sans MS", 0, 35));
        this.nombreAlumno.setForeground(Color.BLACK);
        this.nombreAlumno.setBounds(250, 30, 500, 75);
        
        // Propiedades del fondo de pantalla
        JLabel lblFondo = new JLabel();
        ImageIcon icon = createImageIcon("images/Fondo.jpg", "Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setLayout(new BorderLayout());

        // Text Area
        areaTexto = new JTextArea(alumno.getObservaciones(),5,2);
        areaTexto.setFont(new Font("Comic Sans MS", 0, 18));
        areaTexto.setBorder(BorderFactory.createLineBorder(Color.orange));
        areaTexto.setOpaque(false);
        areaTexto.setEditable(true);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        
        observacion = areaTexto.getText();

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setOpaque(true);
        scroll.setBounds(115, 120, 550, 350);
        scroll.setViewportView(areaTexto);
        scroll.setBackground(Color.white);
        scroll.getViewport().setOpaque(false);
        
        // Propiedades del botón Volver
        btnVolver = Util.crearBoton("Volver y Guardar", 15);
        btnVolver.setBounds(620, 520, 130, 30);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });
        
        lblFondo.add(scroll);
        getContentPane().add(this.nombreAlumno);
        getContentPane().add(this.btnVolver);
        getContentPane().add(scroll);
        getContentPane().add(lblFondo);
        this.add(lblFondo);
        this.mostrar();

    } ////// FIN ---> INITCOMPONENT ////// 

    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.out.println("Couldn't find file: " + path);
            return null;
        }
    }

    public void volver() {
        guardarCambios();
        this.setVisible(false);
        this.ventanaAnterior.setVisible(true);
        // ------------------------------------> Volveria a la ventana anterior
    }

    public void guardarCambios() {
        int contador = areaTexto.getLineCount(); // puede que devuelva total de caracteres
        contadorCaracteres(contador);
        
        PersonaABM personaABM = new PersonaABM();
        observacion = areaTexto.getText();
        alumno.setObservaciones(observacion);
        personaABM.guardar(alumno);
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }
    
    public boolean contadorCaracteres(int letras){  // --------------------> metodo que comprueba cantidad de caracteres. Falta terminar!!!!
        
        if(letras <= 10){
            return true;
        }
        areaTexto.invalidate();
        return false;
    }

}