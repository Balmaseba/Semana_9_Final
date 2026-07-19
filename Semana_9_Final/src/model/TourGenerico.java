package model;

public class TourGenerico extends ServicioTuristico{
    public TourGenerico(String nombre, String precio){
        super(nombre, precio);
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("Servicio: " + nombre + " | Precio: " + precio);
    }

    @Override
    public String toString() {
        return "Servicio: " + nombre
                + " | Precio: $" + precio;
    }
}
