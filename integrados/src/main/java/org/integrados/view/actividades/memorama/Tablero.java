package org.integrados.view.actividades.memorama;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.bloques.BloqueImagen;

/**
 * @web yimscito@gmail.com
 * @author Mouse
 */
public class Tablero extends JPanel {

    //array con los nombres de las figuras 8 en total para 16 pares
    private String[] band = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho"};

    private int fila = 4;
    private int col = 4;
    private int ancho_casilla = 140;

    private List<BloqueImagen> bloques;

    public boolean play = false;

    int c = 0;
    Casilla c1;
    Casilla c2;
    int aciertos = 0;

    /**
     * Constructor de clase
     */
    public Tablero(List<BloqueImagen> bloques) {
        super();
        //propiedades
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setLayout(new java.awt.GridLayout(fila, col));
        Dimension d = new Dimension((ancho_casilla * col), (ancho_casilla * fila));
        setSize(d);
        setPreferredSize(d);
        this.bloques = bloques;

        //crea instancias de casillas para crear el tablero 
        int count = 0;
        for (int i = 0; i < (fila * col); i++) {
            Casilla p = new Casilla(String.valueOf(i + 1));
            p.setFigura(bloques.get(count).getImagen());
            count++;
            count = (count >= 8) ? 0 : count++;
            p.showFigura();
            p.addMouseListener(new juegoMouseListener());
            this.add(p);
        }
        setVisible(true);
    }

    /**
     * Inicia juegos - llena las casillas con pares de figuras
     *
     * @return no tiene
     */
    public void comenzarJuego() {
        aciertos = 0;
        play = true;
        Component[] componentes = this.getComponents();
        //limpia figuras
        for (int i = 0; i < componentes.length; i++) {
            ((Casilla) componentes[i]).congelarImagen(false);
            ((Casilla) componentes[i]).ocultarFigura();
            ((Casilla) componentes[i]).setFigura("");
        }
        //coloca nuevo orden aleatorio de figuras
        for (int i = 0; i < componentes.length; i++) {
            ((Casilla) componentes[i]).setFigura(bloques.get(i).getImagen());
            /*int n = (int) (Math.random()*(band.length));
            if( !existe(bloques.get(n).getImagen()) ){//comprueba que figura no este asignada mas de 2 veces
            ((Casilla)componentes[i]).setFigura(bloques.get(n).getImagen());
            }else{
            i--;
            }*/
        }
    }

    public void setImagenes(List<BloqueImagen> b) {
        this.bloques = b;
    }

    /**
     * Metodo que comprueba que una casilla existe
     *
     * @param int num nombre del objeto
     * @return Casilla si existe NULL si no existe
     */
    private boolean existe(String figura) {
        int count = 0;
        Component[] componentes = this.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof Casilla) {
                if (((Casilla) componentes[i]).getNameFigura().equals(figura)) {
                    count++;
                }
            }
        }
        return (count == 2) ? true : false;
    }

    /**
     * Clase que implemenenta un MouseListener para la captura de eventos del
     * mouse
     */
    class juegoMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (play) {
                c++;//lleva la cuenta de los click realizados en las casillas            
                if (c == 1) { //primer click
                    c1 = ((Casilla) e.getSource()); //obtiene objeto
                    if (!c1.isCongelado()) {
                        c1.showFigura();
                        System.out.println("Primera Figura: " + c1.getNameFigura());
                    } else {//no toma en cuenta
                        c = 0;
                    }
                } else if (c == 2 && !c1.getName().equals(((Casilla) e.getSource()).getName())) {//segundo click
                    c2 = ((Casilla) e.getSource());
                    if (!c2.isCongelado()) {
                        c2.showFigura();
                        System.out.println("Segunda Figura: " + c2.getNameFigura());
                        //compara imagenes
                        Animacion ani = new Animacion(c1, c2);
                        ani.execute();
                    }
                    c = 0;//contador de click a 0
                } else { //mas de 2 clic consecutivos no toma en cuenta
                    c = 0;
                }
            } else {
                System.out.println("Para jugar: FILE -> JUGAR");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    /**
     *
     */
    class Animacion extends SwingWorker<Void, Void> {

        private Casilla casilla1;
        private Casilla casilla2;

        public Animacion(Casilla value1, Casilla value2) {
            this.casilla1 = value1;
            this.casilla2 = value2;
        }

        @Override
        protected Void doInBackground() throws Exception {
            System.out.println("doInBackground: procesando imagenes...");
            //espera 1 segundo 
            Thread.sleep(1000);
            if (casilla1.getNameFigura().equals(casilla2.getNameFigura())) {//son iguales
                casilla1.congelarImagen(true);
                casilla2.congelarImagen(true);
                System.out.println("doInBackground: imagenes son iguales");
                aciertos++;
                if (aciertos == 8) {//win
                    System.out.println("doInBackground: Usted es un ganador!");
                    JOptionPane.showMessageDialog(null, "Usted es un ganador!");
                }
            } else {//no son iguales
                casilla1.ocultarFigura();
                casilla2.ocultarFigura();
                System.out.println("doInBackground: imagenes no son iguales");
            }
            return null;
        }

    }

}
