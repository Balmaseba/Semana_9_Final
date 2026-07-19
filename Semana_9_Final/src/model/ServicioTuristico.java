package model;

public abstract class ServicioTuristico {
    protected String nombre;
    protected String precio;

    public ServicioTuristico(String nombre, String precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public abstract void mostrarInformacion();
}
