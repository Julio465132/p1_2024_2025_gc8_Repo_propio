package org.dis.Practica1;

import com.google.gson.annotations.SerializedName;

public class Origen {
    @SerializedName("comunidad")
    private String comunidadSalida;

    @SerializedName("provincia")
    private String provinciaSalida;

    public Origen() {}

    public Origen(String provinciaSalida, String comunidadSalida) {
        this.provinciaSalida = provinciaSalida;
        this.comunidadSalida = comunidadSalida;
    }

    public String getProvinciaSalida() {
        return provinciaSalida;
    }

    public void setProvinciaSalida(String provinciaSalida) {
        this.provinciaSalida = provinciaSalida;
    }

    public String getComunidadSalida() {
        return comunidadSalida;
    }

    public void setComunidadSalida(String comunidadSalida) {
        this.comunidadSalida = comunidadSalida;
    }

    @Override
    public String toString() {
        return "Origen{" +
                "provinciaSalida='" + provinciaSalida + '\'' +
                ", comunidadSalida='" + comunidadSalida + '\'' +
            '}';
    }
}
