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
import org.integrados.data.util.Util;

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
        this.setBackground(new Color(0, 102, 102));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                controlador.cerrarAplicacion();
            }
        });            

        // Creando panel general y aplicando fondo        
        panel = new JScrollPane();
        lblFondo = new JLabel();   
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/Fondo2.jpg","Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);
        
        // Creando elementos de seccion 1
        lblTitulo = Util.crearLabel("Crear Pregunta y Respuestas", 0, 18);
        comboMateria = Util.crearCombo("Materia");
        comboNivel = Util.crearCombo("Nivel");
        comboNivel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboNivelActionPerformed(evt);
            }
        });
        comboGrado = Util.crearCombo("Grado");
        comboGrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboGradoActionPerformed(evt);
            }
        });
        comboDificultad = Util.crearCombo("Dificultad");
        comboDificultad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });
        lblMaxIntentos = Util.crearLabel("Max.Intentos:", 0, 12);
        txtMaxIntentos = Util.crearTextField(14);
        lblTema = Util.crearLabel("Tema:", 0, 14);
        txtTema = Util.crearTextField(14);
        txtTema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtTemaActionPerformed(evt);
            }
        });
        
        
        // Creando elementos de seccion 2
        linePregunta = new JSeparator();
        lblPregunta = Util.crearLabel("Pregunta (complete uno o mas campos)", 1, 14);
        lblIngreseTexto = Util.crearLabel("Ingrese texto", 0, 14);
        txtIngreseTexto = Util.crearTextField(14);
        txtIngreseTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseTextoActionPerformed(evt);
            }
        });
        lblIngreseImagen = Util.crearLabel("Ingrese imagen", 0, 14);
        txtIngreseImagen = Util.crearTextField(14);
        txtIngreseImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseImagenActionPerformed(evt);
            }
        });
        btnArchivoImagen = Util.crearBoton("Archivo", 12);
        lblIngreseSonido = Util.crearLabel("Ingrese sonido", 0, 14);
        txtIngreseSonido = Util.crearTextField(14);
        txtIngreseSonido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseSonidoActionPerformed(evt);
            }
        });
        btnArchivoSonido = Util.crearBoton("Archivo", 12);
        
        
        // Creando elementos de seccion 3
        lineRespuestas = new JSeparator();
        lblRespuestas = Util.crearLabel("Respuestas (Ingrese al menos 2 opciones)", 1, 14);
        btnAgregar = Util.crearBoton("Agregar", 12);
        tablaRespuestas = new JTable();
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
        lblIcoTexto = new JLabel();
        lblIcoTexto.setIcon(createImageIcon("images/IcoTexto.png","IcoTexto"));
        lblIcoImagen = new JLabel();
        lblIcoImagen.setIcon(createImageIcon("images/IcoImagen.png","IcoImagen"));
        lblIcoSonido = new JLabel();
        lblIcoSonido.setIcon(createImageIcon("images/IcoSonido.png","IcoSonido"));
        lblIcoValidar = new JLabel();
        lblIcoValidar.setIcon(createImageIcon("images/IcoValidar.jpg","IcoValidar"));
        
        
        // Creando elementos de footer
        btnProbar = Util.crearBoton("Probar", 12);;
        btnGuardar = Util.crearBoton("Guardar", 12);;
        btnCancelar = Util.crearBoton("Cancelar", 12);;
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                controlador.nuevaActividadInicioDlg.mostrar();
            }
        });

        
        // Agregando elementos a la ventana
        getContentPane().setLayout(new AbsoluteLayout());
     
        getContentPane().add(lblTitulo, new AbsoluteConstraints(270, 10, 260, 50)); 
        getContentPane().add(comboMateria, new AbsoluteConstraints(70, 70, 160, 30));   
        getContentPane().add(comboNivel, new AbsoluteConstraints(250, 70, 100, 30));           
        getContentPane().add(comboGrado, new AbsoluteConstraints(370, 70, 100, 30));  
        getContentPane().add(comboDificultad, new AbsoluteConstraints(490, 70, 100, 30));  
        getContentPane().add(lblMaxIntentos, new AbsoluteConstraints(600, 70, 90, 30));
        getContentPane().add(txtMaxIntentos, new AbsoluteConstraints(690, 70, 30, 30));
        getContentPane().add(lblTema, new AbsoluteConstraints(70, 110, 50, 30));
        getContentPane().add(txtTema, new AbsoluteConstraints(120, 110, 600, 30));

        getContentPane().add(linePregunta, new AbsoluteConstraints(60, 160, 670, 10));
        getContentPane().add(lblPregunta, new AbsoluteConstraints(70, 160, 340, 30));
        getContentPane().add(lblIngreseTexto, new AbsoluteConstraints(70, 200, 110, 30)); 
        getContentPane().add(txtIngreseTexto, new AbsoluteConstraints(180, 200, 540, 30));
        getContentPane().add(lblIngreseImagen, new AbsoluteConstraints(70, 240, 110, 30));   
        getContentPane().add(txtIngreseImagen, new AbsoluteConstraints(180, 240, 440, 30));
        getContentPane().add(btnArchivoImagen, new AbsoluteConstraints(640, 240, 80, 30));
        getContentPane().add(lblIngreseSonido, new AbsoluteConstraints(70, 280, 110, 30));
        getContentPane().add(txtIngreseSonido, new AbsoluteConstraints(180, 280, 440, 30));
        getContentPane().add(btnArchivoSonido, new AbsoluteConstraints(640, 280, 80, 30));     

        getContentPane().add(lineRespuestas, new AbsoluteConstraints(60, 330, 670, 10));
        getContentPane().add(lblRespuestas, new AbsoluteConstraints(70, 330, 340, 30));
        getContentPane().add(btnAgregar, new AbsoluteConstraints(640, 340, 80, 30));   
        getContentPane().add(lblIcoTexto, new AbsoluteConstraints(90, 380, 30, 30));
        getContentPane().add(lblIcoImagen, new AbsoluteConstraints(250, 380, 30, 30));
        getContentPane().add(lblIcoSonido, new AbsoluteConstraints(410, 380, 30, 30));
        getContentPane().add(lblIcoValidar, new AbsoluteConstraints(570, 380, -1, -1));
        panel.setViewportView(tablaRespuestas);
        getContentPane().add(panel, new AbsoluteConstraints(70, 380, 650, 120));
        
        getContentPane().add(btnProbar, new AbsoluteConstraints(250, 520, 80, 30));    
        getContentPane().add(btnGuardar, new AbsoluteConstraints(360, 520, 80, 30));
        getContentPane().add(btnCancelar, new AbsoluteConstraints(460, 520, 80, 30));         

        
        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 600));
        
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
        System.out.println("Docente id:" + this.docente.getId());
    }
    
    public void ocultar() {
        this.setVisible(false);
    } 
}
