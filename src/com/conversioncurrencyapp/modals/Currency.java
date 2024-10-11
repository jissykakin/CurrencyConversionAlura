package com.conversioncurrencyapp.modals;

import com.conversioncurrencyapp.services.CurrencyServices;

import java.text.DecimalFormat;
import java.util.Map;

public class Currency {
    private String base_code;
    private String name;
    Map<String, Double> conversion_rates;

    public Currency(String code, String name) {
        this.base_code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "code=" + base_code + ", name=" + name ;
    }

    public String getCode() {
        return base_code;
    }

    public String getName() {
        return name;
    }

    public double conversionCurrency( String targetCurrency, double amount  ){

        return this.getRate(targetCurrency) * amount;
    }

    public double getRate(String targetCurrency ){
        return this.conversion_rates.get(targetCurrency);
    }


    @Override
    public boolean equals(Object other){
        boolean eq = false;
        Currency currency = null;
        if(other instanceof Currency){
            currency = (Currency) other;
            eq = this.base_code == currency.base_code;
        }
        return eq;
    }



  }
