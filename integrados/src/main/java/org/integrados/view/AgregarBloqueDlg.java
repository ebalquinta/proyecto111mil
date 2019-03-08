
package org.integrados.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.integrados.data.util.Util;

/**
 *
 * @author home
 */
public class AgregarBloqueDlg extends javax.swing.JFrame {

    /**
     * Creates new form AgregarBloque
     */
     /**
     * Metodo para inicializar los componentes de la vista
     */ 
    public AgregarBloqueDlg() {
        initComponents();
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblIngreseImagen = new javax.swing.JLabel();
        lblIngreseSonido = new javax.swing.JLabel();
        lblIngreseTexto = new javax.swing.JLabel();
        lblAgregarOpcion = new javax.swing.JLabel();
        txtIngreseTexto = new javax.swing.JTextField();
        txtIngreseImagen = new javax.swing.JTextField();
        txtIngreseSonido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnArchivoImagen = new javax.swing.JButton();
        btnArchivoSonido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 320));
        setPreferredSize(new java.awt.Dimension(420, 320));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngreseImagen = Util.crearLabel("Ingrese imagen", 0, 14);
        getContentPane().add(lblIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 20));

        lblIngreseSonido = Util.crearLabel("Ingrese sonido", 0, 14);
        getContentPane().add(lblIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 20));

        lblIngreseTexto = Util.crearLabel("Ingrese texto", 0, 14);
        
        getContentPane().add(lblIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 20));

       lblAgregarOpcion = Util.crearLabel("Agregar opcion(Complete al menos un campo)", 0, 14);
        getContentPane().add(lblAgregarOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 300, -1));
        getContentPane().add(txtIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, -1));
        txtIngreseTexto = Util.crearTextField(14);
        txtIngreseTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtIngreseTextoActionPerformed(evt);
            }

            private void txtIngreseTextoActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtIngreseImagen = Util.crearTextField(14);
        txtIngreseImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txtIngreseImagenActionPerformed(evt);
            }

            private void txtIngreseImagen2ActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        getContentPane().add(txtIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, -1));
        getContentPane().add(txtIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 310, -1));

        btnAceptar = Util.crearBoton("Aceptar", 14);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        btnCancelar = Util.crearBoton("Cancelar", 14);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }

            private void btnCancelarActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        btnArchivoImagen=Util.crearBoton("Archivo", 12);
        getContentPane().add(btnArchivoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));
        btnArchivoSonido=Util.crearBoton("Archivo", 12);
        getContentPane().add(btnArchivoSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/integrados/view/images/FondoChico.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 320));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        

    private void txtIngreseImagenActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

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
            java.util.logging.Logger.getLogger(AgregarBloqueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarBloqueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarBloqueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarBloqueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarBloqueDlg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnArchivoImagen;
    private javax.swing.JButton btnArchivoSonido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIngreseImagen;
    private javax.swing.JLabel lblIngreseSonido;
    private javax.swing.JLabel lblIngreseTexto;
    private javax.swing.JLabel lblAgregarOpcion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtIngreseTexto;
    private javax.swing.JTextField txtIngreseImagen;
    private javax.swing.JTextField txtIngreseSonido;
    // End of variables declaration                   
}
