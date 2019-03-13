
package org.integrados.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.*;



/**
 *
 * @author home
 */
public class SistemaDeArchivosDlg extends javax.swing.JFrame {

    /**
     * Creates new form VistaSistemaDeArchivos
     */
    public SistemaDeArchivosDlg() {
        initComponents();
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubirArchivo = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubirArchivo.setBackground(new java.awt.Color(0, 102, 102));
        SubirArchivo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        SubirArchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SubirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(SubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 380));
        SubirArchivo.getAccessibleContext().setAccessibleParent(SubirArchivo);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        jButton1.setText("volver");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubirArchivoActionPerformed
      //usado para agregar un archivo
      
      JFileChooser SeleccionarArchivo=(JFileChooser)evt.getSource();
      String command=evt.getActionCommand();
       if (command.equals(JFileChooser.APPROVE_SELECTION)){
        File archivoSeleccionado=SeleccionarArchivo.getSelectedFile();
        JOptionPane.showMessageDialog(this,"Ruta:"
        +archivoSeleccionado.getAbsolutePath()+"/n archivo:"+archivoSeleccionado.getName());
  
       } else if (command.equals(JFileChooser.CANCEL_SELECTION)){
        JOptionPane.showMessageDialog(this,"Selecciona un Archivo...");
        
    }
      
      
    }//GEN-LAST:event_SubirArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(SistemaDeArchivosDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaDeArchivosDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaDeArchivosDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaDeArchivosDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaDeArchivosDlg().setVisible(true);
            }
            
        });
        
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser SubirArchivo;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

public void mostrar() {
        this.setVisible(true);
    }
}