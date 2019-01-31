/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */

public class Util {

    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    /**
     * El método convierte un Date a String
     * @param fechaNacimiento
     * @return String
     */
    public static String dateToString(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return "";
        }

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat(FORMATO_FECHA);
        return formatoDeFecha.format(fechaNacimiento);
    }

}
