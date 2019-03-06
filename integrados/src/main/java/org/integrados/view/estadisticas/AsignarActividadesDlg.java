/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.estadisticas;

import java.awt.BorderLayout;
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
import org.integrados.controller.estadisticas.AsignarActividadesCtrl;
import org.integrados.controller.usuarios.DocenteInicioCtrl;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.util.Util;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class AsignarActividadesDlg extends JFrame {

    private JTable tablaRespuestas = null;
    private JPanel panelTabla = new JPanel();
    private JLabel lblFondo;
    private JButton btnAceptar = null;
    private JButton btnCancelar = null;
    private AsignarActividadesCtrl controlador;
    private JScrollPane scroll = null;
    private DocenteInicioCtrl docenteInicio;
    private Docente docente;
    private PersonaABM pers = new PersonaABM(); //-----------> provisorio (va docenteInicioDlg)
    
    public AsignarActividadesDlg(Docente d) {
        docente = d;
        initComponent();
    }

    private void initComponent() {
        this.pack();
         this.setTitle("Asignar Actividad");
        this.setSize(460, 280);
        this.setBackground(new Color(0, 102, 102));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                //controlador.cerrarAplicacion();
            }
        });

        // Creando panel general y aplicando fondo        
        
        lblFondo = new JLabel();
        lblFondo.setFont(new Font("Comic Sans MS", 0, 12)); // NOI18N

        // Propiedades del fondo de pantalla
        //ImageIcon icon = createImageIcon("images/Fondo2.jpg", "Fondo");
       //lblFondo.setIcon(icon);
        lblFondo.setBounds(0, 0, 460, 280);

        JLabel lblEnunciado = Util.crearLabel("Seleccione a que alumno/s desea asignar la nueva actividad", 1, 14);
        lblEnunciado.setBounds(20, 20, 450, 30);
        
        
        // Creando tabla de alumnos
        tablaRespuestas = new JTable();
        tablaRespuestas.setBorder(BorderFactory.createCompoundBorder());
        tablaRespuestas.setFont(new Font("Comic Sans MS", 0, 13)); 
        tablaRespuestas.setModel(new DefaultTableModel(filasSegunTabla(1),
                new String[]{
                    "Nombre", "Apellido", "Grado", "División", " Nivel", "Asignar"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
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
                //volver();
            }
        });
        
         // Propiedades del botón cancelar
        btnCancelar = Util.crearBoton("Cancelar", 14);
        btnCancelar.setBounds(270, 200, 130, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //volver();
            }
        });

//agagregar a la ventana
        
        
        getContentPane().add(lblEnunciado);
        getContentPane().add(btnAceptar);
        getContentPane().add(btnCancelar);
        getContentPane().add(panelTabla);
       this.add(lblFondo);
    }
    

    /**
     * Devuelve matriz object cargada con lista de alumnos del docente
     * 
     * llama a metodo devolverFila(alumno)
     * 
     * @param docente
     * @return 
     */
    public Object[][] filasSegunTabla(int id) {
        List<Alumno> listaAlumnos = pers.listaAlumnos(1);
        String[][] matrizObjetos = new String[listaAlumnos.size()][6];
        int colum = 0;
        
        for (int f = 0; f < listaAlumnos.size(); f++) {
            Alumno alumno = listaAlumnos.get(f);
                matrizObjetos[f][0] =  alumno.getNombre();
                matrizObjetos[f][1] =  alumno.getApellido();
                matrizObjetos[f][2] =  alumno.getGrado().toString();
                matrizObjetos[f][3] =  alumno.getDivision();
                matrizObjetos[f][4] =  alumno.getNivel().toString();
                matrizObjetos[f][5] =  null;
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

    public void mostrar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }
    
    
}
