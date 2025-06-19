package org.dis.Practica1;

public class Destino {
    private String regionDestino;
    private String zonaDestino;

    // Constructor con los datos necesarios
    public Destino(String regionDestino, String zonaDestino) {
        this.regionDestino = regionDestino;
        this.zonaDestino = zonaDestino;
    }
    // Devuelve la comunidad del destino
    public String getRegionDestino() {
        return regionDestino;
    }

    // Devuelve la provincia del destino
    public String getZonaDestino() {
        return zonaDestino;
    }

    // Cambia el valor de la comunidad
    public void setRegionDestino(String regionDestino) {
        this.regionDestino = regionDestino;
    }

    // Cambia el valor de la provincia
    public void setZonaDestino(String zonaDestino) {
        this.zonaDestino = zonaDestino;
    }
    @Override
    public String toString() {
        return "Destino{" +
                "regionDestino='" + regionDestino + '\'' +
                ", zonaDestino='" + zonaDestino + '\'' +
          '}';
    }
}
