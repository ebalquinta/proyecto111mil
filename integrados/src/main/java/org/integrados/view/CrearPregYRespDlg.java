package org.integrados.view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.BloqueABM;
import org.integrados.controller.ABM.MateriaABM;
import org.integrados.controller.ABM.PlantillaABM;
import org.integrados.controller.actividades.AgregarBloqueCtrl;
import org.netbeans.lib.awtextra.*;
import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueAnd;
import org.integrados.data.bloques.BloqueImagen;
import org.integrados.data.bloques.BloqueSonido;
import org.integrados.data.bloques.BloqueTexto;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.plantillas.PregYResp;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.util.Util;

/**
 *
 * @author Grupo Front
 */
public class CrearPregYRespDlg extends JFrame {

    // Variables declaration     
    public CrearPregYRespCtrl controlador;
    public Docente docente;
    private String titulo = null;
    private PregYResp pregYResp;

    private JScrollPane panel = null;
    private JLabel lblFondo = null;
    private DefaultTableModel tableModel;

    private JLabel lblTitulo = null;

    private JLabel lblCategoria = null;
    private JLabel lblMateria = null;
    private JComboBox<String> comboMateria = null;
    private JLabel lblNivel = null;
    private JComboBox<String> comboNivel = null;
    private JLabel lblGrado = null;
    private JComboBox<String> comboGrado = null;
    private JLabel lblDificultad = null;
    private JComboBox<String> comboDificultad = null;
    private JLabel lblMaxIntentos = null;
    private JTextField txtMaxIntentos = null;
    private JLabel lblTema = null;
    private JTextField txtTema = null;

    private JSeparator linePregunta = null;
    private JLabel lblPregunta = null;
    private JLabel lblIngreseTexto = null;
    private JTextField txtIngreseTexto = null;
    private JLabel lblIngreseImagen = null;
    private JTextField txtIngreseImagen = null;
    private JButton btnArchivoImagen = null;
    private JLabel lblIngreseSonido = null;
    private JTextField txtIngreseSonido = null;
    private JButton btnArchivoSonido = null;

    private JSeparator lineRespuestas = null;
    private JLabel lblRespuestas = null;
    private JButton btnAgregar = null;
    private JTable tablaRespuestas = null;
    private JLabel lblIcoTexto = null;
    private JLabel lblIcoImagen = null;
    private JLabel lblIcoSonido = null;
    private JLabel lblIcoValidar = null;

    private JButton btnProbar = null;
    private JButton btnGuardar = null;
    private JButton btnCancelar = null;

    //ABM para guardar la nueva actividad
    private PlantillaABM plantillaABM = new PlantillaABM();
    private MateriaABM materiaABM = new MateriaABM();
    private ActividadABM actividadABM = new ActividadABM();
    private BloqueABM bloqueABM = new BloqueABM();
    // End of variables declaration        

    /**
     * Constructor para usar desde la ventana de Nueva Actividad
     *
     * @param controlador - Controlador de la vista a crear
     * @param docente - Docente logueado
     */
    public CrearPregYRespDlg(CrearPregYRespCtrl controlador, Docente docente) {
        this.controlador = controlador;
        this.docente = docente;
        this.titulo = null;
        initComponents();
    }

    /**
     * Constructor para usar desde la lista de Actividades del Docente, con la
     * opcion de Editar Actividad
     *
     * @param controlador - Controlador de la vista a crear
     * @param docente - Docente logueado
     * @param titulo - Título dinámico con id de actividad a editar
     */
    public CrearPregYRespDlg(CrearPregYRespCtrl controlador, Docente docente, String titulo) {
        this.controlador = controlador;
        this.docente = docente;
        this.titulo = titulo;
        initComponents();

    }

    /**
     * Metodo para inicializar los componentes de la vista
     */
    private void initComponents() {
        CrearPregYRespDlg aux = this;
        if (this.controlador.isAlta()) {
            this.setTitle("Nueva Actividad - Pregunta y Respuestas");
        } else {
            this.setTitle(titulo);
        }
        this.pack();
        this.setSize(800, 600);
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
        panel = new JScrollPane();
        lblFondo = new JLabel();
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/Fondo2.jpg", "Fondo");
        lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 800, 600);

        // Creando elementos de seccion 1        
        if (this.controlador.isAlta()) {
            lblTitulo = Util.crearLabel("Crear Pregunta y Respuestas", 0, 18);
        } else {
            lblTitulo = Util.crearLabel("Editar Pregunta y Respuestas", 0, 18);
        }
        lblCategoria = Util.crearLabel("Categoría (complete todos los campos)", 1, 14);
        lblMateria = Util.crearLabel("Materia:", 0, 12);
        comboMateria = Util.crearComboMateria();
        lblNivel = Util.crearLabel("Nivel:", 0, 12);
        comboNivel = Util.crearComboNivel();
        comboNivel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboNivelActionPerformed(evt);
            }
        });
        lblGrado = Util.crearLabel("Grado:", 0, 12);
        comboGrado = Util.crearComboGrado();
        comboGrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboGradoActionPerformed(evt);
            }
        });
        lblDificultad = Util.crearLabel("Dificultad:", 0, 12);
        comboDificultad = Util.crearComboDificultad();
        comboDificultad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboDificultadActionPerformed(evt);
            }
        });
        lblMaxIntentos = Util.crearLabel("Max.Intentos:", 0, 12);
        txtMaxIntentos = Util.crearTextField(14);
        lblTema = Util.crearLabel("Tema:", 0, 14);
        txtTema = Util.crearTextField(14);
        txtTema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtTemaActionPerformed(evt);
            }
        });

        // Creando elementos de seccion 2
        linePregunta = new JSeparator();
        lblPregunta = Util.crearLabel("Pregunta (complete uno o mas campos)", 1, 14);
        lblIngreseTexto = Util.crearLabel("Ingrese texto", 0, 14);
        txtIngreseTexto = Util.crearTextField(14);
        txtIngreseTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseTextoActionPerformed(evt);
            }
        });
        lblIngreseImagen = Util.crearLabel("Ingrese imagen", 0, 14);
        txtIngreseImagen = Util.crearTextField(14);
        txtIngreseImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseImagenActionPerformed(evt);
            }
        });
        btnArchivoImagen = Util.crearBoton("Archivo", 12);
        btnArchivoImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SistemaDeArchivosDlg archivos;
                JTextField txt = txtIngreseImagen;
                archivos = new SistemaDeArchivosDlg(aux, txt);
                archivos.mostrar();
            }
        });
        lblIngreseSonido = Util.crearLabel("Ingrese sonido", 0, 14);
        txtIngreseSonido = Util.crearTextField(14);
        txtIngreseSonido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtIngreseSonidoActionPerformed(evt);
            }
        });
        btnArchivoSonido = Util.crearBoton("Archivo", 12);
        btnArchivoSonido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SistemaDeArchivosDlg archivos;
                JTextField txt = txtIngreseSonido;
                archivos = new SistemaDeArchivosDlg(aux, txt);
                archivos.mostrar();
            }
        });

        // Creando elementos de seccion 3
        lineRespuestas = new JSeparator();
        lblRespuestas = Util.crearLabel("Respuestas (Ingrese al menos 2 opciones y al menos 1 de ellas válida)", 1, 14);
        btnAgregar = Util.crearBoton("Agregar", 12);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new AgregarBloqueCtrl(controlador).mostrar();
            }
        });

        tablaRespuestas = new JTable();
        tablaRespuestas.setBorder(BorderFactory.createCompoundBorder());
        tablaRespuestas.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N
        tableModel = new DefaultTableModel(iniciarTabla(), new String[]{
            "           Texto", "           Imagen", "           Sonido", "           Es Valida"
        }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        tablaRespuestas.setModel(tableModel);
        tablaRespuestas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaRespuestas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tablaRespuestas.setFocusCycleRoot(true);
        tablaRespuestas.setGridColor(new Color(0, 102, 102));
        tablaRespuestas.setMinimumSize(new Dimension(10, 10));
        lblIcoTexto = new JLabel();
        lblIcoTexto.setIcon(Util.reziseImageIcon(createImageIcon("images/IcoTexto.png", "IcoTexto"), 18, 18));
        lblIcoImagen = new JLabel();
        lblIcoImagen.setIcon(Util.reziseImageIcon(createImageIcon("images/IcoImagen.png", "IcoImagen"), 20, 20));
        lblIcoSonido = new JLabel();
        lblIcoSonido.setIcon(Util.reziseImageIcon(createImageIcon("images/IcoSonido.png", "IcoSonido"), 16, 16));
        lblIcoValidar = new JLabel();
        lblIcoValidar.setIcon(Util.reziseImageIcon(createImageIcon("images/IcoValidar.jpg", "IcoValidar"), 16, 16));

        // Creando elementos de footer
        btnProbar = Util.crearBoton("Probar", 12);
        btnGuardar = Util.crearBoton("Guardar", 12);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guardarActividad();
            }
        });
        btnCancelar = Util.crearBoton("Cancelar", 12);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                volver();
            }
        });

        // Agregando elementos a la ventana
        getContentPane().setLayout(new AbsoluteLayout());

        getContentPane().add(lblTitulo, new AbsoluteConstraints(270, 10, 260, 50));
        getContentPane().add(lblCategoria, new AbsoluteConstraints(70, 50, 340, 30));
        getContentPane().add(lblMateria, new AbsoluteConstraints(70, 76, 160, 12));
        getContentPane().add(comboMateria, new AbsoluteConstraints(70, 90, 160, 30));
        getContentPane().add(lblNivel, new AbsoluteConstraints(250, 76, 100, 12));
        getContentPane().add(comboNivel, new AbsoluteConstraints(250, 90, 100, 30));
        getContentPane().add(lblGrado, new AbsoluteConstraints(370, 76, 100, 12));
        getContentPane().add(comboGrado, new AbsoluteConstraints(370, 90, 100, 30));
        getContentPane().add(lblDificultad, new AbsoluteConstraints(490, 76, 100, 12));
        getContentPane().add(comboDificultad, new AbsoluteConstraints(490, 90, 100, 30));
        getContentPane().add(lblMaxIntentos, new AbsoluteConstraints(600, 90, 90, 30));
        getContentPane().add(txtMaxIntentos, new AbsoluteConstraints(690, 90, 30, 30));
        getContentPane().add(lblTema, new AbsoluteConstraints(70, 130, 50, 30));
        getContentPane().add(txtTema, new AbsoluteConstraints(120, 130, 600, 30));

        getContentPane().add(linePregunta, new AbsoluteConstraints(60, 180, 670, 10));
        getContentPane().add(lblPregunta, new AbsoluteConstraints(70, 180, 340, 30));
        getContentPane().add(lblIngreseTexto, new AbsoluteConstraints(70, 220, 110, 30));
        getContentPane().add(txtIngreseTexto, new AbsoluteConstraints(180, 220, 540, 30));
        getContentPane().add(lblIngreseImagen, new AbsoluteConstraints(70, 260, 110, 30));
        getContentPane().add(txtIngreseImagen, new AbsoluteConstraints(180, 260, 440, 30));
        getContentPane().add(btnArchivoImagen, new AbsoluteConstraints(640, 260, 80, 30));
        getContentPane().add(lblIngreseSonido, new AbsoluteConstraints(70, 300, 110, 30));
        getContentPane().add(txtIngreseSonido, new AbsoluteConstraints(180, 300, 440, 30));
        getContentPane().add(btnArchivoSonido, new AbsoluteConstraints(640, 300, 80, 30));

        getContentPane().add(lineRespuestas, new AbsoluteConstraints(60, 350, 670, 10));
        getContentPane().add(lblRespuestas, new AbsoluteConstraints(70, 350, 500, 30));
        getContentPane().add(btnAgregar, new AbsoluteConstraints(640, 360, 80, 30));
        getContentPane().add(lblIcoTexto, new AbsoluteConstraints(90, 396, 30, 30));
        getContentPane().add(lblIcoImagen, new AbsoluteConstraints(250, 401, 20, 20));
        getContentPane().add(lblIcoSonido, new AbsoluteConstraints(410, 401, 20, 20));
        getContentPane().add(lblIcoValidar, new AbsoluteConstraints(570, 401, 20, 20));
        panel.setViewportView(tablaRespuestas);
        getContentPane().add(panel, new AbsoluteConstraints(70, 400, 650, 120));

        getContentPane().add(btnProbar, new AbsoluteConstraints(250, 530, 80, 30));
        getContentPane().add(btnGuardar, new AbsoluteConstraints(360, 530, 80, 30));
        getContentPane().add(btnCancelar, new AbsoluteConstraints(460, 530, 80, 30));

        getContentPane().add(lblFondo, new AbsoluteConstraints(0, 0, 800, 600));

        if (!this.controlador.isAlta()) {
            actualizarComponentes();
        }

        pack();

    }

    private void comboDificultadActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void comboNivelActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtTemaActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtIngreseTextoActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtIngreseImagenActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtIngreseSonidoActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void comboGradoActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
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

    //Actualiza los componentes con los datos del modelo
    private void actualizarComponentes() {
        Actividad actividad = this.controlador.getActividad();
        this.comboMateria.setSelectedItem(actividad.getMateria().getMateria());
        this.comboNivel.setSelectedItem(actividad.getNivel());
        this.comboGrado.setSelectedItem(actividad.getGrado());
        this.comboDificultad.setSelectedItem(actividad.getDificultad());
        this.txtMaxIntentos.setText(actividad.getMaxIntentos().toString());
        this.txtTema.setText(actividad.getTema());
        this.txtIngreseTexto.setText(actividad.getPlantilla().getEnunciado());
        this.txtIngreseImagen.setText(actividad.getPlantilla().getImagenEnunciado());
        this.txtIngreseSonido.setText(actividad.getPlantilla().getSonidoEnunciado());
        List<Bloque> opciones = ((PregYResp) actividad.getPlantilla()).getOpciones();
        List<Bloque> soluciones = ((PregYResp) actividad.getPlantilla()).getSoluciones();
        for (Bloque b : opciones) {
            this.agregarRow(this.bloqueToObject(b, soluciones));
        }
    }

    /**
     * iniciar tabla como null para evitar nullPointerException
     *
     * @param infoBloque
     */
    public Object[][] iniciarTabla() {
        int cantFilas = 0;
        Object[][] matriz = new Object[cantFilas][4];
        for (int f = 0;
                f < cantFilas;
                f++) {
            matriz[f][0] = null;
            matriz[f][1] = null;
            matriz[f][2] = null;
            matriz[f][3] = false;
        }
        return matriz;
    }

    public void agregarRow(Object[] infoBloque) {
        tableModel.addRow(infoBloque);
    }

    /**
     * Valida si los campos requeridos están completos y guarda o actualiza la
     * Actividad
     */
    private void guardarActividad() {
        System.out.println("Validando campos");
        String materia = comboMateria.getSelectedItem().toString();
        String nivel = comboNivel.getSelectedItem().toString();
        String grado = comboGrado.getSelectedItem().toString();
        String dificultad = comboDificultad.getSelectedItem().toString();
        String maxIntentos = txtMaxIntentos.getText();
        String tema = txtTema.getText();
        String texto = txtIngreseTexto.getText();
        String imagen = txtIngreseImagen.getText();
        String sonido = txtIngreseSonido.getText();

        //Valido si los campos requeridos están completos 
        int filas = tablaRespuestas.getRowCount();
        int validas = 0;
        if (filas > 0) {
            for (int i = 0; i < filas; i++) {
                if ((boolean) tablaRespuestas.getValueAt(i, 3)) {
                    validas++;
                }
            }
        }
        if ((maxIntentos.length() == 0)
                || (tema.length() == 0)
                || ((texto.length() == 0) && (imagen.length() == 0) && (sonido.length() == 0))
                || (filas == 0 || (filas > 0 && validas == 0))) {
            Dialogo.mensaje("¡Error de Validación! ", " Debe completar todos los campos requeridos antes de continuar");
        } else {
            System.out.println("Campos requeridos completos");
            String camposCompletados = "Está a punto de crear una Actividad con la siguiente información:\n\nMateria: " + materia + "\nNivel: " + nivel + "\nGrado: " + grado + "\nDificultad: " + dificultad + "\nMax.Intentos: " + maxIntentos + "\nTema: " + tema + "\nTexto: " + texto + "\nImagen: " + imagen + "\nSonido: " + sonido + "\nRespuestas: " + filas + "\nVálidas: " + validas + "\n\n¿Desea Continuar?";
            Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención! ", camposCompletados);
            if (resultado == Dialogo.ResultadoDialogo.Yes) {
                // acá iría el método del controlador que guarda la actividad en la base de datos
                Materia materiaa = materiaABM.getSegunString(materia);
                //Guardar Bloques y plantilla
                if (this.controlador.isAlta()) {
                    Plantilla plantilla = guardarPlantilla(tablaRespuestas, texto, imagen, sonido);
                    guardarActividadBD(plantilla, materiaa, tema, grado, nivel, dificultad, maxIntentos);
                } else {                
                    Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
                }
                volver();
            }
        }
    }

    /**
     * guarda bloques en lista opciones y soluciones y plantilla con sus
     * respectivos bloques y enunciado
     *
     * @param tabla
     * @param texto
     * @param imagen
     * @param sonido
     * @return plantilla
     */
    public Plantilla guardarPlantilla(JTable tabla, String texto, String imagen, String sonido) {
        int filas = tabla.getRowCount();
        List<Bloque> listaOpciones = new ArrayList<>();
        List<Bloque> listaSoluciones = new ArrayList<>();
        if (!this.controlador.isAlta()) {
            // Si estoy editando, borro los bloques existentes en la actividad para volver a crearlos
            try {
                listaOpciones = ((PregYResp) this.controlador.getActividad().getPlantilla()).getOpciones();
                listaSoluciones = ((PregYResp) this.controlador.getActividad().getPlantilla()).getSoluciones();
                System.out.println("lista opciones existente: " + listaOpciones.toString());
                System.out.println("lista solucion existente: " + listaSoluciones.toString());
                int size = listaOpciones.size();
                for (int i = 0; i < size; i++) {
                    Bloque b = listaSoluciones.get(0);
                    //bloqueABM.borrar(b);
                    //listaOpciones.remove(b);
                    listaSoluciones.remove(b);
                }
            } catch (Exception e) {
                System.out.println("error en borrar lista opciones y soluciones al editar");
            }
        }
        System.out.println("lista opciones luego de borrar: " + listaOpciones.toString());
        System.out.println("lista solucion luego de borrar: " + listaSoluciones.toString());

        // Guardar bloques para opciones y soluciones
        for (int i = 0; i < filas; i++) {
            String texto1 = (String) tabla.getValueAt(i, 0);
            String imagen1 = (String) tabla.getValueAt(i, 1);
            String sonido1 = (String) tabla.getValueAt(i, 2);

            Bloque bloque = null;

            if (this.controlador.isAlta()) {
                bloque = guardarBloque(texto1, imagen1, sonido1);
                if (bloque != null) {
                    listaOpciones.add(bloque);

                    if ((boolean) tabla.getValueAt(i, 3)) {
                        listaSoluciones.add(bloque);
                    }
                }
            } else {
                if (i < listaOpciones.size()) {
                    bloque = bloqueABM.get(listaOpciones.get(i).getId());
                    /*
                        tipoBloque: 
                        sonido = 1
                        imagen = 2
                        texto = 3
                        and = 4
                     */
                    switch (bloque.getTipoBloque()) {
                        case 1:
                            ((BloqueSonido) bloque).setSonido(sonido1);
                            break;
                        case 2:
                            ((BloqueImagen) bloque).setImagen(imagen1);
                            break;
                        case 3:
                            ((BloqueTexto) bloque).setTexto(texto1);
                            break;
                        case 4:
                            ((BloqueAnd) bloque).setSonido(sonido1);
                            ((BloqueAnd) bloque).setImagen(imagen1);
                            ((BloqueAnd) bloque).setTexto(texto1);
                            break;
                    }

                    bloque = actualizarBloque((Bloque) bloque);
                    
                    if (((boolean) tabla.getValueAt(i, 3)) && (!listaSoluciones.contains(bloque))) {
                        listaSoluciones.add(bloque);
                    } else if (!((boolean) tabla.getValueAt(i, 3)) && (listaSoluciones.contains(bloque))) {
                        listaSoluciones.remove(bloque);
                    }
                    
                } else {
                    bloque = guardarBloque(texto1, imagen1, sonido1);
                    if (bloque != null) {
                        listaOpciones.add(bloque);

                        if ((boolean) tabla.getValueAt(i, 3)) {
                            listaSoluciones.add(bloque);
                        }
                    }
                }
            }
        }
        System.out.println("lista opciones luego de agregar: " + listaOpciones.toString());
        System.out.println("lista solucion luego de agregar: " + listaSoluciones.toString());
        //Guardar plantilla 
        PregYResp plantilla = null;
        if (this.controlador.isAlta()) {
            plantilla = new PregYResp(listaOpciones, texto, listaSoluciones);
            plantilla.setImagenEnunciado(imagen);
            plantilla.setSonidoEnunciado(sonido);

            plantillaABM.guardar(plantilla);
        } else {
            plantilla = (PregYResp) plantillaABM.get(this.controlador.getActividad().getPlantilla().getId());
            System.out.println(" plantilla " + plantilla.toString());
            plantilla.setEnunciado(texto);
            System.out.println("texto: " + texto);
            plantilla.setImagenEnunciado(imagen);
            plantilla.setSonidoEnunciado(sonido);
            plantilla.setSoluciones(listaSoluciones);
            System.out.println("lista soluciones set soluciones: " + listaSoluciones.toString());
            plantilla.setOpciones(listaOpciones);
            System.out.println("lista soluciones set opciones: " + listaOpciones.toString());

            plantillaABM.guardar(plantilla);
        }
        return (Plantilla) plantilla;
    }

    /**
     * Guardar bloque para las 8 combinaciones posibles entre los 3 string
     * ingresantes
     *
     * @param texto
     * @param imagen
     * @param sonido
     * @return boolean (alta del bloque en la BD)
     */
    public Bloque guardarBloque(String texto, String imagen, String sonido) {
        if ((((texto != null) && (!texto.equals(""))) && (((imagen != null) && (!imagen.equals(""))) || ((sonido != null) && (!sonido.equals(""))))) || (((imagen != null) && (!imagen.equals(""))) && (((texto != null) && (!texto.equals(""))) || ((sonido != null) && (!sonido.equals(""))))) || (((sonido != null) && (!sonido.equals(""))) && (((imagen != null) && (!imagen.equals(""))) || ((texto != null) && (!texto.equals(""))))) || (((sonido != null) && (!sonido.equals(""))) && ((imagen != null) && (!imagen.equals(""))) && ((texto != null) && (!texto.equals(""))))) {
            Bloque bloqueAnd = new BloqueAnd(texto, imagen, sonido);
            bloqueABM.guardar(bloqueAnd);
            return bloqueAnd;
        } else if ((texto != null) && (!texto.equals(""))) {
            Bloque bloqueTexto = new BloqueTexto(texto);
            bloqueABM.guardar(bloqueTexto);
            return bloqueTexto;
        } else if ((imagen != null) && (!imagen.equals(""))) {
            Bloque bloqueImagen = new BloqueImagen(imagen);
            bloqueABM.guardar(bloqueImagen);
            return bloqueImagen;
        } else {
            Bloque bloqueSonido = new BloqueSonido(sonido);
            bloqueABM.guardar(bloqueSonido);
            return bloqueSonido;
        }
    }

    /**
     *
     * @param texto
     * @param imagen
     * @param sonido
     * @return
     */
    public Bloque actualizarBloque(Bloque bloque) {
        bloqueABM.set(bloque);
        Bloque bloqueRetorno = bloqueABM.get(bloque.getId());

//        if ((((texto != null) && (!texto.equals(""))) && (((imagen != null) && (!imagen.equals(""))) || ((sonido != null) && (!sonido.equals(""))))) || (((imagen != null) && (!imagen.equals(""))) && (((texto != null) && (!texto.equals(""))) || ((sonido != null) && (!sonido.equals(""))))) || (((sonido != null) && (!sonido.equals(""))) && (((imagen != null) && (!imagen.equals(""))) || ((texto != null) && (!texto.equals(""))))) || (((sonido != null) && (!sonido.equals(""))) && ((imagen != null) && (!imagen.equals(""))) && ((texto != null) && (!texto.equals(""))))) {
//            Bloque bloqueAnd = new BloqueAnd(texto, imagen, sonido);
//            bloqueABM.set(bloqueAnd);
//            return bloqueAnd;
//        } else if ((texto != null) && (!texto.equals(""))) {
//            Bloque bloqueTexto = new BloqueTexto(texto);
//            bloqueABM.set(bloqueTexto);
//            return bloqueTexto;
//        } else if ((imagen != null) && (!imagen.equals(""))) {
//            Bloque bloqueImagen = new BloqueImagen(imagen);
//            bloqueABM.set(bloqueImagen);
//            return bloqueImagen;
//        } else {
//            Bloque bloqueSonido = new BloqueSonido(sonido);
//            bloqueABM.set(bloqueSonido);
//            return bloqueSonido;
//        }
        return bloqueRetorno;
    }

    public Object[] bloqueToObject(Bloque bloque, List<Bloque> soluciones) {
        boolean valido = false;
        for (Bloque b : soluciones) {
            if ((b.getTipoBloque() == bloque.getTipoBloque()) && b.equals(bloque)) {
                valido = true;
            }
        }
        /*Arreglo de texto, imagen, sonido, checkbox*/
        Object[] arreglo = {null, null, null, valido};
        this.actualizarArreglo(arreglo, bloque);
        return arreglo;
    }

    private void actualizarArreglo(Object[] arreglo, Bloque bloque) {
        /*
        tipoBloque: 
        sonido = 1
        imagen = 2
        texto = 3
        and = 4
         */
        switch (bloque.getTipoBloque()) {
            case 1:
                arreglo[2] = ((BloqueSonido) bloque).getSonido();
                break;
            case 2:
                arreglo[1] = ((BloqueImagen) bloque).getImagen();
                break;
            case 3:
                arreglo[0] = ((BloqueTexto) bloque).getTexto();
                break;
            case 4:
                arreglo[0] = ((BloqueAnd) bloque).getTexto();
                arreglo[1] = ((BloqueAnd) bloque).getImagen();
                arreglo[2] = ((BloqueAnd) bloque).getSonido();
        }
    }

    /**
     * Guardar Actividad en BD
     *
     * @param plantilla
     * @param materia
     * @param tema
     * @param gradoS
     * @param nivel
     * @param dificultad
     * @param maxIntentosS
     */
    public void guardarActividadBD(Plantilla plantilla, Materia materia, String tema, String gradoS, String nivel, String dificultad, String maxIntentosS) {
        int grado = controlador.verificarGrado(gradoS);
        int maxIntentos = controlador.stringAInt(maxIntentosS);
        Actividad actividad = null;
        if (this.controlador.isAlta()) {
            actividad = new Actividad(plantilla, this.docente, materia, tema, grado, Nivel.valueOf(nivel), Dificultad.valueOf(dificultad), maxIntentos);
        } else {
            actividad = this.controlador.getActividad();
            actividad.setPlantilla(plantilla);
            actividad.setMateria(materia);
            actividad.setTema(tema);
            actividad.setGrado(grado);
            actividad.setNivel(Nivel.valueOf(nivel));
            actividad.setDificultad(Dificultad.valueOf(dificultad));
            actividad.setMaxIntentos(maxIntentos);
        }
        actividadABM.guardar(actividad);
    }

    public void volver() {
        if (controlador.nuevaActividadInicioDlg != null) {
            controlador.nuevaActividadInicioDlg.mostrar();
        } else if (controlador.docenteBrowseActividadesCtrl != null) {
            controlador.docenteBrowseActividadesCtrl.mostrar();
        }
        ocultar();
    }

    public void mostrar() {
        this.setVisible(true);
        System.out.println("Docente id:" + this.docente.getId());
    }

    public void ocultar() {
        this.setVisible(false);
    }
}
