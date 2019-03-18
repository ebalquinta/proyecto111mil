/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradosswing.IntegradosSwing;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Escaliner SD
 */
public class LogIn extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;

    private boolean habilitado;

    public LogIn() {
        initComponents();
    }

    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jCheckBox1.setText("Recordar ");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(120, 420, 120, 23);

        jTextField1.setText(" U S U A R I O");
        jTextField1.setToolTipText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 280, 320, 40);

        jPasswordField1.setText(" U S U A R I O");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(180, 350, 320, 40);

        jButton1.setText("Aceptar");
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 460, 200, 50);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 System.out.print(jPasswordField1.getPassword());
                 System.out.print(jTextField1.getText());
                 String Aux = String.valueOf(jPasswordField1.getPassword());
              
                habilitado = (jTextField1.getText().equals(Aux));
                if (habilitado) {
                
                  pantalla_menu p = new pantalla_menu();
                  setVisible(false);
                
                 
                }
                else 
                    System.out.print ("ERROR");
                
            }
        }
        );

        jButton2.setText("Cancelar");
        getContentPane().add(jButton2);
        jButton2.setBounds(330, 460, 210, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/integradosswing/IntegradosSwing/Imagenes/LogIn1.1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 620);

        pack();
        this.setBounds(new Rectangle(600, 660));
        this.setVisible(true);
    }// </editor-fold>              

//    public void run() {
//        LogIn l = new LogIn();
//    }

    public boolean isHabilitado() {
        return habilitado;
    }
}
