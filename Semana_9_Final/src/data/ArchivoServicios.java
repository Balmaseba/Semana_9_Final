package data;

import model.*;
import java.io.*;
import java.util.ArrayList;

public class ArchivoServicios {

    private static final String ARCHIVO = "servicios.txt";


    public ArrayList<ServicioTuristico> leerServicios(){
        ArrayList<ServicioTuristico> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);

        if(!archivo.exists()){
            System.out.println("No se encontró el archivo de servicios.");
            return lista;
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

                    case "GAS":
                        if(datos.length != 4){
                            System.out.println("Línea " + numeroLinea + " inválida: " + linea);
                            continue;
                        }
                        lista.add(new RutaGastronomica(datos[1], datos[2], datos[3]));
                        break;

                    case "GEN":
                        if(datos.length != 3){
                            System.out.println("Línea " + numeroLinea + " inválida: " + linea);
                            continue;
                        }
                        lista.add(new TourGenerico(datos[1], datos[2]));
                        break;

                    case "LAC":
                        if(datos.length != 4){
                            System.out.println("Línea " + numeroLinea + " inválida: " + linea);
                            continue;
                        }
                        lista.add(new PaseoLacustre(datos[1], datos[2], datos[3]));
                        break;

                    case "CUL":
                        if(datos.length != 4){
                            System.out.println("Línea " + numeroLinea + " inválida: " + linea);
                            continue;
                        }
                        lista.add(new ExcursionCultural(datos[1], datos[2], datos[3]));
                        break;

                    default:
                        System.out.println("Tipo de servicio desconocido de la línea " + numeroLinea + ": " + linea);
                }

            }
        }catch(IOException e){
            System.out.println("Error al lee el archivo de servicios.");
            System.out.println(e.getMessage());
        }
        return lista;
    }


}


