package org.dis.Practica1;

public class Origen {
    private String provinciaSalida;
    private String comunidadSalida;
    // Constructor para inicializar los datos del origen
    public Origen(String provinciaSalida, String comunidadSalida) {
        this.provinciaSalida = provinciaSalida;
        this.comunidadSalida = comunidadSalida;
    }

    // Getter de provincia
    public String getProvinciaSalida() {
        return provinciaSalida;
    }

    // Setter de provincia
    public void setProvinciaSalida(String provinciaSalida) {
        this.provinciaSalida = provinciaSalida;
    }

    // Getter de comunidad
    public String getComunidadSalida() {
        return comunidadSalida;
    }

    // Setter de comunidad
    public void setComunidadSalida(String comunidadSalida) {
        this.comunidadSalida = comunidadSalida;
    }
}
