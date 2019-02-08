package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.data.util.Util;

/**
 *
 * @author GrupoFront
 */
public class SobreNosotrosDlg extends JFrame {
    
    private JLabel lblFondo;
    private JButton btnVolver;
    private JLabel jLabel2;
    private JLabel jLabel3;   
    private JLabel jLabel4;
    
    public SobreNosotrosDlg() {
        initComponents();
    }
    
    private void initComponents() {
        
        lblFondo = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        btnVolver = Util.crearBoton("Volver", 14);
                
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Propiedades de los textos de pie de foto
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18));
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Alumnos del Plan 111Mil Comisión Sab-005 Año 2018");
        jLabel3.setBounds(190, 370, 450, 50);
        getContentPane().add(jLabel3);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Mariela-Ezequiel-Yanina-Jacco");
        jLabel2.setBounds(220, 430, 420, 60);
        getContentPane().add(jLabel2);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24));
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Viviana-Sebastián-Leandro-Paz-Bruno");
        jLabel4.setBounds(175, 410, 470, 40);
        getContentPane().add(jLabel4);
        
        // Propiedades de botón Volver
        btnVolver.setBounds(295, 510, 170, 30);
        JFrame aux = this;
        getContentPane().add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aux.dispose();
            }
        });

        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/SobreNosotrosDLGBkg.jpg","descripción");
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
