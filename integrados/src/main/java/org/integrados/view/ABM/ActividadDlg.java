package org.integrados.view.ABM;

/**
 *
 * @author Grupo Front
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;

public class ActividadDlg {

    private ActividadCtrl controlador = null;
    private ActividadABM actividad = null;
    
    //Booleano que indica si se está dando de alta una actividad o es una edición.
    private boolean alta = false;
    private String titulo = null;

    private JDialog dialogoPrincipal;

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
     */
    public ActividadDlg(ActividadCtrl controlador) {
        this.controlador = controlador;
    }
    
    public void editar(ActividadABM actividad) {
        this.actividad = actividad;
        this.alta = false;        
        this.titulo = "Edición de Actividad nro. " + actividad.getId();
    }
    
    public void nuevo(ActividadABM actividad) {
        this.actividad = actividad;
        this.alta = true; 
        this.titulo = "Agregar Nueva Actividad";
    }

    /**
     * Método que muestra el Dialogo.
     *
     * @param parent para que actue como modal con el Frame o Dialog padre
     */
    public void mostrar(Window parent) {
        if (parent != null) {
            if (parent instanceof JDialog) {
                dialogoPrincipal = new JDialog((JDialog) parent, true);
            }   else {
                dialogoPrincipal = new JDialog((JFrame) parent, true);
            }             
        } else {
            dialogoPrincipal = new JDialog();    
        }
        dialogoPrincipal.setPreferredSize(new Dimension(800, 600));
        dialogoPrincipal.pack();
        dialogoPrincipal.setLocationRelativeTo(parent);
        dialogoPrincipal.setResizable(false);
        initComponentes();
        actualizarComponentes();
        dialogoPrincipal.setTitle(titulo);
        dialogoPrincipal.setVisible(true);
    }

    //Inicializa la interfaz de usuario
    private void initComponentes() {
        ///////////////////////////Botones//////////////////////////
        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        dialogoPrincipal.getContentPane().add(pnlBotonesEdicion, BorderLayout.SOUTH);

        JPanel pnlCentral = new JPanel();
        dialogoPrincipal.getContentPane().add(pnlCentral, BorderLayout.CENTER);
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
        cerrarDialogo();
    }

    //Actualiza los componentes con los datos del modelo
    private void actualizarComponentes() {
        this.txtNombre.setText(this.actividad.getPlantilla());
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
        this.actividad.setPlantilla(this.txtNombre.getText());
    }

    //Cierra el Dialogo
    private void cerrarDialogo() {
        this.dialogoPrincipal.dispose();
    }

    //Cancela, en respuesta al requerimiento del usuario
    private void cancelar() {
        cerrarDialogo();
    }

    //Irían las validaciones de los componentes, antes de pasar los valores a las 
    //propiedades de la actividad que se está editando.
    private void validarComponentes() {
    }
}
