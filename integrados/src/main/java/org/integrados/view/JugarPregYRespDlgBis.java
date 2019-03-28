
package org.integrados.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

 /*
 * @author home
 */
public class JugarPregYRespDlgBis extends javax.swing.JFrame {

    /**
     * Creates new form JugarPregYRespDlgBis
     */
    public JugarPregYRespDlgBis() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        lblPreguntaTexto = new javax.swing.JLabel();
        BtnPreguntaSonido = new javax.swing.JButton();
        lblPreguntaFoto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPreguntaTexto.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblPreguntaTexto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.addTab("Texto", lblPreguntaTexto);

        BtnPreguntaSonido.setText("Hace Click para escuchar");
        jTabbedPane1.addTab("Sonido", BtnPreguntaSonido);

        lblPreguntaFoto.setPreferredSize(new java.awt.Dimension(140, 140));
        jTabbedPane1.addTab("Imagen", lblPreguntaFoto);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 140));

        jButton2.setText("Inserte Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jButton3.setText("Inserte sonido");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 110, -1));

        jButton4.setText("Salir");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 90, -1));

        jButton5.setText("Guardar");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //boton subir foto
              
            //Creamos un objeto de JFilechooser

            JFileChooser dlg = new JFileChooser();
           //Del objeto creado vamos a llamar al metodo setFileFilter

            dlg.setFileFilter(filter);

            //abriremos la ventana de dialogo para escoger la imagen
             int option = dlg.showOpenDialog(this);
             
           //si hacemos click en abrir
            if (option == JFileChooser.APPROVE_OPTION) {

          //Obtener el nombre del archivo
                String fil = dlg.getSelectedFile().getPath();

          //Obtener la direccion de donde se guarda la imagen
            String file = dlg.getSelectedFile().toString();

          //label en donde va la foto
                 lblPreguntaFoto.setIcon(new ImageIcon(fil));
          //modificamos la imagen
            ImageIcon icon = new ImageIcon(fil);
           //Extrae la imagen del icono
            Image img = icon.getImage();
          //Cambiando tamaño de nuestra imagen
            Image newimg=img.getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH);
          //se genera el imageIcon con la nueva imagen
            ImageIcon newIcon=new ImageIcon(newimg);
            lblPreguntaFoto.setIcon(newIcon);
            lblPreguntaFoto.setSize(100, 100);
                     
        }      
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JugarPregYRespDlgBis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JugarPregYRespDlgBis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JugarPregYRespDlgBis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JugarPregYRespDlgBis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JugarPregYRespDlgBis().setVisible(true);
            }
        });
    }
   //variable privada para crear el filtro a imagen o sonido
   private FileNameExtensionFilter filter= new FileNameExtensionFilter("Archivo de Imagen","png","gif","jpg");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPreguntaSonido;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblPreguntaFoto;
    private javax.swing.JLabel lblPreguntaTexto;
    // End of variables declaration//GEN-END:variables
}
