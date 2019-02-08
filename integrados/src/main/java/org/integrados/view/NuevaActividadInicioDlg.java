package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author GrupoFront
 */
public class NuevaActividadInicioDlg extends JFrame{

    private JLabel lblFondo;
    private JButton btnVolver;

    
    public NuevaActividadInicioDlg() {
        initComponents();
    }
    
    private void initComponents() {
        
        lblFondo = new JLabel();
        btnVolver = new JButton();
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

          
        // Propiedades de botón Volver
        btnVolver.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        btnVolver.setText("Volver");
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
        ImageIcon icon = createImageIcon("images/NuevaActividadInicioDlgBackground.jpg","descripción");
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
