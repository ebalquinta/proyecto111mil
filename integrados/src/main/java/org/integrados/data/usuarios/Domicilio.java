/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.data.usuarios;

/**
 *
 * @author Yani
 */
public class Domicilio {

    private Integer id;
    private String calle;
    private int numero;
    private String piso;
    private String departamento;

    public Domicilio() {
        this.id = null;
    }

    public Domicilio(String calle, int numero) {
        this.id = null;
        this.calle = calle;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", departamento=" + departamento + '}';
    }

}
