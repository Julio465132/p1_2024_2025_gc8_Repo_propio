package org.dis.Practica1;

public class Periodo {
    private String inicioPeriodo;
    private String finPeriodo;
    private String codigoPeriodo;

    // Constructor para inicializar los campos
    public Periodo(String inicioPeriodo, String finPeriodo, String codigoPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
        this.finPeriodo = finPeriodo;
        this.codigoPeriodo = codigoPeriodo;
    }

    // Getter de la fecha de inicio
    public String getInicioPeriodo() {
        return inicioPeriodo;
    }

    // Setter de la fecha de inicio
    public void setInicioPeriodo(String inicioPeriodo) {
        this.inicioPeriodo = inicioPeriodo;
    }

    // Getter de la fecha de fin
    public String getFinPeriodo() {
        return finPeriodo;
    }

    // Setter de la fecha de fin
    public void setFinPeriodo(String finPeriodo) {
        this.finPeriodo = finPeriodo;
    }

    // Getter del código del periodo
    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    // Setter del código del periodo
    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }
}
