package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import org.integrados.controller.actividades.AlumnoBrowseActividadesCtrl;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.util.Util;
 
/**
 *
 * @author GrupoFront
 */
public class AlumnoBrowseActividadesDlg extends JFrame{

    private JLabel lblFondo;
    private JLabel lblTitulo;
    private JButton btnVolver;
    private JToggleButton btnOrdenar;
    private JToggleButton btnUnir;
    private JToggleButton btnMemorama;
    private JToggleButton btnPregYResp;
    public AlumnoBrowseActividadesCtrl alumnoBrowseActividadesCtrl;
    public List<Actividad> listaActividades;
    
    public AlumnoBrowseActividadesDlg(AlumnoBrowseActividadesCtrl alumnoBrowseActividadesCtrl, List<Actividad> listaActividades) {
        this.alumnoBrowseActividadesCtrl = alumnoBrowseActividadesCtrl;
        this.listaActividades = listaActividades;
        initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Lista de Actividades");        
        lblFondo = new JLabel();
        lblTitulo = Util.crearTitulo("Elegir Actividad", 1, 42);
        btnVolver = Util.crearBoton("Volver", 14);
        btnOrdenar = new JToggleButton();
        btnUnir = new JToggleButton();
        btnMemorama = new JToggleButton();
        btnPregYResp = new JToggleButton();        
       
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarAplicacion();
            }
        });            
        getContentPane().setLayout(null);
         
        // Propiedades de Título
        lblTitulo.setBounds(40, 40, 720, 60);
        getContentPane().add(lblTitulo);
        
        // Propiedades de botón Volver
        btnVolver.setBounds(295, 510, 170, 30);
        getContentPane().add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ocultar();
                alumnoBrowseActividadesCtrl.getAlumnoInicioDlg().mostrar();
            }
        });

      
        // Propiedades del boton btnOrdenar (ordenar)
        btnOrdenar.setBackground(new java.awt.Color(255, 255, 204));
        btnOrdenar.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadOrdenarBtn.jpg")));
        btnOrdenar.setBounds(230, 150, 140, 140);
        btnOrdenar.setToolTipText("Crea una nueva actividad de Ordenar");
        getContentPane().add(btnOrdenar);
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });

        // Propiedades del boton btnUnir (Unir)
        btnUnir.setBackground(new java.awt.Color(255, 255, 204));
        btnUnir.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadUnirBtn.jpg")));
        btnUnir.setBounds(400, 150, 140, 140);
        btnUnir.setToolTipText("Crea una nueva actividad de Unir");
        getContentPane().add(btnUnir);
        btnUnir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del boton btnMemorama (Preguntas y respuestas)
        btnMemorama.setBackground(new java.awt.Color(255, 255, 204));
        btnMemorama.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadMemoramaBtn.jpg")));
        btnMemorama.setBounds(230, 320, 140, 140);
        btnMemorama.setToolTipText("Crea una nueva actividad de Memorama");
        getContentPane().add(btnMemorama);
        btnMemorama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
            }
        });
        
        // Propiedades del boton btnPregYResp (Memorama)
        btnPregYResp.setBackground(new java.awt.Color(255, 255, 204));
        btnPregYResp.setIcon(new ImageIcon(getClass().getResource("images/NuevaActividadPregRespBtn.jpg")));
        btnPregYResp.setBounds(400, 320, 140, 140);
        btnPregYResp.setToolTipText("Crea una nueva actividad de Preguntas y Respuestas");
        getContentPane().add(btnPregYResp);
        
        AlumnoBrowseActividadesDlg aux = this;
        btnPregYResp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Dialogo.mensaje(" En construcción ", " ¡Estamos trabajando para usted! ");
//                ocultar();
//                new CrearPregYRespCtrl(aux, aux.docenteBrowseActividadesBrw.controlador.docenteInicioDlg).mostrar();
            }
        });
        
        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/FondoConTitulo.jpg","descripción");
        lblFondo.setIcon(icon);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, 0, 800, 600);
        
        this.setBounds(new Rectangle(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
    
    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.ocultar();            
            LoginCtrl.app.cerrar();
        }
    }
}