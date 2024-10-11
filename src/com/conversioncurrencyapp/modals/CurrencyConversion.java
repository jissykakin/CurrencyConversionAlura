package com.conversioncurrencyapp.modals;

import java.text.DecimalFormat;

public class CurrencyConversion {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;
    private double amount;


    public CurrencyConversion(String base_code, String target_code, double conversion_rate, double conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    public CurrencyConversion(String base_code, String target_code, double conversion_rate, double conversion_result, double amount) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
        this.amount = amount;
    }

    public String getTarget_code() {
        return target_code;
    }

    public String getBase_code() {
        return base_code;
    }



    public double getConversion_result() {
        return conversion_result;
    }

    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getConversion_rate() {
        DecimalFormat formato = new DecimalFormat("#,##0.00000");
        return  formato.format(conversion_rate);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
                ", amount=" + amount +
                '}';
    }


}


