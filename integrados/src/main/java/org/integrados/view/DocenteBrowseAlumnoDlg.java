/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view;

import org.integrados.controller.estadisticas.DocenteBrowseAlumnoCtrl;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;
import org.integrados.controller.estadisticas.VerActividadesSinRealizarCtrl;
import org.integrados.controller.estadisticas.VerActividadesRealizadasCtrl;

/**
 *
 * @author Yani
 */
public class DocenteBrowseAlumnoDlg extends JFrame {

    private final DocenteBrowseAlumnoCtrl controlador;
    private List<Alumno> listaAlumnos = new ArrayList<>();
    private JLabel lblFondo;
    private JPanel pnlBotonesEdicion = null;
    public JButton btnDatos = null;
    public JButton btnRealizadas = null;
    public JButton btnSinRealizar = null;
    public JButton btnVolver = null;
    private JTable tablaAlumnos = null;
    DocenteBrowseAlumnoDlg aux = this;

    public DocenteBrowseAlumnoDlg(DocenteBrowseAlumnoCtrl controlador, List<Alumno> listaAlumnos) {
        this.controlador = controlador;
        this.listaAlumnos = listaAlumnos;
        initComponent();
    }
    
    public DocenteBrowseAlumnoCtrl getControlador() {
        return controlador;
    }

    private void initComponent() {
        this.setTitle("Lista de Alumnos");
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
        ImageIcon icon = createImageIcon("images/Fondo.jpg", "Fondo");
        lblFondo.setIcon(icon);
//        lblFondo.setBounds(0, 0, 800, 600);
        lblFondo.setLayout(new BorderLayout());

        // Propiedades de la tabla de alumnos
        tablaAlumnos = new JTable();
        tablaAlumnos.setOpaque(true);

        tablaAlumnos.setBackground(new java.awt.Color(250, 255, 113));
        tablaAlumnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(237, 90, 39)));
        tablaAlumnos.setFont(new java.awt.Font("Comic Sans MS", 0, 12));

        tablaAlumnos.setAlignmentX(1.0F);
        tablaAlumnos.setAlignmentY(1.0F);
        tablaAlumnos.setGridColor(new java.awt.Color(237, 90, 39));
        tablaAlumnos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaAlumnos.setSelectionBackground(new java.awt.Color(85, 196, 190));

        JScrollPane jScrollPane = new JScrollPane(tablaAlumnos);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);

        tablaAlumnos.setModel(new AlumnosTableModel(listaAlumnos));

        tablaAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    verDatosAlumnoActual();
                }
            }
        });
        pnlCentral.add(jScrollPane, BorderLayout.CENTER);
        lblFondo.add(pnlCentral, BorderLayout.CENTER);

        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setOpaque(false);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

        // Propiedades del botón Volver
        btnVolver = Util.crearBoton("Volver", 12);
        btnVolver.setBounds(650, 7, 90, 22);
        pnlBotonesEdicion.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });

        // Propiedades del botón datos personales
        btnDatos = Util.crearBoton("Datos Personales", 12);
        btnDatos.setBounds(40, 7, 120, 22);
        pnlBotonesEdicion.add(btnDatos);
        btnDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                verDatosAlumnoActual();
                //ventana datos personales del alumno..  solo mostrar. (se puede incluir un boton "observaciones" que lleva a la ventana ObservarAlumnoDlg)

                //ocultar();
            }
        });

        // Propiedades del botón Actividades realizadas. Lleva a la ventana estadisticas del alumno
        btnRealizadas = Util.crearBoton("Ver Actividades Realizadas", 12);
        btnRealizadas.setBounds(200, 7, 180, 22);
        pnlBotonesEdicion.add(btnRealizadas);
        btnRealizadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Alumno alumno = getAlumnoSeleccionado();
                if (alumno != null) {
                    if (controlador.cantRealizadas(alumno) <= 0) {  //revisar forma de comprobar si el alumno posee actividades realizadas
                        Dialogo.mensaje("¡Atención! ", "El Alumno no posee actividades realizadas");                        
                    } else {
                        VerActividadesRealizadasCtrl actividadesRealizadas = new VerActividadesRealizadasCtrl(alumno, aux);
                        actividadesRealizadas.mostrarBrw();
                        ocultar();
                    }
                } else {
                    Dialogo.mensaje("¡Atención! ", " Debe seleccionar un alumno para realizar esta opción");
                }
            }
        });

        // Propiedades del botón Actividades sin realizar
        btnSinRealizar = Util.crearBoton("Ver Actividades Sin Realizar", 12);
        btnSinRealizar.setBounds(390, 7, 200, 22);
        pnlBotonesEdicion.add(btnSinRealizar);
        btnSinRealizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Alumno alumno = getAlumnoSeleccionado();
                if (alumno != null) {
                    VerActividadesSinRealizarCtrl actividadesSinRealizar = new VerActividadesSinRealizarCtrl(alumno, aux);
                    actividadesSinRealizar.mostrarBrw();
                    ocultar();
                } else {
                    Dialogo.mensaje("¡Atención! ", " Debe seleccionar un alumno para realizar esta opción");
                }
            }
        });

        getContentPane().add(pnlBotonesEdicion, BorderLayout.SOUTH);

        this.add(lblFondo);

        this.mostrar();
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

    public void volver() {
        this.controlador.ocultar();
        this.controlador.docenteInicioDlg.initComponents();
    }

    private void verDatosAlumnoActual() {
        Alumno alumno = getAlumnoSeleccionado();
        if (alumno != null) {
            DatosAlumnoDlg datosAlumnoDlg = new DatosAlumnoDlg(this, alumno);
            datosAlumnoDlg.mostrar();
        } else {
            Dialogo.mensaje("¡Atención! ", " Debe seleccionar un alumno para realizar esta opción");
        }
    }

    private Alumno getAlumnoSeleccionado() {
        int indexSeleccionado = this.tablaAlumnos.getSelectedRow();
        return ((AlumnosTableModel) this.tablaAlumnos.getModel()).getAlumno(indexSeleccionado);
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }

    /**
     * Modelo de la JTable de Actividades.
     */
    public class AlumnosTableModel extends AbstractTableModel {

        protected List<Alumno> alumnos;

        public AlumnosTableModel(List<Alumno> alumnos) {
            this.alumnos = alumnos;
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Nombre";
            } else if (column == 1) {
                return "Apellido";
            } else if (column == 2) {
                return "Cant. Actividades Realizadas";
            } else {
                return "Cant. Actividades Sin Realizar";
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
            } else {
                return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            Alumno alumno = alumnos.get(row);
            if (column == 0) {
                return alumno.getNombre();
            } else if (column == 1) {
                return alumno.getApellido();
            } else if (column == 2) {
                return controlador.cantRealizadas(alumno);
            } else {
                return controlador.cantNoRealizadas(alumno);
            }
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
        }

        @Override
        public int getRowCount() {
            return alumnos.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        public Alumno getAlumno(int index) {
            if ((index < 0) || (index > alumnos.size())) {
                return null;
            } else {
                return alumnos.get(index);
            }
        }
    }
}
