package model;

public class RutaGastronomica extends ServicioTuristico {

    private String especialidad;

    public RutaGastronomica(String nombre, String precio, String especialidad) {
        super(nombre,precio);
        this.especialidad = especialidad;
    }
    @Override
    public void mostrarInformacion(){
        System.out.println("Servicio: " + nombre + " | Precio: $" + precio + " | Tipo: Gastronómico | Especialidad: "  + especialidad);
    }
    @Override
    public String toString() {
        return "Servicio: " + nombre
                + " | Precio: $" + precio
                + " | Tipo: Gastronómico"
                + " | Especialidad: " + especialidad;
    }
}
