/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.integrados.controller.actividades.PregRespCtrl;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.util.Util;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;

/**
 *
 * @author Jacco
 */
public class PregRespBrowse extends javax.swing.JFrame {

    private JLabel pregunta;
    private List<JCheckBox> checks;
    private JButton terminar;
    private JButton verificar;
    private PregRespCtrl controller;
    private List<Bloque> respuestas;
    private List<Bloque> opciones;
    private List<Panel> cuadroOpciones;
    private JLabel intentos;
    private JLabel bienHecho;

    /**
     * Constructor que llama al initcomponents
     *
     * @param opciones son las opciones que estan guardadas en la plantilla
     * @param pregunta pregunta guardada en plantilla
     * @param controller
     */
    public PregRespBrowse(List<Bloque> opciones, String pregunta, PregRespCtrl controller) {
        this.opciones = opciones;
        this.initComponents(pregunta);
        this.controller = controller;
        this.respuestas = new ArrayList();
        
    }

    public void initComponents(String pregunta) {
        
        //Seteo de los valores de la pregunta
        this.pregunta = new JLabel();
        this.pregunta.setText(pregunta);
        this.pregunta.setBounds(300, 100, pregunta.length() * 10, 20);
        getContentPane().add(this.pregunta);

        //Seteo Intentos
        intentos = new JLabel("Te quedan  intentos");
        intentos.setBounds(100, 50, intentos.getText().length() * 10, 20);
        add(intentos);

        //Inicializa los arrays de componentes
        this.cuadroOpciones = new ArrayList();//es una lista de paneles que contiene los diferentes bloques
        this.checks = new ArrayList();//Lista de checks
        this.setOpciones();
        
        //inicializacion del label bien hecho
        bienHecho = new JLabel("Bien hecho");
        bienHecho.setBounds(400, 150, bienHecho.getText().length() * 10, 30);
        bienHecho.setVisible(false);
        add(bienHecho);
        
        //Creacion de los botones
        JButton terminar = Util.crearBoton("terminar", 14);
        JButton verificar = Util.crearBoton("verificar", 14);
        verificar.setBounds(200, 25, 120, 20);
        
        
        
        
        
        //Agregacion del listener
        verificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Se llama el metodo interno opcionesSeleccionadas() 
                //luego se llama a el metodo verificar() en el controler con una lista de respuestas
                opcionesSeleccionadas();
                try{
                    controller.verificar(respuestas);
                }catch(IntegradosException e){
                    Dialogo.mensaje("Atencion", e.getMessage());
                }finally{
                    respuestas.removeAll(respuestas);
                }              
            }
        });
        add(terminar);
        add(verificar);

        //configuracion de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void setIntentos(int i) {
        this.intentos.setText("Te quedan " + i + " intentos");
        
    }

    /**
     * Este metodo se encarga de instanciar los paneles y los checks y
     * asignarlos a sus determinadas listas Tambien se encarga de agregar los
     * paneles al frame
     */
    public void setOpciones() {
        //Esta variable representa las coordenadas y para poder alinear correctamente los componentes
        int y = 200;
        //Se recorre la lista de opciones 
        for (Bloque b : this.opciones) {
            //Se instancia un panel por cada opcion pasandole el bloque y la coordenada "y"
            Panel panelOpcion = new Panel(b, y);

            //Se instancia un checkbox llamado opcion, se setean las coordenadas y se agrega a la lista de checks
            JCheckBox opcion = new JCheckBox();
            opcion.setBounds(200, y, 120, 20);
            this.checks.add(opcion);

            //Se añade el checkbox instanciado a el panel y se añade el panel a el frame
            panelOpcion.add(opcion);
            add(panelOpcion);
            
            //Se incrementa a la cooredenada 
            y += 50;
        }
    }

    /**
     * Este metodo se encarga de revisar la lista de checks y agregar a la lista
     * rtaAlumno los checksBox seleccionados
     */
    public void opcionesSeleccionadas() {
        for (int i = 0; i < checks.size(); i++) {
            if (checks.get(i).isSelected()) {
                respuestas.add(opciones.get(i));
            }
        }
    }

    
    public void setHecho() {
        bienHecho.setVisible(true);
    }
  
}
