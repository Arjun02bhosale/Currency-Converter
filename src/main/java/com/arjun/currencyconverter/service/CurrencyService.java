package com.arjun.currencyconverter.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CurrencyService {

    private final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double convert(String base, String target, double amount) {
        try {
            String url = API_URL + base.toUpperCase();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());
            double rate = json.getJSONObject("rates").getDouble(target.toUpperCase());
            return amount * rate;
        } catch (Exception e) {
            throw new RuntimeException("Currency conversion failed", e);
        }
    }
}
