package org.integrados.view.actividades.memorama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.integrados.controller.actividades.JugarMemoramaCtrl;
import org.integrados.data.util.Util;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * @author Jacco, Vivi y Mariela
 */
public class JugarMemoramaDlg extends JFrame {

    private Tablero tablero;
    private JugarMemoramaCtrl controller;
    
    private JLabel lblFondo;
    private JButton btnSalir;
    private JButton btnJugar;

    /**
     * Creates new form JugarMemoramaDlg
     */
    public JugarMemoramaDlg(Tablero tablero, JugarMemoramaCtrl controller) {
        this.tablero = tablero;
        this.controller = controller;
        initComponents();
    }
    
    private void initComponents() {
        
        //configuracion de la ventana   
        this.setTitle("Realizar Actividad - Memorama");
        this.pack();
        this.setSize(800, 600);
        this.setBackground(new Color(0, 102, 102));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                controller.cerrarAplicacion();
            }
        });                  
        
        lblFondo = new JLabel();   
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("../../images/Fondo2.jpg","Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);
        
        //Creacion de los botones
        btnSalir = Util.crearBoton("Salir", 14);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();                
                if (controller.getAlumnoBrowseActividadesDlg() != null) {
                    controller.getAlumnoBrowseActividadesDlg().mostrar();
                } else if (controller.getAlumnoBrowseActividadesDlg()!= null) {
                    controller.getAlumnoBrowseActividadesDlg().mostrar();
                }                
            }
        });
        btnJugar = Util.crearBoton("Jugar", 14);

        //Agregacion del listener
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                tablero.comenzarJuego();
            }
        });
        
        // Agregando elementos a la ventana
        getContentPane().setLayout(new AbsoluteLayout());
        getContentPane().add(tablero, new AbsoluteConstraints(60, 15, 560, 560)); 
        getContentPane().add(btnJugar, new AbsoluteConstraints(630, 430, 90, 60));
        getContentPane().add(btnSalir, new AbsoluteConstraints(630, 500, 90, 60));  
        
        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 600));

        pack();
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
