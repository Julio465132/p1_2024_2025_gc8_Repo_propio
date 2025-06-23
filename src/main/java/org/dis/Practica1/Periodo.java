package org.dis.Practica1;

import com.google.gson.annotations.SerializedName;

public class Periodo {

    @SerializedName("fecha_inicio")
    private String fechaInicio;

    @SerializedName("fecha_fin")
    private String fechaFin;

    @SerializedName("periodo")
    private String codigoPeriodo;

    public Periodo() {}

    public Periodo(String fechaInicio, String fechaFin, String codigoPeriodo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", codigoPeriodo='" + codigoPeriodo + '\'' +
            '}';
}
}
