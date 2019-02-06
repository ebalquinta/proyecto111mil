/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.usuarios;

import org.hibernate.Session;
import org.integrados.Aplicacion;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.LoginDlg;

/**
 *
 * @author Grupo Front
 */
public class LoginCtrl {
    
    private Aplicacion app;
    private Persona persona;
    private LoginDlg loginDlg;

    public LoginCtrl(Aplicacion app) {
        this.app = app;
        this.persona = null;
        this.loginDlg = null;
    }
    
    public void login() {
        this.loginDlg = new LoginDlg(this);
        this.loginDlg.mostrar();
    }
    
    public void validar(String usuario, String clave) throws IntegradosException {

        // Comprobación de usuario y contraseña genéricos, sin acceder a la base
        // de datos (para prueba de las GUIs)
        if (usuario.equals("usuario") && clave.equals("usuario")){
            System.out.println("Usuario logueado con éxito");
            return;
        }
   
//        Session session = HibernateUtiles.getSession();
//        session.beginTransaction(); // hecho en clase personaABMCtrl
//        Docente docente = (Docente) session.createQuery("from Docente where usuario = " + usuario + " and clave= " + clave, Docente.class);  //REVISAR EL METODO EN LAS FILMINAS.
//        
//         //SE VERIFICA EN QUE TABLA SE ENCUENTRA EL USUARIO INGRESADO.
//        if(docente !=null){
//            this.persona = docente;
//            return;
//        }
//        Alumno alumno = (Alumno) session.createQuery("from Alumno where usuario = " + usuario + " and clave= " + clave, Alumno.class);
//        if(alumno !=null){
//            this.persona = alumno;
//            return;
//        }

        throw new IntegradosException("Usuario y/o Clave incorrectos (Utilice 'usuario' - 'usuario')");
    }
    
    public void finalizar() {
        this.app.setPersonaLogueada(persona);
        this.loginDlg.ocultar();
    }
    
    public void cancelar() {
        this.loginDlg.ocultar();
        this.app.cerrar();
    }
}   
