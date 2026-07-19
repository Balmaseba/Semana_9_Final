package model;

//Clase que representa a un Guia Turistico
//Hereda de Persona e implementa la interfaz informable

public class GuiaTuristico extends Persona implements Informable {

    private String especialidad;

    //Constructor que inicializa todos los atributos
    public GuiaTuristico(String codigo, String nombre, String rut, String telefono, String correo, String especialidad){
        super(codigo, nombre, rut, telefono, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    //Mostramos datos en consola
    @Override
    public String mostrarDetalles(){
        return "Código: "+ codigo
                + "\nNombre: " + nombre
                + "\nRut: " + rut
                + "\nTeléfono: " + telefono
                + "\nCorreo: " + correo
                + "\nEspecialidad: " + especialidad;
    }

    @Override
    public String toString(){
        return "GUI;" + codigo + ";" + nombre + ";" + rut +  ";" + telefono + ";" + correo + ";" + especialidad;
    }
}
