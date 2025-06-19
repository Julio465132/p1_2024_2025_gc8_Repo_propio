package org.dis.Practica1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class ControladorJSON {
    // Método para leer el archivo JSON y convertirlo en una lista de objetos Turismo
    public ArrayList<Turismo> leerArchivoJSON() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(
                    getClass().getClassLoader().getResourceAsStream("TurismoComunidades.json")));

            ArrayList<Turismo> datosTurismo = new Gson().fromJson(
                    buffer, new TypeToken<ArrayList<Turismo>>() {}.getType());

            buffer.close();
            return datosTurismo;

        } catch (IOException e) {
            System.out.println("Error al leer JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    // Método para escribir un mapa con los datos agrupados a un JSON nuevo
    public void guardarComoJSON(Map<String, ArrayList<Turismo>> agrupado, String rutaDestino) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // hace que el JSON tenga saltos de línea y sangría

        try (FileWriter escritor = new FileWriter(rutaDestino)) {
            mapper.writeValue(escritor, agrupado);
            System.out.println("Archivo JSON escrito correctamente en: " + rutaDestino);
        } catch (IOException e) {
            System.out.println("Error al escribir JSON: " + e.getMessage());
        }
    }
}
