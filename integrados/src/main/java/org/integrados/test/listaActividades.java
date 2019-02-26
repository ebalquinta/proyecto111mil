/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.test;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.controller.ABM.ActividadABM;
import org.integrados.controller.ABM.BloqueABM;
import org.integrados.controller.ABM.MateriaABM;
import org.integrados.controller.ABM.PersonaABM;
import org.integrados.controller.ABM.PlantillaABM;
import org.integrados.data.actividad.Actividad;
import org.integrados.data.actividad.Materia;
import org.integrados.data.bloques.Bloque;
import org.integrados.data.enums.Dificultad;
import org.integrados.data.enums.Nivel;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.data.usuarios.Docente;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class listaActividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IntegradosException {
        HibernateUtiles.inicializar();
       
        BloqueABM bloq = new BloqueABM();
        PlantillaABM plan = new PlantillaABM();
        MateriaABM mate = new MateriaABM();
        ActividadABM act = new ActividadABM();
       //Bloques
        
        Bloque bImg = bloq.get(1);
        
        Bloque bSon = bloq.get(2);
        
        Bloque bTex = bloq.get(3);
       
        Bloque bAnd = bloq.get(4);
          
        
        //Lista Bloques
        List<Bloque> bloques = new ArrayList<>();
        bloques.add(bImg);
        bloques.add(bSon);
        bloques.add(bTex);
        bloques.add(bAnd);
        
        //Plantillas
        
        Plantilla unir = plan.get(1);
        
        Materia materia = mate.get(1);
        
        PersonaABM personaABM = new PersonaABM();
        Docente docente = (Docente) personaABM.get(1);
        
        
        Actividad actividad1 = new Actividad(unir, docente, materia, "Celula", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        act.guardar(actividad1);
        Actividad actividad2 = new Actividad(unir, docente, materia, "Celula", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
       act.guardar(actividad2);
        Actividad actividad3 = new Actividad(unir, docente, materia, "Celula", 1, Nivel.PRIMARIO, Dificultad.BAJO, 3);
        act.guardar(actividad3);
        
        List<Actividad> listaActividades = new ArrayList<>();
        listaActividades.add(actividad1);
        listaActividades.add(actividad2);
        listaActividades.add(actividad3);
        
        docente.setActividades(listaActividades);
        personaABM.guardar(docente);
        
        
    }
    public static void saveObjeto(Object objeto) throws IntegradosException {
        
        Session s;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(objeto);
            s.getTransaction().commit();
            
            s.close();
        } catch (IntegradosException e) {
            System.out.println("no agrego ALUMNO");
        }
    }
}
