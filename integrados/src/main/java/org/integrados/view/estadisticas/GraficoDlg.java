/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;
import org.integrados.controller.estadisticas.GraficoCtrl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Yani
 */
public class GraficoDlg extends JFrame {

    private JLabel lblFondo;
    private JPanel pnlGrafico;
    private JPanel pnlOpciones;
    private JComboBox desplegable;
    private List<String> listaOpciones;
    private List<RegistroActividad> listaRegistro= new ArrayList<>();
    private JLabel nombreAlumno;
    private JButton btnGraficar;
    private JButton btnVolver;
    private GraficoCtrl controlador;

    public GraficoDlg(GraficoCtrl controlador, List<RegistroActividad> listaRegistro) {
        this.controlador = controlador;
        this.listaRegistro = listaRegistro;
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Grafica");
        this.pack();
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                 controlador.cerrarAplicacion();
            }
        });

        lblFondo = new JLabel();
        // Propiedades del fondo de pantalla
//        ImageIcon icon = createImageIcon("images/estadisticas/Fondo2.jpg", "Fondo");
//        lblFondo.setIcon(icon);
//        lblFondo.setBounds(0, 0, 800, 600);

        // Mostrar nombre y apellido del alumno
        this.nombreAlumno = new JLabel();
        this.nombreAlumno.setText(this.recuperarNombreAlumno(listaRegistro));
        this.nombreAlumno.setFont(new Font("Comic Sans MS", 0, 30));
        this.nombreAlumno.setForeground(Color.BLACK);
        this.nombreAlumno.setBounds(300, 5, 500, 50);   ///---------------> editar

        JPanel pnlCentral = new JPanel();
        pnlCentral.setOpaque(false);

        // PANEL DEL GRAFICO VACIO //
        pnlGrafico = new JPanel();
        pnlGrafico.setBounds(5, 100, 550, 450);
        pnlGrafico.setBorder(BorderFactory.createLineBorder(Color.black));

        // DESPLEGABLE //
        this.desplegable = new JComboBox<>();
        desplegable.setBounds(600, 220, 150, 20);
        desplegable.setFont(new java.awt.Font("Comic Sans MS", 0, 12));
        desplegable.addItem("Seleccione una opción");
        desplegable.addItem("Intentos");
        desplegable.addItem("Estrellas");

        // Propiedades del botón Graficar
        btnGraficar = new JButton();
        btnGraficar = Util.crearBoton("Graficar", 12);
        btnGraficar.setBounds(630, 250, 90, 22);
        btnGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlGrafico.removeAll();
                seleccion(listaRegistro);
            }
        });

        // Propiedades del botón Volver
        btnVolver = new JButton();
        btnVolver = Util.crearBoton("Volver", 12);
        btnVolver.setBounds(630, 500, 90, 22);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ocultar();
                controlador.getVerActividadesRealizadasDlg().mostrar();
            }
        });

        // AGREGAR COMPONENTES //
        getContentPane().add(desplegable);
        getContentPane().add(nombreAlumno);
        getContentPane().add(btnGraficar);
        getContentPane().add(btnVolver);
        getContentPane().add(pnlGrafico);
        this.add(lblFondo);
    }

    public void mostrar() {
        this.setVisible(true);
    }
    public void ocultar() {
        this.setVisible(false);
    }
    
    private void seleccion(List<RegistroActividad> listaRegistro) {
        String seleccion = desplegable.getSelectedItem().toString();
       
        if (seleccion.equals("Intentos")) {
            cargarRowIntentos(listaRegistro, "Intentos");
            
        } else if (seleccion.equals("Estrellas")) {
            cargarRowEstrellas(listaRegistro, "Estrellas");
        }
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

    private String recuperarNombreAlumno(List<RegistroActividad> registro) {
        try {
            RegistroActividad reg = registro.get(0);
            Alumno alumno = reg.getAlumno();
            return "Alumno : " + alumno.getNombre() + " " + alumno.getApellido();
        } catch (Exception e) {
            return "Error al recuperar nombre del alumno";
        }
    }

    ////////////////// GRAFICO ///////////////////////////////////
    private void panelGrafico(DefaultCategoryDataset dataset, String nom) {
        //se llama desde cargar row
        JFreeChart chart=ChartFactory.createLineChart("Estadisticas", nom,"Cantidad",dataset,PlotOrientation.VERTICAL, false, false,false); 

        ChartPanel charpanel = new ChartPanel(chart);
        charpanel.setPreferredSize(new Dimension(548, 440));
        
        pnlGrafico.add(charpanel);
        pnlGrafico.validate();
        getContentPane().add(pnlGrafico);
    }

    private void cargarRowIntentos(List<RegistroActividad> cantidadGrafico, String nom) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String dato;
        for (int i = 0; i < cantidadGrafico.size(); i++) {
            dato = toString(nom, i);
            RegistroActividad reg = cantidadGrafico.get(i);
            
            dataset.setValue(reg.getIntentos(), "", dato);
        }
        panelGrafico(dataset, nom);
    }
    
    private void cargarRowEstrellas(List<RegistroActividad> cantidadGrafico, String nom) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String dato;

        for (int i = 0; i < cantidadGrafico.size(); i++) {
            dato = toString(nom, i);
            RegistroActividad reg = cantidadGrafico.get(i);
            
            dataset.setValue(reg.getEstrella(), "", dato);
        }
        panelGrafico(dataset, nom);
    }

    private String toString(String nom, int i) {
        return "Actividad " + i++;
    }

}
