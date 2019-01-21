package org.integrados.data.usuarios;

public abstract class Persona {    

	private String nombre;
	private int edad;
	private int id;


    public Persona() {
    }

    public Persona(int edad) {
        this.edad = edad;
    }
    
    public Persona (int edad, String nombre) {
    	this.edad=edad;
    	this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", id=" + id + '}';
    }
    
}
