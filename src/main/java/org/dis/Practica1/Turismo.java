package org.dis.Practica1;

import com.google.gson.annotations.SerializedName;

public class Turismo {

    @SerializedName("origen")
    private Origen origenViaje;

    @SerializedName("destino")
    private Destino destinoViaje;

    @SerializedName("periodo")
    private Periodo periodoDatos;

    @SerializedName("total")
    private int numeroTuristas;

    public Turismo() {
        // Constructor vacío necesario para Gson
    }

    public Turismo(Origen origenViaje, Destino destinoViaje, Periodo periodoDatos, int numeroTuristas) {
        this.origenViaje = origenViaje;
        this.destinoViaje = destinoViaje;
        this.periodoDatos = periodoDatos;
        this.numeroTuristas = numeroTuristas;
    }

    public Origen getOrigenViaje() {
        return origenViaje;
    }

    public void setOrigenViaje(Origen origenViaje) {
        this.origenViaje = origenViaje;
    }

    public Destino getDestinoViaje() {
        return destinoViaje;
    }

    public void setDestinoViaje(Destino destinoViaje) {
        this.destinoViaje = destinoViaje;
    }

    public Periodo getPeriodoDatos() {
        return periodoDatos;
    }

    public void setPeriodoDatos(Periodo periodoDatos) {
        this.periodoDatos = periodoDatos;
    }

    public int getNumeroTuristas() {
        return numeroTuristas;
    }

    public void setNumeroTuristas(int numeroTuristas) {
        this.numeroTuristas = numeroTuristas;
    }

    @Override
    public String toString() {
        return "Turismo{" +
                "origenViaje=" + origenViaje +
                ", destinoViaje=" + destinoViaje +
                ", periodoDatos=" + periodoDatos +
                ", numeroTuristas=" + numeroTuristas +
        '}';
    }
}
