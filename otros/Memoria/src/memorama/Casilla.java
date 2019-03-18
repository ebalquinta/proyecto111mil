package memorama;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 
 * @author SAB-005
 */
public class Casilla extends JLabel{
    
    private int ancho=140;
    private int alto=140;
    private ImageIcon hide = new ImageIcon(getClass().getResource("/imagenes/hide.jpg"));
    private ImageIcon figura;
    private String sFigura="";
    private boolean congelado=false;
    
     /** 
      * constructor de clase
      * @param name String El nomnbre de instancia
      */
    public Casilla( String name ){
        super();
        Dimension d = new Dimension(ancho,alto);
        setName(name);
        setSize( d );
        setPreferredSize( d );
        setText("");                
        setIcon( hide );
        setVisible(true);        
        setOpaque(true);
        setCursor(new Cursor( Cursor.HAND_CURSOR ));
    }
    
    /** 
     * Muestra la imagen de la figura asignada a esta casilla
     * @return no tiene
     */
    public void showFigura(){
        setIcon( figura );
    }
    
    /**
     * Oculta la figura
     * @return no tiene
     */
    public void ocultarFigura(){
        if( !congelado ){
            setIcon( hide );
        }
    }
    
    /**
     * Cuando una imagen es congelada, no se puede volver a ocultar hasta comenzar un nuevo juego
     * @param value boolean
     */
    public void congelarImagen(boolean value){
        this.congelado=value;
    }
    
    /**
     * Metodo que retorna el valor boolean de una casilla si este esta o no congelado
     * @return boolean 
     */
    public boolean isCongelado(){
        return this.congelado;
    }
    
    /**
     * Asigna la figura que contendra la casilla
     * @param name nombre de la figura
     */
    public void setFigura( String name ){
        this.sFigura = name;
        if( !name.equals("") ){            
            figura = new ImageIcon(getClass().getResource("/imagenes/"+name+".jpg"));        
        }        
    }
    
    /**
     * Retorna el nombre de la figura que tenga asignada la casilla, si no tiene ninguna
     * retorna una cadena vacia
     * @return String 
     */
    public String getNameFigura(){
        return sFigura;
    }
    
}
