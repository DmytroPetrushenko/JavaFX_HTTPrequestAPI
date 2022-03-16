package com.example.viev_model.api_requests;

import com.example.model.CurrencyRate;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenExchangeRatesApi {

    public CurrencyRate sendRequest() {
        HttpURLConnection connection = null;
        String query = "https://openexchangerates.org/api/latest.json?app_id"
                + "=82f78c24108047838abad1ccb7705b10";
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            return streamReader(connection.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Can't connect to API according web-address: "
                    + query + " ! ", e);
        } finally {
            if (connection == null) {
                connection.disconnect();
            }
        }
    }

    private CurrencyRate streamReader(InputStream stream) {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream))) {
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read a data about currency rates from a buffer", e);
        }
        return new Gson().fromJson(stringBuilder.toString(), CurrencyRate.class);
    }
}
