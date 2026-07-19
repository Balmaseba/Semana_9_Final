package model;
//Clase que represetna a un colaborador externo que presta servicios a nuestra agencia (Como mecánico, proveedor de alojamiento, etc)
public class ColaboradorExterno extends Persona implements Informable {
    private String servicio; //Tipo de servicio que presta el colaborador

    //Constructor que inicializa todos los atributos
    public ColaboradorExterno(String codigo, String nombre, String rut, String telefono, String correo, String servicio) {
        super(codigo, nombre, rut, telefono, correo);
        this.servicio = servicio;
    }

    public String getServicio(){
        return servicio;
    }
    //Muestra los datos en consola
    @Override
    public String mostrarDetalles(){
        return "Código: " + codigo
                        + "\nNombre: " + nombre
                        + "\nRut: " + rut
                        + "\nTeléfono: " + telefono
                        + "\nCorreo: " + correo
                        + "\nServicio prestado: " + servicio;
    }

    @Override
    public String toString(){
        return "COL;" +  codigo + ";" + nombre + ";" + rut +  ";" + telefono + ";" + correo + ";" + servicio;
    }
}
