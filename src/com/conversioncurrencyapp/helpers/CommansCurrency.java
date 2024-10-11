package com.conversioncurrencyapp.helpers;

import com.conversioncurrencyapp.modals.Currency;
import com.conversioncurrencyapp.modals.CurrencyConversion;
import com.conversioncurrencyapp.modals.HistoryConversion;
import com.conversioncurrencyapp.services.CurrencyServices;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommansCurrency {


    private final CurrencyServices services = new CurrencyServices();

    public CurrencyConversion getConversionCurrency(String baseCode, String targetCode, boolean isCalcule) {
        Scanner scanner = new Scanner(System.in);
        CommansScanner commansScanner = new CommansScanner();
        System.out.println("Por favor, ingrese el valor en " + baseCode + " a convertir:");

        double amount = commansScanner.solicitarCantidad(scanner, baseCode);

        CurrencyConversion conversion;
        if (isCalcule){
            conversion = conversionCurrencyCalc(baseCode, targetCode, amount);
        }
        else {
            conversion = conversionCurrencyDirect(baseCode, targetCode, amount);
        }

        return  conversion;

    }

    public CurrencyConversion conversionCurrencyDirect(String baseCode, String targetCode , double amount) {
        return  services.pairConversion(baseCode, targetCode, amount);
    }
    public CurrencyConversion conversionCurrencyCalc(String baseCode, String targetCode , double amount) {
        Currency baseCurrency = services.pairConversionManual(baseCode);
        double resultConversion =  baseCurrency.conversionCurrency(targetCode, amount);

        CurrencyConversion conversion = new CurrencyConversion(baseCode,targetCode, baseCurrency.getRate(targetCode), resultConversion, amount  );
        return conversion;
    }








    public String getMesssageConversion(CurrencyConversion conversion){
        DecimalFormat formato = new DecimalFormat("#,###.00");

        return "\nLa conversión del valor " + formato.format(conversion.getAmount())
                + "[" + conversion.getBase_code() + "] equivale a " + formato.format(conversion.getConversion_result())
                + "[" + conversion.getTarget_code() + "] " +
                "\nTasa de cambio " +  conversion.getConversion_rate() + "[" + conversion.getBase_code() + "]";
    }


    public void saveHistoryConversion(CurrencyConversion conversion) {
        String typeConversion = conversion.getBase_code() + "To" + conversion.getTarget_code();
        HistoryConversion history = new HistoryConversion(typeConversion, conversion);


        // TODO: GUARDAR HISTORICO EN ARCHIVO JSON
        FilesGenerator generador = new FilesGenerator();
        generador.saveConversions(history);
    }

    public static List<Currency>  listCurrency(){

        CurrencyServices services = new CurrencyServices();

        List<Currency> currencies = services.currencyCodes();
        System.out.println("Listado de Códigos de Monedas permitidos para conversión");

        for (Currency currency : currencies) {
            System.out.println(currency.toString());
            //System.out.println("Código: " + currency.getCode() + ", Nombre: " + currency.getName());
        }

        return currencies;

    }



}
