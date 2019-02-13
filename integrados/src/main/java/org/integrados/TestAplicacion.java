/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados;

import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;

/**
 *
 * @author balquinta
 */
public class TestAplicacion {

    public static void main(String[] args) {

        try {
            CfgMySql f = new CfgMySql();
            f.modificarXml("root", "q4xJolas");
            f.generarXml();
        } catch (Exception e) {
            System.out.println("xd");
            e.printStackTrace();
        }

        Aplicacion app = new Aplicacion();

        try {
            app.inicializar();
        } catch (IntegradosException e) {
            Dialogo.error("ERROR FATAL", "Falló la inicialización");
//            // Dialogo.error(e.getMessage(), new Dialogo.ListenerCerrarDialogo() {
//                @Override
//                public void ejecutar() {
//                    System.exit(0);        
//                }
//            });
            return;
        }
        app.ejecutar();

    }
}
