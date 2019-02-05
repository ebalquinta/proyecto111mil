package org.integrados.data.actividad;

public class Materia {
    private Integer id;
    private String materia;
    
    public Materia(){   
        this.id = null;
    }
      
    public Materia(String materia){
        this();
        this.materia = materia;
    }

    public Integer getId() {
        return id;
    }    

    public String getMateria(){
        return this.materia;
    }

    private void setId(Integer id) {
        this.id = id;
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    @Override
    public String toString(){
        return "ID = " + this.id + ", materia = " + this.materia;
    }
}
