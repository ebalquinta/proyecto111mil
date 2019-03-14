/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;
import org.integrados.controller.estadisticas.GraficoCtrl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.netbeans.lib.awtextra.*;

/**
 *
 * @author Yani
 */
public class GraficoDlg extends JFrame {

    private JLabel lblFondo;
    private JPanel pnlGrafico;
    private JComboBox desplegable;
    private List<RegistroActividad> listaRegistro = new ArrayList<>();
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

        // Mostrar nombre y apellido del alumno
        String nombre = this.recuperarNombreAlumno(listaRegistro);
        this.nombreAlumno = Util.crearTitulo(nombre, 1, 32);     
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
        
        lblFondo = new JLabel();
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("../images/Fondo2.jpg", "Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);
        
        // Propiedades de Título
        
        // PANEL DEL GRAFICO VACIO //
        pnlGrafico = new JPanel();
        pnlGrafico.setBorder(BorderFactory.createLineBorder(Color.black));

        // DESPLEGABLE //
        this.desplegable = Util.crearCombo(new String[] {"Seleccionar", "Intentos", "Estrellas"});

        // Propiedades del botón Graficar
        btnGraficar = Util.crearBoton("Graficar", 12);
        btnGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                pnlGrafico.removeAll();
                seleccion(listaRegistro);
            }
        });

        // Propiedades del botón Volver
        btnVolver = Util.crearBoton("Volver", 12);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ocultar();
                controlador.getVerActividadesRealizadasDlg().mostrar();
            }
        });
        
        
        
        getContentPane().setLayout(new AbsoluteLayout());
        getContentPane().add(nombreAlumno, new AbsoluteConstraints(40, 20, 720, 40));
        getContentPane().add(pnlGrafico, new AbsoluteConstraints(60, 70, 540, 450));
        getContentPane().add(desplegable, new AbsoluteConstraints(610, 150, 120, 30));
        getContentPane().add(btnGraficar, new AbsoluteConstraints(625, 200, 90, 30));
        getContentPane().add(btnVolver, new AbsoluteConstraints(625, 490, 90, 30));
        
        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 600));
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
        charpanel.setPreferredSize(new Dimension(500, 410));
        
        pnlGrafico.add(charpanel);
        pnlGrafico.validate();
        getContentPane().add(pnlGrafico, new AbsoluteConstraints(60, 70, 540, 450));
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
