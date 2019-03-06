/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class AsignarActividadesDlg extends JFrame {
    private JPanel pnlActividades;
    private JCheckBox listaCheck;
    
    public AsignarActividadesDlg() {

    }
    
    private void initComponent (){
        this.setTitle("Asignar Actividades");
        this.pack();
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                  //controlador.cerrarAplicacion();
            }
        });
        
        listaCheck = new JCheckBox();
        //listaCheck.isSelected();    puede devolver si esta seleccionado o no
        
        
        //vivi trabajo tabla con check box en crear preguntas y respuestas.
    
    }

     
       

}
