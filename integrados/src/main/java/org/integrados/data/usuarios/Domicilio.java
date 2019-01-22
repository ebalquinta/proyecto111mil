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

    private static int idActual = 0;
    private int idDomicilio;
    private String calle;
    private int numero;
    private String piso;
    private String departamento;

    public Domicilio() {
        idActual++;
        this.idDomicilio = idActual;
    }

    public Domicilio(String calle, int numero) {
        idActual++;
        this.idDomicilio = idActual;
        this.calle = calle;
        this.numero = numero;
    }

    public Domicilio(String calle, int numero, String piso, String departamento) {
        idActual++;
        this.idDomicilio = idActual;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
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
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", departamento=" + departamento + '}';
    }

}
