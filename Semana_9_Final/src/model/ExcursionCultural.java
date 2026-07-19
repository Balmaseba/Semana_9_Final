package model;

public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, String precio, String lugarHistorico) {
        super(nombre, precio);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("Servicio: " + nombre + " | Precio: $" + precio + " | Tipo: Excursión Cultural | Lugar Histórico: " + lugarHistorico);
    }
    @Override
    public String toString() {
        return "Servicio: " + nombre
                + " | Precio: $" + precio
                + " | Tipo: Excursión Cultural"
                + " | Lugar histórico: " + lugarHistorico;
    }
}
