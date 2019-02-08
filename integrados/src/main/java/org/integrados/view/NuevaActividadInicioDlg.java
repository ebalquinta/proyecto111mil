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
public class NuevaActividadInicioDlg extends JFrame{

    private JLabel lblFondo;
    private JButton btnVolver;
    private JToggleButton jToggleButton1;
    private JToggleButton jToggleButton2;
    private JToggleButton jToggleButton3;
    private JToggleButton jToggleButton4;
    
    public NuevaActividadInicioDlg() {
        initComponents();
    }
    
    private void initComponents() {
        
        lblFondo = new JLabel();
        btnVolver = Util.crearBoton("Volver", 14);
        jToggleButton1 = new JToggleButton();
        jToggleButton2 = new JToggleButton();
        jToggleButton3 = new JToggleButton();
        jToggleButton4 = new JToggleButton();        
       
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

      
        // Propiedades del boton jToggleButton1 (ordenar)
        jToggleButton1.setBackground(new java.awt.Color(255, 255, 204));
        jToggleButton1.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadOrdenarBtn.jpg")));
        jToggleButton1.setBounds(230, 150, 140, 140);
        jToggleButton1.setToolTipText("Crea una nueva actividad de Ordenar");
        getContentPane().add(jToggleButton1);
        jToggleButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });

        // Propiedades del boton jToggleButton2 (Unir)
        jToggleButton2.setBackground(new java.awt.Color(255, 255, 204));
        jToggleButton2.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadUnirBtn.jpg")));
        jToggleButton2.setBounds(400, 150, 140, 140);
        jToggleButton2.setToolTipText("Crea una nueva actividad de Unir");
        getContentPane().add(jToggleButton2);
        jToggleButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del boton jToggleButton3 (Preguntas y respuestas)
        jToggleButton3.setBackground(new java.awt.Color(255, 255, 204));
        jToggleButton3.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadMemoramaBtn.jpg")));
        jToggleButton3.setBounds(230, 320, 140, 140);
        jToggleButton3.setToolTipText("Crea una nueva actividad de Memorama");
        getContentPane().add(jToggleButton3);
        jToggleButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del boton jToggleButton4 (Memorama)
        jToggleButton4.setBackground(new java.awt.Color(255, 255, 204));
        jToggleButton4.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadPregRespBtn.jpg")));
        jToggleButton4.setBounds(400, 320, 140, 140);
        jToggleButton4.setToolTipText("Crea una nueva actividad de Preguntas y Respuestas");
        getContentPane().add(jToggleButton4);
        jToggleButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/NuevaActividadInicioDlgBkg.jpg","descripción");
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