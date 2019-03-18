/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClass;

/**
 *
 * @author Jacco
 */
 
import java.util.Random;
 
public class Cronometro extends Thread {
 
    int minutos = 0, seg=0;
    boolean detener = true;
    
    public Cronometro(){
        
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSeg() {
        return seg;
    }
    
    public void parar(){
        detener = false;
    }
    
    @Override
    public void run() {
        
         while(detener){
            
//            System.out.println(seg);
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
            
            if(seg == 60){
                seg=0;
                minutos++;
            }
            seg++;
        }
    }

}

