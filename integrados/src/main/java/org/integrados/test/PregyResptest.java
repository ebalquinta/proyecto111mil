
package org.integrados.test;

/**
 *
 * @author home
 */
public class PregyResptest extends javax.swing.JFrame {

    /**
     * Creates new form PregyResptest
     */
    public PregyResptest() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JLabel lblBienHecho;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIntentos;
    private javax.swing.JLabel lblPregunta;
    // End of variables declaration//GEN-END:variables
}
