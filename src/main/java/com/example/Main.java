package com.example;

import com.example.model.CurrencyRate;
import com.example.viev_model.api_requests.OpenExchangeRatesApi;
import com.example.view.ViewTestOne;
import javafx.application.Application;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //OpenExchangeRatesApi openExchangeRatesApi = new OpenExchangeRatesApi();
        //CurrencyRate currencyRate = openExchangeRatesApi.sendRequest();
        //Map<String, Double> rates = currencyRate.getRates();
        ViewTestOne viewTestOne = new ViewTestOne();
        Application.launch(viewTestOne.getClass());
    }
}
