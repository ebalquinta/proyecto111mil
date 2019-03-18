/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClass;

import TestClass.Cronometro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacco
 */

public class Juego extends Thread {
    
    public Juego(){
        
    }
   
    
    @Override
    public void run() {
        Cronometro cronometro = new Cronometro();
        cronometro.start();
        int seg=0;
        while(seg <10){
            System.out.println("jugando...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            seg++;
        }
        
        cronometro.parar();
        System.out.println("Juego finalizado");
        System.out.println("Tiempo "+cronometro.getMinutos()+":"+cronometro.getSeg());

    }
}
