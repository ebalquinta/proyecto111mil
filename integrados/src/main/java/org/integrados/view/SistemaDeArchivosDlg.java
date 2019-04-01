
package org.integrados.view;

import java.io.File;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.border.*;
import org.netbeans.lib.awtextra.*;


/**
 * @author Vivi y Mariela
 */
public class SistemaDeArchivosDlg extends JFrame {
    public Object vistaAnterior;     
    public JTextField inputAnterior;
    private JFileChooser selectorDeArchivo;
    File archivoSeleccionado;
    
    /**
     * Creates new form SistemaDeArchivosDlg
     */
    public SistemaDeArchivosDlg() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public SistemaDeArchivosDlg(Object vistaAnterior, JTextField inputAnterior) {
        this();
        this.vistaAnterior = vistaAnterior;
        this.inputAnterior = inputAnterior;
    }
         
    private void initComponents() {
        this.setTitle("Seleccionar Archivo");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            
        // Creando elementos     
        selectorDeArchivo = new JFileChooser();
        selectorDeArchivo.setBackground(new Color(0, 102, 102));
        selectorDeArchivo.setFont(new Font("Comic Sans MS", 0, 14));
        selectorDeArchivo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        selectorDeArchivo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        selectorDeArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selectorDeArchivoActionPerformed(evt);
            }
        });
        
        // Agregando elementos 
        getContentPane().setLayout(new AbsoluteLayout());
        getContentPane().add(selectorDeArchivo, new AbsoluteConstraints(0, 0, 600, 380));
        pack();
    }                    

    private void selectorDeArchivoActionPerformed(ActionEvent evt) {                    
        //usado para agregar un archivo
        String command = evt.getActionCommand();
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
            archivoSeleccionado = selectorDeArchivo.getSelectedFile();
//            JOptionPane.showMessageDialog(this, "Ruta: "
//                    + archivoSeleccionado.getAbsolutePath() + "\nArchivo: " + archivoSeleccionado.getName());
            if (this.vistaAnterior instanceof AgregarBloqueDlg ) {
                AgregarBloqueDlg vista = (AgregarBloqueDlg) vistaAnterior;
                vista.mostrar();   
                inputAnterior.setText(archivoSeleccionado.getAbsolutePath());
                ocultar();
            }
            if (this.vistaAnterior instanceof CrearPregYRespDlg ) {
                CrearPregYRespDlg vista = (CrearPregYRespDlg) vistaAnterior;
                vista.mostrar();   
                inputAnterior.setText(archivoSeleccionado.getAbsolutePath());
                ocultar();
            }
        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
//            JOptionPane.showMessageDialog(this, "Selecciona un Archivo...");
            ocultar();
        }   
    }  

    public void mostrar() {
        this.setVisible(true);
    }
    public void ocultar() {
        this.setVisible(false);
    }
}
