package com.conversioncurrencyapp.modals;


import java.util.Date;

public class HistoryConversion {
    public String getTypeConversion() {
        return typeConversion;
    }

    public Date getDateOfConversion() {
        return dateOfConversion;
    }

    public CurrencyConversion getHistory() {
        return history;
    }

    private String typeConversion;
    private Date  dateOfConversion = new Date();
    private CurrencyConversion history;

    @Override
    public String toString() {
        return "HistoryConversion{" +
                "typeConversion='" + typeConversion + '\'' +
                ", dateOfConversion=" + dateOfConversion +
                ", history=" + history +
                '}';
    }

    public HistoryConversion(String typeConversion, CurrencyConversion history) {
        this.typeConversion = typeConversion;
        this.history = history;
    }

}
