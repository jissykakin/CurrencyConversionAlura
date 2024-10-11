import com.conversioncurrencyapp.helpers.CommansCurrency;
import com.conversioncurrencyapp.helpers.CommansScanner;
import com.conversioncurrencyapp.helpers.FilesGenerator;
import com.conversioncurrencyapp.helpers.ListsMenu;
import com.conversioncurrencyapp.modals.Currency;
import com.conversioncurrencyapp.modals.CurrencyConversion;
import com.conversioncurrencyapp.modals.HistoryConversion;
import com.conversioncurrencyapp.services.CurrencyServices;

import java.util.*;

public class Main {



    public static void main(String[] args) {


        String message = "";
        CommansScanner commansScanner = new CommansScanner();
        ListsMenu listsMenu = new ListsMenu();

        System.out.println("**************************************************");
        System.out.println("Sean Bienvenid@s al Conversor de Monedas!!!");


        int opcion;

        do {
            listsMenu.showMenu();
            opcion = commansScanner.obtenerOpcion("Opción inválida. Ingrese un número del 0 al 9.");

            if (opcion >= 1 && opcion <= 8) {
                accionOption(opcion);
            } else if (opcion == 9) {
                showAdvancedOptios();
            } else if (opcion != 0) {
                System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

        System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta luego!");

    }

    private static void accionOption(int opcion){



        String baseCurrency = "";
        String targetCurrency = "";

        switch (opcion) {
            case 1:
                baseCurrency = "USD";
                targetCurrency = "COP";
                break;
            case 2:
                baseCurrency = "COP";
                targetCurrency = "USD";
                break;
            case 3:
                baseCurrency = "EUR";
                targetCurrency = "COP";
                break;
            case 4:
                baseCurrency = "COP";
                targetCurrency = "EUR";
                break;
            case 5:
                baseCurrency = "USD";
                targetCurrency = "BRL";
                break;
            case 6:
                baseCurrency = "BRL";
                targetCurrency = "USD";
                break;
            case 7:
                baseCurrency = "EUR";
                targetCurrency = "USD";
                break;
            case 8:
                baseCurrency = "USD";
                targetCurrency = "EUR";
                break;
        }
        System.out.printf("Has seleccionado la opción - Convertir %s =>> %s\n", baseCurrency, targetCurrency);

        String message =  conversionMoney(baseCurrency, targetCurrency, true);
        System.out.println(message + "\n");

    }

    private static void showAdvancedOptios(){
        Scanner scanner = new Scanner(System.in);
        FilesGenerator files = new FilesGenerator();
        CommansScanner commansScanner = new CommansScanner();
        CommansCurrency commansCurrency = new CommansCurrency();
        ListsMenu listsMenu = new ListsMenu();

        int subOpcion ;
        do {
            listsMenu.showSubMenu();
            subOpcion =  commansScanner.obtenerOpcion( "Opción inválida. Ingrese un número del 0 al 3.");


            switch (subOpcion) {
                case 1:

                    List<Currency> currencies = commansCurrency.listCurrency();


                    String baseCode = commansScanner.scannerCodeCurrency(scanner, "Por favor, Ingrese el codigo de moneda base:", currencies );
                    String targetCode = commansScanner.scannerCodeCurrency(scanner, "Por favor, Ingrese el codigo de moneda a convertir:" , currencies);


                    if (!baseCode.isEmpty() && !targetCode.isEmpty()){
                        String message = conversionMoney(baseCode, targetCode, false);
                        System.out.println(message + "\n");
                    }else{
                        System.out.println("Códigos de moneda no pueden estar vacíos.");
                    }
                    break;

                case 2:
                    files.showConversions();
                    break;
                case 3:
                    files.deleleFilesHistory();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (subOpcion != 0);


    }


    private static String conversionMoney(String baseCode, String targetCode, Boolean isCalcule){
        CommansCurrency commansCurrency = new CommansCurrency();
        CurrencyConversion conversion = commansCurrency.getConversionCurrency(baseCode, targetCode,isCalcule);
        if (conversion == null) {
            return "Error en la conversión. Intente nuevamente.";
        }
        commansCurrency.saveHistoryConversion(conversion);
        return commansCurrency.getMesssageConversion(conversion);
    }








}
