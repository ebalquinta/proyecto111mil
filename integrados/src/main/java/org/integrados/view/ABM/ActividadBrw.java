package org.integrados.view.ABM;
        
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;

/**
 *
 * @author Grupo Front
 */
public class ActividadBrw { 

    private ActividadCtrl controlador;
    private List<String> actividadesRequeridos;

    private JDialog dialogoPrincipal;

    private JPanel pnlBotonesEdicion = null;
    public JButton botonNuevo = null;
    public JButton botonEdicion = null;
    public JButton botonBorrar = null;
    public JButton botonProbar = null;
    public JButton botonVolver = null;
    private JTable tablaActividades = null;
    
    private List<ActividadABM> listaActividades;

    public ActividadBrw(ActividadCtrl controlador, List<ActividadABM> listaActividades) {
        this.controlador = controlador;
        this.listaActividades = listaActividades;
    }

    public Window getFrame() {
        return dialogoPrincipal;
    }
    
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
        dialogoPrincipal.setTitle("Lista de Actividades disponibles");

        initComponentes();
        
        dialogoPrincipal.setVisible(true);
    }

    private void initComponentes() {
        JPanel pnlCentral = new JPanel();
        BorderLayout pnlCentralLayout = new BorderLayout();
        pnlCentral.setLayout(pnlCentralLayout);
        dialogoPrincipal.getContentPane().add(pnlCentral, BorderLayout.CENTER);

        // Propiedades de la tabla de actividades
        tablaActividades = new JTable();
        tablaActividades.setBackground(new java.awt.Color(252, 241, 224));
        tablaActividades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaActividades.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); 
        
        tablaActividades.setAlignmentX(1.0F);
        tablaActividades.setAlignmentY(1.0F);
        tablaActividades.setGridColor(new java.awt.Color(255, 51, 0));
        tablaActividades.setIntercellSpacing(new java.awt.Dimension(2, 2));
        tablaActividades.setSelectionBackground(new java.awt.Color(255, 204, 0));

              
        
        pnlCentral.add(new JScrollPane(tablaActividades), BorderLayout.CENTER);
        tablaActividades.setModel(new ActividadTableModel(listaActividades));

        tablaActividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editarActividadActual();
                }
            }
        });

        pnlBotonesEdicion = new JPanel();
        pnlBotonesEdicion.setLayout(null);
        pnlBotonesEdicion.setPreferredSize(new java.awt.Dimension(300, 35));
        pnlBotonesEdicion.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        dialogoPrincipal.getContentPane().add(pnlBotonesEdicion, BorderLayout.SOUTH);

        // Propiedades del botón Nuevo
        botonNuevo = Util.crearBoton("Nuevo", 12);
        botonNuevo.setBounds(20, 7, 90, 22);
        pnlBotonesEdicion.add(botonNuevo);
        botonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaActividad();
            }
        });

        // Propiedades del botón Editar
        botonEdicion = Util.crearBoton("Editar", 12);
        botonEdicion.setBounds(120, 7, 90, 22);
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
        botonBorrar.setBounds(220, 7, 90, 22);
        pnlBotonesEdicion.add(botonBorrar);
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                borrarActividad();
            }
        });
        
        // Propiedades del botón Probar
        botonProbar = Util.crearBoton("Probar", 12);
        botonProbar.setBounds(320, 7, 90, 22);
        pnlBotonesEdicion.add(botonProbar);
        botonProbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! "); 
            }
        });
        
        // Propiedades del botón Volver
        botonVolver = Util.crearBoton("Volver", 12);
        botonVolver.setBounds(420, 7, 90, 22);
        pnlBotonesEdicion.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });
        
    }
    
    //////////////////////////////////////Nueva ActividadABM//////////////////////////////////////
    private void nuevaActividad() {
        System.out.println("nuevaActividad");
        this.controlador.agregar();
    }
    
    public void agregarATabla(ActividadABM actividadNueva) {
        ((ActividadTableModel)tablaActividades.getModel()).addActividad(actividadNueva);
    }
    ////////////////////////////////////Fin->Nueva ActividadABM///////////////////////////////////
    
    /////////////////////////////////////Editar ActividadABM//////////////////////////////////////
    private void editarActividadActual() {
        System.out.println("editarActividad");
    	ActividadABM actividad = getActividadSeleccionada();

    	if (actividad != null) {
//            this.controlador.editar(actividad);
                Dialogo.error("En construcción","¡Estamos trabajando para usted!");
    	}
    }
    
    public void actualizarATabla(ActividadABM actividadEditada) {
        ((ActividadTableModel)tablaActividades.getModel()).updateActividad(actividadEditada);
    }
    ///////////////////////////////////FIN->Editar ActividadABM///////////////////////////////////

    //////////////////////////////////////////Volver///////////////////////////////////////////
    public void volver() {
        this.controlador.volver();
    }
    ///////////////////////////////////////////FIN->Volver/////////////////////////////////////
    
    /////////////////////////////////////Borrar ActividadABM//////////////////////////////////////
    private void borrarActividad() {
        System.out.println("borrarActividad");
    	ActividadABM actividad = getActividadSeleccionada();
        
        if (actividad != null)  {
            try {        
                controlador.borrar(actividad);
                ((ActividadTableModel)tablaActividades.getModel()).removeActividad(actividad);        
            } catch (Exception e) {
                Dialogo.error("Error al borrar: ", e.getMessage());
            }
        }
    }   
    ///////////////////////////////////FIN->Borrar ActividadABM///////////////////////////////////
    
    //Indica cuál es la actividad que está seleccionado en la JTable
    private ActividadABM getActividadSeleccionada() {
    	int indexSeleccionado = this.tablaActividades.getSelectedRow();
    	return ((ActividadTableModel)this.tablaActividades.getModel()).getActividad(indexSeleccionado);
    }
    
    /**
     * Modelo de la JTable de Actividades.
     */
    public class ActividadTableModel extends AbstractTableModel {

        protected List<ActividadABM> actividades;

        public ActividadTableModel(List<ActividadABM> actividades) {
            this.actividades = actividades;
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Número";
            } else if (column == 1) {
                return "Plantilla";
            } else if (column == 2) {
                return "Docente";
            } else if (column == 3) {
                return "Materia";
            } else 
                return "Tema";    
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
            ActividadABM actividad = actividades.get(row);
            if (column == 0) {
                return actividad.getId();
            } else if (column == 1) {
                return actividad.getPlantilla();
            } else if (column == 2) {
                return actividad.getDocente();
            } else if (column == 3) {
                return actividad.getMateria();
            } else {
                return actividad.getTema();
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
            return 5;
        }

        public ActividadABM getActividad(int index) {
            if ((index < 0) || (index > actividades.size())) {
                return null;
            } else {
                return actividades.get(index);
            }
        }

        public void removeActividad(ActividadABM actividad) {
            actividades.remove(actividad);
            fireTableDataChanged();
        }

        public void addActividad(ActividadABM actividad) {
            actividades.add(actividad);
            fireTableDataChanged();
        }

        public void updateActividad(ActividadABM actividadActualizado) {
            int index = 0;
            for (ActividadABM actividad : actividades) {
                if (actividad.equals(actividadActualizado)) {
                    actividades.set(index, actividadActualizado);
                    break;
                }
                index = index + 1;
            }
        }
    }
}