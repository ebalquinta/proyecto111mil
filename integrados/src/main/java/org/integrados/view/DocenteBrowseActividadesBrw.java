
package org.integrados.view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import org.integrados.controller.actividades.DocenteBrowseActividadesCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.util.Util;

/**
 *
 * @author Grupo Front
 */
public class DocenteBrowseActividadesBrw extends JFrame {
    private JLabel lblFondo;
    private DocenteBrowseActividadesCtrl controlador;
    private JPanel pnlBotonesEdicion = null;
    public JButton botonNuevo = null;
    public JButton botonEdicion = null;
    public JButton botonBorrar = null;
    public JButton botonProbar = null;
    public JButton botonVolver = null;
    private JTable tablaActividades = null;
    private List<Actividad> listaActividades;
    
    public DocenteBrowseActividadesBrw(DocenteBrowseActividadesCtrl controlador, List<Actividad> listaActividades) {
        this.controlador = controlador;
        this.listaActividades = listaActividades;
        initComponents();
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
        ImageIcon icon = createImageIcon("images/Fondo.jpg","Fondo");
        lblFondo.setIcon(icon);
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
                    editarActividadActual();
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

        // Propiedades del botón Nuevo
        botonNuevo = Util.crearBoton("Nuevo", 12);
        botonNuevo.setBounds(150, 7, 90, 22);
        pnlBotonesEdicion.add(botonNuevo);
        botonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaActividad();
            }
        });

        // Propiedades del botón Editar
        botonEdicion = Util.crearBoton("Editar", 12);
        botonEdicion.setBounds(250, 7, 90, 22);
        pnlBotonesEdicion.add(botonEdicion);
        botonEdicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
                //editarActividadActual();
            }
        });

        // Propiedades del botón Borrar
        botonBorrar = Util.crearBoton("Borrar", 12);
        botonBorrar.setBounds(350, 7, 90, 22);
        pnlBotonesEdicion.add(botonBorrar);
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                borrarActividad();
            }
        });
        
        // Propiedades del botón Probar
        botonProbar = Util.crearBoton("Probar", 12);
        botonProbar.setBounds(450, 7, 90, 22);
        pnlBotonesEdicion.add(botonProbar);
        botonProbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! "); 
            }
        });
        
        // Propiedades del botón Volver
        botonVolver = Util.crearBoton("Volver", 12);
        botonVolver.setBounds(550, 7, 90, 22);
        pnlBotonesEdicion.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
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
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    public void ocultar() {
        this.setVisible(false);
    }   
    
    //////////////////////////////////////Nueva Actividad//////////////////////////////////////
    private void nuevaActividad() {
        System.out.println("nuevaActividad");
        this.controlador.agregar();
    }
    
    public void agregarATabla(Actividad actividadNueva) {
        ((ActividadTableModel)tablaActividades.getModel()).addActividad(actividadNueva);
    }
    ////////////////////////////////////Fin->Nueva Actividad///////////////////////////////////
    
    /////////////////////////////////////Editar Actividad//////////////////////////////////////
    private void editarActividadActual() {
        System.out.println("editarActividad");
    	Actividad actividad = getActividadSeleccionada();

    	if (actividad != null) {
//            this.controlador.editar(actividad);
            Dialogo.error("En construcción","¡Estamos trabajando para usted!");
    	}
    }
    
    public void actualizarATabla(Actividad actividadEditada) {
        ((ActividadTableModel)tablaActividades.getModel()).updateActividad(actividadEditada);
    }
    ///////////////////////////////////FIN->Editar Actividad///////////////////////////////////

    //////////////////////////////////////////Volver///////////////////////////////////////////
    public void volver() {
        this.controlador.ocultar();
    }
    ///////////////////////////////////////////FIN->Volver/////////////////////////////////////
    
    /////////////////////////////////////Borrar Actividad//////////////////////////////////////
    private void borrarActividad() {
        System.out.println("borrarActividad");
    	Actividad actividad = getActividadSeleccionada();
        
        if (actividad != null)  {
            try {        
                controlador.borrar(actividad);
                ((ActividadTableModel)tablaActividades.getModel()).removeActividad(actividad);        
            } catch (Exception e) {
                Dialogo.error("Error al borrar: ", e.getMessage());
            }
        }
    }   
    ///////////////////////////////////FIN->Borrar Actividad///////////////////////////////////
    
    //Indica cuál es la actividad que está seleccionado en la JTable
    private Actividad getActividadSeleccionada() {
    	int indexSeleccionado = this.tablaActividades.getSelectedRow();
    	return ((ActividadTableModel)this.tablaActividades.getModel()).getActividad(indexSeleccionado);
    }
    
    /**
     * Modelo de la JTable de Actividades.
     */
    public class ActividadTableModel extends AbstractTableModel {

        protected List<Actividad> actividades;

        public ActividadTableModel(List<Actividad> actividades) {
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
            } else 
                return "Enunciado";    
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
            } else if (column == 5) {
                return String.class;
            } else {
                return String.class;
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            Actividad actividad = actividades.get(row);
            if (column == 0) {
                return actividad.getMateria().getMateria();
            } else if (column == 1) {
                return actividad.getTema();
            } else if (column == 2) {
                return actividad.getGrado();
            } else if (column == 3) {
                return actividad.getNivel();
            } else if (column == 4) {
                return actividad.getDificultad();
            } else if (column == 5) {
                return actividad.getPlantilla().verNombrePlantilla();
            } else {
                return actividad.getPlantilla().getEnunciado();
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

        public Actividad getActividad(int index) {
            if ((index < 0) || (index > actividades.size())) {
                return null;
            } else {
                return actividades.get(index);
            }
        }

        public void removeActividad(Actividad actividad) {
            actividades.remove(actividad);
            fireTableDataChanged();
        }

        public void addActividad(Actividad actividad) {
            actividades.add(actividad);
            fireTableDataChanged();
        }

        public void updateActividad(Actividad actividadActualizado) {
            int index = 0;
            for (Actividad actividad : actividades) {
                if (actividad.equals(actividadActualizado)) {
                    actividades.set(index, actividadActualizado);
                    break;
                }
                index = index + 1;
            }
        }
    }    
    
}
