package com.conversioncurrencyapp.services;

import com.conversioncurrencyapp.modals.Currency;
import com.conversioncurrencyapp.modals.CurrencyCodes;
import com.conversioncurrencyapp.modals.CurrencyConversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CurrencyServices {

    private String apiKey = "d4bff35927262538005c52a1/";
    private String baseURL  =  ("https://v6.exchangerate-api.com/v6/" + apiKey);

    public CurrencyConversion pairConversion(String base_code, String target_code, double amount )  {
        try {
            BigDecimal number = new BigDecimal( String.valueOf( amount));

            URI uriApi = URI.create(baseURL + "/pair/" + base_code + "/" + target_code + "/" + number.toPlainString());

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriApi)
                    .GET()
                    .build();


                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()!=200) { return null; }

            Gson gson = new Gson();
            CurrencyConversion conversion = gson.fromJson(response.body(), CurrencyConversion.class );
            conversion.setAmount(amount);
            return conversion;

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al convertir" + e);
            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Currency pairConversionManual(String base_code )  {
        try {

            URI uriApi = URI.create(baseURL + "/latest/" + base_code);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriApi)
                    .GET()
                .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()!=200) { return null; };

            Gson gson = new Gson();

            Currency conversion = gson.fromJson(response.body(), Currency.class);
            return conversion;

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión, hable con el administrador" + e);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Currency> currencyCodes( ) {
        try {
            URI uriApi = URI.create(baseURL + "/codes");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriApi)
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()!=200) { return null; };

            Gson gson = new Gson();
            CurrencyCodes resApi = gson.fromJson(response.body(), CurrencyCodes.class);

            List<List<String>> codigosSoporte = resApi.supported_codes();

                        // Convertir la lista de listas a una lista de objetos Moneda
                        List<Currency> currencies = new ArrayList<>();
                        for (List<String> support_code : codigosSoporte) {

                            Currency currency =  new Currency(support_code.get(0), support_code.get(1));
                            currencies.add(currency);
                        }
                  return currencies;


        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión, hable con el administrador" + e);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
