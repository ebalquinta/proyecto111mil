/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.view.actividades.memorama;

import javax.swing.JFrame;

/**
 *
 * @author alumno
 */
public class MemoramaDlg extends JFrame {
    Tablero tablero;
    
    public MemoramaDlg(Tablero tablero){
        this.tablero = tablero;
        this.add(tablero);
        
    }
}
