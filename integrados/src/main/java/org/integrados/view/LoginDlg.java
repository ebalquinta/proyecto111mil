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
    private JButton btnSobreNosotros;
    private JTextField txtUsuario;
    private JPasswordField pswClave;
    private LoginCtrl loginCtrl;
    private JLabel etiUsuario;
    private JLabel etiClave;
    
    public LoginDlg(LoginCtrl loginCtrl) {
        this.loginCtrl = loginCtrl;
        initComponents();
    }
    
    private void initComponents() {
        
        txtUsuario = new JTextField();
        pswClave = new JPasswordField();
        btnAceptar = new JButton();
        btnCancelar = new JButton();
        btnSobreNosotros = new JButton();
        lblFondo = new JLabel();
        etiUsuario = new JLabel();
        etiClave = new JLabel();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        // Propiedades de etiqueta de usuario
        etiUsuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        etiUsuario.setText("Usuario");
        etiUsuario.setBounds(525, 150, 120, 20);
        getContentPane().add(etiUsuario);
        
        // Propiedades de campo de usuario
        txtUsuario.setBackground(new java.awt.Color(0, 204, 204));
        txtUsuario.setText("");
        txtUsuario.setToolTipText("Ingrese su usuario");
        txtUsuario.setBounds(630, 145, 120, 30);
        getContentPane().add(txtUsuario);
        
        // Propiedades de etiqueta de clave
        etiClave.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        etiClave.setText("Contraseña");
        etiClave.setBounds(510, 230, 120, 20);
        getContentPane().add(etiClave);

        // Propiedades de campo de clave
        pswClave.setBackground(new java.awt.Color(0, 204, 204));
        pswClave.setText("");
        pswClave.setToolTipText("Ingrese su contraseña");
        getContentPane().add(pswClave);
        pswClave.setBounds(630, 225, 120, 30);
       
        // Propiedades de botón Aceptar
        btnAceptar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBounds(510, 370, 120, 30);
        getContentPane().add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    loginCtrl.validar(txtUsuario.getText(), String.valueOf(pswClave.getPassword()));
                } catch (IntegradosException e) {
                    Dialogo.error("Error de Logueo", e.getMessage());
                    return;
                }
                
                // Aquí debemos enlazar con la siguiente pantalla
                // La de docente que tiene los botones Actividades y Alumnos
                
                DocenteInicioDlg docenteInicioDlg = new DocenteInicioDlg();
                docenteInicioDlg.mostrar();
            }
        });
        
        // Propiedades de botón Cancelar
        // btnCancelar.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        btnCancelar.setText("Salir");
        btnCancelar.setBounds(645, 370, 120, 30);
        getContentPane().add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loginCtrl.finalizar();
            }
        });

        // Propiedades del botón SobreNosotros
        btnSobreNosotros.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        btnSobreNosotros.setText("Sobre Nosotros");
        btnSobreNosotros.setBounds(295, 510, 170, 30);
        getContentPane().add(btnSobreNosotros);
        btnSobreNosotros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Aqui lo que hace el botón
                SobreNosotrosDlg sobreNosotrosDlg = new SobreNosotrosDlg();
                sobreNosotrosDlg.mostrar();
            }
        });
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/ver1.0-LoginBackground.jpg","descripción");
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