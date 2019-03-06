/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.usuarios;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.integrados.Aplicacion;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.usuarios.Alumno;
import org.integrados.data.usuarios.Docente;
import org.integrados.data.usuarios.Persona;
import org.integrados.exceptions.IntegradosException;
import org.integrados.view.Dialogo;
import org.integrados.view.LoginDlg;

/**
 *
 * @author Grupo Front
 */
public class LoginCtrl {
    
    public static Aplicacion app;
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

    public Aplicacion getApp() {
        return app;
    }

    public Persona getPersona() {
        return persona;
    }

    public void validar(String usuario, String clave) throws IntegradosException {
        Session session = null;
        try {
            session = HibernateUtiles.getSession();
            session.beginTransaction();             
            Query query = session.createQuery("from Docente where usuario='" + usuario + "' and clave='" + clave + "'");  
            Docente docente = (Docente) query.uniqueResult();
            session.getTransaction().commit();
            
            if (docente != null) {
                this.persona = docente;
                return;
            }

            session.beginTransaction();
            query = session.createQuery("from Alumno where usuario='" + usuario + "' and clave='" + clave + "'");
            Alumno alumno = (Alumno) query.uniqueResult();
            session.getTransaction().commit();
            
            if (alumno != null) {
                this.persona = alumno;
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new IntegradosException("Error al consultar el usuario", e);
        } finally {
            if (session.isConnected())
                session.close();
        }
        throw new IntegradosException("Usuario y/o Clave incorrectos");
    }

    public void finalizar() {
        this.app.setPersonaLogueada(persona);
        this.loginDlg.ocultar();
    }

    public void cerrarAplicacion() {
        Dialogo.ResultadoDialogo resultado = Dialogo.confirmacion("¡Atención!", "¿Realmente desea salir?");
        if (resultado == Dialogo.ResultadoDialogo.Yes) {
            this.loginDlg.ocultar();
            this.app.cerrar();
        }
    }
}
