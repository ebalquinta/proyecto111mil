/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;

import org.integrados.controller.estadisticas.VerActividadesRealizadasCtrl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;
import org.integrados.view.DocenteBrowseActividadesDlg;
import org.integrados.controller.estadisticas.GraficoCtrl;

public class VerActividadesRealizadasDlg extends JFrame {

    private JPanel pnlBotonesEdicion = null;
    private JLabel lblFondo;
    private JLabel nombreAlumno;
    private JButton btnGrafico;
    private JButton btnVolver;
    private JTable tablaActividades = null;
    private List<RegistroActividad> listaActividades;
    private VerActividadesRealizadasCtrl controlador;
    private boolean actividadesDisponibles=true;

    public VerActividadesRealizadasDlg(VerActividadesRealizadasCtrl controlador, List<RegistroActividad> listaActividades) {
        this.listaActividades = listaActividades;
        this.controlador = controlador;

        this.initComponents();
    }

    private void initComponents() {
        this.setTitle("Lista de Actividades Realizadas");
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

        // Mostrar nombre y apellido del alumno
        String nombre = this.recuperarNombreAlumno(listaActividades);
        this.nombreAlumno = Util.crearTitulo(nombre, 1, 32);
        this.nombreAlumno.setOpaque(false);
        this.nombreAlumno.setForeground(Color.BLACK);
        this.nombreAlumno.setBounds(40, 50, 720, 40);

        lblFondo = new JLabel();

        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("../images/Fondo.jpg", "Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);
        lblFondo.setLayout(new BorderLayout());

        // Propiedades de la tabla de actividades
        tablaActividades = new JTable();
        tablaActividades.setOpaque(true);

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

        if (tablaActividades != null) {
            pnlCentral.add(jScrollPane, BorderLayout.CENTER);
        }

        lblFondo.add(pnlCentral, BorderLayout.CENTER);

        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setOpaque(false);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

        // Propiedades del botón Graficar
        btnGrafico = Util.crearBoton("Graficar", 12);
        btnGrafico.setBounds(50, 7, 90, 22);
        pnlBotonesEdicion.add(btnGrafico);  
        VerActividadesRealizadasDlg aux = this;
        btnGrafico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               if (actividadesDisponibles){
                    GraficoCtrl graf = new GraficoCtrl(listaActividades, aux);
                    graf.mostrarBrw();
                    ocultar();
                } else{
                    Dialogo.mensaje("¡Atencion! ", "El alumno no posee datos graficables");
                }
            }
        });

        // Propiedades del botón Volver
        btnVolver = Util.crearBoton("Volver", 12);
        btnVolver.setBounds(650, 7, 90, 22);
        pnlBotonesEdicion.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ocultar();
                controlador.getDocenteBrowseAlumnoDlg().mostrar();
            }
        });

        getContentPane().add(pnlBotonesEdicion, BorderLayout.SOUTH);
        lblFondo.add(this.nombreAlumno, BorderLayout.NORTH);  

        this.add(lblFondo);

        this.mostrar();
    }    /////////////////////////FIN INITCOMPONENT//////////////

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
            actividadesDisponibles = true;
            return "Alumno : " + alumno.getNombre() + " " + alumno.getApellido();
        } catch (Exception e) {
            actividadesDisponibles = false;
            return "El Alumno: " + " No posee actividades realizadas";
        }
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }

//Indica cuál es la actividad que está seleccionado en la JTable
    private Actividad getActividadSeleccionada() {
        int indexSeleccionado = this.tablaActividades.getSelectedRow();
        return ((DocenteBrowseActividadesDlg.ActividadTableModel) this.tablaActividades.getModel()).getActividad(indexSeleccionado);
    }

    /**
     * Modelo de la JTable de Actividades.
     */
    public class ActividadTableModel extends AbstractTableModel {

        protected List<RegistroActividad> actividades;

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
            } else {
                return "Corazón";
            }
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
            } else if (column == 3) {
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
            } else {
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
            return 6;
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
