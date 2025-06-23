package org.dis.Practica1;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String rutaCsv = "src/main/resources/TurismoComunidades.csv";
    public static String rutaJson = "src/main/resources/TurismoComunidades.json";
    public static String rutaJsonAgrupado = "src/main/resources/Comunidades_agrupadas.json";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean csvCargado = false;
        boolean seguirEjecutando = true;

        while(seguirEjecutando){
            int opcion;
            do{
                System.out.print("""
                        MENÚ PRINCIPAL

                        1. Convertir CSV a JSON
                        2. Agrupar por comunidad de destino
                        3. Buscar resultados por periodo
                        4. Buscar resultados por origen
                        5. Salir
                        => """);

                opcion = teclado.nextInt();
                limpiarPantalla();

                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción no válida.");
                }

                if (opcion == 1) {
                    csvCargado = true;
                } else if (!csvCargado && opcion != 5) {
                    System.out.println("Primero debes convertir el CSV.\nPulsa Enter para continuar...");
                    esperarTecla();
                    limpiarPantalla();
                }
            }while ((opcion < 1 || opcion > 5) || (!csvCargado && opcion != 5));

            switch (opcion) {
                case 1 -> {
                    new LectorCSV().convertirCSVaJSON(rutaCsv, rutaJson);
                    System.out.println("CSV convertido correctamente.\nPulsa Enter para continuar...");
                    esperarTecla();
                    limpiarPantalla();
                }
                case 2 -> agruparPorComunidad();
                case 3 -> consultarPorFecha();
                case 4 -> consultarPorProvincia();
                case 5 -> seguirEjecutando=false;
            }
        }
    }
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void esperarTecla() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void agruparPorComunidad() {
        ArrayList<Turismo> lista = new ControladorJSON().leerArchivoJSON(Main.rutaJson);

        Map<String, ArrayList<Turismo>> agrupado = new HashMap<>();

        for (Turismo t : lista) {
            if (t.getDestinoViaje() != null) {
                String comunidad = (t.getDestinoViaje().getComunidad() != null)
                        ? t.getDestinoViaje().getComunidad()
                        : "";
                agrupado.computeIfAbsent(comunidad, k -> new ArrayList<>()).add(t);
                agrupado.get(comunidad).add(t);
            } else {
                // Opcional: puedes agruparlos como "" o saltarlos
                agrupado.computeIfAbsent("", k -> new ArrayList<>()).add(t);
            }
        }

        new ControladorJSON().guardarComoJSON(agrupado, Main.rutaJsonAgrupado);

        System.out.println("Datos agrupados correctamente.\nPulsa Enter para continuar...");
        esperarTecla();
        limpiarPantalla();
    }
    public static void consultarPorFecha() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Turismo> lista = new ControladorJSON().leerArchivoJSON(Main.rutaJson);
        System.out.println("Introduce la fecha (AAAA-MM-DD):");
        String entradaFecha = sc.nextLine();

        String[] partes = entradaFecha.split("-");
        if (partes.length == 3) {
            String periodo = partes[0] + "M" + partes[1];
            System.out.println("Mostrando datos para el periodo: " + periodo);
            for (Turismo t : lista) {
                if (t.getPeriodoDatos().getCodigoPeriodo().equalsIgnoreCase(periodo)) {
                    String resultado = t.toString()
                            .replaceAll("origenViaje=", "")
                            .replaceAll("destinoViaje=", "")
                            .replaceAll("periodoDatos=", "")
                            .replaceAll("=", ": ")
                            .replaceAll("\\{", "")
                            .replaceAll("}", "")
                            .replaceAll("'", "")
                            .replaceAll("\\s+", " ")
                            .trim();
                    System.out.println(resultado);
                }
            }
        } else {
            System.out.println("Formato incorrecto. Debe ser: AAAA-MM-DD");
        }
        System.out.println("Pulsa Enter para continuar...");
        esperarTecla();
        limpiarPantalla();
    }
    public static String consultarPorProvincia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu provincia de origen: ");
        String entrada = sc.nextLine();

        entrada = entrada.trim();
        entrada = StringUtils.capitalize(entrada);

        // Equivalencias para los nombres especiales
        String[][] excepciones = {
                {"Valencia", "Valencia/València"},
                {"La Rioja", "Rioja, La"},
                {"A Coruña", "Coruña, A"},
                {"Álava", "Araba/Álava"},
                {"Castellón", "Castellón/Castelló"},
                {"Las Palmas", "Palmas, Las"},
                {"Santa Cruz de Tenerife", "Tenerife, Santa Cruz de"},
                {"Islas Baleares", "Balears, Illes"},
                {"Alicante", "Alicante/Alacant"}
        };

        for (String[] ex : excepciones) {
            if (ex[0].equals(entrada)) {
                return ex[1];
            }
        }

        return entrada;
    }
}
