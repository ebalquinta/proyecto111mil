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

    private Integer idDomicilio;
    private String calle;
    private int numero;
    private String piso;
    private String departamento;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }
    
    public Domicilio(String calle, int numero, String piso) {
        this(calle, numero);
        this.piso = piso;
    }
    
    public Domicilio(String calle, int numero, String piso, String departamento) {
        this(calle, numero, piso);
        this.departamento = departamento;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
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
