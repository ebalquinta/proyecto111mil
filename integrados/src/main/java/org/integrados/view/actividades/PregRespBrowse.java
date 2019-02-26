/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.integrados.controller.actividades.PregRespCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.util.Util;

/**
 *
 * @author Jacco
 */
public class PregRespBrowse extends javax.swing.JFrame {

    private JLabel pregunta;
    private List<JCheckBox> checks;
    private JButton terminar;
    private JButton verificar;
    private PregRespCtrl controller;
    private List<Bloque> rtaAlumno;
    private List<Bloque> opciones;
    private List<Panel> cuadroOpciones;
//    private JPanel p = new JPanel();
    public PregRespBrowse(List<Bloque> opciones, String pregunta, PregRespCtrl controller) {
        this.opciones=opciones;
        this.initComponents(pregunta);
        this.controller = controller;
        this.rtaAlumno = new ArrayList();
        
    }

    public void initComponents(String pregunta) {
        this.pregunta = new JLabel();
        this.pregunta.setText(pregunta);
        this.pregunta.setBounds(300, 100, pregunta.length() * 10, 20);
        getContentPane().add(this.pregunta);
        
        this.cuadroOpciones = new ArrayList();
        this.checks = new ArrayList();
        this.setOpciones();
        
       
        JButton terminar = Util.crearBoton("terminar", 14);
        JButton verificar = Util.crearBoton("verificar", 14);
        verificar.setBounds(200, 25, 120, 20);
        verificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                opcionesSeleccionadas();
                controller.verificar(rtaAlumno);
            }
        });
        add(terminar);
        add(verificar);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void setOpciones() {

        int y = 200;
        for (Bloque b : this.opciones) {
            Panel panelOpcion = new Panel(b,y);
            JCheckBox opcion = new JCheckBox();
            opcion.setBounds(200, y, 120, 20);
            this.checks.add(opcion);
            panelOpcion.add(opcion);
            add(panelOpcion);
            y += 50;
        }
    }
    public void opcionesSeleccionadas(){
        for (int i = 0; i < checks.size(); i++) {
            if(checks.get(i).isSelected()){
                rtaAlumno.add(opciones.get(i));
            }
           
        }
    }
}
