package org.integrados.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.actividades.JugarPregYRespCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.util.Util;
import org.integrados.exceptions.IntegradosException;
import org.integrados.test.PregyResptest;
import org.integrados.view.Dialogo;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Jacco
 */
public class JugarPregYRespDlg extends javax.swing.JFrame {

    private JLabel lblFondo;
    private JLabel lblPregunta;
    private JLabel lblIntentos;
    private JLabel lblBienHecho;
    private JButton btnSalir;
    private JButton btnEnviar;
    private JugarPregYRespCtrl controller;
    private List<JCheckBox> checks;
    private List<Bloque> respuestas;
    private List<Bloque> opciones;
    private List<Panel> cuadroOpciones;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;

    /**
     * Constructor que llama al initcomponents
     *
     * @param opciones son las opciones que estan guardadas en la plantilla
     * @param pregunta pregunta guardada en plantilla
     * @param controller
     */
    public JugarPregYRespDlg(List<Bloque> opciones, String pregunta, JugarPregYRespCtrl controller) {
        this.opciones = opciones;
        this.initComponents(pregunta);
        this.controller = controller;
        respuestas = new ArrayList();
        
    }

  private void initComponents() {

        lblIntentos = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        lblBienHecho = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 160, 40));

        lblPregunta.setName(""); // NOI18N
        getContentPane().add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 270, 30));
        getContentPane().add(lblBienHecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 110, 60));

        btnSalir.setText("Salir");
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, -1, -1));

        btnEnviar.setText("Enviar");
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));
        getContentPane().add(check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));
        getContentPane().add(check2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));
        getContentPane().add(check3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/integrados/view/images/Fondo2.jpg"))); // NOI18N
        lblFondo.setName(""); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PregyResptest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PregyResptest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PregyResptest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PregyResptest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PregyResptest().setVisible(true);
            }
        });
    }


    public void setIntentos(int i) {
        lblIntentos.setText("Te quedan " + i + " intentos");
    }

    /**
     * Este metodo se encarga de instanciar los paneles y los checks y
     * asignarlos a sus determinadas listas Tambien se encarga de agregar los
     * paneles al frame
     */
  public void initOpciones() {
        //Esta variable representa las coordenadas y para poder alinear correctamente los componentes
        int y = 200;
        //Se recorre la lista de opciones 
        for (Bloque b : opciones) {
            //Se instancia un panel por cada opcion pasandole el bloque y la coordenada "y"
            org.integrados.view.actividades.pregyresp.Panel panelOpcion = new org.integrados.view.actividades.pregyresp.Panel(b, y);

            //Se instancia un checkbox llamado opcion, se setean las coordenadas y se agrega a la lista de checks
            JCheckBox opcion = new JCheckBox();
            opcion.setBounds(70, y, 330, 40);
            opcion.setOpaque(false);
            opcion.setHorizontalTextPosition(JCheckBox.RIGHT);
            checks.add(opcion);

            //Se añade el checkbox instanciado a el panel y se añade el panel a el frame
            panelOpcion.add(opcion);
            panelOpcion.setBounds(70, y, 330, 40);
            panelOpcion.setOpaque(false);
            getContentPane().add(panelOpcion);

            //Se incrementa a la cooredenada 
            y += 50;
        }
    }

    public List<Bloque> getOpciones() {
        return this.opciones;
    }

    public void setOpciones(List<Bloque> opciones) {
        this.opciones = opciones;
    }

    /**
     * Este metodo se encarga de revisar la lista de checks y agregar a la lista
     * rtaAlumno los checksBox seleccionados
     */
    public void opcionesSeleccionadas() {
        for (int i = 0; i < this.checks.size(); i++) {
            if (this.checks.get(i).isSelected()) {
                this.respuestas.add(this.opciones.get(i));
            }
        }
    }

    public void setHecho() {
        lblBienHecho.setVisible(true);
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

    private void initComponents(String pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
