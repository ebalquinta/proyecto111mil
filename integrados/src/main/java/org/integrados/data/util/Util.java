package org.integrados.data.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *paqiuete util: con .java con metodos que sean utiles para implemetar en distintas clases. 
los metodos estaticos. la clase NO (publica).
constrructor privado.
clacularPorcentaje y estrellas podrian estar en util.
 */

 public class Util {
    private static final String FORMATO_FECHA = "dd/MM/yyyy";
    
    private Util(){
        
    }
    
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
