package data;

import model.*;
import java.io.*;


public class ArchivoTurismo {
    private static final String ARCHIVO = "personas.txt";

    //Guardar archivo
    public void guardarArchivo(GestorTurismo gestor) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))){
            for (Persona p : gestor.getLista()){
                bw.write(p.toString());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Error al guardar el archivo.");
            System.out.println(e.getMessage());
        }
    }

    //Leer archivo
    public void leerArchivo(GestorTurismo gestor){
        File archivo = new File(ARCHIVO);

        if(!archivo.exists()){
            System.out.println("El archivo no existe.");
            return;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){

            String linea;
            int numeroLinea = 0;

            while((linea = br.readLine()) != null){
                numeroLinea++;
                if(linea.trim().isEmpty()){
                    continue;
                }

                String[] datos = linea.split(";");

                switch(datos[0]){
                    case "GUI":
                        if(datos.length != 7){
                            System.out.println("Línea " + numeroLinea + " inválida.");
                            continue;
                        }
                        GuiaTuristico guia = new GuiaTuristico(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                        gestor.registrarPersona(guia);
                        gestor.actualizarContadorGuia(Integer.parseInt(datos[1].substring(3)));
                        break;

                    case "OPE":
                        if(datos.length != 8){
                            System.out.println("Línea " + numeroLinea + " inválida.");
                            continue;
                        }
                        OperadorTransporte operador = new OperadorTransporte(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
                        gestor.registrarPersona(operador);
                        gestor.actualizarContadorOperador(Integer.parseInt(datos[1].substring(3)));
                        break;

                    case "COL":
                        if(datos.length != 7){
                            System.out.println("Línea " + numeroLinea + " inválida.");
                            continue;
                        }
                        ColaboradorExterno colaborador = new ColaboradorExterno(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                        gestor.registrarPersona(colaborador);
                        gestor.actualizarContadorColaborador(Integer.parseInt(datos[1].substring(3)));
                        break;

                    case "CLI":
                        if(datos.length != 7){
                            System.out.println("Línea " + numeroLinea + " inválida.");
                            continue;
                        }
                        Cliente cliente = new Cliente(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
                        gestor.registrarPersona(cliente);
                        gestor.actualizarContadorCliente(Integer.parseInt(datos[1].substring(3)));
                        break;

                    default:
                        System.out.println("Tipo de persona desconocido en la línea." + numeroLinea);

                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo.");
            System.out.println(e.getMessage());
        }
    }
}
