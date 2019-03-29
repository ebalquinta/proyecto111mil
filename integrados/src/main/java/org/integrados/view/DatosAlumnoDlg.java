package org.integrados.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.util.Util;

/**
 *
 * @author GrupoFront
 */
public class DatosAlumnoDlg extends JFrame {
    
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblDni;
    private JLabel lblFechaNac;
    private JLabel lblDomicilio;
    private JLabel lblTelefono;
    private JLabel lblMail;
    private JLabel lblEdadMadu;
    private JLabel lblGrado;
    private JLabel lblDivision;
    private JLabel lblNivel;
    private JLabel lblObserva;
    private JButton btnVolver;
    private JLabel lblFondo;
    private DocenteBrowseAlumnoDlg vistaAnterior;
    private Alumno alumno;
    
    public DatosAlumnoDlg(DocenteBrowseAlumnoDlg vistaAnterior, Alumno alumno) {
        this.vistaAnterior=vistaAnterior;
        this.alumno = alumno;
        initComponents();
    }
    
    private void initComponents() {
                
        lblFondo = new JLabel();
        btnVolver = Util.crearBoton("Volver", 14);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        // Propiedades del label que muestra el nombre completo
        String nombre = this.alumno.getNombre();
        String apellido = this.alumno.getApellido();
        lblNombre = Util.crearLabel("Nombre: " + nombre + " " + apellido, 1, 26);
        lblNombre.setBounds(130, 50, 800, 80);
        getContentPane().add(lblNombre);
        
        // Inicializa el tamaño de font para el resto de los labels
        int tamañoFont = 18;
        
        // Propiedades del label que muestra el dni
        String dni = this.alumno.getDni()+"";
        lblDni = Util.crearLabel("DNI: " + dni, 0, tamañoFont);
        lblDni.setBounds(130, 100, 800, 120);
        getContentPane().add(lblDni);
        
        // Propiedades del label que muestra la fecha de nacimiento
        String fechaNacimiento = Util.dateToString(this.alumno.getFechaNacimiento());
        lblFechaNac = Util.crearLabel("Fecha de nacimiento: " + fechaNacimiento, 0, tamañoFont);
        lblFechaNac.setBounds(130, 120, 800, 140);
        getContentPane().add(lblFechaNac);

        // Propiedades del label que muestra el domicilio
        
        // La siguiente es la línea que falla:
        // Intenta obtener el domicilio de la instancia de Alumno pasada como
        // parámetro desde el método verDatosAlumnoActual() de la vista 
        // DocenteBrowswAlumnoDlg.
        
        //String domicilio = this.alumno.getDomicilio().toString();
        String domicilio = "A solucionar";
        lblDomicilio = Util.crearLabel("Domicilio: " + domicilio, 1, tamañoFont);
        lblDomicilio.setBounds(130, 140, 800, 160);
        getContentPane().add(lblDomicilio);

        // Propiedades del label que muestra el teléfono
        String telefono = this.alumno.getTelefono();
        lblTelefono = Util.crearLabel("Teléfono: " + telefono, 0, tamañoFont);
        lblTelefono.setBounds(130, 160, 800, 180);
        getContentPane().add(lblTelefono);

        // Propiedades del label que muestra el mail
        String mail = this.alumno.getMail();
        lblMail = Util.crearLabel("Mail: " + mail, 0, tamañoFont);
        lblMail.setBounds(130, 180, 800, 200);
        getContentPane().add(lblMail);
        
        // Propiedades del label que muestra la edad madurativa
        String edadMadurativa = this.alumno.getEdadMadurativa()+"";
        lblEdadMadu = Util.crearLabel("Edad madurativa: " + edadMadurativa, 0, tamañoFont);
        lblEdadMadu.setBounds(130, 200, 800, 220);
        getContentPane().add(lblEdadMadu);
        
         // Propiedades del label que muestra el grado
        String grado = this.alumno.getGrado()+"";
         lblGrado = Util.crearLabel("Grado: " + grado, 0, tamañoFont);
        lblGrado.setBounds(130, 220, 800, 240);
        getContentPane().add(lblGrado);

        // Propiedades del label que muestra la división
        String division = this.alumno.getDivision();
        lblDivision = Util.crearLabel("División: " + division, 0, tamañoFont);
        lblDivision.setBounds(130, 240, 800, 260);
        getContentPane().add(lblDivision);
   
         // Propiedades del label que muestra el nivel
        String nivel = this.alumno.getNivel()+"";
        lblNivel = Util.crearLabel("Nivel: " + nivel, 0, tamañoFont);
        lblNivel.setBounds(130, 260, 800, 280);
        getContentPane().add(lblNivel);
        
         // Propiedades del label que muestra las observaciones
        String observaciones = this.alumno.getObservaciones();
        lblObserva = Util.crearLabel("Observaciones: " + observaciones, 0, tamañoFont);
        lblObserva.setBounds(130, 280, 800, 300);
        getContentPane().add(lblObserva);
        
        // Propiedades de botón Volver
        btnVolver.setBounds(295, 510, 170, 30);
        DatosAlumnoDlg aux = this;
        getContentPane().add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aux.ocultar();
            }
        });

        // Propiedades del fondo de pantalla
        ImageIcon icon = createImageIcon("images/Fondo.jpg", "Fondo");
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
        this.vistaAnterior.ocultar();
        this.setVisible(true);
    }
    
    public void ocultar() {
        this.dispose();
        this.vistaAnterior.mostrar();
    }
    
}