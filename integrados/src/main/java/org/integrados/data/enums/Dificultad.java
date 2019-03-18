/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.enums;

/**
 *
 * @author
 */
public enum Dificultad {

    Baja("El nivel de dificultad de la actividad es Bajo", 1),
    Intermedia("El nivel de dificultad de la actividad es Intermedio", 2),
    Alta("El nivel de dificultad de la actividad es Alto", 3);

    private String descripcion;
    private int valor;

    Dificultad(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getValor() {
        return this.valor;
    }

}
