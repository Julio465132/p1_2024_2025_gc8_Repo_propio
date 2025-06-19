package org.dis.Practica1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String rutaCsv = "src/main/resources/TurismoComunidades.csv";
    public static String rutaJson = "src/main/resources/TurismoComunidades.json";
    public static String rutaJsonAgrupado = "src/main/resources/Comunidades_agrupadas.json";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean csvCargando = false;
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
}
