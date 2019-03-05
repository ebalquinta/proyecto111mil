/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados;

import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;
//import org.integrados.view.MySqlLog;
 
/**
 *
 * @author balquinta
 */
public class TestAplicacion {

    public static void main(String[] args) {
    
        

        Aplicacion app = new Aplicacion();

        try {
            app.inicializar();
        } catch (IntegradosException e) {
            Dialogo.error("ERROR FATAL", "Falló la inicialización");
            // Dialogo.error(e.getMessage(), new Dialogo.ListenerCerrarDialogo() {
            //    @Override
            //    public void ejecutar() {
            //       System.exit(0);        
            //    }
            // });
            return;
        }
        app.ejecutar();

    }
}
