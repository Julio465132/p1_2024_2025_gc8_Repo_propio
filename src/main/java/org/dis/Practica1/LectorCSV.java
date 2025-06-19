package org.dis.Practica1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class LectorCSV {


        // Método que transforma un archivo CSV en un archivo JSON estructurado
        public void convertirCSVaJSON(String rutaCSV, String rutaJSON) {
            try {
                // Abrimos el lector CSV y configuramos el delimitador ';'
                CSVReader lector = new CSVReaderBuilder(new FileReader(rutaCSV))
                        .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                        .build();

                // Lista donde iremos guardando los datos procesados
                List<Map<String, Object>> datos = new ArrayList<>();

                // Saltamos la primera fila (cabecera)
                lector.readNext();

                String[] fila;
                while ((fila = lector.readNext()) != null) {
                    if (fila.length != 8) {
                        System.out.println("Fila mal formada: " + Arrays.toString(fila));
                        continue;
                    }

                    try {
                        Map<String, Object> registro = new HashMap<>();

                        // Asignamos un ID único
                        registro.put("_id", UUID.randomUUID().toString());

                        // Origen como subobjeto
                        Map<String, String> origen = new HashMap<>();
                        origen.put("comunidad", fila[2]);
                        origen.put("provincia", fila[1]);
                        registro.put("origen", origen);

                        // Destino como subobjeto
                        Map<String, String> destino = new HashMap<>();
                        destino.put("comunidad", fila[3]);
                        destino.put("provincia", fila[4]);
                        registro.put("destino", destino);

                        // Formateamos el periodo (inicio y fin del mes)
                        String periodo = fila[6]; // ej. 2020M05
                        int anio = Integer.parseInt(periodo.substring(0, 4));
                        int mes = Integer.parseInt(periodo.substring(5, 7));
                        YearMonth ym = YearMonth.of(anio, mes);
                        LocalDate inicio = ym.atDay(1);
                        LocalDate fin = ym.atEndOfMonth();

                        Map<String, Object> datosPeriodo = new HashMap<>();
                        datosPeriodo.put("fecha_inicio", inicio.toString());
                        datosPeriodo.put("fecha_fin", fin.toString());
                        datosPeriodo.put("periodo", periodo);
                        registro.put("periodo", datosPeriodo);

                        // Total (turistas), limpiando comas por si acaso
                        String totalTexto = fila[7].replace(",", "");
                        try {
                            registro.put("total", Long.parseLong(totalTexto));
                        } catch (NumberFormatException e) {
                            registro.put("total", 0);
                        }

                        datos.add(registro);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Guardamos la lista en JSON usando Jackson
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);

                try (FileWriter writer = new FileWriter(rutaJSON)) {
                    mapper.writeValue(writer, datos);
                    System.out.println("Archivo JSON generado correctamente en: " + rutaJSON);
                }

            } catch (Exception e) {
                System.out.println("Error al procesar el CSV: " + e.getMessage());
            }
        }
    }
