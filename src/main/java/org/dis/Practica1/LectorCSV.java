package org.dis.Practica1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorCSV {
    public void convertircsvaJSON(String nombreArchivoCSV,String archivoJSON){
        try{
            // Creamos el lector CSV y especificamos el separador que usa el archivo
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(nombreArchivoCSV))
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                    .build();

            // Lista para almacenar los datos que luego se convertirán a JSON
            List<Map<String, Object>> datosCSV = new ArrayList<>();

            // Ignorar la primera línea (cabecera del CSV)
            csvReader.readNext();
            String[] fila;
            while ((fila = csvReader.readNext()) != null) {
                // Validamos que la fila tenga el número de columnas esperado
                if (fila.length != 8) {
                    System.out.println("Fila inválida: " + Arrays.toString(fila));
                    continue;
                }

                try {
                    Map<String, Object> objeto = new HashMap<>();

                    // Generamos un ID único para cada entrada
                    objeto.put("_id", UUID.randomUUID().toString());

                    // Creamos el objeto origen
                    Map<String, String> origen = new HashMap<>();
                    origen.put("comunidad", fila[2]);
                    origen.put("provincia", fila[1]);
                    objeto.put("origen", origen);

                    // Creamos el objeto destino
                    Map<String, String> destino = new HashMap<>();
                    destino.put("comunidad", fila[3]);
                    destino.put("provincia", fila[4]);
                    objeto.put("destino", destino);

                    // Parseamos el campo de periodo (formato: AAAAMMM)
                    String periodoOriginal = fila[6];
                    int año = Integer.parseInt(periodoOriginal.substring(0, 4));
                    int mes = Integer.parseInt(periodoOriginal.substring(5, 7));
                    YearMonth yearMonth = YearMonth.of(año, mes);

                    // Calculamos la fecha de inicio y fin del mes
                    LocalDate fechaInicio = yearMonth.atDay(1);
                    LocalDate fechaFin = yearMonth.atEndOfMonth();

                    Map<String, Object> periodo = new HashMap<>();
                    periodo.put("fecha_inicio", fechaInicio.toString());
                    periodo.put("fecha_fin", fechaFin.toString());
                    periodo.put("periodo", periodoOriginal);
                    objeto.put("periodo", periodo);

                    // Procesamos el campo "total", eliminando posibles comas en el número
                    String totalString = fila[7].replace(",", "");
                    try {
                        long total = Long.parseLong(totalString);
                        objeto.put("total", total);
                    } catch (NumberFormatException e) {
                        // Si no es un número válido, asignamos 0
                        objeto.put("total", 0);
                    }

                    // Añadimos el objeto a la lista de resultados
                    datosCSV.add(objeto);

                } catch (Exception e) {
                    // Mostrar errores individuales por fila sin interrumpir el proceso completo
                    System.err.println("Error procesando fila: " + Arrays.toString(fila));
                    e.printStackTrace();
                }
            }
        }
    }
}
