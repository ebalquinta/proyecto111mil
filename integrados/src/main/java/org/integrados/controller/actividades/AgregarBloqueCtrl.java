package org.integrados.controller.actividades;

import org.integrados.controller.actividades.CrearPregYRespCtrl;
import org.integrados.view.AgregarBloqueDlg; 

/**
 *
 * @author Mariela
 */
public class AgregarBloqueCtrl {    
    private CrearPregYRespCtrl crearPregYRespCtrl;
    public AgregarBloqueDlg agregarBloqueDlg;

    public AgregarBloqueCtrl(CrearPregYRespCtrl crearPregYRespCtrl) {
        this.crearPregYRespCtrl = crearPregYRespCtrl;
    }    

    public CrearPregYRespCtrl getCrearPregYRespCtrl() {
        return crearPregYRespCtrl;
    }
    
    public void mostrar() {
        agregarBloqueDlg = new AgregarBloqueDlg(this, crearPregYRespCtrl);
        this.agregarBloqueDlg.mostrar();
    }
    
    
}
