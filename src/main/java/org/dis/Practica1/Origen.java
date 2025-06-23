package org.dis.Practica1;

import com.google.gson.annotations.SerializedName;

public class Origen {

    @SerializedName("comunidad")
    private String comunidad;

    @SerializedName("provincia")
    private String provincia;

    public Origen() {}

    public Origen(String provincia, String comunidad) {
        this.provincia = provincia;
        this.comunidad = comunidad;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Origen{" +
                "comunidad='" + comunidad + '\'' +
                ", provincia='" + provincia + '\'' +
            '}';
    }
}
