/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.usuarios;

import org.integrados.view.DocenteInicioDlg;

/**
 *
 * @author Grupo Front
 */
public class DocenteInicioCtrl {
    
    private DocenteInicioDlg ppalFrmDocenteDlg;

    public DocenteInicioCtrl() {
    }
    
    public void finalizar() {
        this.ppalFrmDocenteDlg.ocultar();
    }
}
