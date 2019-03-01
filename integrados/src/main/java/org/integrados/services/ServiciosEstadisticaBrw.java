/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.services;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesBrw;

/**
 *
 * @author Yani
 */
public class ServiciosEstadisticaBrw extends JFrame {
    private JPanel pnlBotonesEdicion = null;
    private JLabel lblFondo;
    private JButton btnGrafico;
    private JButton btnVolver;
    private JTable tablaActividades = null;
    private List<RegistroActividad> listaActividades;
    private ServiciosEstadisticaCtrl controlador;

    public ServiciosEstadisticaBrw(List<RegistroActividad> listaActividades, ServiciosEstadisticaCtrl controlador) {
        this.listaActividades = listaActividades;
        this.controlador = controlador;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Lista de Actividades");
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

        JPanel pnlCentral = new JPanel();
        BorderLayout pnlCentralLayout = new BorderLayout();
        pnlCentral.setOpaque(false);
        pnlCentral.setLayout(pnlCentralLayout);
        
        lblFondo = new JLabel();        
        // Propiedades del fondo de pantalla
       // ImageIcon icon = createImageIcon("images/Fondo.jpg","Fondo");
        //lblFondo.setIcon(icon);
//        lblFondo.setBounds(0, 0, 800, 600);
        lblFondo.setLayout(new BorderLayout());   
        // Propiedades de la tabla de actividades
        tablaActividades = new JTable();
        tablaActividades.setOpaque(true);           
//        ((DefaultTableCellRenderer)tablaActividades.getDefaultRenderer(Object.class)).setOpaque(false);
        
        tablaActividades.setBackground(new java.awt.Color(250, 255, 113));
        tablaActividades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 90, 39)));
        tablaActividades.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); 
        
        tablaActividades.setAlignmentX(1.0F);
        tablaActividades.setAlignmentY(1.0F);
        tablaActividades.setGridColor(new java.awt.Color(237, 90, 39));
        tablaActividades.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaActividades.setSelectionBackground(new java.awt.Color(85, 196, 190));           
        
        JScrollPane jScrollPane = new JScrollPane(tablaActividades);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        
        tablaActividades.setModel(new ActividadTableModel(listaActividades));

        tablaActividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    //editarActividadActual();     //---------------------->llama la ventana graficar
                }
            }
        });
        pnlCentral.add(jScrollPane, BorderLayout.CENTER);
        lblFondo.add(pnlCentral, BorderLayout.CENTER);
        
        // Propiedades del botón Graficar
        btnGrafico = Util.crearBoton("Editar", 12);
        btnGrafico.setBounds(250, 7, 90, 22);
        pnlBotonesEdicion.add(btnGrafico);
        btnGrafico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
                //graficarActividadActual;
            }
        });
        
        // Propiedades del botón Volver
        btnVolver = Util.crearBoton("Volver", 12);
        btnVolver.setBounds(550, 7, 90, 22);
        pnlBotonesEdicion.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });
    }
        
    public void mostrar(){
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }
    
    public void volver() {
        this.controlador.ocultar();
        //this.controlador.docenteInicioDlg.initComponents();
    }


//Indica cuál es la actividad que está seleccionado en la JTable
    private Actividad getActividadSeleccionada() {
    	int indexSeleccionado = this.tablaActividades.getSelectedRow();
    	return ((DocenteBrowseActividadesBrw.ActividadTableModel)this.tablaActividades.getModel()).getActividad(indexSeleccionado);
    }


/**
     * Modelo de la JTable de Actividades.
     */
    public class ActividadTableModel extends AbstractTableModel {

        protected List<RegistroActividad> actividades;
        protected RegistroActividad registro;

        public ActividadTableModel(List<RegistroActividad> actividades) {
            this.actividades = actividades;
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Materia";
            } else if (column == 1) {
                return "Tema";
            } else if (column == 2) {
                return "Dificultad";
            } else if (column == 3) {
                return "Intentos";
            } else if (column == 4) {
                return "Estrellas";
            } else 
                return "Corazón";    
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class getColumnClass(int column) {
            if (column == 0) {
                return String.class;
            } else if (column == 1) {
                return String.class;
            } else if (column == 2) {
                return String.class;
            }  else if (column == 3) {
                return String.class;
            } else if (column == 4) {
                return String.class;
            } else {
                return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            RegistroActividad actividad = actividades.get(row);
            if (column == 0) {
                return actividad.getActividad().getMateria().getMateria();
            } else if (column == 1) {
                return actividad.getActividad().getTema();
            } else if (column == 2) {
                return actividad.getActividad().getDificultad();
            } else if (column == 3) {
                return actividad.getIntentos();
            } else if (column == 4) {
                return actividad.getEstrella();
            }else {
                return actividad.getCorazon();
            }
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
        }

        @Override
        public int getRowCount() {
            return actividades.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        public RegistroActividad getActividad(int index) {
            if ((index < 0) || (index > actividades.size())) {
                return null;
            } else {
                return actividades.get(index);
            }
        }
    }
}







