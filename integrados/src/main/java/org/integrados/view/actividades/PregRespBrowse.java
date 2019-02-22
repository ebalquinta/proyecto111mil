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
    private List<JLabel> opciones;
    private List<JCheckBox> checks;
    private JButton terminar;
    private JButton verificar;

    public PregRespBrowse(ArrayList<String> opciones, String pregunta) {
        this.initComponents(opciones, pregunta);
    }

    public void initComponents(ArrayList<String> opciones, String pregunta) {
        this.pregunta = new JLabel();
        this.pregunta.setText(pregunta);
        this.pregunta.setBounds(525, 100, 120, 20);
        getContentPane().add(this.pregunta);

        this.checks = new ArrayList();
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

    public void setOpciones(ArrayList<String> opciones) {

        for (int i = 0; i < opciones.size(); i++) {
            JLabel etiqueta = new JLabel();
            JCheckBox check = new JCheckBox();
            this.opciones.add(etiqueta);
            this.checks.add(check);
        }
        int y = 150;

        for (int i = 0; i < opciones.size(); i++) {

            this.opciones.get(i).setText(opciones.get(i));
            this.opciones.get(i).setBounds(525, y, 120, 20);
            this.checks.get(i).setBounds(400, y, 120, 20);
            add(this.checks.get(i));
            add(this.opciones.get(i));
            y += 50;

        }
    }

}
