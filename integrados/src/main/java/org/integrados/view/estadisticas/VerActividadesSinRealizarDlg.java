/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;

import org.integrados.controller.estadisticas.VerActividadesSinRealizarCtrl;
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
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;

/**
 *
 * @author Yani
 */
public class VerActividadesSinRealizarDlg extends JFrame {

    private List<RegistroActividad> listaActividades;
    private VerActividadesSinRealizarCtrl controlador;
    private JButton btnVolver;
    private JButton btnEliminar;
    private JButton btnAgregarActividad;
    private JPanel pnlBotonesEdicion = null;
    private JLabel lblFondo;
    private JLabel nombreAlumno;
    private JTable tablaActividades = null;

    public VerActividadesSinRealizarDlg(VerActividadesSinRealizarCtrl ctrl, List<RegistroActividad> listaARecuperar) {
        this.listaActividades = listaARecuperar;
        this.controlador = ctrl;
        initComponent();
    }

    private void initComponent() {
        this.setTitle("Lista de Actividades Sin Realizar");
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
        this.nombreAlumno.setBackground(new Color(0,0,0,0));
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

        pnlCentral.add(jScrollPane, BorderLayout.CENTER);
        lblFondo.add(pnlCentral, BorderLayout.CENTER);

        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setOpaque(false);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));

        // Propiedades del botón Eliminar
        btnEliminar = Util.crearBoton("Eliminar", 12);
        btnEliminar.setBounds(190, 7, 90, 22);
        pnlBotonesEdicion.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                RegistroActividad actividad = getActividadSeleccionada();
                if (actividad != null) {                
                    borrarActividadAsignada(actividad);
                } else {
                    Dialogo.mensaje("¡Atención! ", " Debe seleccionar una actividad para realizar esta opción");
                }
            }
        });
        
        // Propiedades del botón asignar Actividades
        btnAgregarActividad = Util.crearBoton("Asignar Actividades", 12);
        btnAgregarActividad.setBounds(50, 7, 130, 22);
        pnlBotonesEdicion.add(btnAgregarActividad);
        btnAgregarActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
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
        lblFondo.add(this.nombreAlumno, BorderLayout.NORTH);  //panel para mostrar nombre del alumno

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

    private String recuperarNombreAlumno(List<RegistroActividad> registro) {
        try {
            RegistroActividad reg = registro.get(1);
            Alumno alumno = reg.getAlumno();
            return "Alumno : " + alumno.getNombre() + " " + alumno.getApellido();
        } catch (Exception e) {
            return "El Alumno: " + " No posee actividades";
        }
    }

    //Indica cuál es la actividad que está seleccionado en la JTable
    private RegistroActividad getActividadSeleccionada() {
        int indexSeleccionado = this.tablaActividades.getSelectedRow();
        return ((ActividadTableModel) this.tablaActividades.getModel()).getActividad(indexSeleccionado);
    }
    
    /////////////////////////////////////Borrar RegistroActividad//////////////////////////////////////
    private void borrarActividadAsignada(RegistroActividad actividad) {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea eliminar esta actividad para este alumno?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            System.out.println("borrarActividadAsignada");
            try {        
                controlador.borrar(actividad);   //eliminar de la lista del alumno
                ((ActividadTableModel)tablaActividades.getModel()).removeActividad(actividad);        
            } catch (Exception e) {
                Dialogo.error("Error al borrar: ", e.getMessage());
            }
        }
    }   
    ///////////////////////////////////FIN->Borrar RegistroActividad///////////////////////////////////
    

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }

    public void volver() {
        // this.controlador.ventanaAnterior();
        this.ocultar();
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
                return "Grado";
            } else if (column == 3) {
                return "Nivel";
            } else if (column == 4) {
                return "Dificultad";
            } else if (column == 5) {
                return "Tipo";
            } else {
                return "Enunciado";
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
            } else if (column == 5) {
                return String.class;
            } else {
                return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            RegistroActividad registro = actividades.get(row);
            if (column == 0) {
                return registro.getActividad().getMateria().getMateria();
            } else if (column == 1) {
                return registro.getActividad().getTema();
            } else if (column == 2) {
                return registro.getActividad().getGrado();
            } else if (column == 3) {
                return registro.getActividad().getNivel();
            } else if (column == 4) {
                return registro.getActividad().getDificultad();
            } else if (column == 5) {
                return registro.getActividad().getPlantilla().getTipoPlantilla();
            } else {
                return registro.getActividad().getPlantilla().getEnunciado();
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

        public void removeActividad(RegistroActividad actividad) {
            actividades.remove(actividad);
            fireTableDataChanged();
        }

        public void addActividad(RegistroActividad actividad) {
            actividades.add(actividad);
            fireTableDataChanged();
        }

    }
}
