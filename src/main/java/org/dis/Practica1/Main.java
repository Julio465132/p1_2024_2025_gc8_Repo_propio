package org.dis.Practica1;

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
        ControladorJSON jsonControlador = new ControladorJSON();
        ArrayList<Turismo> lista = jsonControlador.leerArchivoJSON();

        Map<String, ArrayList<Turismo>> agrupado = new HashMap<>();

        for (Turismo t : lista) {
            String comunidad = t.getDestinoViaje().getRegionDestino();
            agrupado.putIfAbsent(comunidad, new ArrayList<>());
            agrupado.get(comunidad).add(t);
        }

        jsonControlador.guardarComoJSON(agrupado, rutaJsonAgrupado);
        System.out.println("Datos agrupados correctamente.\nPulsa Enter para continuar...");
        esperarTecla();
        limpiarPantalla();
    }
    public static void consultarPorFecha() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Turismo> lista = new ControladorJSON().leerArchivoJSON();

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
    }
