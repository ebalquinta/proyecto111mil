package org.integrados.view.estadisticas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.table.DefaultTableModel;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.ABM.RegistroActividadABM;
import org.integrados.controller.estadisticas.AsignarActividadesCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.RegistroActividad;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.util.Util;
import org.integrados.view.Dialogo;

public class AsignarActividadesDlg extends JFrame {

    private RegistroActividadABM registroABM = new RegistroActividadABM();
    private PersonaABM personaABM = new PersonaABM();
    private AsignarActividadesCtrl controlador;
    private List<Alumno> listaAlumnos;
    private final Docente docenteInicio;
    private final Actividad actividad;
    public boolean altaReg = false;

    private JLabel lblFondo;
    private JTable tablaRespuestas = null;
    private JScrollPane scroll = null;
    private JPanel panelTabla = new JPanel();

    private JButton btnAceptar = null;
    private JButton btnCancelar = null;

    public AsignarActividadesDlg(Docente d, Actividad a) {
        docenteInicio = d;
        actividad = a;
        initComponent();
    }

    private void initComponent() {
        this.pack();
        this.setTitle("Asignar Actividad");
        this.setSize(460, 280);
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

        // Creando panel general y aplicando fondo        
        lblFondo = new JLabel();
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N

        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/Fondo2.jpg","Fondo");
        lblFondo.setIcon(icon);
        
        lblFondo.setBounds(0, 0, 460, 280);

        JLabel lblEnunciado = Util.crearLabel("Seleccione a que alumno/s desea asignar la nueva actividad", 1, 14);
        lblEnunciado.setBounds(20, 20, 450, 30);

        // Creando tabla de alumnos
        tablaRespuestas = new JTable();
        tablaRespuestas.setBorder(BorderFactory.createCompoundBorder());
        tablaRespuestas.setFont(new Font("Comic Sans MS", 0, 13));
        tablaRespuestas.setModel(new DefaultTableModel(filasSegunTabla(docenteInicio.getId()),
                new String[]{
                    "Nombre", "Apellido", "Grado", "División", " Nivel", "Asignar"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class<?> getColumnClass(int column) {
                return types[column];
            }

        });
        tablaRespuestas.setAutoResizeMode(JTable.WIDTH);
        tablaRespuestas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tablaRespuestas.setFocusCycleRoot(true);
        tablaRespuestas.setGridColor(new Color(0, 102, 102));

        scroll = new JScrollPane(tablaRespuestas);
        scroll.createVerticalScrollBar();
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setVisible(true);
        scroll.setViewportView(tablaRespuestas);
        scroll.setPreferredSize(new Dimension(450, 100));
        scroll.getPreferredSize();

        panelTabla.setSize(scroll.getPreferredSize());
        panelTabla.setLocation(0, 60);
        panelTabla.add(scroll);

        // Propiedades del botón aceptar
        btnAceptar = Util.crearBoton("Aceptar", 14);
        btnAceptar.setBounds(70, 200, 130, 30);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                consultaAceptar();
            }
        });

        // Propiedades del botón cancelar
        btnCancelar = Util.crearBoton("Cancelar", 14);
        btnCancelar.setBounds(270, 200, 130, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //sigue curso de ejecucion sin asignar la actividad
            }
        });

//agagregar a la ventana
        getContentPane().add(lblEnunciado);
        getContentPane().add(btnAceptar);
        getContentPane().add(btnCancelar);
        getContentPane().add(panelTabla);
        this.add(lblFondo);
    } // FIN INITCOMPONENT//

    /**
     * Metodo de boton aceptar: consulta si esta seguro de guardar la seleccion realizada.
     * si = guarda el registro actividad, no= vuelve a la ventana asignar
     */
    private void consultaAceptar() {
        if (Dialogo.confirmacion("Confirmacion", "¿Esta seguro que desea realizar esta operación?") == Dialogo.ResultadoDialogo.Yes) {
            boolean[] booleans = cargarAsignaciones();
            guardarRegistro(booleans);            
            ocultar();
            altaReg = true;
        }
    }

    /**
     * Devuelve matriz object cargada con lista de alumnos del docente
     *
     * llama a metodo devolverFila(alumno)
     *
     * @param id docente
     * @return
     */
    public Object[][] filasSegunTabla(int id) {

        listaAlumnos = personaABM.listaAlumnos(docenteInicio.getId());
        Object[][] matrizObjetos = new Object[listaAlumnos.size()][6];
        int colum = 0;

        for (int f = 0; f < listaAlumnos.size(); f++) {

            Alumno alumno = listaAlumnos.get(f);
            matrizObjetos[f][0] = alumno.getNombre();
            matrizObjetos[f][1] = alumno.getApellido();
            matrizObjetos[f][2] = alumno.getGrado().toString();
            matrizObjetos[f][3] = alumno.getDivision();
            matrizObjetos[f][4] = alumno.getNivel().toString();
            matrizObjetos[f][5] = false;
        }
        return matrizObjetos;
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

    /**
     * Guarda la/s selecion/es de alumnos realiazada por el docente luego de crear la actividad
     * @return boolean[]
     */
    private boolean[] cargarAsignaciones() {
        boolean[] asignaciones = new boolean[listaAlumnos.size()];

        for (int i = 0; i < asignaciones.length; i++) {
            boolean dato = (boolean) tablaRespuestas.getValueAt(i, 5);
            asignaciones[i] = dato;
        }

        return asignaciones;
    }

    /**
     * Guarda el registro actividad incorporando los atributos not null (actividad, alumno, docente)
     * @param asignacion
     */
    public void guardarRegistro(boolean[] asignacion) {

        List<Alumno> listaAlumnos = personaABM.listaAlumnos(docenteInicio.getId());

        for (int i = 0; i < asignacion.length; i++) {

            if (asignacion[i]) {
                RegistroActividad nuevoRegistro = new RegistroActividad();
                nuevoRegistro.setActividad(actividad);
                nuevoRegistro.setAlumno(listaAlumnos.get(i));
                nuevoRegistro.setDocente(docenteInicio);

                registroABM.guardar(nuevoRegistro);
            }
        }
    }

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }

}
