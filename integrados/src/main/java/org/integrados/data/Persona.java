package org.integrados.data;

public class Persona {    

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
    
}
