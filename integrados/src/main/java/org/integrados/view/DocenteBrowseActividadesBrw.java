
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
public class DocenteBrowseActividadesBrw {

    private DocenteBrowseActividadesCtrl controlador;

    private JDialog dialogoPrincipal;

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
        this.controlador.volver();
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
            Actividad actividad = actividades.get(row);
            if (column == 0) {
                return actividad.getId();
            } else if (column == 1) {
                return actividad.getPlantilla();
            } else if (column == 2) {
                return actividad.getDocenteCreador();
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
