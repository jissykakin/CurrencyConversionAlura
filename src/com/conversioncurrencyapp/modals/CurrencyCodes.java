package com.conversioncurrencyapp.modals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record CurrencyCodes(
         String result,
         String documentation,
         String terms_of_use,
         List<List<String>> supported_codes
) {
}
