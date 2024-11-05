package com.alura.conversor.modelos;

public class Moneda {
    private String nombre;
    private double usd;
    private double ars;
    private double brl;
    private double pen;

    public Moneda(MonedaAPI monedaAPI) {
        this.nombre = monedaAPI.base_code();
        if(monedaAPI.conversion_rates() != null) {
            this.usd = monedaAPI.conversion_rates().USD();
            this.ars = monedaAPI.conversion_rates().ARS();
            this.brl = monedaAPI.conversion_rates().BRL();
            this.pen = monedaAPI.conversion_rates().PEN();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getArs() {
        return ars;
    }

    public void setArs(double ars) {
        this.ars = ars;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public double getPen() {
        return pen;
    }

    public void setPen(double pen) {
        this.pen = pen;
    }

    @Override
    public String toString() {
        return "{Moneda: " +
                    "Nombre: " + nombre + ", " +
                    "ValorMoneda: {" +
                        "USD:" + usd +
                        ", ARS:" + ars +
                        ", BRL" + brl +
                        ", PEN:" + pen +
                    "}";
    }
}
