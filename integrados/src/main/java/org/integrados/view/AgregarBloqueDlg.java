package org.integrados.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.integrados.controller.actividades.AgregarBloqueCtrl;
import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.data.util.Util;

/**
 *
 * @author Grupo Front
 */
public class AgregarBloqueDlg extends JFrame {
    
    // Variables declaration     
    public CrearPregYRespCtrl crearPregYRespCtrl; 
    public AgregarBloqueCtrl controlador;  
    private String titulo = null;   
                     
    private JLabel lblTitulo = null;
    private JLabel lblSubTitulo = null;
    private JButton btnAceptar = null;
    private JButton btnCancelar = null;
    private JButton btnArchivoImagen = null;
    private JButton btnArchivoSonido = null;
    private JLabel lblFondo = null;
    private JLabel lblIngreseImagen = null;
    private JLabel lblIngreseSonido = null;
    private JLabel lblIngreseTexto = null;
    private JSeparator linea = null;
    private JTextField txtIngreseTexto = null;
    private JTextField txtIngreseImagen = null;
    private JTextField txtIngreseSonido = null;
    // End of variables declaration        
    
    /**
     * Constructor para usar desde Crear Actividad
     * @param controlador - Controlador de la vista a crear
     * @param crearPregYRespCtrl - Controlador de la vista anterior
     */
    public AgregarBloqueDlg(AgregarBloqueCtrl controlador, CrearPregYRespCtrl crearPregYRespCtrl) { 
        this.controlador = controlador; 
        this.crearPregYRespCtrl = crearPregYRespCtrl; 
        initComponents(); 
    } 
    /**
     * Constructor para usar desde Editar Actividad
     * @param controlador - Controlador de la vista a crear
     * @param crearPregYRespCtrl - Controlador de la vista anterior
     * @param titulo - Título dinámico con id del bloque a editar 
     */
    public AgregarBloqueDlg(AgregarBloqueCtrl controlador, CrearPregYRespCtrl crearPregYRespCtrl, String titulo) { 
        this.controlador = controlador; 
        this.crearPregYRespCtrl = crearPregYRespCtrl; 
        this.titulo = titulo;
        initComponents(); 
    } 
    
    /**
    * Metodo para inicializar los componentes de la vista
    */        
    private void initComponents() { 
        if (this.controlador.isAlta()) {
            this.setTitle("Nuevo Bloque");
        } else {
            this.setTitle(titulo);
        }
        this.pack();
        this.setSize(400, 300);
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
        
        // Creando elementos            
        lblFondo = new JLabel();
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/FondoChico.jpg","Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 400, 300);
        
        if (this.controlador.isAlta()) {
            lblTitulo = Util.crearLabel("Agregar Bloque", 0, 18);
        } else {
            lblTitulo = Util.crearLabel("Editar Bloque", 0, 18);
        }
        lblSubTitulo = Util.crearLabel("(Complete al menos un campo)", 0, 14);
        lblIngreseTexto = Util.crearLabel("Ingrese texto", 0, 14);
        txtIngreseTexto = Util.crearTextField(14);
        lblIngreseImagen = Util.crearLabel("Ingrese imagen", 0, 14);
        txtIngreseImagen = Util.crearTextField(14);
        btnArchivoImagen = Util.crearBoton("Archivo", 12);
        btnArchivoImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VistaSistemaDeArchivos VistaSistemaDeArchivos = new VistaSistemaDeArchivos();
                VistaSistemaDeArchivos.mostrar();
            }
        });
        lblIngreseSonido = Util.crearLabel("Ingrese sonido", 0, 14);
        txtIngreseSonido = Util.crearTextField(14);
        btnArchivoSonido = Util.crearBoton("Archivo", 12);
        linea = new JSeparator();
        btnAceptar = Util.crearBoton("Aceptar", 14);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ocultar();
            }
        });
        btnCancelar = Util.crearBoton("Cancelar", 14);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ocultar();
            }
        });

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());     
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 20));
        getContentPane().add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 200, 20));
        getContentPane().add(lblIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, 20));
        getContentPane().add(txtIngreseTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 320, 30));
        getContentPane().add(lblIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 20));
        getContentPane().add(txtIngreseImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, 30));
        getContentPane().add(btnArchivoImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 80, 30));
        getContentPane().add(lblIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 20));   
        getContentPane().add(txtIngreseSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 30));
        getContentPane().add(btnArchivoSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 80, 30));
        getContentPane().add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 320, 1));
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 80, 30));
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 80, 30));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));
        pack();
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
