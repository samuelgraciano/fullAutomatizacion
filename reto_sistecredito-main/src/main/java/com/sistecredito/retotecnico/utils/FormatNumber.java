package com.sistecredito.retotecnico.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatNumber {

    private FormatNumber() {
    }

    public static String separator(String number) {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        int num = Integer.parseInt(number);
        return format.format(num).replace(",", ".");
    }
}
