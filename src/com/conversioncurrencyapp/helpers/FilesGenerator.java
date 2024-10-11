package com.conversioncurrencyapp.helpers;

import com.conversioncurrencyapp.modals.HistoryConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FilesGenerator {

    private static final String FILE_PATH = "conversions.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static List<HistoryConversion> conversions = new ArrayList<>();

        public void saveConversions(HistoryConversion historyConversion) {
            loadConversions();
            conversions.add(historyConversion);
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                gson.toJson(conversions, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    private static void loadConversions() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<HistoryConversion>>() {}.getType();
            conversions = gson.fromJson(reader, listType);
            if (conversions == null) {
                conversions = new ArrayList<>();
            }
        } catch (IOException e) {
            conversions = new ArrayList<>();
        }
    }

    public void showConversions() {
        DecimalFormat formato = new DecimalFormat("#,###.00");
            loadConversions();

            if (conversions.size() == 0){
                System.out.println("El Archivo esta vacio");
            }
            for ( HistoryConversion conversion : conversions ){

                System.out.println("""
                        Tipo Conversion: \s""" + conversion.getTypeConversion() + """ 
                        \nFecha de Conversion:\s""" + conversion.getDateOfConversion()  + """                             
                        \nDivisa de origen:\s""" + conversion.getHistory().getBase_code()  + """
                        \nDivisa de destino:\s""" + conversion.getHistory().getTarget_code() + """
                        \nMonto:\s""" + formato.format(conversion.getHistory().getAmount() )+ """
                        \nTasa:\s""" + conversion.getHistory().getConversion_rate() + """
                        \nTotal:\s""" +  formato.format(conversion.getHistory().getConversion_result()) + """
                        \n""");

            }



           // final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            //final String representacionBonita = prettyGson.toJson(conversions);
            //System.out.println(representacionBonita);
    }

    public void deleleFilesHistory(){
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            conversions = new ArrayList<>();
            gson.toJson(conversions, writer);
            System.out.println("El archivo fue borrado exitosamente.");
        }  catch (IOException e) {
            System.out.println("No se pudo borrar el archivo.");
        }
    }


}
