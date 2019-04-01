/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades.memorama;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.integrados.data.util.Util;
/**
 * 
 * @author SAB-005
 */
public class Casilla extends JLabel{
    
    private int ancho=140;
    private int alto=140;
    private ImageIcon hide;
    private ImageIcon figura;
    private String sFigura="";
    private boolean congelado=false;
    
     /** 
      * constructor de clase
      * @param name String El nomnbre de instancia
      */
    public Casilla( String name ){
        super();
        // Obtengo la ruta relativa de donde estoy parado
        String path = this.getClass().getResource("../../").toString();
        // Reescribo esa ruta en formato correcto para que saque espacios y caracteres especiales
        String result = Util.getDecodedUrl(path);
//        System.out.println(result);
        hide = new ImageIcon(result + "imagesMemorama/hide.png");
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
    public void setFigura( String url ){
        this.sFigura = url;
        if( !url.equals("") ){            
            figura = new ImageIcon(url);        
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

