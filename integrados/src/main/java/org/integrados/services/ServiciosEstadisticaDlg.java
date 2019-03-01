/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.services;

import java.awt.BorderLayout;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.integrados.data.actividad.RegistroActividad;

/**
 *
 * @author Yani
 */
public class ServiciosEstadisticaDlg extends JFrame {
    private JLabel lblFondo;

    private ServiciosEstadisticaCtrl controlador = null;
    private RegistroActividad actividad = null;
    private JPanel pnlBotonesEdicion = null;
    public JButton botonGraficar = null;
    public JButton botonVolver = null;
    private JTextField txtNombre;
   

    public ServiciosEstadisticaDlg(ServiciosEstadisticaCtrl controlador) {
        this.controlador = controlador;
        this.initComponents();
    }
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    //Inicializa la interfaz de usuario
    private void initComponents() {
        
        lblFondo = new JLabel();
        ///////////////////////////Botones//////////////////////////
        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        this.add(pnlBotonesEdicion, BorderLayout.SOUTH);

        JPanel pnlCentral = new JPanel();
        this.add(pnlCentral, BorderLayout.CENTER);
        pnlCentral.setLayout(null);

        JLabel lblNombre = new JLabel();
        pnlCentral.add(lblNombre);
        lblNombre.setText("Nombre");  //--------------------------------->  Nombre alumno
        lblNombre.setBounds(16, 14, 74, 16);

        txtNombre = new JTextField();
        pnlCentral.add(txtNombre);
        txtNombre.setBounds(90, 11, 423, 22);
//		txtNombre.setDocument(new FiltroTexto(FiltroTexto.ALL,100));
        
    }
    
    
    public void ocultar(){
        this.setVisible(false);
    }
    
}
