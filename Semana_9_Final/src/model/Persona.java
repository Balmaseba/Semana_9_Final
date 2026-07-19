package model;

public abstract class Persona {
    //protected porque en este caso no es indisplensable que esten en private
    protected String codigo;
    protected String nombre;
    protected String rut;
    protected String telefono;
    protected String correo;

    public Persona() {
    }

    public Persona(String codigo, String nombre, String rut, String telefono, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.correo = correo;
    }
    public String getCodigo() { //Solo getter y no setter por que el dato es un identificador de la persona
        return codigo;
    }
    public String getRut() { //Getter para el rut ya que debemos utilizarlo para verificar si la persona está duplicada
        return rut;
    }
    public String getNombre() { //Getter y setter para el resto ya que los utilizaremos
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }

}
