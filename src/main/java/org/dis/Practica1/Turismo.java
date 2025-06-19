package org.dis.Practica1;

public class Turismo {
    private Origen origenViaje;
    private Destino destinoViaje;
    private Periodo periodoDatos;
    private int numeroTuristas;
    // Constructor principal
    public Turismo(Origen origenViaje, Destino destinoViaje, Periodo periodoDatos, int numeroTuristas) {
        this.origenViaje = origenViaje;
        this.destinoViaje = destinoViaje;
        this.periodoDatos = periodoDatos;
        this.numeroTuristas = numeroTuristas;
    }

    // Getters y setters
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

}
