package org.integrados.data.usuarios;

public abstract class Persona {

    protected Integer id;
    protected Integer dni;
    protected String nombre;
    protected String apellido;
    protected Domicilio domicilio;
    protected Integer telefono;
    protected String mail;
    protected String usuario;
    protected String clave;

    public Persona() {
        this.id = null;
    }

    public Persona(Integer dni, String nombre, String apellido) {
        this();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", telefono=" + telefono + ", mail=" + mail + ", usuario=" + usuario + ", clave=" + clave + '}';
    }

}
