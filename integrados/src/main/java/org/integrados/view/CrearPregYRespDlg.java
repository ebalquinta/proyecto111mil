/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author VIB
 */
public class CrearPregYRespDlg  extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnArchivoImagen;
    private javax.swing.JButton btnArchivoSonido;
    private javax.swing.JButton btnProbar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboNivel;
    private javax.swing.JComboBox<String> comboDificultad;
    private javax.swing.JComboBox<String> comboMateria;
    private javax.swing.JComboBox<String> comboGrado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcoTexto;
    private javax.swing.JLabel lblIcoImagen;
    private javax.swing.JLabel lblIcoSonido;
    private javax.swing.JLabel lblIcoValidar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblMaxIntentos;
    private javax.swing.JLabel lblRespuestas;
    private javax.swing.JLabel lblIngreseSonido;
    private javax.swing.JLabel lblIngreseImagen;
    private javax.swing.JLabel lblIngreseTexto;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JScrollPane panel;
    private javax.swing.JSeparator linePregunta;
    private javax.swing.JSeparator lineRespuestas;
    private javax.swing.JTable tablaRespuestas;
    private javax.swing.JTextField txtMaxIntentos;
    private javax.swing.JTextField txtTema;
    private javax.swing.JTextField txtIngreseTexto;
    private javax.swing.JTextField txtIngreseImagen;
    private javax.swing.JTextField txtIngreseSonido;
    public CrearPregYRespCtrl controlador;
    public Docente docente;
    // End of variables declaration           
    
    /**
     * Creates new form CrearPregYRespDlg
     */
    public CrearPregYRespDlg() {
        initComponents();
    }
    public CrearPregYRespDlg(CrearPregYRespCtrl controlador, Docente docente) {
        this.controlador = controlador;
        this.docente = docente;
        initComponents();
    }

    /**
     * Metodo para inicializar los componentes de la vista
     */          
    private void initComponents() {      
        this.setTitle("Nueva Actividad - Pregunta y Respuestas");
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                controlador.cerrarAplicacion();
            }
        });            

        panel = new javax.swing.JScrollPane();
        lblFondo = new javax.swing.JLabel();
        
        lblTitulo = new javax.swing.JLabel();
        comboMateria = new javax.swing.JComboBox<>();
        comboNivel = new javax.swing.JComboBox<>();
        comboGrado = new javax.swing.JComboBox<>();
        comboDificultad = new javax.swing.JComboBox<>();
        lblMaxIntentos = new javax.swing.JLabel();
        txtMaxIntentos = new javax.swing.JTextField();
        lblTema = new javax.swing.JLabel();
        txtTema = new javax.swing.JTextField();
        
        linePregunta = new javax.swing.JSeparator();
        lblPregunta = new javax.swing.JLabel();
        lblIngreseTexto = new javax.swing.JLabel();
        txtIngreseTexto = new javax.swing.JTextField();
        lblIngreseImagen = new javax.swing.JLabel();
        txtIngreseImagen = new javax.swing.JTextField();
        btnArchivoImagen = new javax.swing.JButton();
        lblIngreseSonido = new javax.swing.JLabel();
        txtIngreseSonido = new javax.swing.JTextField();
        btnArchivoSonido = new javax.swing.JButton();
        
        lineRespuestas = new javax.swing.JSeparator();
        lblRespuestas = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        tablaRespuestas = new javax.swing.JTable();
        lblIcoTexto = new javax.swing.JLabel();
        lblIcoImagen = new javax.swing.JLabel();
        lblIcoSonido = new javax.swing.JLabel();
        lblIcoValidar = new javax.swing.JLabel();
        
        btnProbar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaxIntentos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        getContentPane().add(txtMaxIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 30, 30));
        getContentPane().add(linePregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 670, 10));

        lblRespuestas.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblRespuestas.setText("Respuestas(Ingrese al menos 2 opciones)");
        getContentPane().add(lblRespuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 340, 30));

        lblIngreseImagen.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseImagen.setText("Ingrese imagen");
        getContentPane().add(lblIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, 30));

        lblIngreseSonido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseSonido.setText("Ingrese sonido");
        getContentPane().add(lblIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 110, 30));

        lblIngreseTexto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseTexto.setText("Ingrese texto");
        getContentPane().add(lblIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 110, 30));

        txtIngreseImagen.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngreseImagenActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 230, 30));

        txtIngreseSonido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseSonido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngreseSonidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 230, 30));
        getContentPane().add(lineRespuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 670, 10));

        lblIcoTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/IcoTexto.png"))); // NOI18N
        lblIcoTexto.setLabelFor(panel);
        getContentPane().add(lblIcoTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 30, 30));

        lblIcoSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/IcoSonido.png"))); // NOI18N
        getContentPane().add(lblIcoSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 30, 30));

        lblPregunta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPregunta.setText("Pregunta(complete uno o mas campos)");
        getContentPane().add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 340, 30));

        lblIcoValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/IcoValidar.jpg"))); // NOI18N
        getContentPane().add(lblIcoValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, -1));

        lblIcoImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/IcoImagen.png"))); // NOI18N
        getContentPane().add(lblIcoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 30, 30));

        btnProbar.setBackground(new java.awt.Color(0, 102, 102));
        btnProbar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnProbar.setForeground(new java.awt.Color(0, 102, 102));
        btnProbar.setText("Probar");
        getContentPane().add(btnProbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 80, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 80, 30));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 80, 30));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                controlador.nuevaActividadInicioDlg.mostrar();
            }
        });

        btnArchivoSonido.setBackground(new java.awt.Color(0, 102, 102));
        btnArchivoSonido.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnArchivoSonido.setText("Archivo");
        getContentPane().add(btnArchivoSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 80, 30));

        comboGrado.setBackground(new java.awt.Color(0, 102, 102));
        comboGrado.setEditable(true);
        comboGrado.setForeground(new java.awt.Color(0, 102, 102));
        comboGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grado" }));
        comboGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGradoActionPerformed(evt);
            }
        });
        getContentPane().add(comboGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 90, 30));

        panel.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N

        tablaRespuestas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tablaRespuestas.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaRespuestas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "           Texto", "           Imagen", "           Sonido", "           Es Valida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaRespuestas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaRespuestas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaRespuestas.setFocusCycleRoot(true);
        tablaRespuestas.setGridColor(new java.awt.Color(0, 102, 102));
        tablaRespuestas.setMinimumSize(new java.awt.Dimension(10, 10));
        panel.setViewportView(tablaRespuestas);

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 650, 120));

        btnAgregar.setBackground(new java.awt.Color(0, 102, 102));
        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 80, 30));

        btnArchivoImagen.setBackground(new java.awt.Color(0, 102, 102));
        btnArchivoImagen.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        btnArchivoImagen.setText("Archivo");
        getContentPane().add(btnArchivoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 80, 30));

        lblTema.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblTema.setText("Tema:");
        getContentPane().add(lblTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 60, 30));

        lblMaxIntentos.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblMaxIntentos.setText("Max.Intentos:");
        getContentPane().add(lblMaxIntentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 90, 30));

        txtIngreseTexto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngreseTextoActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 520, 30));

        txtTema.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 520, 30));

        comboNivel.setBackground(new java.awt.Color(0, 102, 102));
        comboNivel.setEditable(true);
        comboNivel.setForeground(new java.awt.Color(0, 102, 102));
        comboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nivel" }));
        comboNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNivelActionPerformed(evt);
            }
        });
        getContentPane().add(comboNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 80, 30));

        comboDificultad.setBackground(new java.awt.Color(0, 102, 102));
        comboDificultad.setEditable(true);
        comboDificultad.setForeground(new java.awt.Color(0, 102, 102));
        comboDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dificultad" }));
        comboDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });
        getContentPane().add(comboDificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 90, 30));

        comboMateria.setBackground(new java.awt.Color(0, 102, 102));
        comboMateria.setEditable(true);
        comboMateria.setForeground(new java.awt.Color(0, 102, 102));
        comboMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia" }));
        getContentPane().add(comboMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 160, 30));

        lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lblTitulo.setText("Crear Pregunta y Respuestas");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 260, 50));

        lblFondo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Fondo2.jpg"))); // NOI18N
        lblFondo.setText("lblFondo");
        lblFondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        lblFondo.setMinimumSize(new java.awt.Dimension(800, 600));
        lblFondo.setName(""); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        pack();
    }                   

    private void comboDificultadActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void comboNivelActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtTemaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseTextoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseImagenActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseSonidoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void comboGradoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }     
        
    public void mostrar() {
        this.setVisible(true);
        System.out.println("Docente id:" + this.docente.getId());
    }
    
    public void ocultar() {
        this.setVisible(false);
    } 
}
