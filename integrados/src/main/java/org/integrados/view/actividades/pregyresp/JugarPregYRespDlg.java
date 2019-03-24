package org.integrados.view.actividades.pregyresp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import org.integrados.controller.actividades.JugarPregYRespCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.util.Util;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * @author Jacco y Mariela
 */
public class JugarPregYRespDlg extends JFrame {

    private JLabel lblFondo;
    private JLabel lblPregunta;
    private JLabel lblIntentos;
    private JLabel lblBienHecho;
    private JButton btnSalir;
    private JButton btnEnviar;
    private JugarPregYRespCtrl controller;
    private List<JCheckBox> checks;
    private List<Bloque> respuestas;
    private List<Bloque> opciones;
    private List<Panel> cuadroOpciones;

    /**
     * Constructor que llama al initcomponents
     *
     * @param opciones son las opciones que estan guardadas en la plantilla
     * @param pregunta pregunta guardada en plantilla
     * @param controller
     */
    public JugarPregYRespDlg(List<Bloque> opciones, String pregunta, JugarPregYRespCtrl controller) {
        this.opciones = opciones;
        this.initComponents(pregunta);
        this.controller = controller;
        respuestas = new ArrayList();
    }

    public void initComponents(String pregunta) {

        //configuracion de la ventana   
        this.setTitle("Realizar Actividad - Pregunta y Respuestas");
        this.pack();
        this.setSize(800, 600);
        this.setBackground(new Color(0, 102, 102));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                controller.cerrarAplicacion();
            }
        });           
        
        lblFondo = new JLabel();   
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("../../images/Fondo2.jpg","Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);
        
        //Seteo de los valores de la pregunta
        lblPregunta = Util.crearLabel(pregunta, 0, 14);
//        lblPregunta.setBounds(300, 100, pregunta.length() * 10, 20);

        //Seteo Intentos
        lblIntentos = Util.crearLabel("Te quedan  intentos", 0, 14);
//        lblIntentos.setBounds(100, 50, lblIntentos.getText().length() * 10, 20);

        //Inicializa los arrays de componentes
        cuadroOpciones = new ArrayList();//es una lista de paneles que contiene los diferentes bloques
        checks = new ArrayList();//Lista de checks
        initOpciones();

        //inicializacion del label bien hecho
        lblBienHecho = Util.crearLabel("Bien hecho!", 1, 20);
//        lblBienHecho.setBounds(400, 150, lblBienHecho.getText().length() * 10, 30);
        lblBienHecho.setVisible(false);

        //Creacion de los botones
        btnSalir = Util.crearBoton("Salir", 14);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                controller.getDocenteBrowseActividadesBrw().mostrar();
            }
        });
        btnEnviar = Util.crearBoton("Enviar", 14);

        //Agregacion del listener
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Se llama el metodo interno opcionesSeleccionadas() 
                //luego se llama a el metodo verificar() en el controler con una lista de respuestas
                opcionesSeleccionadas();
                try {
                    controller.verificar(respuestas);
                } catch (IntegradosException e) {
                    Dialogo.mensaje("Atención", e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    respuestas.clear();
                }
            }
        });
        
        
        // Agregando elementos a la ventana
        getContentPane().setLayout(new AbsoluteLayout());
        getContentPane().add(lblPregunta, new AbsoluteConstraints(70, 10, 330, 180)); 
        getContentPane().add(lblIntentos, new AbsoluteConstraints(400, 20, 330, 50)); 
        getContentPane().add(lblBienHecho, new AbsoluteConstraints(400, 100, 330, 50));         
        getContentPane().add(btnEnviar, new AbsoluteConstraints(500, 480, 90, 60));
        getContentPane().add(btnSalir, new AbsoluteConstraints(600, 480, 90, 60));  
        
        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 600));
        pack();
    }

    public void setIntentos(int i) {
        lblIntentos.setText("Te quedan " + i + " intentos");
    }

    /**
     * Este metodo se encarga de instanciar los paneles y los checks y
     * asignarlos a sus determinadas listas Tambien se encarga de agregar los
     * paneles al frame
     */
    public void initOpciones() {
        //Esta variable representa las coordenadas y para poder alinear correctamente los componentes
        int y = 200;
        //Se recorre la lista de opciones 
        for (Bloque b : opciones) {
            //Se instancia un panel por cada opcion pasandole el bloque y la coordenada "y"
            Panel panelOpcion = new Panel(b, y);

            //Se instancia un checkbox llamado opcion, se setean las coordenadas y se agrega a la lista de checks
            JCheckBox opcion = new JCheckBox();
            opcion.setBounds(70, y, 330, 40);
            opcion.setOpaque(false);
            opcion.setHorizontalTextPosition(JCheckBox.RIGHT);
            checks.add(opcion);

            //Se añade el checkbox instanciado a el panel y se añade el panel a el frame
            panelOpcion.add(opcion);
            panelOpcion.setBounds(70, y, 330, 40);
            panelOpcion.setOpaque(false);
            getContentPane().add(panelOpcion);

            //Se incrementa a la cooredenada 
            y += 50;
        }
    }

    public List<Bloque> getOpciones() {
        return this.opciones;
    }

    public void setOpciones(List<Bloque> opciones) {
        this.opciones = opciones;
    }

    /**
     * Este metodo se encarga de revisar la lista de checks y agregar a la lista
     * rtaAlumno los checksBox seleccionados
     */
    public void opcionesSeleccionadas() {
        for (int i = 0; i < this.checks.size(); i++) {
            if (this.checks.get(i).isSelected()) {
                this.respuestas.add(this.opciones.get(i));
            }
        }
    }

    public void setHecho() {
        lblBienHecho.setVisible(true);
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
