package br.com.pistorio.request.converters;

import br.com.pistorio.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strnumber) {
        if (strnumber == null || strnumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strnumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strnumber) {
        if (strnumber == null || strnumber.isEmpty()) return false;
        String number = strnumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
