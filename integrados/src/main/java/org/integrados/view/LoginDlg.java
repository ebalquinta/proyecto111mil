/*
 * Ventana de Dialogo de Login.
 */
package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.DocenteInicioDlg;

public class LoginDlg extends JFrame {
    private JLabel lblFondo;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTextField txtUsuario;
    private JPasswordField pswClave;
    private LoginCtrl loginCtrl;

    public LoginDlg(LoginCtrl loginCtrl) {
        this.loginCtrl = loginCtrl;
        initComponents();
    }
    
    private void initComponents() {
        txtUsuario = new JTextField();
        pswClave = new JPasswordField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        lblFondo = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        txtUsuario.setText("");
        txtUsuario.setToolTipText("Ingrese su usuario");
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(180, 280, 320, 40);
        
        pswClave.setText("");
        pswClave.setToolTipText("Ingrese su clave");
        getContentPane().add(pswClave);
        pswClave.setBounds(180, 350, 320, 40);
        
        btnAceptar.setText("Aceptar");
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(130, 460, 200, 50);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    loginCtrl.validar(txtUsuario.getText(), String.valueOf(pswClave.getPassword()));
                } catch (IntegradosException e) {
                    Dialogo.mostrarError(e, null);
                    return;
                }
                
                // Aquí debemos enlazar con la siguiente pantalla
                // La de docente que tiene los botones Actividades y Alumnos
                
                DocenteInicioDlg docenteInicioDlg = new DocenteInicioDlg();
                docenteInicioDlg.mostrar();
                
                // loginCtrl.finalizar();
            }
        });
        
        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(330, 460, 200, 50);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loginCtrl.finalizar();
            }
        });

        ImageIcon icon = createImageIcon("images/LoginBackground.jpg","descripción");
        lblFondo.setIcon(icon);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 600, 600);
        
        this.setBounds(new Rectangle(600, 600));
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