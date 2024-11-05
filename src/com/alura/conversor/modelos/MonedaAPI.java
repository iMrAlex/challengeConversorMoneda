package com.alura.conversor.modelos;

public record MonedaAPI(String base_code, ConversionRates conversion_rates) {
    //Anidamos los record para hacer obtener datos de json anidados
    public record ConversionRates(double USD, double ARS, double BRL, double PEN) {}
}