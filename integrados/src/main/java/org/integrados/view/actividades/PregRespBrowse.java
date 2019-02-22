/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import org.integrados.controller.actividades.PregRespCtrl;
import org.integrados.data.util.Util;

/**
 *
 * @author Jacco
 */
public class PregRespBrowse extends javax.swing.JFrame {

    private JLabel pregunta;
    private List<JCheckBox> opciones;
    private JButton terminar;
    private JButton verificar;

    public PregRespBrowse(List<String> opciones, String pregunta) {
        this.initComponents(opciones, pregunta);
    }

    public void initComponents(List<String> opciones, String pregunta) {
        this.pregunta = new JLabel();
        this.pregunta.setText(pregunta);
        this.pregunta.setBounds(300, 100, pregunta.length()*10, 20);
        getContentPane().add(this.pregunta);
        this.opciones = new ArrayList();
        this.setOpciones(opciones);

        JButton terminar = Util.crearBoton("terminar", 14);
        JButton verificar = Util.crearBoton("verificar", 14);
        add(terminar);
        add(verificar);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void setOpciones(List<String> opciones) {
        int y = 150;
        for (int i = 0; i < opciones.size(); i++) {
            JCheckBox opcion = new JCheckBox(opciones.get(i));
            opcion.setBounds(200, y, 120, 20);
            this.opciones.add(opcion);
            add(this.opciones.get(i));
            y+=50;
        }
    }

}
