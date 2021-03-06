package org.integrados;

import org.integrados.exceptions.IntegradosException;
import org.integrados.bd.HibernateUtiles;
import org.integrados.controller.usuarios.LoginCtrl;
import org.integrados.data.usuarios.Persona;

/**
 *
 * @author Grupo Front
 */
public class Aplicacion {
    
    private Persona personaLogueada;
    
    public Aplicacion() {       
        this.personaLogueada = null;
    }

    public Persona getPersonaLogueada() {
        return personaLogueada;
    }

    public void setPersonaLogueada(Persona personaLogueada) {
        this.personaLogueada = personaLogueada;
    }
    
    public void inicializar() throws IntegradosException {
//        LoginCtrl loginCtrl = new LoginCtrl(this);
//        MySqlLog logIn = new MySqlLog(loginCtrl);
//        logIn.setVisible(true);
        HibernateUtiles.inicializar();
    }
    
    public void ejecutar() {
        LoginCtrl loginCtrl = new LoginCtrl(this);
        loginCtrl.login();
    }
    
    public void cerrar() {
        HibernateUtiles.finalizar();
        System.exit(0);
    }
    
    
}

//        HibernateUtiles.inicializar();
//        PersonaABMCtrl p = new PersonaABMCtrl();
//        Persona m = (Persona)p.get(1);        
//        System.out.print(m.toString());
//        m.setNombre("Pablo");
//        p.guardar(m);
//        m = (Persona)p.get(1);        
//        System.out.print(m.toString());