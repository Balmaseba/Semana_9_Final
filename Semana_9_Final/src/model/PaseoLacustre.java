package model;

public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, String precio, String tipoEmbarcacion) {
        super(nombre,precio);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre +  " | Precio: $" + precio + " | Tipo: Paseo Lacustre | Tipo de Embarcación: " + tipoEmbarcacion);
    }
    @Override
    public String toString() {
        return "Servicio: " + nombre
                + " | Precio: $" + precio
                + " | Tipo: Paseo Lacustre"
                + " | Embarcación: " + tipoEmbarcacion;
    }
}
