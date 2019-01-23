/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.actividad;

/**
 *
 * @author Yani
 */
public class Materia {

    private Integer id;
    private String materia;
    private int anio;

    public Materia(String materia, int anio) {
        this.materia = materia;
        this.anio = anio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", materia=" + materia + ", anio=" + anio + '}';
    }

}
