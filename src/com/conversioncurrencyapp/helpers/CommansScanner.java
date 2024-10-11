package com.conversioncurrencyapp.helpers;

import com.conversioncurrencyapp.modals.Currency;

import java.util.List;
import java.util.Scanner;

public class CommansScanner {


    public static String scannerCodeCurrency(Scanner scanner, String message, List<Currency> currencies) {
        String inputCodeCurrency;
        boolean isValid = false;

        do {
            System.out.println(message);
            inputCodeCurrency = scanner.next().toUpperCase();

            for (Currency currency : currencies) {
                if (currency.getCode().equals(inputCodeCurrency)) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Código de moneda no válido. Intente nuevamente.");
            }
        } while (!isValid);

        return inputCodeCurrency;
    }

    public static int obtenerOpcion(String message) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println(message);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double solicitarCantidad(Scanner scanner, String message) {

        while (!scanner.hasNextDouble()){
            System.out.println("Por favor, ingrese un valor númerico válido: ");
            scanner.next();
        };
        return scanner.nextDouble();
    }

}
