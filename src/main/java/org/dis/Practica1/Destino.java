
package org.dis.Practica1;

import com.google.gson.annotations.SerializedName;

public class Destino {

    @SerializedName("comunidad")
    private String comunidad;

    @SerializedName("provincia")
    private String provincia;

    public Destino() {}

    public Destino(String comunidad, String provincia) {
        this.comunidad = comunidad;
        this.provincia = provincia;
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
        return "Destino{" +
                "comunidad='" + comunidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}