package org.integrados;

import org.integrados.bd.HibernateUtiles;
import org.integrados.controller.PersonaABMCtrl;
import org.integrados.data.Persona;

/**
 *
 * @author balquinta
 */
public class Aplicacion {
    
    public Aplicacion() {
        HibernateUtiles.inicializar();
        PersonaABMCtrl p = new PersonaABMCtrl();
        Persona m = (Persona)p.get(1);        
        System.out.print(m.toString());
        m.setNombre("Pablo");
        p.guardar(m);
        m = (Persona)p.get(1);        
        System.out.print(m.toString());
    }
}
