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
    private List<Actividad> listaActividades;
    private final Docente docenteInicio;
    private final Alumno alumno;
    public boolean altaReg = false;

    private JLabel lblFondo = null;
    private JLabel lblTitulo = null;
    private JLabel lblSubTitulo = null;
    private JTable tablaRespuestas = null;
    private JScrollPane scroll = null;
    private JPanel panelTabla = new JPanel();

    private JButton btnAceptar = null;
    private JButton btnCancelar = null;

    public AsignarActividadesDlg(Docente d, Alumno a, AsignarActividadesCtrl controlador) {
        docenteInicio = d;
        alumno = a;
        this.controlador = controlador;
        initComponent();
    }

    private void initComponent() {
        this.pack();
        this.setTitle("Asignar Actividad/es");
        this.setSize(400, 300);
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
        ImageIcon icon = createImageIcon("../images/FondoChico.jpg", "Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 400, 300);

        lblTitulo = Util.crearLabel("Asignar Actividad/es al alumno: " + alumno.getNombre() + " " + alumno.getApellido(), 0, 18); ///pasar nombre alumno
        lblTitulo.setBounds(80, 10, 300, 20);
        lblSubTitulo = Util.crearLabel("(Seleccione que actividad desea asignar)", 0, 14);
        lblSubTitulo.setBounds(60, 30, 290, 20);

        // Creando tabla de alumnos
        tablaRespuestas = new JTable();
        tablaRespuestas.setOpaque(true);
        tablaRespuestas.setBackground(new Color(250, 255, 113));
        tablaRespuestas.setBorder(BorderFactory.createLineBorder(new Color(237, 90, 39)));
        tablaRespuestas.setFont(new Font("Comic Sans MS", 0, 12));
        tablaRespuestas.setAlignmentX(1.0F);
        tablaRespuestas.setAlignmentY(1.0F);
        tablaRespuestas.setGridColor(new Color(237, 90, 39));
        tablaRespuestas.setIntercellSpacing(new Dimension(0, 0));
        tablaRespuestas.setSelectionBackground(new Color(85, 196, 190));

        tablaRespuestas.setModel(new DefaultTableModel(filasSegunTabla(docenteInicio.getId()),
                new String[]{
                    "Materia", "Tema", "Grado", "Nivel", "Dificultad", "Max Intentos", "Asignar"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class<?> getColumnClass(int column) {
                return types[column];
            }

        });

        scroll = new JScrollPane(tablaRespuestas);
        scroll.createVerticalScrollBar();
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setVisible(true);
        scroll.setViewportView(tablaRespuestas);
        scroll.setPreferredSize(new Dimension(400, 150));
        scroll.getPreferredSize();

        panelTabla.setOpaque(false);
        panelTabla.setSize(scroll.getPreferredSize());
        panelTabla.setLocation(0, 60);
        panelTabla.add(scroll);

        // Propiedades del botón aceptar
        btnAceptar = Util.crearBoton("Aceptar", 14);
        btnAceptar.setBounds(110, 240, 80, 30);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                consultaAceptar();
            }
        });

        // Propiedades del botón cancelar
        btnCancelar = Util.crearBoton("Cancelar", 14);
        btnCancelar.setBounds(220, 240, 80, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //sigue curso de ejecucion sin asignar la actividad
                ocultar();
            }
        });

        //agagregar a la ventana
        getContentPane().add(lblTitulo);
        getContentPane().add(lblSubTitulo);
        getContentPane().add(btnAceptar);
        getContentPane().add(btnCancelar);
        getContentPane().add(panelTabla);
        getContentPane().add(lblFondo);
        pack();
    } // FIN INITCOMPONENT//

    /**
     * Metodo de boton aceptar: consulta si esta seguro de guardar la seleccion
     * realizada. si = guarda el registro actividad, no= vuelve a la ventana
     * asignar
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
     * llama a metodo comprobarExistentes(alumno) si el alumno ya posee la
     * actividad a asignar, no lo muestra como opcion
     *
     * @param id docente
     * @return Object [][]
     */
    public Object[][] filasSegunTabla(int id) {

        listaActividades = personaABM.listaActividad(docenteInicio.getId());
        Object[][] matrizObjetos = new Object[listaActividades.size() + 4][7];
        int fila = 0;
        for (int f = 0; f < listaActividades.size(); f++) {
            Actividad actividad = listaActividades.get(f);
            if (controlador.comprobarExistentes(actividad)) {
                matrizObjetos[fila][0] = actividad.getMateria().getMateria();
                matrizObjetos[fila][1] = actividad.getTema();
                matrizObjetos[fila][2] = actividad.getGrado().toString();
                matrizObjetos[fila][3] = actividad.getNivel().toString();
                matrizObjetos[fila][4] = actividad.getDificultad().toString();
                matrizObjetos[fila][5] = actividad.getMaxIntentos();
                matrizObjetos[fila][6] = false;
                fila++;
            }
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
     * Guarda la/s selecion/es de alumnos realiazada por el docente luego de
     * crear la actividad
     *
     * @return boolean[]
     */
    private boolean[] cargarAsignaciones() {
        boolean[] asignaciones = new boolean[listaActividades.size()];

        for (int i = 0; i < asignaciones.length; i++) {
            boolean dato = (boolean) tablaRespuestas.getValueAt(i, 5);
            asignaciones[i] = dato;
        }

        return asignaciones;
    }

    /**
     * Guarda el registro actividad incorporando los atributos not null
     * (actividad, alumno, docente)
     *
     * @param asignacion
     */
    public void guardarRegistro(boolean[] asignacion) {

        List<Actividad> listaActividades = personaABM.listaActividad(docenteInicio.getId());

        for (int i = 0; i < asignacion.length; i++) {

            if (asignacion[i]) {
                RegistroActividad nuevoRegistro = new RegistroActividad();
                nuevoRegistro.setActividad(listaActividades.get(i));
                nuevoRegistro.setAlumno(this.alumno);
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
