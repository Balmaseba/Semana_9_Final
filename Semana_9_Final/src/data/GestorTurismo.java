package data;

import model.*;

import java.util.ArrayList;

//Clase para administrar los recursos de la agencia
//Registramos recursos y generamos el reporte

public class GestorTurismo{
    //Lista para almacenar los recursos registrados
    private ArrayList<Persona>listaPersona = new ArrayList<>();
    //Lista para almacenar los servicios turísticos
    private ArrayList<ServicioTuristico>listaServicios = new ArrayList<>();

    //Contadores
    private int contadorGuia = 1;
    private int contadorOperador = 1;
    private int contadorColaborador = 1;
    private int contadorCliente = 1;

    //Generadores de código
    public String generarCodigoGuia() {
        return String.format("GUI%03d", contadorGuia++);
    }
    public String generarCodigoOperador(){
        return String.format("OPE%03d", contadorOperador++);
    }
    public String generarCodigoColaborador(){
        return String.format("COL%03d", contadorColaborador++);
    }
    public String generarCodigoCliente(){
        return String.format("CLI%03d", contadorCliente++);
    }

    //Actualizar contadores

    public void actualizarContadorGuia(int numero){
        if(numero >= contadorGuia){
            contadorGuia = numero + 1;
        }
    }
    public void actualizarContadorOperador(int numero){
        if(numero >= contadorOperador){
            contadorOperador = numero + 1;
        }
    }
    public void actualizarContadorColaborador(int numero){
        if(numero >= contadorColaborador){
            contadorColaborador = numero + 1;
        }
    }
    public void actualizarContadorCliente(int numero){
        if(numero >= contadorCliente){
            contadorCliente = numero + 1;
        }
    }

    //Registrar persona
    public boolean registrarPersona(Persona persona) {
        if(existeRut(persona.getRut())) {
            return false;
        }
        listaPersona.add(persona);
        return true;
    }

    // Método para mostrar los guías
    public String mostrarGuias(){
        String texto = "-------- Guías turísticos --------\n\n";
        for(Persona p : listaPersona){
            if(p instanceof GuiaTuristico){
                texto += ((Informable)p).mostrarDetalles();
                texto += "\n----------------------------\n";
            }
        }
        return texto;
    }

    // Método para mostrar a los operadores
    public String mostrarOperadores(){
        String texto = "---------- Operadores de Transporte -----------\n\n";
        for(Persona p : listaPersona){
            if(p instanceof OperadorTransporte){
                texto += ((Informable)p).mostrarDetalles();
                texto += "\n-----------------------------------------\n";
            }
        }
        return texto;
    }

    // Método para mostrar colaboradores
    public String mostrarColaboradores(){
        String texto = "---------- Colaboradores Externos -----------\n\n";
        for(Persona p : listaPersona){
            if(p instanceof ColaboradorExterno){
                texto += ((Informable)p).mostrarDetalles();
                texto += "\n-----------------------------------------\n";
            }
        }
        return texto;
    }

    // Mostrar Clientes
    public String mostrarClientes(){
        String texto = "------------ Clientes Externos --------------\n\n";
        for(Persona p : listaPersona){
            if(p instanceof Cliente){
                texto += ((Informable)p).mostrarDetalles();
                texto += "\n-----------------------------\n";
            }
        }
        return texto;
    }

    //Método para cargar los Servicios Turisticos
    public void cargarServicios(ArrayList<ServicioTuristico> servicios) {

        listaServicios.clear();
        listaServicios.addAll(servicios);
    }

    public ArrayList<ServicioTuristico> getListaServicios(){
        return listaServicios;
    }


    // Método para mostrar los servicios
    public String obtenerServicios(){
        String texto = "--------------- SERVICIOS TURÍSTICOS ----------------------\n\n";

        for (ServicioTuristico servicio : listaServicios){
            texto += servicio.toString() + "\n\n";
        }
        return texto;
    }

    // Verificar RUT duplicado
    public boolean existeRut(String rut){
        for(Persona persona :listaPersona) {
            if (persona.getRut().equalsIgnoreCase(rut)) {
                return true;
            }
        }
        return false;
    }
    //Generar Reporte
    public String generarReporte() {

        String reporte = "";

        for (Persona p : listaPersona) {

            if (p instanceof GuiaTuristico) {
                reporte += "GUÍA TURÍSTICO\n";
            } else if (p instanceof OperadorTransporte) {
                reporte += "OPERADOR DE TRANSPORTE\n";
            } else if (p instanceof ColaboradorExterno) {
                reporte += "COLABORADOR EXTERNO\n";
            } else if (p instanceof Cliente) {
                reporte += "CLIENTE\n";
            }

            reporte += ((Informable)p).mostrarDetalles();
            reporte += "\n------------------------------------\n\n";
        }

        return reporte;
    }

        public ArrayList<Persona> getLista() {

        return listaPersona;
        }
    }





