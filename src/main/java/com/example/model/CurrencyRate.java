package com.example.model;

import java.util.Map;

public class CurrencyRate {
    private String base;
    private Map<String, Double> rates;

    public CurrencyRate() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "base='" + base + '\'' +
                ", rates=" + rates.toString() +
                '}';
    }
}
