package model;
//Clase que representa a un operador de transporte (Ya sea de automovil o de bote)
public class OperadorTransporte extends Persona implements Informable {
    private String tipoVehiculo;
    private String estadoVehiculo;

    //Constructor que inicializa todos los atributos
    public OperadorTransporte(String codigo, String nombre, String rut, String telefono, String correo, String tipoVehiculo, String estadoVehiculo) {
        super(codigo, nombre, rut, telefono, correo);
        this.tipoVehiculo = tipoVehiculo;
        this.estadoVehiculo =  estadoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    //Mostramos los datos en consola
    @Override
    public String mostrarDetalles() {
        return "Código: " + codigo
                        + "\nNombre: " + nombre
                        + "\nRut: " + rut
                        + "\nTeléfono: " + telefono
                        + "\nCorreo: " + correo
                        + "\nTipo vehículo: " + tipoVehiculo
                        + "\nEstado: " + estadoVehiculo;
    }

    @Override
    public String toString(){
        return "OPE;" +  codigo + ";" + nombre + ";" + rut + ";" + telefono + ";" +  correo + ";" + tipoVehiculo + ";" + estadoVehiculo;
    }
}
