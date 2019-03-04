/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import org.netbeans.lib.awtextra.*;
import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.data.usuarios.Docente;

/**
 *
 * @author VIB
 */
public class CrearPregYRespDlg  extends JFrame {

    // Variables declaration     
    public CrearPregYRespCtrl controlador;
    public Docente docente;          
    
    private JScrollPane panel = null;
    private JLabel lblFondo = null;
    
    private JLabel lblTitulo = null;
    private JComboBox<String> comboMateria = null;
    private JComboBox<String> comboNivel = null;
    private JComboBox<String> comboGrado = null;
    private JComboBox<String> comboDificultad = null;
    private JLabel lblMaxIntentos = null;
    private JTextField txtMaxIntentos = null;
    private JLabel lblTema = null;
    private JTextField txtTema = null;
    
    private JSeparator linePregunta = null;
    private JLabel lblPregunta = null;
    private JLabel lblIngreseTexto = null;
    private JTextField txtIngreseTexto = null;
    private JLabel lblIngreseImagen = null;
    private JTextField txtIngreseImagen = null;
    private JButton btnArchivoImagen = null;
    private JLabel lblIngreseSonido = null;
    private JTextField txtIngreseSonido = null;
    private JButton btnArchivoSonido = null;
    
    private JSeparator lineRespuestas = null;
    private JLabel lblRespuestas = null;
    private JButton btnAgregar = null;
    private JTable tablaRespuestas = null;
    private JLabel lblIcoTexto = null;
    private JLabel lblIcoImagen = null;
    private JLabel lblIcoSonido = null;
    private JLabel lblIcoValidar = null;
    
    private JButton btnProbar = null;
    private JButton btnGuardar = null;
    private JButton btnCancelar = null;
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                controlador.cerrarAplicacion();
            }
        });            

        panel = new JScrollPane();
        lblFondo = new JLabel();
        
        lblTitulo = new JLabel();
        comboMateria = new JComboBox<>();
        comboNivel = new JComboBox<>();
        comboGrado = new JComboBox<>();
        comboDificultad = new JComboBox<>();
        lblMaxIntentos = new JLabel();
        txtMaxIntentos = new JTextField();
        lblTema = new JLabel();
        txtTema = new JTextField();
        
        linePregunta = new JSeparator();
        lblPregunta = new JLabel();
        lblIngreseTexto = new JLabel();
        txtIngreseTexto = new JTextField();
        lblIngreseImagen = new JLabel();
        txtIngreseImagen = new JTextField();
        btnArchivoImagen = new JButton();
        lblIngreseSonido = new JLabel();
        txtIngreseSonido = new JTextField();
        btnArchivoSonido = new JButton();
        
        lineRespuestas = new JSeparator();
        lblRespuestas = new JLabel();
        btnAgregar = new JButton();
        tablaRespuestas = new JTable();
        lblIcoTexto = new JLabel();
        lblIcoImagen = new JLabel();
        lblIcoSonido = new JLabel();
        lblIcoValidar = new JLabel();
        
        btnProbar = new JButton();
        btnGuardar = new JButton();
        btnCancelar = new JButton();

        setBackground(new Color(0, 102, 102));
        getContentPane().setLayout(new AbsoluteLayout());

        txtMaxIntentos.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        getContentPane().add(txtMaxIntentos, new AbsoluteConstraints(650, 60, 30, 30));
        getContentPane().add(linePregunta, new AbsoluteConstraints(60, 160, 670, 10));

        lblRespuestas.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblRespuestas.setText("Respuestas(Ingrese al menos 2 opciones)");
        getContentPane().add(lblRespuestas, new AbsoluteConstraints(70, 330, 340, 30));

        lblIngreseImagen.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseImagen.setText("Ingrese imagen");
        getContentPane().add(lblIngreseImagen, new AbsoluteConstraints(80, 240, 110, 30));

        lblIngreseSonido.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseSonido.setText("Ingrese sonido");
        getContentPane().add(lblIngreseSonido, new AbsoluteConstraints(80, 280, 110, 30));

        lblIngreseTexto.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblIngreseTexto.setText("Ingrese texto");
        getContentPane().add(lblIngreseTexto, new AbsoluteConstraints(80, 200, 110, 30));

        txtIngreseImagen.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseImagenActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseImagen, new AbsoluteConstraints(190, 240, 230, 30));

        txtIngreseSonido.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseSonido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseSonidoActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseSonido, new AbsoluteConstraints(190, 280, 230, 30));
        getContentPane().add(lineRespuestas, new AbsoluteConstraints(60, 330, 670, 10));

        lblIcoTexto.setIcon(new ImageIcon(getClass().getResource("images/IcoTexto.png"))); // NOI18N
        lblIcoTexto.setLabelFor(panel);
        getContentPane().add(lblIcoTexto, new AbsoluteConstraints(90, 380, 30, 30));

        lblIcoSonido.setIcon(new ImageIcon(getClass().getResource("images/IcoSonido.png"))); // NOI18N
        getContentPane().add(lblIcoSonido, new AbsoluteConstraints(410, 380, 30, 30));

        lblPregunta.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPregunta.setText("Pregunta(complete uno o mas campos)");
        getContentPane().add(lblPregunta, new AbsoluteConstraints(70, 160, 340, 30));

        lblIcoValidar.setIcon(new ImageIcon(getClass().getResource("images/IcoValidar.jpg"))); // NOI18N
        getContentPane().add(lblIcoValidar, new AbsoluteConstraints(570, 380, -1, -1));

        lblIcoImagen.setIcon(new ImageIcon(getClass().getResource("images/IcoImagen.png"))); // NOI18N
        getContentPane().add(lblIcoImagen, new AbsoluteConstraints(250, 380, 30, 30));

        btnProbar.setBackground(new Color(0, 102, 102));
        btnProbar.setFont(new Font("Comic Sans MS", 1, 12)); // NOI18N
        btnProbar.setForeground(new Color(0, 102, 102));
        btnProbar.setText("Probar");
        getContentPane().add(btnProbar, new AbsoluteConstraints(250, 520, 80, 30));

        btnGuardar.setBackground(new Color(0, 102, 102));
        btnGuardar.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        getContentPane().add(btnGuardar, new AbsoluteConstraints(360, 520, 80, 30));

        btnCancelar.setBackground(new Color(0, 102, 102));
        btnCancelar.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new AbsoluteConstraints(460, 520, 80, 30));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                controlador.nuevaActividadInicioDlg.mostrar();
            }
        });

        btnArchivoSonido.setBackground(new Color(0, 102, 102));
        btnArchivoSonido.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        btnArchivoSonido.setText("Archivo");
        getContentPane().add(btnArchivoSonido, new AbsoluteConstraints(430, 280, 80, 30));

        comboGrado.setBackground(new Color(0, 102, 102));
        comboGrado.setEditable(true);
        comboGrado.setForeground(new Color(0, 102, 102));
        comboGrado.setModel(new DefaultComboBoxModel<>(new String[] { "Grado" }));
        comboGrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboGradoActionPerformed(evt);
            }
        });
        getContentPane().add(comboGrado, new AbsoluteConstraints(350, 60, 90, 30));


        tablaRespuestas.setBorder(BorderFactory.createCompoundBorder());
        tablaRespuestas.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        tablaRespuestas.setModel(new DefaultTableModel(
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
        tablaRespuestas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaRespuestas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tablaRespuestas.setFocusCycleRoot(true);
        tablaRespuestas.setGridColor(new Color(0, 102, 102));
        tablaRespuestas.setMinimumSize(new Dimension(10, 10));
        panel.setViewportView(tablaRespuestas);

        getContentPane().add(panel, new AbsoluteConstraints(80, 380, 650, 120));

        btnAgregar.setBackground(new Color(0, 102, 102));
        btnAgregar.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        getContentPane().add(btnAgregar, new AbsoluteConstraints(640, 340, 80, 30));

        btnArchivoImagen.setBackground(new Color(0, 102, 102));
        btnArchivoImagen.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        btnArchivoImagen.setText("Archivo");
        getContentPane().add(btnArchivoImagen, new AbsoluteConstraints(430, 240, 80, 30));

        lblTema.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        lblTema.setText("Tema:");
        getContentPane().add(lblTema, new AbsoluteConstraints(120, 120, 60, 30));

        lblMaxIntentos.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        lblMaxIntentos.setText("Max.Intentos:");
        getContentPane().add(lblMaxIntentos, new AbsoluteConstraints(560, 60, 90, 30));

        txtIngreseTexto.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        txtIngreseTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseTextoActionPerformed(evt);
            }
        });
        getContentPane().add(txtIngreseTexto, new AbsoluteConstraints(190, 200, 520, 30));

        txtTema.setFont(new Font("Comic Sans MS", 0, 14)); // NOI18N
        txtTema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtTemaActionPerformed(evt);
            }
        });
        getContentPane().add(txtTema, new AbsoluteConstraints(170, 120, 520, 30));

        comboNivel.setBackground(new Color(0, 102, 102));
        comboNivel.setEditable(true);
        comboNivel.setForeground(new Color(0, 102, 102));
        comboNivel.setModel(new DefaultComboBoxModel<>(new String[] { "Nivel" }));
        comboNivel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboNivelActionPerformed(evt);
            }
        });
        getContentPane().add(comboNivel, new AbsoluteConstraints(260, 60, 80, 30));

        comboDificultad.setBackground(new Color(0, 102, 102));
        comboDificultad.setEditable(true);
        comboDificultad.setForeground(new Color(0, 102, 102));
        comboDificultad.setModel(new DefaultComboBoxModel<>(new String[] { "Dificultad" }));
        comboDificultad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });
        getContentPane().add(comboDificultad, new AbsoluteConstraints(450, 60, 90, 30));

        comboMateria.setBackground(new Color(0, 102, 102));
        comboMateria.setEditable(true);
        comboMateria.setForeground(new Color(0, 102, 102));
        comboMateria.setModel(new DefaultComboBoxModel<>(new String[] { "Materia" }));
        getContentPane().add(comboMateria, new AbsoluteConstraints(90, 60, 160, 30));

        lblTitulo.setFont(new Font("Comic Sans MS", 0, 18)); // NOI18N
        lblTitulo.setText("Crear Pregunta y Respuestas");
        getContentPane().add(lblTitulo, new AbsoluteConstraints(270, 10, 260, 50));

        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        lblFondo.setIcon(new ImageIcon(getClass().getResource("images/Fondo2.jpg"))); // NOI18N
        lblFondo.setText("lblFondo");
        lblFondo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblFondo.setMaximumSize(new Dimension(800, 600));
        lblFondo.setMinimumSize(new Dimension(800, 600));
        lblFondo.setName(""); // NOI18N
        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 590));

        pack();
    }                   

    private void comboDificultadActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void comboNivelActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtTemaActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseTextoActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseImagenActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void txtIngreseSonidoActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void comboGradoActionPerformed(ActionEvent evt) {                                           
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
