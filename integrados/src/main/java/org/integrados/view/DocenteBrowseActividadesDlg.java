package org.integrados.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.*;
import org.integrados.controller.actividades.DocenteBrowseActividadesCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.util.Util;

/**
 *
 * @author Grupo Front
 */
public class DocenteBrowseActividadesDlg extends JFrame {
    
    private JLabel lblFondo;

    private DocenteBrowseActividadesCtrl controlador = null;
    private Actividad actividad = null;
    
    //Booleano que indica si se está dando de alta una actividad o es una edición.
    private boolean alta = false;
    private String titulo = null;

//    private JDialog dialogoPrincipal;

    private JPanel pnlBotonesEdicion = null;
    public JButton botonGuardar = null;
    public JButton botonCancelar = null;
    private JTextField txtNombre;
    private JCheckBox chkActivo;
    private JTextField txtUrl;
    private JTextField txtFilePath;
    private JRadioButton rbtnFilePath;
    private JRadioButton rbtnURL;
    
    /**
     * Constructor
     * @param controlador
     */
    public DocenteBrowseActividadesDlg(DocenteBrowseActividadesCtrl controlador) {
        this.controlador = controlador;                
        initComponents();
    }
    
    public void editar(Actividad actividad) {
        this.actividad = actividad;
        this.alta = false;        
        this.titulo = "Edición de Actividad nro. " + actividad.getId();
    }
    
    public void nuevo(Actividad actividad) {
        this.actividad = actividad;
        this.alta = true; 
        this.titulo = "Agregar Nueva Actividad";
    }

    /**
     * Método que muestra el Dialogo.
     *
     * @param parent para que actue como modal con el Frame o Dialog padre
     */
//    
    public void mostrar() {
        this.setVisible(true);
    }

    //Inicializa la interfaz de usuario
    private void initComponents() {
        
        lblFondo = new JLabel();
        ///////////////////////////Botones//////////////////////////
        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        this.add(pnlBotonesEdicion, BorderLayout.SOUTH);

        JPanel pnlCentral = new JPanel();
        this.add(pnlCentral, BorderLayout.CENTER);
        pnlCentral.setLayout(null);

        JLabel lblNombre = new JLabel();
        pnlCentral.add(lblNombre);
        lblNombre.setText("Nombre");
        lblNombre.setBounds(16, 14, 74, 16);

        txtNombre = new JTextField();
        pnlCentral.add(txtNombre);
        txtNombre.setBounds(90, 11, 423, 22);
//		txtNombre.setDocument(new FiltroTexto(FiltroTexto.ALL,100));

        ButtonGroup group = new ButtonGroup();

        rbtnURL = new JRadioButton();
        rbtnURL.setText("Desde URL");
        rbtnURL.setBounds(12, 60, 117, 20);
        pnlCentral.add(rbtnURL);
        group.add(rbtnURL);
        rbtnURL.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent changEvent) {
                AbstractButton aButton = (AbstractButton) changEvent.getSource();
                ButtonModel aModel = aButton.getModel();

                habilitarComponentesURL(aModel.isSelected());
            }
        }
        );

        txtUrl = new JTextField();
        txtUrl.setBounds(160, 61, 353, 21);
        pnlCentral.add(txtUrl);

        rbtnFilePath = new JRadioButton();
        rbtnFilePath.setText("Desde archivo local");
        rbtnFilePath.setBounds(12, 101, 148, 20);
        pnlCentral.add(rbtnFilePath);
        group.add(rbtnFilePath);
        rbtnFilePath.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent changEvent) {
                AbstractButton aButton = (AbstractButton) changEvent.getSource();
                ButtonModel aModel = aButton.getModel();

                habilitarComponentesFilePath(aModel.isSelected());
            }
        }
        );

        txtFilePath = new JTextField();
        txtFilePath.setBounds(160, 100, 323, 22);
        pnlCentral.add(txtFilePath);

        chkActivo = new JCheckBox();
        pnlCentral.add(chkActivo);
        chkActivo.setText("Hacer una copia local");
        chkActivo.setBounds(160, 132, 206, 20);

        botonGuardar = Util.crearBoton("Guardar", 12);
        botonGuardar.setBounds(169, 9, 100, 22);
        pnlBotonesEdicion.add(botonGuardar);
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                guardar();
            }
        });

        botonCancelar = Util.crearBoton("Cancelar", 12);
        botonCancelar.setBounds(276, 9, 100, 22);
        pnlBotonesEdicion.add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelar();
            }
        });
        
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/Fondo.jpg","Fondo");
        lblFondo.setIcon(icon);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 800, 600);
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

    //Habilita o no los componentes de edición de archivos por Path
    private void habilitarComponentesFilePath(boolean habilitado) {
        this.txtFilePath.setEnabled(habilitado);
        this.chkActivo.setEnabled(habilitado);
    }

    //Habilita o no los componentes de edición de archivos por URL
    private void habilitarComponentesURL(boolean habilitado) {
        this.txtUrl.setEnabled(habilitado);
    }

    //Permite guardar el recurso
    private void guardar() {

        try {
            validarComponentes();
        } catch (Exception e) {
            Dialogo.error("Error al validar: ", e.getMessage());
            return;
        }
        
        cargarPropiedades();
        
        try {
            
            this.controlador.guardar(actividad, alta);
        } catch (Exception e) {
            Dialogo.error("Error al guardar: ", e.getMessage());
            return;
        } finally {
            // Código que se ejecuta con o sin excepción.
        }
        
        //Si anduvo todo bien se guardó la actividad y se debe cerrar la ventana de edición
        ocultar();
    }

    //Actualiza los componentes con los datos del modelo
    private void actualizarComponentes() {
        this.txtNombre.setText(this.actividad.getPlantilla().toString());
//        this.txtUrl.setText();
//        this.txtFilePath.setText();

        boolean seUsaURL = (!txtUrl.getText().equals(""));
        this.rbtnURL.setSelected(seUsaURL);
        habilitarComponentesURL(seUsaURL);

        boolean seUsaPath = (!txtFilePath.getText().equals(""));
        this.rbtnFilePath.setSelected(seUsaPath);
        habilitarComponentesFilePath(seUsaPath);

        this.chkActivo.setSelected(true);
    }
    
    private void cargarPropiedades() {
        this.actividad.setPlantilla(new PregYResp());
    }

    public void ocultar() {
        this.setVisible(false);
    }   

    //Cancela, en respuesta al requerimiento del usuario
    private void cancelar() {
        ocultar();
    }

    //Irían las validaciones de los componentes, antes de pasar los valores a las 
    //propiedades de la actividad que se está editando.
    private void validarComponentes() {
    }


    
    
    
    
}
