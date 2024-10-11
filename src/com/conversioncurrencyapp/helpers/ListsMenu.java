package com.conversioncurrencyapp.helpers;

public class ListsMenu {


    public static void showMenu(){
        System.out.println("**************************************************\n");
        System.out.println("Menú Principal:");
        System.out.println("1.  Dólar           =>> Peso Colombiano");
        System.out.println("2.  Peso Colombiano =>> Dólar");
        System.out.println("3.  Euro            =>> Peso Colombiano");
        System.out.println("4.  Peso Colombiano =>> Euro");
        System.out.println("5.  Dólar           =>> Peso Brasileño");
        System.out.println("6.  Peso Brasileño  =>> Dólar");
        System.out.println("7.  Euro            =>> Dolar");
        System.out.println("8.  Dólar           =>> Euro");
        System.out.println("9.  Opciones Avanzadas");
        System.out.println("0.  Salir");

        System.out.println("Ingrese una opción:\n");

        System.out.println("**************************************************");
    }

    public static void showSubMenu(){
        System.out.println("**************************************************\n");

        System.out.println("Menú Opciones Avanzadas:");
        System.out.println("1. Conversión personalizada");
        System.out.println("2. Ver histórico de conversiones realizadas");
        System.out.println("3. Borrar histórico");
        System.out.println("0. Regresar a menú principal");

        System.out.println("Ingrese una opción:\n");

        System.out.println("**************************************************");
    }


}
