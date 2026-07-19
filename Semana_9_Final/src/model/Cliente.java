package model;

public class Cliente extends Persona implements Informable {
    private String servicioContratado;

    public Cliente(String codigo, String nombre, String rut, String telefono, String correo, String servicioContratado) {
        super(codigo, nombre, rut, telefono, correo);
        this.servicioContratado = servicioContratado;
    }

    public String getServicioContratado(){
        return servicioContratado;
    }
    @Override
    public String mostrarDetalles(){
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nRut: " + rut
                + "\nTeléfono: " + telefono
                + "\nCorreo: " + correo
                + "\nServicio Contratado: " + servicioContratado;
    }

    @Override
    public String toString() {
        return "CLI;" + codigo + ";" + nombre + ";" + rut + ";" + telefono + ";" + correo + ";" + servicioContratado;
    }
}
