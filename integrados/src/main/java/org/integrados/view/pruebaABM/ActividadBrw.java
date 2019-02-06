package org.integrados.view.pruebaABM;
        
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
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
    
    private List<Actividad> listaActividades;

    public ActividadBrw(ActividadCtrl controlador, List<Actividad> listaActividades) {
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

        tablaActividades = new JTable();
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

        botonNuevo = new JButton();
        botonNuevo.setText("Nuevo");
        botonNuevo.setBounds(20, 7, 90, 22);
        pnlBotonesEdicion.add(botonNuevo);
        botonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nuevaActividad();
            }
        });

        botonEdicion = new JButton();
        botonEdicion.setText("Editar");
        botonEdicion.setBounds(120, 7, 90, 22);
        pnlBotonesEdicion.add(botonEdicion);
        botonEdicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                editarActividadActual();
            }
        });

        botonBorrar = new JButton();
        botonBorrar.setText("Borrar");
        botonBorrar.setBounds(220, 7, 90, 22);
        pnlBotonesEdicion.add(botonBorrar);
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                borrarActividad();
            }
        });
        
        botonProbar = new JButton();
        botonProbar.setText("Probar");
        botonProbar.setBounds(320, 7, 90, 22);
        pnlBotonesEdicion.add(botonProbar);
        botonProbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! "); 
            }
        });
        
        botonVolver = new JButton();
        botonVolver.setText("Volver");
        botonVolver.setBounds(420, 7, 90, 22);
        pnlBotonesEdicion.add(botonVolver);
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
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
            this.controlador.editar(actividad);
    	}
    }
    
    public void actualizarATabla(Actividad actividadEditada) {
        ((ActividadTableModel)tablaActividades.getModel()).updateActividad(actividadEditada);
    }
    ///////////////////////////////////FIN->Editar Actividad///////////////////////////////////

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
                return Integer.class;
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
            Actividad actividad = actividades.get(row);
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