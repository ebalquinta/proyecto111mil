/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.exceptions;

/**
 *
 * @author Yani
 */
public class IntegradosException extends Exception {

    public IntegradosException(String mensaje) {
        super(mensaje); 
    }
    
    public IntegradosException(String mensaje, Exception cause) {
        super(mensaje, cause); 
    }
}
