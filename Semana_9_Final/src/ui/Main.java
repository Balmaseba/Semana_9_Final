package ui;
//Clase principal de nuestro programa
//Utilizamos JOptionPane para registrar recursos mediante un menú gráfico
import data.GestorTurismo;
import data.ArchivoTurismo;
import data.ArchivoServicios;
import model.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {

    public static GestorTurismo gestor = new GestorTurismo();
    private static ArchivoTurismo archivo = new ArchivoTurismo();
    private static ArchivoServicios archivoServicios = new ArchivoServicios();

    public static void main(String[] args) {

        archivo.leerArchivo(gestor);
        gestor.cargarServicios(archivoServicios.leerServicios());


        String menu = "------LLANQUIHUE TOUR------\n\n1.- Registrar Guía turístico\n2.- Registrar Operador de Transporte\n3.- Registrar Colaborador Externo\n" +
                "4.- Registrar Cliente\n5.- Filtrar\n6.- Ver Servicios Turísticos\n7.- Ver Reporte\n8.- Salir";

        while (true) {
            String opciones = JOptionPane.showInputDialog(menu);
            if (opciones == null || opciones.equals("8")) break;

            switch (opciones) {
                case "1":
                    registrarGuia();
                    break;

                case "2":
                    registrarOperador();
                    break;

                case "3":
                    registrarColaborador();
                    break;

                case "4":
                    registrarCliente();
                    break;
                case "5":
                    filtrarPersonas();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, gestor.obtenerServicios());
                    break;
                case "7":

                    JTextArea area = new JTextArea(gestor.generarReporte());

                    area.setRows(20);       // cantidad de filas visibles
                    area.setColumns(30);    // ancho de la ventana
                    area.setEditable(false);

                    JOptionPane.showMessageDialog(
                            null,
                            new JScrollPane(area),
                            "Reporte Llanquihue Tour",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
        JOptionPane.showMessageDialog(null, "Programa finalizado");
    }

    // Método para ingresar y validar dato en el registro
    private static String solicitarDato(String mensaje) {

        String dato = JOptionPane.showInputDialog(mensaje);

        if (dato == null || dato.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo no puede quedar vacío.");
            return null;
        }

        return dato;
    }


    //Método para registrar Guía
    public static void registrarGuia() {

        String nombre = solicitarDato("Nombre:");
        if (nombre == null) return;

        String rut = solicitarDato("Rut:");
        if (rut == null) return;

        String telefono = solicitarDato("Teléfono:");
        if (telefono == null) return;

        String correo = solicitarDato("Correo:");
        if (correo == null) return;

        String especialidad = solicitarDato("Especialidad:");
        if (especialidad == null) return;

        GuiaTuristico guia = new GuiaTuristico(
                gestor.generarCodigoGuia(),
                nombre,
                rut,
                telefono,
                correo,
                especialidad);

        registrarPersona(guia);
    }

    //Método para Registrar Operador
    private static void registrarOperador() {

        String nombre = solicitarDato("Nombre:");
        if (nombre == null) return;

        String rut = solicitarDato("Rut:");
        if (rut == null) return;

        String telefono = solicitarDato("Teléfono:");
        if (telefono == null) return;

        String correo = solicitarDato("Correo:");
        if (correo == null) return;

        String tipoVehiculo = solicitarDato("Tipo de vehículo:");
        if (tipoVehiculo == null) return;

        String estadoVehiculo = solicitarDato("Estado del vehículo (Funcional/En mantenimiento):");
        if (estadoVehiculo == null) return;

        OperadorTransporte operador = new OperadorTransporte(
                gestor.generarCodigoOperador(),
                nombre,
                rut,
                telefono,
                correo,
                tipoVehiculo,
                estadoVehiculo);

        registrarPersona(operador);
    }

    //Método para registrar al colaborador
    private static void registrarColaborador() {

        String nombre = solicitarDato("Nombre:");
        if (nombre == null) return;

        String rut = solicitarDato("Rut:");
        if (rut == null) return;

        String telefono = solicitarDato("Teléfono:");
        if (telefono == null) return;

        String correo = solicitarDato("Correo:");
        if (correo == null) return;

        String servicio = solicitarDato("Servicio prestado:");
        if (servicio == null) return;

        ColaboradorExterno colaborador = new ColaboradorExterno(
                gestor.generarCodigoColaborador(),
                nombre,
                rut,
                telefono,
                correo,
                servicio);

        registrarPersona(colaborador);
    }

    //Método para registrar al cliente
    private static void registrarCliente() {

        String nombre = solicitarDato("Nombre:");
        if (nombre == null) return;

        String rut = solicitarDato("Rut:");
        if (rut == null) return;

        String telefono = solicitarDato("Teléfono:");
        if (telefono == null) return;

        String correo = solicitarDato("Correo:");
        if (correo == null) return;

        String servicio = solicitarDato("------- Servicio contratado ------- \n\nGastronómicos: Sabores del Sur - Ruta del queso\n\n" +
                "Cultural: Patrimonial Furtillar - Historia de Osorno\n\nLacustre: Lago Llanquihue - Bahía de Puerto Varas\n\n" +
                "Tour Generico: 1 - 2");
        if (servicio == null) return;

        Cliente cliente = new Cliente(
                gestor.generarCodigoCliente(),
                nombre,
                rut,
                telefono,
                correo,
                servicio);

        registrarPersona(cliente);
    }

    // Método para registrar a cualquier persona
    private static void registrarPersona(Persona persona) {
        if (gestor.registrarPersona(persona)) {
            archivo.guardarArchivo(gestor);
            JOptionPane.showMessageDialog(null, "Registro exitoso.\n\nCódigo: " + persona.getCodigo());
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una persona registrada con ese RUT");
        }
    }

    //Método para filtrar personas
    private static void filtrarPersonas() {
        String menu = "---------- Filtrar Personas -----------\n\n" + "1.- Guías Turísticos\n" + "2.- Operadores de Transporte\n"
                + "3.- Colaboradores Externos\n" + "4.- Clientes\n" + "5.- Mostrar todos\n" + "6.- Volver";

        String opcion = JOptionPane.showInputDialog(menu);

        if (opcion == null || opcion.equals("6")) {
            return;
        }
        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, gestor.mostrarGuias());
                break;
            case "2":
                JOptionPane.showMessageDialog(null, gestor.mostrarOperadores());
                break;
            case "3":
                JOptionPane.showMessageDialog(null, gestor.mostrarColaboradores());
                break;
            case "4":
                JOptionPane.showMessageDialog(null, gestor.mostrarClientes());
                break;
            case "5":
                JOptionPane.showMessageDialog(null, gestor.generarReporte());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion inválida");
                return;
        }

    }
}
