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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectorCSV {
    private final Gson conversor;

    // Se prepara el objeto Gson con formato bonito para el archivo de salida
    public GestorJSON() {
        this.conversor = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
    /**
     * Carga los datos desde un archivo JSON ubicado en resources.
     * Devuelve una lista de objetos Turismo cargados desde el fichero.
     */
    public ArrayList<Turismo> cargarDesdeJSON() {
        try (InputStream entrada = getClass().getClassLoader().getResourceAsStream("TurismoComunidades.json");
             InputStreamReader lector = new InputStreamReader(entrada)) {

            Type tipoLista = new TypeToken<ArrayList<Turismo>>() {}.getType();
            return conversor.fromJson(lector, tipoLista);

        } catch (Exception error) {
            System.err.println("No se pudo leer el archivo JSON: " + error.getMessage());
            return new ArrayList<>();
        }
    }
}
